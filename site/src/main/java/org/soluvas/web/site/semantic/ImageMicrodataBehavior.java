package org.soluvas.web.site.semantic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;

/**
 * Adds {@code itemprop="image" itemscope itemtype="http://schema.org/ImageObject"}.
 * @author ceefour
 * @see <a href="http://schema.org/image">schema:image</a>
 * @see <a href="http://schema.org/ImageObject">schema:ImageObject</a>
 * @see AttributeModifier
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ImageMicrodataBehavior extends Behavior {

	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		if (tag.getType() != TagType.CLOSE) {
			tag.getAttributes().put("itemprop", "image");
			tag.getAttributes().put("itemscope", null);
			tag.getAttributes().put("itemtype", "http://schema.org/ImageObject");
		}
	}
	
}
