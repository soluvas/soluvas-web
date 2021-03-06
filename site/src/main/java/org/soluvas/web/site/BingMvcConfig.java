package org.soluvas.web.site;

import org.soluvas.web.site.bing.BingVerifyController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author ceefour
 *
 */
@Configuration
public class BingMvcConfig {
	
	@Bean @Scope("request")
	public BingVerifyController bingVerifyController() {
		return new BingVerifyController();
	}

}
