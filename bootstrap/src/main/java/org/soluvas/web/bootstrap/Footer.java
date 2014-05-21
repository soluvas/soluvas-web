package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 * @author ceefour
 *
 */
public class Footer extends Panel {

	private static final long serialVersionUID = 1L;

	public Footer(String footerHtml) {
		super("footer", new Model<String>(footerHtml));
		final Label label = new Label("text", footerHtml);
		label.setEscapeModelStrings(false);
		add(label);
	}
	
}
