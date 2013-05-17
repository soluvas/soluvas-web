package org.soluvas.web.site.widget;

import org.apache.wicket.Page;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

@SuppressWarnings("serial")
public class LinkColumn<T, S> extends PropertyColumn<T, S> {

	final Optional<IModel<String>> labelModel;
	final Class<? extends Page> pageClass;
	final PageParameters paramsTemplate;
	final String paramName;
	final String paramExpression;

	public LinkColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, 
			Class<? extends Page> pageClass, String paramName, String paramExpression) {
		super(displayModel, sortProperty, propertyExpression);
		this.labelModel = Optional.absent();
		this.pageClass = pageClass;
		this.paramsTemplate = new PageParameters();
		this.paramName = paramName;
		this.paramExpression = paramExpression;
	}

	public LinkColumn(IModel<String> displayModel, S sortProperty,
			String propertyExpression, 
			Class<? extends Page> pageClass, PageParameters paramsTemplate,
			String paramName, String paramExpression) {
		super(displayModel, sortProperty, propertyExpression);
		this.labelModel = Optional.absent();
		this.pageClass = pageClass;
		this.paramsTemplate = paramsTemplate;
		this.paramName = paramName;
		this.paramExpression = paramExpression;
	}

	public LinkColumn(IModel<String> displayModel, IModel<String> labelModel,
			Class<? extends Page> pageClass, String paramName, String paramExpression) {
		super(displayModel, null);
		this.labelModel = Optional.of(labelModel);
		this.pageClass = pageClass;
		this.paramsTemplate = new PageParameters();
		this.paramName = paramName;
		this.paramExpression = paramExpression;
	}

	public LinkColumn(IModel<String> displayModel, String propertyExpression,
			Class<? extends Page> pageClass, String paramName, String paramExpression) {
		super(displayModel, propertyExpression);
		this.labelModel = Optional.absent();
		this.pageClass = pageClass;
		this.paramsTemplate = new PageParameters();
		this.paramName = paramName;
		this.paramExpression = paramExpression;
	}

	public LinkColumn(IModel<String> displayModel, String propertyExpression,
			Class<? extends Page> pageClass, PageParameters paramsTemplate, String paramName, String paramExpression) {
		super(displayModel, propertyExpression);
		this.labelModel = Optional.absent();
		this.pageClass = pageClass;
		this.paramsTemplate = paramsTemplate;
		this.paramName = paramName;
		this.paramExpression = paramExpression;
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final Object paramValue = Preconditions.checkNotNull(new PropertyModel<>(model, paramExpression).getObject(),
				"Cannot get '%s' parameter because of null '%s' in %s",
				paramName, paramExpression, model.getObject());
		final PageParameters params = new PageParameters(paramsTemplate)
			.add(paramName, paramValue);
		item.add(new LinkPanel<T, S>(componentId, pageClass, params,
				labelModel.or((IModel) getDataModel(model))));
	}
}