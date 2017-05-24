package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.login.facebook.FacebookLoginLink;
import org.soluvas.web.login.facebook.FacebookRecipient;
import org.soluvas.web.login.twitter.TwitterLoginLink;
import org.soluvas.web.site.SoluvasWebSession;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * A Shiro-powered dedicated login panel, to be used by e.g. {@link DedicatedLoginPage}.
 *
 * <p>It uses {@link LoginButton}, therefore its requirements:</p>
 *
 * <ol>
 *     <li>Shiro {@link org.apache.shiro.realm.AuthenticatingRealm}</li>
 *     <li>{@link org.apache.wicket.protocol.http.WebApplication#newSession(Request, Response)} must return {@link SoluvasWebSession}</li>
 * </ol>
 *
 * @author rudi
 * @see DedicatedLoginPage
 * @see org.apache.wicket.protocol.http.WebApplication#newSession(Request, Response)
 * @see SoluvasWebSession
 */
@SuppressWarnings("serial")
public class DedicatedLoginPanel extends GenericPanel<LoginToken> {
	
	private static final Logger log = LoggerFactory
			.getLogger(DedicatedLoginPanel.class);
	
	private final Class<? extends Page> facebookRecipientPage;
	private final Class<? extends Page> twitterRecipientPage;

	public DedicatedLoginPanel(final String id,
			final IModel<LoginToken> userLoginModel) {
		super(id, userLoginModel);
		this.facebookRecipientPage = FacebookRecipient.class;
		this.twitterRecipientPage = TwitterRecipient.class;
	}
	
	public DedicatedLoginPanel(final String id,
			final IModel<LoginToken> userLoginModel,
			Class<? extends Page> facebookRecipientPage,
			Class<? extends Page> twitterRecipientPage) {
		super(id, userLoginModel);
		this.facebookRecipientPage = facebookRecipientPage;
		this.twitterRecipientPage = twitterRecipientPage;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		final Subject subject = SecurityUtils.getSubject();
		if (subject.getPrincipal() != null) {
			final Class<? extends Page> homePage = getApplication().getHomePage();
			log.info("User '{}' is already logged in, redirecting to {}", subject.getPrincipal(), homePage.getName());
			getRequestCycle().setResponsePage(homePage);
		}
		
		add(new FormSignIn("formSignIn", getModel(), this));		
	}
	
	public class FormSignIn extends Form<LoginToken> {

		@Inject
		private WebAddress webAddress;
		@Inject @Named("personLookup")
		private EntityLookup<Person2, String> personLookup;
		@Inject
		private TenantRef tenant;
		
		public FormSignIn(final String id, final IModel<LoginToken> userLoginModel,
				final Component dedicatedLoginPanelComponent) {
			super(id, userLoginModel);

			final Subject subject = SecurityUtils.getSubject();
			if (subject.isRemembered()) {
				userLoginModel.getObject().setUsername((String) subject.getPrincipal());
				userLoginModel.getObject().setRememberMe(true);
			}
			
			setOutputMarkupId(true);
			
			add(new TextField<String>("userName", new PropertyModel<>(userLoginModel, "username")));
			add(new PasswordTextField("password", new PropertyModel<>(userLoginModel, "password")));
			add(new CheckBox("rememberMe", new PropertyModel<>(userLoginModel, "rememberMe")));
			
			final LoginButton ldapLoginBtn = new LoginButton("login", userLoginModel, tenant.getTenantId()) {
				@Override
				protected void onLoginSuccess(AjaxRequestTarget target, String personId) {
					log.debug("LoginButton has logged in '{}', redirecting to original page...", personId);
					((SoluvasWebSession) getSession()).postLoginSuccess();
				}
			};
			add(ldapLoginBtn);
			
			final FacebookLoginLink facebookLoginLink = new FacebookLoginLink("btnLoginWithFb", facebookRecipientPage);
			add(facebookLoginLink);
			final TwitterLoginLink twitterLoginLink = new TwitterLoginLink("btnLoginWithTwitter", twitterRecipientPage);
			add(twitterLoginLink);
			// TODO: enable Google when it's actually working with Google accounts, not Google+
//			final GoogleLoginLink googleLoginLink = new GoogleLoginLink("btnLoginWithGoogle");
//			add(googleLoginLink);
			final Component googleLoginLink = new WebMarkupContainer("btnLoginWithGoogle").setVisible(false);
			add(googleLoginLink);
			final WebMarkupContainer socialLoginLabel = new WebMarkupContainer("socialLoginLabel");
			socialLoginLabel.setVisible(facebookLoginLink.isVisible() || twitterLoginLink.isVisible() || googleLoginLink.isVisible());
			add(socialLoginLabel);

			setDefaultButton(ldapLoginBtn);
		}
		
	}

}
