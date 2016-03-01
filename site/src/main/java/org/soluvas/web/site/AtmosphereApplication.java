package org.soluvas.web.site;

import java.nio.charset.Charset;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.wicket.Application;
import org.apache.wicket.IApplicationListener;
import org.apache.wicket.protocol.http.WebApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Wicket {@link WebApplication} that publishes all Guava {@link EventBus} events to an Atmosphere {@link org.apache.wicket.atmosphere.EventBus}.
 * @author ceefour
 * @see SecuredWicketAtmosphereHandler
 */
public abstract class AtmosphereApplication extends WebApplication {
	
	private static final Logger log = LoggerFactory
			.getLogger(AtmosphereApplication.class);
	@Inject @Named("appEventBus")
	private EventBus appEventBus;
	private org.apache.wicket.atmosphere.EventBus atmosphereEventBus;
	
	@Override
	protected void init() {
		super.init();
		log.info("Wicket default markup encoding: {} (usually null). defaultCharset={}, LANG={}",
				getMarkupSettings().getDefaultMarkupEncoding(), Charset.defaultCharset(), System.getenv("LANG"));
		try {
			atmosphereEventBus = new org.apache.wicket.atmosphere.EventBus(this);
			getApplicationListeners().add(new IApplicationListener() {
				@Override
				public void onBeforeDestroyed(Application application) {
					log.info("Unregistering {} from EventBus {}", application, appEventBus);
					appEventBus.unregister(AtmosphereApplication.this);
				}
				
				@Override
				public void onAfterInitialized(Application application) {
					log.info("Registering {} to EventBus {}", application, appEventBus);
					appEventBus.register(AtmosphereApplication.this);
				}
			});
		} catch (Exception e) {
			// log error, but let application continue without Atmosphere
			log.error("Cannot initialize Wicket Atmosphere EventBus, continuing without Atmosphere support", e);
		}
	}
	
	@Subscribe
	public void bridgeToAtmosphere(Object obj) {
//		log.trace("Bridging {}", obj.getClass().getName());
		atmosphereEventBus.post(obj);
	}

}
