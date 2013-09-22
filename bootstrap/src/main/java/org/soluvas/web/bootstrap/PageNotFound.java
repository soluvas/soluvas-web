package org.soluvas.web.bootstrap;

import org.apache.wicket.request.http.WebResponse;

/**
 * @author atang
 *
 */
public class PageNotFound extends BootstrapPage {

	private static final long serialVersionUID = 1L;

	public PageNotFound() {
		super();
//		add(new Page404());
	}
	
	@Override
	protected void configureResponse(WebResponse response) {
		// see http://stackoverflow.com/a/18941652/122441
		super.configureResponse(response);
		response.setStatus(404);
	}
	
}
