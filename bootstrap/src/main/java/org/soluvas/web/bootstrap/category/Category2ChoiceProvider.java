package org.soluvas.web.bootstrap.category;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

@SuppressWarnings("serial")
public class Category2ChoiceProvider extends ChoiceProvider<Category2> {
	
	private static final Logger log = LoggerFactory
			.getLogger(Category2ChoiceProvider.class);
		
	@Inject
	private MongoCategoryRepository categoryRepo;
	
	public Category2ChoiceProvider() {
		super();
		Injector.get().inject(this);
	}

	@Override
	public String getDisplayValue(Category2 choice) {
		final String displayTxt = getParentPrefix(choice) + choice.getName();
		return displayTxt;
	}

	protected String getParentPrefix(Category2 child) {
		if (!Strings.isNullOrEmpty(child.getParentId())) {
			final Category2 parent = categoryRepo.findOne(child.getParentId());
			if (parent != null) {
				return getParentPrefix(parent) + "" + parent.getName() + " > ";
			}
			return "";
		} else {
			return "";
		}
	}

	@Override
	public String getIdValue(Category2 choice) {
		return choice.getId();
	}

	@Override
	public void query(final String term, int page, Response<Category2> response) {
		final PageRequest pageable = new PageRequest(page, 10L, Direction.ASC, "localSku");
		final Page<Category2> result = categoryRepo.findAll(Optional.fromNullable(term).or("").trim(), ImmutableList.of(CategoryStatus.ACTIVE), pageable);
		response.addAll(result.getContent());
		response.setHasMore(result.hasNextPage());
	}

	@Override
	public Collection<Category2> toChoices(Collection<String> ids) {
		return categoryRepo.findAll(ids);
	}
	
}