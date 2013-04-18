package org.soluvas.web.site.widget;

import javax.annotation.Nullable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.WebAddress;
import org.soluvas.image.DisplayImage;

import com.google.common.base.Strings;

/**
 * Displays a {@link DisplayImage}.
 * @author rio
 */
@SuppressWarnings("serial")
public class DisplayImageContainer extends WebMarkupContainer {

	@SpringBean
	private WebAddress webAddress;
	private final String title;
	
	public DisplayImageContainer(String id, IModel<DisplayImage> model) {
		super(id, model);
		this.title = null;
	}
	
	/**
	 * @param id
	 * @param model
	 * @param title Title to override alt & title attributes.
	 */
	public DisplayImageContainer(String id, IModel<DisplayImage> model, @Nullable String title) {
		super(id, model);
		this.title = title;
	}
	
	public DisplayImageContainer(String id, DisplayImage image) {
		super(id, new Model<>(image));
		this.title = null;
	}
	
	/**
	 * @param id
	 * @param image
	 * @param title Title to override alt & title attributes.
	 */
	public DisplayImageContainer(String id, DisplayImage image, @Nullable String title) {
		super(id, new Model<>(image));
		this.title = title;
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		final DisplayImage image = (DisplayImage) getDefaultModelObject();
		tag.put("src", image.getSrc());
		if (image.getWidth() != null) {
			tag.put("width", image.getWidth());
		}
		if (image.getHeight() != null) {
			tag.put("height", image.getHeight());
		}
		if (!Strings.isNullOrEmpty(title)) {
			tag.put("alt", title);
			tag.put("title", title);
		} else {
			if (!Strings.isNullOrEmpty(image.getAlt())) {
				tag.put("alt", image.getAlt());
			}
			if (!Strings.isNullOrEmpty(image.getTitle())) {
				tag.put("title", image.getTitle());
			}
		}
	}
	
}
