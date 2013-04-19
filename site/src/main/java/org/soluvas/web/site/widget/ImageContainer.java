package org.soluvas.web.site.widget;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

@SuppressWarnings("serial")
public class ImageContainer extends WebMarkupContainer {

	public ImageContainer(String id, IModel<String> model) {
		super(id, model);
	}

	public ImageContainer(String id) {
		super(id);
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("img");
		tag.setHasNoCloseTag(true);
		tag.put("src", getDefaultModelObjectAsString());
		super.onComponentTag(tag);
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		setVisible(getDefaultModelObject() != null);
	}
	
}
