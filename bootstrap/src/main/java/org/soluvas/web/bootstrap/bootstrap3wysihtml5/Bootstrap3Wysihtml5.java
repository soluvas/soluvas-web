/**
 * 
 */
package org.soluvas.web.bootstrap.bootstrap3wysihtml5;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.soluvas.web.bootstrap.AfterBootstrapCssResourceReference;
import org.soluvas.web.bootstrap.AfterBootstrapJavaScriptResourceReference;
import org.soluvas.web.bootstrap.handlebars.Handlebars;
import org.soluvas.web.bootstrap.wysihtml.Wysihtml;

import com.google.common.collect.ImmutableList;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * <a href="http://bootstrap-wysiwyg.github.io/bootstrap3-wysiwyg/">bootstrap3-wysiwyg</a>
 * 
 * <p>Sample usage in {@code advanced-form.js}:
 * 
 * <pre>
 * //wysihtml5 start
 * 
 * // Bippo hack to workaround missing CSS since JavaScript doesn't know the (WicketResource) location of the CSS file
 * $('.wysihtml5').wysihtml5({color: true,
 * 	stylesheets: ['/wicket/resource/id.co.bippo.web.mall.BackendPage/assets/bootstrap-wysihtml5/wysiwyg-color.css']});
 * 
 * //wysihtml5 end
 * </pre>
 * 
 * @author anton
 */
public class Bootstrap3Wysihtml5 {

	private static final CssResourceReference BOOTSTRAP3_WYSIHTML5_CSS = new AfterBootstrapCssResourceReference(
			Bootstrap3Wysihtml5.class, "bootstrap3-wysihtml5.css");
	private static final CssResourceReference BOOTSTRAP3_WYSIHTML5_MIN_CSS = new AfterBootstrapCssResourceReference(
			Bootstrap3Wysihtml5.class, "bootstrap3-wysihtml5.min.css");
	// Requires templates.js + English locale
//	private static final JavaScriptResourceReference BOOTSTRAP3_WYSIHTML5 = new AfterBootstrapJavaScriptResourceReference(
//			Bootstrap3Wysihtml5.class, "bootstrap3-wysihtml5.js") {
//		@Override
//		public Iterable<? extends HeaderItem> getDependencies() {
//			return ImmutableList.of(
//					CssHeaderItem.forReference(BOOTSTRAP3_WYSIHTML5_CSS),
//					Handlebars.asHeaderItem_v1(), Wysihtml.toolbar());
//		}
//	};
	private static final JavaScriptResourceReference BOOTSTRAP3_WYSIHTML5_MIN = new AfterBootstrapJavaScriptResourceReference(
			Bootstrap3Wysihtml5.class, "bootstrap3-wysihtml5.min.js") {
		@Override
		public Iterable<? extends HeaderItem> getDependencies() {
			return ImmutableList.of(
					CssHeaderItem.forReference(BOOTSTRAP3_WYSIHTML5_MIN_CSS),
					Handlebars.asHeaderItem_v1(), Wysihtml.toolbar());
		}
	};
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static JavaScriptHeaderItem asHeaderItem() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return JavaScriptHeaderItem.forReference(BOOTSTRAP3_WYSIHTML5_MIN);
		} else {
			return JavaScriptHeaderItem.forReference(BOOTSTRAP3_WYSIHTML5_MIN);
		}
	}
	
}
