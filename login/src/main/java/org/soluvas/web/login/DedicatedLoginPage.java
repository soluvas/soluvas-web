package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.Page;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.EntityLookup;
import org.soluvas.ldap.Person;
import org.soluvas.security.AppSessionManager;
import org.soluvas.web.bootstrap.BootstrapPage;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="login")
public class DedicatedLoginPage extends BootstrapPage {
	
	private static final Logger log = LoggerFactory
			.getLogger(DedicatedLoginPage.class);
	
	@PaxWicketBean(name="webAddress") @SpringBean(name="webAddress")
	private WebAddress webAddress;
	@PaxWicketBean(name="personLookup") @SpringBean(name="personLookup")
	private EntityLookup<Person, String> personLookup;
	@PaxWicketBean(name="appSessionMgr") @SpringBean(name="appSessionMgr")
	private AppSessionManager appSessionMgr;
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		
		final Subject subject = SecurityUtils.getSubject();
		if (subject.getPrincipal() != null) {
			final Person userSession = appSessionMgr.requirePerson(subject);
			log.warn("{} has logged in..", userSession.getId());
			final Class<? extends Page> homePage = getApplication().getHomePage();
			getRequestCycle().setResponsePage(homePage);
		}
	}
	
	public DedicatedLoginPage() {
		super(SidebarVisibility.HIDDEN);
		
		final IModel<LoginFormModel> userLoginModel = new LoadableDetachableModel<LoginFormModel>() {
			@Override
			protected LoginFormModel load() {
				return new LoginFormModel();
			}
		};
		
		add(new DedicatedLoginPanel("dedicatedLoginPanel", userLoginModel));
	}

}
