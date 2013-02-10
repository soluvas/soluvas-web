package org.soluvas.web.login;

import javax.annotation.Nonnull;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

@SuppressWarnings("serial")
public class LdapLoginButton extends IndicatingAjaxButton {
	private static final Logger log = LoggerFactory
			.getLogger(LdapLoginButton.class);
	private final IModel<LoginFormModel> loginFormModel;

	public LdapLoginButton(String id,
			@Nonnull final IModel<LoginFormModel> loginFormModel) {
		super(id);
		this.loginFormModel = loginFormModel;
	}

	@Override
	protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
		final LoginFormModel loginData = loginFormModel.getObject();
		final String upUsername = Strings.nullToEmpty(loginData.getUsername());
		final String upPassword = Strings.nullToEmpty(loginData.getPassword());
		final UsernamePasswordToken token = new UsernamePasswordToken(
				upUsername, upPassword.toCharArray());
		log.debug("Logging in using {}", upUsername);
		try {
			final Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			final String personId = Preconditions.checkNotNull((String) currentUser.getPrincipal(),
					"Cannot get current user as person ID");
			info(String.format("Your are now logged in as %s", personId));
			log.debug("Current user is now {}", personId);
			log.debug("{} permitted to edit person? {}",
					personId, currentUser.isPermitted("person:edit:*"));
			onLoginSuccess(target, personId);
		} catch (final AuthenticationException e) {
			error(String.format("Invalid credentials for %s",
					token.getUsername()));
			log.debug(
					String.format("Invalid credentials for %s",
							token.getUsername()), e);
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

	@Override
	protected void onError(AjaxRequestTarget target, Form<?> form) {
		super.onError(target, form);
	}

}
