package org.soluvas.web.bootstrap.wysihtml;

import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * <a href="https://github.com/Edicy/wysihtml5">Wysihtml5 0.4.2+</a>
 * @author anton
 */
public class Wysihtml {

	private static final JavaScriptResourceReference WYSIHTML5X = new JQueryPluginResourceReference(
			Wysihtml.class, "wysihtml5x.js");
	private static final JavaScriptResourceReference WYSIHTML5X_MIN = new JQueryPluginResourceReference(
			Wysihtml.class, "wysihtml5x.min.js");
	private static final JavaScriptResourceReference WYSIHTML5X_TOOLBAR = new JQueryPluginResourceReference(
			Wysihtml.class, "wysihtml5x-toolbar.js");
	private static final JavaScriptResourceReference WYSIHTML5X_TOOLBAR_MIN = new JQueryPluginResourceReference(
			Wysihtml.class, "wysihtml5x-toolbar.min.js");
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static JavaScriptHeaderItem core() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return JavaScriptHeaderItem.forReference(WYSIHTML5X_MIN);
		} else {
			return JavaScriptHeaderItem.forReference(WYSIHTML5X);
		}
	}

	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static JavaScriptHeaderItem toolbar() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return JavaScriptHeaderItem.forReference(WYSIHTML5X_TOOLBAR_MIN);
		} else {
			return JavaScriptHeaderItem.forReference(WYSIHTML5X_TOOLBAR);
		}
	}

}
