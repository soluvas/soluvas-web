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
				String googleAnalyticScript = "_gaq.push([ '_setAccount', '"+ googleAnalyticsMgr.getTrackingId() + "' ]);";
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
