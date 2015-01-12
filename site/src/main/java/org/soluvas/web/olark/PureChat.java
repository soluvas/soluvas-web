/**
 * 
 */
package org.soluvas.web.olark;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author atang
 *
 */
public class PureChat extends Panel {

	public PureChat(String id, IModel<String> model) {
		super(id);
		final String siteId = model.getObject();
		final String identifyScript = "var w = new PCWidget({ c: '"+ siteId +"', f: true });";
		final Label identify = new Label("identify", identifyScript);
		identify.setEscapeModelStrings(false);
		add(identify);
	}

}
