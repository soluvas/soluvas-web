package org.soluvas.web.jquerynotify;

import org.soluvas.web.site.ComponentFactory;

/**
 * @author ceefour
 */
public class NotifyPanelFactory implements ComponentFactory<NotifyPanel> {

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.ComponentFactory#create(java.lang.String)
	 */
	@Override
	public NotifyPanel create(String id) {
		return new NotifyPanel(id);
	}

}
