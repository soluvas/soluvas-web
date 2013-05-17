package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.Ini;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.soluvas.web.site.WicketMountPoint;

import com.google.common.base.Supplier;

/**
 * Login form Wicket style no Backbone.
 * @author ceefour
 * @deprecated use {@link DedicatedLoginPage}.
 */
@SuppressWarnings("serial")
@WicketMountPoint(mountPoint="login2")
@Deprecated
public class LoginPage extends BootstrapPage {

	private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
	private final LoginToken loginFormModel = new LoginToken();
	private transient final Supplier<Subject> subjectSupplier = new SecurityUtilsSubjectSupplier();
	private transient SecurityManager securityManager;
	
	@SpringBean(name="appManifest")
	private AppManifest appManifest;

	protected void initializeSecurityManager() {
		Ini ini = new Ini();
		ini.load(LoginPage.class.getResourceAsStream("default.realm.ini"));
		IniRealm defaultRealm = new IniRealm(ini);

		securityManager = new DefaultSecurityManager(defaultRealm);
		SecurityUtils.setSecurityManager(securityManager);
	}

	public LoginPage() {
		super();

		// initializeSecurityManager();
		
		add(new Label("appName", new PropertyModel<String>(appManifest, "title")));

		final Form<LoginToken> loginForm = new Form<LoginToken>("loginForm", new Model<LoginToken>(loginFormModel));
		add(loginForm);
		LoadableDetachableModel<Subject> currentUserModel = new LoadableDetachableModel<Subject>() {
			@Override
			protected Subject load() {
				return subjectSupplier.get();
			}
		};
		loginForm.add(new Label("currentUser", new PropertyModel<String>(
				currentUserModel, "principal")));
		loginForm.add(new TextField<String>("username", new PropertyModel<String>(loginFormModel , "username")));
		loginForm.add(new PasswordTextField("password", new PropertyModel<String>(loginFormModel , "password")));
		loginForm.add(new CheckBox("rememberMe", new PropertyModel<Boolean>(loginFormModel, "rememberMe")));
		loginForm.add(new AjaxButton("login") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				log.info("Processing {}", loginFormModel);
				target.add(feedbackPanel, loginForm);
				Subject currentUser = subjectSupplier.get();
				final UsernamePasswordToken token = new UsernamePasswordToken(
						loginFormModel.getUsername(), loginFormModel
								.getPassword().toCharArray());
				log.debug("Logging in using {}", token);
				try {
					currentUser.login(token);
					info(String.format("Current user is now %s",
							currentUser.getPrincipal()));
					log.debug("Current user is now {}",
							currentUser.getPrincipal());
					log.info("Permitted to edit person? {}",
							currentUser.isPermitted("person:edit:*"));
				} catch (AuthenticationException e) {
					error(String.format("Invalid credentials for %s",
							token.getUsername()));
					log.debug(String.format("Invalid credentials for %s",
									token.getUsername()), e);
				}
				super.onSubmit(target, form);
			}
			
			@Override
			protected void onError(AjaxRequestTarget target, Form<?> form) {
				target.add(feedbackPanel);
				super.onError(target, form);
			}
		});
	}
}
