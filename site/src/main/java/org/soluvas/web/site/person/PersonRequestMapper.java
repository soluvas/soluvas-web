package org.soluvas.web.site.person;

import javax.servlet.ServletRequest;

import org.apache.wicket.Page;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler.RedirectPolicy;
import org.apache.wicket.core.request.mapper.AbstractBookmarkableMapper;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.web.site.MapperRedirectException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;

/**
 * Match request to a {@code PersonShow}{@link Page}, with {@code slug} parameter
 * based on {@link Person#getSlug()}, using {@link PersonRepository}.
 * <p>Usage:
 * <pre>
 * mount(new PersonRequestMapper(PersonShowPage.class));
 * </pre>
 * @author ceefour
 */
public class PersonRequestMapper extends AbstractBookmarkableMapper {
	
	private static final Logger log = LoggerFactory
			.getLogger(PersonRequestMapper.class);

	private final Class<? extends Page> personShowPage;
	
	/**
	 * @param personShowPage Page with {@code slug} parameter.
	 */
	public PersonRequestMapper(Class<? extends Page> personShowPage) {
		super();
		this.personShowPage = personShowPage;
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
		if (request.getUrl().getSegments().size() == 1) {
			final String segment1 = request.getUrl().getSegments().get(0);
			log.debug("segment1 person request mapper {}", segment1);
			log.trace("segments: {}", request.getUrl().getSegments());
			if (SlugUtils.SEGMENT_PATTERN.matcher(segment1).matches()) {
				log.debug("masuk person request mapper");
				final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
						((ServletRequest) request.getContainerRequest()).getServletContext());
				final PersonRepository personRepo = appCtx.getBean(PersonRepository.class);
				// RAW because we can detect mismatch
				final Existence<String> existence = personRepo.existsBySlug(StatusMask.RAW, segment1);
				log.trace("match segments: {} {}", request.getUrl().getSegments(), existence);
				switch (existence.getState()) {
				case MATCHED:
					return new UrlInfo(getPageComponentInfo(request.getUrl()),
							personShowPage, new PageParameters().set("slug", existence.get()));
				case MISMATCHED:
					// canonical URI
					throw new MapperRedirectException(new PageProvider(personShowPage, new PageParameters().set("slug", existence.get())));
					
//					throw new MapperRedirectException(new PageProvider(PersonPubViewPage.class, PersonPubViewPage.bySlug(existence.get())));
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
		if (info.getPageClass() == personShowPage && info.getPageParameters() != null) {
			final String personSlug = info.getPageParameters().get("slug").toString();
			if (personSlug != null) {
				final Url url = new Url(ImmutableList.of(personSlug), Charsets.UTF_8);
				encodePageComponentInfo(url, info.getPageComponentInfo());
				return url;
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
