package org.soluvas.web.site.robots;

import javax.inject.Inject;

import org.soluvas.commons.WebAddress;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ceefour
 *
 */
@RestController
@Scope("request")
public class RobotsTxtController {
	
	@Inject
	private WebAddress webAddress;
	
	@RequestMapping(method = RequestMethod.GET, value = "robots.txt")
	public String getRobotsTxt() {
		// TODO: SSL support
		return "User-Agent: *\n"
				+ "Disallow: \n"
				+ "Sitemap: " + webAddress.getBaseUri() + "sitemap_index.xml\n";
	}

}
