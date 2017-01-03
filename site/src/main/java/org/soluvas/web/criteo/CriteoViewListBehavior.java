/**
 * 
 */
package org.soluvas.web.criteo;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
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
public class CriteoViewListBehavior extends Behavior {
	private static final Logger log = LoggerFactory
			.getLogger(CriteoViewListBehavior.class);
	
	private final List<String> itemIds;
	private final String criteoPartnerId;
	private final boolean isCriteoEnabled;
	private final IModel<PersonInfo> personInfoModel;
	
	public CriteoViewListBehavior(boolean isCriteoEnabled, 
			String criteoPartnerId, List<String> itemIds, IModel<PersonInfo> personInfoModel) {
		super();
		this.isCriteoEnabled = isCriteoEnabled;
		this.criteoPartnerId = criteoPartnerId;
		this.itemIds = itemIds;
		this.personInfoModel = personInfoModel;
	}
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		
		if (isCriteoEnabled) {
			if (Strings.isNullOrEmpty(criteoPartnerId)) {
				log.warn("Criteo Partner ID must be set");
			} else {
				String mobileDetectLib = "\n<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/mobile-detect/1.3.5/mobile-detect.min.js\"></script>\n";
				response.render(StringHeaderItem.forString(mobileDetectLib));
				
				String criteoScript = "\n<script type=\"text/javascript\" src=\"//static.criteo.net/js/ld/ld.js\" async=\"true\"></script>\n";
				String mainScript;
				String itemIdArr = StringUtils.join(itemIds, ",");
				if (personInfoModel.getObject().getEmail() != null) {
					mainScript = String.format("\t\twindow.criteo_q = window.criteo_q || [];\n"
							+ "\t\twindow.criteo_q.push(\n"
							+ "\t\t{event: \"setAccount\", account: %s},\n"
							+ "\t\t{event: \"setEmail\", email: \"%s\"},\n"
							+ "\t\t{event: \"setSiteType\", type: \"d\"},\n"
							+ "\t\t{event: \"viewItem\", item: [%s]}\n"
							+ "\t\t);\n", 
							criteoPartnerId, 
							DigestUtils.md5Hex(personInfoModel.getObject().getEmail()), 
							itemIdArr);
				} else {
					mainScript = String.format("\t\twindow.criteo_q = window.criteo_q || [];\n"
							+ "\t\twindow.criteo_q.push(\n"
							+ "\t\t{event: \"setAccount\", account: %s},\n"
							+ "\t\t{event: \"setSiteType\", type: \"d\"},\n"
							+ "\t\t{event: \"viewItem\", item: [%s]}\n"
							+ "\t\t);\n", 
							criteoPartnerId, 
							itemIdArr);
					
				}
				criteoScript += "<script type=\"text/javascript\">\n"+ mainScript +"</script>\n";
				response.render(StringHeaderItem.forString(criteoScript));
			}
		}
		
	}
	
}
