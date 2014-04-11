package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Generic {@link IndicatingAjaxButton} that can be used with any Shiro {@link Realm},
 * provided it accepts {@link UsernamePasswordToken}.
 * It's for stateful login form, if you want stateless use {@link StatelessLoginForm}.
 * You need to override {@link #onLoginSuccess(AjaxRequestTarget, String)}.
 * @author ceefour
 * @see StatelessLoginForm
 */
public class LoginButton extends IndicatingAjaxButton {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(LoginButton.class);
	private final IModel<LoginToken> loginTokenModel;
	
	@SpringBean
	private TenantRef tenant;

	public LoginButton(String id, final IModel<LoginToken> loginTokenModel) {
		super(id);
		this.loginTokenModel = loginTokenModel;
	}

	@Override
	protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
		final LoginToken loginData = loginTokenModel.getObject();
		final String upUsername = Strings.nullToEmpty(loginData.getUsername());
		final String upPassword = Strings.nullToEmpty(loginData.getPassword());
		final UsernamePasswordToken token = new UsernamePasswordToken(
				upUsername, upPassword.toCharArray(), tenant.getTenantId());
		log.debug("Logging in using '{}' tenant '{}'", upUsername, tenant.getTenantId());
		try {
			final Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			final String personId = Preconditions.checkNotNull((String) currentUser.getPrincipal(),
					"Cannot get current user as person ID");
			info(String.format("You are now logged in as %s", personId));
			log.debug("Current user is now '{}' tenant '{}'. Has permission to edit all person data? {}",
					personId, tenant.getTenantId(), currentUser.isPermitted("person:edit:*"));
			onLoginSuccess(target, personId);
		} catch (final AuthenticationException e) {
//			error(String.format("Invalid credentials for %s", token.getUsername()));
			error(String.format("Wrong Username/Email and password combination."));
			log.info(String.format("Invalid credentials for '%s' tenant '%s'", token.getUsername(), token.getHost()), e);
		}
		super.onSubmit(target, form);
	}

	/**
	 * Override this method to, for example, redirect to original page
	 * (if using {@link DedicatedLoginPage}).
	 * @param target TODO
	 * @param personId
	 */
	protected void onLoginSuccess(AjaxRequestTarget target, String personId) {
	}

}
