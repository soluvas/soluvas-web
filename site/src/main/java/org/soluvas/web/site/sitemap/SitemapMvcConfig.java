package org.soluvas.web.site.sitemap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author ceefour
 *
 */
@Configuration
public class SitemapMvcConfig {

	@Bean @Scope("request")
	public SitemapController sitemapController() {
		return new SitemapController();
	}

}
