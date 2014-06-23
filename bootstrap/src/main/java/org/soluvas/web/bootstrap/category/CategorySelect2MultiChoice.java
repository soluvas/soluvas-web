/**
 * 
 */
package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.commons.IdFunction;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.image.ImageManager;
import org.soluvas.web.bootstrap.widget.InteractiveSelect2MultiChoice;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.TextChoiceProvider;

/**
 * @author atang
 *
 */
public class CategorySelect2MultiChoice extends
		InteractiveSelect2MultiChoice<Category> {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(CategorySelect2MultiChoice.class);
	@SpringBean
	private CategoryRepository categoryRepo;
	@SpringBean
	private ImageManager imageMgr;
	private IModel<List<Category>> sortedCategoriesModel;
	
	
	private final class CategoryChoiceProvider extends TextChoiceProvider<Category> {
		
		private static final long serialVersionUID = 1L;

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
					log.debug("id is {}. Sorted category has {} records", id, sortedCategoriesModel.getObject().size());
					try {
						return Iterables.find(sortedCategoriesModel.getObject(), new Predicate<Category>() {
							@SuppressWarnings("null") @Override
							public boolean apply(@Nullable Category cat) {
								log.debug("cat is {}", cat);
								return Objects.equal(cat.getId(), id);
							}
						}, null);
					} catch (Exception e) {
						log.warn("Invalid category ID '{}', {} valid categories are: {}",
								id, sortedCategoriesModel.getObject().size(), Lists.transform(sortedCategoriesModel.getObject(), new IdFunction()));
						return null;
					}
				}
			});
		}
		
	}
	
	private class LoadableCategoryModel extends LoadableDetachableModel<Category> {

		private static final long serialVersionUID = 1L;
		private String categoryUName;
		
		public LoadableCategoryModel(@Nullable Category currentCategory) {
			super();
			this.categoryUName = currentCategory != null ? currentCategory.getUName() : null;
		}

		@Override
		protected Category load() {
			return categoryUName != null ? categoryRepo.findOne(categoryUName) : null;
		}
		
		@Override
		public void detach() {
			categoryUName = getObject() != null ? getObject().getId() : null;
			super.detach();
		}
		
	}
	
	
	public CategorySelect2MultiChoice(String id,
			IModel<? extends Collection<Category>> currentCateogorymodel) {
		super(id, (IModel) currentCateogorymodel);
		sortedCategoriesModel = new LoadableDetachableModel<List<Category>>() {
			@Override
			protected List<Category> load() {
				final List<Category> categoryList = categoryRepo.findAll(new PageRequest(0, 500, Direction.ASC, "name")).getContent();
				log.debug("Categories has {} rows: {}", categoryList.size(), categoryList);
				final List<Category> filteredCategories = ImmutableList.copyOf(Iterables.filter(categoryList, new Predicate<Category>() {
					@Override
					public boolean apply(@Nullable Category input) {
						return input.getCategories().isEmpty();
					}
				}));
				log.debug("Filtered Categories by leaf has {} rows: {}", filteredCategories.size(), filteredCategories);
				final Ordering<Category> categoryOrderer = Ordering.from(new Comparator<Category>() {
					@Override
					public int compare(Category cat1, Category cat2) {
						return cat1.getSlugPath().compareToIgnoreCase(cat2.getSlugPath());
					}
				});
				return categoryOrderer.sortedCopy(filteredCategories);
			}
		};
		setProvider(new CategoryChoiceProvider());
	}
	
	public IModel<List<Category>> getSortedCategoriesModel() {
		return sortedCategoriesModel;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Category"));
		getSettings().getAjax().setQuietMillis(250);
	}
	
	
}
