package org.soluvas.web.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DelegatingFilter implements Filter {
	
	private Filter filter;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		Filter delegatedFilter = getFilter();
		delegatedFilter.doFilter(request, response, chain);
	}

	private Filter getFilter() {
		if (filter == null) {
			throw new IllegalStateException("Filter property is required");
		}
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
