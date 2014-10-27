package org.soluvas.web.site.facebook;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.socmed.FacebookSysConfig;

import com.google.common.base.Optional;

/**
 * <p>If you want to track the conversions that happen on your website as a result of ads that you're running on Facebook, you can create a conversion tracking pixel to put on your website.
 * 
 * <p>Using the conversion tracking pixel tool, you can create a JavaScript code snippet to place on your conversion pages. For example, if you want to track checkouts, you would put the conversion tracking pixel on the checkout confirmation page that people see after completing a checkout. Whenever a person loads that page in his or her browser, the code tells Facebook that the conversion event has occurred. Facebook then matches that conversion event against the set of people an ad was served to/or that clicked on an ad so that we can provide you with information that helps understand the return on investment for your ad spend.
 * 
 * <p><a href="https://www.facebook.com/help/373979379354234">Learn more about conversion pixels.</a>
 * 
 * @author ceefour
 * @see FacebookSysConfig#getFacebookPixelEnabled()
 * @see FacebookSysConfig#getFacebookPixelId()
 */
@SuppressWarnings("serial")
public class FacebookPixelBehavior extends Behavior {

	private static final Logger log = LoggerFactory
			.getLogger(FacebookPixelBehavior.class);
	
	@SpringBean(required=false)
	private FacebookSysConfig facebookSysConfig;
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		if (Optional.fromNullable(facebookSysConfig.getFacebookPixelEnabled()).or(false)) {
			// Google Analytics is required for server timing
			if (facebookSysConfig.getFacebookPixelId() != null) {
				final String script =
						"<script>(function() {\n"
						+ "var _fbq = window._fbq || (window._fbq = []);\n"
						+ "if (!_fbq.loaded) {\n"
						+ "var fbds = document.createElement('script');\n"
						+ "fbds.async = true;\n"
						+ "fbds.src = '//connect.facebook.net/en_US/fbds.js';\n"
						+ "var s = document.getElementsByTagName('script')[0];\n"
						+ "s.parentNode.insertBefore(fbds, s);\n"
						+ "_fbq.loaded = true;\n"
						+ "}\n"
						+ "_fbq.push(['addPixelId', '" + facebookSysConfig.getFacebookPixelId() + "']);\n"
						+ "})();\n"
						+ "window._fbq = window._fbq || [];\n"
						+ "window._fbq.push(['track', 'PixelInitialized', {}]);\n"
						+ "</script>\n"
						+ "<noscript><img height=\"1\" width=\"1\" alt=\"\" style=\"display:none\" src=\"https://www.facebook.com/tr?id=" + facebookSysConfig.getFacebookPixelId() + "&amp;ev=PixelInitialized\" /></noscript>";
				// do not put in footer-container, so we use StringHeaderItem instead of JavaScriptHeaderItem
				// to "fool" de.agilecoders.wicket.core.markup.html.RenderJavaScriptToFooterHeaderResponseDecorator
				response.render(StringHeaderItem.forString(script));
			} else {
				log.warn("Incomplete configuration: facebookPixelEnabled is set but facebookPixelId is empty");
			}
		}
	}
	
}
