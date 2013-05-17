package org.soluvas.web.site.osgi;

import java.util.Collection;

import javax.annotation.Nullable;

import org.apache.wicket.Application;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantRefImpl;
import org.soluvas.web.site.SiteException;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;

/**
 * Pax Wicket and OSGi tenant-aware utilities.
 * 
 * @author ceefour
 */
public class WebUtils {

	private static final Logger log = LoggerFactory
			.getLogger(WebUtils.class);
	
	/**
	 * Get {@link TenantRefImpl} for current Wicket {@link Application}.
	 * 
	 * <p>WARNING: This method is not thread-safe, it must be run from the Wicket thread,
	 * so it's useless for asynchronous operations.
	 * 
	 * @return
	 */
	public static TenantRef getTenant() {
		return new TenantRefImpl(null, null, null);
//		Application app = Application.get();
//		final String appKey = app.getApplicationKey();
//		log.trace("Getting Wicket tenant for app key={} name={}", appKey,
//				app.getName());
//		
//		Matcher matcher = Pattern.compile("(.+)_([^_]+)").matcher(appKey);
//		if (!matcher.matches()) {
//			log.error("Cannot parse application key " + appKey + " into tenantId_tenantEnv");
//			throw new SiteException("Cannot parse application key " + appKey + " into tenantId_tenantEnv");
//		}
//		final String tenantId = matcher.group(1);
//		final String tenantEnv = matcher.group(2);
//		return new TenantRef(null, tenantId, tenantEnv);
	}

	/**
	 * Get OSGi {@link ServiceReference} scoped to the current Wicket
	 * {@link Application}'s tenant.
	 * 
	 * <p>WARNING: This method is not thread-safe, it must be run from the Wicket thread,
	 * so it's useless for asynchronous operations.
	 * 
	 * @param iface
	 * @param namespace
	 * @param filter
	 * @return
	 */
	public static <T> ServiceReference<T> getService(Class<T> iface,
			@Nullable String namespace, @Nullable String filter) {
		final BundleContext bundleContext = FrameworkUtil.getBundle(
				WebUtils.class).getBundleContext();

//		final TenantRef tenant = getTenant();
//		final String tenantId = tenant != null ? tenant.getTenantId() : null;
//		final String tenantEnv = tenant != null ? tenant.getTenantEnv() : null;
		
		final String className = iface.getName();
		final String additionalFilter = Optional.fromNullable(filter).or("");
		// single tenant for now
//		log.trace(
//				"Lookup {} for tenantId={} tenantEnv={} namespace={} filter: {}",
//				className, tenantId, tenantEnv, namespace, additionalFilter);
		log.trace("Lookup {} for namespace={} filter: {}",
				className, namespace, additionalFilter);
		final String namespaceFilter = !Strings.isNullOrEmpty(namespace) ? "(namespace="
				+ namespace + ")"
				: "";
//		String realFilter = "(&(tenantId=" + tenantId + ")(tenantEnv="
//				+ tenantEnv + ")" + namespaceFilter + additionalFilter + ")";
		String realFilter = "(&" + namespaceFilter + additionalFilter + ")";
		if ("(&)".equals(realFilter)) {
			realFilter = null;
		}

		try {
			final Collection<ServiceReference<T>> foundRefs = bundleContext
					.getServiceReferences(iface, realFilter);
			if (foundRefs == null || foundRefs.isEmpty())
				throw new SiteException("Cannot find " + className
						+ " service with filter " + realFilter);
			final ServiceReference<T> serviceRef = foundRefs.iterator().next();
			return serviceRef;
		} catch (InvalidSyntaxException e) {
			throw new SiteException("Cannot find " + className
					+ " service with filter " + realFilter, e);
		}
	}

	/**
	 * Returns a tenant-scoped supplied object from {@link Supplier} service,
	 * on {@code application} layer.
	 * 
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getSupplied(Class<T> clazz) {
		final ServiceReference<Supplier> supplierRef = getService(
				Supplier.class, null, "(&(suppliedClass=" + clazz.getName() + ")(layer=application))");
		final BundleContext bundleContext = FrameworkUtil.getBundle(
				WebUtils.class).getBundleContext();
		final Supplier<T> supplier = bundleContext.getService(supplierRef);
		try {
			return supplier.get();
		} finally {
			bundleContext.ungetService(supplierRef);
		}
	}
	
	/**
	 * Returns the {@link WebAddress} for current tenant application.
	 * @return
	 */
	public static WebAddress getWebAddress() {
		return getSupplied(WebAddress.class);
	}
	
	/**
	 * Return the absolute URI of a properly scoped image, also uses SSL if required.
	 *  
	 * @param bundleClazz The class that has the same bundle as the image path.
	 * @param path id.co.bippo.web.pub/logo_diweb.gif
	 * @return e.g. {@code /static/images/id.co.bippo.web.pub/logo_diweb.gif} or {@code http://images.berbatik.com/id.co.bippo.web.pub/logo_diweb.gif}
	 * 		or {@code https://images.berbatik.com/id.co.bippo.web.pub/logo_diweb.gif}
	 */
	public static String getImageUri(Class bundleClazz, String path) {
		final WebAddress webAddress = WebUtils.getWebAddress();
		return webAddress.getImagesUri() + FrameworkUtil.getBundle(bundleClazz).getSymbolicName() + "/" + path;
	}
	
}
