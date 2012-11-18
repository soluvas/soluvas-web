package org.soluvas.web.site;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.wicket.Application;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.support.SimpleThreadScope;

/**
 * See {@link SimpleThreadScope} for sample {@link Scope} implementation.
 * @author ceefour
 * @deprecated Quasi-failed experiment. The service "URI" needs to be put as bean ID, which Spring XML dislikes,
 * 		and... the ID needs to be re-specified in the @{@link PaxWicketBean}, which is pointless.
 * 		Please use {@link Inject}.
 */
@Deprecated
public class WicketTenantScope implements Scope {

	public static class ServiceBean {
		private final ServiceReference serviceRef;
		private final Object bean;
		
		public ServiceBean(ServiceReference serviceRef, Object bean) {
			super();
			this.serviceRef = serviceRef;
			this.bean = bean;
		}
	}
	
	private transient Logger log = LoggerFactory.getLogger(WicketTenantScope.class);
	private final BundleContext bundleContext;
	/**
	 * Map of applicationKey -> scopedTarget name -> ServiceReference. 
	 */
	private final Map<String, Map<String, ServiceBean>> beanMap = new ConcurrentHashMap<String, Map<String,ServiceBean>>();
	
	public WicketTenantScope(BundleContext bundleContext) {
		super();
		this.bundleContext = bundleContext;
		log.info("Create Wicket scope");
	}
	
	/**
	 * The bean name in this format:
	 * 
	 * 1. {objectClass}
	 * 2. {objectClass}/{namespace}
	 * 3. {objectClass}?repositoryMode=raw&type=jaxrs
	 * 4. {objectClass}/{namespace}?repositoryMode=raw&type=jaxrs
	 * 
	 * which will be prepended the scheme internally to form a URI:
	 * 
	 * service://{objectClass}/{namespace}?filter=a&filter=b&...
	 * 
	 * The Wicket app's {@link Application#getApplicationKey()} must be {tenantId}_{tenantEnv}. 
	 * 
	 * @see org.springframework.beans.factory.config.Scope#get(java.lang.String, org.springframework.beans.factory.ObjectFactory)
	 */
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		log.info("Get {}, {}", name, objectFactory);
		Application app = Application.get();
		final String appKey = app.getApplicationKey();
		log.info("Wicket app: key={} name={}", appKey, app.getName());
		if (beanMap.containsKey(appKey) && beanMap.get(appKey).containsKey(name)) {
			return beanMap.get(appKey).get(name).bean;
		}
		
		Matcher matcher = Pattern.compile("(.+)_([^_]+)").matcher(appKey);
		if (!matcher.matches()) {
			log.error("Cannot parse application key " + appKey + " into tenantId_tenantEnv");
			throw new RuntimeException("Cannot parse application key " + appKey + " into tenantId_tenantEnv");
		}
		final String tenantId = matcher.group(1);
		final String tenantEnv = matcher.group(2);
		final URI uri = URI.create("service://" + name.replace("scopedTarget.", ""));
		final String className = uri.getHost();
		List<NameValuePair> filterPairs = URLEncodedUtils.parse(uri, "UTF-8");
		log.debug("Lookup {} for tenantId={} tenantEnv={} filters: {}", new Object[] { className, tenantId, tenantEnv, filterPairs });
		String filter = "(&(tenantId=" + tenantId + ")(tenantEnv=" + tenantEnv + ")";
		for (NameValuePair pair : filterPairs) {
			filter += "(" + pair.getName() + "=" + pair.getValue() + ")";
		}
		filter += ")";
		
		ServiceReference serviceRef = null;
		try {
			ServiceReference[] serviceRefs = bundleContext.getServiceReferences(className, filter);
			if (serviceRefs.length == 0)
				throw new RuntimeException("Cannot find " + className + " service with filter " + filter);
			serviceRef = serviceRefs[0];
		} catch (InvalidSyntaxException e) {
			throw new RuntimeException("Cannot find " + className + " service with filter " + filter, e);
		}
		Object bean = bundleContext.getService(serviceRef);
		if (!beanMap.containsKey(appKey))
			beanMap.put(appKey, new ConcurrentHashMap<String, ServiceBean>());
		beanMap.get(appKey).put(name, new ServiceBean(serviceRef, bean));
		return bean;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#remove(java.lang.String)
	 */
	@Override
	public Object remove(String name) {
		log.info("Remove {}", name);
		Application app = Application.get();
		final String appKey = app.getApplicationKey();
		log.info("Wicket app: key={} name={}", appKey, app.getName());
		if (beanMap.containsKey(appKey) && beanMap.get(appKey).containsKey(name)) {
			ServiceReference serviceRef = beanMap.get(appKey).get(name).serviceRef;
			bundleContext.ungetService(serviceRef);
			beanMap.get(appKey).remove(name);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#registerDestructionCallback(java.lang.String, java.lang.Runnable)
	 */
	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		log.trace("Register destruction {}", name);
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#resolveContextualObject(java.lang.String)
	 */
	@Override
	public Object resolveContextualObject(String key) {
		log.trace("Resolve contextual {}", key);
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#getConversationId()
	 */
	@Override
	public String getConversationId() {
		log.trace("Get conversation");
		Application app = Application.get();
		final String appKey = app.getApplicationKey();
		return appKey;
	}

}
