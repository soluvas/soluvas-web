package org.soluvas.web.site.person;

import javax.servlet.ServletRequest;

import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import org.apache.wicket.Page;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler.RedirectPolicy;
import org.apache.wicket.core.request.mapper.AbstractBookmarkableMapper;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.IPageParametersEncoder;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.mapper.parameter.PageParametersEncoder;
import org.apache.wicket.util.lang.Args;
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
	public static final String SLUG_PARAMETER = "slug";

	private IPageParametersEncoder pageParametersEncoder = new PageParametersEncoder();
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
			log.trace("segments: {}", request.getUrl().getSegments());
			if (SlugUtils.SCREEN_NAME_PATTERN.matcher(segment1).matches()) {
				final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
						((ServletRequest) request.getContainerRequest()).getServletContext());
				final PersonRepository personRepo = appCtx.getBean(PersonRepository.class);
				// RAW because we can detect mismatch
				final Existence<String> existence = personRepo.existsBySlug(StatusMask.RAW, segment1);
				log.trace("match segments: {} {}", request.getUrl().getSegments(), existence);
				switch (existence.getState()) {
				case MATCHED:
					final PageParameters pageParameters = Optional.fromNullable(
							extractPageParameters(request, 1, pageParametersEncoder))
							.or(new PageParameters());
					pageParameters.set(SLUG_PARAMETER, existence.get());
					return new UrlInfo(getPageComponentInfo(request.getUrl()),
							personShowPage, pageParameters);
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
			final String personSlug = info.getPageParameters().get(SLUG_PARAMETER).toString();
			if (personSlug != null) {
				final PageParameters copy = new PageParameters(info.getPageParameters());
				copy.remove(SLUG_PARAMETER);
				final Url url = new Url(ImmutableList.of(personSlug), Charsets.UTF_8);
				encodePageComponentInfo(url, info.getPageComponentInfo());
				return encodePageParameters(url, copy, pageParametersEncoder);
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

	/**
	 * Encodes the given {@link org.apache.wicket.request.mapper.parameter.PageParameters} to the URL using the given
	 * {@link org.apache.wicket.request.mapper.parameter.IPageParametersEncoder}. The original URL object is unchanged.
	 *
	 * @param url
	 * @param pageParameters
	 * @param encoder
	 * @return URL with encoded parameters
	 */
	protected Url encodePageParameters(Url url, PageParameters pageParameters,
									   final IPageParametersEncoder encoder) {
		Args.notNull(url, "url");
		Args.notNull(encoder, "encoder");

		if (pageParameters == null)
		{
			pageParameters = new PageParameters();
		}

		Url parametersUrl = encoder.encodePageParameters(pageParameters);
		if (parametersUrl != null)
		{
			// copy the url
			url = new Url(url);

			for (String s : parametersUrl.getSegments())
			{
				url.getSegments().add(s);
			}
			for (Url.QueryParameter p : parametersUrl.getQueryParameters())
			{
				url.getQueryParameters().add(p);
			}
		}

		return url;
	}

}
