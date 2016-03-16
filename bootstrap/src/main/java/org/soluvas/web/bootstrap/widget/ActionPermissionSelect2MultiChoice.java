package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.security.ActionPermission;
import org.soluvas.security.DomainPermission2;

/**
 * @author anisa
 *
 */
public class ActionPermissionSelect2MultiChoice extends InteractiveSelect2MultiChoice<ActionPermission> {

	private static final long serialVersionUID = 1L;
	
	public ActionPermissionSelect2MultiChoice(String id,final IModel<Collection<ActionPermission>> model, final IModel<DomainPermission2> domainPermissionModel) {
		super(id, model);
		setProvider(new ActionPermissionChoiceProvider(domainPermissionModel));
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		add(new AttributeModifier("placeholder", "Select Action"));
		getSettings().getAjax().setQuietMillis(250);
	}

}
