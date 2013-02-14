package org.soluvas.web.googleanalytics;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class GoogleAnalytics extends Panel {

	public GoogleAnalytics(String id) {
		super(id);
	}

	public GoogleAnalytics(String id, IModel<String> model) {
		super(id, model);
		String googleAnalyticScript = "_gaq.push([ '_setAccount', '"+ model.getObject() + "' ]);";
		Label trackingId = new Label("trackerId", googleAnalyticScript);
		trackingId.setEscapeModelStrings(false);
		add(trackingId);
		
	}

}
