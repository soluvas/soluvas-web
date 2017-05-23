  package org.soluvas.web.bootstrap.category;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class AddChildHeaderPanel extends Panel {

	/**
	 * @param id
	 */
	public AddChildHeaderPanel(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param model
	 */
	public AddChildHeaderPanel(String id, IModel<?> model) {
		super(id, model);
	}

}
