package org.soluvas.web.site;

import org.apache.wicket.markup.html.WebPage;

/**
 * @author rudi
 *
 */
public interface ConfigurableApplication {
	
	public void setHomePage(Class<? extends WebPage> homePage);

}
