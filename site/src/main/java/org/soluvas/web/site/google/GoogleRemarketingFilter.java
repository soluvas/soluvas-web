package org.soluvas.web.site.google;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.wicket.model.IModel;
import org.apache.wicket.response.filter.IResponseFilter;
import org.apache.wicket.util.string.AppendingStringBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.web.site.GoogleRemarketingSysConfig;

import com.google.common.base.Strings;

/**
 * Puts <a href="http://stackoverflow.com/a/10712960/122441">Google Analytics script in {@code head}</a>.
 * 
 * <p>Google Analytics tracking <a href="https://idbippo.atlassian.net/browse/BC-1397">was not enabled on app/mall role</a>.
 * However, Google Analytics is useful for other things, including server response time tracking,
 * so it should be enabled on all pages including backend pages.
 * 
 * @author ceefour
 */
public class GoogleRemarketingFilter implements IResponseFilter {

	private static final Logger log = LoggerFactory
			.getLogger(GoogleRemarketingFilter.class);
	private final GoogleRemarketingSysConfig sysConfig;
	private final AppManifest appManifest;
	private final IModel<String> localSkuModel;
	private final IModel<BigDecimal> finalPriceProductModel;
	
	
	
	public GoogleRemarketingFilter(final GoogleRemarketingSysConfig sysConfig, final AppManifest appManifest,
			IModel<String> localSkuModel, IModel<BigDecimal> finalPriceProductModel) {
		super();
		this.sysConfig = sysConfig;
		this.appManifest = appManifest;
		this.localSkuModel = localSkuModel;
		this.finalPriceProductModel = finalPriceProductModel;
	}

	@Override
	public AppendingStringBuffer filter(AppendingStringBuffer responseBuffer) {
			int bodyIndex = responseBuffer.lastIndexOf("</body>");
			if (bodyIndex >= 0) {
				if (sysConfig.isGoogleRemarketingEnabled()) {
					// Google Analytics is required for server timing
					if (Strings.isNullOrEmpty(sysConfig.getGoogleRemarketingTagId())) {
						log.warn("Google Remarketing TAG ID must be set");
					} else {
						String script = "";
						script += "<script type=\"text/javascript\"> \n"
								+ "var google_tag_params = { \n"
								+ "ecomm_prodid: '%s', \n"
								+ "ecomm_pagetype: '%s', \n"
								+ "ecomm_totalvalue: %s, \n"
								+ "dynx_itemid: '%s', \n"
								+ "dynx_pagetype: '%s', \n"
								+ "dynx_totalvalue: %s, \n"
								+ "}; \n"
								+ "</script> \n"
								+ "\n"
								+ "<script type=\"text/javascript\"> \n"
								+ "var google_conversion_id = %s; \n"
								+ "var google_custom_params = window.google_tag_params; \n"
								+ "var google_remarketing_only = true; \n"
								+ "</script> \n"
								+ "\n"
								+ "<script type=\"text/javascript\" src=\"//www.googleadservices.com/pagead/conversion.js\"> \n"
								+ "</script> \n"
								+ "\n"
								+ "<noscript> \n"
								+ "<div style=\"display:inline;\"> \n"
								+ "<img height=\"1\" width=\"1\" style=\"border-style:none;\" alt=\"\" src=\"//googleads.g.doubleclick.net/pagead/viewthroughconversion/%s/?guid=ON&amp;script=0\"/> \n"
								+ "</div> \n"
								+ "</noscript> \n";
						script = String.format(script,
								StringEscapeUtils.escapeEcmaScript(localSkuModel.getObject()), "product", finalPriceProductModel.getObject().setScale(2, RoundingMode.HALF_EVEN),
								StringEscapeUtils.escapeEcmaScript(localSkuModel.getObject()), "offerdetail", finalPriceProductModel.getObject().setScale(2, RoundingMode.HALF_EVEN),
								sysConfig.getGoogleRemarketingTagId(), sysConfig.getGoogleRemarketingTagId());
						
						responseBuffer.insert(bodyIndex - 1, script);
					}
				}
				responseBuffer.insert(bodyIndex - 1, "");
				
			}
		return responseBuffer;
	}
	
}
