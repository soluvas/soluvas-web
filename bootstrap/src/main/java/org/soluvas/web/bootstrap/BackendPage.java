package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.request.mapper.parameter.PageParameters;


/**
 * Only default styling.
 * @author rio
 */
@SuppressWarnings("serial")
public class BackendPage extends BootstrapPage {

//	private static final JavaScriptResourceReference bootstrapJs = new JavaScriptResourceReference(BackendPage.class, "bootstrap.js");
	
	/**
	 * 
	 */
	public BackendPage(PageParameters params) {
		this(params, SidebarVisibility.VISIBLE);
	}

	/**
	 * @param sidebarVisible
	 */
	public BackendPage(PageParameters params, SidebarVisibility sidebarVisibility) {
		super(sidebarVisibility);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
	}
	
}
