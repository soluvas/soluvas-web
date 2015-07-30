package org.soluvas.web.bootstrap.category;

import java.util.Collection;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.web.bootstrap.widget.InteractiveSelect2MultiChoice;

/**
 * @author rudi
 *
 */
public class PropertyDefinitionSelect2MultiChoice extends InteractiveSelect2MultiChoice<PropertyDefinition> {

	private static final long serialVersionUID = 1L;
	
	public PropertyDefinitionSelect2MultiChoice(String id, IModel<Collection<PropertyDefinition>> model) {
		super(id, model);
		setProvider(new PropertyDefinitionChoiceProvider());;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Formal Category"));
		getSettings().getAjax().setQuietMillis(250);
	}

}
