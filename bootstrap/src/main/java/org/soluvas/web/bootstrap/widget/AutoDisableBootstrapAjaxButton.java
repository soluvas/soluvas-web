package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.soluvas.web.site.widget.AutoDisableAjaxCallListener;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons.Type;

/**
 * {@link BootstrapAjaxButton} that auto-disables during AJAX request.
 * @author rudi
 */
public class AutoDisableBootstrapAjaxButton extends BootstrapAjaxButton {
	
	private static final long serialVersionUID = 1L;

	public AutoDisableBootstrapAjaxButton(String id, Form<?> form, Type type) {
		super(id, form, type);
	}

	public AutoDisableBootstrapAjaxButton(String id, IModel<String> model,
			Form<?> form, Type type) {
		super(id, model, form, type);
	}

	public AutoDisableBootstrapAjaxButton(String componentId,
			IModel<String> model, Type type) {
		super(componentId, model, type);
	}

	public AutoDisableBootstrapAjaxButton(String componentId, Type type) {
		super(componentId, type);
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);
		attributes.setChannel(new AjaxChannel("0", AjaxChannel.Type.ACTIVE));
		attributes.getAjaxCallListeners().add(new AutoDisableAjaxCallListener());
	}

}
