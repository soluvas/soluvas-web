package org.soluvas.web.bootstrap.content;

import org.soluvas.data.EntityLookup;
import org.soluvas.data.StatusMask;

import com.google.common.collect.ImmutableSet;

/**
 * @author ceefour
 *
 */
public interface ContentRepository extends EntityLookup<String, String> {

	ImmutableSet<String> findAllSlugPathsByStatus(StatusMask statusMask);
	
	ImmutableSet<String> findAllWithouthPattern();

}
