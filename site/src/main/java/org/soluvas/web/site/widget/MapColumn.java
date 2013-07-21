package org.soluvas.web.site.widget;

import java.util.Map;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Renders a {@link Map}.
 * @author ceefour
 */
public class MapColumn<T, S> extends PropertyColumn<T, S> {

	private static final long serialVersionUID = 1L;

	public MapColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression) {
		super(displayModel, sortProperty, propertyExpression);
	}

	public MapColumn(IModel<String> displayModel,
			String propertyExpression) {
		super(displayModel, propertyExpression);
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId,
			IModel<T> rowModel) {
		final IModel<Map<String, Object>> cellModel = (IModel) getDataModel(rowModel);
		item.add(new MapColumnPanel(componentId, cellModel));
	}

}
