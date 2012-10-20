package org.soluvas.web.site;

import org.soluvas.web.site.pagemeta.PageMeta;

/**
 * Manipulates {@link PageMeta} information.
 * @author ceefour
 */
public interface PageProcessor {
	
	/**
	 * Manipulates a page.
	 * @param page
	 */
	void processPage(PageMeta pageMeta);

}
