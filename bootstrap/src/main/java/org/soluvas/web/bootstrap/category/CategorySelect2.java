package org.soluvas.web.bootstrap.category;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import org.wicketstuff.select2.Select2Choice;
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
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.image.ImageManager;
import org.soluvas.web.bootstrap.widget.InteractiveSelect2Choice;

import javax.annotation.Nullable;
import java.util.Comparator;
import java.util.List;

/**
 * Displays a {@link Category} {@link Select2Choice} that only allows a leaf category
 * to be selected.
 *
 * @author ceefour
 * @see TopLevelCategorySelect2
 */
@SuppressWarnings("serial")
public class CategorySelect2 extends InteractiveSelect2Choice<Category> {

    private static final Logger log = LoggerFactory
            .getLogger(CategorySelect2.class);
    @SpringBean
    private CategoryRepository categoryRepo;
    @SpringBean
    private ImageManager imageMgr;
    private IModel<List<Category>> sortedCategoriesModel;

    private class LoadableCategoryModel extends LoadableDetachableModel<Category> {

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

    /**
     * @param id
     * @param model
     */
    public CategorySelect2(String id, @Nullable Category currentCategory) {
        super(id);
        setModel(new LoadableCategoryModel(currentCategory));
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
        setProvider(new CategoryChoiceProvider(sortedCategoriesModel));
    }

    /**
     * @param id
     * @param model
     */
    public CategorySelect2(String id, IModel<Category> model) {
        super(id, model);
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
        setProvider(new CategoryChoiceProvider(sortedCategoriesModel));
    }


    public void setCurrentCategory(@Nullable Category currentCategory) {
        setModel(new LoadableCategoryModel(currentCategory));
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
        add(new AttributeModifier("placeholder", "Choose Category"));
        getSettings().getAjax().setDelay(250);
    }

    @Override
    protected void detachModel() {
        super.detachModel();
        sortedCategoriesModel.detach();
    }

    public IModel<List<Category>> getSortedCategoriesModel() {
        return sortedCategoriesModel;
    }

}
