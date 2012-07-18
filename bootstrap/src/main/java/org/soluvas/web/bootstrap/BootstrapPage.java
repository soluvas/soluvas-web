package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base page for Twitter Bootstrap-powered Wicket pages.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BootstrapPage extends WebPage {

	private transient Logger log = LoggerFactory.getLogger(BootstrapPage.class);
	
	public BootstrapPage() {
		add(new Label("pageTitle", "Welcome").setRenderBodyOnly(true));
		add(new Label("siteTitle", "Soluvas Web Framework").setRenderBodyOnly(true));
		add(new Header());
		add(new Footer());
	}

}
