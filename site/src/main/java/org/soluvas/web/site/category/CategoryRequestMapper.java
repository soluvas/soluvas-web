package org.soluvas.web.site.category;

import org.apache.wicket.Page;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler.RedirectPolicy;
import org.apache.wicket.core.request.mapper.AbstractBookmarkableMapper;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.commons.SlugUtils;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.web.site.MapperRedirectException;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;

/**
 * Match request to a {@code CategoryShow} {@link Page}, with {@code slugPath} parameter
 * based on {@link Category#getSlugPath()}, using {@link CategoryRepository}.
 * <p>Usage:
 * <pre>
 * mount(new CategoryRequestMapper(CategoryShowPage.class));
 * </pre>
 * @author ceefour
 */
public class CategoryRequestMapper extends AbstractBookmarkableMapper {
	
	private static final Logger log = LoggerFactory
			.getLogger(CategoryRequestMapper.class);

	@SpringBean
	private CategoryRepository categoryRepo;
	private final Class<? extends Page> categoryShowPage;
	
	/**
	 * @param CategoryShow {@link Page} with {@code slugPath} parameter.
	 */
	public CategoryRequestMapper(Class<? extends Page> categoryShowPage) {
		super();
		this.categoryShowPage = categoryShowPage;
		Injector.get().inject(this);
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
		if (request.getUrl().getSegments().size() >= 2 && "category".equals(request.getUrl().getSegments().get(0))) {
			// legacy URIs: shouldn't be needed after Bippo 7.0
			log.debug("legacy segments: {}", request.getUrl().getSegments());
			final String segments = Joiner.on('/').join(FluentIterable.from(request.getUrl().getSegments()).skip(1));
			throw new MapperRedirectException(new PageProvider(categoryShowPage, new PageParameters().set("slugPath", segments)));
		} else if (request.getUrl().getSegments().size() >= 1) {
			log.debug("segments: {}", request.getUrl().getSegments());
			final String segments = Joiner.on('/').join(request.getUrl().getSegments());
			if (SlugUtils.SLUG_PATTERN.matcher(segments).matches()) {
				// RAW because we can detect mismatch
				final Existence<String> existence = categoryRepo.existsBySlugPath(StatusMask.RAW, segments);
				log.trace("match segments: {} {}", request.getUrl().getSegments(), existence);
				switch (existence.getState()) {
				case MATCHED:
					return new UrlInfo(null, categoryShowPage, new PageParameters().set("slugPath", existence.get()));
				case MISMATCHED:
					// canonical URI
					throw new MapperRedirectException(new PageProvider(categoryShowPage, new PageParameters().set("slugPath", existence.get())));
				default:
				}
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.request.IRequestMapper#getCompatibilityScore(org.apache.wicket.request.Request)
	 */
	@Override
	public int getCompatibilityScore(Request request) {
		return -1;
	}

	@Override
	protected Url buildUrl(UrlInfo info) {
		if (info.getPageClass() == categoryShowPage && info.getPageParameters() != null) {
			final String categorySlugPath = info.getPageParameters().get("slugPath").toString();
			if (categorySlugPath != null) {
				return new Url(Splitter.on('/').splitToList(categorySlugPath), Charsets.UTF_8);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public IRequestHandler mapRequest(Request request) {
		try {
			return super.mapRequest(request);
		} catch (MapperRedirectException e) {
			log.debug("Redirecting '{}' to canonical page: {}", request.getUrl(), e.getPageProvider());
			return new RenderPageRequestHandler(e.getPageProvider(), RedirectPolicy.ALWAYS_REDIRECT);
		}
	}

	@Override
	protected boolean pageMustHaveBeenCreatedBookmarkable() {
		return false;
	}

}
