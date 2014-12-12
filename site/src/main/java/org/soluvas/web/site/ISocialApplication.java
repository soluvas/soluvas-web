package org.soluvas.web.site;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * Social Web Application helper methods.
 * @author ceefour
 */
public interface ISocialApplication {

	Class<? extends Page> getResetPasswordPage();
	
	Class<? extends Page> getPersonShowPage();
	
	/**
	 * It's recommended to use {@link #newCategoryLink(String, String, String, String)} instead.
	 * @return
	 */
	Class<? extends Page> getCategoryShowPage();

	BookmarkablePageLink<? extends Page> newCategoryLink(
			String componentId, String localePrefId, String slugPath,
			String displayName);

}
