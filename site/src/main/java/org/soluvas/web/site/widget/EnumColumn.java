package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;

/**
 * Renders a regular {@link Enum} or an EMF {@link Enumerator}.
 * @author adri
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class EnumColumn<T> extends PropertyColumn<T, String> {

	private final EEnum eEnum;

	public EnumColumn(IModel<String> displayModel, String propertyExpression,
			EEnum eEnum) {
		super(displayModel, propertyExpression, propertyExpression);
		this.eEnum = eEnum;
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final TitledEnumLabel label = new TitledEnumLabel(componentId,
				getDataModel(model), eEnum);
		item.add(label);
		item.add(new AttributeAppender("class", "enum"));
	}
}