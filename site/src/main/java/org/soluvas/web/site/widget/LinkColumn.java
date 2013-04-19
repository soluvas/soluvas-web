package org.soluvas.web.site.widget;

import org.apache.wicket.Page;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.link.PopupSettings;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.google.common.base.Optional;

public class LinkColumn<T, S> extends PropertyColumn<T, S> {

	private PopupSettings popupSettings;
	final Optional<IModel> labelModel;
	final Class<? extends Page> pageClass;
	final String paramName;
	final String paramExpression;

	public LinkColumn(IModel displayModel, S sortProperty,
			String propertyExpression, 
			Class<? extends Page> pageClass, String paramName, String paramExpression) {
		super(displayModel, sortProperty, propertyExpression);
		this.labelModel = Optional.absent();
		this.pageClass = pageClass;
		this.paramName = paramName;
		this.paramExpression = paramExpression;
	}

	public LinkColumn(IModel displayModel, IModel labelModel,
			Class<? extends Page> pageClass, String paramName, String paramExpression) {
		super(displayModel, null);
		this.labelModel = Optional.of(labelModel);
		this.pageClass = pageClass;
		this.paramName = paramName;
		this.paramExpression = paramExpression;
	}

	public LinkColumn(IModel displayModel, String propertyExpressions,
			Class<? extends Page> pageClass, String paramName, String paramExpression) {
		super(displayModel, propertyExpressions);
		this.labelModel = Optional.absent();
		this.pageClass = pageClass;
		this.paramName = paramName;
		this.paramExpression = paramExpression;
	}

	@Override
	public void populateItem(Item item, String componentId, IModel model) {
		final PageParameters params = new PageParameters()
			.add(paramName, new PropertyModel<>(model, paramExpression).getObject());
		item.add(new LinkPanel<T, S>(componentId, pageClass, params,
				labelModel.or(getDataModel(model))));
	}
}