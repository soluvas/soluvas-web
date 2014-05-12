package org.soluvas.web.site.widget;

import java.io.Serializable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * @author ceefour
 *
 */
public class PercentLabel extends Label {

	private static final long serialVersionUID = 1L;
	
	public PercentLabel(String id, IModel<?> model) {
		super(id, model);
	}

	public PercentLabel(String id, Serializable label) {
		super(id, label);
	}

	public PercentLabel(String id, String label) {
		super(id, label);
	}

	public PercentLabel(String id) {
		super(id);
	}

	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		replaceComponentTagBody(markupStream, openTag, 
				getDefaultModelObjectAsString() + "<small class=\"text-muted\">%</small>");
	}

}
