package org.soluvas.web.login;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.login.facebook.FacebookLoginLink2;
import org.soluvas.web.login.facebook.SpringFacebookRecipientPage;
import org.soluvas.web.login.twitter.TwitterLoginLink;
import org.soluvas.web.site.SoluvasWebSession;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * A Spring Security-powered dedicated login panel, to be used by e.g. {@link DedicatedLoginPage}.
 *
 * <p>It uses {@link SpringLoginButton}, therefore its requirements:</p>
 *
 * <ol>
 *     <li>{@link EntityLookup} for {@link Person2}</li>
 *     <li>A {@link org.springframework.security.authentication.ProviderManager} with one or more {@link org.springframework.security.authentication.AuthenticationProvider}s</li>
 *     <li>TODO: {@link org.springframework.security.web.authentication.RememberMeServices}</li>
 *     <li>{@link org.apache.wicket.protocol.http.WebApplication#newSession(Request, Response)} must return {@link SoluvasWebSession}</li>
 * </ol>
 *
 * @author ceefour
 * @see DedicatedLoginPage
 * @see org.apache.wicket.protocol.http.WebApplication#newSession(Request, Response)
 * @see SoluvasWebSession
 */
@SuppressWarnings("serial")
public class SpringDedicatedLoginPanel extends GenericPanel<LoginToken> {

	private static final Logger log = LoggerFactory
			.getLogger(SpringDedicatedLoginPanel.class);

	private final Class<? extends Page> facebookRecipientPage;
	private final Class<? extends Page> twitterRecipientPage;
	private boolean normalEnabled = true;
	private boolean loginAsEnabled = false;

	public SpringDedicatedLoginPanel(final String id,
									 final IModel<LoginToken> userLoginModel) {
		super(id, userLoginModel);
		this.facebookRecipientPage = SpringFacebookRecipientPage.class;
		this.twitterRecipientPage = TwitterRecipient.class;
	}

	public SpringDedicatedLoginPanel(final String id,
									 final IModel<LoginToken> userLoginModel,
									 Class<? extends Page> facebookRecipientPage,
									 Class<? extends Page> twitterRecipientPage) {
		super(id, userLoginModel);
		this.facebookRecipientPage = facebookRecipientPage;
		this.twitterRecipientPage = twitterRecipientPage;
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

	/**
	 * Normal authentication uses app-configured database (PostgreSQL/MongoDB).
	 * If disabled, only external authentications (Facebook/Twitter/etc.) are available.
	 * @return
     */
	public boolean isNormalEnabled() {
		return normalEnabled;
	}

	/**
	 * @param normalEnabled Normal authentication uses app-configured database (PostgreSQL/MongoDB).
	 * If disabled, only external authentications (Facebook/Twitter/etc.) are available.
	 * @return
     */
	public SpringDedicatedLoginPanel setNormalEnabled(boolean normalEnabled) {
		this.normalEnabled = normalEnabled;
		return this;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		final SecurityContextHolderAwareRequestWrapper request = new SecurityContextHolderAwareRequestWrapper((HttpServletRequest) getRequest().getContainerRequest(), "ROLE_");
		final Principal userPrincipal = request.getUserPrincipal();
		if (userPrincipal != null) {
			final Class<? extends Page> homePage = getApplication().getHomePage();
			log.info("User '{}' is already logged in, redirecting to {}", userPrincipal.getName(), homePage.getName());
			getRequestCycle().setResponsePage(homePage);
		}
		
		add(new FormSignIn("formSignIn", getModel(), this));		
	}
	
	public class FormSignIn extends Form<LoginToken> {
		
		@Inject
		private TenantRef tenant;

		public FormSignIn(final String id, final IModel<LoginToken> userLoginModel,
				final Component dedicatedLoginPanelComponent) {
			super(id, userLoginModel);

			// TODO: RememberMeServices
//			if (subject.isRemembered()) {
//				userLoginModel.getObject().setUsername((String) subject.getPrincipal());
//				userLoginModel.getObject().setRememberMe(true);
//			}
			
			setOutputMarkupId(true);

			final WebMarkupContainer normal = new WebMarkupContainer("normal") {
				@Override
				protected void onConfigure() {
					super.onConfigure();
					setVisible(normalEnabled);
				}
			};
			normal.add(new TextField<String>("userName", new PropertyModel<>(userLoginModel, "username")));
			normal.add(new PasswordTextField("password", new PropertyModel<>(userLoginModel, "password")));
			normal.add(new CheckBox("rememberMe", new PropertyModel<>(userLoginModel, "rememberMe")));
			final SpringLoginButton normalLoginBtn = new SpringLoginButton("login", userLoginModel, tenant.getTenantId()) {
				@Override
				protected void onLoginSuccess(AjaxRequestTarget target, String personId) {
					log.debug("LoginButton has logged in '{}', redirecting to original page...", personId);
					((SoluvasWebSession) getSession()).postLoginSuccess();
				}
			};
			normalLoginBtn.setLoginAsEnabled(loginAsEnabled);
			normal.add(normalLoginBtn);
			add(normal);
			
			final FacebookLoginLink2 facebookLoginLink = new FacebookLoginLink2("btnLoginWithFb", facebookRecipientPage);
			add(facebookLoginLink);
			final TwitterLoginLink twitterLoginLink = new TwitterLoginLink("btnLoginWithTwitter", twitterRecipientPage);
			add(twitterLoginLink);
			// TODO: enable Google when it's actually working with Google accounts, not Google+
//			final GoogleLoginLink googleLoginLink = new GoogleLoginLink("btnLoginWithGoogle");
//			add(googleLoginLink);
			final Component googleLoginLink = new WebMarkupContainer("btnLoginWithGoogle").setVisible(false);
			add(googleLoginLink);

			final WebMarkupContainer socialLoginLabel = new WebMarkupContainer("socialLoginLabel") {
				@Override
				protected void onConfigure() {
					super.onConfigure();
					setVisible(normal.isVisible() &&
							(facebookLoginLink.isVisible() || twitterLoginLink.isVisible() || googleLoginLink.isVisible()));
				}
			};
			add(socialLoginLabel);

			setDefaultButton(normalLoginBtn);
		}
		
	}

}
