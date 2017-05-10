package org.soluvas.web.login;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.security.impl.StaticAppRealm;
import org.soluvas.web.site.Interaction;
import org.soluvas.web.site.SoluvasWebSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;
import org.wicketstuff.stateless.components.StatelessAjaxButton;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

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
public class SpringLoginButton extends StatelessAjaxButton {

	private static final Logger log = LoggerFactory.getLogger(SpringLoginButton.class);

	private final IModel<LoginToken> loginTokenModel;
	private final String host;
	private boolean loginAsEnabled = false;

	@Inject
	private AuthenticationManager authMgr;
	@Inject
	private Environment env;
	@SpringBean(required = false)
	private PersonRepository personRepo;

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
	 * Allow login using sysadmin password ({@code security.user.password}).
	 * @return
     */
	public boolean isLoginAsEnabled() {
		return loginAsEnabled;
	}

	public void setLoginAsEnabled(boolean loginAsEnabled) {
		this.loginAsEnabled = loginAsEnabled;
	}

	protected void doAuthenticate(@Nullable AjaxRequestTarget target) {
		final LoginToken loginData = loginTokenModel.getObject();
		final String upUsername = Strings.nullToEmpty(loginData.getUsername());
		final String upPassword = Strings.nullToEmpty(loginData.getPassword());

		// FIXME: authorities
		boolean authenticated = false;
		Authentication authentication = new UsernamePasswordAuthenticationToken(upUsername, upPassword, null);
		log.debug("Logging in using '{}' host '{}'", upUsername, host);
		try {
			authentication = authMgr.authenticate(authentication);
			authenticated = true;
		} catch (final AuthenticationException e) {
			// second try using runAs
			if (isLoginAsEnabled()) {
				Preconditions.checkNotNull(personRepo, "loginAsEnabled requires personRepo");
				final String sysadminPassword = env.getRequiredProperty("security.user.password");
				if (sysadminPassword.equals(upPassword)) {
					final Person2 person = Preconditions.checkNotNull(personRepo.findOneByEmail(StatusMask.RAW, upUsername),
							"Cannot find person by email '%s'", upUsername);
					final User user = new User(person.getId(), "", ImmutableList.of());
					final List<SimpleGrantedAuthority> authorities = person.getSecurityRoleIds().stream()
							.map(it -> new SimpleGrantedAuthority("ROLE_" + it)).collect(Collectors.toList());
					final PreAuthenticatedAuthenticationToken preAuthenticated = new PreAuthenticatedAuthenticationToken(user, "",
							authorities);
					log.info("User {}'s Authorities: {}", person.getId(), authorities);
					preAuthenticated.setDetails(new PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails(
							(HttpServletRequest) getRequest().getContainerRequest(), authorities));
					// if exception here means Spring Security misconfiguration
					authentication = authMgr.authenticate(preAuthenticated);
					authenticated = true;
				}
			}

			if (!authenticated) {
				//			error(String.format("Invalid credentials for %s", token.getUsername()));
				getSession().error(String.format("Wrong Username/Email and password combination."));
				log.info(String.format("Invalid credentials for '%s' authorities %s",
						authentication.getPrincipal(), authentication.getAuthorities()), e);
			}
		}

		if (authenticated) {
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
