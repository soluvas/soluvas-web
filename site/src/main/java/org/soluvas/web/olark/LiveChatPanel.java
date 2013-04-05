package org.soluvas.web.olark;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author atang
 * 
 */
@SuppressWarnings("serial")
public class LiveChatPanel extends Panel {
	/**
	 * @param id
	 * @param model
	 */
	public LiveChatPanel(String id, IModel<LiveChatManager> model) {
		super(id, model);
		Component inner = null;
		final LiveChatManager liveChatMgr = model.getObject();
		switch (liveChatMgr.getProvider()) {
		case OLARK:
			inner = new Olark("inner", new Model<>(liveChatMgr.getSiteId()));
			break;
		case LIVECHATINC:
			inner = new LiveChatinc("inner", new Model<>(
					liveChatMgr.getSiteId()));
			break;
		}
		setVisible(liveChatMgr.isEnabled());
		add(inner);
	}

}
