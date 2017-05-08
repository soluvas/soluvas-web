package org.soluvas.web.bootstrap.category;

import java.util.Collection;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category2;
import org.soluvas.web.bootstrap.widget.BootstrapSelect2MultiChoice;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class Category2Select2MultiChoice extends
		BootstrapSelect2MultiChoice<Category2> {
	
	static final Logger log = LoggerFactory
			.getLogger(Category2Select2MultiChoice.class);
	
	public Category2Select2MultiChoice(String id, IModel<Collection<Category2>> model) {
		super(id, model);
		setProvider(new Category2ChoiceProvider(null));
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
