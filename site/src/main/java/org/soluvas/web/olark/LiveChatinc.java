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
public class LiveChatinc extends Panel {
	public LiveChatinc(String id, IModel<String> model) {
		super(id, model);
		String siteId = model.getObject();
		
		final String identifyScript = "__lc.license = "+ siteId;
		final Label identify = new Label("identify", identifyScript);
		identify.setEscapeModelStrings(false);
		add(identify);
	}

}
