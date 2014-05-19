package org.soluvas.web.site;

import org.apache.wicket.request.resource.CssResourceReference;

/**
 * <a href="http://fortawesome.github.io/Font-Awesome/icons/">Font Awesome</a> CSS reference.
 * @author ceefour
 */
public class FontAwesomeResourceReference extends CssResourceReference {

	private static final long serialVersionUID = 1L;
	public static final FontAwesomeResourceReference INSTANCE = new FontAwesomeResourceReference();

	/**
	 * @param scope
	 * @param name
	 */
	private FontAwesomeResourceReference() {
		super(FontAwesomeResourceReference.class, "font-awesome/css/font-awesome.css");
	}

}
