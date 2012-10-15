package org.soluvas.web.site;

/**
 * Manipulates {@link Page} meta information.
 * @author ceefour
 */
public interface PageProcessor {
	
	/**
	 * Manipulates a page.
	 * @param page
	 */
	void processPage(Page page);

}
