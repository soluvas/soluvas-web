package org.soluvas.web.site.widget;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Choose models inside a {@link DataTable}.
 * @author rudi
 */
@SuppressWarnings("serial")
public class CheckColumn<T> extends
		AbstractColumn<T, String> {
	
	public CheckColumn(IModel<String> displayModel) {
		super(displayModel);
	}
	
	@Override
	public Component getHeader(String componentId) {
		return new CheckHeaderPanel(componentId);
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> cellItem,
			String componentId, IModel<T> rowModel) {
		cellItem.add(new CheckPanel<>(componentId, rowModel));
	}
	
}
