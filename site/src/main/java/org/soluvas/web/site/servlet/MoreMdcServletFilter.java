package org.soluvas.web.site.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Adds more {@link MDC} properties not added by {@link ch.qos.logback.classic.helpers.MDCInsertingServletFilter}:
 * 
 * <ol>
 * 	<li>{@code req.referer}: from {@code Referer} HTTP header.</li>
 * 	<li>{@code req.sessionId}: from {@link HttpSession#getId()}.</li>
 * </ol>
 * 
 * For Shiro: Combine this with {@link ShiroPrincipalsServletFilter}.
 * 
 * @author ceefour
 * @see ch.qos.logback.classic.helpers.MDCInsertingServletFilter
 * @see ShiroPrincipalsServletFilter
 * @see SpringSecurityMdcServletFilter
 */
public class MoreMdcServletFilter extends OncePerRequestFilter {

	private static final Logger log = LoggerFactory
			.getLogger(MoreMdcServletFilter.class);
	public static final String REQUEST_SESSION_ID = "req.sessionId";
	public static final String REQUEST_REFERER = "req.referer";
	
	public MoreMdcServletFilter() {
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Get referer
		final String referer = request.getHeader("Referer");
		if (referer != null) {
			MDC.put(REQUEST_REFERER, referer);
		}
		// Get session
		final HttpSession session = request.getSession(false);
		if (session != null) {
			MDC.put(REQUEST_SESSION_ID, session.getId());
		}

		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.remove(REQUEST_REFERER);
			MDC.remove(REQUEST_SESSION_ID);
		}
	}

	@Override
	public void destroy() {
	}

}
