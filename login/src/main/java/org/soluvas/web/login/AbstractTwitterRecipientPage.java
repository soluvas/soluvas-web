package org.soluvas.web.login;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.*;
import org.soluvas.commons.NameUtils.PersonName;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.json.JsonUtils;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.NotLoggedWithTwitterException;
import org.soluvas.twitter.TwitterManager;
import org.soluvas.twitter.TwitterUtils;
import org.soluvas.web.site.Interaction;
import org.soluvas.web.site.SoluvasWebSession;
import org.wicketstuff.annotation.mount.MountPath;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import org.soluvas.commons.entity.Person2;
import javax.annotation.Nullable;


/**
 * @author haidar
 *
 */
@SuppressWarnings("serial")
public class AbstractTwitterRecipientPage extends WebPage {

	protected final Logger log = LoggerFactory
			.getLogger(getClass());

	@SpringBean(name="twitterMgr")
	private TwitterManager twitterManager;
	@SpringBean
	private WebAddress webAddress;
	@SpringBean
	private PersonRepository personRepo;
	@SpringBean(name="personImageRepo")
	private ImageRepository personImageRepo;
	@SpringBean
	private TenantRef tenant;

	public AbstractTwitterRecipientPage(final PageParameters params) {
		super(params);
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
			
			Person2 curPerson = personRepo.findOneByTwitter(Long.valueOf(twitterUser.getId()), null);
			if (curPerson == null) {
				curPerson = personRepo.findOneByTwitter(null, twitterUser.getScreenName());
			}
			
			if (curPerson != null) {
				// Direct Login
				log.debug("Person {} from Twitter ID {} (#{}) exists",
						curPerson.getId(), twitterUser.getScreenName(), twitterUser.getId());
			} else {
				final String personFullName = Preconditions.checkNotNull(twitterUser.getName(), "Twitter User's Name cannot be empty");
				final String personId = SlugUtils.generateValidId(personFullName, new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personRepo.exists(input);
					}
				});
				
				final String personSlug = SlugUtils.generateValidScreenName(personFullName, new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personRepo.existsBySlug(StatusMask.RAW, input).isPresent();
					}
				});
				final PersonName personName = NameUtils.splitName(personFullName);
				curPerson = new Person2().createPerson(personId, personSlug, personName.getFirstName(), personName.getLastName(), null, Gender.UNKNOWN);//CommonsFactory.eINSTANCE.createPerson(personId, personSlug, personName.getFirstName(), personName.getLastName(), null, Gender.UNKNOWN);
				curPerson.setCreationTime(new DateTime());
				curPerson.setModificationTime(new DateTime());
				personRepo.add(curPerson);
				log.debug("person {} is inserted", personId);
			}
			
			if (curPerson.getValidationTime() == null) {
				curPerson.setValidationTime(new DateTime());
			}
			curPerson.setAccountStatus(AccountStatus.ACTIVE);
			curPerson.setTwitterScreenName(twitterUser.getScreenName());
			curPerson.setTwitterId(Long.valueOf(twitterUser.getId()));
			curPerson.setTwitterAccessToken(oAuthAccessToken.getToken());
			curPerson.setTwitterAccessTokenSecret(oAuthAccessToken.getTokenSecret());
			curPerson.setTwitterScreenName(twitterUser.getScreenName());
			if (curPerson.getPhotoId() == null) {
				//Set photo from Twitter.
				try {
					final String imageId = TwitterUtils.refreshPhotoFromTwitter(
							curPerson, twitterManager.getConsumerKey(), twitterManager.getConsumerSecret(), personImageRepo);
					curPerson.setPhotoId(imageId);
				} catch (Exception e) {
					log.error("Cannot refresh photo from Twitter for person " + curPerson.getId() + " " + curPerson.getName(), e);
				}
			}
			final Person2 modifiedPerson = personRepo.modify(curPerson.getId(), curPerson);
			
			// Set Token And Set Session
			final AuthenticationToken token = new AutologinToken(
					Strings.nullToEmpty(modifiedPerson.getId()), tenant.getTenantId());
			log.debug("Logging in using AutologinToken {}", token.getPrincipal() );
			try {
				final Subject currentUser = SecurityUtils.getSubject();
				currentUser.login(token);
				final String personId = Preconditions.checkNotNull(modifiedPerson.getId(),
						"Cannot get current user as person ID");
				Interaction.LOGIN.info("You are now logged in as %s", personId);
				log.debug("Current user is now {}, permitted to edit person? {}", personId, currentUser.isPermitted("person:edit:*"));
//							onLoginSuccess(personId);
			} catch (final AuthenticationException e) {
//				error(String.format("Invalid credentials for %s", token.getPrincipal()));
				getSession().error(String.format("Wrong Username/Email and password combination."));
				log.debug(String.format("Invalid credentials for %s", token.getPrincipal()), e);
			}
						
			// Redirect Url
			((SoluvasWebSession) getSession()).postLoginSuccess();
		} catch (TwitterException e) {
			throw new NotLoggedWithTwitterException("Error when processing Twitter verifier", e);
//			info("Error when processing Twitter verifier" + e.getMessage());
//			log.error("Error when processing Twitter verifier", e);
//			throw new RestartResponseException(DedicatedLoginPage.class);
		}
	}
}
