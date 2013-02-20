package org.soluvas.web.login;

import java.util.Set;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.NameUtils.PersonName;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.inject.Supplied;
import org.soluvas.json.JsonUtils;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.NotLoggedWithTwitterException;
import org.soluvas.web.site.SoluvasWebSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;


/**
 * @author haidar
 *
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="twitter_recipient/")
public class TwitterRecipient extends WebPage {
	
	private static final Logger log = LoggerFactory
			.getLogger(TwitterRecipient.class);
	
	@PaxWicketBean(name="twitterMgr")
	private TwitterManager twitterManager;
	@Inject @Supplied
	private WebAddress webAddress;
	@PaxWicketBean(name="personRawRepo")	
	private LdapRepository<SocialPerson> personRawRepo;
	
	public TwitterRecipient(PageParameters params) {
		super();
		final String verifier = params.get("oauth_verifier").toOptionalString();
//		Preconditions.checkArgument(!Strings.isNullOrEmpty(verifier), "oauth_verifier Parameter must be provided");
		if (Strings.isNullOrEmpty(verifier)) {
			throw new NotLoggedWithTwitterException();
		}
        final SoluvasWebSession session = (SoluvasWebSession) getSession();
        final RequestToken requestToken = new RequestToken(session.getTwitterRequestToken(), session.getTwitterRequestTokenSecret());

        final AccessToken oAuthAccessToken;
        try {
        	final Twitter twitter = twitterManager.createTwitter();
			oAuthAccessToken = twitter.getOAuthAccessToken(requestToken, verifier);
            session.setTwitterRequestToken(null);
            session.setTwitterRequestTokenSecret(null);
        } catch (final TwitterException e) {
            info("Error when processing Twitter verifier " + e.getMessage());
			log.error("Error when processing Twitter verifier", e);
			throw new NotLoggedWithTwitterException("Error when processing Twitter verifier", e);
        }
        //response.sendRedirect(request.getContextPath() + "/");
	        
		log.debug("Code parameter url is {}", verifier);
		add(new Label("code" ,verifier));
		try {
			final String accessToken = oAuthAccessToken.getToken(); 
			log.debug("fetching access token {}", accessToken);
			final Twitter twitter = twitterManager.createTwitter(oAuthAccessToken.getToken(), oAuthAccessToken.getTokenSecret());
			final User user = twitter.showUser(oAuthAccessToken.getUserId());
			Preconditions.checkNotNull("User should not be null", user);
			log.debug("Got user {}", JsonUtils.asJson(user));
			
			SocialPerson person = personRawRepo.findOneByAttribute("twitterId", String.valueOf(user.getId()));
			if (person == null) {
				person = personRawRepo.findOneByAttribute("twitterScreenName", user.getScreenName());
			}
			
			SocialPerson modifiedPerson = null;
			
			if (person != null) {
				// Direct Login
				log.debug("person is exist, update the Access Token");
				final Set<String> emails = Sets.newHashSet();
				if (person.getEmails() != null) {
					emails.addAll(person.getEmails());
				}
				
				person.setTwitterScreenName(user.getScreenName());
				person.setTwitterId(Long.valueOf(user.getId()));
				person.setTwitterAccessToken(oAuthAccessToken.getToken());
				person.setTwitterAccessTokenSecret(oAuthAccessToken.getTokenSecret());
				modifiedPerson = personRawRepo.modify(person);
			} else {
				Preconditions.checkNotNull(user.getName(), "Twitter User's Name cannot be empty");
				final String personId = SlugUtils.generateValidId(user.getName(), new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personRawRepo.exists(input);
					}
				});
				
				final String personSlug = SlugUtils.generateValidScreenName(user.getName(), new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personRawRepo.existsByAttribute("uniqueIdentifier", input);
					}
				});
				final PersonName personName = NameUtils.splitName(user.getName());
				final SocialPerson newPerson = new SocialPerson(personId, personSlug, personName.getFirstName(), personName.getLastName());
				//log.debug("User's email is {}", user.getEmail());
				newPerson.setTwitterId(Long.valueOf(user.getId()));
				newPerson.setTwitterAccessToken(oAuthAccessToken.getToken());
				newPerson.setTwitterAccessTokenSecret(oAuthAccessToken.getTokenSecret());
				
				modifiedPerson = personRawRepo.add(newPerson);
				log.debug("person {} is inserted", personId);
			}
			// Set Token And Set Session
			final AuthenticationToken token = new AutologinToken(
					Strings.nullToEmpty(modifiedPerson.getId()));
			log.debug("Logging in using AutologinToken {}", token.getPrincipal() );
			try {
				final Subject currentUser = SecurityUtils.getSubject();
				currentUser.login(token);
				final String personId = Preconditions.checkNotNull(modifiedPerson.getId(),
						"Cannot get current user as person ID");
				info(String.format("Your are now logged in as %s", personId));
				log.debug("Current user is now {}", personId);
				log.debug("{} permitted to edit person? {}", personId, currentUser.isPermitted("person:edit:*"));
//							onLoginSuccess(personId);
			} catch (final AuthenticationException e) {
				error(String.format("Invalid credentials for %s", token.getPrincipal()));
				log.debug(String.format("Invalid credentials for %s", token.getPrincipal()), e);
			}
						
			// Redirect Url
			final SoluvasWebSession solWebSession = (SoluvasWebSession) getSession();
			if (solWebSession.getOriginalUrl() != null) {
				final String destUri = webAddress.getBaseUri() + solWebSession.getOriginalUrl().toString();
				log.debug("Session has originalUrl, redirecting to {}", destUri);
				solWebSession.setOriginalUrl(null);
				throw new RedirectToUrlException(destUri);
			} else {
				final Class<? extends Page> homePage = Application.get().getHomePage();
				log.debug("Session has no, redirecting to {}", homePage.getName()); 
				throw new RestartResponseException(homePage);
			}
		} catch (TwitterException e) {
			throw new NotLoggedWithTwitterException("Error when processing Twitter verifier", e);
//			info("Error when processing Twitter verifier" + e.getMessage());
//			log.error("Error when processing Twitter verifier", e);
//			throw new RestartResponseException(DedicatedLoginPage.class);
		}
	}
}
