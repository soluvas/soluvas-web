package org.soluvas.web.site;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.soluvas.commons.tenant.TenantMode;
import org.wicketstuff.annotation.mount.MountPath;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

/**
 * Annotation used to tag a page to be automatically mounted within a specific place.
 * Taken from Pax Wicket.
 * @deprecated Please use {@link MountPath} in conjunction with
 * 	a to-be-coded scanner based on {@link AnnotatedMountScanner}
 * 	but supports {@link TenantMode#MULTI_PATH} (if this mode is still supported).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
@Deprecated
public @interface WicketMountPoint {
    /**
     * Defines the place where a page should be mounted
     */
    String mountPoint();
}
