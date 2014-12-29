package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * <a href="https://github.com/devote/HTML5-History-API">HTML5 History API polyfill</a>.
 * @author anton
 */
public class Html5HistoryApi {

	public static final JavaScriptResourceReference HTML5_HISTORY_API = 
			new JQueryPluginResourceReference(Html5HistoryApi.class, "html5-history-api/history.min.js");
//	private static final UrlResourceReference SCROLLTO_CDN = new JQueryPluginUrlResourceReference(
//			Url.parse("//cdnjs.cloudflare.com/ajax/libs/jquery-scrollTo/1.4.11/jquery.scrollTo.min.js"));
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static ResourceReference instance() {
//		if (Bootstrap.getSettings().useCdnResources()) {
//			return SCROLLTO_CDN;
//		} else {
			return HTML5_HISTORY_API;
//		}
	}
	
	public static JavaScriptHeaderItem asHeaderItem() {
		return JavaScriptHeaderItem.forReference(instance());
	}

}
