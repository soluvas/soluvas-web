package org.soluvas.web.login;

import java.io.IOException;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.person.PersonRepository;
import org.wicketstuff.annotation.mount.MountPath;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

/**
 * FIXME: not complete T.T still bug..
 * Google Recipient 
 * @author haidar
 *
 */
@MountPath("google_recipient/")
public class GoogleRecipient extends WebPage {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(GoogleRecipient.class);
	
	@SpringBean
	private PersonRepository personRepo;
	@SpringBean(name="googleMgr")
	private GoogleManager googleManager;
	@SpringBean
	private WebAddress webAddress;

	private static final HttpTransport TRANSPORT = new NetHttpTransport();
	private static final JsonFactory JSON_FACTORY = new JacksonFactory();

	public GoogleRecipient(PageParameters params) throws IOException {
		super();
		throw new UnsupportedOperationException("Masih lom jalan + di komen juga code-nya");
		/*final String myUrl = webAddress.getBaseUri() + "google_recipient/";
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
			
			final Person existingPerson = personRepo.findOneByAttribute("googlePlusId", String.valueOf(user.getId()));
			if (existingPerson == null) {
				existingPerson = personRepo.findOneByAttribute("google", user.getName().toString());
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
						return !personRepo.exists(input);
					}
				});
				
				final String personSlug = SlugUtils.generateValidScreenName(user.getDisplayName(), new Predicate<String>() {
					@Override
					public boolean apply(@Nullable String input) {
						return !personRepo.existsByAttribute("uniqueIdentifier", input);
					}
				});
				final PersonName personName = NameUtils.splitName(user.getDisplayName());
				final SocialPerson newPerson = new SocialPerson(personId, personSlug, personName.getFirstName(), personName.getLastName());
				existingPerson = personRepo.add(newPerson);
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
			personRepo.modify(existingPerson);
		} catch (final Exception e) {
//			info("Error when building a uri using Google Account" + e.getMessage());
//			log.error("Error when building a uri using Google Account", e);
//			throw new RestartResponseException(DedicatedLoginPage.class);
			throw new NotLoggedWithGooglePlusException("Error logging in via Google Account", e);
		}*/
	}

}
