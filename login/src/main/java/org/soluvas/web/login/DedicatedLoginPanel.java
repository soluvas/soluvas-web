package org.soluvas.web.login;

import javax.annotation.Nonnull;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.EntityLookup;
import org.soluvas.ldap.Person;
import org.soluvas.web.login.facebook.FacebookLoginLink;
import org.soluvas.web.login.twitter.TwitterLoginLink;
import org.soluvas.web.site.SoluvasWebSession;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class DedicatedLoginPanel extends Panel {
	
	static final Logger log = LoggerFactory
			.getLogger(DedicatedLoginPanel.class);

	public DedicatedLoginPanel(@Nonnull final String id,
			@Nonnull final IModel<LoginToken> userLoginModel) {
		super(id, userLoginModel);
		
		add(new FormSignIn("formSignIn", userLoginModel, this));
	}
	
	public class FormSignIn extends Form<LoginToken> {
		
		@SpringBean
		private WebAddress webAddress;
		@SpringBean(name="personLookup")
		private EntityLookup<Person, String> personLookup;
		
		@SuppressWarnings("unused")
		public FormSignIn(@Nonnull final String id, @Nonnull final IModel<LoginToken> userLoginModel,
				@Nonnull final Component dedicatedLoginPanelComponent) {
			super(id, userLoginModel);
			
			setOutputMarkupId(true);
			
			add(new TextField<String>("userName", new PropertyModel<String>(userLoginModel, "username")));
			add(new PasswordTextField("password", new PropertyModel<String>(userLoginModel, "password")));
			add(new CheckBox("rememberMe", new PropertyModel<Boolean>(userLoginModel, "rememberMe")));
			
			final LoginButton ldapLoginBtn = new LoginButton("login", userLoginModel) {
				@Override
				protected void onLoginSuccess(AjaxRequestTarget target, String personId) {
					((SoluvasWebSession) getSession()).postLoginSuccess();
				}
			};
			add(ldapLoginBtn);
			
			add(new FacebookLoginLink("btnLoginWithFb"));
			add(new TwitterLoginLink("btnLoginWithTwitter"));
			add(new WebMarkupContainer("btnLoginWithGoogle").setVisible(false));
			// TODO: enable Google when it's actually working with Google accounts, not Google+
//			final GoogleLoginLink googleLoginLink = new GoogleLoginLink("btnLoginWithGoogle");
//			add(googleLoginLink);
			
			setDefaultButton(ldapLoginBtn);
		}
		
	}

}
