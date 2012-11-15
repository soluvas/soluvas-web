package org.soluvas.web.site.compose;

import java.io.Serializable;
import java.util.Collection;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;

/**
 * @author ceefour
 *
 */
public class ComposeUtils {

	private static Logger log = LoggerFactory.getLogger(ComposeUtils.class);
	
	/**
	 * Composes the relevant contributors.
	 * @param page
	 * @param contributors
	 */
	public static void compose(Page page, Collection<LiveContributor> contributors) {
		for (LiveContributor contrib : contributors) {
			if (contrib.getState() != ContributorState.RESOLVED)
				continue;
			if (contrib instanceof LiveChildContributor) {
				final LiveChildContributor childContrib = (LiveChildContributor) contrib;
				LivePlaceholder placeholder = childContrib.getPlaceholder();
				if (placeholder.getPageClass().isAssignableFrom(page.getClass())) {
					final Iterable<String> pathSegments = Splitter.on(':').split(contrib.getTargetPath());
					Component parent = page;
					for (String segment : pathSegments) {
						Component child = parent.get(segment);
						if (child == null) {
							throw new RuntimeException("Cannot find component " + segment + " from parent " + parent + " requested by " + contrib);
						}
						parent = child;
					}
					final RepeatingView repeatingViewParent = (RepeatingView) parent;
					final Component componentToAdd = childContrib.getFactory().create(repeatingViewParent.newChildId(), new Model<Serializable>(null)); // TODO: need model!
					log.debug("Adding {} to {} in {}", componentToAdd, repeatingViewParent, page);
					repeatingViewParent.add(componentToAdd);
				}
			}
		}
	}
	
}
