package org.soluvas.web.bootstrap.widget;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.security.DomainPermission2;

/**
 * @author rudi
 *
 */
public class DomainSelect2 extends InteractiveSelect2Choice<DomainPermission2> {

	private static final long serialVersionUID = 1L;
	
	public DomainSelect2(final String id, final IModel<DomainPermission2> model,
			final IModel<List<String>> excludedDomainIdsModel) {
		super(id, model);
		setProvider(new DomainChoiceProvider(excludedDomainIdsModel));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Select Domain"));
		getSettings().getAjax().setQuietMillis(250);
	}

}
