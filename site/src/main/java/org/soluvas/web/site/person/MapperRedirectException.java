package org.soluvas.web.site.person;

import org.apache.wicket.core.request.handler.IPageProvider;

/**
 * Redirects for canonical URIs (i.e. mismatched {@code slug}) 
 * or legacy URIs (which should be no longer needed on Bippo 7.0).
 * @author ceefour
 */
public class MapperRedirectException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final IPageProvider pageProvider;

	public MapperRedirectException(IPageProvider pageProvider) {
		super();
		this.pageProvider = pageProvider;
	}
	
	public IPageProvider getPageProvider() {
		return pageProvider;
	}
	
}
