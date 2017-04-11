package org.soluvas.web.site.google;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.GoogleRemarketingSysConfig;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;


/**
 * @author rudi
 *
 */
public class GoogleRemarketingPreAndPraCheckoutPageUtils {

	private static final Logger log = LoggerFactory
			.getLogger(GoogleRemarketingPreAndPraCheckoutPageUtils.class);
	
	public static final List<HeaderItem> getScripts(final GoogleRemarketingSysConfig sysConfig, final Map<String, BigDecimal> productMap) {
		if (sysConfig.isGoogleRemarketingEnabled()) {
			// Google Analytics is required for server timing
			if (Strings.isNullOrEmpty(sysConfig.getGoogleRemarketingTagId())) {
				log.warn("Google Remarketing TAG ID must be set");
			} else {
				final List<HeaderItem> scriptList = new ArrayList<>();

				String productIdsString = "";
				if (productMap.size() > 1) {
					productIdsString += "['";
					productIdsString += StringUtils.join(productMap.keySet().stream().map(new Function<String, String>() {
						@Override
						public String apply(String t) {
							return StringEscapeUtils.escapeEcmaScript(t);
						}
					}).collect(Collectors.toList()), "','");
					productIdsString += "']";
				} else {
					if (productMap.isEmpty()) {
						productIdsString += "null";
					} else {
						productIdsString += "'" + StringEscapeUtils.escapeEcmaScript(productMap.keySet().iterator().next()) + "'";
					}
				}
				
				final List<BigDecimal> scaledPriceList = productMap.values().stream().map(new Function<BigDecimal, BigDecimal>() {
					@Override
					public BigDecimal apply(BigDecimal t) {
						return t.setScale(2, RoundingMode.HALF_EVEN);
					}
				}).collect(Collectors.toList());
				
				
				final String script1 = String.format("var google_tag_params = { \n"
						+ "ecomm_prodid: %s, \n"
						+ "ecomm_pagetype: '%s', \n"
						+ "ecomm_totalvalue: %s, \n"
						+ "dynx_itemid: %s, \n"
						+ "dynx_pagetype: '%s', \n"
						+ "dynx_totalvalue: %s, \n"
						+ "}; \n", productIdsString, "purchase", scaledPriceList.size() > 1 ? scaledPriceList : (scaledPriceList.isEmpty() ? "null" : scaledPriceList.get(0)),
						productIdsString, "conversion", scaledPriceList.size() > 1 ? scaledPriceList : (scaledPriceList.isEmpty() ? "null" : scaledPriceList.get(0)));
				scriptList.add(JavaScriptHeaderItem.forScript(script1, null));
				
				final String script2 = String.format("var google_conversion_id = %s; \n"
						+ "var google_custom_params = window.google_tag_params; \n"
						+ "var google_remarketing_only = true; \n", sysConfig.getGoogleRemarketingTagId());
				scriptList.add(JavaScriptHeaderItem.forScript(script2, null));
				
				scriptList.add(JavaScriptHeaderItem.forUrl("//www.googleadservices.com/pagead/conversion.js"));
				
				scriptList.add(StringHeaderItem.forString(String.format("<noscript> \n"
						+ "<div style=\"display:inline;\"> \n"
						+ "<img height=\"1\" width=\"1\" style=\"border-style:none;\" alt=\"\" src=\"//googleads.g.doubleclick.net/pagead/viewthroughconversion/%s/?guid=ON&amp;script=0\"/> \n"
						+ "</div> \n"
						+ "</noscript> \n", sysConfig.getGoogleRemarketingTagId())));
						
						
				return scriptList;
			}
		}
//		return JavaScriptHeaderItem.forScript("", null);
		return ImmutableList.of();
	}

}
