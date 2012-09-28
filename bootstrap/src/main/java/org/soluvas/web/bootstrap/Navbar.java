package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author rudi
 *
 */
public class Navbar extends Panel {

	public Navbar(String id, IModel<?> model) {
		super(id, model);
		add(new Label("navbarChild"));
	}

	public Navbar(String id) {
		this(id, new Model());
	}

}
