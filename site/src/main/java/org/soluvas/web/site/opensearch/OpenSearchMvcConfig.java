package org.soluvas.web.site.opensearch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author ceefour
 * @see org.soluvas.web.site.opensearch.OpenSearchLink
 * @see org.soluvas.web.site.opensearch.OpenSearchController
 */
@Configuration
public class OpenSearchMvcConfig {

	@Bean @Scope("request")
	public OpenSearchController openSearchController() {
		return new OpenSearchController();
	}

}
