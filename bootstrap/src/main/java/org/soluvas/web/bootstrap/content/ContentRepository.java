package org.soluvas.web.bootstrap.content;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import org.soluvas.data.EntityLookup;
import org.soluvas.data.StatusMask;

/**
 * @author ceefour
 *
 */
public interface ContentRepository extends EntityLookup<String, String> {

	ImmutableSet<String> findAllSlugPathsByStatus(StatusMask statusMask);

}
