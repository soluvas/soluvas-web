package org.soluvas.web.site;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

/**
 * Sets {@link Component#setVisible(boolean)} to visible only if
 * model object is not {@code null} and not empty string. 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ModelVisibilityBehavior extends Behavior {
	
	@Override
	public void onConfigure(Component component) {
		super.onConfigure(component);
		component.setVisible( component.getDefaultModelObject() != null && !"".equals(component.getDefaultModelObject()) );
	}

}
