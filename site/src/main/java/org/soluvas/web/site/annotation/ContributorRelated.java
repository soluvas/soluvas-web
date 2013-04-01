package org.soluvas.web.site.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.compose.LiveContributor;

/**
 * Used to inject a {@link LiveContributor} {@link CrudRepository}.
 * @author rudi
 */
@Qualifier @Documented @Retention(RetentionPolicy.RUNTIME)
public @interface ContributorRelated {

}
