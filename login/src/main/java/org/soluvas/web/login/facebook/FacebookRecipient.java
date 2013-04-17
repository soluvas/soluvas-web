package org.soluvas.web.login.facebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Nullable;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.WebAddress;
import org.soluvas.facebook.FacebookUtilsImpl;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.json.JsonUtils;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.NotLoggedWithFacebookException;
import org.soluvas.web.login.FacebookManager;
import org.soluvas.web.site.SoluvasWebSession;
import org.soluvas.web.site.WicketMountPoint;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;

/**
 * Get Facebook Login , token Access, FB Photo profile
 * @author haidar
 *
 */
@SuppressWarnings("serial")
@WicketMountPoint(mountPoint="fb_recipient/")
public class FacebookRecipient extends WebPage {

	private static final Logger log = LoggerFactory.getLogger(FacebookRecipient.class);
	
	@SpringBean(name="personLdapRepo")
	private LdapRepository<SocialPerson> personLdapRepo;
	@SpringBean(name="personImageRepo")
	private ImageRepository personImageRepo;
	@SpringBean(name="facebookMgr")
	private FacebookManager facebookMgr;
	@SpringBean(name="webAddress")
	private WebAddress webAddress;
	
	public FacebookRecipient(PageParameters params) {
		super();
		try {
			final String code = params.get("code").toOptionalString();
			if (Strings.isNullOrEmpty(code)) {
				throw new NotLoggedWithFacebookException();
			}
	//		Preconditions.checkArgument(!Strings.isNullOrEmpty(code), "Code Parameter must be provided");
			final String redirectUri = webAddress.getBaseUri() + "fb_recipient/";
			final String appId = facebookMgr.getAppId();
			final String appSecret = facebookMgr.getAppSecret();
	
			log.debug("Code parameter url is {}", code);
			add(new Label("code" ,code));
			
			log.info("Getting access token for appId {} redirectUri {}",
					appId, redirectUri);
			final String accessToken = fetchAccessToken(appId, appSecret, redirectUri, code);
			log.debug("fetching access token {}", accessToken);
			final FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
			final User fbUser = facebookClient.fetchObject("me", User.class);
			Preconditions.checkNotNull("User should not be null", fbUser);
			log.debug("Got user and user details{}", JsonUtils.asJson(fbUser));
			
			SocialPerson existingPerson = personLdapRepo.findOneByAttribute("fbId", fbUser.getId());
			if (existingPerson == null) {
				existingPerson = personLdapRepo.findOneByAttribute("fbUser", fbUser.getUsername());
			}
			if (existingPerson == null) {
				existingPerson = personLdapRepo.findOneByAttribute("mail", fbUser.getEmail());
			}
			
			if (existingPerson != null) {
				// Direct Login
				log.debug("Person {} from Facebook ID {} exists",
						existingPerson.getId(), fbUser.getId());
			} else {
				Preconditions.checkNotNull(fbUser.getName(), "Facebook User's Name cannot be empty");
				final String personId = SlugUtils.generateValidId(fbUser.getName(), new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personLdapRepo.exists(input);
					}
				});
				
				final String personSlug = SlugUtils.generateValidScreenName(fbUser.getName(), new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personLdapRepo.existsByAttribute("uniqueIdentifier", input);
					}
				});
				
				existingPerson = new SocialPerson(personId, personSlug, fbUser.getFirstName(), fbUser.getLastName());
				personLdapRepo.add(existingPerson);
			}

			existingPerson.setFacebookUsername(fbUser.getUsername());
			existingPerson.setFacebookId(Long.valueOf(fbUser.getId()));
			existingPerson.setFacebookAccessToken(accessToken);
			if (existingPerson.getEmails() == null) {
				existingPerson.setEmails(new HashSet<String>());
			}
			if (!Strings.isNullOrEmpty(fbUser.getEmail())) {
				log.debug("User {} from Facebook ID {} has email {}",
						existingPerson.getId(), fbUser.getId(), fbUser.getEmail());
				existingPerson.getEmails().add(fbUser.getEmail());
				if (existingPerson.getPrimaryEmail() == null) {
					existingPerson.setPrimaryEmail(fbUser.getEmail());
				}
			} else {
				log.warn("User {} from Facebook ID {} has no email address",
					existingPerson.getId(), fbUser.getId());
			}
			if (existingPerson.getPhotoId() == null) {
				//Set photo from Facebook.
				try {
					final String imageId = FacebookUtilsImpl.refreshPhotoFromFacebook(
							existingPerson.getFacebookId(), existingPerson.getName(), personImageRepo);
					existingPerson.setPhotoId(imageId);
				} catch (Exception e) {
					log.error("Cannot refresh photo from Facebook for person " + existingPerson.getId() + " " + existingPerson.getName(), e);
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
//				onLoginSuccess(personId);
			} catch (final AuthenticationException e) {
				error(String.format("Invalid credentials for %s", token.getPrincipal()));
				log.debug(String.format("Invalid credentials for %s", token.getPrincipal()), e);
			}
			
			// Redirect Url
			final SoluvasWebSession solWebSession = (SoluvasWebSession) getSession();
			if (solWebSession.getOriginalUrl() != null) {
				final String destUri = webAddress.getBaseUri() + solWebSession.getOriginalUrl().toString();
				solWebSession.setOriginalUrl(null);
				log.debug("Session has originalUrl, redirecting to {}", destUri);
				throw new RedirectToUrlException(destUri);
			} else {
				// If Regular User
				final Class<? extends Page> homePage = Application.get().getHomePage();
//				RedirectByUserTyperType;
				
				log.debug("Session has no, redirecting to {}", homePage.getName()); 
				throw new RestartResponseException(homePage);
			}
		} catch (final Exception e) {
			throw new NotLoggedWithFacebookException("Cannot login via Facebook", e);
		}
	}

	public String fetchAccessToken(String appId, String appSecret, String redirectUri, String code) {
		try {
			final URIBuilder accessTokenUri = new URIBuilder("https://graph.facebook.com/oauth/access_token");
			accessTokenUri.addParameter("client_id", appId);
			accessTokenUri.addParameter("client_secret", appSecret);
			accessTokenUri.addParameter("redirect_uri", redirectUri);
			accessTokenUri.addParameter("code", code);
			final HttpGet accessTokenUriRequest = new HttpGet(accessTokenUri.build());
			final DefaultHttpClient client = new DefaultHttpClient();
			final HttpResponse responseAccessTokenReq = client.execute(accessTokenUriRequest);
			if (responseAccessTokenReq.getStatusLine().getStatusCode() != 200)
				throw new IOException(String.format(
						"GET %s throws HTTP Error %d: %s", accessTokenUriRequest, responseAccessTokenReq
								.getStatusLine().getStatusCode(), responseAccessTokenReq
								.getStatusLine().getReasonPhrase()));
			final Scanner scanner = new Scanner(responseAccessTokenReq.getEntity().getContent());
			final List<NameValuePair> data = new ArrayList<>();
			URLEncodedUtils.parse(data, scanner, "UTF-8");
			
			final String accessToken = data.get(0).getValue();
			return accessToken;
			//throw new RedirectToUrlException(myUrl.toString());
		} catch (final Exception ex) {
			throw new RuntimeException("Error when building Facebook URI for appId " + 
				appId + " and redirectUri " + redirectUri, ex);
		}
	}
	
}
