package org.soluvas.web.site;

import java.io.Serializable;

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

	String toString();

	String getFooterHtml();
	void setFooterHtml(String footerHtml);

	String getFaviconUri();
	void setFaviconUri(String faviconUri);
	
//	void updated(Dictionary configuration);

}