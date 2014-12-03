package org.soluvas.web.site.semantic;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.google.common.base.CaseFormat;

/**
 * Adds {@code itemprop} from {@link Enum#name()} inflected using {@link CaseFormat#LOWER_CAMEL},
 * with a {@code href} attribute that is an {@link Enum#name()} inflected using {@link CaseFormat#UPPER_CAMEL}.
 * Usually used with {@code <link>}, but {@code <span>} should work too.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ItemPropEnumBehavior extends Behavior {
	
	private final Enum<?> property;
	private final IModel<String> hrefModel;
	private final IModel<?> contentModel;

	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param hrefModel enumeration value, e.g. {@link ItemAvailability#IN_STOCK}.
	 * @param contentModel Content value, e.g. {@code InStock}.
	 */
	public ItemPropEnumBehavior(Enum<?> property, final IModel<? extends Enum<?>> hrefModel, final IModel<?> contentModel) {
		super();
		this.property = property;
		this.hrefModel = new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				final Enum<?> origHref = hrefModel.getObject();
				if (origHref != null) {
					return "http://schema.org/" + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, origHref.name());
				} else {
					return null;
				}
			}
		};
		this.contentModel = contentModel;
	}
	
	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param hrefModel enumeration value, e.g. {@link ItemAvailability#IN_STOCK}.
	 */
	public ItemPropEnumBehavior(Enum<?> property, final IModel<? extends Enum<?>> hrefModel) {
		this(property, hrefModel, new Model<>());
	}
	
	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param hrefModel enumeration value, e.g. {@link ItemAvailability#IN_STOCK}.
	 */
	public ItemPropEnumBehavior(Enum<?> property, final Enum<?> href) {
		this(property, new Model<Enum<?>>(href));
	}
	
	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		if (tag.getType() != TagType.CLOSE) {
			tag.getAttributes().put("itemprop", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, property.name()));
			tag.getAttributes().put("href", hrefModel.getObject());
			if (contentModel.getObject() != null) {
				tag.getAttributes().put("content", contentModel.getObject());
			}
		}
	}

}
