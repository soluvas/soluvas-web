/**
 * 
 */
package org.soluvas.web.bootstrap.bootstrap3wysihtml5v2;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.soluvas.web.bootstrap.AfterBootstrapCssResourceReference;
import org.soluvas.web.bootstrap.AfterBootstrapJavaScriptResourceReference;

/**
 * 
 * Files to reference:
 * <link rel="stylesheet" type="text/css" href="lib/css/bootstrap.min.css" /> <!-- Please use the newest Version of Bootstrap 3.0.X -->
<link rel="stylesheet" type="text/css" href="src/bootstrap3-wysihtml5.css" />
<link rel="stylesheet" type="text/css" href="src/bootstrap3-wysihtml5-editor.css" />
<script src="lib/js/jquery-1.11.1.min.js"></script>
<script src="lib/js/bootstrap.min.js"></script>
<script src="lib/js/wysihtml5x-toolbar.min.js"></script>
<script src="src/bootstrap3-wysihtml5.min.js"></script>
 * 
 * @author rudi
 *
 */
public class Bootstrap3Wysihtml5v2 {
	
	public static final CssHeaderItem CSS_BOOTSTRAP3_WYSIHTML5 = CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(
			Bootstrap3Wysihtml5v2.class, "bootstrap3-wysihtml5.css"));
	public static final CssHeaderItem CSS_BOOTSTRAP3_WYSIHTML5_EDITOR = CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(
			Bootstrap3Wysihtml5v2.class, "bootstrap3-wysihtml5-editor.css"));
	
	public static final JavaScriptHeaderItem WYSIHTML5X_TOOLBAR_MIN = JavaScriptHeaderItem.forReference(new AfterBootstrapJavaScriptResourceReference(
			Bootstrap3Wysihtml5v2.class, "wysihtml5x-toolbar.min.js"));
	public static final JavaScriptHeaderItem BOOTSTRAP3_WYSIHTML5_MIN = JavaScriptHeaderItem.forReference(new AfterBootstrapJavaScriptResourceReference(
			Bootstrap3Wysihtml5v2.class, "bootstrap3-wysihtml5.min.js"));
	
	
	
}
