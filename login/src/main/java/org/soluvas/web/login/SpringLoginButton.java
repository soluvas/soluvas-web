package org.soluvas.web.login;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
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
import org.soluvas.web.site.SoluvasWebSession;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Generic {@link IndicatingAjaxButton} that can be used with Spring Security {@link org.springframework.security.authentication.ProviderManager}.
 *
 * <p>You need to override {@link #onLoginSuccess(AjaxRequestTarget, String)}.</p>
 *
 * <p>It's for stateful login form, if you want stateless use {@link StatelessLoginForm}.</p>
 *
 * <p>Requirements:</p>
 *
 * <ol>
 *     <li>A {@link org.springframework.security.authentication.ProviderManager} with one or more {@link org.springframework.security.authentication.AuthenticationProvider}s</li>
 *     <li>TODO: {@link org.springframework.security.web.authentication.RememberMeServices}</li>
 *     <li>{@link org.apache.wicket.protocol.http.WebApplication#newSession(Request, Response)} must return {@link SoluvasWebSession}</li>
 * </ol>
 *
 * @author rudi
 * @author ceefour
 * @see SpringDedicatedLoginPanel
 * @see org.apache.wicket.protocol.http.WebApplication#newSession(Request, Response)
 * @see SoluvasWebSession
 * @see StatelessLoginForm
 */
@SuppressWarnings("serial")
public class SpringLoginButton extends IndicatingAjaxButton {

	private static final Logger log = LoggerFactory.getLogger(SpringLoginButton.class);

	private final IModel<LoginToken> loginTokenModel;
	private final String host;

	@Inject
	private AuthenticationManager authMgr;

	/**
	 * @param id
	 * @param loginTokenModel
	 * @param host To be used for {@link UsernamePasswordToken#setHost(String)}, usually {@link TenantRef#getTenantId()} for tenant logins
	 * 		and {@link StaticAppRealm#HOST} for app login.
	 */
	public SpringLoginButton(String id, final IModel<LoginToken> loginTokenModel, String host) {
		super(id);
		this.loginTokenModel = loginTokenModel;
		this.host = host;
	}
	
	/**
	 * Makes this a stateless AJAX button.
	 * @todo Find a better, more convenient, superclass.
	 */
	@Override
	protected boolean getStatelessHint() {
		return true;
	}
	
	/**
	 * Makes this a stateless AJAX button.
	 * @todo Find a better, more convenient, superclass.
	 */
	@Override
	protected AjaxFormSubmitBehavior newAjaxFormSubmitBehavior(String event)
	{
		return new AjaxFormSubmitBehavior(getForm(), event)
		{
			@Override
			public boolean getStatelessHint(org.apache.wicket.Component component) {
				return true;
			};
			
			@Override
			protected void onSubmit(AjaxRequestTarget target)
			{
				SpringLoginButton.this.onSubmit(target, SpringLoginButton.this.getForm());
			}

			@Override
			protected void onAfterSubmit(AjaxRequestTarget target)
			{
				SpringLoginButton.this.onAfterSubmit(target, SpringLoginButton.this.getForm());
			}

			@Override
			protected void onError(AjaxRequestTarget target)
			{
				SpringLoginButton.this.onError(target, SpringLoginButton.this.getForm());
			}

			@Override
			protected AjaxChannel getChannel()
			{
				return SpringLoginButton.this.getChannel();
			}

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
			{
				super.updateAjaxAttributes(attributes);
				SpringLoginButton.this.updateAjaxAttributes(attributes);
			}

			@Override
			public boolean getDefaultProcessing()
			{
				return SpringLoginButton.this.getDefaultFormProcessing();
			}
		};
	}

	protected void doAuthenticate(@Nullable AjaxRequestTarget target) {
		final LoginToken loginData = loginTokenModel.getObject();
		final String upUsername = Strings.nullToEmpty(loginData.getUsername());
		final String upPassword = Strings.nullToEmpty(loginData.getPassword());
//		final UsernamePasswordToken token = new UsernamePasswordToken(
//				upUsername, upPassword.toCharArray(), host);
		// FIXME: authorities
		Authentication authentication = new UsernamePasswordAuthenticationToken(upUsername, upPassword, null);
		log.debug("Logging in using '{}' host '{}'", upUsername, host);
		try {
			authentication = authMgr.authenticate(authentication);
			final User user = (User) authentication.getPrincipal();
			final String personId = Preconditions.checkNotNull(user.getUsername(),
					"Cannot get current user as person ID");
			Interaction.LOGIN.info("You are now logged in as %s", personId);
			// TODO: Permission-based?
//			log.debug("Current user is now '{}' host '{}'. Has permission to edit all person data? {}",
//					personId, host, currentUser.isPermitted("person:edit:*"));
			// http://stackoverflow.com/a/6165912/122441 is not required if 'securityFilterChain' is property ordered
			SecurityContextHolder.getContext().setAuthentication(authentication);
			if (target != null) {
				onLoginSuccess(target, personId);
			} else {
				onLoginSuccessStateless(personId);
			}
		} catch (final AuthenticationException e) {
//			error(String.format("Invalid credentials for %s", token.getUsername()));
			getSession().error(String.format("Wrong Username/Email and password combination."));
			log.info(String.format("Invalid credentials for '%s' tenant '%s'",
					authentication.getPrincipal(), authentication.getAuthorities()), e);
		}
	}

	@Override
	protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
		super.onSubmit(target, form);
		doAuthenticate(target);
	}
	
	@Override
	public void onSubmit() {
		super.onSubmit();
		doAuthenticate(null);
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
	 */
	protected void onLoginSuccessStateless(String personId) {
	}

}
