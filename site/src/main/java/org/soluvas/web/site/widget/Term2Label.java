package org.soluvas.web.site.widget;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Term;
import org.soluvas.data.Term2;

/**
 * Formats a {@link Term} with associated image or color.
 * Only usable inside {@link TenantRef}.
 * @todo It's possible to use app-scoped {@link WebAddress#getImagesUri()} or customize.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class Term2Label extends Label {
	
	public enum Term2Display {
		IMAGE_ONLY,
		TEXT_ONLY,
		IMAGE_AND_TEXT,
	}

	@SpringBean
	private WebAddress webAddress;

	private Term2Display termDisplay = Term2Display.IMAGE_ONLY;

	public Term2Label(String id, IModel<Term2> model) {
		super(id, model);
		setRenderBodyOnly(true);
	}

	public Term2Label(String id, Term2 term) {
		this(id, new Model<>(term));
	}
	
	public Term2Label(String id, IModel<Term2> model, Term2Display termDisplay) {
		super(id, model);
		this.termDisplay = termDisplay;
		setRenderBodyOnly(true);
	}

	public Term2Label(String id, Term2 term, Term2Display termDisplay) {
		this(id, new Model<>(term), termDisplay);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final Term2 term = (Term2) getDefaultModelObject();
		final String curLanguageTag = getLocale().toLanguageTag();
		if (term != null) {
			final String iconHtml;
			final String uri = term.getImageUri(webAddress.getImagesUri());
			if (uri != null) {
				iconHtml = "<img class=\"img-color-badge\" src=\"" + uri + "\" alt=\"" + Strings.escapeMarkup(term.getEffectiveName(curLanguageTag)) + "\" title=\"" + org.apache.wicket.util.string.Strings.escapeMarkup(term.getEffectiveName(curLanguageTag)) + "\"/> ";
			} else {
				final String color = term.getColor();
				if (color != null) {
					iconHtml = "<span class=\"color-badge\" style=\"background: " + color + ";" + 
//							(term.isBordered() ? "border:1px solid #eee" : "") + "\">&nbsp;</span> "; 
							(true ? "border:1px solid #eee" : "") + "\">&nbsp;</span> ";
				} else {
					iconHtml = "";
				}
			}
			switch (termDisplay) {
			case IMAGE_ONLY:
				if (!"".equals(iconHtml)) {
					return iconHtml;
				} else {
					return "" + Strings.escapeMarkup(term.getEffectiveName(curLanguageTag));
				}
			case TEXT_ONLY:
				return "" + Strings.escapeMarkup(term.getEffectiveName(curLanguageTag));
			case IMAGE_AND_TEXT:
				return iconHtml + Strings.escapeMarkup(term.getEffectiveName(curLanguageTag));
			default:
				throw new RuntimeException("Unrecognize for termDisplay " + termDisplay);
			}
			/*if (hideTextIfImageExists && !"".equals(iconHtml)) {
				return iconHtml;
			} else {
				return iconHtml + Strings.escapeMarkup(term.getDisplayName());
			}*/
		} else {
			return "";
		}
	}
	
}
