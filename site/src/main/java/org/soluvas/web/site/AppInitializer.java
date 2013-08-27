package org.soluvas.web.site;

import java.util.UUID;

import org.soluvas.commons.tenant.RequestOrCommandScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.collect.ImmutableMap;

/**
 * Registers {@link WebPropertySource}. Usage:
 * 
 * <pre>{@literal
 * 	<context-param>
 * 		<param-name>contextClass</param-name>
 * 		<param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
 * 	</context-param>
 * 	<context-param>
 * 		<param-name>contextConfigLocation</param-name>
 * 		<param-value>com.quikdo.hub.app.AppConfig</param-value>
 * 	</context-param>
 * 	<context-param>
 * 		<param-name>contextInitializerClasses</param-name>
 * 		<param-value>org.soluvas.web.site.AppInitializer</param-value>
 * 	</context-param>
 * 	<context-param>
 * 		<param-name>configuration</param-name>
 * 		<param-value>development</param-value>
 * 	</context-param>
 * 	<listener>
 * 		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 * 	</listener>
 * 	<listener>
 * 		<listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
 * 	</listener>
 * }</pre>
 * 
 * @author ceefour
 */
public class AppInitializer implements
		ApplicationContextInitializer<ConfigurableWebApplicationContext> {

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextInitializer#initialize(org.springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void initialize(ConfigurableWebApplicationContext applicationContext) {
		applicationContext.setId(UUID.randomUUID().toString().substring(0, 8)); // make it easy to identify in logs
		final WebPropertySource webPs = new WebPropertySource("webConfig", applicationContext.getServletContext());
		applicationContext.getEnvironment().getPropertySources().addLast(webPs);
		final CustomScopeConfigurer scopeConfigurer = new CustomScopeConfigurer();
		scopeConfigurer.setScopes(ImmutableMap.<String, Object>of(WebApplicationContext.SCOPE_REQUEST, new RequestOrCommandScope()));
		applicationContext.addBeanFactoryPostProcessor(scopeConfigurer);
	}
	
}
