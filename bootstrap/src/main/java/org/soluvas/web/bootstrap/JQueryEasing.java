package org.soluvas.web.bootstrap;

import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.soluvas.web.site.AfterJQueryJavaScriptResourceReference;
import org.soluvas.web.site.AfterJQueryUrlResourceReference;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * Latest jQuery easing (no compatibility with old easing names).
 * @author rio
 */
public class JQueryEasing {

	private static final JavaScriptResourceReference EASING = new AfterJQueryJavaScriptResourceReference(
			JQueryEasing.class, "jquery.easing-1.3/jquery.easing.1.3.js");
	private static final UrlResourceReference EASING_CDN = new AfterJQueryUrlResourceReference(
			"//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js");
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static ResourceReference instance() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return EASING_CDN;
		} else {
			return EASING;
		}
	}
	
}

