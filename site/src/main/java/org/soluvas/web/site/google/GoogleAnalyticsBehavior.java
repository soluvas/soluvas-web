package org.soluvas.web.site.google;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.request.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.IGoogleAnalyticsSysConfig;

import javax.inject.Inject;

/**
 * Puts <a href="http://stackoverflow.com/a/10712960/122441">Google Analytics script in {@code head}</a>.
 * 
 * <p>Google Analytics tracking <a href="https://idbippo.atlassian.net/browse/BC-1397">was not enabled on app/mall role</a>.
 * However, Google Analytics is useful for other things, including server response time tracking,
 * so it should be enabled on all pages including backend pages.
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class GoogleAnalyticsBehavior extends Behavior {

	private static final Logger log = LoggerFactory
			.getLogger(GoogleAnalyticsBehavior.class);
	
	@Inject
	private IGoogleAnalyticsSysConfig sysConfig;

	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		if (Boolean.TRUE == sysConfig.getGoogleAnalyticsEnabled()) {
			// Google Analytics is required for server timing
			if (Strings.isNullOrEmpty(sysConfig.getGoogleAnalyticsTrackingId())) {
				log.warn("Google Analytics Tracking ID must be set");
			} else {
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
				if (baseUrl.toString().matches(".+\\?\\d+")) {
					fixedUrl = "/" + baseUrl.toString().replaceFirst("\\?\\d+", "");
				} else if (baseUrl.toString().matches(".+\\?\\d+&.*")) {
					fixedUrl = "/" + baseUrl.toString().replaceFirst("\\?\\d+&", "?");
				} else {
					fixedUrl = "/" + baseUrl.toString();
				}
				log.trace("Current URL: base={}, fixeds={}", baseUrl, fixedUrl);
				// https://developers.google.com/analytics/devguides/collection/analyticsjs/field-reference#hit
//				googleAnalyticScript += "ga('send', 'pageview');\n";
				googleAnalyticScript += "ga('send', {'hitType': 'pageview', 'page': " + JSONObject.quote(fixedUrl) + "});\n";
				// do not put in footer-container, so we use StringHeaderItem instead of JavaScriptHeaderItem
				// to "fool" de.agilecoders.wicket.core.markup.html.RenderJavaScriptToFooterHeaderResponseDecorator
				response.render(StringHeaderItem.forString("<script>\n" + googleAnalyticScript + "</script>\n"));
			}
		}
	}
	
}
