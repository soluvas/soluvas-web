package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Renders the {@link java.time.OffsetDateTime}-typed {@link IColumn} as a {@link DateTimeLabel2}.
 * @author ceefour
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class OffsetDateTimeColumn<T> extends PropertyColumn<T, String> {

	private String cssClass = "time";

	public OffsetDateTimeColumn(IModel<String> displayModel, String propertyExpression) {
		super(displayModel, propertyExpression, propertyExpression);
	}

	public OffsetDateTimeColumn<T> cssClass(String cssClass) {
		this.cssClass = cssClass;
		return this;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		item.add(new OffsetDateTimeLabel(componentId, (IModel) getDataModel(model)));
		item.add(new AttributeAppender("class", cssClass));
	}
}