package org.soluvas.web.site.metrics;

import java.lang.management.ManagementFactory;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
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
 * @author ceefour
 */
public class ThreadMetricsRequestCycleListener extends
		AbstractRequestCycleListener {
	
	static final ThreadLocal<Long> startCpuTime = new ThreadLocal<>();
	static final ThreadLocal<Long> startUserTime = new ThreadLocal<>();
	static final ThreadLocal<Long> startAllocatedBytes = new ThreadLocal<>();
	
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
	
}
