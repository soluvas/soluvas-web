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
import org.soluvas.category.Category;
import org.soluvas.category.CategoryRepository;
import org.soluvas.commons.NotNullPredicate;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.web.bootstrap.widget.BootstrapSelect2Choice;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;

/**
 * {@link Category} {@link Select2Choice} that only displays top-level categories.
 * @author ceefour
 * @see CategorySelect2
 */
public class TopLevelCategorySelect2 extends BootstrapSelect2Choice<Category> {

	private static final long serialVersionUID = 1L;

	private class TopLevelCategoryChoiceProvider extends ChoiceProvider<Category> {

		@Override
		public String getDisplayValue(Category choice) {
			return choice.getName();
		}

		@Override
		public String getIdValue(Category choice) {
			return choice.getId();
		}

		@Override
		public void query(final String term, int page, Response<Category> response) {
			final Collection<Category> matching = ImmutableList.copyOf(Collections2.filter(sortedCategoriesModel.getObject(), input -> StringUtils.containsIgnoreCase(input.getName(), term.trim())));
			response.addAll(matching);
		}

		@Override
		public Collection<Category> toChoices(Collection<String> ids) {
			return ImmutableList.copyOf(Collections2.filter(Collections2.transform(ids, new Function<String, Category>() {
				@SuppressWarnings("null") @Override @Nullable
				public Category apply(@Nullable final String id) {
					return Iterables.find(sortedCategoriesModel.getObject(), new Predicate<Category>() {
						@Override
						public boolean apply(@Nullable Category input) {
							return input.getId().equalsIgnoreCase(id);
						}
					}, null);
				}
			}), new NotNullPredicate<>()));
		}
	}

//	@SpringBean
//	private CategoryCatalog categoryCatalog;
	@SpringBean
	private CategoryRepository categoryRepo;
	
	private IModel<List<Category>> sortedCategoriesModel;
	
	/**
	 * @param id
	 * @param model
	 */
	public TopLevelCategorySelect2(String id, IModel<Category> model) {
		super(id, model);
		sortedCategoriesModel = new LoadableDetachableModel<List<Category>>() {
			@Override
			protected List<Category> load() {
				final List<Category> unorderedCategories = categoryRepo.findAll(new PageRequest(0, 500, Direction.ASC, "name")).getContent();
//				final List<Category> unorderedCategories = CategoryUtils.flatten(ImmutableList.copyOf(EcoreUtil.copyAll(categoryCatalog.getCategories())));
				final Ordering<Category> orderer = Ordering.from(new Comparator<Category>() {
					@Override
					public int compare(Category o1, Category o2) {
						return o1.getName().compareToIgnoreCase(o2.getName());
					}
				});
				return orderer.immutableSortedCopy(unorderedCategories);
			}
		};
		setProvider(new TopLevelCategoryChoiceProvider());
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Category"));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		getSettings().getAjax().setDelay(250);
	}
	
	@Override
	protected void detachModel() {
		super.detachModel();
		sortedCategoriesModel.detach();
	}

}
