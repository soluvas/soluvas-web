package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.data.PropertyDefinitionRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageImpl;
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

	private final IModel<List<PropertyDefinition>> excludedsModel;
	private final IModel<List<PropertyDefinition>> dataPropDefListModel;

	private final IModel<Collection<PropertyDefinition>> model;
	
	public PropertyDefinitionChoiceProvider(final IModel<Collection<PropertyDefinition>> model, final IModel<List<PropertyDefinition>> excludedsModel,
			final IModel<List<PropertyDefinition>> dataPropDefListModel) {
		super();
		Injector.get().inject(this);
		this.model = model;
		this.excludedsModel = excludedsModel;
		this.dataPropDefListModel = dataPropDefListModel;
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
		final Page<PropertyDefinition> result;
		if (dataPropDefListModel.getObject() != null && !dataPropDefListModel.getObject().isEmpty()) {
//			log.debug("dataPropDefList has {} rows", dataPropDefListModel.getObject().size());
			final List<PropertyDefinition> filteredPropDefList = dataPropDefListModel.getObject().stream().filter(new Predicate<PropertyDefinition>() {
				@Override
				public boolean test(PropertyDefinition t) {
					return t.getName().startsWith(term.trim());
				}
			}).collect(Collectors.toList());
			result = new PageImpl<>(filteredPropDefList, new PageRequest(page, 10L, Direction.ASC, "name"), filteredPropDefList.size() - model.getObject().size());
		} else {
			final List<String> excludedPropertyDefIds = excludedsModel.getObject().stream().
					map(it -> it.getId()).collect(Collectors.toList());
			result = repo.findAllBaseBySearchText(term.trim(),
					ImmutableSet.copyOf(excludedPropertyDefIds),
					new PageRequest(page, 10L, Direction.ASC, "name"));
		}
//		log.debug("by page {} and result.getContent(): {}", page, result.getContent().size());
		response.addAll(result.getContent());
		response.setHasMore(result.hasNextPage());
	}

	@Override
	public Collection<PropertyDefinition> toChoices(Collection<String> ids) {
		if (dataPropDefListModel.getObject() != null && !dataPropDefListModel.getObject().isEmpty()) {
			return dataPropDefListModel.getObject().stream().filter(new Predicate<PropertyDefinition>() {
				@Override
				public boolean test(PropertyDefinition t) {
					return ids.contains(t.getId());
				}
			}).collect(Collectors.toList());
		} else {
			return repo.findAllBase(ids);
		}
	}
	
}
