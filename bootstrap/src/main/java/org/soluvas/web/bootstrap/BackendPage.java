package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.soluvas.web.site.JavaScriptMode;
import org.soluvas.web.site.client.AmdDependency;


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
	public BackendPage() {
		this(SidebarVisibility.VISIBLE);
	}

	/**
	 * @param sidebarVisible
	 */
	public BackendPage(SidebarVisibility sidebarVisibility) {
		super(sidebarVisibility);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		// TODO: for now this is workaround because bootstrap.js will be loaded
		// in header, and thus, no need for RequireJS stuff
//		response.render(JavaScriptHeaderItem.forReference(bootstrapJs));
		if (requireMgr.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT) {
			response.render(JavaScriptHeaderItem.forUrl(webAddress.getJsUri() + "org.soluvas.web.bootstrap/bootstrap.js"));
		} else {
			response.render(JavaScriptHeaderItem.forUrl("//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/js/bootstrap.min.js"));
		}
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new AmdDependency("bootstrap/bootstrap-dropdown", "bootstrap_dropdown"));
	}
	
}
