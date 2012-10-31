package org.soluvas.web.login;

import javax.servlet.Filter;

import org.ops4j.pax.wicket.api.ConfigurableFilterConfig;
import org.ops4j.pax.wicket.util.AbstractFilterFactory;
import org.osgi.framework.BundleContext;

public class DelegatingFilterFactory extends AbstractFilterFactory {

	private Filter filter;
	
	public DelegatingFilterFactory(BundleContext bundleContext, String applicationName, Integer priority) {
		super(bundleContext, applicationName, priority);
	}

	public Filter createFilter(ConfigurableFilterConfig filterConfig) {
		ClassLoader oldClassloader = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(DelegatingFilter.class.getClassLoader());
            DelegatingFilter delegatingFilter = DelegatingFilter.class.newInstance();
            delegatingFilter.setFilter(filter);
            delegatingFilter.init(filterConfig);
            return filter;
        } catch (Exception e) {
            throw new IllegalStateException(String.format("Filter %s could not be created for application {}",
                DelegatingFilter.class.getName(), getApplicationName()), e);
        } finally {
            Thread.currentThread().setContextClassLoader(oldClassloader);
        }
	}
	
	public void setFilter(Filter filter) {
		this.filter= filter;
	}
}
