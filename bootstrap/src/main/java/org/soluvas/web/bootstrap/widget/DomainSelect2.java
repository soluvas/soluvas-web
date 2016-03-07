package org.soluvas.web.bootstrap.widget;

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
	
	public DomainSelect2(String id, IModel<DomainPermission2> model) {
		super(id, model);
		setProvider(new DomainChoiceProvider());;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Choose Formal Category"));
		getSettings().getAjax().setQuietMillis(250);
	}

}
