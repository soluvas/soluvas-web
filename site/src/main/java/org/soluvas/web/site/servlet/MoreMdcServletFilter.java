package org.soluvas.web.site.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Adds more {@link MDC} properties:
 * 
 * <ol>
 * 	<li>{@code req.referer}: from {@code Referer} HTTP header.</li>
 * 	<li>{@code req.sessionId}: from {@link HttpSession#getId()}.</li>
 * </ol>
 * 
 * Combine this with {@link ShiroPrincipalsServletFilter}.
 * 
 * @author ceefour
 * @see ShiroPrincipalsServletFilter
 */
public class MoreMdcServletFilter implements Filter {

	private static final Logger log = LoggerFactory
			.getLogger(MoreMdcServletFilter.class);
	public static final String MDC_REQ_SESSION_ID = "req.sessionId";
	public static final String MDC_REQ_REFERER = "req.referer";
	
	public MoreMdcServletFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			// Get referer
			final String referer = ((HttpServletRequest) request).getHeader("Referer");
			if (referer != null) {
				MDC.put(MDC_REQ_REFERER, referer);
			}
			// Get session
			final HttpSession session = ((HttpServletRequest) request).getSession(false);
			if (session != null) {
				MDC.put(MDC_REQ_SESSION_ID, session.getId());
			}
		}

		try {
			chain.doFilter(request, response);
		} finally {
			MDC.remove(MDC_REQ_REFERER);
			MDC.remove(MDC_REQ_SESSION_ID);
		}
	}

	@Override
	public void destroy() {
	}

}
