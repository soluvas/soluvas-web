package org.soluvas.web.nav;

import java.io.Serializable;

import javax.annotation.Nullable;

import org.apache.wicket.Page;
import org.apache.wicket.core.request.handler.IPageProvider;
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
	@Nullable
	private final Class<? extends Page> page;
	@Nullable
	private final PageParameters params;
	
	public PageLink(String title, IPageProvider pageProvider) {
		super();
		this.title = title;
		this.page = (Class<? extends Page>) pageProvider.getPageClass();
		this.params = pageProvider.getPageParameters();
	}
	
	public PageLink(String title, Class<? extends Page> page, PageParameters params) {
		super();
		this.title = title;
		this.page = page;
		this.params = params;
	}
	
	public PageLink(String title, Class<? extends Page> page) {
		this(title, page, new PageParameters());
	}
	
	public PageLink(String title, Class<? extends Page> page, String paramName, String paramValue) {
		this(title, page, new PageParameters().add(paramName, paramValue));
	}

	public PageLink(String title) {
		super();
		this.title = title;
		this.page = null;
		this.params = null;
	}
	
	public String getTitle() {
		return title;
	}

	public Class<? extends Page> getPage() {
		return page;
	}

	public PageParameters getParams() {
		return params;
	}
	
}
