package org.soluvas.web.site.widget;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;
import org.soluvas.data.Value;
import org.soluvas.web.site.EmfModel;

/**
 * Formats a {@link Value}, and if lookup successful via {@link TermManager}, with associated
 * image or color.
 * @author agus
 */
@SuppressWarnings("serial")
public class ValueLabel extends Label {

	@SpringBean
	private TermManager termMgr;
	@SpringBean
	private WebAddress webAddress;
	private boolean hideTextIfImageExists = false;

	public ValueLabel(String id, IModel<Value<?>> model) {
		super(id, model);
	}

	public ValueLabel(String id, Value<?> value) {
		this(id, new EmfModel<Value<?>>(value));
	}
	
	public ValueLabel(String id, IModel<Value<?>> model, boolean hideTextIfImageExists) {
		super(id, model);
		this.hideTextIfImageExists = hideTextIfImageExists;
	}

	public ValueLabel(String id, Value<?> value, boolean hideTextIfImageExists) {
		this(id, new EmfModel<Value<?>>(value), hideTextIfImageExists);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final Value<?> valueObj = (Value<?>) getDefaultModelObject();
//		final Locale locale = getLocale();
		if (valueObj != null) {
			final Term term = termMgr.findTerm(valueObj.getString());
			if (term != null) {
				final String iconHtml;
				if (term.getImageId() != null) {
					final String bundleName = "base".equals(term.getNsPrefix()) ? "org.soluvas.data" : "tenant_common";
					final String uri = webAddress.getImagesUri() + bundleName + "/" + term.getKindNsPrefix() + "_" + term.getKindName() +"/" + term.getImageId() + ".png";
					iconHtml = "<img class=\"img-circle\" src=\"" + uri + "\" alt=\"" + Strings.escapeMarkup(term.getDisplayName()) + "\" title=\"" + org.apache.wicket.util.string.Strings.escapeMarkup(term.getDisplayName()) + "\"/> ";
				} else {
					final String color = term.getColor();
					if (color != null) {
						iconHtml = "<span class=\"img-circle\" style=\"background: " + color + "; width: 20px; display: inline-block; border: 1px solid #ccc;\">&nbsp;</span> "; 
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
				return Strings.escapeMarkup(valueObj.getDisplayValue()) + ""; // foolproof way to convert CharSequence to String, do NOT cast CharSequence to String!
			}
		} else {
			return "";
		}
	}
	
}
