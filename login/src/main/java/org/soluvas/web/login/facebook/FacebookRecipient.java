package org.soluvas.web.login.facebook;

import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.commons.Person;
import org.soluvas.commons.entity.Person2;
import org.soluvas.security.AutologinToken;
import org.soluvas.web.login.LoginException;
import org.soluvas.web.site.Interaction;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Get Facebook Login , token Access, FB Photo profile.
 *
 * To use, add in your {@link org.apache.wicket.protocol.http.WebApplication}:
 *
 * <pre>{@code
 * new AnnotatedMountScanner().scanPackage("org.soluvas.web.login").mount(this);
 * }</pre>
 *
 * @author haidar
 * @see FacebookLoginLink
 */
@SuppressWarnings("serial")
@MountPath("fb_recipient/")
public class FacebookRecipient extends AbstractFacebookRecipient {

	public static final String PATH = "fb_recipient/";

	public FacebookRecipient(final PageParameters params) {
		super(params, PATH);
	}

	@Override
	protected void doLogin(final String personId, Person2 person) {
		final AuthenticationToken token = new AutologinToken(
				Strings.nullToEmpty(personId), tenant.getTenantId());
		log.debug("Logging in via Facebook using AutologinToken {} ...", token.getPrincipal());
		try {
			final Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			Interaction.LOGIN.info("You are now logged in as %s", personId);
			log.debug("Current user is now {}, permitted to edit person? {}",
					personId, currentUser.isPermitted("person:edit:*"));
//				onLoginSuccess(personId);
		} catch (final AuthenticationException e) {
			throw new LoginException(e, "Invalid credentials for %s", token.getPrincipal());
		}
	}

}
