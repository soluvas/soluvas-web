package org.soluvas.web.site.robots;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.config.MultiTenantConfig;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	private MultiTenantConfig tenantConfig;
	@Inject
	private WebAddress webAddress;
	@Inject
	private GeneralSysConfig sysConfig;
	
	@RequestMapping(method = RequestMethod.GET, value = "robots.txt")
	public ResponseEntity<String> getRobotsTxt() {
		final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
		final String body;
		if (MultiTenantConfig.ENV_PRD.equals(tenantConfig.getTenantEnv())) {
			body = "User-Agent: *\n"
				+ "Disallow: \n"
				+ "\n"
				+ "Sitemap: " + baseUri + "sitemap_index.xml\n";
		} else {
			body = "User-Agent: *\n"
					+ "# Search engine crawling is disabled for '" + tenantConfig.getTenantEnv() + "' application environment\n"
					+ "Disallow: /\n";
		}
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setExpires(new DateTime().plusDays(1).getMillis());
		return new ResponseEntity<>(body, headers, HttpStatus.OK);
	}

}
