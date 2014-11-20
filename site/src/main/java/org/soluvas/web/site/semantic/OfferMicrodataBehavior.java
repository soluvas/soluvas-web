package org.soluvas.web.site.semantic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag.TagType;

/**
 * Adds {@code itemprop="offers" itemscope itemtype="http://schema.org/Offer"}.
 * 
 * <p>An offer to transfer some rights to an item or to provide a service—for example, an offer to sell tickets to an event, to rent the DVD of a movie, to stream a TV show over the internet, to repair a motorcycle, or to loan a book.
 * 
 * <p>For GTIN-related fields, see Check Digit calculator and validation guide from GS1.

 * @author ceefour
 * @see <a href="http://schema.org/offers">schema:offers</a>
 * @see <a href="http://schema.org/Offer">schema:Offer</a>
 * @see AttributeModifier
 * @author ceefour
 */
@SuppressWarnings("serial")
public class OfferMicrodataBehavior extends Behavior {

	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		super.onComponentTag(component, tag);
		if (tag.getType() != TagType.CLOSE) {
			tag.getAttributes().put("itemprop", "offers");
			tag.getAttributes().put("itemscope", null);
			tag.getAttributes().put("itemtype", "http://schema.org/Offer");
		}
	}
	
}
