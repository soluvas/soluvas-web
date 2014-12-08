package org.soluvas.web.site.category;

import javax.servlet.ServletRequest;

import org.apache.wicket.Page;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.commons.SlugUtils;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.web.site.MapperRedirectException;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
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
public class CategoryRequestMapper extends SeoBookmarkableMapper {
	
	private static final Logger log = LoggerFactory
			.getLogger(CategoryRequestMapper.class);
	public static final String SLUG_PATH_PARAMETER = "slugPath";

	private final Class<? extends Page> categoryShowPage;

	/**
	 * @param categoryShowPage CategoryShow {@link Page} with {@code slugPath} parameter.
	 */
	public CategoryRequestMapper(Class<? extends Page> categoryShowPage) {
		super();
		this.categoryShowPage = categoryShowPage;
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
		if (request.getUrl().getSegments().size() >= 2 && "category".equals(request.getUrl().getSegments().get(0))) {
			// legacy URIs: shouldn't be needed after Bippo 7.0
			log.trace("legacy segments: {}", request.getUrl().getSegments());
			final String segments = Joiner.on('/').join(FluentIterable.from(request.getUrl().getSegments()).skip(1));
			throw new MapperRedirectException(new PageProvider(categoryShowPage, new PageParameters().set("slugPath", segments)));
		} else if (request.getUrl().getSegments().size() >= 1) {
			log.trace("segments: {}", request.getUrl().getSegments());
			final String segments = Joiner.on('/').join(request.getUrl().getSegments());
			if (SlugUtils.SEGMENT_PATH_PATTERN.matcher(segments).matches()) {
				final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
						((ServletRequest) request.getContainerRequest()).getServletContext());
				final CategoryRepository categoryRepo = appCtx.getBean(CategoryRepository.class);
				// RAW because we can detect mismatch
				final Existence<String> existence = categoryRepo.existsBySlugPath(StatusMask.RAW, segments);
				log.trace("match segments: {} {}", request.getUrl().getSegments(), existence);
				switch (existence.getState()) {
				case MATCHED:
					final PageParameters pageParameters = Optional.fromNullable(
							extractPageParameters(request, request.getUrl().getSegments().size(), pageParametersEncoder))
							.or(new PageParameters());
					pageParameters.set(SLUG_PATH_PARAMETER, existence.get());
					return new UrlInfo(getPageComponentInfo(request.getUrl()), 
							categoryShowPage, pageParameters);
				case MISMATCHED:
					// canonical URI
					throw new MapperRedirectException(new PageProvider(categoryShowPage,
							new PageParameters().set(SLUG_PATH_PARAMETER, existence.get())));
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
			final String categorySlugPath = info.getPageParameters().get(SLUG_PATH_PARAMETER).toString();
			if (categorySlugPath != null) {
				final PageParameters copy = new PageParameters(info.getPageParameters());
				copy.remove(SLUG_PATH_PARAMETER);
				final Url url = new Url(Splitter.on('/').splitToList(categorySlugPath), Charsets.UTF_8);
				encodePageComponentInfo(url, info.getPageComponentInfo());
				return encodePageParameters(url, copy, pageParametersEncoder);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
