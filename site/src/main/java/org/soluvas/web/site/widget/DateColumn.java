package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.joda.time.DateTime;

/**
 * Renders the {@link DateTime}-typed {@link IColumn} as a {@link DateTimeLabel}.
 * @author ceefour
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class DateColumn<T> extends PropertyColumn<T, String> {

	private final String dateStyle;
	private String cssClass = "time";

	public DateColumn(IModel<String> displayModel, String propertyExpression) {
		super(displayModel, propertyExpression, propertyExpression);
		this.dateStyle = "MS";
	}

	public DateColumn(IModel<String> displayModel, String propertyExpression,
			String dateStyle) {
		super(displayModel, propertyExpression, propertyExpression);
		this.dateStyle = dateStyle;
	}
	
	public DateColumn<T> cssClass(String cssClass) {
		this.cssClass = cssClass;
		return this;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		item.add(new DateTimeLabel(componentId, (IModel) getDataModel(model), new StyleDateConverter(dateStyle, true)));
		item.add(new AttributeAppender("class", cssClass));
	}
}