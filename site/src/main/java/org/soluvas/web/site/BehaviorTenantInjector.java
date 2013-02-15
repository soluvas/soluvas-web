package org.soluvas.web.site;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.wicket.Application;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.handler.ListenerInterfaceRequestHandler;
import org.apache.wicket.request.handler.RenderPageRequestHandler;
import org.apache.wicket.request.mapper.StalePageException;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ReflectionUtils;
import org.soluvas.commons.inject.Filter;
import org.soluvas.commons.inject.Namespace;
import org.soluvas.commons.inject.Supplied;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.web.site.osgi.WebTenantUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterables;

/**
 * Injects Wicket {@link Component}s using {@link TenantInjectionBehavior}.
 * 
 * Supported annotations are: {@link Inject}, {@link Namespace}, {@link Filter}, {@link Supplied}.
 * 
 * The Wicket app's {@link Application#getApplicationKey()} must be {tenantId}_{tenantEnv}.
 * 
 * @author ceefour
 */
public class BehaviorTenantInjector extends AbstractRequestCycleListener implements IComponentInstantiationListener {

	public static final class InjectVisitor implements
			IVisitor<Component, Void> {
		@Override
		public void component(Component component, IVisit<Void> visit) {
			TenantInjectionBehavior injectionBehavior = Iterables.getFirst(
					component.getBehaviors(TenantInjectionBehavior.class), null);
			if (injectionBehavior != null) {
				injectionBehavior.inject(component, "ajaxRequestTarget");
			}
		}
	}

	private static Logger log = LoggerFactory.getLogger(BehaviorTenantInjector.class);
	
	@SuppressWarnings("rawtypes")
	@Override
	public void onInstantiation(Component component) {
		final TenantRef tenant = WebTenantUtils.getTenant();
		final String tenantId = tenant.getTenantId();
		final String tenantEnv = tenant.getTenantEnv();
		
		final List<Field> fields = ReflectionUtils.getAllFields(component.getClass());
		
		final String componentId = component instanceof org.apache.wicket.Page ? component.getClass().getName() : component.getId();
		final BundleContext bundleContext = Preconditions.checkNotNull(FrameworkUtil.getBundle(component.getClass()).getBundleContext(),
				"Cannot get BundleContext for Wicket component %s %s", component.getClass().getName(), componentId);
		boolean needBehavior = false;
		for (Field field : fields) {
			final Inject injectAnn = field.getAnnotation(Inject.class);
			if (injectAnn == null)
				continue;
			
			final Supplied supplied = field.getAnnotation(Supplied.class);
			if (supplied == null) {
				needBehavior = true;
			} else {
				final Namespace namespaced = field.getAnnotation(Namespace.class);
				final String namespace = namespaced != null ? namespaced.value() : null;
				final String namespaceFilter = namespace != null ? "(namespace=" + namespace + ")" : "";
				
				final Filter filtered = field.getAnnotation(Filter.class);
				final String additionalFilter = filtered != null ? filtered.value() : "";

				final Class<?> suppliedClass = field.getType();
				
				log.trace("Field {}#{} needs Supplier<{}> for tenantId={} tenantEnv={} namespace={} filter: {}", new Object[] {
						componentId, field.getName(), suppliedClass.getName(), tenantId, tenantEnv, namespace, additionalFilter });
				final String suppliedClassFilter = supplied != null ? "(suppliedClass=" + field.getType().getName() + ")(layer=application)" : "";
				final String filter = "(&" + String.format("(|(tenantId=%s)(tenantId=\\*))(|(tenantEnv=%s)(tenantEnv=\\*))", tenantId, tenantEnv)
						+ namespaceFilter + suppliedClassFilter + additionalFilter + ")";
				
				final Collection<ServiceReference<Supplier>> serviceRefs;
				try {
					serviceRefs = bundleContext.getServiceReferences(Supplier.class, filter);
				} catch (InvalidSyntaxException e) {
					throw new SiteException("Cannot inject " + componentId + "#" + field.getName() + ", invalid " +
							suppliedClass.getName() + " Supplier service with filter " + filter, e);
				}
				if (serviceRefs == null || serviceRefs.isEmpty()) {
					throw new SiteException("Cannot find " + suppliedClass.getName() + " supplier for " + componentId + "#" + field.getName() + ", " +
							"Supplier with " + filter + " not found");
				}
				final ServiceReference<Supplier> serviceRef = serviceRefs.iterator().next();
				final Supplier supplier = bundleContext.getService(serviceRef);
				try {
					final Object suppliedObj = supplier.get();
					log.trace("Injecting {}#{} as {}", componentId, field.getName(), suppliedObj);
					FieldUtils.writeField(field, component, suppliedObj, true);
				} catch (Exception e) {
					log.error("Cannot inject " + componentId + "#" + field.getName() + " from " + supplier, e);
					throw new SiteException("Cannot inject " + componentId + "#" + field.getName() + " from " + supplier, e);
				} finally {
					bundleContext.ungetService(serviceRef);
				}
			}
		}
		if (needBehavior) {
			final TenantInjectionBehavior behavior = new TenantInjectionBehavior(bundleContext, tenantId, tenantEnv);
			behavior.inject(component, "onInstantiation");	// perform first injection
			component.add( behavior );
		}
	}
	
	@Override
	public void onRequestHandlerResolved(RequestCycle cycle,
			IRequestHandler handler) {
		log.trace("onRequestHandlerResolved {} {}", handler.getClass(), handler);
		try {
			if (handler instanceof RenderPageRequestHandler) {
				final RenderPageRequestHandler renderPageHandler = (RenderPageRequestHandler) handler;
				if (renderPageHandler.isPageInstanceCreated()) {
					final Page page = (Page) renderPageHandler.getPage();
					injectPage(page);
				}
				// sometimes (?) inject was not run yet before Wicket calls beforeRender...
				// but I can't reproduce it again (huh!)
			} else if (handler instanceof ListenerInterfaceRequestHandler) {
				final ListenerInterfaceRequestHandler listenerInterfaceHandler = (ListenerInterfaceRequestHandler) handler;
				log.trace("onRequestHandlerResolved {} {} isPageInstanceCreated={}",
						handler.getClass(), handler, listenerInterfaceHandler.isPageInstanceCreated());
				if (listenerInterfaceHandler.isPageInstanceCreated()) {
					final Page page = (Page) listenerInterfaceHandler.getPage();
					injectPage(page);
				}
			}
		} catch (StalePageException e) {
			log.debug("StalePageException during onRequestHandlerResolved " +
					handler.getClass() + " " + handler, e);
		}
		super.onRequestHandlerResolved(cycle, handler);
	}
	
	@Override
	public void onRequestHandlerScheduled(RequestCycle reqCycle,
			IRequestHandler handler) {
		log.trace("onRequestHandlerScheduled {} {}", handler.getClass(), handler);
		try {
			if (handler instanceof AjaxRequestTarget) {
				final Page page = ((AjaxRequestTarget) handler).getPage();
				injectPage(page);
			} else if (handler instanceof RenderPageRequestHandler) {
				final RenderPageRequestHandler renderPageHandler = (RenderPageRequestHandler) handler;
				if (renderPageHandler.isPageInstanceCreated()) {
					final Page page = (Page) renderPageHandler.getPage();
					injectPage(page);
				}
			}
		} catch (StalePageException e) {
			log.debug("StalePageException during onRequestHandlerScheduled " +
					handler.getClass() + " " + handler, e);
		}
		super.onRequestHandlerScheduled(reqCycle, handler);
	}
	
	/**
	 * @param page
	 */
	protected void injectPage(final Page page) {
		final InjectVisitor injectVisitor = new InjectVisitor();
		injectVisitor.component(page, null);
		page.visitChildren(injectVisitor);
	}
	
}
