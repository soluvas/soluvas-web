package org.soluvas.web.site;

import java.io.Serializable;
import java.util.Map;

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
	
//	void updated(Dictionary configuration);

}