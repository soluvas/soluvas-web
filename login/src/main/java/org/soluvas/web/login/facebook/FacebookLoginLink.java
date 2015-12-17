package org.soluvas.web.login.facebook;

import com.google.common.base.Strings;
import org.apache.http.client.utils.URIBuilder;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.facebook.FacebookManager;
import org.soluvas.web.login.LoginException;

import javax.inject.Inject;

/**
 * {@link ExternalLink} that gets its source from {@link FacebookManager} settings.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class FacebookLoginLink extends ExternalLink {

	private static final Logger log = LoggerFactory
			.getLogger(FacebookLoginLink.class);

	@SpringBean(required=false)
	private FacebookManager facebookMgr;
	@Inject
	private WebAddress webAddress;

	public FacebookLoginLink(String id) {
		this(id, FacebookRecipient.class);
	}
	
	public FacebookLoginLink(String id, Class<? extends Page> recipientPage) {
		super(id, new Model<>());
		
		if (facebookMgr != null && !Strings.isNullOrEmpty(facebookMgr.getAppId()) && 
				!Strings.isNullOrEmpty(facebookMgr.getAppSecret())) {
			// final String token_url =
			// "https://graph.facebook.com/oauth/access_token?";
			// must use webAddress.baseUri since we need actual external URI, not
			// 'localhost'
//			final String redirectUri = webAddress.getBaseUri() + "fb_recipient/";
			final String redirectUri = webAddress.getBaseUri() + 
					getRequestCycle().mapUrlFor(recipientPage, new PageParameters()).toString();
			final String appId = facebookMgr.getAppId();
			// final String appSecret = facebookMgr.getAppSecret();
			// UUID state = UUID.randomUUID();
			final String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";
			try {
				final URIBuilder fbLoginUriBuilder = new URIBuilder(
						facebookRedirectUri);
				fbLoginUriBuilder.addParameter("client_id", appId);
				fbLoginUriBuilder.addParameter("redirect_uri", redirectUri);
				fbLoginUriBuilder
						.addParameter(
								"scope",
								"user_likes,read_stream,email,user_birthday,user_hometown,user_about_me,user_photos,user_religion_politics,user_relationships,user_work_history,user_education_history,user_website,publish_actions");
				final String fbLoginUri = fbLoginUriBuilder.toString();
				log.trace("Facebook login URI {}", fbLoginUri);
				setDefaultModelObject(fbLoginUri);
			} catch (final Exception ex) {
				throw new LoginException("Error building Facebook URI", ex);
			}
		} else {
			log.debug("Disabling Facebook login because facebookAppId/facebookAppSecret is empty");
			setVisible(false);
		}
	}
	
//	@Override
//	public void onClick(AjaxRequestTarget target) {
////					final String token_url = "https://graph.facebook.com/oauth/access_token?";
//		// must use webAddress.baseUri since we need actual external URI, not 'localhost'
//		final String redirectUri = webAddress.getBaseUri() + "fb_recipient/";
////		final String redirectUri = getRequestCycle().mapUrlFor(FacebookRecipient.class, new PageParameters()).toString();
//		final String appId = facebookMgr.getAppId();
////					final String appSecret = facebookMgr.getAppSecret();
////					UUID state = UUID.randomUUID();
//		final String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";
//		try {
//			final URIBuilder fbLoginUriBuilder = new URIBuilder(facebookRedirectUri);
//			fbLoginUriBuilder.addParameter("client_id", appId);
//			fbLoginUriBuilder.addParameter("redirect_uri", redirectUri);
//			fbLoginUriBuilder.addParameter("scope", "read_stream,email,user_birthday,user_hometown,user_about_me,user_photos,user_religion_politics,user_relationships,user_work_history,user_education_history,user_website,offline_access,publish_stream,publish_actions,share_item");
//			final String fbLoginUri = fbLoginUriBuilder.toString();
//			log.trace("Facebook login URI {}", fbLoginUri);
//			
//			throw new RedirectToUrlException(fbLoginUri);
//		} catch (final Exception ex) {
//			throw new LoginException("Error when building a uri", ex);
//		}
//	}
	
}