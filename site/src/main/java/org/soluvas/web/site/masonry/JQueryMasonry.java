package org.soluvas.web.site.masonry;

import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.soluvas.web.site.AfterJQueryJavaScriptResourceReference;

/**
 * <a href="http://masonry.desandro.com/">jQuery Masonry</a>.
 * @author ceefour
 */
public class JQueryMasonry {

	public static final JavaScriptResourceReference JS = 
			new AfterJQueryJavaScriptResourceReference(JQueryMasonry.class, "jquery.masonry-2.1.08.js");
	public static final CssResourceReference TRANSITIONS_CSS = new CssResourceReference(JQueryMasonry.class, "masonry-transitions.css");
	
}
