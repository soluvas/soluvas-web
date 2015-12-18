package org.soluvas.web.login.facebook;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.security.AutologinToken;
import org.soluvas.web.login.LoginException;
import org.soluvas.web.site.Interaction;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.GrantedAuthoritiesContainerImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails;
import org.wicketstuff.annotation.mount.MountPath;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 * Get Facebook Login , token Access, FB Photo profile
 * @author haidar
 *
 */
@SuppressWarnings("serial")
@MountPath("fb_recipient_spring")
public class SpringFacebookRecipientPage extends AbstractFacebookRecipient {

	public static final String PATH = "fb_recipient_spring";

	@Inject
	private AuthenticationManager authMgr;

	public SpringFacebookRecipientPage(final PageParameters params) {
		super(params, PATH);
	}

	@Override
	protected void doLogin(String personId) {
		final User user = new User(personId, "", ImmutableList.of());
		final PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(user, "");
		token.setDetails(new PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails(
				(HttpServletRequest) getRequest().getContainerRequest(), ImmutableList.of()));
		log.debug("Logging in via Facebook using pre-authenticated {} ...", token);
		try {
			final Authentication authentication = authMgr.authenticate(token);
			// TODO: Permission-based?
//			log.debug("Current user is now '{}' host '{}'. Has permission to edit all person data? {}",
//					personId, host, currentUser.isPermitted("person:edit:*"));
			// http://stackoverflow.com/a/6165912/122441 is not required if 'securityFilterChain' is property ordered
			SecurityContextHolder.getContext().setAuthentication(authentication);
			log.debug("Current user is now {} via Facebook", personId);
			Interaction.LOGIN.info("You are now logged in as %s", personId);
		} catch (final AuthenticationException e) {
			throw new LoginException(e, "Invalid credentials for %s", token.getPrincipal());
		}
	}
}
