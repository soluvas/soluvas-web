package org.soluvas.web.site.compose;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.ExtensiblePage;

import com.google.common.base.Preconditions;

/**
 * Used so that {@link Panel}s or other components
 * can create compose regions and provide an {@link IModel}
 * to their child.
 * This provides the same functionality as {@link ExtensiblePage}'s
 * addModelForChild, or even may replace it.
 * @author rio
 */
@SuppressWarnings("serial")
public class RegionBehavior<T> extends Behavior {

	private static final Logger log = LoggerFactory.getLogger(RegionBehavior.class);
			
	/**
	 * The region component name, e.g. {@code addToCartRegion}. The component's path 
	 * (e.g. {@code sidePanel:addToCart} will become
	 * the region ID. 
	 */
	private final String name;
	/**
	 * The placeholder component. The component's path 
	 * (e.g. {@code productPanel:cartRegion} will become
	 * the region ID. 
	 */
	private final MarkupContainer region;
	/**
	 * Model to be provided for the region's children. 
	 */
	private final IModel<T> model;
	
	/**
	 * @param name The region component name, e.g. {@code addToCartRegion}. The component's path 
	 * (e.g. {@code sidePanel:addToCart} will become
	 * the region ID.
	 * @param model Model to be provided for the region's children.
	 */
	public RegionBehavior(String name, IModel<T> model) {
		super();
		this.name = name;
		this.model = model;
		this.region = new RepeatingView(name);
	}
	
	@Override
	public void bind(Component component) {
		super.bind(component);
		Preconditions.checkArgument(
				MarkupContainer.class.isAssignableFrom(component.getClass()),
				"RegionBehavior host %s must extend MarkupContainer", component);
		final MarkupContainer host = (MarkupContainer) component;
		host.add(region);
		log.debug("Binding {} region {} to host {}", getPath(), region, host);
	}
	
	@Override
	public void unbind(Component component) {
		region.remove();
		super.unbind(component);
	}

	/**
	 * Region name. This is the same as the placeholder
	 * component's {@link Component#getPageRelativePath()}.  
	 */
	public String getPath() {
		return region.getPageRelativePath();
	}

	public String getName() {
		return name;
	}

	public MarkupContainer getRegion() {
		return region;
	}

	public IModel<T> getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "RegionBehavior ["
				+ (getPath() != null ? "path=" + getPath() + ", " : "")
				+ (name != null ? "name=" + name + ", " : "")
				+ (region != null ? "region=" + region + ", " : "")
				+ (model != null ? "model=" + model : "") + "]";
	}

}
