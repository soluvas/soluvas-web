package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * Hyperlink to telephone or mobile number using
 * <a href="http://tools.ietf.org/html/rfc3966">tel: URI specification (RFC3966)</a> and <a href="http://tools.ietf.org/html/rfc5341">RFC5341</a>.
 * @author rio
 * @see TelTextField
 * @see EmailLink
 */
public class TelLink extends ExternalLink {

	/**
	 * @param id
	 * @param href
	 */
	public TelLink(String id, String label) {
		this(id, new Model<>(label));
	}

	/**
	 * @param id
	 * @param href
	 */
	public TelLink(String id, final IModel<String> label) {
		super(id, new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return label.getObject() != null ? "tel:" + label.getObject() : null;
			}
		}, label);
	}

}
