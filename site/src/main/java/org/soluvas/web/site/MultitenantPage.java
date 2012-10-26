package org.soluvas.web.site;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.multitenant.TenantRef;
import org.soluvas.web.site.osgi.WebTenantUtils;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/**
 * Page supporting multi-tenant injection.
 * 
 * The Wicket app's {@link Application#getApplicationKey()} must be {tenantId}_{tenantEnv}. 
 * 
 * @todo We can support Pax Wicket's PaxWicketBean "injectionSource" implementation.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MultitenantPage extends WebPage {
	
	private transient Logger log = LoggerFactory
			.getLogger(MultitenantPage.class);
	
	@PaxWicketBean(name="blueprintBundleContext")
	private transient BundleContext bundleContext;
	/**
	 * List of get-ed services (to unget).
	 */
	private final Map<Field, ServiceReference<?>> serviceRefs = new HashMap<Field, ServiceReference<?>>();
	
	public MultitenantPage() {
		super();
		getTenantServices();
	}
	
	@Override
	protected void onAfterRender() {
		ungetTenantServices();
		super.onAfterRender();
	}
	
	@Override
	protected void finalize() throws Throwable {
		ungetTenantServices();
		super.finalize();
	}
	
	protected void getTenantServices() {
		TenantRef tenant = WebTenantUtils.getTenant();
		final String tenantId = tenant.getTenantId();
		final String tenantEnv = tenant.getTenantEnv();
		
		Class<?> clazz = getClass();
		List<Field> fields = new ArrayList<Field>();
		while (clazz != null) {
			fields.addAll(ImmutableList.copyOf(clazz.getDeclaredFields()));
			clazz = clazz.getSuperclass();
		}
		for (Field field : fields) {
			TenantService tenantService = field.getAnnotation(TenantService.class);
			if (tenantService == null)
				continue;
			final String className = Strings.isNullOrEmpty(tenantService.objectClass()) ? field.getType().getName() : tenantService.objectClass();
			final String namespace = tenantService.value();
			final String additionalFilter = Optional.fromNullable(tenantService.filter()).or("");
			log.trace("Lookup {} for tenantId={} tenantEnv={} namespace={} filter: {}", new Object[] {
					className, tenantId, tenantEnv, namespace, additionalFilter });
			final String namespaceFilter = !Strings.isNullOrEmpty(namespace) ? "(namespace=" + namespace + ")" : ""; 
			String filter = "(&(tenantId=" + tenantId + ")(tenantEnv=" + tenantEnv + ")" + namespaceFilter + additionalFilter + ")";
			
			ServiceReference<?> serviceRef = null;
			try {
				ServiceReference<?>[] foundRefs = bundleContext
						.getServiceReferences(className, filter);
				if (foundRefs == null || foundRefs.length == 0)
					throw new RuntimeException("Cannot find " + className + " service with filter " + filter);
				serviceRef = foundRefs[0];
			} catch (InvalidSyntaxException e) {
				throw new RuntimeException("Cannot find " + className + " service with filter " + filter, e);
			}
			Object bean = bundleContext.getService(serviceRef);
			serviceRefs.put(field, serviceRef);
			log.trace("Injecting {}#{} as {}", new Object[] { getPageClass().getName(), field.getName(), bean });
			final boolean wasAccessible = field.isAccessible();
			field.setAccessible(true);
			try {
				field.set(this, bean);
			} catch (Exception e) {
				log.error("Cannot inject " + getPageClass().getName() + "#" + field.getName() + " as " + bean, e);
				throw new RuntimeException("Cannot inject " + getPageClass().getName() + "#" + field.getName() + " as " + bean, e);
			} finally {
				field.setAccessible(wasAccessible);
			}
		}
	}

	protected void ungetTenantServices() {
		for (Entry<Field, ServiceReference<?>> entry : serviceRefs.entrySet()) {
			final Field field = entry.getKey();
			log.trace("Unsetting {}#{}", new Object[] { getPageClass().getName(), field.getName() });
			final boolean wasAccessible = field.isAccessible();
			field.setAccessible(true);
			try {
				field.set(this, null);
			} catch (Exception e) {
				log.warn("Cannot unset " + getPageClass().getName() + "." + field.getName(), e);
			} finally {
				field.setAccessible(wasAccessible);
			}
			bundleContext.ungetService(entry.getValue());
		}
		serviceRefs.clear();
	}
	
}
