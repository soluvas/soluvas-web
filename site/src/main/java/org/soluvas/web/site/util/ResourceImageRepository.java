package org.soluvas.web.site.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.io.FilenameUtils;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.SharedResourceReference;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ProgressMonitor;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepositoryBase;
import org.soluvas.image.ImageConnector;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.store.Image;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.image.store.ImageStyle;
import org.soluvas.image.store.StyledImage;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Serves static images from classpath resources using Wicket {@link SharedResourceReference} mechanism.
 * <p>Important: methods must be called inside a Wicket servlet thread.
 * @author ceefour
 */
public class ResourceImageRepository extends PagingAndSortingRepositoryBase<Image, String> implements ImageRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(ResourceImageRepository.class);
	private List<Resource> resources;
	private final Class<?> scope;
	private final String subpackage;
	
	public ResourceImageRepository(Class<?> scope, @Nullable String subpackage) {
		super();
		this.scope = scope;
		this.subpackage = subpackage;
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(scope.getClassLoader());
		final String locationPattern = "classpath:/" + scope.getPackage().getName().replace('.', '/') +
				(!Strings.isNullOrEmpty(subpackage) ? "/" + subpackage : "") + "/*.jpg";
		try {
			final Resource[] resources = resolver.getResources(locationPattern);
			log.info("Scanning {} returned {} resources: {}", locationPattern,
					resources.length, resources);
			this.resources = ImmutableList.copyOf(resources);
		} catch (IOException e) {
			throw new RuntimeException("Cannot scan " + locationPattern, e);
		}
//		Lists.transform(ImmutableList.copyOf(resources), new Function<Resource, Image>() {
//			@Override @Nullable
//			public Image apply(@Nullable Resource input) {
//				return null;
//			}
//		});
	}

//	/**
//	 * @param classLoader
//	 * @param directory Must be at least one subfolder. Root ('/') won't work due to JDK limitation.
//	 */
//	public ResourceImageRepository(ClassLoader classLoader, String directory) {
//		super();
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(classLoader);
//		final String locationPattern = "classpath:" + directory + "/*.jpg";
//		try {
//			final Resource[] resources = resolver.getResources(locationPattern);
//			log.info("Scanning {} returned {} resources: {}", locationPattern,
//					resources.length, resources);
//			this.resources = ImmutableList.copyOf(resources);
//		} catch (IOException e) {
//			throw new RuntimeException("Cannot scan " + locationPattern, e);
//		}
////		Lists.transform(ImmutableList.copyOf(resources), new Function<Resource, Image>() {
////			@Override @Nullable
////			public Image apply(@Nullable Resource input) {
////				return null;
////			}
////		});
//	}

	@Override
	public long count() {
		return resources.size();
	}

	@Override
	@Deprecated
	public void addStyle(String name, String code, int maxWidth, int maxHeight) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<ImageStyle> getStyles() {
		return ImmutableList.of(
				new ImageStyle(ImageStyles.THUMBNAIL.getLiteral(), "t", 75, 75),
				new ImageStyle(ImageStyles.SMALL.getLiteral(), "s", 240, null),
				new ImageStyle(ImageStyles.NORMAL.getLiteral(), "n", 480, null)
			);
	}

	@Override
	public void setStyles(List<ImageStyle> styles) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getImageUri(String id, String styleName) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public Image create(String fileName, InputStream content,
			String contentType, long length, String name) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Image create(String imageId, File originalFile, String contentType,
			String name) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Map<String, Image> findAllByIds(Iterable<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<String> findAllIds() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Image> search(String searchText) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void reprocess(Iterable<String> ids, ProgressMonitor pm) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void reprocessAll(ProgressMonitor pm) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getNamespace() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getMongoUri() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateUriAll(ProgressMonitor monitor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateUri(Collection<String> imageIds, ProgressMonitor monitor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getUriTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageConnector getConnector() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Image> List<S> add(Collection<S> newImages,
			ProgressMonitor monitor) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Nullable
	protected String getId(Image entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Image> Collection<S> add(Collection<S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <S extends Image> Collection<S> modify(Map<String, S> entities) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<String> exists(Collection<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Image> findAll(final Collection<String> ids) {
		final Iterable<Resource> filtered = Iterables.filter(resources, new Predicate<Resource>() {
			@Override
			public boolean apply(@Nullable Resource input) {
				final String baseName = FilenameUtils.getBaseName(input.getFilename());
				return ids.contains(baseName);
			}
		});
		final Iterable<Image> transformed = Iterables.transform(filtered, new Function<Resource, Image>() {
			@Override @Nullable
			public Image apply(@Nullable Resource input) {
				final String fileName = input.getFilename();
				final String baseName = FilenameUtils.getBaseName(fileName);
				final SharedResourceReference resourceRef = new SharedResourceReference(scope, 
						(!Strings.isNullOrEmpty(subpackage) ? subpackage + "/" : "") + fileName);
				final String url = RequestCycle.get().urlFor(resourceRef, new PageParameters()).toString();
				
				final Map<String, StyledImage> styledImages = new HashMap<>();
				for (ImageStyle style : getStyles()) {
					final StyledImage styled = new StyledImage(style.getName(), "t", url, "image/jpeg", 0L, 0, 0);
					styledImages.put(style.getName(), styled);
				}
				
				final Image image = new Image(baseName, url, url, "image/jpeg", fileName, 0L, 
						styledImages, baseName, new DateTime());
				return image;
			}
		});
		return ImmutableList.copyOf(transformed);
	}

	@Override
	public long deleteIds(Collection<String> ids) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<String> findAllIds(Pageable pageable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<Image> findAll(Pageable pageable) {
		throw new UnsupportedOperationException();
	}

}
