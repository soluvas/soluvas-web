package org.soluvas.web.bootstrap;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.references.JQueryPluginUrlResourceReference;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;

/**
 * Latest jQuery easing (no compatibility with old easing names).
 * @author rio
 */
public class JQueryEasing {

	private static final JavaScriptResourceReference EASING = new JQueryPluginResourceReference(
			JQueryEasing.class, "jquery.easing-1.3/jquery.easing.1.3.js");
	private static final UrlResourceReference EASING_CDN = new JQueryPluginUrlResourceReference(
			Url.parse("//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"));
	
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
	
	public static JavaScriptHeaderItem asHeaderItem() {
		return JavaScriptHeaderItem.forReference(instance());
	}
	
}

