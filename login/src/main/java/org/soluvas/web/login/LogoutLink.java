package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logs the current user out and returns to "after logout page".
 * @author ceefour
 */
@SuppressWarnings("serial")
public class LogoutLink extends AjaxLink<Void> {

	private static final Logger log = LoggerFactory.getLogger(LogoutLink.class);
	private final Component[] ajaxTargets;
	
	public LogoutLink(String id, Component... ajaxTargets) {
		super(id);
		this.ajaxTargets = ajaxTargets;
	}

	@Override
	public void onClick(AjaxRequestTarget target) {
		Subject currentUser = SecurityUtils.getSubject();
		final Class<? extends Page> homePage = getApplication().getHomePage();
		log.info("Logging out {} and redirecting to {}", currentUser.getPrincipal(), homePage);
		currentUser.logout();
		info("Anda telah log out.");
//		target.add(ajaxTargets);
		getRequestCycle().setResponsePage(homePage);
	}

}
