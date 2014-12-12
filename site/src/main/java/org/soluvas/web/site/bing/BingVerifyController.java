package org.soluvas.web.site.bing;

import javax.inject.Inject;

import org.joda.time.DateTime;
import org.soluvas.web.site.BingSysConfig;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;

/**
 * @author ceefour
 * @see BingSysConfig
 */
@RestController
@Scope("request")
public class BingVerifyController {
	
	@Inject
	private BingSysConfig bingSysConfig;

	@RequestMapping(method = RequestMethod.GET, value = "BingSiteAuth.xml")
	public ResponseEntity<?> getBingSiteAuth() {
		if (!Strings.isNullOrEmpty(bingSysConfig.getBingVerifyId())) {
			final String body = "<?xml version=\"1.0\"?>\n"
					+ "<users>\n"
					+ "  <user>" + bingSysConfig.getBingVerifyId() + "</user>"
					+ "</users>\n";
			return ResponseEntity.ok()
					.header("Expires", Long.toString(new DateTime().plusWeeks(1).getMillis()))
					.body(body);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
