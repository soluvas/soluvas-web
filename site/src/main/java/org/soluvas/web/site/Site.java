package org.soluvas.web.site;

import java.io.Serializable;

import org.soluvas.commons.AppManifest;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.webaddress.WebAddress;

/**
 * This is for branding only, not for web page rendering.
 * 
 * For web page rendering metadata, please use {@link Page} and {@link PageRule} suppliers.
 * 
 * @author ceefour
 * @deprecated Will be replaced by {@link AppManifest}, {@link WebAddress} and other EMF models.
 */
@Deprecated
public interface Site extends Serializable {

	String getSiteTitle();

	void setSiteTitle(String siteTitle);

	String getHomeTitle();

	void setHomeTitle(String homeTitle);

	String getPageTitleSuffix();

	void setPageTitleSuffix(String pageTitleSuffix);

	String getLogoText();

	void setLogoText(String logoText);

	String getLogoAlt();

	void setLogoAlt(String logoAlt);

	@Override
	String toString();

	String getFooterHtml();
	void setFooterHtml(String footerHtml);

	String getFaviconUri();
	void setFaviconUri(String faviconUri);
	
//	void updated(Dictionary configuration);

}