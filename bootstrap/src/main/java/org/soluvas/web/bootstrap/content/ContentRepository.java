package org.soluvas.web.bootstrap.content;

import java.util.Set;

import org.soluvas.data.EntityLookup;
import org.soluvas.data.StatusMask;

/**
 * @author ceefour
 *
 */
public interface ContentRepository extends EntityLookup<String, String> {

	Set<String> findAllSlugPathsByStatus(StatusMask statusMask);

}
