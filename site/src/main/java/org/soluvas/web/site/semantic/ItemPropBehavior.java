package org.soluvas.web.site.semantic;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;

import com.google.common.base.CaseFormat;

/**
 * Adds {@code itemprop} from {@link Enum#name()} inflected using {@link CaseFormat#LOWER_CAMEL}.
 * @author ceefour
 */
public class ItemPropBehavior extends Behavior {
	
	private final Enum<?> property;

	/**
	 * @param property Typically a property from {@link SchemaOrgProperty}.
	 */
	public ItemPropBehavior(Enum<?> property) {
		super();
		this.property = property;
	}
	
	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		if (tag.getType() != TagType.CLOSE) {
			tag.getAttributes().put("itemprop", CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, property.name()));
		}
	}

}
