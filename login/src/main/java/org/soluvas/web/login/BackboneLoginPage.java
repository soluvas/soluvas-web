package org.soluvas.web.login;

import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Extensible login and sign up page.
 * @author ceefour
 */
@SuppressWarnings("serial")
@MountPath("login_backbone")
public class BackboneLoginPage extends BootstrapPage {

	public BackboneLoginPage(PageParameters params) {
		super(params);
		LoginToken loginFormData = new LoginToken("hendy", "bippo");
		add(new BackboneLoginForm("loginForm", new Model<LoginToken>(loginFormData)));
	}

}
