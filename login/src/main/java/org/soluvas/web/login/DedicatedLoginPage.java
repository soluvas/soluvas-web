package org.soluvas.web.login;

import org.apache.wicket.model.IModel;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.soluvas.web.site.AsyncModel;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="login")
public class DedicatedLoginPage extends BootstrapPage {
	
	public DedicatedLoginPage() {
		super(false);
		
		final IModel<LoginFormModel> userLoginModel = new AsyncModel<LoginFormModel>() {
			@Override
			protected LoginFormModel load() throws Exception {
				return new LoginFormModel();
			}
		};
		
		add(new DedicatedLoginPanel("dedicatedLoginPanel", userLoginModel));
	}

}
