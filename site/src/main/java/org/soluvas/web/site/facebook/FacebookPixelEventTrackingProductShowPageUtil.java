package org.soluvas.web.site.facebook;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.money.CurrencyUnit;

import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;
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
public class FacebookPixelEventTrackingProductShowPageUtil {

	private static final Logger log = LoggerFactory
			.getLogger(FacebookPixelEventTrackingProductShowPageUtil.class);
	
	public static OnDomReadyHeaderItem get(final IModel<String> localSkuModel, final IModel<BigDecimal> finalPriceModel,
			final IModel<CurrencyUnit> currencyUnitModel) {
		
		final String script = "fbq('track', 'ViewContent', { \n"
				+ "content_ids: ['" + localSkuModel.getObject() + "'], \n"
				+ "content_type: 'product', \n"
				+ "value: " + finalPriceModel.getObject().setScale(2, RoundingMode.CEILING) + " , \n"
				+ "currency: '" + currencyUnitModel.getObject().getCurrencyCode() + "' \n"
				+ "});";
		
		return OnDomReadyHeaderItem.forScript(script);
	}
	
}
