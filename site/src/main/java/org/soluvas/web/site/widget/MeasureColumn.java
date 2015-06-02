package org.soluvas.web.site.widget;

import java.math.BigDecimal;

import javax.annotation.Nullable;
import javax.measure.unit.Unit;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
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

	@Nullable
	private final String unitExpression;
	@Nullable
	private final Unit<?> fixedUnit;

	public MeasureColumn(IModel<String> displayModel, String unitExpression, String amountExpression) {
		super(displayModel, amountExpression, amountExpression);
		this.unitExpression = unitExpression;
		this.fixedUnit = null;
	}
	
	public MeasureColumn(IModel<String> displayModel, Unit<?> fixedUnit, String amountExpression) {
		super(displayModel, amountExpression, amountExpression);
		this.unitExpression = null;
		this.fixedUnit = fixedUnit;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final MeasureLabel label = new MeasureLabel(componentId,
				unitExpression != null ? new PropertyModel<>(model, unitExpression) : new Model<>(fixedUnit),
				(IModel) getDataModel(model));
		item.add(label);
		item.add(new AttributeAppender("class", "measure text-right"));
	}
}