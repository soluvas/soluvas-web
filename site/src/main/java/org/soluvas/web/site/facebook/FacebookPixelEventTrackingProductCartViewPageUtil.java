package org.soluvas.web.site.facebook;

import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.socmed.FacebookSysConfig;

/**
 *Render firt in head for {@link FacebookPixelBehavior}
 * 
 * @author ceefour
 * @see FacebookSysConfig#getFacebookPixelEnabled()
 * @see FacebookSysConfig#getFacebookPixelId()
 */
public class FacebookPixelEventTrackingProductCartViewPageUtil {

	private static final Logger log = LoggerFactory
			.getLogger(FacebookPixelEventTrackingProductCartViewPageUtil.class);
	
	public static OnDomReadyHeaderItem get() {
		
		final String script = "fbq('track', 'InitiateCheckout');";
		
		return OnDomReadyHeaderItem.forScript(script);
	}
	
}
