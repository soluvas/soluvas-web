/**
 * 
 */
package org.soluvas.web.criteo;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.PersonInfo;

import com.google.common.base.Strings;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class CriteoViewItemBehavior extends Behavior {
	private static final Logger log = LoggerFactory
			.getLogger(CriteoViewItemBehavior.class);
	
	private final String criteoPartnerId;
	private final boolean isCriteoEnabled;
	private final IModel<PersonInfo> personInfoModel;
	private final String itemId;

	public CriteoViewItemBehavior(boolean isCriteoEnabled, 
			String criteoPartnerId, String itemId, IModel<PersonInfo> personInfoModel) {
		super();
		this.isCriteoEnabled = isCriteoEnabled;
		this.criteoPartnerId = criteoPartnerId;
		this.personInfoModel = personInfoModel;
		this.itemId = itemId;
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
				String mainScript = String.format("\t\twindow.criteo_q = window.criteo_q || [];\n"
						+ "\t\twindow.criteo_q.push(\n"
						+ "\t\t{event: \"setAccount\", account: %s},\n"
						+ "\t\t{event: \"setEmail\", email: \"%s\"},\n"
						+ "\t\t{event: \"setSiteType\", type: \"d\"},\n"
						+ "\t\t{event: \"viewItem\", item: \"%s\"}\n"
						+ ");", criteoPartnerId, email, itemId);
				criteoScript += "<script type=\"text/javascript\">\n"+ mainScript +"</script>";
				response.render(StringHeaderItem.forString(criteoScript));
			}
		}
	}
}
