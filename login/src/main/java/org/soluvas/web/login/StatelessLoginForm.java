package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.web.site.Interaction;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * rudi: ga jadi pake stateless: https://idbippo.atlassian.net/browse/BC-2658
 * 
 * It's for stateless login form, combined with a normal {@code input type="submit"},
 * which can be non-Wicket component, {@link Button}, or even a simple {@link WebMarkupContainer}.
 * If you want stateful use {@link LoginButton} + normal {@link Form}.
 * It's usable out-of-the-box because it does a POST-REDIRECT-GET (to avoid the Refresh POST problem) back to the current page,
 * if you want to replace this behavior or need more you can override {@link #onLoginSuccess(String)}.
 * @author ceefour
 * @see LoginButton
 */
@SuppressWarnings("serial")
public class StatelessLoginForm extends Form<LoginToken> {
	
	private static final Logger log = LoggerFactory
			.getLogger(StatelessLoginForm.class);

	@SpringBean
	private TenantRef tenant;

	public StatelessLoginForm(String id, final IModel<LoginToken> model) {
		super(id, model);
	}
	
	@Override
	protected void onSubmit() {
		final LoginToken loginData = getModelObject();
		final String upUsername = Strings.nullToEmpty(loginData.getUsername());
		final String upPassword = Strings.nullToEmpty(loginData.getPassword());
		final UsernamePasswordToken token = new UsernamePasswordToken(
				upUsername, upPassword.toCharArray(), tenant.getTenantId());
		log.debug("Logging in using '{}' password {} tenant '{}'", upUsername, upPassword, tenant.getTenantId());
		try {
			final Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			final String personId = Preconditions.checkNotNull((String) currentUser.getPrincipal(),
					"Cannot get current user as person ID");
			Interaction.LOGIN.info("You are now logged in as %s", personId);
			log.debug("Current user is now '{}' tenant '{}'. Has permission to edit all person data? {}",
					personId, tenant.getTenantId(), currentUser.isPermitted("person:edit:*"));
			onLoginSuccess(personId);
		} catch (final AuthenticationException e) {
//			error(String.format("Invalid credentials for %s",
//					token.getUsername()));
			getSession().error(String.format("Wrong Username/Email and password combination."));
			log.info(String.format("Invalid credentials for '%s' tenant '%s'",
					token.getUsername(), token.getHost()), e);
		}
		super.onSubmit();
	}

	/**
	 * Override this method to, for example, redirect to original page
	 * (if using {@link DedicatedLoginPage}).
	 * @param target TODO
	 * @param personId
	 */
	protected void onLoginSuccess(String personId) {
		setResponsePage(getPage().getClass(), getPage().getPageParameters());
	}
	
}
