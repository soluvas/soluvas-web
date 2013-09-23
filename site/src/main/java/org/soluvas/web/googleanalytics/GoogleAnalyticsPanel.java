package org.soluvas.web.googleanalytics;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

public class GoogleAnalyticsPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(GoogleAnalyticsPanel.class);
	
	@SpringBean
	private GoogleAnalyticsManager googleAnalyticsMgr;
	
	public GoogleAnalyticsPanel(String id) {
		super(id);
		if (googleAnalyticsMgr.isEnabled()) {
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
