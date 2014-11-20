package org.soluvas.web.site.semantic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;

/**
 * Adds {@code itemprop="review" itemscope itemtype="http://schema.org/Review"}.
 * @author ceefour
 * @see <a href="http://schema.org/review">schema:review</a>
 * @see <a href="http://schema.org/Review">schema:Review</a>
 * @see AttributeModifier
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ReviewMicrodataBehavior extends Behavior {

	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		if (tag.getType() != TagType.CLOSE) {
			tag.getAttributes().put("itemprop", "review");
			tag.getAttributes().put("itemscope", null);
			tag.getAttributes().put("itemtype", "http://schema.org/Review");
		}
	}
	
}
