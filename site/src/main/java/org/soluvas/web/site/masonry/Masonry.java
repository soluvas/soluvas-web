package org.soluvas.web.site.masonry;

import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * jQuery Masonry.
 * @author ceefour
 */
public class Masonry {

	public static final JavaScriptResourceReference JS_LIBRARY = new JavaScriptResourceReference(Masonry.class, "jquery.masonry-2.1.08.js");
	public static final CssResourceReference CSS_TRANSITIONS = new CssResourceReference(Masonry.class, "masonry-transitions.css");
	
}
