package org.soluvas.web.site.widget;

import java.util.Collection;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Renders a {@link Collection}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CollectionColumn<T, C> extends PropertyColumn<T, String> {

	public CollectionColumn(IModel<String> displayModel,
			String propertyExpression) {
		super(displayModel, propertyExpression);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId,
			IModel<T> rowModel) {
		final IModel<Collection<C>> cellModel = (IModel) getDataModel(rowModel);
		item.add(new CollectionColumnPanel<C>(componentId, cellModel) {
			@Override
			protected Component createItemComponent(String componentId,
					ListItem<C> item) {
				return CollectionColumn.this.createItemComponent(componentId, item);
			}
		});
	}

	/**
	 * Create the {@link Component} for the specified item.
	 * The Component ID must be {@code componentId}.
	 * The default implementation creates a simple {@link Label}.
	 * @return
	 */
	protected Component createItemComponent(String componentId, ListItem<C> item) {
		return new Label(componentId, item.getModel());
	}

}
