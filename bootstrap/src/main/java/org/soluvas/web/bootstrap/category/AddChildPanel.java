package org.soluvas.web.bootstrap.category;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.category.Category;

/**
 * @author ceefour
 *
 */
public class AddChildPanel extends GenericPanel<Category> {

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param model
	 */
	public AddChildPanel(String id, IModel<Category> model, Class<? extends Page> addPage) {
		super(id, model);
		add(new BookmarkablePageLink<>("link", addPage, 
				new PageParameters().set("parentUName", new PropertyModel<>(model, "uName").getObject())));
	}

}
