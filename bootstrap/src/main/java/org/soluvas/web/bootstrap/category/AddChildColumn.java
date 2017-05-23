package org.soluvas.web.bootstrap.category;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.soluvas.category.Category;
import org.soluvas.category.Category2;

/**
 * Contains a link to new {@link Category} page inside a parent (current row) {@link Category}.
 * @author rudi
 */
@SuppressWarnings("serial")
public class AddChildColumn extends
		AbstractColumn<Category2, String> {
	
	private final Class<? extends Page> addPage;

	public AddChildColumn(IModel<String> displayModel, Class<? extends Page> addPage) {
		super(displayModel);
		this.addPage = addPage;
	}
	
	@Override
	public Component getHeader(String componentId) {
		return new AddChildHeaderPanel(componentId);
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<Category2>> cellItem,
			String componentId, IModel<Category2> rowModel) {
		cellItem.add(new AddChildPanel(componentId, rowModel, addPage));
	}
	
}
