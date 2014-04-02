package org.soluvas.web.site;

import org.apache.wicket.request.resource.CssResourceReference;
import org.soluvas.geo.Country;

/**
 * Used for showing {@link Country} flags, using <a href="http://flag-sprites.com/">flag-sprites.com</a>.
 * 
 * <pre>{@code
 * <img src="blank.gif" class="flag flag-cz" alt="Czech Republic" />
 * }</pre>
 * 
 * @author rudi
 */
public class FlagsCssResourceReference extends CssResourceReference {

	private static final long serialVersionUID = 1L;
	
	public static FlagsCssResourceReference INSTANCE = new FlagsCssResourceReference();
	
	public FlagsCssResourceReference() {
		super(Country.class, "flags.css");
	}

}
