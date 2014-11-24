package org.soluvas.web.site.widget;

import java.math.BigDecimal;

import javax.measure.unit.Unit;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

/**
 * Renders the {@link BigDecimal}-typed {@link IColumn} and {@link Unit}
 * as a {@link MeasureLabel}, with CSS class <code>measure</code>.
 * @author ceefour
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class MeasureColumn<T> extends PropertyColumn<T, String> {

	private final String unitExpression;

	public MeasureColumn(IModel<String> displayModel, String unitExpression, String amountExpression) {
		super(displayModel, amountExpression, amountExpression);
		this.unitExpression = unitExpression;
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final MeasureLabel label = new MeasureLabel(componentId,
				new PropertyModel<>(model, unitExpression),
				(IModel) getDataModel(model));
		item.add(label);
		item.add(new AttributeAppender("class", "measure text-right"));
	}
}