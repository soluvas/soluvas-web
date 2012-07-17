package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class Footer extends Panel {

	public Footer() {
		super("footer");
	}

	public Footer(IModel<?> model) {
		super("footer", model);
	}
	
}
