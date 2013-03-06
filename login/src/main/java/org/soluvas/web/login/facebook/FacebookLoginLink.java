package org.soluvas.web.login.facebook;

import org.apache.http.client.utils.URIBuilder;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.web.login.FacebookManager;

@SuppressWarnings("serial")
public class FacebookLoginLink extends AjaxLink<Void> {

	private static final Logger log = LoggerFactory
			.getLogger(FacebookLoginLink.class);

	@PaxWicketBean(name="facebookMgr")
	private FacebookManager facebookMgr;
	@PaxWicketBean(name="webAddress")
	private WebAddress webAddress;
	
	public FacebookLoginLink(String id) {
		super(id);
	}

	@Override
	public void onClick(AjaxRequestTarget target) {
		/** just config test **/
//					final String token_url = "https://graph.facebook.com/oauth/access_token?";
		final String redirectUri = webAddress.getBaseUri() + "fb_recipient/";
		final String appId = facebookMgr.getAppId();
//					final String appSecret = facebookMgr.getAppSecret();
//					UUID state = UUID.randomUUID();
		final String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";
		try {
			final URIBuilder fbLoginUriBuilder = new URIBuilder(facebookRedirectUri);
			fbLoginUriBuilder.addParameter("client_id", appId);
			fbLoginUriBuilder.addParameter("redirect_uri", redirectUri);
			fbLoginUriBuilder.addParameter("scope", "read_stream,email,user_birthday,user_hometown,user_about_me,user_photos,user_religion_politics,user_relationships,user_work_history,user_education_history,user_website,offline_access,publish_stream,publish_actions,share_item");
			final String fbLoginUri = fbLoginUriBuilder.toString();
			log.debug(" facebook login uri {}", fbLoginUri);
			
			throw new RedirectToUrlException(fbLoginUri);
		} catch (final Exception ex) {
			throw new RuntimeException("Error when building a uri", ex);
		}
	}
	
}