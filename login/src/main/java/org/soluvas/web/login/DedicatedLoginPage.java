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
import org.soluvas.commons.WebAddress;
import org.soluvas.data.EntityLookup;
import org.soluvas.ldap.Person;
import org.soluvas.security.AppSessionManager;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.soluvas.web.site.WicketMountPoint;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
@WicketMountPoint(mountPoint="login")
public class DedicatedLoginPage extends BootstrapPage {
	
	private static final Logger log = LoggerFactory
			.getLogger(DedicatedLoginPage.class);
	
	@SpringBean
	private WebAddress webAddress;
	@SpringBean(name="personLookup")
	private EntityLookup<Person, String> personLookup;
	@SpringBean(name="appSessionMgr")
	private AppSessionManager appSessionMgr;
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		
		final Subject subject = SecurityUtils.getSubject();
		if (subject.getPrincipal() != null) {
			final Person userSession = appSessionMgr.requirePerson(subject);
			log.info("{} has logged in..", userSession.getId());
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
