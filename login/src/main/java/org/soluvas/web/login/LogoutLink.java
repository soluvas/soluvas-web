package org.soluvas.web.login;

import java.util.Collection;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logs the current user out and returns to "after logout page".
 * @author ceefour
 */
@SuppressWarnings("serial")
public class LogoutLink extends IndicatingAjaxLink<Void> {

	private static final Logger log = LoggerFactory.getLogger(LogoutLink.class);
	private final Collection<Component> ajaxTargets;
	private final Collection<IModel<?>> modelsToDetach;
	
	public LogoutLink(String id, Collection<Component> ajaxTargets, Collection<IModel<?>> modelsToDetach) {
		super(id);
		this.ajaxTargets = ajaxTargets;
		this.modelsToDetach = modelsToDetach;
	}

	@Override
	public void onClick(AjaxRequestTarget target) {
		Subject currentUser = SecurityUtils.getSubject();
		final Class<? extends Page> homePage = getApplication().getHomePage();
		log.info("Logging out {} and redirecting to {}", currentUser.getPrincipal(), homePage);
		currentUser.logout();
		info("Anda telah log out.");
		for (final IModel<?> model : modelsToDetach) {
			model.detach();
		}
		target.add(ajaxTargets.toArray(new Component[] {}));
//		getRequestCycle().setResponsePage(homePage);
	}

}
