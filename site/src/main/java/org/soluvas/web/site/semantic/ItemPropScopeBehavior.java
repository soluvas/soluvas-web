package org.soluvas.web.site.semantic;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.google.common.base.CaseFormat;

/**
 * Adds {@code itemprop} from {@link Enum#name()} inflected using {@link CaseFormat#LOWER_CAMEL},
 * with {@code itemscope} and {@code itemtype} attributes.
 * Usually used with {@code <span>} or {@code <div>}.
 * @author ceefour
 * @see ItemPropBehavior
 * @see ItemScopeBehavior
 */
@SuppressWarnings("serial")
public class ItemPropScopeBehavior extends Behavior {
	
	private final Enum<?> property;
	private final IModel<Enum<?>> itemTypeModel;

	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param contentModel object value, convertible to String
	 */
	public ItemPropScopeBehavior(Enum<?> property, final IModel<Enum<?>> itemTypeModel) {
		super();
		this.property = property;
		this.itemTypeModel = itemTypeModel;
	}
	
	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param content content value
	 */
	public ItemPropScopeBehavior(Enum<?> property, final Enum<?> itemType) {
		this(property, new Model<Enum<?>>(itemType));
	}
	
	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		if (tag.getType() != TagType.CLOSE) {
			tag.getAttributes().put("itemprop", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, property.name()));
			tag.getAttributes().put("itemscope", null);
			final Enum<?> itemType = itemTypeModel.getObject();
			if (itemType != null) {
				tag.getAttributes().put("itemtype", "http://schema.org/" + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, itemType.name()));
			}
		}
	}

}
