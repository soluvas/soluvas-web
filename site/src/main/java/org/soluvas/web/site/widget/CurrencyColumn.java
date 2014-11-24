package org.soluvas.web.site.widget;

import java.math.BigDecimal;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Renders the {@link BigDecimal}-typed {@link IColumn} (and currency)
 * as a {@link CurrencyLabel}, with CSS class <code>currency</code>.
 * @author ceefour
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class CurrencyColumn<T> extends PropertyColumn<T, String> {

	private final String currencyExpression;

	public CurrencyColumn(IModel<String> displayModel, String amountExpression,
			String currencyExpression) {
		super(displayModel, amountExpression, amountExpression);
		this.currencyExpression = currencyExpression;
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final CurrencyLabel label = new CurrencyLabel(componentId,
				new PropertyModel<>(model, currencyExpression),
				(IModel) getDataModel(model));
		item.add(label);
		item.add(new AttributeAppender("class", "currency text-right"));
	}
	
}