package org.soluvas.web.site;

import org.soluvas.commons.tenant.RequestOrCommandScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.collect.ImmutableMap;

/**
 * Registers {@link RequestOrCommandScope}.
 * 
 * @author ceefour
 * @see AppInitializer
 */
public class RequestOrCommandAppInitializer implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	private boolean scopeConfigurerEnabled;

	public RequestOrCommandAppInitializer(boolean scopeConfigurerEnabled) {
		this.scopeConfigurerEnabled = scopeConfigurerEnabled;
	}

	public RequestOrCommandAppInitializer() {
		this(true);
	}

	/* (non-Javadoc)
         * @see org.springframework.context.ApplicationContextInitializer#initialize(org.springframework.context.ConfigurableApplicationContext)
         */
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		if (scopeConfigurerEnabled) {
			final CustomScopeConfigurer scopeConfigurer = new CustomScopeConfigurer();
			scopeConfigurer.setScopes(ImmutableMap.<String, Object>of(WebApplicationContext.SCOPE_REQUEST, new RequestOrCommandScope()));
			applicationContext.addBeanFactoryPostProcessor(scopeConfigurer);
		}
	}
	
}
