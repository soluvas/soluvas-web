package org.soluvas.web.login;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
@MountPath("access_denied/")
public class AccessDeniedPage extends BootstrapPage {
	
	public AccessDeniedPage(PageParameters params) {
		super(params);
	}

}
