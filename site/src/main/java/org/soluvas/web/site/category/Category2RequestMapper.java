package org.soluvas.web.site.category;

import javax.servlet.ServletRequest;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.MongoCategoryRepository;
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
import com.google.common.collect.ImmutableList;

/**
 * Match request to a {@code CategoryShow} {@link Page}, with {@code slugPath} parameter
 * based on {@link Category#getSlugPath()}, using {@link CategoryRepository}.
 * <p>Usage:
 * <pre>
 * mount(new CategoryRequestMapper(CategoryShowPage.class));
 * </pre>
 * @author ceefour
 */
public class Category2RequestMapper extends SeoBookmarkableMapper {
	
	private static final Logger log = LoggerFactory
			.getLogger(Category2RequestMapper.class);
	public static final String SLUG_PATH_PARAMETER = "slugPath";

	private final Class<? extends Page> categoryShowPage;

	/**
	 * @param categoryShowPage CategoryShow {@link Page} with {@code slugPath} parameter.
	 */
	public Category2RequestMapper(Class<? extends Page> categoryShowPage) {
		super();
		this.categoryShowPage = categoryShowPage;
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
		if (request.getUrl().getSegments().size() >= 2) {
			final String localePrefId = request.getUrl().getSegments().get(0);
			final String upSlugPath = Joiner.on('/').join(request.getUrl().getSegments().subList(1, request.getUrl().getSegments().size()));
			if (SlugUtils.SEGMENT_PATH_PATTERN.matcher(upSlugPath).matches()) {
				final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
						((ServletRequest) request.getContainerRequest()).getServletContext());
				final MongoCategoryRepository categoryRepo = appCtx.getBean(MongoCategoryRepository.class);
				// RAW because we can detect mismatch
				final Existence<String> existence = categoryRepo.existsBySlugPath(StatusMask.RAW, upSlugPath);
				switch (existence.getState()) {
				case MATCHED:
					final PageParameters pageParameters = Optional.fromNullable(
							extractPageParameters(request, request.getUrl().getSegments().size(), pageParametersEncoder))
							.or(new PageParameters());
					pageParameters.set(LOCALE_PREF_ID_PARAMETER, localePrefId);
					pageParameters.set(SLUG_PATH_PARAMETER, existence.get());
					return new UrlInfo(getPageComponentInfo(request.getUrl()), 
							categoryShowPage, pageParameters);
				case MISMATCHED:
					// canonical URI
					throw new MapperRedirectException(new PageProvider(categoryShowPage,
							new PageParameters()
								.set(LOCALE_PREF_ID_PARAMETER, localePrefId)
								.set(SLUG_PATH_PARAMETER, existence.get())));
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
			if (info.getPageParameters().get(LOCALE_PREF_ID_PARAMETER).isEmpty()) {
				log.warn("localePrefId PageParameter must be given", new IllegalArgumentException("localePrefId PageParameter must be given"));
			}
			final String defaultLocalePrefId = Session.get().getLocale().toLanguageTag().equals("id-ID") ? SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID : SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_EN;
			final String localePrefId = info.getPageParameters().get(LOCALE_PREF_ID_PARAMETER).toString(defaultLocalePrefId);
			final String categorySlugPath = info.getPageParameters().get(SLUG_PATH_PARAMETER).toString();
			if (categorySlugPath != null) {
				final PageParameters copy = new PageParameters(info.getPageParameters());
				copy.remove(LOCALE_PREF_ID_PARAMETER);
				copy.remove(SLUG_PATH_PARAMETER);
				final ImmutableList<String> segments = ImmutableList.<String>builder()
						.add(localePrefId)
						.addAll(Splitter.on('/').splitToList(categorySlugPath)).build();
				final Url url = new Url(segments, Charsets.UTF_8);
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
