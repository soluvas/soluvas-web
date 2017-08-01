package org.soluvas.web.site.google;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.feedback.FeedbackCollector;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.request.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.IGoogleAnalyticsSysConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.List;

/**
 * Puts <a href="http://stackoverflow.com/a/10712960/122441">Google Analytics script in {@code head}</a>.
 * 
 * <p>Google Analytics tracking <a href="https://idbippo.atlassian.net/browse/BC-1397">was not enabled on app/mall role</a>.
 * However, Google Analytics is useful for other things, including server response time tracking,
 * so it should be enabled on all pages including backend pages.
 *
 * <p>It disables itself if a {@code ROLE_ADMIN} user is logged in (supported in Spring Security only).</p>
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class GoogleAnalyticsBehavior extends Behavior {

	private static final Logger log = LoggerFactory
			.getLogger(GoogleAnalyticsBehavior.class);
	
	@Inject
	private IGoogleAnalyticsSysConfig sysConfig;

	public static boolean isAdmin() {
		try {
			final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			return auth.getAuthorities().stream().anyMatch(it -> "ROLE_ADMIN".equals(it.getAuthority()));
		} catch (Exception e) {
			log.trace("Spring Security not used", e);
		}
		return false;
	}

	public static boolean isReallyEnabled(IGoogleAnalyticsSysConfig sysConfig) {
		return null != sysConfig && Boolean.TRUE == sysConfig.getGoogleAnalyticsEnabled() &&
				!Strings.isNullOrEmpty(sysConfig.getGoogleAnalyticsTrackingId()) && !isAdmin();
	}

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		if (Boolean.TRUE == sysConfig.getGoogleAnalyticsEnabled()) {
			// Google Analytics is required for server timing
			if (Strings.isNullOrEmpty(sysConfig.getGoogleAnalyticsTrackingId())) {
				log.warn("Google Analytics Tracking ID must be set");
			} else {
				if (!isAdmin()) {
					// TODO: support specific domain (i.e. non-auto) during ga(create)
					// https://developers.google.com/analytics/devguides/collection/analyticsjs/
					final String realCookieDomain = Optional.fromNullable(sysConfig.getGoogleAnalyticsCookieDomain()).or("auto");
					String googleAnalyticScript =
							"(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n"
									+ "(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n"
									+ "m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n"
									+ "})(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n"
									+ "\n"
									+ "ga('create', '" + sysConfig.getGoogleAnalyticsTrackingId() + "', '" + realCookieDomain + "');\n";
					if (Boolean.TRUE == sysConfig.getGoogleAnalyticsDisplayFeatures()) {
						googleAnalyticScript += "ga('require', 'displayfeatures');\n";
					}
					// result e.g. "id/search?4&religion=BUDDHISM"
					final Url baseUrl = component.getRequestCycle().getUrlRenderer().getBaseUrl();
					final String fixedUrl;
					if (baseUrl.toString().matches(".*\\?\\d+=?")) {
						fixedUrl = "/" + baseUrl.toString().replaceFirst("\\?\\d+=?", "");
					} else if (baseUrl.toString().matches(".*\\?\\d+=?&.*")) {
						fixedUrl = "/" + baseUrl.toString().replaceFirst("\\?\\d+=?&", "?");
					} else {
						fixedUrl = "/" + baseUrl.toString();
					}
					log.trace("Current URL: base={}, fixeds={}", baseUrl, fixedUrl);
					// Sets the page value on the tracker.
					googleAnalyticScript += "ga('set', 'page', " + JSONObject.quote(fixedUrl) + ");\n";
					// https://developers.google.com/analytics/devguides/collection/analyticsjs/field-reference#hit
					googleAnalyticScript += "ga('send', 'pageview');\n";
					// do not put in footer-container, so we use StringHeaderItem instead of JavaScriptHeaderItem
					// to "fool" de.agilecoders.wicket.core.markup.html.RenderJavaScriptToFooterHeaderResponseDecorator
					response.render(StringHeaderItem.forString("<script>\n" + googleAnalyticScript + "</script>\n"));
				}
			}
		}
	}

	/**
	 * Sends a Google Analytics event tracking over AJAX, while also logging to JavaScript console.
	 * Checks if Google Analytics is enabled before adding JavaScript.
	 *
	 * Important: It's a Google Analytics terms violation to send user ID or any user-identifiable information!
	 *
	 * @param config
	 * @param target
	 * @param category
	 * @param action
	 * @param label
	 * @param value
	 */
	public static void appendSendEvent(@Nullable IGoogleAnalyticsSysConfig config, AjaxRequestTarget target,
									   String category, String action, String label, Integer value) {
		final String consoleLog = String.format("ga.send.event category=%s action=%s label=%s value=%s",
			category, action, label, value);
		target.appendJavaScript("console.debug(" + JSONObject.quote(consoleLog) + ");\n");
		if (isReallyEnabled(config)) {
			target.appendJavaScript("ga('send', 'event', " + JSONObject.quote(category) + ", " + JSONObject.quote(action) + ", " +
					JSONObject.quote(label) + ", " + (null != value ? value : "null") + ");\n");
		}
	}

	/**
	 * Gets the send event JavaScript usable for onclick handler because it asks for beacon transport.
	 * @param config
	 * @param category
	 * @param action
	 * @param label
	 * @param value
	 * @return
	 */
	public static String getEventBeaconScript(IGoogleAnalyticsSysConfig config,
											  String category, String action, String label, Integer value) {
		String script = "";
		final String consoleLog = String.format("ga.send.event[beacon] category=%s action=%s label=%s value=%s",
				category, action, label, value);
		script += "console.debug(" + JSONObject.quote(consoleLog) + "); ";
		if (isReallyEnabled(config)) {
			script += " ga('send', 'event', " + JSONObject.quote(category) + ", " + JSONObject.quote(action) + ", " +
					JSONObject.quote(label) + ", " + (null != value ? value : "null") + ", {transport: 'beacon'});";
		}
		return script;
	}

	/**
	 * Gets the send event JavaScript usable for page load because it marks nonInteraction=true.
	 * @param config
	 * @param category
	 * @param action
	 * @param label
	 * @param value
	 * @return
	 */
	public static String getNonInteractionEventScript(IGoogleAnalyticsSysConfig config,
											  String category, String action, String label, Integer value) {
		String script = "";
		final String consoleLog = String.format("ga.send.event[nonInteraction] category=%s action=%s label=%s value=%s",
				category, action, label, value);
		script += "console.debug(" + JSONObject.quote(consoleLog) + "); ";
		if (isReallyEnabled(config)) {
			script += " ga('send', 'event', " + JSONObject.quote(category) + ", " + JSONObject.quote(action) + ", " +
					JSONObject.quote(label) + ", " + (null != value ? value : "null") + ", {nonInteraction: true});";
		}
		return script;
	}

	/**
	 * Reports component errors (usually form validation) as Google Analytics events.
	 * See {@code com.satukancinta.web.TrackingLaddaAjaxButton} for sample usage.
	 * @param config
	 * @param target
	 * @param component
	 */
	public static void reportErrors(IGoogleAnalyticsSysConfig config, AjaxRequestTarget target,
									Component component) {
		final List<FeedbackMessage> messages = new FeedbackCollector(component).collect();
		// appendSendEvent already calls isReallyEnabled()
		messages.forEach(msg -> {
			try {
				GoogleAnalyticsBehavior.appendSendEvent(config, target,
						component.getPage().getPageClass().getSimpleName(), "error " + msg.getReporter().getId(),
						msg.toString(), msg.getLevel());
			} catch (Exception e) {
				log.error("Cannot report error", e);
				throw e;
			}
		});
	}

}
