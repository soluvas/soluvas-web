package org.soluvas.web.site;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.osgi.framework.BundleContext;
import org.soluvas.commons.tenant.TenantInjection;

/**
 * Injects {@link Inject} tenant services before render, and uninjects after render.
 * Created by {@link BehaviorTenantInjector}.
 * @see TenantInjection
 * @author ceefour
 */
@SuppressWarnings("serial")
public class TenantInjectionBehavior extends Behavior {
	
	private final TenantInjection tenantInjection;
	
	/**
	 * @param bundleContext
	 * @param tenantId
	 * @param tenantEnv
	 */
	public TenantInjectionBehavior(final BundleContext bundleContext,
			final String tenantId, final String tenantEnv) {
		super();
		tenantInjection = new TenantInjection(bundleContext, tenantId, tenantEnv);
	}
	
	/**
	 * Perform injection.
	 * @param component
	 * @param phase 
	 */
	public void inject(final Component component, final String phase) {
		final String componentId = component instanceof org.apache.wicket.Page ? component.getClass().getName() : component.getId();
		tenantInjection.inject(component, componentId, phase);
	}
	
	/**
	 * Uninjects injected fields.
	 * @param component
	 * @param phase 
	 */
	public void uninject(final Component component, final String phase) {
		final String componentId = component instanceof org.apache.wicket.Page ? component.getClass().getName() : component.getId();
		tenantInjection.uninject(component, componentId, phase);
	}

	@Override
	public void detach(final Component component) {
		uninject(component, "detach");
		super.detach(component);
	}
	
	@Override
	public void afterRender(final Component component) {
		// Behaviors are "rendered" after 'afterRender', and they can use IModel's
		// so we must make sure things are still injected when the Behaviors execute
		super.afterRender(component);
//		uninject(component, "afterRender");
	}
	
}
