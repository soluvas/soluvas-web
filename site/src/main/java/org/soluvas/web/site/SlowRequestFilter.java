package org.soluvas.web.site;

import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;
import org.apache.wicket.response.filter.IResponseFilter;
import org.apache.wicket.util.string.AppendingStringBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.google.GoogleAnalyticsServerTimingFilter;

import com.google.common.base.Optional;

/**
 * Logs {@link Logger#warn(String)} if page processing is slow ({@value #SLOW_REQUEST_MS} ms).
 * 
 * <p>Usage in {@link WebApplication#init()}:
 * 
 * <pre>getRequestCycleSettings().addResponseFilter(new SlowRequestFilter());</pre>
 * 
 * @author ceefour
 * @see GoogleAnalyticsServerTimingFilter
 * @see AjaxServerAndClientTimeFilter
 */
public class SlowRequestFilter implements IResponseFilter {
	
	private static final Logger log = LoggerFactory
			.getLogger(SlowRequestFilter.class);
	/**
	 * Threshold for slow request in milliseconds.
	 */
	public static final int SLOW_REQUEST_MS = 2000;
	private static NumberFormat numberFormat = NumberFormat.getNumberInstance();

	/* (non-Javadoc)
	 * @see org.apache.wicket.response.filter.IResponseFilter#filter(org.apache.wicket.util.string.AppendingStringBuffer)
	 */
	@Override
	public AppendingStringBuffer filter(AppendingStringBuffer responseBuffer) {
		long timeTaken = System.currentTimeMillis() - RequestCycle.get().getStartTime();
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
