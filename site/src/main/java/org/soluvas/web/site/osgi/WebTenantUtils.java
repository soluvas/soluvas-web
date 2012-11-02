package org.soluvas.web.site.osgi;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.wicket.Application;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
/**
 * Pax Wicket and OSGi tenant-aware utilities.
 * 
 * @author ceefour
 */
public class WebTenantUtils {

	private static transient Logger log = LoggerFactory
			.getLogger(WebTenantUtils.class);
	
	/**
	 * Get {@link TenantRef} for current Wicket {@link Application}.
	 * 
	 * @return
	 */
	public static TenantRef getTenant() {
		Application app = Application.get();
		final String appKey = app.getApplicationKey();
		log.debug("Getting Wicket tenant for app key={} name={}", appKey,
				app.getName());
		
		Matcher matcher = Pattern.compile("(.+)_([^_]+)").matcher(appKey);
		if (!matcher.matches()) {
			log.error("Cannot parse application key " + appKey + " into tenantId_tenantEnv");
			throw new RuntimeException("Cannot parse application key " + appKey + " into tenantId_tenantEnv");
		}
		final String tenantId = matcher.group(1);
		final String tenantEnv = matcher.group(2);
		return new TenantRef(null, tenantId, tenantEnv);
	}

	/**
	 * Get OSGi {@link ServiceReference} scoped to the current Wicket
	 * {@link Application}'s tenant.
	 * 
	 * @param iface
	 * @param namespace
	 * @param filter
	 * @return
	 */
	public static <T> ServiceReference<T> getService(@Nonnull Class<T> iface,
			@Nullable String namespace, @Nullable String filter) {
		BundleContext bundleContext = FrameworkUtil.getBundle(
				WebTenantUtils.class).getBundleContext();

		TenantRef tenant = getTenant();
		final String tenantId = tenant.getTenantId();
		final String tenantEnv = tenant.getTenantEnv();
		
		final String className = iface.getName();
		final String additionalFilter = Optional.fromNullable(filter).or("");
		log.trace(
				"Lookup {} for tenantId={} tenantEnv={} namespace={} filter: {}",
				new Object[] { className, tenantId, tenantEnv, namespace,
						additionalFilter });
		final String namespaceFilter = !Strings.isNullOrEmpty(namespace) ? "(namespace="
				+ namespace + ")"
				: "";
		String realFilter = "(&(tenantId=" + tenantId + ")(tenantEnv="
				+ tenantEnv + ")" + namespaceFilter + additionalFilter + ")";

		ServiceReference<T> serviceRef = null;
		try {
			Collection<ServiceReference<T>> foundRefs = bundleContext
					.getServiceReferences(iface, realFilter);
			if (foundRefs == null || foundRefs.isEmpty())
				throw new RuntimeException("Cannot find " + className
						+ " service with filter " + realFilter);
			serviceRef = foundRefs.iterator().next();
			return serviceRef;
		} catch (InvalidSyntaxException e) {
			throw new RuntimeException("Cannot find " + className
					+ " service with filter " + realFilter, e);
		}
	}

	/**
	 * Returns a tenant-scoped supplied object from {@link Supplier} service.
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getSupplied(@Nonnull Class<T> clazz) {
		ServiceReference<Supplier> supplierRef = getService(
				Supplier.class, null, "(suppliedClass=" + clazz.getName() + ")");
		BundleContext bundleContext = FrameworkUtil.getBundle(
				WebTenantUtils.class).getBundleContext();
		Supplier<T> supplier = bundleContext.getService(supplierRef);
		try {
			return supplier.get();
		} finally {
			bundleContext.ungetService(supplierRef);
		}
	}
	
}
