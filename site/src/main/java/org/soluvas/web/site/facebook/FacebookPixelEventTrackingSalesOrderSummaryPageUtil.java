package org.soluvas.web.site.facebook;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.money.CurrencyUnit;

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
public class FacebookPixelEventTrackingSalesOrderSummaryPageUtil {

	private static final Logger log = LoggerFactory
			.getLogger(FacebookPixelEventTrackingSalesOrderSummaryPageUtil.class);
	
	public static OnDomReadyHeaderItem get(final IModel<List<String>> contentIdsModel, final IModel<List<String>> contentsModel,
			final IModel<BigDecimal> amountModel, final IModel<CurrencyUnit> currenyModel) {
		
		String contentIds;
		if (contentIdsModel.getObject() != null && !contentIdsModel.getObject().isEmpty()) {
			contentIds = "['";
			contentIds += Strings.join(contentIdsModel.getObject(), "','");
			contentIds += "']";
		} else {
			contentIds = "[]";
		}
		
		String contents;
		if (contentsModel.getObject() != null && !contentsModel.getObject().isEmpty()) {
			contents = "[";
			contents += Strings.join(contentsModel.getObject(), ",");
			contents += "]";
		} else {
			contents = "[]";
		}
		
		final String script = "fbq('track', 'Purchase', { \n"
				+ "content_ids: " + contentIds + ", \n"
				+ "content_type: 'product', \n"
				+ "value: " + amountModel.getObject().setScale(2, RoundingMode.CEILING) + ", \n"
				+ "currency: '" + currenyModel.getObject().getCurrencyCode() + "', \n"
				+ "contents: " + contents + " \n"
				+ "});";
		
		
		return OnDomReadyHeaderItem.forScript(script);
	}
	
}
