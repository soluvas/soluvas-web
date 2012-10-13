package org.soluvas.web.login;

import org.apache.wicket.model.Model;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.soluvas.web.bootstrap.BootstrapPage;

/**
 * Extensible login and sign up page.
 * @author ceefour
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="login")
public class LoginPage extends BootstrapPage {

	public LoginPage() {
		super();
		LoginFormModel loginFormData = new LoginFormModel("hendy", "bippo");
		add(new LoginForm("loginForm", new Model<LoginFormModel>(loginFormData)));
	}

}
