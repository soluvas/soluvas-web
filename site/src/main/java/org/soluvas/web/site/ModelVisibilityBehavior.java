package org.soluvas.web.site;

import javax.annotation.Nullable;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;

/**
 * Sets {@link Component#setVisible(boolean)} to visible only if
 * model object is not {@code null} and not empty string. 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ModelVisibilityBehavior extends Behavior {
	
	@Nullable
	private IModel<?> model;
	
	public ModelVisibilityBehavior() {
		super();
	}
	
	public ModelVisibilityBehavior(IModel<?> model) {
		super();
		this.model = model;
	}
	
	@Override
	public void onConfigure(Component component) {
		super.onConfigure(component);
		if (model != null) {
			component.setVisible( model != null && model.getObject() != null && !"".equals(model.getObject()) );
		} else {
			component.setVisible( component.getDefaultModelObject() != null && !"".equals(component.getDefaultModelObject()) );
		}
	}

}
