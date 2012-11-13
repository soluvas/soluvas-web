package org.soluvas.web.jquerynotify;

import org.soluvas.web.site.ComponentFactory;

/**
 * @author ceefour
 */
public class NotifyPanelFactory implements ComponentFactory<NotifyPanel> {

	@Override
	public NotifyPanel create(String id) {
		return new NotifyPanel(id);
	}

}
