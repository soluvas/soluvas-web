package org.soluvas.web.bootstrap.category;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.category.FormalCategory;
import org.soluvas.web.bootstrap.widget.BootstrapSelect2Choice;

/**
 * @author rudi
 *
 */
public class FormalCategorySelect2 extends BootstrapSelect2Choice<FormalCategory> {

	private static final long serialVersionUID = 1L;
	
	public FormalCategorySelect2(String id, IModel<FormalCategory> model) {
		super(id, model);
		setProvider(new FormalCategoryChoiceProvider());;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Formal Category"));
		getSettings().getAjax().setDelay(250);
		getSettings().setCloseOnSelect(true);
	}

}
