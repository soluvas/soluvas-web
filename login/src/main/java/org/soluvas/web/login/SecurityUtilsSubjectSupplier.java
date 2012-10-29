package org.soluvas.web.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.google.common.base.Supplier;

/**
 * Provides {@link Subject} via {@link SecurityUtils#getSubject()}. Note that
 * this is not expected to work well in a multitenant OSGi environment.
 * 
 * @author ceefour
 */
public class SecurityUtilsSubjectSupplier implements Supplier<Subject> {

	@Override
	public Subject get() {
		return SecurityUtils.getSubject();
	}

}
