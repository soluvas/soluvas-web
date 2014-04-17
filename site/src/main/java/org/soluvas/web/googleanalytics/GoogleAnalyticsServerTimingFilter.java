package org.soluvas.web.googleanalytics;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;
import org.apache.wicket.response.filter.IResponseFilter;
import org.apache.wicket.util.string.AppendingStringBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.SlowRequestFilter;

/**
 * Sends the server request processing time (response time) via <a href="https://developers.google.com/analytics/devguides/collection/analyticsjs/user-timings">Google Analytics User Timings</a>.
 * 
 * <p>Note that your pages must have Google Analytics enabled, otherwise you'll get JavaScript error.
 * 
 * <p>Usage in {@link WebApplication#init()}:
 * 
 * <pre>getRequestCycleSettings().addResponseFilter(new GoogleAnalyticsServerTimingFilter());</pre>
 * 
 * @author ceefour
 * @see SlowRequestFilter
 * @see AjaxServerAndClientTimeFilter
 */
public class GoogleAnalyticsServerTimingFilter implements IResponseFilter {
	
	private static final Logger log = LoggerFactory
			.getLogger(GoogleAnalyticsServerTimingFilter.class);
	
	/* (non-Javadoc)
	 * @see org.apache.wicket.response.filter.IResponseFilter#filter(org.apache.wicket.util.string.AppendingStringBuffer)
	 */
	@Override
	public AppendingStringBuffer filter(AppendingStringBuffer responseBuffer) {
		long timeTaken = System.currentTimeMillis() - RequestCycle.get().getStartTime();
		int analyticsIndex = responseBuffer.indexOf("//www.google-analytics.com/analytics.js");
		if (analyticsIndex >= 0) {
			int bodyIndex = responseBuffer.lastIndexOf("</body>");
			if (bodyIndex >= 0) {
				final String script = "\n<script>ga('send', 'timing', 'server', 'Server processing', " + timeTaken + ");</script>\n";
				responseBuffer.insert(bodyIndex - 1, script);
			}
		} else {
			log.debug("Google Analytics not detected in HTML response, skipping Google Analytics server timing reporting");
		}
		return responseBuffer;
	}

}
