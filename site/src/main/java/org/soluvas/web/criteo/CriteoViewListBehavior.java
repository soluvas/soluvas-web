/**
 * 
 */
package org.soluvas.web.criteo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class CriteoViewListBehavior extends Behavior {
	private static final Logger log = LoggerFactory
			.getLogger(CriteoViewListBehavior.class);
	private final List<String> itemIds;

	public CriteoViewListBehavior(List<String> itemIds) {
		super();
		this.itemIds = itemIds;
	}
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		//TODO: ambil dari sysconfig
		final boolean isCriteoEnable = true;
		final String criteoPartnerId = "35754";
		final String email = "atang@bippo.co.id";
		
		if (isCriteoEnable) {
			if (Strings.isNullOrEmpty(criteoPartnerId)) {
				log.warn("Criteo Partner ID must be set");
			} else {
				String criteoScript = "\n<script type=\"text/javascript\" src=\"//static.criteo.net/js/ld/ld.js\" async=\"true\"></script>\n";
				
				String itemIdArr = StringUtils.join(itemIds, ",");
				String mainScript = String.format("\t\twindow.criteo_q = window.criteo_q || [];\n"
						+ "\t\twindow.criteo_q.push(\n"
						+ "\t\t{event: \"setAccount\", account: %s},\n"
						+ "\t\t{event: \"setEmail\", email: \"%s\"},\n"
						+ "\t\t{event: \"setSiteType\", type: \"d\"},\n"
						+ "\t\t{event: \"viewItem\", item: [%s]}\n"
						+ ");", 
						criteoPartnerId, 
						email, 
						itemIdArr);
				criteoScript += "<script type=\"text/javascript\">\n"+ mainScript +"</script>";
				response.render(StringHeaderItem.forString(criteoScript));
			}
		}
		
	}
	
}
