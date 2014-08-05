package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.wicketstuff.annotation.mount.MountPath;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
@MountPath("login")
public class DedicatedLoginPage extends BootstrapPage {
	
	private static final Logger log = LoggerFactory
			.getLogger(DedicatedLoginPage.class);
	
	@SpringBean
	private WebAddress webAddress;
	@SpringBean(name="personLookup")
	private EntityLookup<Person, String> personLookup;
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		
		final Subject subject = SecurityUtils.getSubject();
		if (subject.getPrincipal() != null) {
			log.info("{} is already logged in.", subject.getPrincipal());
			final Class<? extends Page> homePage = getApplication().getHomePage();
			getRequestCycle().setResponsePage(homePage);
		}
	}
	
	public DedicatedLoginPage(PageParameters params) {
		super(params, SidebarVisibility.HIDDEN);
		
		final IModel<LoginToken> userLoginModel = new LoadableDetachableModel<LoginToken>() {
			@Override
			protected LoginToken load() {
				return new LoginToken();
			}
		};
		
		add(new DedicatedLoginPanel("dedicatedLoginPanel", userLoginModel));
	}

}
