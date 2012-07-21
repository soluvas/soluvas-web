package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class Footer extends Panel {

	public Footer(IModel<String> model) {
		super("footer", model);
		add(new Label("text", model.getObject()));
	}
	
}
