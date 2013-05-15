package org.soluvas.web.site;

import org.apache.wicket.Page;
import org.soluvas.web.site.pagemeta.PageMeta;

/**
 * Provides a {@link Page} metadata to be rendered in a web page template.
 * @author ceefour
 */
public interface PageMetaProvider {
	
	public PageMeta get(PageRequestContext context);

}
