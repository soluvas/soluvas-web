package org.soluvas.web.bootstrap;

import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.soluvas.web.site.AfterJQueryJavaScriptResourceReference;
import org.soluvas.web.site.AfterJQueryUrlResourceReference;

import de.agilecoders.wicket.core.Bootstrap;

/**
 * @todo Submit v1.1 to cdnjs/jsdelivr
 * @author ceefour
 */
public class TinyNavJs {

	private static final JavaScriptResourceReference JS = new AfterJQueryJavaScriptResourceReference(TinyNavJs.class, "tinynav-1.05/tinynav.js");
	private static final UrlResourceReference CDN = new AfterJQueryUrlResourceReference("//cdn.jsdelivr.net/tinynav/1.05/tinynav.min.js");
	
	public static ResourceReference instance() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return CDN;
		} else {
			return JS;
		}
	}
	
}
