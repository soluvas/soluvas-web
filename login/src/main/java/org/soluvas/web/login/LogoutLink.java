package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logs the current user out and returns to "after logout page".
 * @author ceefour
 */
@SuppressWarnings("serial")
public class LogoutLink extends IndicatingAjaxLink<Void> {

	private static final Logger log = LoggerFactory.getLogger(LogoutLink.class);
	
	public LogoutLink(String id) {
		super(id);
	}

	@Override
	public void onClick(AjaxRequestTarget target) {
		Subject currentUser = SecurityUtils.getSubject();
		final Class<? extends Page> homePage = getApplication().getHomePage();
		log.info("Logging out {} and redirecting to {}", currentUser.getPrincipal(), homePage);
		currentUser.logout();
		info("Anda telah log out.");
		throw new RestartResponseException(homePage);
	}

}
