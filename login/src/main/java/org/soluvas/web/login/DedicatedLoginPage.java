package org.soluvas.web.login;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * Copy this class to your own {@link WebPage}, the logic is in {@link DedicatedLoginPanel}.
 * This page can be used as-is if you're okay it extends {@link BootstrapPage}.
 * @author rudi
 */
@SuppressWarnings("serial")
@MountPath("login")
public class DedicatedLoginPage extends BootstrapPage {
	
	public DedicatedLoginPage(PageParameters params) {
		super(params, SidebarVisibility.HIDDEN);
		add(new DedicatedLoginPanel("dedicatedLoginPanel", new Model<>(new LoginToken()) ));
	}

}
