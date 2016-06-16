package org.soluvas.web.bootstrap.category;

import java.util.Collection;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.web.bootstrap.widget.BootstrapSelect2MultiChoice;

import com.google.common.collect.ImmutableList;

/**
 * @author rudi
 *
 */
public class PropertyDefinitionSelect2MultiChoice extends BootstrapSelect2MultiChoice<PropertyDefinition> {

	private static final long serialVersionUID = 1L;
	
	public PropertyDefinitionSelect2MultiChoice(final String id, final IModel<Collection<PropertyDefinition>> model) {
		super(id, model);
		setProvider(new PropertyDefinitionChoiceProvider(model, new ListModel<>(ImmutableList.of()), new ListModel<>(ImmutableList.of()), new Model<>(true)));
	}
	
	public PropertyDefinitionSelect2MultiChoice(final String id, final IModel<Collection<PropertyDefinition>> model,
			final IModel<List<PropertyDefinition>> excludedsModel) {
		super(id, model);
		setProvider(new PropertyDefinitionChoiceProvider(model, excludedsModel, new ListModel<>(ImmutableList.of()), new Model<>(true)));
	}
	
	public PropertyDefinitionSelect2MultiChoice(final String id, final IModel<Collection<PropertyDefinition>> model,
			final IModel<List<PropertyDefinition>> excludedsModel, final IModel<List<PropertyDefinition>> dataListModel, IModel<Boolean> fromRepoModel) {
		super(id, model);
		setProvider(new PropertyDefinitionChoiceProvider(model, excludedsModel, dataListModel, fromRepoModel));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Property Definition"));
		getSettings().getAjax().setDelay(250);
	}
	
}
