package org.soluvas.web.site;

import java.util.Dictionary;

import org.apache.commons.beanutils.PropertyUtils;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class SimpleSite implements Site, ManagedService {

	private transient Logger log = LoggerFactory.getLogger(SimpleSite.class);
	private String siteTitle;
	private String homeTitle;
	private String pageTitleSuffix;
	private String logoText;
	private String logoAlt;
	private String footerText;

	public SimpleSite() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#getSiteTitle()
	 */
	@Override
	public String getSiteTitle() {
		return siteTitle;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#setSiteTitle(java.lang.String)
	 */
	@Override
	public void setSiteTitle(String siteTitle) {
		this.siteTitle = siteTitle;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#getHomeTitle()
	 */
	@Override
	public String getHomeTitle() {
		return homeTitle;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#setHomeTitle(java.lang.String)
	 */
	@Override
	public void setHomeTitle(String homeTitle) {
		this.homeTitle = homeTitle;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#getPageTitleSuffix()
	 */
	@Override
	public String getPageTitleSuffix() {
		return pageTitleSuffix;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#setPageTitleSuffix(java.lang.String)
	 */
	@Override
	public void setPageTitleSuffix(String pageTitleSuffix) {
		this.pageTitleSuffix = pageTitleSuffix;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#getLogoText()
	 */
	@Override
	public String getLogoText() {
		return logoText;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#setLogoText(java.lang.String)
	 */
	@Override
	public void setLogoText(String logoText) {
		this.logoText = logoText;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#getLogoAlt()
	 */
	@Override
	public String getLogoAlt() {
		return logoAlt;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.Site#setLogoAlt(java.lang.String)
	 */
	@Override
	public void setLogoAlt(String logoAlt) {
		this.logoAlt = logoAlt;
	}

	@Override
	public String toString() {
		return String
				.format("SimpleSite [siteTitle=%s, homeTitle=%s, pageTitleSuffix=%s, logoText=%s, logoAlt=%s]",
						siteTitle, homeTitle, pageTitleSuffix, logoText,
						logoAlt);
	}

	@Override
	public void updated(Dictionary configuration) throws ConfigurationException {
		try {
			log.info("Updating site configuration: {}", configuration);
			PropertyUtils.copyProperties(configuration, this);
		} catch (Exception e) {
			log.error("Cannot apply configuration " + configuration, e);
		}
	}

	@Override
	public String getFooterText() {
		return footerText;
	}

	@Override
	public void setFooterText(String footerText) {
		this.footerText = footerText;
	}

}
