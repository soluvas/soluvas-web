package org.soluvas.web.bootstrap.category;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.web.bootstrap.widget.BootstrapSelect2Choice;

import com.google.common.collect.ImmutableList;

/**
 * @author eki
 *
 */
@SuppressWarnings("serial")
public class PropertyDefinitionSelect2Choice extends BootstrapSelect2Choice<PropertyDefinition> {

	public PropertyDefinitionSelect2Choice(String id, IModel<PropertyDefinition> model) {
		super(id, model);
		setProvider(new PropertyDefinitionChoiceProvider(
				new ListModel(ImmutableList.of()), new ListModel(ImmutableList.of()), new ListModel(ImmutableList.of()), new Model<>(true)));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Property Definition"));
		getSettings().getAjax().setDelay(250);
		getSettings().setCloseOnSelect(true);
	}

}
