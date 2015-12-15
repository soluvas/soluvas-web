package org.soluvas.web.site.person;

import javax.servlet.ServletRequest;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.data.Existence;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.web.site.MapperRedirectException;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.common.base.Charsets;
import com.google.common.base.Optional;
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
public class PersonRequestMapper extends SeoBookmarkableMapper {
	
	public static final String SLUG_PARAMETER = "slug";

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
		if (request.getUrl().getSegments().size() == 2 &&
				SeoBookmarkableMapper.SUPPORTED_LOCALE_PREFS.containsKey(request.getUrl().getSegments().get(0))) {
			final String localePrefId = request.getUrl().getSegments().get(0);
			final String upSlug = request.getUrl().getSegments().get(1);
			if (SlugUtils.SCREEN_NAME_PATTERN.matcher(upSlug).matches()) {
				final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
						((ServletRequest) request.getContainerRequest()).getServletContext());
				final PersonRepository personRepo = appCtx.getBean(PersonRepository.class);
				// RAW because we can detect mismatch
				final Existence<String> existence = personRepo.existsBySlug(StatusMask.RAW, upSlug);
				switch (existence.getState()) {
				case MATCHED:
					log.debug("MATCHED");
					final PageParameters pageParameters = Optional.fromNullable(
							extractPageParameters(request, 2, pageParametersEncoder))
							.or(new PageParameters());
					pageParameters.set(LOCALE_PREF_ID_PARAMETER, localePrefId);
					pageParameters.set(SLUG_PARAMETER, existence.get());
					return new UrlInfo(getPageComponentInfo(request.getUrl()),
							personShowPage, pageParameters);
				case MISMATCHED:
					log.debug("MISMATCHED");
					// canonical URI
					throw new MapperRedirectException(new PageProvider(personShowPage, 
							new PageParameters().set(LOCALE_PREF_ID_PARAMETER, localePrefId)
								.set(SLUG_PARAMETER, existence.get())));
//					throw new MapperRedirectException(new PageProvider(PersonPubViewPage.class, PersonPubViewPage.bySlug(existence.get())));
				default:
					log.debug("default");
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
			if (info.getPageParameters().get(LOCALE_PREF_ID_PARAMETER).isEmpty()) {
				log.warn("localePrefId PageParameter must be given");
			}
			final String defaultLocalePrefId = Session.get().getLocale().toLanguageTag().equals("id-ID") ? SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID : SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_EN;
			final String localePrefId = info.getPageParameters().get(LOCALE_PREF_ID_PARAMETER).toString(defaultLocalePrefId);
			final String personSlug = info.getPageParameters().get(SLUG_PARAMETER).toString();
			if (personSlug != null) {
				final PageParameters copy = new PageParameters(info.getPageParameters());
				copy.remove(LOCALE_PREF_ID_PARAMETER);
				copy.remove(SLUG_PARAMETER);
				final Url url = new Url(ImmutableList.of(localePrefId, personSlug), Charsets.UTF_8);
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
