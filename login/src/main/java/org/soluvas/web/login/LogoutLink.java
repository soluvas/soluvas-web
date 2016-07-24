package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.Interaction;

/**
 * rudi: Pake normal link, bukan stateless: ga jadi pake stateless: https://idbippo.atlassian.net/browse/BC-2658
 * 
 * Logs the current user out and returns to "after logout page", using Shiro.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class LogoutLink extends Link<Void> {

	private static final Logger log = LoggerFactory.getLogger(LogoutLink.class);
	
	public LogoutLink(String id) {
		super(id);
	}

	@Override
	public void onClick() {
		final Subject currentUser = SecurityUtils.getSubject();
		final Class<? extends Page> homePageClass = getApplication().getHomePage();
		log.info("Logging out {} and redirecting to {}", currentUser.getPrincipal(), homePageClass.getName());
		currentUser.logout();
		Interaction.LOGOUT.info(getString("loggedOut")); // TODO: why is this not in FeedbackMessages?
		setResponsePage(homePageClass);
		/* For some reason at this point Wicket (6.8.0) throws:
		 *  
		 * java.lang.IllegalStateException
		 * getAttribute: Session already invalidated
		 * at org.apache.catalina.session.StandardSession.getAttribute(StandardSession.java:1165) ~[catalina.jar:7.0.39]
		 * at org.apache.catalina.session.StandardSessionFacade.getAttribute(StandardSessionFacade.java:122) ~[catalina.jar:7.0.39]
		 * at org.apache.wicket.session.HttpSessionStore.getAttribute(HttpSessionStore.java:264) ~[wicket-core-6.8.0.jar:6.8.0]
		 * at org.apache.wicket.Session.getAttribute(Session.java:732) ~[wicket-core-6.8.0.jar:6.8.0]
		 *
		 * But logout works fine.
		 * I've no idea why. -Hendy
		 */
	}
	
}
