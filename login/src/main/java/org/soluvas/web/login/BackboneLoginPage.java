package org.soluvas.web.login;

import org.apache.wicket.model.Model;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Extensible login and sign up page.
 * @author ceefour
 */
@MountPath("login_backbone")
public class BackboneLoginPage extends BootstrapPage {

	private static final long serialVersionUID = 1L;

	public BackboneLoginPage() {
		super();
		LoginToken loginFormData = new LoginToken("hendy", "bippo");
		add(new BackboneLoginForm("loginForm", new Model<LoginToken>(loginFormData)));
	}

}
