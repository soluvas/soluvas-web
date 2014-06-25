package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.commons.IdFunction;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.TextChoiceProvider;

@SuppressWarnings("serial")
class CategoryChoiceProvider extends TextChoiceProvider<Category> {
		
	@Inject
	private CategoryRepository categoryRepo;
	private final IModel<List<Category>> sortedCategoriesModel;
	
	public CategoryChoiceProvider(IModel<List<Category>> sortedCategoriesModel) {
		super();
		Injector.get().inject(this);
		this.sortedCategoriesModel = sortedCategoriesModel;
	}
	
	@Override
	protected String getDisplayText(Category choice) {
//			log.debug("Choice {} has {} - parentUname", choice.getUName(), choice.getParentUName());
		final String displayTxt = getParentPrefix(choice) + choice.getName();
//			log.debug("Display Text: {}", displayTxt);
		return displayTxt;
	}
	
	@SuppressWarnings("null")
	protected String getParentPrefix(Category child) {
//			if (child.getParent() != null) {
		if (!Strings.isNullOrEmpty(child.getParentUName())) {
			final Category parent = categoryRepo.findOne(child.getParentUName());
			if (parent != null) {
				CategorySelect2MultiChoice.log.debug("Parent of {} is {}", child.getUName(), parent.getUName());
				return getParentPrefix(parent) + "" + parent.getName() + " > ";
			}
			return "";
		} else {
			return "";
		}
	}

	@Override
	protected Object getId(Category choice) {
		return choice.getId();
	}

	@Override
	public void query(final String term, int page, Response<Category> response) {
		final Collection<Category> catList = Collections2.filter(sortedCategoriesModel.getObject(), new Predicate<Category>(){
			@Override
			public boolean apply(@Nullable Category input) {
				return StringUtils.containsIgnoreCase(input.getName(), term.trim());
			}
		});
		response.addAll(catList);
	}

	@Override
	public Collection<Category> toChoices(Collection<String> ids) {
		return Collections2.transform(ids, new Function<String, Category>() {
			@Override @Nullable
			public Category apply(@Nullable final String id) {
				CategorySelect2MultiChoice.log.debug("id is {}. Sorted category has {} records", id, sortedCategoriesModel.getObject().size());
				try {
					return Iterables.find(sortedCategoriesModel.getObject(), new Predicate<Category>() {
						@SuppressWarnings("null") @Override
						public boolean apply(@Nullable Category cat) {
							CategorySelect2MultiChoice.log.debug("cat is {}", cat);
							return Objects.equal(cat.getId(), id);
						}
					}, null);
				} catch (Exception e) {
					CategorySelect2MultiChoice.log.warn("Invalid category ID '{}', {} valid categories are: {}",
							id, sortedCategoriesModel.getObject().size(), Lists.transform(sortedCategoriesModel.getObject(), new IdFunction()));
					return null;
				}
			}
		});
	}
	
}