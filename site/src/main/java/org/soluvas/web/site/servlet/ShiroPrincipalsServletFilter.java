package org.soluvas.web.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.google.common.base.Joiner;

/**
 * Puts a {@code principals} in the {@link MDC} based on Shiro {@link SecurityUtils#getSubject()}.
 * Combine this with {@link MoreMdcServletFilter}.
 * @author ceefour
 * @see MoreMdcServletFilter
 */
public class ShiroPrincipalsServletFilter implements Filter {

	private static final Logger log = LoggerFactory
			.getLogger(ShiroPrincipalsServletFilter.class);
	public static final String MDC_KEY = "principals";
	
	public ShiroPrincipalsServletFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Get principal
		try {
			final PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
			if (principalCollection != null) {
				final List<?> principals = principalCollection.asList();
				try {
					MDC.put(MDC_KEY, Joiner.on(", ").join(principals));
				} catch (Exception e) {
					log.warn("Cannot register 'principals' MDC: " + principals, e);
				}
			}
		} catch (Exception e) {
			log.warn("Cannot get Shiro Subject", e);
		}
		
		try {
			chain.doFilter(request, response);
		} finally {
			MDC.remove(MDC_KEY);
		}
	}

	@Override
	public void destroy() {
	}

}
