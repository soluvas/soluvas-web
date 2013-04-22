package org.soluvas.web.site.widget;

import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;

import com.google.common.collect.ImmutableMap;

/**
 * Renders a regular {@link Enum} or an EMF {@link Enumerator}.
 * @author adri
 *
 * @param <T>
 * @param <S>
 */
@SuppressWarnings("serial")
public class EnumColumn<T> extends PropertyColumn<T, String> {

	private final Map<? extends Enum<?>, String> iconMapping;
	private boolean enumVisible = true;
	private String headerIcon = null;
	private final Map<? extends Enum<?>, String> docs;

	public EnumColumn(IModel<String> displayModel, String propertyExpression,
			EEnum eEnum) {
		super(displayModel, propertyExpression, propertyExpression);
		this.docs = TitledEnumLabel.getEEnumDocs(eEnum);
		this.iconMapping = ImmutableMap.of();
	}
	
	public EnumColumn(IModel<String> displayModel, String propertyExpression,
			EEnum eEnum, Map<? extends Enum<?>, String> iconMapping) {
		super(displayModel, propertyExpression, propertyExpression);
		this.docs = TitledEnumLabel.getEEnumDocs(eEnum);
		this.iconMapping = ImmutableMap.copyOf(iconMapping);
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final TitledEnumLabel label = new TitledEnumLabel(componentId,
				getDataModel(model), docs, iconMapping);
		label.setEnumVisible(enumVisible);
		item.add(label);
		item.add(new AttributeAppender("class", "enum"));
	}
	
	public EnumColumn<T> enumVisible(boolean enumVisible) {
		this.enumVisible = enumVisible;
		return this;
	}
	
	@Override
	public Component getHeader(String componentId) {
		if (headerIcon != null) {
			return new Label(componentId, "<i class=\"icon-" + headerIcon + "\" title=\"" + 
					Strings.escapeMarkup(getDisplayModel().getObject()) + "\"></i>")
						.setEscapeModelStrings(false);
		} else {
			return new Label(componentId, getDisplayModel());
		}
	}
	
	public EnumColumn<T> headerIcon(String headerIcon) {
		this.headerIcon = headerIcon;
		return this;
	}
	
}