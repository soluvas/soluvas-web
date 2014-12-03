package org.soluvas.web.site.semantic;

import java.io.Serializable;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.google.common.base.CaseFormat;

/**
 * Adds {@code itemprop} a {@code href=} attribute, optionally with {@code content=}.
 * Usually used with {@code <link>}, but {@code <span>} should work too.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ItemPropHrefBehavior extends Behavior {
	
	private final Enum<?> property;
	private final IModel<String> hrefModel;
	private final IModel<?> contentModel;

	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param hrefModel enumeration value, e.g. {@link ItemAvailability#IN_STOCK}.
	 * @param contentModel Content value, e.g. {@code InStock}.
	 */
	public ItemPropHrefBehavior(Enum<?> property, final IModel<String> hrefModel, final IModel<?> contentModel) {
		super();
		this.property = property;
		this.hrefModel = hrefModel;
		this.contentModel = contentModel;
	}
	
	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param hrefModel enumeration value, e.g. {@link ItemAvailability#IN_STOCK}.
	 */
	public ItemPropHrefBehavior(Enum<?> property, final IModel<String> hrefModel) {
		this(property, hrefModel, new Model<>());
	}
	
	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param href href value.
	 */
	public ItemPropHrefBehavior(Enum<?> property, final String href) {
		this(property, new Model<>(href));
	}
	
	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param href href value, e.g. {@link ItemAvailability#IN_STOCK}.
	 * @param content Content value, e.g. {@code InStock}.
	 */
	public ItemPropHrefBehavior(Enum<?> property, final String href, final Serializable content) {
		this(property, new Model<>(href), new Model<>(content));
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
