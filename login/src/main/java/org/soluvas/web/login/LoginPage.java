package org.soluvas.web.login;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.bootstrap.BootstrapPage;

/**
 * Login form Wicket style no Backbone.
 * @author ceefour
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="login")
public class LoginPage extends BootstrapPage {

	private transient Logger log = LoggerFactory.getLogger(LoginPage.class);
	private LoginFormModel loginFormModel = new LoginFormModel();

	public LoginPage() {
		super();
		final Form<LoginFormModel> loginForm = new Form<LoginFormModel>("loginForm", new Model<LoginFormModel>(loginFormModel));
		add(loginForm);
		loginForm.add(new TextField<String>("username", new PropertyModel<String>(loginFormModel , "username")));
		loginForm.add(new PasswordTextField("password", new PropertyModel<String>(loginFormModel , "password")));
		loginForm.add(new CheckBox("rememberMe", new PropertyModel<Boolean>(loginFormModel, "rememberMe")));
		loginForm.add(new AjaxButton("login") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				log.info("Processing {}", loginFormModel);
				target.add(LoginPage.this);
			}
		});
	}
}
