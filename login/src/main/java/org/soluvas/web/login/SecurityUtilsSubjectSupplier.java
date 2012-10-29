package org.soluvas.web.login;

import org.apache.felix.service.command.CommandSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.common.base.Supplier;

/**
 * Provides {@link Subject} via {@link SecurityUtils#getSubject()}. Note that
 * this is not expected to work well in a multitenant OSGi environment.
 * 
 * The problem is, a "SecurityUtils.getSubject()" is definitely dependant on
 * both the tenant and the subsystem :
 * <ol>
 * <li>Wicket subsystem: get tenant from Wicket's Application.get(), get session
 * ID from HttpServletRequest Cookie</li>
 * <li>JAX-RS subsystem: get tenant from analyzing the URI, get session ID from
 * HttpServletRequest Cookie</li>
 * <li>Shell subsystem: get tenant from {@link CommandSession}, get session ID
 * also from {@link CommandSession}</li>
 * </ol>
 * 
 * On all three scenarios, the session itself is stored elsewhere, by Shiro,
 * probably in a MongoDB database, so sessions can be shared in a cluster of
 * Karaf nodes.
 * 
 * @author ceefour
 */
public class SecurityUtilsSubjectSupplier implements Supplier<Subject> {

	@Override
	public Subject get() {
		return SecurityUtils.getSubject();
	}

}
