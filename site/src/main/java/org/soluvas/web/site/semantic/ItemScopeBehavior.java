package org.soluvas.web.site.semantic;

import javax.annotation.Nonnull;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.google.common.base.CaseFormat;

/**
 * Adds {@code itemscope itemtype="http://schema.org/ItemType"} where ItemType is the {@link Enum#name()}
 * inflected using {@link CaseFormat#UPPER_CAMEL}.
 * @author ceefour
 * @see e.g. <a href="http://schema.org/Product">schema:Product</a>
 * @see AttributeModifier
 */
@SuppressWarnings("serial")
public class ItemScopeBehavior extends Behavior {
	
	@Nonnull
	private final IModel<? extends Enum<?>> itemTypeModel;
	
	/**
	 * @param itemType Typically a {@link SchemaOrgClass} value, e.g. {@link SchemaOrgClass#PRODUCT}.
	 */
	public ItemScopeBehavior(@Nonnull Enum<?> itemType) {
		super();
		this.itemTypeModel = new Model<Enum<?>>(itemType);
	}

	/**
	 * @param itemType Typically a {@link SchemaOrgClass} value, e.g. {@link SchemaOrgClass#PRODUCT}.
	 */
	public ItemScopeBehavior(@Nonnull IModel<? extends Enum<?>> itemTypeModel) {
		super();
		this.itemTypeModel = itemTypeModel;
	}

	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		if (tag.getType() != TagType.CLOSE && itemTypeModel.getObject() != null) {
			tag.getAttributes().put("itemscope", null);
			tag.getAttributes().put("itemtype", "http://schema.org/" + 
				CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, itemTypeModel.getObject().name()));
		}
	}
	
}
