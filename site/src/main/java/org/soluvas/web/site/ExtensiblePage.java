package org.soluvas.web.site;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.compose.ChildContributor;

import com.google.common.collect.Maps;

/**
 * {@link Page} supporting regions.
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ExtensiblePage extends WebPage {
	
	private static Logger log = LoggerFactory
			.getLogger(ExtensiblePage.class);
	private final Map<String, IModel<?>> modelsForChild = Maps.newConcurrentMap();
	
	/**
	 * Together with Compose {@code child} contribution, this allows {@link ChildContributor}s
	 * to get a model.
	 * @param path
	 * @param model
	 * @todo Find a better name / mechanism.
	 */
	private void addModelForChild(String path, IModel<?> model) {
		log.trace("Adding model for child {} in {}", path, getPageClass().getName());
		modelsForChild.put(path, model);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IModel<?>> T getModelForChild(String path) {
		return (T) modelsForChild.get(path);
	}
	
	/**
	 * Create a {@link RepeatingView} region and associate it with an {@link IModel}.
	 * @param regionId The component name for the region.
	 * @param model Model that will be given to all of its children.
	 * @return
	 */
	protected RepeatingView addRegion(@Nonnull final String regionId, @Nullable final IModel<?> model) {
		final RepeatingView region;
		add(region = new RepeatingView(regionId));
		addModelForChild(regionId, model);
		return region;
	}
}
