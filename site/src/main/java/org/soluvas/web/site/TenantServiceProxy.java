package org.soluvas.web.site;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

import javax.inject.Inject;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JDK Proxy implementation for JSR330 {@link Inject}. Created by {@link ProxyTenantInjector}. 
 * @author ceefour
 */
public class TenantServiceProxy implements InvocationHandler {

	private static Logger log = LoggerFactory
			.getLogger(TenantServiceProxy.class);
	private final BundleContext bundleContext;
	private final String name;
	@SuppressWarnings("rawtypes")
	private final Class clazz;
	private final String filter;
	
	/**
	 * @param bundleContext
	 * @param name
	 * @param clazz
	 * @param filter
	 */
	@SuppressWarnings("rawtypes")
	public TenantServiceProxy(BundleContext bundleContext, String name,
			Class clazz, String filter) {
		super();
		this.bundleContext = bundleContext;
		this.name = name;
		this.clazz = clazz;
		this.filter = filter;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		log.trace("Lookup {} for {} on {}", clazz.getName(), filter, method);
		final ServiceReference<?> serviceRef;
		try {
			final Collection<ServiceReference<?>> foundRefs = bundleContext.getServiceReferences(clazz, filter);
			if (foundRefs == null || foundRefs.isEmpty()) {
				throw new RuntimeException("Cannot invoke " + method + " on " + name + ", " +
						clazz.getName() + " service with " + filter + " not found");
			}
			serviceRef = foundRefs.iterator().next();
		} catch (InvalidSyntaxException e) {
			throw new RuntimeException("Cannot invoke " + method + " on " + name + ", invalid " +
					clazz.getName() + " service with filter " + filter, e);
		}
		final Object bean = bundleContext.getService(serviceRef);
		log.trace("Invoking {} on {} with {}", method, name, bean );
		try {
			return method.invoke(bean, args);
		} finally {
			bundleContext.ungetService(serviceRef);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TenantServiceProxy ["
				+ (name != null ? "name=" + name + ", " : "")
				+ (clazz != null ? "clazz=" + clazz + ", " : "")
				+ (filter != null ? "filter=" + filter : "") + "]";
	}

}
