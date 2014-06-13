package org.soluvas.web.googleanalytics;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.security.SecurityCatalog;

import com.google.common.base.Strings;

/**
 * @todo AFTER DECEMBER 2013 : Only use Google Analytics tracking if NOT has app/mall role: https://idbippo.atlassian.net/browse/BC-1397
 * @author ceefour
 */
public class GoogleAnalyticsPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(GoogleAnalyticsPanel.class);
	
	@SpringBean
	private GoogleAnalyticsManager googleAnalyticsMgr;
	@SpringBean
	private SecurityCatalog securityCatalog;
	
	public GoogleAnalyticsPanel(String id) {
		super(id);
		boolean displayGoogleAnalytics = false;
		if (googleAnalyticsMgr.isEnabled()) {
			// TODO: AFTER DECEMBER 2013 :
			// only use Google Analytics tracking if NOT has app/mall role: https://idbippo.atlassian.net/browse/BC-1397
			displayGoogleAnalytics = true;
			// disabled logic for now, make our "visitor count" still high
//			final Subject subject = SecurityUtils.getSubject();
//			if (!subject.isAuthenticated()) {
//				// display newsletter form for guests
//				displayGoogleAnalytics = true;
//			} else {
//				// display newsletter form for regular users ONLY
//				displayGoogleAnalytics = !SecurityHelper.hasAnyRealRole(securityCatalog, subject);
//			}
		}

		if (displayGoogleAnalytics) {
			if (Strings.isNullOrEmpty(googleAnalyticsMgr.getTrackingId())) {
				log.warn("Google Analytics Tracking ID must be set");
				add(new EmptyPanel("trackerId"));
				setVisible(false);
			} else {
				// TODO: support specific domain (i.e. non-auto) during ga(create)
				// https://developers.google.com/analytics/devguides/collection/analyticsjs/
				String googleAnalyticScript =
						  "\n"
						+ "(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n"
						+ "(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n"
						+ "m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n"
						+ "})(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n"
						+ "\n"
						+ "ga('create', '" + googleAnalyticsMgr.getTrackingId() + "', '" + googleAnalyticsMgr.getCookieDomain() + "');\n"
						+ "ga('require', 'displayfeatures');\n" // BC-1974 : in 5.3.x displayfeatures is always enabled
						+ "ga('send', 'pageview');\n";
				Label trackingId = new Label("trackerId", googleAnalyticScript);
				trackingId.setEscapeModelStrings(false);
				add(trackingId);
			}
		} else {
			add(new EmptyPanel("trackerId"));
			setVisible(false);
		}
	}

}
