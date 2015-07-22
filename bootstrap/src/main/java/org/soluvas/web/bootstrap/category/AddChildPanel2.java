package org.soluvas.web.bootstrap.category;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.category.Category2;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class AddChildPanel2 extends GenericPanel<Category2> {

	/**
	 * @param id
	 * @param model
	 */
	public AddChildPanel2(String id, IModel<Category2> model, Class<? extends Page> addPage) {
		super(id, model);
		add(new BookmarkablePageLink<>("link", addPage, 
				new PageParameters().set("parentUName", new PropertyModel<>(model, "id").getObject())));
	}

}
