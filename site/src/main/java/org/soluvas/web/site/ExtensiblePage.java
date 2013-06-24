package org.soluvas.web.site;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.annotation.Nullable;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.compose.ChildContributor;
import org.soluvas.web.site.compose.RegionBehavior;
import org.soluvas.web.site.pagemeta.impl.PageMetaImpl;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
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
	private final Map<String, IModel<?>> modelsForPageMeta = Maps.newHashMap();
	
	/**
	 * Together with Compose {@code child} contribution, this allows {@link ChildContributor}s
	 * to get a model.
	 * @param path
	 * @param model
	 * @deprecated Use {@link RegionBehavior}.
	 */
	@Deprecated
	private void addModelForChild(String path, IModel<?> model) {
		log.trace("Adding model for child {} in {}", path, getPageClass().getName());
		modelsForChild.put(path, model);
	}
	
	/**
	 * Together with {@link RulesPageMetaSupplier}, this allows {@link PageMetaImpl#toText(Object)}
	 * to get the {@literal scope}.
	 * @param name
	 * @param model
	 * @todo Find a better name / mechanism.
	 */
	public void addModelForPageMeta(final String name, final IModel<?> model) {
		log.trace("Adding model for PageMeta {} in {}", name, getPageClass().getName());
		modelsForPageMeta.put(name, model);
	}
	
	/**
	 * This will currently search in two places: #modelForChild
	 * and {@link RegionBehavior}s.
	 * @param path
	 * @return
	 * @todo remove modelForChild and replace with {@link RegionBehavior}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> IModel<T> getModelForChild(final String path) {
		final Component region = Preconditions.checkNotNull(get(path),
				"Cannot find component '%s' in %s for getModelForChild",
				path, getClass().getName());
		final MarkupContainer regionHost = region.getParent();
		final List<RegionBehavior<?>> hostRegions = (List) regionHost.getBehaviors(RegionBehavior.class);
		try {
			final RegionBehavior<T> regionBehavior = (RegionBehavior<T>) Iterables.find(hostRegions, new Predicate<RegionBehavior<?>>() {
				@Override
				public boolean apply(@Nullable RegionBehavior<?> behavior) {
					return path.equals(behavior.getPath());
				}
			});
			return regionBehavior.getModel();
		} catch (NoSuchElementException e) {
			if (modelsForChild.containsKey(path))
				return (IModel<T>) modelsForChild.get(path);
			throw new WebSiteException("Cannot find RegionBehavior for " + path +
					" in " + regionHost + ". Found " + hostRegions.size() + " other RegionBehaviors: " + hostRegions, e);
		}
	}
	
	/**
	 * Create a {@link RepeatingView} region and associate it with an {@link IModel}.
	 * @param regionId The component name for the region.
	 * @param model Model that will be given to all of its children.
	 * @return
	 * @deprecated Use {@link RegionBehavior}.
	 */
	@Deprecated
	protected RepeatingView addRegion(final String regionId, @Nullable final IModel<?> model) {
		final RepeatingView region;
		add(region = new RepeatingView(regionId));
		addModelForChild(regionId, model);
		return region;
	}

	public Map<String, IModel<?>> getModelsForPageMeta() {
		return modelsForPageMeta;
	}

}
