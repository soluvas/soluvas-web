package org.soluvas.web.olark;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Olark extends Panel {
	private static final Logger log = LoggerFactory
			.getLogger(Olark.class);
	
	public Olark(String id, Model<String> model) {
		super(id);
		String siteId = model.getObject();
		final String identifyScript = "olark.identify('" + siteId + "');";
		final Label identify = new Label("identify", identifyScript);
		identify.setEscapeModelStrings(false);
		add(identify);
		final String contactHref = "https://www.olark.com/site/" + siteId + "/contact";
		final WebMarkupContainer contact = new WebMarkupContainer("contact");
		contact.add(new AttributeModifier("href", contactHref));
		add(contact);
	}
	
	

}
