/**
 * 
 */
package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;
import org.soluvas.web.site.AfterJQueryUrlResourceReference;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * <a href="http://flesler.blogspot.com">jQuery ScrollTo</a>.
 * @author anton
 */
public class JQueryScrollTo {

	public static final JavaScriptResourceReference SCROLLTO = 
			new JQueryPluginResourceReference(JQueryScrollTo.class, "scrollTo/jquery.scrollTo.min.js");
	private static final UrlResourceReference SCROLLTO_CDN = new AfterJQueryUrlResourceReference(
			"//cdnjs.cloudflare.com/ajax/libs/jquery-scrollTo/1.4.11/jquery.scrollTo.min.js");
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static ResourceReference instance() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return SCROLLTO_CDN;
		} else {
			return SCROLLTO;
		}
	}
	
	public static JavaScriptHeaderItem asHeaderItem() {
		return JavaScriptHeaderItem.forReference(instance());
	}

}
