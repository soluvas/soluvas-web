package org.soluvas.web.bootstrap;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class TinyNavJs {

	/**
	 * TODO: how to use .min.js in Wicket resource mechanism? 
	 */
	public static final JavaScriptResourceReference INSTANCE = new JavaScriptResourceReference(TinyNavJs.class, "tinynav.js");
	
}
