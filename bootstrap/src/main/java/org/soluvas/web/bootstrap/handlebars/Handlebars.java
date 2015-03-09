package org.soluvas.web.bootstrap.handlebars;

import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.references.JQueryPluginUrlResourceReference;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * <a href=http://handlebarsjs.com/">Handlebars.js</a>
 * @author anton
 */
public class Handlebars {

	private static final JavaScriptResourceReference HANDLEBARS = new JQueryPluginResourceReference(
			Handlebars.class, "handlebars-v3.0.0.js");
	private static final UrlResourceReference HANDLEBARS_CDN = new JQueryPluginUrlResourceReference(
			Url.parse("//cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"));
	private static final JavaScriptResourceReference HANDLEBARS1 = new JQueryPluginResourceReference(
			Handlebars.class, "handlebars-v1.3.0.js");
	private static final UrlResourceReference HANDLEBARS1_CDN = new JQueryPluginUrlResourceReference(
			Url.parse("//cdnjs.cloudflare.com/ajax/libs/handlebars.js/1.3.0/handlebars.min.js"));
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static ResourceReference instance() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return HANDLEBARS_CDN;
		} else {
			return HANDLEBARS;
		}
	}
	
	public static JavaScriptHeaderItem asHeaderItem() {
		return JavaScriptHeaderItem.forReference(instance());
	}
	
	/**
	 * Handlebars v1.3.0. Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static ResourceReference instance_v1() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return HANDLEBARS1_CDN;
		} else {
			return HANDLEBARS1;
		}
	}
	
	/**
	 * Handlebars v1.3.0.
	 * @return
	 */
	public static JavaScriptHeaderItem asHeaderItem_v1() {
		return JavaScriptHeaderItem.forReference(instance_v1());
	}
	
}
