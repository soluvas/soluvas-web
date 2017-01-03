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
import org.soluvas.commons.PersonInfo;

import com.google.common.base.Strings;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class CriteoViewHomeBehavior extends Behavior {
	
	private static final Logger log = LoggerFactory
			.getLogger(CriteoViewHomeBehavior.class);
	
	private final IModel<PersonInfo> personInfoModel;
	private final String criteoPartnerId;
	private final boolean isCriteoEnabled;
	
	public CriteoViewHomeBehavior(boolean isCriteoEnabled, String criteoPartnerId, 
			IModel<PersonInfo> personInfoModel) {
		super();
		this.isCriteoEnabled = isCriteoEnabled;
		this.criteoPartnerId = criteoPartnerId;
		this.personInfoModel = personInfoModel;
	}
	
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		
		if (isCriteoEnabled) {
			if (Strings.isNullOrEmpty(criteoPartnerId)) {
				log.warn("Criteo Partner ID must be set");
			} else {
				String mobileDetectLib = "\n<script type=\"text/javascript\" src=\"//wurfl.io/wurfl.js\"></script>\n";
				response.render(StringHeaderItem.forString(mobileDetectLib));
				
				String criteoScript = "\n<script type=\"text/javascript\" src=\"//static.criteo.net/js/ld/ld.js\" async=\"true\"></script>\n";
				String mainScript = "\t\tvar siteType = \"d\";\n";
				mainScript += "\t\tif (WURFL.is_mobile === true && WURFL.form_factor === \"Smartphone\") { siteType = \"m\"; }\n";
				mainScript += "\t\tif (WURFL.is_mobile === true && WURFL.form_factor === \"Tablet\") { siteType = \"t\"; }\n";
				if (personInfoModel.getObject().getEmail() != null) {
					mainScript += String.format("\t\twindow.criteo_q = window.criteo_q || [];\n"
							+ "\t\twindow.criteo_q.push(\n"
							+ "\t\t{event: \"setAccount\", account: %s},\n"
							+ "\t\t{event: \"setEmail\", email: \"%s\"},\n"
							+ "\t\t{event: \"setSiteType\", type: siteType},\n"
							+ "\t\t{event: \"viewHome\"}\n"
							+ ");", criteoPartnerId, DigestUtils.md5Hex(personInfoModel.getObject().getEmail()));
				} else {
					mainScript += String.format("\t\twindow.criteo_q = window.criteo_q || [];\n"
							+ "\t\twindow.criteo_q.push(\n"
							+ "\t\t{event: \"setAccount\", account: %s},\n"
							+ "\t\t{event: \"setSiteType\", type: siteType},\n"
							+ "\t\t{event: \"viewHome\"}\n"
							+ ");", criteoPartnerId);

				}
				
				criteoScript += "<script type=\"text/javascript\">\n"+ mainScript +"</script>\n";
				response.render(StringHeaderItem.forString(criteoScript));
			}
		}
	}
}
