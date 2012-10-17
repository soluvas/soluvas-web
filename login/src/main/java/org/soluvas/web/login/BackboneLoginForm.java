package org.soluvas.web.login;

import org.apache.wicket.model.IModel;
import org.soluvas.web.site.HandlebarsRenderer;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BackboneLoginForm extends HandlebarsRenderer {

	public BackboneLoginForm(String id, IModel<LoginFormModel> model) {
		super(id, model, BackboneLoginForm.class, "form", "form-horizontal");
	}

}
