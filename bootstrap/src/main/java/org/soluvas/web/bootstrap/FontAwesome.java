package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.request.resource.ResourceReference;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCDNCSSReference;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCssReference;


/**
 * <a href="http://fortawesome.github.io/Font-Awesome/icons/">Font Awesome</a> CSS reference.
 * Uses either {@link de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCssReference}
 * or {@link FontAwesomeCDNCSSReference} based on {@link IBootstrapSettings#useCdnResources()}.
 * @author ceefour
 */
public class FontAwesome {
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static ResourceReference instance() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return FontAwesomeCDNCSSReference.instance();
		} else {
			return FontAwesomeCssReference.instance();
		}
	}
	
	public static CssHeaderItem asHeaderItem() {
		return CssHeaderItem.forReference(instance());
	}

}
