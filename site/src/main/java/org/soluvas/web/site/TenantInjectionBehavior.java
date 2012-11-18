package org.soluvas.web.site;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.inject.Filter;
import org.soluvas.commons.inject.Namespace;
import org.soluvas.commons.inject.Supplied;

import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;

/**
 * Injects {@link Inject} tenant services before render, and uninjects after render.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class TenantInjectionBehavior extends Behavior {
	
	private static Logger log = LoggerFactory
			.getLogger(TenantServiceProxy.class);
	private final BundleContext bundleContext;
	private final String tenantId;
	private final String tenantEnv;
	/**
	 * List of get-ed services (to unget).
	 */
	private final Map<Field, ServiceReference<?>> serviceRefs = new HashMap<Field, ServiceReference<?>>();
	
	/**
	 * @param bundleContext
	 * @param tenantId
	 * @param tenantEnv
	 */
	public TenantInjectionBehavior(BundleContext bundleContext,
			String tenantId, String tenantEnv) {
		super();
		this.bundleContext = bundleContext;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
	}

	@Override
	public void beforeRender(Component component) {
		inject(component);
		
		super.beforeRender(component);
	}

	/**
	 * Perform injection.
	 * @param component
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void inject(Component component) {
		Class<?> clazz = component.getClass();
		final ImmutableList.Builder<Field> fieldsBuilder = ImmutableList.builder();
		while (clazz != null) {
			fieldsBuilder.addAll(ImmutableList.copyOf(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		final List<Field> fields = fieldsBuilder.build();
		
		for (Field field : fields) {
			// Skip irrelevant fields
			final Inject injectAnn = field.getAnnotation(Inject.class);
			if (injectAnn == null)
				continue;
			final Supplied supplied = field.getAnnotation(Supplied.class);
			if (supplied != null)
				continue;
			try {
				Object currentValue = FieldUtils.readField(field, component, true);
				if (currentValue != null)
					continue;
			} catch (IllegalAccessException e) {
				Throwables.propagate(e);
				return;
			}
			
			final Namespace namespaced = field.getAnnotation(Namespace.class);
			final String namespace = namespaced != null ? namespaced.value() : null;
			final String namespaceFilter = namespace != null ? "(namespace=" + namespace + ")" : "";
			
			final Filter filtered = field.getAnnotation(Filter.class);
			final String additionalFilter = filtered != null ? filtered.value() : "";
			
			final Class serviceClass = field.getType();
			
			log.trace("Field {}#{} looking up {} for tenantId={} tenantEnv={} namespace={} filter: {}", new Object[] {
					component.getId(), field.getName(), serviceClass.getName(), tenantId, tenantEnv, namespace, additionalFilter });
			final String suppliedClassFilter = supplied != null ? "(suppliedClass=" + field.getType().getName() + ")(layer=application)" : "";
			final String filter = "(&(tenantId=" + tenantId + ")(tenantEnv=" + tenantEnv + ")" + namespaceFilter + suppliedClassFilter + additionalFilter + ")";
			
			final ServiceReference<?> serviceRef;
			try {
				final Collection<ServiceReference<?>> foundRefs = bundleContext.getServiceReferences(serviceClass, filter);
				if (foundRefs == null || foundRefs.isEmpty()) {
					throw new RuntimeException("Cannot inject " + component.getId() + "#" + field.getName() + ", " +
							serviceClass.getName() + " service with " + filter + " not found");
				}
				serviceRef = foundRefs.iterator().next();
			} catch (InvalidSyntaxException e) {
				throw new RuntimeException("Cannot inject " + component.getId() + "#" + field.getName() + ", invalid " +
						serviceClass.getName() + " service with " + filter);
			}
			final Object bean = bundleContext.getService(serviceRef);
			try {
				log.trace("Injecting {}#{} as {}", component.getId(), field.getName(), bean);
				FieldUtils.writeField(field, component, bean, true);
				serviceRefs.put(field, serviceRef);
			} catch (Exception e) {
				bundleContext.ungetService(serviceRef);
				serviceRefs.remove(field);
				throw new RuntimeException("Cannot set field " + component.getId() + "#" + field.getName() + " using " +
						serviceClass.getName() + " service with " + filter, e);
			}
		}
	}
	
	@Override
	public void afterRender(Component component) {
		super.afterRender(component);
		uninject(component);
	}

	/**
	 * Uninjects injected fields.
	 * @param component
	 */
	public void uninject(Component component) {
		Iterator<Entry<Field, ServiceReference<?>>> serviceRefIterator = serviceRefs.entrySet().iterator();
		while (serviceRefIterator.hasNext()) {
			final Entry<Field, ServiceReference<?>> entry = serviceRefIterator.next();
			final Field field = entry.getKey();
			log.trace("Unsetting {}#{}", new Object[] { component.getId(), field.getName() });
			try {
				FieldUtils.writeField(field, this, null, true);
			} catch (Exception e) {
				log.warn("Cannot unset " + component.getId() + "." + field.getName(), e);
			}
			bundleContext.ungetService(entry.getValue());
			serviceRefIterator.remove();
		}
	}

}
