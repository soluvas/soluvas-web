package org.soluvas.web.site;

import org.apache.wicket.Page;

/**
 * @author ceefour
 *
 */
public interface SocialApplication {

	Class<? extends Page> getResetPasswordPage();
	
	Class<? extends Page> getPersonShowPage();
	
	Class<? extends Page> getCategoryShowPage();

}
