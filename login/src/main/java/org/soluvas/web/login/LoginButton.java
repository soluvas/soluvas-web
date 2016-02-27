package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.ajax.AjaxChannel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.security.impl.StaticAppRealm;
import org.soluvas.web.site.Interaction;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.soluvas.web.site.SoluvasWebSession;

import javax.annotation.Nullable;

/**
 * Generic {@link IndicatingAjaxButton} that can be used with any Spring Security {@link Realm},
 * provided it accepts {@link UsernamePasswordToken}.
 *
 * <p>You need to override {@link #onLoginSuccess(AjaxRequestTarget, String)}.</p>
 *
 * <p>It's for stateful login form, if you want stateless use {@link StatelessLoginForm}.</p>
 *
 * <p>Requirements:</p>
 *
 * <ol>
 *     <li>Shiro {@link org.apache.shiro.realm.AuthenticatingRealm}</li>
 *     <li>{@link org.apache.wicket.protocol.http.WebApplication#newSession(Request, Response)} must return {@link SoluvasWebSession}</li>
 * </ol>
 *
 * @author rudi
 * @author ceefour
 * @see DedicatedLoginPage
 * @see org.apache.wicket.protocol.http.WebApplication#newSession(Request, Response)
 * @see SoluvasWebSession
 * @see StatelessLoginForm
 */
@SuppressWarnings("serial")
public class LoginButton extends IndicatingAjaxButton {
	private static final Logger log = LoggerFactory.getLogger(LoginButton.class);
	private final IModel<LoginToken> loginTokenModel;
	private final String host;
	
	/**
	 * @param id
	 * @param loginTokenModel
	 * @param host To be used for {@link UsernamePasswordToken#setHost(String)}, usually {@link TenantRef#getTenantId()} for tenant logins
	 * 		and {@link StaticAppRealm#HOST} for app login.
	 */
	public LoginButton(String id, final IModel<LoginToken> loginTokenModel, String host) {
		super(id);
		this.loginTokenModel = loginTokenModel;
		this.host = host;
	}
	
	protected void doAuthenticate(@Nullable AjaxRequestTarget target) {
		final LoginToken loginData = loginTokenModel.getObject();
		final String upUsername = Strings.nullToEmpty(loginData.getUsername());
		final String upPassword = Strings.nullToEmpty(loginData.getPassword());
		final UsernamePasswordToken token = new UsernamePasswordToken(
				upUsername, upPassword.toCharArray(), host);
		log.debug("Logging in using '{}' host '{}'", upUsername, host);
		try {
			final Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			final String personId = Preconditions.checkNotNull((String) currentUser.getPrincipal(),
					"Cannot get current user as person ID");
			Interaction.LOGIN.info("You are now logged in as %s", personId);
			log.debug("Current user is now '{}' host '{}'. Has permission to edit all person data? {}",
					personId, host, currentUser.isPermitted("person:edit:*"));
			if (target != null) {
				onLoginSuccess(target, personId);
			} else {
				onLoginSuccessStateless(personId);
			}
		} catch (final AuthenticationException e) {
//			error(String.format("Invalid credentials for %s", token.getUsername()));
			getSession().error(String.format("Wrong Username/Email and password combination."));
			log.info(String.format("Invalid credentials for '%s' tenant '%s'",
					token.getUsername(), token.getHost()), e);
		}
	}

	@Override
	protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
		super.onSubmit(target, form);
		doAuthenticate(target);
	}
	
	/**
	 * Override this method to handle Ajax submit <b>only</b>, for example, redirect to original page
	 * (if using {@link DedicatedLoginPage}).
	 * @param target 
	 * @param personId
	 */
	protected void onLoginSuccess(AjaxRequestTarget target, String personId) {
	}

	/**
	 * Override this method to handle <b>non</b>-Ajax submit, for example, redirect to original page
	 * (if using {@link DedicatedLoginPage}).
	 * @param personId
	 * @deprecated No longer supports stateless since Wicket 7 because no {@link #onSubmit()}.
	 */
	@Deprecated
	protected void onLoginSuccessStateless(String personId) {
	}

}
