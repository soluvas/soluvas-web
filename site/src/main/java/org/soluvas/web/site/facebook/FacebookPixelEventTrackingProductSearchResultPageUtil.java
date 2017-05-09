package org.soluvas.web.site.facebook;

import java.util.List;

import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;
import org.ocpsoft.common.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.socmed.FacebookSysConfig;

/**
 *Render firt in head for {@link FacebookPixelBehavior}
 * 
 * @author ceefour
 * @see FacebookSysConfig#getFacebookPixelEnabled()
 * @see FacebookSysConfig#getFacebookPixelId()
 */
public class FacebookPixelEventTrackingProductSearchResultPageUtil {

	private static final Logger log = LoggerFactory
			.getLogger(FacebookPixelEventTrackingProductSearchResultPageUtil.class);
	
	public static OnDomReadyHeaderItem get(final IModel<String> searchStringModel, final IModel<List<String>> contentIdsModel) {
		
		String contentIds;
		if (contentIdsModel.getObject() != null && !contentIdsModel.getObject().isEmpty()) {
			contentIds = "['";
			contentIds += Strings.join(contentIdsModel.getObject(), "','");
			contentIds += "']";
		} else {
			contentIds = "[]";
		}
		
		final String script = ""
				+ "fbq('track', 'Search', { \n"
				+ "search_string: '" + searchStringModel.getObject() + "', \n"
				+ "content_ids: " + contentIds + ", \n"
				+ "content_type: 'product' \n"
				+ "}); \n";
		return OnDomReadyHeaderItem.forScript(script);
	}
	
}
