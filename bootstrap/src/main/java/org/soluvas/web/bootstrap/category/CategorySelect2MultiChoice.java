/**
 * 
 */
package org.soluvas.web.bootstrap.category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nullable;

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
import org.soluvas.category.CategoryStatus;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.image.ImageManager;
import org.soluvas.web.bootstrap.widget.InteractiveSelect2MultiChoice;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * @author atang
 *
 */
@SuppressWarnings("serial")
public class CategorySelect2MultiChoice extends
		InteractiveSelect2MultiChoice<Category> {
	
	static final Logger log = LoggerFactory
			.getLogger(CategorySelect2MultiChoice.class);
	@SpringBean
	private CategoryRepository categoryRepo;
	@SpringBean
	private ImageManager imageMgr;
	private LoadableDetachableModel<List<Category>> sortedCategoriesModel;
//	private final IModel<List<Category>> selectedCategoryModel;
	
	private class LoadableCategoriesModel extends LoadableDetachableModel<Collection<Category>> {

		private final ArrayList<String> categoryUNames = new ArrayList<>();
		
		public LoadableCategoriesModel(@Nullable Collection<Category> currentCategories) {
			super();
			for (final Category category : currentCategories) {
				categoryUNames.add(category.getUName());
			}
		}

		@Override
		protected List<Category> load() {
			return new ArrayList<>( categoryRepo.findAll(categoryUNames) );
		}
		
		@Override
		public void detach() {
			categoryUNames.clear();
			if (getObject() != null) {
				for (Category category : getObject()) {
					categoryUNames.add(category.getUName());
				}
				super.detach();
			}
		}
		
	}

	public CategorySelect2MultiChoice(String id, Collection<Category> currentCategories) {
		super(id);
		setModel(new LoadableCategoriesModel(currentCategories));
		sortedCategoriesModel = new LoadableDetachableModel<List<Category>>() {
			@Override
			protected List<Category> load() {
				final List<Category> categoryList = categoryRepo.findAllByStatus(ImmutableList.of(CategoryStatus.ACTIVE), new PageRequest(0, 500, Direction.ASC, "name")).getContent();
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
//		log.debug("sortedCategoriesModel has {} rows ", sortedCategoriesModel.getObject().size());
		setProvider(new CategoryChoiceProvider(sortedCategoriesModel));
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
	
	@Override
	protected void detachModel() {
//		getModel().detach();
//		super.detachModel();
		sortedCategoriesModel.detach();
	}
	
}
