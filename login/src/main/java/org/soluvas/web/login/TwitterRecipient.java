package org.soluvas.web.login;

import javax.annotation.Nullable;

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
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.NameUtils.PersonName;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.WebAddress;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.json.JsonUtils;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.NotLoggedWithTwitterException;
import org.soluvas.twitter.TwitterManager;
import org.soluvas.twitter.TwitterUtils;
import org.soluvas.web.site.SoluvasWebSession;
import org.soluvas.web.site.WicketMountPoint;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;


/**
 * @author haidar
 *
 */
@SuppressWarnings("serial")
@WicketMountPoint(mountPoint="twitter_recipient/")
public class TwitterRecipient extends WebPage {
	
	private static final Logger log = LoggerFactory
			.getLogger(TwitterRecipient.class);
	
	@SpringBean(name="twitterMgr")
	private TwitterManager twitterManager;
	@SpringBean
	private WebAddress webAddress;
	@SpringBean(name="personLdapRepo")
	private LdapRepository<SocialPerson> personLdapRepo;
	@SpringBean(name="personImageRepo")
	private ImageRepository personImageRepo;
	
	public TwitterRecipient(final PageParameters params) {
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
		add(new Label("code", verifier));
		try {
			final String accessToken = oAuthAccessToken.getToken(); 
			log.debug("fetching access token {}", accessToken);
			final Twitter twitter = twitterManager.createTwitter(oAuthAccessToken.getToken(), oAuthAccessToken.getTokenSecret());
			final User twitterUser = twitter.showUser(oAuthAccessToken.getUserId());
			Preconditions.checkNotNull("User should not be null", twitterUser);
			log.debug("Got user {}", JsonUtils.asJson(twitterUser));
			
			SocialPerson existingPerson = personLdapRepo.findOneByAttribute("twitterId", String.valueOf(twitterUser.getId()));
			if (existingPerson == null) {
				existingPerson = personLdapRepo.findOneByAttribute("twitterScreenName", twitterUser.getScreenName());
			}
			
			if (existingPerson != null) {
				// Direct Login
				log.debug("Person {} from Twitter ID {} (#{}) exists",
						existingPerson.getId(), twitterUser.getScreenName(), twitterUser.getId());
			} else {
				final String personFullName = Preconditions.checkNotNull(twitterUser.getName(), "Twitter User's Name cannot be empty");
				final String personId = SlugUtils.generateValidId(personFullName, new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personLdapRepo.exists(input);
					}
				});
				
				final String personSlug = SlugUtils.generateValidScreenName(personFullName, new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personLdapRepo.existsByAttribute("uniqueIdentifier", input);
					}
				});
				final PersonName personName = NameUtils.splitName(personFullName);
				final SocialPerson newPerson = new SocialPerson(personId, personSlug, personName.getFirstName(), personName.getLastName());
				existingPerson.setCreationTime(new DateTime());
				existingPerson.setModificationTime(new DateTime());
				existingPerson = personLdapRepo.add(newPerson);
				log.debug("person {} is inserted", personId);
			}
			
			if (existingPerson.getValidationTime() == null) {
				existingPerson.setValidationTime(new DateTime());
			}
			if (existingPerson.getAccountStatus() == null ||
					existingPerson.getAccountStatus() == AccountStatus.DRAFT ||
					existingPerson.getAccountStatus() == AccountStatus.ACTIVE) {
				existingPerson.setAccountStatus(AccountStatus.VALIDATED);
			}
			existingPerson.setTwitterScreenName(twitterUser.getScreenName());
			existingPerson.setTwitterId(Long.valueOf(twitterUser.getId()));
			existingPerson.setTwitterAccessToken(oAuthAccessToken.getToken());
			existingPerson.setTwitterAccessTokenSecret(oAuthAccessToken.getTokenSecret());
			existingPerson.setTwitterScreenName(twitterUser.getScreenName());
			if (existingPerson.getPhotoId() == null) {
				//Set photo from Twitter.
				try {
					final String imageId = TwitterUtils.refreshPhotoFromTwitter(
							existingPerson.getTwitterScreenName(), existingPerson.getName(), personImageRepo);
					existingPerson.setPhotoId(imageId);
				} catch (Exception e) {
					log.error("Cannot refresh photo from Twitter for person " + existingPerson.getId() + " " + existingPerson.getName(), e);
				}
			}
			final SocialPerson modifiedPerson = personLdapRepo.modify(existingPerson);
			
			// Set Token And Set Session
			final AuthenticationToken token = new AutologinToken(
					Strings.nullToEmpty(modifiedPerson.getId()));
			log.debug("Logging in using AutologinToken {}", token.getPrincipal() );
			try {
				final Subject currentUser = SecurityUtils.getSubject();
				currentUser.login(token);
				final String personId = Preconditions.checkNotNull(modifiedPerson.getId(),
						"Cannot get current user as person ID");
				info(String.format("You are now logged in as %s", personId));
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
