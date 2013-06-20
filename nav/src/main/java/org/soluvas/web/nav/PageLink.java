package org.soluvas.web.nav;

import java.io.Serializable;

import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Used by breadcrumb navigation bar.
 * @author atang
 */
public class PageLink implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String title;
	private final Class<?> page;
	private final PageParameters params;
	
	public PageLink(String title, Class<?> page, PageParameters params) {
		super();
		this.title = title;
		this.page = page;
		this.params = params;
	}
	
	public PageLink(String title, Class<?> page) {
		this(title, page, new PageParameters());
	}
	
	public PageLink(String title, Class<?> page, String paramName, String paramValue) {
		this(title, page, new PageParameters().add(paramName, paramValue));
	}

	public String getTitle() {
		return title;
	}

	public Class<?> getPage() {
		return page;
	}

	public PageParameters getParams() {
		return params;
	}
	
}
