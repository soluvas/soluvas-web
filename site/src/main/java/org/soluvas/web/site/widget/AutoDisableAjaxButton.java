package org.soluvas.web.site.widget;

import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

/**
 * {@link IndicatingAjaxButton} which auto-disables during AJAX request.
 * @author rudi
 */
public class AutoDisableAjaxButton extends IndicatingAjaxButton {
	
	private static final long serialVersionUID = 1L;

	public AutoDisableAjaxButton(String id, Form<?> form) {
		super(id, form);
	}

	public AutoDisableAjaxButton(String id, IModel<String> model, Form<?> form) {
		super(id, model, form);
	}

	public AutoDisableAjaxButton(String id, IModel<String> model) {
		super(id, model);
	}

	public AutoDisableAjaxButton(String id) {
		super(id);
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);
		attributes.setChannel(new AjaxChannel("autodisable", AjaxChannel.Type.ACTIVE));
		attributes.getAjaxCallListeners().add(new AutoDisableAjaxCallListener());
	}
	
	
	
}
