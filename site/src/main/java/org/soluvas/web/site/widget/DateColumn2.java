package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Renders the {@link DateTime}-typed {@link IColumn} as a {@link DateTimeLabel2}.
 * @author ceefour
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class DateColumn2<T> extends PropertyColumn<T, String> {

	private String cssClass = "time";
	private final DateTimeZone dtZone;
	
	public DateColumn2(IModel<String> displayModel, String propertyExpression,
			DateTimeZone dtZone) {
		super(displayModel, propertyExpression, propertyExpression);
		this.dtZone = dtZone;
	}

	public DateColumn2<T> cssClass(String cssClass) {
		this.cssClass = cssClass;
		return this;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		item.add(new DateTimeLabel2(componentId, (IModel) getDataModel(model)).withCustomZone(dtZone));
		item.add(new AttributeAppender("class", cssClass));
	}
}