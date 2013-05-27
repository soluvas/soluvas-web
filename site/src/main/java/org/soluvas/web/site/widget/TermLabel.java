package org.soluvas.web.site.widget;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.Term;
import org.soluvas.web.site.EmfModel;

/**
 * Formats a {@link Term} with associated image or color.
 * @author agus
 */
@SuppressWarnings("serial")
public class TermLabel extends Label {

	@SpringBean
	private WebAddress webAddress;
	private boolean hideTextIfImageExists = false;

	public TermLabel(String id, IModel<Term> model) {
		super(id, model);
		setRenderBodyOnly(true);
	}

	public TermLabel(String id, Term term) {
		this(id, new EmfModel<>(term));
	}
	
	public TermLabel(String id, IModel<Term> model, boolean hideTextIfImageExists) {
		super(id, model);
		this.hideTextIfImageExists = hideTextIfImageExists;
		setRenderBodyOnly(true);
	}

	public TermLabel(String id, Term term, boolean hideTextIfImageExists) {
		this(id, new EmfModel<>(term), hideTextIfImageExists);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final Term term = (Term) getDefaultModelObject();
//		final Locale locale = getLocale();
		if (term != null) {
			final String iconHtml;
			if (term.getImageId() != null) {
				final String bundleName = "base".equals(term.getNsPrefix()) ? "org.soluvas.data" : "tenant_common";
				final String uri = webAddress.getImagesUri() + bundleName + "/" + term.getKindNsPrefix() + "_" + term.getKindName() +"/" + term.getImageId() + ".png";
				iconHtml = "<img class=\"img-circle\" src=\"" + uri + "\" alt=\"" + Strings.escapeMarkup(term.getDisplayName()) + "\" title=\"" + org.apache.wicket.util.string.Strings.escapeMarkup(term.getDisplayName()) + "\"/> ";
			} else {
				final String color = term.getColor();
				if (color != null) {
					iconHtml = "<span class=\"img-circle\" style=\"background: " + color + "; width: 17px; display: inline-block;\">&nbsp;</span> "; 
				} else {
					iconHtml = "";
				}
			}
			if (hideTextIfImageExists && !"".equals(iconHtml)) {
				return iconHtml;
			} else {
				return iconHtml + Strings.escapeMarkup(term.getDisplayName());
			}
		} else {
			return "";
		}
	}
	
}
