package org.soluvas.web.site.widget;

import java.util.Collection;
import java.util.Map;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.image.DisplayImage2;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyle;
import org.soluvas.image.ImageType;

import com.google.common.collect.ImmutableMap;

/**
 * "Canggih" version of {@code transient} {@code displayImagesModel}.
 * This is useless fancy overhead for {@link ChoiceProvider} implementations, but useful
 * for regular Wicket components/{@link Panel}s.
 * @author ceefour
 * @see DisplayImagesModel
 */
public class DisplayImageIdsModel extends LoadableDetachableModel<Map<String, DisplayImage2>> {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private ImageManager imageMgr;
	
	private final ImageType namespace;
	private final ImageStyle imageStyle;
	private final IModel<? extends Collection<String>> imageIdsModel;
	
	public DisplayImageIdsModel(ImageType namespace, ImageStyle imageStyle, IModel<? extends Collection<String>> imageIdsModel) {
		super();
		this.namespace = namespace;
		this.imageStyle = imageStyle;
		this.imageIdsModel = imageIdsModel;
		Injector.get().inject(this);
	}
	
	@Override
	protected Map<String, DisplayImage2> load() {
		final Collection<String> imageIds = imageIdsModel.getObject();
		if (imageIds != null) {
			return imageMgr.getSafeImagesByIds(namespace, imageIds, imageStyle);
		} else {
			return ImmutableMap.<String, DisplayImage2>of();
		}
	}
	
}