package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.FormalCategory;
import org.soluvas.category.FormalCategoryRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;

import com.google.common.collect.Iterables;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

/**
 * @author rudi
 *
 */
public class FormalCategoryChoiceProvider extends ChoiceProvider<FormalCategory> {
	
	private static final Logger log = LoggerFactory
			.getLogger(FormalCategoryChoiceProvider.class);
	
	@Inject
	private FormalCategoryRepository repo;
	
	public FormalCategoryChoiceProvider() {
		super();
		Injector.get().inject(this);
		
	}

	@Override
	public String getDisplayValue(FormalCategory choice) {
		return Iterables.getLast(choice.getGoogleBreadcrumbs());
	}

	@Override
	public String getIdValue(FormalCategory choice) {
		return Long.toString(choice.getGoogleId());
	}

	@Override
	public void query(String term, int page, Response<FormalCategory> response) {
		final Page<FormalCategory> result = repo.findAllBySearchText(term.trim(), new PageRequest(page, 10L, Direction.ASC, "googleId"));
		log.debug("Got {} row(s) by term '{}': {}", result.getSize(), term, Iterables.limit(result.getContent(), 5));
		response.addAll(result.getContent());
		response.setHasMore(result.hasNextPage());
	}

	@Override
	public Collection<FormalCategory> toChoices(Collection<String> ids) {
		return repo.findAll(ids.stream().map(id -> Long.valueOf(id)).collect(Collectors.toList()));
	}

}
