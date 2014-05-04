package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author ceefour
 *
 */
class PercentColumnPanel extends Panel {

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public PercentColumnPanel(String id) {
		this(id, null);
	}

	/**
	 * @param id
	 * @param model
	 */
	public PercentColumnPanel(String id, IModel<?> model) {
		super(id, model);
		add(new Label("value", model));
	}

}
