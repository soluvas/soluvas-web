package org.soluvas.web.login.facebook;

import com.google.common.collect.ImmutableSet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.IWebAddress2;
import org.soluvas.socmed.FacebookApp;
import org.soluvas.web.login.LoginException;
import org.soluvas.web.site.IGoogleAnalyticsSysConfig;
import org.soluvas.web.site.google.GoogleAnalyticsClickTrackingBehavior;

import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Facebook login Button gets its source from {@link FacebookApp} settings, but uses {@link IWebAddress2}.
 * Facebook Callback/Redirect will be handled by {@link FacebookRecipient} or {@link SpringFacebookRecipientPage}.
 * Uses {@link GoogleAnalyticsClickTrackingBehavior}.
 *
 * @author ceefour
 * @see FacebookLoginLink2
 * @see FacebookRecipient
 * @see SpringFacebookRecipientPage
 */
public class FacebookLoginButton extends Button {

    private static final Logger log = LoggerFactory
            .getLogger(FacebookLoginButton.class);

    /**
     * See https://developers.facebook.com/docs/facebook-login/review/what-is-login-review
     * why we only have 3 permissions now.
     * @todo App-specific login permissions.
     */
    public static final ImmutableSet<String> DEFAULT_LOGIN_PERMISSIONS =
            ImmutableSet.of("public_profile", "email");
    private static final long serialVersionUID = 1L;

    private final Class<? extends Page> recipientPage;
    @SpringBean(required = false)
    private FacebookApp facebookApp;
    @Inject
    private IWebAddress2 webAddress2;
    @SpringBean(required = false)
    private IGoogleAnalyticsSysConfig gaConfig;
    private String eventCategory = "Login";
    private String eventAction = "before login facebook";

    public FacebookLoginButton(String id, Class<? extends Page> recipientPage) {
        super(id);
        this.recipientPage = recipientPage;
    }

    @Override
    protected boolean getStatelessHint() {
        return true;
    }

    @Override
    public boolean isVisible() {
        final String fbAppId;
        if (facebookApp != null && facebookApp.getApiKey() != null) {
            fbAppId = facebookApp.getApiKey();
        } else {
            fbAppId = null;
        }
        if (fbAppId != null) {
            return true;
        } else {
            log.debug("Disabling Facebook login because facebookAppId is empty");
            return false;
        }
    }

    public FacebookLoginButton category(String newEventCategory) {
        this.eventCategory = newEventCategory;
        return this;
    }

    public FacebookLoginButton action(String newEventAction) {
        this.eventAction = newEventAction;
        return this;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        final String fbAppId;
        if (facebookApp != null && facebookApp.getApiKey() != null) {
            fbAppId = facebookApp.getApiKey();
        } else {
            fbAppId = null;
        }
        if (fbAppId != null) {
            add(new GoogleAnalyticsClickTrackingBehavior(gaConfig,
                    this.eventCategory, this.eventAction, null, null));
        }
    }

    @Override
    public void onSubmit() {
        super.onSubmit();
        final String fbAppId = facebookApp.getApiKey();
        // final String token_url =
        // "https://graph.facebook.com/oauth/access_token?";
        // must use webAddress.baseUri since we need actual external URI, not
        // 'localhost'
//			final String redirectUri = webAddress.getBaseUri() + "fb_recipient/";
        final String baseUri = webAddress2.getBaseUri();
        final String redirectUri = baseUri + getRequestCycle().mapUrlFor(recipientPage, new PageParameters()).toString();
        // final String appSecret = facebookMgr.getAppSecret();
        // UUID state = UUID.randomUUID();
        final String facebookRedirectUri = "https://www.facebook.com/dialog/oauth";
        try {
            final Set<String> loginPermissions = facebookApp != null && !facebookApp.getLoginPermissions().isEmpty() ?
                    facebookApp.getLoginPermissions() : DEFAULT_LOGIN_PERMISSIONS;
            final URIBuilder fbLoginUriBuilder = new URIBuilder(
                    facebookRedirectUri);
            fbLoginUriBuilder.addParameter("client_id", fbAppId);
            fbLoginUriBuilder.addParameter("redirect_uri", redirectUri);
            fbLoginUriBuilder.addParameter("scope",
                    loginPermissions.stream().collect(Collectors.joining(",")));
            final String fbLoginUri = fbLoginUriBuilder.toString();
            log.trace("Facebook login URI {}", fbLoginUri);
            throw new RedirectToUrlException(fbLoginUri);
        } catch (final Exception ex) {
            throw new LoginException(ex, "Error building Facebook URI for App ID %s Redirect URI %s", fbAppId, redirectUri);
        }
    }
}