package org.soluvas.web.site.widget;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.Imageable;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyle;
import org.soluvas.image.ImageType;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;

/**
 * "Canggih" version of {@code transient} {@code displayImagesModel}.
 * This is useless fancy overhead for {@link ChoiceProvider} implementations, but useful
 * for regular Wicket components/{@link Panel}s.
 * @author ceefour
 * @see DisplayImageIdsModel
 */
public class DisplayImagesModel<T extends Imageable> extends LoadableDetachableModel<Map<String, DisplayImage>> {

	private static final long serialVersionUID = 1L;

	@SpringBean
	private ImageManager imageMgr;
	
	private final ImageType namespace;
	private final ImageStyle imageStyle;
	private final IModel<? extends Collection<T>> imageablesModel;
	
	public DisplayImagesModel(ImageType namespace, ImageStyle imageStyle, IModel<? extends Collection<T>> imageablesModel) {
		super();
		this.namespace = namespace;
		this.imageStyle = imageStyle;
		this.imageablesModel = imageablesModel;
		Injector.get().inject(this);
	}
	
	protected Set<String> getImageIds() {
		final Collection<T> imageables = imageablesModel.getObject();
		if (imageables != null) {
			final Set<String> imageIds = FluentIterable.from(imageables).transform(new Function<T, String>() {
				@Override @Nullable
				public String apply(@Nullable T input) {
					return input.getImageId();
				}
			}).filter(new NotNullPredicate<>()).toSet();
			return imageIds;
		} else {
			return ImmutableSet.of();
		}
	}
	
	/**
	 * Override this to use your own logic, e.g. {@link Product#getListingImageId()}.
	 * By default it returns {@link Imageable#getImageId()}.
	 * @param imageable
	 * @return
	 */
	protected String getImageId(T imageable) {
		return imageable.getImageId();
	}

	@Override
	protected Map<String, DisplayImage> load() {
		final Set<String> imageIds = getImageIds();
		return imageMgr.getSafeImagesById(namespace, imageIds, imageStyle);
	}
	
}