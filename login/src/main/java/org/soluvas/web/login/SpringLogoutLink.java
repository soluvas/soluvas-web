package org.soluvas.web.login;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.Interaction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * Logs the current user out and returns to "after logout page", using Spring Security.
 *
 * FIXME: resolve https://issues.apache.org/jira/browse/WICKET-6431
 *
 * @author ceefour
 */
@SuppressWarnings("serial")
public class SpringLogoutLink extends Link<Void> {

	private static final Logger log = LoggerFactory.getLogger(SpringLogoutLink.class);

	public SpringLogoutLink(String id) {
		super(id);
	}

	@Override
	public void onClick() {
		final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final String prevUserId;
		if (principal instanceof User) {
			prevUserId = ((User) principal).getUsername();
		} else {
			prevUserId = null;
		}
		final Class<? extends Page> homePageClass = getApplication().getHomePage();
		log.info("Logging out '{}' and redirecting to {}", prevUserId, homePageClass.getName());
		SecurityContextHolder.getContext().setAuthentication(null);
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
