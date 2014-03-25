package org.soluvas.web.googleanalytics;

import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;
import org.apache.wicket.response.filter.IResponseFilter;
import org.apache.wicket.util.string.AppendingStringBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

/**
 * Sends the server request processing time (response time) via <a href="https://developers.google.com/analytics/devguides/collection/analyticsjs/user-timings">Google Analytics User Timings</a>.
 * 
 * <p>Note that your pages must have Google Analytics enabled, otherwise you'll get JavaScript error.
 * 
 * <p>Also logs warn if page processing is slow.
 * 
 * <p>Usage in {@link WebApplication#init()}:
 * 
 * <pre>getRequestCycleSettings().addResponseFilter(new GoogleAnalyticsServerTimingFilter());</pre>
 * 
 * @author ceefour
 * @see AjaxServerAndClientTimeFilter
 */
public class GoogleAnalyticsServerTimingFilter implements IResponseFilter {
	
	private static final Logger log = LoggerFactory
			.getLogger(GoogleAnalyticsServerTimingFilter.class);
	/**
	 * Threshold for slow request in milliseconds.
	 */
	public static final int SLOW_REQUEST_MS = 1000;
	private static NumberFormat numberFormat = NumberFormat.getNumberInstance();

	/* (non-Javadoc)
	 * @see org.apache.wicket.response.filter.IResponseFilter#filter(org.apache.wicket.util.string.AppendingStringBuffer)
	 */
	@Override
	public AppendingStringBuffer filter(AppendingStringBuffer responseBuffer) {
		long timeTaken = System.currentTimeMillis() - RequestCycle.get().getStartTime();
		int bodyIndex = responseBuffer.lastIndexOf("</body>");
		if (bodyIndex != -1) {
			final String script = "\n<script>ga('send', 'timing', 'server', 'Server processing', " + timeTaken + ");</script>\n";
			responseBuffer.insert(bodyIndex - 1, script);
		}
		final HttpServletRequest req = (HttpServletRequest) RequestCycle.get().getRequest().getContainerRequest();
		final String xForwardedFor = req.getHeader("X-Forwarded-For");
		final String remoteIp = Optional.fromNullable(xForwardedFor).or(req.getRemoteAddr());

		if (timeTaken > SLOW_REQUEST_MS) {
			log.warn("Slow {}ms server time taken for {} request \"{}\" ({} KiB)",
					timeTaken, remoteIp, RequestCycle.get().getRequest().getUrl(), numberFormat.format(responseBuffer.length() / 1024));
		} else {
			log.debug("{}ms server time taken for {} request \"{}\" ({} KiB)",
					timeTaken, remoteIp, RequestCycle.get().getRequest().getUrl(), numberFormat.format(responseBuffer.length() / 1024));
		}
		return responseBuffer;
	}

}
