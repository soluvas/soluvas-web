package org.soluvas.web.site.perfectaudience;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.PerfectAudienceSysConfig;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

/**
 * Read me: https://idbippo.atlassian.net/browse/BC-2881
 * 
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class PerfectAudienceBehavior extends Behavior {
	
	private static final Logger log = LoggerFactory
			.getLogger(PerfectAudienceBehavior.class);
	
	@SpringBean
	private PerfectAudienceSysConfig sysConfig;
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		if (Optional.fromNullable(sysConfig.getPerfectAudienceEnabled()).or(false)) {
			if (Strings.isNullOrEmpty(sysConfig.getPerfectAudienceId())) {
				log.warn("Perfect Audience Id must be set");
			} else {
				final String script = "(function() {\n" +
									"window._pa = window._pa || {};\n" +
									// _pa.orderId = "myOrderId"; // OPTIONAL: attach unique conversion identifier to conversions
									// _pa.revenue = "19.99"; // OPTIONAL: attach dynamic purchase values to conversions
									// _pa.productId = "myProductId"; // OPTIONAL: Include product ID for use with dynamic ads
									"var pa = document.createElement('script'); pa.type = 'text/javascript'; pa.async = true;\n" +
									"pa.src = ('https:' == document.location.protocol ? 'https:' : 'http:')+'//tag.perfectaudience.com/serve/" + sysConfig.getPerfectAudienceId() + ".js';\n" +
									"var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(pa, s);\n" +
									"})();\n";
				response.render(StringHeaderItem.forString("<script>\n" + script + "</script>\n"));
			}
		}
	}

}
