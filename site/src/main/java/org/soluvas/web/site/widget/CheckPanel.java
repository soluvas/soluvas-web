package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.form.Check;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

@SuppressWarnings("serial")
public class CheckPanel<T> extends GenericPanel<T> {
	
	public CheckPanel(String id, IModel<T> model) {
		super(id, model);
		add(new Check<>("check", model));
	}
	
}