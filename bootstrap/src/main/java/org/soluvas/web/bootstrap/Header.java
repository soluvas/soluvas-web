package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.html.panel.Panel;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.soluvas.web.site.ComponentFactory;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class Header extends Panel {
	
	/**
	 * @todo Should accept an Either<Throwable, List<Categories>> for example
	 * if TimeoutException.
	 * @param categories
	 */
	public Header() {
		super("header");
		setRenderBodyOnly(true);
	}

}
