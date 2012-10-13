package org.soluvas.web.login;

import org.apache.wicket.model.IModel;
import org.soluvas.web.site.HandlebarsRenderer;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class LoginForm extends HandlebarsRenderer {

	public LoginForm(String id, IModel<LoginFormModel> model) {
		super(id, model, LoginForm.class, "form", "form-horizontal");
	}

}
