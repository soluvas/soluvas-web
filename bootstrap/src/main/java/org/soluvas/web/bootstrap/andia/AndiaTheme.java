package org.soluvas.web.bootstrap.andia;

import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import de.agilecoders.wicket.markup.html.themes.bootstrap.BootstrapCssReference;
import de.agilecoders.wicket.markup.html.themes.bootstrap.BootstrapResponsiveCssReference;
import de.agilecoders.wicket.settings.Theme;

/**
 * @author ceefour
 */
public class AndiaTheme extends Theme {

	/**
	 * Usable by "sub-themes". 
	 */
	public static final ResourceReference[] RESOURCES = new ResourceReference[] {
		BootstrapCssReference.INSTANCE,
		BootstrapResponsiveCssReference.INSTANCE,
		new CssResourceReference(AndiaTheme.class, "css/andia.css"),
		new CssResourceReference(AndiaTheme.class, "css/andia-tweak.css")
	};
	
	public AndiaTheme() {
		super("andia", RESOURCES);
	}

}
