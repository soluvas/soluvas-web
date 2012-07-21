/**
 * 
 */
package org.soluvas.web.site;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class SidebarNav extends Panel {

	public SidebarNav(String id, IModel<?> model) {
		super(id, model);
	}

	public SidebarNav(String id) {
		super(id);
	}

}
