package org.soluvas.web.site;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to tag a page to be automatically mounted within a specific place.
 * Taken from Pax Wicket.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface WicketMountPoint {
    /**
     * Defines the place where a page should be mounted
     */
    String mountPoint();
}
