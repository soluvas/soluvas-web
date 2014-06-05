package org.soluvas.web.bootstrap;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

/**
 * @deprecated Please use Wicket's
 * @author rio
 */
@Deprecated
public class RequireJs {
	public static final JavaScriptResourceReference INSTANCE = new JavaScriptResourceReference(RequireJs.class, "require-2.1.5-soluvas.js");
}
