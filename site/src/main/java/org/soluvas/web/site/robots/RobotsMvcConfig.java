package org.soluvas.web.site.robots;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author ceefour
 *
 */
@Configuration
public class RobotsMvcConfig {

	@Bean @Scope("request")
	public RobotsTxtController robotsTxtController() {
		return new RobotsTxtController();
	}

}
