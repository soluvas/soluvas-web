package org.soluvas.web.site.widget;

import java.io.Serializable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * {@link Label} that can change its HTML tag.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class TagLabel extends Label {
	
	private final TagType tagType;

	public TagLabel(String id, IModel<?> model, TagType tagType) {
		super(id, model);
		this.tagType = tagType;
	}

	public TagLabel(String id, Serializable label, TagType tagType) {
		super(id, label);
		this.tagType = tagType;
	}

	public TagLabel(String id, String label, TagType tagType) {
		super(id, label);
		this.tagType = tagType;
	}

	public TagLabel(String id, TagType tagType) {
		super(id);
		this.tagType = tagType;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		setRenderBodyOnly(tagType == TagType.NONE);
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName(tagType.name().toLowerCase());
		super.onComponentTag(tag);
	}
	
}
