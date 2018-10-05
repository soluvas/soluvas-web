package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryStatus;
import org.soluvas.web.bootstrap.widget.BootstrapSelect2MultiChoice;

import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class CategorySelect2MultiChoice extends
		BootstrapSelect2MultiChoice<Category2> {
	
	static final Logger log = LoggerFactory
			.getLogger(CategorySelect2MultiChoice.class);
	
	public CategorySelect2MultiChoice(String id, IModel<Collection<Category2>> model) {
		super(id, model);
		setProvider(new CategoryChoiceProvider(new ListModel<>(ImmutableList.of(CategoryStatus.ACTIVE))));
	}
	
	public CategorySelect2MultiChoice(String id, IModel<Collection<Category2>> model,
			final IModel<List<CategoryStatus>> statusesModel) {
		super(id, model);
		setProvider(new CategoryChoiceProvider(statusesModel));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Category"));
		getSettings().getAjax().setDelay(250);
	}
	
	@Override
	protected void onDetach() {
		super.onDetach();
	}
	
}
