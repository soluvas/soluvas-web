package org.soluvas.web.olark;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.security.SecurityCatalog;
import org.soluvas.security.util.SecurityHelper;
import org.soluvas.web.site.SiteException;

/**
 * @author atang
 * 
 */
public class LiveChatPanel extends Panel {
	private static final long serialVersionUID = 1L;

	@SpringBean
	private SecurityCatalog securityCatalog;

	/**
	 * @param id
	 * @param model
	 */
	public LiveChatPanel(String id, IModel<LiveChatManager> model) {
		super(id, model);
		final LiveChatManager liveChatMgr = model.getObject();
		// only display live chat if NOT has app/mall role: https://idbippo.atlassian.net/browse/BC-1397
		boolean displayLiveChat = false;
		if (liveChatMgr.isEnabled()) {
			final Subject subject = SecurityUtils.getSubject();
			if (!subject.isAuthenticated()) {
				// display live chat for guests
				displayLiveChat = true;
			} else {
				// display live chat for regular users ONLY
				displayLiveChat = !SecurityHelper.hasAnyRealRole(securityCatalog, subject);
			}
		}
		final Component inner;
		if (displayLiveChat) {
			switch (liveChatMgr.getProvider()) {
			case OLARK:
				inner = new Olark("inner", new Model<>(liveChatMgr.getSiteId()));
				break;
			case LIVECHATINC:
				inner = new LiveChatinc("inner", new Model<>(
						liveChatMgr.getSiteId()));
				break;
			default:
				throw new SiteException("Unknown live chat provider: " + liveChatMgr.getProvider());
			}
		} else {
			inner = new EmptyPanel("inner");
			inner.setVisible(false);
		}
		add(inner);
	}

}
