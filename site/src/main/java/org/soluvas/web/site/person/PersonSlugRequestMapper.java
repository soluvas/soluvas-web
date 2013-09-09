package org.soluvas.web.site.person;

import java.util.regex.Pattern;

import org.apache.wicket.Page;
import org.apache.wicket.core.request.mapper.AbstractBookmarkableMapper;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.Person;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;

/**
 * Match request to a {@code PersonShowPage} {@link Page}, with {@code personSlug} parameter
 * based on {@link Person#getSlug()}, using {@link PersonRepository}.
 * <p>Usage:
 * <pre>{@literal
 * mount(new PersonSlugRequestMapper(PersonShowPage.class));
 * }</pre>
 * @author ceefour
 */
public class PersonSlugRequestMapper extends AbstractBookmarkableMapper {

	@SpringBean
	private PersonRepository personRepo;
	private final Class<? extends Page> personShowPage;
	private static final Pattern SLUG_PATTERN = Pattern.compile("[a-z0-9][a-z0-9\\.-]+");
	
	public PersonSlugRequestMapper(Class<? extends Page> personShowPage) {
		super();
		this.personShowPage = personShowPage;
		Injector.get().inject(this);
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
		if (request.getUrl().getSegments().size() == 1) {
			final String segment1 = request.getUrl().getSegments().get(0);
			if (SLUG_PATTERN.matcher(segment1).matches()) {
				// RAW because it is assumed that the PersonShowPage will then throw appropriate EntityLookupException
				if (personRepo.existsBySlug(StatusMask.RAW, segment1) != null) {
					return new UrlInfo(null, personShowPage, 
							new PageParameters().set("personSlug", segment1));
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
			final String personSlug = info.getPageParameters().get("personSlug").toString();
			if (personSlug != null) {
				return new Url(ImmutableList.of(personSlug), 
					Charsets.UTF_8);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	protected boolean pageMustHaveBeenCreatedBookmarkable() {
		return false;
	}

}
