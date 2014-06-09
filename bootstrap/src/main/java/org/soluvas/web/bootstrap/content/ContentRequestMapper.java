package org.soluvas.web.bootstrap.content;

import javax.servlet.ServletRequest;

import org.apache.wicket.Page;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler.RedirectPolicy;
import org.apache.wicket.core.request.mapper.AbstractBookmarkableMapper;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.SlugUtils;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.site.MapperRedirectException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.hp.hpl.jena.assembler.Content;

/**
 * Match request to a {@code ContentShow} {@link Page} containing {@link org.soluvas.web.bootstrap.content.ContentPanel}, with {@code slugPath} parameter
 * based on {@link Content#getSlugPath()}, using {@code contentLookup} bean.
 * <p>Usage:
 * <pre>
 * mount(new ContentRequestMapper(ContentShowPage.class));
 * </pre>
 * @author ceefour
 */
public class ContentRequestMapper extends AbstractBookmarkableMapper {
	
	private static final Logger log = LoggerFactory
			.getLogger(ContentRequestMapper.class);

	private final Class<? extends Page> contentShowPage;
	
	/**
	 * @param ContentShow {@link Page} with {@code slugPath} parameter.
	 */
	public ContentRequestMapper(Class<? extends Page> contentShowPage) {
		super();
		this.contentShowPage = contentShowPage;
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
		if (request.getUrl().getSegments().size() == 2 && "p".equals(request.getUrl().getSegments().get(0))) {
			// legacy URIs: shouldn't be needed after Bippo 7.0
			log.trace("legacy segments: {}", request.getUrl().getSegments());
			final String segments = Joiner.on('/').join(FluentIterable.from(request.getUrl().getSegments()).skip(1));
			throw new MapperRedirectException(new PageProvider(contentShowPage, ContentPanel.bySlugPath(segments)));
		} else if (request.getUrl().getSegments().size() == 1) {
			log.trace("segments: {}", request.getUrl().getSegments());
			final String segments = Joiner.on('/').join(request.getUrl().getSegments());
			if (SlugUtils.SEGMENT_PATH_PATTERN.matcher(segments).matches()) {
				final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
						((ServletRequest) request.getContainerRequest()).getServletContext());
				final EntityLookup<String, String> contentLookup = appCtx.getBean("contentLookup", EntityLookup.class); 
				try {
					final String found = contentLookup.findOne(segments);
					log.trace("match segments: {} {}", segments, found != null);
					if (found != null) {
						return new UrlInfo(null, contentShowPage, ContentPanel.bySlugPath(segments));
					}
				} catch (Exception e) {
					// does not match
					log.trace("Content not found for '" + segments + "' using " + 
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
			final String contentSlugPath = info.getPageParameters().get("slugPath").toString();
			if (contentSlugPath != null) {
				return new Url(Splitter.on('/').splitToList(contentSlugPath), Charsets.UTF_8);
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
