package org.soluvas.web.bootstrap;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.soluvas.web.bootstrap.widget.PersonPopover;
import org.soluvas.web.site.widget.DateTimeLabel;

/**
 * Renders the {@link Person2}-typed {@link IColumn} as a {@link DateTimeLabel}.
 * @param <T>
 * @param <S>
 * @author ceefour
 */
public class PersonColumn<T> extends PropertyColumn<T, String> {

	private static final long serialVersionUID = 1L;

	public PersonColumn(IModel<String> displayModel, String propertyExpression) {
		super(displayModel, propertyExpression);
	}
	
	public PersonColumn(IModel<String> displayModel, String sortProperty, String propertyExpression) {
		super(displayModel, sortProperty, propertyExpression);
	}

	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		item.add(new PersonPopover(componentId, (IModel) getDataModel(model)));
		item.add(new AttributeAppender("class", "person"));
	}
}