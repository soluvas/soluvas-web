package org.soluvas.web.bootstrap.category;

import javax.annotation.Nullable;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category2;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.image.ImageManager;
import org.soluvas.web.bootstrap.widget.InteractiveSelect2Choice;

/**
 * @author atang
 */
@SuppressWarnings("serial")
public class Category2Select2 extends InteractiveSelect2Choice<Category2> {

	private static final Logger log = LoggerFactory
			.getLogger(Category2Select2.class);
	@SpringBean
	private MongoCategoryRepository categoryRepo;
	@SpringBean
	private ImageManager imageMgr;
//	private IModel<List<Category2>> sortedCategoriesModel;
	
	private class LoadableCategoryModel extends LoadableDetachableModel<Category2> {

		private String categoryName;
		
		public LoadableCategoryModel(@Nullable Category2 currentCategory) {
			super();
			this.categoryName = currentCategory != null ? currentCategory.getName() : null;
		}

		@Override
		protected Category2 load() {
			return categoryName != null ? categoryRepo.findOne(categoryName) : null;
		}
		
		@Override
		public void detach() {
			categoryName = getObject() != null ? getObject().getId() : null;
			super.detach();
		}
		
	}

	/**
	 * @param id
	 * @param model
	 */
	public Category2Select2(String id, @Nullable Category2 currentCategory) {
		super(id);
		setModel(new LoadableCategoryModel(currentCategory));
		setProvider(new Category2ChoiceProvider());
	}
	/**
	 * @param id
	 * @param model
	 */
	public Category2Select2(String id, IModel<Category2> model) {
		super(id, model);
		setProvider(new Category2ChoiceProvider());
	}
	
	
	public void setCurrentCategory(@Nullable Category2 currentCategory) {
		setModel(new LoadableCategoryModel(currentCategory));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Category2"));
		getSettings().getAjax().setDelay(250);
	}

}
