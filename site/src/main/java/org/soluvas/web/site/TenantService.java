package org.soluvas.web.site;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Injects OSGi service conforming to Soluvas Multitenant conventions.
 * @see MultitenantPage
 * @author ceefour
 */
@Target(ElementType.FIELD) @Retention(RetentionPolicy.RUNTIME)
public @interface TenantService {

	/**
	 * Namespace of the service.
	 */
	String value() default "";
	
	/**
	 * Interface or class name of the service.
	 * Default is the field type.
	 * @return
	 */
	String objectClass() default "";
	
	/**
	 * Additional filters, in LDAP format, e.g. <tt>(repositoryMode=normal)</tt>.
	 * @return
	 */
	String filter() default "";
	
}
