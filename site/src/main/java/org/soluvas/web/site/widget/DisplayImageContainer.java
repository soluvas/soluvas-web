package org.soluvas.web.site.widget;

import javax.annotation.Nullable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.WebAddress;
import org.soluvas.image.DisplayImage;
import org.soluvas.web.site.EmfModel;

import com.google.common.base.Strings;

/**
 * Displays a {@link DisplayImage}.
 * @author rio
 */
public class DisplayImageContainer extends WebMarkupContainer {

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private WebAddress webAddress;
	private final IModel<String> titleModel;
	
	public DisplayImageContainer(String id, IModel<DisplayImage> model) {
		super(id, model);
		this.titleModel = new Model<>();
	}
	
	/**
	 * @param id
	 * @param model
	 * @param title Title to override alt & title attributes.
	 */
	public DisplayImageContainer(String id, IModel<DisplayImage> model, @Nullable String title) {
		super(id, model);
		this.titleModel = new Model<>(title);
	}
	
	/**
	 * @param id
	 * @param model
	 * @param title Title to override alt & title attributes.
	 */
	public DisplayImageContainer(String id, IModel<DisplayImage> model, IModel<String> titleModel) {
		super(id, model);
		this.titleModel = titleModel;
	}
	
	public DisplayImageContainer(String id, DisplayImage image) {
		super(id, new EmfModel<>(image));
		this.titleModel = new Model<>();
	}
	
	/**
	 * @param id
	 * @param image
	 * @param title Title to override alt & title attributes.
	 */
	public DisplayImageContainer(String id, DisplayImage image, @Nullable String title) {
		super(id, new EmfModel<>(image));
		this.titleModel = new Model<>(title);
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		final DisplayImage image = (DisplayImage) getDefaultModelObject();
		tag.put("src", image.getSrc());
		// only override width & height if not specified by markup
		if (tag.getAttribute("width") == null && image.getWidth() != null) {
			tag.put("width", image.getWidth());
		}
		if (tag.getAttribute("height") == null && image.getHeight() != null) {
			tag.put("height", image.getHeight());
		}
		final String title = titleModel.getObject();
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
	
	@Override
	protected void detachModel() {
		super.detachModel();
		titleModel.detach();
	}
	
}
