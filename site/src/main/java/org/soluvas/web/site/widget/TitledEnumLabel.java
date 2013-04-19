package org.soluvas.web.site.widget;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.EnumLabel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Renders {@link Enumerator} with genmodel annotation as <code>abbr title</code>.
 * If resource message is missing, will simply humanize the enum's <code>toString()</code>.
 * @author adri
 */
@SuppressWarnings("serial")
public class TitledEnumLabel<T extends Enum<T>> extends EnumLabel<T> {

	private static final Logger log = LoggerFactory
			.getLogger(TitledEnumLabel.class);
	
	public TitledEnumLabel(String id, final IModel<T> model, final EEnum eEnum) {
		super(id, model);
		if (eEnum != null) {
			add(new AttributeModifier("title", new AbstractReadOnlyModel<String>() {
				@Override
				public String getObject() {
					final T enumValue = model.getObject();
					if (enumValue == null) {
						return null;
					}
					final EEnumLiteral literal = eEnum.getEEnumLiteral(enumValue.ordinal());
					if (literal != null) {
						final EAnnotation eAnnotation = literal
								.getEAnnotation("http://www.eclipse.org/emf/2002/GenModel");
						log.info("e {}", eAnnotation);
						if (eAnnotation != null && eAnnotation.getDetails().containsKey("documentation")) {
							return eAnnotation.getDetails().get("documentation");
						} else {
							return null;
						}
					} else {
						log.warn("Cannot get {} enum literal {}", eEnum);
						return null;
					}
				}
			}));
		}
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("abbr");
		super.onComponentTag(tag);
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		try {
			super.onComponentTagBody(markupStream, openTag);
		} catch (Exception e) {
			final T obj = getModelObject();
			final String result = obj != null ? 
					WordUtils.capitalizeFully(obj.toString().replace('_', ' ')) : null;
			replaceComponentTagBody(markupStream, openTag, result);
		}
	}
	
}
