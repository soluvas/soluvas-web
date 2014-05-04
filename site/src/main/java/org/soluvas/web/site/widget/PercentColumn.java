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
 * @author ceefour
 */
public class PercentColumn<T, S> extends PropertyColumn<T, S> {

	public PercentColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression) {
		super(displayModel, sortProperty, propertyExpression);
	}

	public PercentColumn(IModel<String> displayModel, String propertyExpression) {
		super(displayModel, propertyExpression);
	}
	
	
	
//	
//
//	private final String unitExpression;
//
//	public PercentColumn(IModel<String> displayModel, String unitExpression, String amountExpression) {
//		super(displayModel, amountExpression, amountExpression);
//		this.unitExpression = unitExpression;
//	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
//		super.populateItem(item, componentId, model);
		item.add(new PercentColumnPanel(componentId, getDataModel(model)));
//		item.add(new Label(componentId, getDataModel(model)));
//		item.add(new Label(item."percent", "%"));
//		final MeasureLabel label = new MeasureLabel(componentId,
//				new PropertyModel<>(model, unitExpression),
//				(IModel) getDataModel(model));
//		item.add(label);
		item.add(new AttributeAppender("class", "measure"));
	}
}