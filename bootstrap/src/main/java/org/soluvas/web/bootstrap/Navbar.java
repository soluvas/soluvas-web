package org.soluvas.web.bootstrap;

import java.io.Serializable;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Bootstrap's Navbar with fixed position on top of the page.
 * @author rudi
 */
@SuppressWarnings("serial")
public class Navbar extends Panel {

	public Navbar(String id, IModel<?> model) {
		super(id, model);
		add(new WebMarkupContainer("navbarChild"));
	}

	public Navbar(String id) {
		this(id, new Model<Serializable>());
	}

}
