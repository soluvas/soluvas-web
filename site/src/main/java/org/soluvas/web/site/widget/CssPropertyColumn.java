package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import javax.annotation.Nullable;

/**
 * {@link PropertyColumn} with CSS class and {@code overflow/text-overflow} support.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CssPropertyColumn<T, S> extends PropertyColumn<T, S> {

	public static final String DEFAULT_WIDTH = "10em";

	private final String cssClass;
	private final boolean ellipsis;
	// only has effect if ellipsis == true
	private final String width;

	public CssPropertyColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, @Nullable String cssClass) {
		super(displayModel, sortProperty, propertyExpression);
		this.cssClass = cssClass;
		this.ellipsis = false;
		this.width = null;
	}

	public CssPropertyColumn(IModel<String> displayModel,
			String propertyExpression, @Nullable String cssClass) {
		super(displayModel, propertyExpression);
		this.cssClass = cssClass;
		this.ellipsis = false;
		this.width = null;
	}

	public CssPropertyColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, @Nullable String cssClass, boolean ellipsis) {
		super(displayModel, sortProperty, propertyExpression);
		this.cssClass = cssClass;
		this.ellipsis = ellipsis;
		this.width = DEFAULT_WIDTH;
	}

	public CssPropertyColumn(IModel<String> displayModel,
			String propertyExpression, @Nullable String cssClass, boolean ellipsis) {
		super(displayModel, propertyExpression);
		this.cssClass = cssClass;
		this.ellipsis = ellipsis;
		this.width = DEFAULT_WIDTH;
	}

	public CssPropertyColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, @Nullable String cssClass, boolean ellipsis, String width) {
		super(displayModel, sortProperty, propertyExpression);
		this.cssClass = cssClass;
		this.ellipsis = ellipsis;
		this.width = width;
	}

	public CssPropertyColumn(IModel<String> displayModel,
			String propertyExpression, @Nullable String cssClass, boolean ellipsis, String width) {
		super(displayModel, propertyExpression);
		this.cssClass = cssClass;
		this.ellipsis = ellipsis;
		this.width = width;
	}

	public CssPropertyColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, boolean ellipsis, String width) {
		super(displayModel, sortProperty, propertyExpression);
		this.cssClass = null;
		this.ellipsis = ellipsis;
		this.width = width;
	}

	public CssPropertyColumn(IModel<String> displayModel,
			String propertyExpression, boolean ellipsis, String width) {
		super(displayModel, propertyExpression);
		this.cssClass = null;
		this.ellipsis = ellipsis;
		this.width = width;
	}

	public CssPropertyColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, boolean ellipsis) {
		super(displayModel, sortProperty, propertyExpression);
		this.cssClass = null;
		this.ellipsis = ellipsis;
		this.width = DEFAULT_WIDTH;
	}

	public CssPropertyColumn(IModel<String> displayModel,
			String propertyExpression, boolean ellipsis) {
		super(displayModel, propertyExpression);
		this.cssClass = null;
		this.ellipsis = ellipsis;
		this.width = DEFAULT_WIDTH;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId,
			IModel<T> rowModel) {
		super.populateItem(item, componentId, rowModel);
		if (null != cssClass) {
			item.add(new AttributeAppender("class", cssClass, " "));
		}
		if (ellipsis) {
			item.get(componentId)
					.add(new AttributeAppender("style", "width: " + width + "; overflow: hidden; text-overflow: ellipsis", "; "));
		}
	}

}
