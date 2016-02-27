package org.soluvas.web.site;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * Temporary fix before Wicket 7.3.0.
 * Created by ceefour on 27/02/2016.
 */
public class JQueryFix1_12_1 {
    public static void apply(WebApplication app) {
        app.getJavaScriptLibrarySettings().setJQueryReference(
                new JavaScriptResourceReference(JQueryFix1_12_1.class, "jquery-1.12.1.min.js")
        );
    }
}
