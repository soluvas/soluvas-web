package org.soluvas.web.site.masonry;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.resource.JQueryPluginResourceReference;

import com.google.common.collect.ImmutableList;

/**
 * <a href="http://masonry.desandro.com/">jQuery Masonry</a>.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JQueryMasonry {

	public static final JavaScriptResourceReference JS = 
			new JQueryPluginResourceReference(JQueryMasonry.class, "jquery.masonry-2.1.08.js");
	public static final UrlResourceReference JS_CDN =
			new UrlResourceReference(Url.parse("//cdnjs.cloudflare.com/ajax/libs/masonry/2.1.08/jquery.masonry.min.js")) {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	public static final CssResourceReference TRANSITIONS_CSS = new CssResourceReference(JQueryMasonry.class, "masonry-transitions.css");
	
}
