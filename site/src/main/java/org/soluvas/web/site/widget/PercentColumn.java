package org.soluvas.web.site.widget;

import java.math.BigDecimal;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Renders the {@link BigDecimal}/{@link Double}/{@link Float}/{@link Integer}/{@link Long}-typed {@link IColumn}
 * plus "%" sign, with CSS class <code>measure</code>.
 * 
 * @param <T>
 * @param <S>
 * @author ceefour
 */
public class PercentColumn<T, S> extends PropertyColumn<T, S> {

	private static final long serialVersionUID = 1L;

	public PercentColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression) {
		super(displayModel, sortProperty, propertyExpression);
	}

	public PercentColumn(IModel<String> displayModel, String propertyExpression) {
		super(displayModel, propertyExpression);
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		item.add(new PercentLabel(componentId, getDataModel(model)));
		item.add(new AttributeAppender("class", "measure"));
	}

}