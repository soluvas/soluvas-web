package org.soluvas.web.site.widget;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Term;
import org.soluvas.web.site.EmfModel;

/**
 * Formats a {@link Term} with associated image or color.
 * Only usable inside {@link TenantRef}.
 * @todo It's possible to use app-scoped {@link WebAddress#getImagesUri()} or customize.
 * @author ceefour
 */
public class TermLabel extends Label {
	
	public enum TermDisplay {
		IMAGE_ONLY,
		TEXT_ONLY,
		IMAGE_AND_TEXT,
	}

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private WebAddress webAddress;

	private TermDisplay termDisplay = TermDisplay.IMAGE_ONLY;

	public TermLabel(String id, IModel<Term> model) {
		super(id, model);
		setRenderBodyOnly(true);
	}

	public TermLabel(String id, Term term) {
		this(id, new EmfModel<>(term));
	}
	
	public TermLabel(String id, IModel<Term> model, TermDisplay termDisplay) {
		super(id, model);
		this.termDisplay = termDisplay;
		setRenderBodyOnly(true);
	}

	public TermLabel(String id, Term term, TermDisplay termDisplay) {
		this(id, new EmfModel<>(term), termDisplay);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final Term term = (Term) getDefaultModelObject();
		final String curLanguageTag = getLocale().toLanguageTag();
		if (term != null) {
			final String iconHtml;
			final String uri = term.getImageUri(webAddress.getImagesUri());
			if (uri != null) {
				iconHtml = "<img class=\"img-color-badge\" src=\"" + uri + "\" alt=\"" + Strings.escapeMarkup(term.getEffectiveDisplayName(curLanguageTag)) + "\" title=\"" + org.apache.wicket.util.string.Strings.escapeMarkup(term.getEffectiveDisplayName(curLanguageTag)) + "\"/> ";
			} else {
				final String color = term.getColor();
				if (color != null) {
					iconHtml = "<span class=\"color-badge\" style=\"background: " + color + ";" + 
							(term.isBordered() ? "border:1px solid #eee" : "") + "\">&nbsp;</span> "; 
				} else {
					iconHtml = "";
				}
			}
			switch (termDisplay) {
			case IMAGE_ONLY:
				if (!"".equals(iconHtml)) {
					return iconHtml;
				} else {
					return "" + Strings.escapeMarkup(term.getEffectiveDisplayName(curLanguageTag));
				}
			case TEXT_ONLY:
				return "" + Strings.escapeMarkup(term.getEffectiveDisplayName(curLanguageTag));
			case IMAGE_AND_TEXT:
				return iconHtml + Strings.escapeMarkup(term.getEffectiveDisplayName(curLanguageTag));
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
