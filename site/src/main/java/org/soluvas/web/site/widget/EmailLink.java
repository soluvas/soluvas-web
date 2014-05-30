package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Hyperlink to email using
 * <a href="http://www.faqs.org/rfcs/rfc6068.html">mailto: URI specification (RFC6068)</a>.
 * @author rio
 * @see TelLink
 * @see EmailTextField
 */
public class EmailLink extends ExternalLink {

	/**
	 * @param id
	 * @param href
	 */
	public EmailLink(String id, String label) {
		this(id, new Model<>(label));
	}

	/**
	 * @param id
	 * @param href
	 */
	public EmailLink(String id, final IModel<String> label) {
		super(id, new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return label.getObject() != null ? "mailto:" + label.getObject() : null;
			}
		}, label);
	}

}
