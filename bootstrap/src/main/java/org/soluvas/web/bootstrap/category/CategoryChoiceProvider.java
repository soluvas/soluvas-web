package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.commons.NotNullPredicate;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.TextChoiceProvider;

@SuppressWarnings("serial")
class CategoryChoiceProvider extends TextChoiceProvider<Category> {
	
	private static final Logger log = LoggerFactory
			.getLogger(CategoryChoiceProvider.class);
		
	@Inject
	private CategoryRepository categoryRepo;
	private final IModel<List<Category>> sortedCategoriesModel;
	
	public CategoryChoiceProvider(IModel<List<Category>> sortedActiveCategoriesModel) {
		super();
		Injector.get().inject(this);
		this.sortedCategoriesModel = sortedActiveCategoriesModel;
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
				log.debug("Parent of {} is {}", child.getUName(), parent.getUName());
				return getParentPrefix(parent) + "" + parent.getName() + " > ";
			}
			return "";
		} else {
			return "";
		}
	}

	@Override
	protected Object getId(Category choice) {
		return choice.getUName();
	}

	@Override
	public void query(final String term, int page, Response<Category> response) {
		final Collection<Category> catList = Collections2.filter(sortedCategoriesModel.getObject(), new Predicate<Category>() {
			@Override
			public boolean apply(@Nullable Category input) {
				return StringUtils.containsIgnoreCase(input.getName(), term.trim());
			}
		});
		response.addAll(catList);
	}

	@Override
	public Collection<Category> toChoices(Collection<String> ids) {
		return FluentIterable.from(ids).transform(new Function<String, Category>() {
			@Override @Nullable
			public Category apply(@Nullable final String uName) {
				log.trace("Category UName is {}. Sorted category has {} records", uName, sortedCategoriesModel.getObject().size());
				@Nullable
				Category found = categoryRepo.findOne(uName);
				if (found == null) {
					log.warn("Invalid category UName '{}', {} valid category UNames are: {}",
							uName, sortedCategoriesModel.getObject().size(), 
							Lists.transform(sortedCategoriesModel.getObject(), new Function<Category, String>() {
								@Override
								public String apply(Category input) {
									return input.getUName();
								}
							}));
				}
				return found;
			}
		})
		.filter(new NotNullPredicate<>())
		.toList();
	}
	
}