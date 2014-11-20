package org.soluvas.web.site.semantic;

import java.util.Objects;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.google.common.base.CaseFormat;

/**
 * Adds {@code itemprop} from {@link Enum#name()} inflected using {@link CaseFormat#LOWER_CAMEL},
 * with a {@code content} attribute using {@link Object#toString()}.
 * Usually used with {@code <span>}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ItemPropContentBehavior extends Behavior {
	
	private final Enum<?> property;
	private final IModel<?> contentModel;

	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param contentModel object value, convertible to String
	 */
	public ItemPropContentBehavior(Enum<?> property, final IModel<?> contentModel) {
		super();
		this.property = property;
		this.contentModel = contentModel;
	}
	
	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 * @param content content value
	 */
	public ItemPropContentBehavior(Enum<?> property, final String content) {
		this(property, new Model<>(content));
	}
	
	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		if (tag.getType() != TagType.CLOSE) {
			tag.getAttributes().put("itemprop", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, property.name()));
			tag.getAttributes().put("content", Objects.toString(contentModel.getObject(), null));
		}
	}

}
