package org.soluvas.web.bootstrap.content;

import javax.servlet.ServletRequest;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.SlugUtils;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.hp.hpl.jena.assembler.Content;

/**
 * Match request to a {@code ContentShow} {@link Page} containing {@link org.soluvas.web.bootstrap.content.ContentPanel}, with {@code slugPath} parameter
 * based on {@link Content#getSlugPath()}, using {@code contentLookup} bean.
 * <p>Usage:
 * <pre>
 * mount(new ContentRequestMapper(ContentPage.class));
 * </pre>
 * @author ceefour
 */
public class ContentRequestMapper extends SeoBookmarkableMapper {
	
	private static final Logger log = LoggerFactory
			.getLogger(ContentRequestMapper.class);
	public static final String SLUG_PATH_PARAMETER = "slugPath";

	private final Class<? extends Page> contentShowPage;

	/**
	 * @param contentShowPage ContentShow {@link Page} with {@code slugPath} parameter.
	 */
	public ContentRequestMapper(Class<? extends Page> contentShowPage) {
		super();
		this.contentShowPage = contentShowPage;
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
//		if (request.getUrl().getSegments().size() == 2 && "p".equals(request.getUrl().getSegments().get(0))) {
//			// legacy URIs: shouldn't be needed after Bippo 7.0
//			log.trace("legacy segments: {}", request.getUrl().getSegments());
//			final String segments = Joiner.on('/').join(FluentIterable.from(request.getUrl().getSegments()).skip(1));
//			throw new MapperRedirectException(new PageProvider(contentShowPage, ContentPanel.bySlugPath(segments)));
//		} else 
		if (request.getUrl().getSegments().size() == 2) {
			final String localePrefId = request.getUrl().getSegments().get(0);
			final String upSlug = Joiner.on('/').join(request.getUrl().getSegments().subList(1, request.getUrl().getSegments().size()));
			if (SlugUtils.SEGMENT_PATH_PATTERN.matcher(upSlug).matches()) {
				final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
						((ServletRequest) request.getContainerRequest()).getServletContext());
				final EntityLookup<String, String> contentLookup = appCtx.getBean("contentLookup", EntityLookup.class); 
				try {
					final String found = contentLookup.findOne(upSlug);
					log.trace("match segments: {} {}", upSlug, found != null);
					if (found != null) {
						final PageParameters pageParameters = Optional.fromNullable(
								extractPageParameters(request, 2, pageParametersEncoder))
								.or(new PageParameters());
						pageParameters.set(LOCALE_PREF_ID_PARAMETER, localePrefId);
						pageParameters.set(SLUG_PATH_PARAMETER, upSlug);
						return new UrlInfo(getPageComponentInfo(request.getUrl()),
								contentShowPage, pageParameters);
					}
				} catch (Exception e) {
					// does not match
					log.trace("Content not found for '" + upSlug + "' using " + 
							contentLookup, e);
				}
				// TODO: content system should support existsBySlugPath
//				// RAW because we can detect mismatch
//				final Existence<String> existence = contentRepo.existsBySlugPath(StatusMask.RAW, segments);
//				log.trace("match segments: {} {}", segments, existence);
//				switch (existence.getState()) {
//				case MATCHED:
//					return new UrlInfo(null, contentShowPage, new PageParameters().set("slugPath", existence.get()));
//				case MISMATCHED:
//					// canonical URI
//					throw new MapperRedirectException(new PageProvider(contentShowPage, new PageParameters().set("slugPath", existence.get())));
//				default:
//				}
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
		if (info.getPageClass() == contentShowPage && info.getPageParameters() != null) {
			final String defaultLocalePrefId = Session.get().getLocale().toLanguageTag().equals("id-ID") ? SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID : SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_EN;
			final String localePrefId = info.getPageParameters().get(LOCALE_PREF_ID_PARAMETER).toString(defaultLocalePrefId);
			final String contentSlugPath = info.getPageParameters().get(SLUG_PATH_PARAMETER).toString();
			if (contentSlugPath != null) {
				final PageParameters copy = new PageParameters(info.getPageParameters());
				copy.remove(LOCALE_PREF_ID_PARAMETER);
				copy.remove(SLUG_PATH_PARAMETER);
				final ImmutableList<String> segments = ImmutableList.<String>builder()
						.add(localePrefId)
						.addAll(Splitter.on('/').splitToList(contentSlugPath)).build();
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
