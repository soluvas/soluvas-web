package org.soluvas.web.bootstrap.bootstrap3wysihtml5v2;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.soluvas.web.bootstrap.AfterBootstrapCssResourceReference;
import org.soluvas.web.bootstrap.AfterBootstrapJavaScriptResourceReference;

/**
 * 
 * Files to reference:
 * <link rel="stylesheet" type="text/css" href="lib/css/bootstrap.min.css" /> <!-- Please use the newest Version of Bootstrap 3.0.X -->
<link rel="stylesheet" type="text/css" href="src/bootstrap3-wysihtml5.css" />
<link rel="stylesheet" type="text/css" href="src/bootstrap3-wysihtml5-editor.css" />
&lt;script src="lib/js/jquery-1.11.1.min.js"></script>
&lt;script src="lib/js/bootstrap.min.js"></script>
&lt;script src="lib/js/wysihtml5x-toolbar.min.js"></script>
&lt;script src="src/bootstrap3-wysihtml5.min.js"></script>
 * 
 * 
 * https://github.com/Waxolunist/bootstrap3-wysihtml5-bower/
 * @author rudi
 *
 */
public class Bootstrap3Wysihtml5v2 {
	
	public static final CssReferenceHeaderItem WYSIWYG_COLOR_CSS = CssHeaderItem.forReference(
			new AfterBootstrapCssResourceReference(Bootstrap3Wysihtml5v2.class, "wysiwyg-color.css"));
	
	public static final CssReferenceHeaderItem BOOTSTRAP3_WYSIHTML5_MIN_CSS = CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(
			Bootstrap3Wysihtml5v2.class, "bootstrap3-wysihtml5.min.css"));
	
	public static final JavaScriptHeaderItem BOOTSTRAP3_WYSIHTML5_MIN = JavaScriptHeaderItem.forReference(new AfterBootstrapJavaScriptResourceReference(
			Bootstrap3Wysihtml5v2.class, "bootstrap3-wysihtml5.min.js"));
	
	public static final JavaScriptHeaderItem BOOTSTRAP3_WYSIHTML5_ALL_MIN = JavaScriptHeaderItem.forReference(new AfterBootstrapJavaScriptResourceReference(
			Bootstrap3Wysihtml5v2.class, "bootstrap3-wysihtml5.all.min.js"));
	
}
