package org.soluvas.web.site.metrics;

import java.lang.management.ManagementFactory;
import java.text.NumberFormat;
import java.util.Locale;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;

import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.response.filter.IResponseFilter;
import org.apache.wicket.util.string.AppendingStringBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.metrics.ThreadMetricsConfig;
import org.soluvas.web.googleanalytics.GoogleAnalyticsServerTimingFilter;
import org.springframework.context.annotation.Import;

/**
 * Sends the server request processing time (response time) via <a href="https://developers.google.com/analytics/devguides/collection/analyticsjs/user-timings">Google Analytics User Timings</a>.
 * 
 * <p>Note that your pages must have Google Analytics enabled, otherwise you'll get JavaScript error.
 * 
 * <p>Usage: Make sure you {@link Import} {@link ThreadMetricsConfig}, then in {@link WebApplication#init()}:
 * 
 * <p>Usage in {@link WebApplication#init()}:
 * 
 * <pre>
 * if (threadMetricsConfig.isEnabled()) {
 * 	getRequestCycleListeners().add(new ThreadMetricsRequestCycleListener());
 * 	getRequestCycleSettings().addResponseFilter(new ThreadMetricsFilter());
 * }
 * </pre>
 * 
 * <p>See <a href="https://productforums.google.com/d/msg/analytics/5ueetejZ6Wc/ZeqmTZJNfSgJ">Track CPU and Memory Usage with Google Analytics</a>
 * and <a href="https://developers.google.com/analytics/devguides/collection/analyticsjs/events">Event Tracking with analytics.js</a>.
 * 
 * @author ceefour
 * @see ThreadMetricsRequestCycleListener
 * @see ThreadMetricsConfig
 * @see GoogleAnalyticsServerTimingFilter
 */
public class ThreadMetricsFilter implements IResponseFilter {
	
	/**
	 * {@link Logger#warn(String)} if thread memory usage is equal or above this KiB.
	 */
	public static long ALLOCATED_THRESHOLD_KIB = 100 * 1024;
	
	private static final Logger log = LoggerFactory
			.getLogger(ThreadMetricsFilter.class);
	private static NumberFormat NUMBER_FORMAT = NumberFormat.getNumberInstance(Locale.ENGLISH);
	
	/* (non-Javadoc)
	 * @see org.apache.wicket.response.filter.IResponseFilter#filter(org.apache.wicket.util.string.AppendingStringBuffer)
	 */
	@SuppressWarnings("restriction")
	@Override
	public AppendingStringBuffer filter(AppendingStringBuffer responseBuffer) {
		final long threadId = Thread.currentThread().getId();
		final long startCpuTime;
		final long startUserTime;
		final long startAllocatedBytes;
		try {
			startCpuTime = ThreadMetricsRequestCycleListener.startCpuTime.get();
			startUserTime = ThreadMetricsRequestCycleListener.startUserTime.get();
			startAllocatedBytes = ThreadMetricsRequestCycleListener.startAllocatedBytes.get();
//				log.debug("Thread #{} {} start cputime={}ms usertime={}ms mem={}KiB", threadId, Thread.currentThread().getName(),
//						startCpuTime / 1000000, startUserTime / 1000000, startAllocatedBytes / 1024);
		} catch (NullPointerException e) {
			log.warn("startCpuTime/startUserTime/startAllocatedBytes is null. Have you added ThreadMetricsRequestCycleListener?");
			return responseBuffer;
		}
		final com.sun.management.ThreadMXBean threadMx = (com.sun.management.ThreadMXBean) ManagementFactory.getThreadMXBean();
		final long curCpuTime = threadMx.getThreadCpuTime(threadId);
		final long curUserTime = threadMx.getThreadUserTime(threadId);
		final long curAllocatedBytes = threadMx.getThreadAllocatedBytes(threadId);
//			log.debug("Thread #{} {} current cputime={}ms usertime={}ms mem={}KiB", threadId, Thread.currentThread().getName(),
//					curCpuTime / 1000000, curUserTime / 1000000, curAllocatedBytes / 1024);
		final long cpuTimeMs = (curCpuTime - startCpuTime) / 1000000;
		final long userTimeMs = (curUserTime - startUserTime) / 1000000;
		final long allocatedKib = (curAllocatedBytes - startAllocatedBytes) / 1024;
		final RequestCycle cycle = RequestCycle.get();
		final long elapsedTimeMs = System.currentTimeMillis() - cycle.getStartTime();
		final String requestUri = ((HttpServletRequest) cycle.getRequest().getContainerRequest()).getRequestURI();
		@Nullable
		final String path = cycle.getRequest().getUrl() != null ? cycle.getRequest().getUrl().getPath() : null;
		final String eventLabel;
		if (path != null) {
			@Nullable
			final Class<?> pageClassForPath = ThreadMetricsRequestCycleListener.pageClassForPath.get(path);
			if (pageClassForPath != null) {
				eventLabel = pageClassForPath.getSimpleName()
						.replaceFirst("Page$", "");
			} else {
				eventLabel = "(N/A)";
			}
		} else {
			eventLabel = "(N/A)";
		}
//		final String eventLabel = ThreadMetricsRequestCycleListener.handlerOrPageClass.get() != null ?
//				ThreadMetricsRequestCycleListener.handlerOrPageClass.get().getName() : "null";
		if (allocatedKib >= ALLOCATED_THRESHOLD_KIB) {
			log.warn("Too much memory usage: Thread {} {} #{} {} mem={}KiB cputime={}ms usertime={}ms elapsed={}ms", 
					eventLabel, requestUri,
					threadId, Thread.currentThread().getName(),
					NUMBER_FORMAT.format(allocatedKib), 
					NUMBER_FORMAT.format(cpuTimeMs), NUMBER_FORMAT.format(userTimeMs), NUMBER_FORMAT.format(elapsedTimeMs));
		} else {
			log.debug("Thread {} {} #{} {} mem={}KiB cputime={}ms usertime={}ms elapsed={}ms", 
					eventLabel, requestUri,
					threadId, Thread.currentThread().getName(),
					allocatedKib, cpuTimeMs, userTimeMs, elapsedTimeMs);
		}
		
		// cleanup
		ThreadMetricsRequestCycleListener.startCpuTime.remove();
		ThreadMetricsRequestCycleListener.startUserTime.remove();
		ThreadMetricsRequestCycleListener.startAllocatedBytes.remove();
//		ThreadMetricsRequestCycleListener.handlerOrPageClass.remove();

		// send to Google Analytics
		int analyticsIndex = responseBuffer.indexOf("//www.google-analytics.com/analytics.js");
		if (analyticsIndex >= 0) {
			int bodyIndex = responseBuffer.lastIndexOf("</body>");
			if (bodyIndex >= 0) {
				String script = "\n<script>\n";
				script += "ga('send', 'timing', 'cputime', 'CPU Time', " + cpuTimeMs + ");\n";
				script += "ga('send', 'timing', 'usertime', 'User Time', " + userTimeMs + ");\n";
				script += "ga('send', 'event', 'server', 'mem', " + JSONObject.quote(eventLabel) + ", " + allocatedKib + ", {nonInteraction: 1});\n";
				script += "ga('send', 'event', 'server', 'cputime', " + JSONObject.quote(eventLabel) + ", " + cpuTimeMs + ", {nonInteraction: 1});\n";
				script += "ga('send', 'event', 'server', 'usertime', " + JSONObject.quote(eventLabel) + ", " + userTimeMs + ", {nonInteraction: 1});\n";
				script += "ga('send', 'event', 'server', 'elapsedtime', " + JSONObject.quote(eventLabel) + ", " + elapsedTimeMs + ", {nonInteraction: 1});\n";
				// Note: Custom metrics are not (yet?) average-able :( http://stackoverflow.com/a/19460632/122441
				// Metric 1: Allocated (KiB). 0..2000000
				script += "ga('set', 'metric1', " + allocatedKib + ");\n";
				// Metric 2: CPU Time (ms) 0..30000
				script += "ga('set', 'metric2', " + cpuTimeMs + ");\n";
				// Metric 3: User Time (ms) 0..30000
				script += "ga('set', 'metric3', " + userTimeMs + ");\n";
				// Metric 4: Elapsed Time (ms) 0..30000
				script += "ga('set', 'metric4', " + elapsedTimeMs + ");\n";
				script += "</script>\n";
				responseBuffer.insert(bodyIndex - 1, script);
			}
		} else {
			log.trace("Google Analytics not detected in HTML response, skipping Google Analytics thread metrics reporting");
		}
		
		return responseBuffer;
	}

}
