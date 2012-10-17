package org.soluvas.web.login;

import org.apache.wicket.model.Model;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.soluvas.web.bootstrap.BootstrapPage;

/**
 * Extensible login and sign up page.
 * @author ceefour
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="login_backbone")
public class BackboneLoginPage extends BootstrapPage {

	public BackboneLoginPage() {
		super();
		LoginFormModel loginFormData = new LoginFormModel("hendy", "bippo");
		add(new BackboneLoginForm("loginForm", new Model<LoginFormModel>(loginFormData)));
	}

}
