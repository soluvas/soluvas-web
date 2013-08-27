package org.soluvas.web.site;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.servlet.ShiroFilter;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereServlet;
import org.atmosphere.cpr.AtmosphereServletProcessor;
import org.atmosphere.cpr.FrameworkConfig;
import org.atmosphere.handler.AbstractReflectorAtmosphereHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * Here we define {@link ShiroFilter} (via {@link DelegatingFilterProxy}) and {@link WicketFilter} as atmosphere.xml 
 * does not support proper definition of filters despite the fact that {@link AtmosphereServlet}
 * requires definition of filters inside itself to be able to delegate to them.
 * 
 * <p>Usage in {@code src/main/webapp/META-INF/atmosphere.xml}:
 * <pre>{@literal
 * <?xml version="1.0" encoding="UTF-8"?>
 * <atmosphere-handlers>
 *     <atmosphere-handler context-root="/*" class-name=
 * 			"org.soluvas.web.site.SecuredWicketAtmosphereHandler" />
 * </atmosphere-handlers>
 * }</pre>
 * 
 * Requires the {@code filterMappingUrlPattern init-param}:
 * 
 * <pre>{@literal
 * <init-param>
 * 	<param-name>filterMappingUrlPattern</param-name>
 * 	<param-value>/*</param-value>
 * </init-param>
 * }</pre>
 * 
 * <p>Adapted from http://burkond.blogspot.com/2013/01/non-blocking-server-push-with.html
 */
public class SecuredWicketAtmosphereHandler extends AbstractReflectorAtmosphereHandler
        implements AtmosphereServletProcessor {
	private static final Logger log = LoggerFactory
			.getLogger(SecuredWicketAtmosphereHandler.class);

    private CustomFilterChain filterChain;

    public SecuredWicketAtmosphereHandler() {
    	super();
    }

    /**
     * Delegate the request to the Servlet.service method, and 
     * add the {@link AtmosphereResource} to the {@link 
     * HttpServletRequest#setAttribute(java.lang.String, java.lang.Object))}.
     * The {@link AtmosphereResource} can be retrieved using 
     * {@link org.atmosphere.cpr.FrameworkConfig#ATMOSPHERE_RESOURCE} value.
     *
     * @param resource The {@link AtmosphereResource}
     * @throws java.io.IOException
     */
    @Override
	public void onRequest(AtmosphereResource resource) throws IOException {
        resource.getRequest().setAttribute(FrameworkConfig.ATMOSPHERE_RESOURCE, resource);
        resource.getRequest().setAttribute(FrameworkConfig.ATMOSPHERE_HANDLER, this);
        try {
            filterChain.invokeFilterChain(resource.getRequest(), resource.getResponse());
        } catch (Throwable ex) {
            throw new SiteException(ex);
        }
    }

    @Override
	public void init(ServletConfig servletConfig) throws ServletException {
        try {
        	// The filter-name matches name of a 'shiroFilter' bean inside applicationContext.xml
        	// Make sure any request you want accessible to Shiro is filtered. /* catches all
        	// requests.  Usually this filter mapping is defined first (before all others) to
        	// ensure that Shiro works in subsequent filters in the filter chain:            
            FilterConfigImpl shiroFilterConfig = new FilterConfigImpl(servletConfig,
                    new DelegatingFilterProxy(), "shiroFilter");
            shiroFilterConfig.addInitParameter("targetFilterLifecycle", Boolean.TRUE.toString());
            
            FilterConfigImpl wicketFilterConfig = new FilterConfigImpl(servletConfig,
                    new WicketFilter(getWebApplication(servletConfig)),
                    "wicketFilter");
//            wicketFilterConfig.addInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/app/*");

//            filterChain = new CustomFilterChain(ImmutableList.of(
//                    wicketFilterConfig), servletConfig.getServletContext());
            filterChain = new CustomFilterChain(ImmutableList.of(shiroFilterConfig,
                    wicketFilterConfig), servletConfig.getServletContext());
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
        filterChain.init();
    }

    private WebApplication getWebApplication(ServletConfig sc) {
        final WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc
                .getServletContext());
        final Map<String, WebApplication> beans = BeanFactoryUtils
                .beansOfTypeIncludingAncestors(ac, WebApplication.class, false, false);
        if (beans.size() == 0) {
            throw new IllegalStateException("bean of type ["
                    + WebApplication.class.getName() + "] not found");
        }
        if (beans.size() > 1) {
            throw new IllegalStateException("More than one bean of type ["
                    + WebApplication.class.getName() + "] found, must have only one");
        }
        final WebApplication webApp = beans.values().iterator().next();
        log.info("Initializing Wicket application {} for Atmosphere from {} {}", webApp, ac.getId(), ac);
        return webApp;
    }

    @Override
	public void destroy() {
        if (filterChain != null) {
            filterChain.destroy();
        }
    }

    private static final class CustomFilterChain implements FilterChain {

        private final List<FilterConfigImpl> filterConfigurations;
        private final ServletContext servletContext;

        public CustomFilterChain(List<FilterConfigImpl> filterConfigurations,
                ServletContext servletContext) {
            this.filterConfigurations = Collections
                    .unmodifiableList(filterConfigurations);
            this.servletContext = servletContext;
        }

        public void destroy() {
            for (FilterConfigImpl filter : filterConfigurations) {
                filter.getFilter().destroy();
            }
        }

        public void init() throws ServletException {
            for (FilterConfigImpl filter : filterConfigurations) {
                filter.getFilter().init(filter);
            }
        }

        public void invokeFilterChain(ServletRequest request, ServletResponse response)
                throws IOException, ServletException {
            request.setAttribute("pos", new AtomicInteger(0));
            doFilter(request, response);
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response)
                throws IOException, ServletException {
            // Call the next filter if there is one
            AtomicInteger pos = ((AtomicInteger) request.getAttribute("pos"));
            if (pos.get() < filterConfigurations.size()) {
                FilterConfigImpl filterConfig = filterConfigurations.get(pos
                        .getAndIncrement());
                Filter filter = null;
                try {
                    filter = filterConfig.getFilter();
                    filter.doFilter(request, response, this);
                } catch (Throwable e) {
                    throw new ServletException("Cannot process filter: " + e, e);
                }
                return;
            }

            try {
                RequestDispatcher rd = servletContext.getNamedDispatcher("default");
                if (rd == null) {
                    throw new ServletException("No Servlet Found");
                }
                rd.forward(request, response);
            } catch (Throwable e) {
            	throw new ServletException("Cannot process filter: " + e, e);
            }
        }
    }

    /**
     * Allows control over initParameters.
     */
    private static final class FilterConfigImpl implements FilterConfig {

        private final Filter filter;
        private final String filterName;
        private final ServletContext servletContext;

        private final Map<String, String> initParams;

        public FilterConfigImpl(ServletConfig servletConfig, Filter filter,
                String filterName) {
            this.servletContext = servletConfig.getServletContext();
            this.filter = filter;
            this.filterName = filterName;
            this.initParams = addParameters(servletConfig);
        }

        private Map<String, String> addParameters(ServletConfig servletConfig) {
            Map<String, String> result = Maps.newHashMap();
            Enumeration<String> parameterNames = servletConfig.getInitParameterNames();
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String value = servletConfig.getInitParameter(name);
                result.put(name, value);
            }
            return result;
        }

        public void addInitParameter(String name, String value) {
            initParams.put(name, value);
        }

        public Filter getFilter() {
            return filter;
        }

        @Override
        public String getFilterName() {
            return filterName;
        }

        @Override
        public ServletContext getServletContext() {
            return servletContext;
        }

        @Override
        public String getInitParameter(String name) {
            return initParams.get(name);
        }

        @Override
        public Enumeration<String> getInitParameterNames() {
            return Collections.enumeration(initParams.keySet());
        }
    }
}