package org.soluvas.web.site;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ConfigurableWebApplicationContext;

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
		final WebPropertySource webPs = new WebPropertySource("webConfig", applicationContext.getServletContext());
		applicationContext.getEnvironment().getPropertySources().addLast(webPs);
	}

}
