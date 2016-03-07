package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.security.DomainPermission2;
import org.soluvas.security.DomainPermissionRepository;

import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.TextChoiceProvider;

/**
 * @author rudi
 *
 */
public class DomainChoiceProvider extends TextChoiceProvider<DomainPermission2> {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(DomainChoiceProvider.class);
	
	@Inject
	private DomainPermissionRepository repo;
	
	public DomainChoiceProvider() {
		super();
		Injector.get().inject(this);
	}

	@Override
	protected String getDisplayText(DomainPermission2 choice) {
		return choice.getDescription();
	}

	@Override
	protected Object getId(DomainPermission2 choice) {
		return choice.getId();
	}

	@Override
	public void query(String term, int page, Response<DomainPermission2> response) {
		final Page<DomainPermission2> result = repo. findAllBySearchText(term.trim(), new PageRequest(page, 5L, Direction.ASC, "id"));
		log.debug("Got {} row(s) for query '{}'", result.getContent().size(), term);
		response.addAll(result.getContent());
		response.setHasMore(result.hasNextPage());
	}

	@Override
	public Collection<DomainPermission2> toChoices(Collection<String> ids) {
		return repo.findAll(ids);
	}

}
