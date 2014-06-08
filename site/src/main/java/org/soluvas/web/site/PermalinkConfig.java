package org.soluvas.web.site;

import org.soluvas.commons.StaticXmiLoader;
import org.soluvas.web.site.impl.PermalinkManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Uses {@code default.PermalinkCatalog.xmi}.
 * @author ceefour
 */
@Configuration
public class PermalinkConfig {
	
	@Bean
	public PermalinkCatalog permalinkCatalog() {
		return new StaticXmiLoader<PermalinkCatalog>(SitePackage.eINSTANCE,
			PermalinkConfig.class, "default.PermalinkCatalog.xmi").get();
	}
	
	@Bean
	public PermalinkManager permalinkMgr() {
		return new PermalinkManagerImpl(permalinkCatalog());
	}

}
