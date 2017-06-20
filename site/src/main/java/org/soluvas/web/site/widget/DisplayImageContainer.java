package org.soluvas.web.site.widget;

import javax.annotation.Nullable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.WebAddress;
import org.soluvas.image.DisplayImage2;
import org.soluvas.web.site.semantic.ImageMicrodataBehavior;
import org.soluvas.web.site.semantic.ItemPropBehavior;
import org.soluvas.web.site.semantic.SchemaOrgProperty;

import com.google.common.base.Strings;

/**
 * Displays a {@link DisplayImage2} with itemprop={@link SchemaOrgProperty#CONTENT_URL}.
 * @author rio
 * @see ImageMicrodataBehavior
 */
@SuppressWarnings("serial")
public class DisplayImageContainer extends WebMarkupContainer {

	@SpringBean
	private WebAddress webAddress;
	private final IModel<String> titleModel;
	
	public DisplayImageContainer(String id, IModel<DisplayImage2> model) {
		super(id, model);
		this.titleModel = new Model<>();
	}
	
	/**
	 * @param id
	 * @param model
	 * @param title Title to override alt & title attributes.
	 */
	public DisplayImageContainer(String id, IModel<DisplayImage2> model, @Nullable String title) {
		super(id, model);
		this.titleModel = new Model<>(title);
	}
	
	/**
	 * @param id
	 * @param model
	 * @param title Title to override alt & title attributes.
	 */
	public DisplayImageContainer(String id, IModel<DisplayImage2> model, IModel<String> titleModel) {
		super(id, model);
		this.titleModel = titleModel;
	}
	
	public DisplayImageContainer(String id, DisplayImage2 image) {
		super(id, new Model<>(image));
		this.titleModel = new Model<>();
	}
	
	/**
	 * @param id
	 * @param image
	 * @param title Title to override alt & title attributes.
	 */
	public DisplayImageContainer(String id, DisplayImage2 image, @Nullable String title) {
		super(id, new Model<>(image));
		this.titleModel = new Model<>(title);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new ItemPropBehavior(SchemaOrgProperty.CONTENT_URL));
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		final DisplayImage2 image = (DisplayImage2) getDefaultModelObject();
		if (image == null) {
			return;
		}
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
