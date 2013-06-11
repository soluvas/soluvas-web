package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.form.CheckGroupSelector;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Used by {@link CheckColumn} in table header column.
 * @author rudi
 */
@SuppressWarnings("serial")
public class CheckHeaderPanel extends Panel {
	
	public CheckHeaderPanel(String id) {
		super(id);
		add(new CheckGroupSelector("selector"));
	}
	
}