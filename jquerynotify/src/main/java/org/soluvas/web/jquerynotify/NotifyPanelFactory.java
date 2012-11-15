package org.soluvas.web.jquerynotify;

import java.io.Serializable;

import org.apache.wicket.model.IModel;
import org.soluvas.web.site.ComponentFactory;

/**
 * @author ceefour
 */
public class NotifyPanelFactory implements ComponentFactory<NotifyPanel, Serializable> {

	@Override
	public NotifyPanel create(String id, IModel<Serializable> model) {
		return new NotifyPanel(id);
	}

}
