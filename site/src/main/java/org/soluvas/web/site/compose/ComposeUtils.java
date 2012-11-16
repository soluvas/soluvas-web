package org.soluvas.web.site.compose;

import java.io.Serializable;
import java.util.Collection;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.Page;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.MultitenantPage;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

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
				final LivePlaceholder placeholder = childContrib.getPlaceholder();
				if (placeholder.getPageClass().isAssignableFrom(page.getClass())) {
					final Iterable<String> pathSegments = Splitter.on(':').split(contrib.getTargetPath());
					Component parent = page;
					boolean validPath = true;
					for (String segment : pathSegments) {
						Component child = parent.get(segment);
						if (child == null) {
							validPath = false;
							log.warn("Skipping non-existing component " + segment + " from parent " + parent + " requested by " + contrib +
									", probably the component hierarchy is incompatible due to other contributors. Try using the weight attribute to reorder.");
							break;
						}
						parent = child;
					}
					if (!validPath)
						continue;;
					final RepeatingView repeatingViewParent = (RepeatingView) parent;
					final IModel<?> model;
					if (!Strings.isNullOrEmpty(placeholder.getModelClassName())) {
						if (page instanceof MultitenantPage) {
							model = ((MultitenantPage) page).getModelForChild(contrib.getTargetPath());
						} else
							throw new RuntimeException("Page " + page.getClass().getName() + " must be an instance of MultitenantPage to provide a model of " +
									placeholder.getModelClassName() + " for " + placeholder);
					} else {
						model = null;
					}
					final Component componentToAdd = childContrib.getFactory().create(repeatingViewParent.newChildId(), model);
					log.debug("Adding {} to {} in {}", componentToAdd, repeatingViewParent, page);
					repeatingViewParent.add(componentToAdd);
				}
			} else if (contrib instanceof LiveReplaceContributor) {
				final LiveReplaceContributor replaceContrib = (LiveReplaceContributor) contrib;
				final LiveSlave slave = ((LiveReplaceContributor) contrib).getSlave();
				if (slave.getPageClass().isAssignableFrom(page.getClass())) {
					final Iterable<String> pathSegments = Splitter.on(':').split(contrib.getTargetPath());
					Component target = page;
					MarkupContainer parent = null;
					boolean validPath = true;
					for (String segment : pathSegments) {
						parent = (MarkupContainer) target;
						Component child = target.get(segment);
						if (child == null) {
							validPath = false;
							log.warn("Skipping non-existing component " + segment + " from parent " + target + " requested by " + contrib +
									", probably the component hierarchy is incompatible due to other contributors. Try using the weight attribute to reorder.");
							continue;
						}
						target = child;
					}
					if (!validPath)
						continue;;
					final String compId = Iterables.getLast(pathSegments);
					Preconditions.checkNotNull(parent, "parent must not be null. Probably path %s is invalid for page %s.",
							contrib.getTargetPath(), page.getClass());
					final Component componentToAdd = replaceContrib.getFactory().create(compId, new Model<Serializable>(null)); // TODO: need model!
					log.debug("Replacing {} with {} to {} in {}", contrib.getTargetPath(), componentToAdd, parent, page);
					parent.replace(componentToAdd);
				}
			} else {
				throw new RuntimeException("Unknown contributor " + contrib.getClass().getName() + " requested by " + contrib);
			}
		}
	}
	
}
