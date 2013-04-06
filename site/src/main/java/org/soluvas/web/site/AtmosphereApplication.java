package org.soluvas.web.site;

import javax.inject.Inject;

import org.apache.wicket.Application;
import org.apache.wicket.IApplicationListener;
import org.apache.wicket.protocol.http.WebApplication;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Wicket {@link WebApplication} that publishes all Guava {@link EventBus} events to an Atmosphere {@link org.apache.wicket.atmosphere.EventBus}.
 * @author ceefour
 */
public abstract class AtmosphereApplication extends WebApplication {
	
	@Inject
	private EventBus eventBus;
	private org.apache.wicket.atmosphere.EventBus atmosphereEventBus;
	
	@Override
	protected void init() {
		super.init();
		atmosphereEventBus = new org.apache.wicket.atmosphere.EventBus(this);
		eventBus.register(this);
		getApplicationListeners().add(new IApplicationListener() {
			@Override
			public void onBeforeDestroyed(Application application) {
				eventBus.unregister(this);
			}
			
			@Override
			public void onAfterInitialized(Application application) {
			}
		});
	}

	@Subscribe
	public void bridgeToAtmosphere(Object obj) {
		atmosphereEventBus.post(obj);
	}

}
