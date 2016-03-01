package org.soluvas.web.site;

import java.util.UUID;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * For {@link ConfigurableWebApplicationContext} only, registers {@link WebPropertySource} which provides {@code configDir}.
 * 
 * <p>Usage:
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
 * @see WebPropertySource
 * @see RequestOrCommandAppInitializer
 * @deprecated With Spring Boot and putting configuration in {@code config/} + {@code workspace.folder},
 * 	this is no longer needed.
 */
@Deprecated
public class AppInitializer extends RequestOrCommandAppInitializer {

	public AppInitializer(boolean scopeConfigurerEnabled) {
		super(scopeConfigurerEnabled);
	}

	public AppInitializer() {
	}

	/* (non-Javadoc)
         * @see org.springframework.context.ApplicationContextInitializer#initialize(org.springframework.context.ConfigurableApplicationContext)
         */
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		super.initialize(applicationContext);
		applicationContext.setId(UUID.randomUUID().toString().substring(0, 8)); // make it easy to identify in logs
		final WebPropertySource webPs = new WebPropertySource("webConfig", ((ConfigurableWebApplicationContext) applicationContext).getServletContext());
		applicationContext.getEnvironment().getPropertySources().addLast(webPs);
	}
	
}
