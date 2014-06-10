package org.soluvas.web.site.metrics;

import javax.servlet.ServletRequest;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;
import org.apache.wicket.response.filter.IResponseFilter;
import org.apache.wicket.util.string.AppendingStringBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.metrics.ThreadMetricsConfig;
import org.soluvas.web.site.SlowRequestFilter;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Sends the server request processing time (response time) via <a href="https://developers.google.com/analytics/devguides/collection/analyticsjs/user-timings">Google Analytics User Timings</a>.
 * 
 * <p>Note that your pages must have Google Analytics enabled, otherwise you'll get JavaScript error.
 * 
 * <p>Usage: Make sure you {@link Import} {@link ThreadMetricsConfig}, then in {@link WebApplication#init()}:
 * 
 * <pre>getRequestCycleSettings().addResponseFilter(new GoogleAnalyticsServerTimingFilter());</pre>
 * 
 * <p>See <a href="https://productforums.google.com/d/msg/analytics/5ueetejZ6Wc/ZeqmTZJNfSgJ">Track CPU and Memory Usage with Google Analytics</a>
 * and <a href="https://developers.google.com/analytics/devguides/collection/analyticsjs/events">Event Tracking with analytics.js</a>.
 * 
 * @author ceefour
 * @see SlowRequestFilter
 * @see AjaxServerAndClientTimeFilter
 */
public class ThreadMetricsFilter implements IResponseFilter {
	
	private static final Logger log = LoggerFactory
			.getLogger(ThreadMetricsFilter.class);
	
	/* (non-Javadoc)
	 * @see org.apache.wicket.response.filter.IResponseFilter#filter(org.apache.wicket.util.string.AppendingStringBuffer)
	 */
	@Override
	public AppendingStringBuffer filter(AppendingStringBuffer responseBuffer) {
		final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
				((ServletRequest) RequestCycle.get().getRequest().getContainerRequest()).getServletContext());
		final ThreadMetricsConfig config = appCtx.getBean(ThreadMetricsConfig.class);
		
//		long timeTaken = System.currentTimeMillis() - RequestCycle.get().getStartTime();
//		int analyticsIndex = responseBuffer.indexOf("//www.google-analytics.com/analytics.js");
//		if (analyticsIndex >= 0) {
//			int bodyIndex = responseBuffer.lastIndexOf("</body>");
//			if (bodyIndex >= 0) {
//				final String script = "\n<script>ga('send', 'timing', 'server', 'Server processing', " + timeTaken + ");</script>\n";
//				responseBuffer.insert(bodyIndex - 1, script);
//			}
//		} else {
//			log.debug("Google Analytics not detected in HTML response, skipping Google Analytics server timing reporting");
//		}

		return responseBuffer;
	}

}
