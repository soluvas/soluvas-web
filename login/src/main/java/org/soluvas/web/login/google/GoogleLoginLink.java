package org.soluvas.web.login.google;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.inject.Supplied;
import org.soluvas.web.login.GoogleManager;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.plus.PlusScopes;
import com.google.common.collect.ImmutableList;

@SuppressWarnings("serial")
public class GoogleLoginLink extends IndicatingAjaxLink<Void> {
			
	private static final Logger log = LoggerFactory
			.getLogger(GoogleLoginLink.class);
	
	@Inject
	private GoogleManager googleMgr;
	@Inject @Supplied
	private WebAddress webAddress;

	public GoogleLoginLink(String id) {
		super(id);
	}

	@Override
	public void onClick(AjaxRequestTarget target) {
		/** just config test **/
//					final String token_url = "https://api.twitter.com/oauth/request_token ";
		final String redirectUri = webAddress.getBaseUri() + "google_recipient/";
		final GoogleAuthorizationCodeFlow authorizationCodeFlow = new GoogleAuthorizationCodeFlow.Builder(
				new NetHttpTransport(), new JacksonFactory(),
				googleMgr.getClientId(), googleMgr.getClientSecret(),
				ImmutableList.of(PlusScopes.PLUS_ME))
				.setAccessType("offline")
		        .build();
		final String authorizationUri = authorizationCodeFlow.newAuthorizationUrl().setRedirectUri(redirectUri).build();
		log.debug("Google Autorize url {}", authorizationUri);
		throw new RedirectToUrlException(authorizationUri);
		// .setCredentialStore(
	    // new JdoCredentialStore(JDOHelper.getPersistenceManagerFactory("transactions-optional")))
	}

}
