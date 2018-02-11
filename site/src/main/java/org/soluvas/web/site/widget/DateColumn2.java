package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.annotation.Nullable;

/**
 * Renders the {@link DateTime}-typed {@link IColumn} as a {@link DateTimeLabel2}.
 * @author ceefour
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class DateColumn2<T> extends PropertyColumn<T, String> {

	private String cssClass = "time";
	/**
	 * If null, means uses {@link org.soluvas.web.site.widget.DateTimeLabel2.ZoneConversion#TENANT}.
	 */
	@Nullable
	private final DateTimeZone customZone;

	/**
	 * {@link DateTime} column using {@link org.soluvas.web.site.widget.DateTimeLabel2.ZoneConversion#TENANT}-specified time zone.
	 * @param displayModel
	 * @param propertyExpression
	 */
	public DateColumn2(IModel<String> displayModel, String propertyExpression) {
		super(displayModel, propertyExpression, propertyExpression);
		this.customZone = null;
	}

	/**
	 * {@link DateTime} column using {@link org.soluvas.web.site.widget.DateTimeLabel2.ZoneConversion#CUSTOM} time zone.
	 * @param displayModel
	 * @param propertyExpression
	 * @param customZone
	 */
	public DateColumn2(IModel<String> displayModel, String propertyExpression,
			DateTimeZone customZone) {
		super(displayModel, propertyExpression, propertyExpression);
		this.customZone = customZone;
	}

	public DateColumn2<T> cssClass(String cssClass) {
		this.cssClass = cssClass;
		return this;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final DateTimeLabel2 dateTimeLabel2 = new DateTimeLabel2(componentId, (IModel) getDataModel(model));
		if (customZone != null) {
			dateTimeLabel2.withCustomZone(customZone);
		}
		item.add(dateTimeLabel2);
		item.add(new AttributeAppender("class", cssClass));
	}
}