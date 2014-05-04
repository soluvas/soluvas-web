package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * {@link PropertyColumn} with CSS class.
 * @author ceefour
 */
public class CssPropertyColumn<T, S> extends PropertyColumn<T, S> {

	private static final long serialVersionUID = 1L;
	
	private final String cssClass;

	public CssPropertyColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, String cssClass) {
		super(displayModel, sortProperty, propertyExpression);
		this.cssClass = cssClass;
	}

	public CssPropertyColumn(IModel<String> displayModel,
			String propertyExpression, String cssClass) {
		super(displayModel, propertyExpression);
		this.cssClass = cssClass;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId,
			IModel<T> rowModel) {
		super.populateItem(item, componentId, rowModel);
		item.add(new AttributeAppender("class", new Model<>(cssClass), " "));
	}

}
