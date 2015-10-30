package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.soluvas.data.Value;

/**
 * Renders the {@link Value}-typed {@link IColumn}
 * using {@link ValueLabel2}, with CSS class <code>value</code>.
 * @author ceefour
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class ValueColumn2<T> extends PropertyColumn<T, String> {

	private final boolean hideTextIfImageExists;

	public ValueColumn2(IModel<String> displayModel, String valueExpression) {
		super(displayModel, valueExpression + ".value", valueExpression);
		this.hideTextIfImageExists = false;
	}
	
	public ValueColumn2(IModel<String> displayModel, String valueExpression, boolean hideTextIfImageExists) {
		super(displayModel, valueExpression + ".value", valueExpression);
		this.hideTextIfImageExists = hideTextIfImageExists;
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final ValueLabel2 label = new ValueLabel2(componentId,
				(IModel) getDataModel(model), hideTextIfImageExists);
		item.add(label);
		item.add(new AttributeAppender("class", "value"));
	}

}