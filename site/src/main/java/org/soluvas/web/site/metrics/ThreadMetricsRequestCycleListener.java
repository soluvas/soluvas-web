package org.soluvas.web.site.metrics;

import java.lang.management.ManagementFactory;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Nullable;

import org.apache.wicket.MetaDataKey;
import org.apache.wicket.core.request.handler.IPageClassRequestHandler;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.metrics.ThreadMetricsConfig;

/**
 * To save performance, {@link ThreadMetricsRequestCycleListener} should not be added at all
 * if {@link ThreadMetricsConfig#isEnabled()} is {@code false}.
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
 * @todo See http://apache-wicket.1842946.n4.nabble.com/How-to-get-PageClass-from-BufferedResponseRequestHandler-And-how-to-quot-link-quot-related-requests-td4666247.html
 * for issues.
 * @author ceefour
 */
public class ThreadMetricsRequestCycleListener extends
		AbstractRequestCycleListener {
	
	private static final MetaDataKey<Locale> LOCALE_KEY = new MetaDataKey<Locale>() { };
	private static final Logger log = LoggerFactory
			.getLogger(ThreadMetricsRequestCycleListener.class);
	static final ThreadLocal<Long> startCpuTime = new ThreadLocal<>();
	static final ThreadLocal<Long> startUserTime = new ThreadLocal<>();
	static final ThreadLocal<Long> startAllocatedBytes = new ThreadLocal<>();
//	/**
//	 * Effective {@link Page} (if available) or {@link IRequestHandler} class.
//	 */
//	static final ThreadLocal<Class<?>> handlerOrPageClass = new ThreadLocal<>();
	/**
	 * Workaround for http://apache-wicket.1842946.n4.nabble.com/How-to-get-PageClass-from-BufferedResponseRequestHandler-And-how-to-quot-link-quot-related-requests-td4666247.html
	 * @todo NOT foolproof! but better than nothing, I guess
	 */
	static final Map<String, Class<?>> pageClassForPath = new ConcurrentHashMap<>();
	
	@SuppressWarnings("restriction")
	@Override
	public void onBeginRequest(RequestCycle cycle) {
		final com.sun.management.ThreadMXBean threadMx = (com.sun.management.ThreadMXBean) ManagementFactory.getThreadMXBean();
		final long threadId = Thread.currentThread().getId();
		startCpuTime.set(threadMx.getThreadCpuTime(threadId));
		startUserTime.set(threadMx.getThreadUserTime(threadId) / 1000);
		startAllocatedBytes.set(threadMx.getThreadAllocatedBytes(threadId));
		super.onBeginRequest(cycle);
	}
	
	@Override
	public void onRequestHandlerResolved(RequestCycle cycle,
			IRequestHandler handler) {
		super.onRequestHandlerResolved(cycle, handler);
		@Nullable
		final String path = cycle.getRequest().getUrl() != null ? cycle.getRequest().getUrl().getPath() : null;
		if (path != null && !pageClassForPath.containsKey(path) && handler instanceof IPageClassRequestHandler) {
			pageClassForPath.put(path, ((IPageClassRequestHandler) handler).getPageClass());
		}
	}

}