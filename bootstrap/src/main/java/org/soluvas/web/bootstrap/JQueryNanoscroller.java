package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.references.JQueryPluginUrlResourceReference;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * jQuery nanoscroller 0.8.4.
 * @author ceefour
 * @see http://cdnjs.com/libraries/jquery.nanoscroller
 */
public class JQueryNanoscroller {

	private static final CssResourceReference NANOSCROLLER_CSS = new CssResourceReference(
			JQueryNanoscroller.class, "jquery.nanoscroller-0.8.4/nanoscroller.css");
	private static final JavaScriptResourceReference NANOSCROLLER = new JQueryPluginResourceReference(
			JQueryNanoscroller.class, "jquery.nanoscroller-0.8.4/jquery.nanoscroller.min.js");
	private static final UrlResourceReference NANOSCROLLER_CSS_CDN = new UrlResourceReference(
			Url.parse("//cdnjs.cloudflare.com/ajax/libs/jquery.nanoscroller/0.8.4/css/nanoscroller.css"));
	private static final UrlResourceReference NANOSCROLLER_CDN = new JQueryPluginUrlResourceReference(
			Url.parse("//cdnjs.cloudflare.com/ajax/libs/jquery.nanoscroller/0.8.4/javascripts/jquery.nanoscroller.min.js"));
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 */
	public static void renderHead(IHeaderResponse response) {
		if (Bootstrap.getSettings().useCdnResources()) {
			response.render(CssHeaderItem.forReference(NANOSCROLLER_CSS_CDN));
			response.render(JavaScriptHeaderItem.forReference(NANOSCROLLER_CDN));
		} else {
			response.render(CssHeaderItem.forReference(NANOSCROLLER_CSS));
			response.render(JavaScriptHeaderItem.forReference(NANOSCROLLER));
		}
		
	}
	
}

