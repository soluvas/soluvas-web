package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.data.PropertyDefinitionRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;

import com.google.common.collect.ImmutableSet;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.TextChoiceProvider;

/**
 * @author rudi
 *
 */
public class PropertyDefinitionChoiceProvider extends TextChoiceProvider<PropertyDefinition> {
	
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(PropertyDefinitionChoiceProvider.class);
	
	@Inject
	private PropertyDefinitionRepository repo;

	private final IModel<List<String>> excludedIdsModel;
	
	public PropertyDefinitionChoiceProvider(IModel<List<String>> excludedIdsModel) {
		super();
		Injector.get().inject(this);
		this.excludedIdsModel = excludedIdsModel;
	}

	@Override
	protected String getDisplayText(PropertyDefinition choice) {
		return choice.getName();
	}

	@Override
	protected Object getId(PropertyDefinition choice) {
		return choice.getId();
	}

	@Override
	public void query(String term, int page, Response<PropertyDefinition> response) {
		final Page<PropertyDefinition> result = repo.findAllBaseBySearchText(term.trim(),
				ImmutableSet.copyOf(this.excludedIdsModel.getObject()),
				new PageRequest(page, 10L, Direction.ASC, "name"));
		response.addAll(result.getContent());
		response.setHasMore(result.hasNextPage());
	}

	@Override
	public Collection<PropertyDefinition> toChoices(Collection<String> ids) {
		return repo.findAllBase(ids);
	}
	
}
