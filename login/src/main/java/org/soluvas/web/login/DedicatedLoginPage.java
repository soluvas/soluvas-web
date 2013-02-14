package org.soluvas.web.login;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.soluvas.web.bootstrap.BootstrapPage;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="login")
public class DedicatedLoginPage extends BootstrapPage {
	
	public DedicatedLoginPage() {
		super(false);
		
		final IModel<LoginFormModel> userLoginModel = new LoadableDetachableModel<LoginFormModel>() {
			@Override
			protected LoginFormModel load() {
				return new LoginFormModel();
			}
		};
		
		add(new DedicatedLoginPanel("dedicatedLoginPanel", userLoginModel));
	}

}
