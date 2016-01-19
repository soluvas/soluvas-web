package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.StatelessLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.Interaction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Logs the current user out and returns to "after logout page", using Spring Security.
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
		final SecurityContextHolderAwareRequestWrapper request = (SecurityContextHolderAwareRequestWrapper) getRequest().getContainerRequest();
		final Principal prevUserPrincipal = request.getUserPrincipal();
		final Class<? extends Page> homePageClass = getApplication().getHomePage();
		log.info("Logging out '{}' and redirecting to {}", prevUserPrincipal != null ? prevUserPrincipal.getName() : null, homePageClass.getName());
		SecurityContextHolder.getContext().setAuthentication(null);
		Interaction.LOGOUT.info("Anda telah log out."); // TODO: why is this not in FeedbackMessages?
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
