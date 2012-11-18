package org.soluvas.web.site;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.wicket.Component;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.inject.Filter;
import org.soluvas.commons.inject.Namespace;
import org.soluvas.commons.inject.Supplied;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.web.site.osgi.WebTenantUtils;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;

/**
 * Injects Wicket {@link Component}s using {@link TenantServiceProxy}.
 * 
 * Supported annotations are: {@link Inject}, {@link Namespace}, {@link Filter}, {@link Supplied}.
 * 
 * {@link BehaviorTenantInjector} is superior: it works with all objects (not just interfaces), and more performant
 * because it doesn't use proxies, and in some ways easier to debug (but harder in other ways, because it does a long-running
 * {@link BundleContext#getService(ServiceReference)}).
 * 
 * @author ceefour
 */
public class ProxyTenantInjector implements IComponentInstantiationListener {

	private static Logger log = LoggerFactory.getLogger(ProxyTenantInjector.class);
	
	@SuppressWarnings("rawtypes")
	@Override
	public void onInstantiation(Component component) {
		final TenantRef tenant = WebTenantUtils.getTenant();
		final String tenantId = tenant.getTenantId();
		final String tenantEnv = tenant.getTenantEnv();
		
		Class<?> clazz = component.getClass();
		final ImmutableList.Builder<Field> fieldsBuilder = ImmutableList.builder();
		while (clazz != null) {
			fieldsBuilder.addAll(ImmutableList.copyOf(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		final List<Field> fields = fieldsBuilder.build();
		
		final BundleContext bundleContext = FrameworkUtil.getBundle(component.getClass()).getBundleContext();
		for (Field field : fields) {
			final Inject injectAnn = field.getAnnotation(Inject.class);
			if (injectAnn == null)
				continue;
			
			final Namespace namespaced = field.getAnnotation(Namespace.class);
			final String namespace = namespaced != null ? namespaced.value() : null;
			final String namespaceFilter = namespace != null ? "(namespace=" + namespace + ")" : "";
			
			final Filter filtered = field.getAnnotation(Filter.class);
			final String additionalFilter = filtered != null ? filtered.value() : "";
			
			final Supplied supplied = field.getAnnotation(Supplied.class);
			if (supplied == null) {
				final Class<?> serviceClass = field.getType();
				
				log.trace("Field {}#{} will lookup {} for tenantId={} tenantEnv={} namespace={} filter: {}", new Object[] {
						component.getId(), field.getName(), serviceClass.getName(), tenantId, tenantEnv, namespace, additionalFilter });
				final String suppliedClassFilter = supplied != null ? "(suppliedClass=" + field.getType().getName() + ")(layer=application)" : "";
				final String filter = "(&(tenantId=" + tenantId + ")(tenantEnv=" + tenantEnv + ")" + namespaceFilter + suppliedClassFilter + additionalFilter + ")";
				
				final InvocationHandler invocationHandler = new TenantServiceProxy(bundleContext, component.getId() + "#" + field.getName(), serviceClass, filter);
				final Object proxy = Proxy.newProxyInstance(component.getClass().getClassLoader(), new Class[] { serviceClass }, invocationHandler);
				log.trace("Injecting {}#{} as {}", component.getId(), field.getName(), invocationHandler);
				try {
					FieldUtils.writeField(field, component, proxy, true);
				} catch (Exception e) {
					log.error("Cannot inject " + component.getId() + "#" + field.getName() + " as " + invocationHandler, e);
					throw new RuntimeException("Cannot inject " + component.getId() + "#" + field.getName() + " as " + invocationHandler, e);
				}
			} else {
				final Class<?> suppliedClass = field.getType();
				
				log.trace("Field {}#{} needs Supplier<{}> for tenantId={} tenantEnv={} namespace={} filter: {}", new Object[] {
						component.getId(), field.getName(), suppliedClass.getName(), tenantId, tenantEnv, namespace, additionalFilter });
				final String suppliedClassFilter = supplied != null ? "(suppliedClass=" + field.getType().getName() + ")(layer=application)" : "";
				final String filter = "(&(tenantId=" + tenantId + ")(tenantEnv=" + tenantEnv + ")" + namespaceFilter + suppliedClassFilter + additionalFilter + ")";
				
				final Collection<ServiceReference<Supplier>> serviceRefs;
				try {
					serviceRefs = bundleContext.getServiceReferences(Supplier.class, filter);
				} catch (InvalidSyntaxException e) {
					throw new RuntimeException("Cannot inject " + component.getId() + "#" + field.getName() + ", invalid " +
							suppliedClass.getName() + " Supplier service with filter " + filter, e);
				}
				if (serviceRefs == null || serviceRefs.isEmpty()) {
					throw new RuntimeException("Cannot find " + suppliedClass.getName() + " supplier for " + component.getId() + "#" + field.getName() + ", " +
							"Supplier with " + filter + " not found");
				}
				final ServiceReference<Supplier> serviceRef = serviceRefs.iterator().next();
				final Supplier supplier = bundleContext.getService(serviceRef);
				try {
					final Object suppliedObj = supplier.get();
					log.trace("Injecting {}#{} as {}", component.getId(), field.getName(), suppliedObj);
					FieldUtils.writeField(field, component, suppliedObj, true);
				} catch (Exception e) {
					log.error("Cannot inject " + component.getId() + "#" + field.getName() + " from " + supplier, e);
					throw new RuntimeException("Cannot inject " + component.getId() + "#" + field.getName() + " from " + supplier, e);
				} finally {
					bundleContext.ungetService(serviceRef);
				}
			}
		}
	}

}
