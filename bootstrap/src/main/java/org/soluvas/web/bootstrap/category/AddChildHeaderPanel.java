package org.soluvas.web.bootstrap.category;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author ceefour
 *
 */
public class AddChildHeaderPanel extends Panel {

	private static final long serialVersionUID = 1L;

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
