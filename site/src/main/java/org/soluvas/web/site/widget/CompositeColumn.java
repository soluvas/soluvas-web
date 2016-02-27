package org.soluvas.web.site.widget;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.export.IExportableColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

import com.google.common.collect.ImmutableList;

/**
 * A {@link PropertyColumn} with several child {@link IColumn}s.
 * @author ceefour
 */
public class CompositeColumn<T, S> extends PropertyColumn<T, S> {

	private final ImmutableList<IExportableColumn<T, ?>> children;

	public CompositeColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, IExportableColumn<T, ?>... children) {
		super(displayModel, sortProperty, propertyExpression);
		this.children = ImmutableList.copyOf(children);
	}

	public CompositeColumn(IModel<String> displayModel,
			String propertyExpression, IExportableColumn<T, ?>... children) {
		super(displayModel, propertyExpression);
		this.children = ImmutableList.copyOf(children);
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId,
			IModel<T> rowModel) {
		item.add(new CompositeColumnPanel(componentId, rowModel, this, children));
	}

}
