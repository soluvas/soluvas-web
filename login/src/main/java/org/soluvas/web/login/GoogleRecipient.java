package org.soluvas.web.login;

import java.io.IOException;
import java.util.HashSet;

import javax.annotation.Nullable;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.NameUtils.PersonName;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.WebAddress;
import org.soluvas.json.JsonUtils;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.security.NotLoggedWithGooglePlusException;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.PlusScopes;
import com.google.api.services.plus.model.Person;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/**
 * Google Recipient 
 * @author haidar
 *
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="google_recipient/")
public class GoogleRecipient extends WebPage {
	
	private static final Logger log = LoggerFactory
			.getLogger(GoogleRecipient.class);
	
	@PaxWicketBean(name="personLdapRepo") @SpringBean(name="personLdapRepo")
	private LdapRepository<SocialPerson> personLdapRepo;
	@PaxWicketBean(name="googleMgr") @SpringBean(name="googleMgr")
	private GoogleManager googleManager;
	@PaxWicketBean(name="webAddress") @SpringBean(name="webAddress")
	private WebAddress webAddress;

	private static final HttpTransport TRANSPORT = new NetHttpTransport();
	private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	public GoogleRecipient(PageParameters params) throws IOException {
		super();
		final String myUrl = webAddress.getBaseUri() + "google_recipient/";
		final String code = params.get("code").toOptionalString();

		final GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				TRANSPORT, JSON_FACTORY, googleManager.getClientId(), googleManager.getClientSecret(),
				ImmutableList.of(PlusScopes.PLUS_ME)).build();

		final GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(myUrl).execute();
		final String accessToken = response.getAccessToken();
		// Set Up Google Plus
		 
		final GoogleCredential credential = new GoogleCredential().setAccessToken(accessToken);

		final Plus plus = new Plus(TRANSPORT, JSON_FACTORY, credential);
		final Person user = plus.people().get("me").execute();
		if (user == null) {
			throw new NotLoggedWithGooglePlusException("Canot login via Google Account, Google+ 'me' resource is null");
		}
		log.debug("User detail {}", user);
		
		add(new Label("code" ,accessToken));
		try {
			log.debug("fetching access token {}", accessToken);
			Preconditions.checkNotNull("User should not be null", user);
			log.debug("Got user {}", JsonUtils.asJson(user));
			
			SocialPerson existingPerson = personLdapRepo.findOneByAttribute("googlePlusId", String.valueOf(user.getId()));
			if (existingPerson == null) {
				existingPerson = personLdapRepo.findOneByAttribute("google", user.getName().toString());
			}
			
			if (existingPerson != null) {
				// Direct Login
				log.debug("Person {} from Google ID {} ({}) exists",
						existingPerson.getId(), user.getId(), user.getEmails());
			} else {
				Preconditions.checkNotNull(user.getName(), "Google User's Name cannot be empty");
				final String personId = SlugUtils.generateValidId(user.getDisplayName(), new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personLdapRepo.exists(input);
					}
				});
				
				final String personSlug = SlugUtils.generateValidScreenName(user.getDisplayName(), new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personLdapRepo.existsByAttribute("uniqueIdentifier", input);
					}
				});
				final PersonName personName = NameUtils.splitName(user.getDisplayName());
				final SocialPerson newPerson = new SocialPerson(personId, personSlug, personName.getFirstName(), personName.getLastName());
				existingPerson = personLdapRepo.add(newPerson);
				log.debug("person {} is inserted", personId);
			}

			if (existingPerson.getEmails() == null) {
				existingPerson.setEmails(new HashSet<String>());
			}
			if (user.getEmails() != null && !user.getEmails().isEmpty()) {
				for (final Person.Emails googleEmail : user.getEmails()) {
					if (!Strings.isNullOrEmpty(googleEmail.getValue())) {
						existingPerson.getEmails().add(googleEmail.getValue());
					}
				}
				if (!Strings.isNullOrEmpty(user.getEmails().get(0).getValue())) {
					existingPerson.setGoogleUsername(user.getEmails().get(0).getValue());
				}
			}
			existingPerson.setGooglePlusId(user.getId());
			existingPerson.setGoogleAccessToken(accessToken);
			personLdapRepo.modify(existingPerson);
		} catch (final Exception e) {
//			info("Error when building a uri using Google Account" + e.getMessage());
//			log.error("Error when building a uri using Google Account", e);
//			throw new RestartResponseException(DedicatedLoginPage.class);
			throw new NotLoggedWithGooglePlusException("Error logging in via Google Account", e);
		}
	}

}
