package org.soluvas.web.login.facebook;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
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
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.facebook.FacebookManager;
import org.soluvas.facebook.FacebookUtilsImpl;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.json.JsonUtils;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.NotLoggedWithFacebookException;
import org.soluvas.socmed.FacebookApp;
import org.soluvas.web.site.Interaction;
import org.soluvas.web.site.SoluvasWebSession;
import org.wicketstuff.annotation.mount.MountPath;

import javax.annotation.Nullable;
import javax.inject.Inject;

/**
 * Get Facebook Login , token Access, FB Photo profile
 * @author haidar
 *
 */
@SuppressWarnings("serial")
@MountPath("fb_recipient/")
public class FacebookRecipient extends WebPage {

	private static final Logger log = LoggerFactory.getLogger(FacebookRecipient.class);
	
	@Inject
	private PersonRepository personRepo;
	@SpringBean(name = "personImageRepo", required = false)
	private ImageRepository personImageRepo;
	@SpringBean(required = false)
	private FacebookApp facebookApp;
	/**
	 * @deprecated Use {@link FacebookApp}.
	 */
	@SpringBean(required = false) @Deprecated
	private FacebookManager facebookMgr;
	@Inject
	private WebAddress webAddress;
	@Inject
	private TenantRef tenant;
	
	public FacebookRecipient(final PageParameters params) {
		super();
		Preconditions.checkState(facebookApp != null || facebookMgr != null, "facebookApp must be provided");
		try {
			final String code = params.get("code").toOptionalString();
			if (Strings.isNullOrEmpty(code)) {
				throw new NotLoggedWithFacebookException();
			}
	//		Preconditions.checkArgument(!Strings.isNullOrEmpty(code), "Code Parameter must be provided");
			final String redirectUri = webAddress.getBaseUri() + "fb_recipient/";
			final String appId = facebookApp != null ? facebookApp.getApiKey() : facebookMgr.getAppId();
			final String appSecret = facebookApp != null ? facebookApp.getApiSecret() : facebookMgr.getAppSecret();
	
			log.debug("Code parameter url is {}", code);
			add(new Label("code", code));
			
			log.info("Getting access token for appId {} redirectUri {}", appId, redirectUri);
			final Facebook facebook = new FacebookFactory().getInstance();
			facebook.setOAuthAppId(appId, appSecret);
			facebook.setOAuthCallbackURL(redirectUri);
//			final String accessToken = fetchAccessToken(appId, appSecret, redirectUri, code);
			final AccessToken accessToken = facebook.getOAuthAccessToken(code);
			log.debug("fetched access token: {}", accessToken);
//			final long expiresInSeconds = new Duration(facebookAuthorization().getExpiryTime(), new DateTime()).getStandardSeconds();
			facebook.setOAuthAccessToken(accessToken);

//			final FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
			final facebook4j.User fbUser = facebook.getMe();
			Preconditions.checkNotNull("User should not be null", fbUser);
			log.debug("Got user and user details {}", JsonUtils.asJson(fbUser));
			
			Person curPerson = personRepo.findOneByFacebook(Long.valueOf(fbUser.getId()), null);
			if (curPerson == null) {
				curPerson = personRepo.findOneByFacebook(null, fbUser.getUsername());
			}
			if (curPerson == null) {
				curPerson = personRepo.findOneByEmail(StatusMask.RAW, fbUser.getEmail());
			}
			
			if (curPerson != null) {
				// Direct Login
				log.debug("Person {} from Facebook ID {} exists",
						curPerson.getId(), fbUser.getId());
			} else {
				Preconditions.checkNotNull(fbUser.getName(), "Facebook User's Name cannot be empty");
				final String personId = SlugUtils.generateValidId(fbUser.getName(),
						input -> !personRepo.exists(input));
				final String personSlug = SlugUtils.generateValidId(fbUser.getName(),
						input -> !personRepo.existsBySlug(StatusMask.RAW, input).isPresent());
				curPerson = CommonsFactory.eINSTANCE.createPerson(personId, personSlug, fbUser.getFirstName(), fbUser.getLastName(), null, Gender.UNKNOWN);
				curPerson.setCreationTime(new DateTime());
				curPerson.setModificationTime(new DateTime());
				personRepo.add(curPerson);
			}

			if (curPerson.getValidationTime() == null) {
				curPerson.setValidationTime(new DateTime());
			}
			curPerson.setAccountStatus(AccountStatus.ACTIVE);
			if (fbUser.getGender() != null) {
				try {
					final Gender gender = Gender.valueOf(fbUser.getGender().toUpperCase());
					curPerson.setGender(gender);
				} catch (Exception e) {
					log.warn("Invalid gender value {} from Facebook ID {}",
							fbUser.getGender(), fbUser.getId());
				}
			}
			curPerson.setFacebookUsername(fbUser.getUsername());
			curPerson.setFacebookId(Long.valueOf(fbUser.getId()));
			curPerson.setFacebookAccessToken(accessToken.getToken());
			if (!Strings.isNullOrEmpty(fbUser.getEmail())) {
				log.debug("User {} from Facebook ID {} has email {}",
						curPerson.getId(), fbUser.getId(), fbUser.getEmail());
				final Optional<Email> existingEmail = Iterables.tryFind(curPerson.getEmails(), new Predicate<Email>() {
					@Override
					public boolean apply(@Nullable Email input) {
						return input.getEmail().equals(fbUser.getEmail());
					}
				});
				if (!existingEmail.isPresent()) {
					final Email email = CommonsFactory.eINSTANCE.createEmail();
					email.setEmail(fbUser.getEmail());
					if (Strings.isNullOrEmpty(curPerson.getEmail())) {
						email.setPrimary(true);
					}
					curPerson.getEmails().add(email);
				}
			} else {
				log.warn("User {} from Facebook ID {} has no email address",
					curPerson.getId(), fbUser.getId());
			}
			if (curPerson.getPhotoId() == null) {
				if (personImageRepo != null) {
					//Set photo from Facebook.
					try {
						final String imageId = FacebookUtilsImpl.refreshPhotoFromFacebook(
								curPerson.getFacebookId(), curPerson.getName(), personImageRepo);
						curPerson.setPhotoId(imageId);
					} catch (Exception e) {
						log.error("Cannot refresh photo from Facebook for person " + curPerson.getId() + " " + curPerson.getName(), e);
					}
				} else {
					log.warn("Not refreshing photo from Facebook for person {} {} because personImageRepo bean not provided",
							curPerson.getId(), curPerson.getName());
				}
			}
			final Person modifiedPerson = personRepo.modify(curPerson.getId(), curPerson); 
			
			// Set Token And Set Session
			final AuthenticationToken token = new AutologinToken(
					Strings.nullToEmpty(modifiedPerson.getId()), tenant.getTenantId());
			log.debug("Logging in using AutologinToken {}", token.getPrincipal());
			try {
				final Subject currentUser = SecurityUtils.getSubject();
				currentUser.login(token);
				final String personId = Preconditions.checkNotNull(modifiedPerson.getId(),
						"Cannot get current user as person ID");
				Interaction.LOGIN.info("You are now logged in as %s", personId);
				log.debug("Current user is now {}, permitted to edit person? {}", personId, currentUser.isPermitted("person:edit:*"));
//				onLoginSuccess(personId);
			} catch (final AuthenticationException e) {
//				error(String.format("Invalid credentials for %s", token.getPrincipal()));
				getSession().error(String.format("Wrong Username/Email and password combination."));
				log.debug(String.format("Invalid credentials for %s", token.getPrincipal()), e);
			}
			
			// Redirect Url
			((SoluvasWebSession) getSession()).postLoginSuccess();
		} catch (final Exception e) {
			throw new NotLoggedWithFacebookException("Cannot login via Facebook", e);
		}
	}

}
