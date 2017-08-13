package org.soluvas.web.site.servlet;

import org.slf4j.MDC;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Must be after Spring Security's {@link org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer#DEFAULT_FILTER_NAME}.
 */
public class SpringSecurityMdcServletFilter extends OncePerRequestFilter {
    private static final String REQUEST_USER = "req.user";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            MDC.put(REQUEST_USER, ((User) principal).getUsername());
        }
        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(REQUEST_USER);
        }
    }
}
