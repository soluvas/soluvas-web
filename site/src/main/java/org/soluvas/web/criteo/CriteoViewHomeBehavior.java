/**
 * 
 */
package org.soluvas.web.criteo;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class CriteoViewHomeBehavior extends Behavior {
	
	private static final Logger log = LoggerFactory
			.getLogger(CriteoViewHomeBehavior.class);
	
	private final IModel<String> emailModel;
	
	public CriteoViewHomeBehavior(IModel<String> emailModel) {
		super();
		this.emailModel = emailModel;
	}
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		//TODO: ambil dari sysconfig
		final boolean isCriteoEnable = true;
		final String criteoPartnerId = "35754";
		final String emailHash = DigestUtils.md5Hex("atang@bippo.co.id");
		
		if (isCriteoEnable) {
			if (Strings.isNullOrEmpty(criteoPartnerId)) {
				log.warn("Criteo Partner ID must be set");
			} else {
				String criteoScript = "\n<script type=\"text/javascript\" src=\"//static.criteo.net/js/ld/ld.js\" async=\"true\"></script>\n";
				String mainScript = String.format("\t\twindow.criteo_q = window.criteo_q || [];\n"
						+ "\t\twindow.criteo_q.push(\n"
						+ "\t\t{event: \"setAccount\", account: %s},\n"
						+ "\t\t{event: \"setEmail\", email: \"%s\"},\n"
						+ "\t\t{event: \"setSiteType\", type: \"d\"},\n"
						+ "\t\t{event: \"viewHome\"}\n"
						+ ");", criteoPartnerId, emailHash);
				criteoScript += "<script type=\"text/javascript\">\n"+ mainScript +"</script>\n";
				response.render(StringHeaderItem.forString(criteoScript));
			}
		}
	}
}
