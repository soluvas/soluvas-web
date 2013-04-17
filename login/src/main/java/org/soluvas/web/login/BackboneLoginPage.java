package org.soluvas.web.login;

import org.apache.wicket.model.Model;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.soluvas.web.site.WicketMountPoint;

/**
 * Extensible login and sign up page.
 * @author ceefour
 */
@SuppressWarnings("serial")
@WicketMountPoint(mountPoint="login_backbone")
public class BackboneLoginPage extends BootstrapPage {

	public BackboneLoginPage() {
		super();
		LoginFormModel loginFormData = new LoginFormModel("hendy", "bippo");
		add(new BackboneLoginForm("loginForm", new Model<LoginFormModel>(loginFormData)));
	}

}
