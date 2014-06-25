package org.soluvas.web.bootstrap;

import java.util.Locale;

import de.agilecoders.wicket.core.markup.html.themes.bootstrap.BootstrapCssReference;
import de.agilecoders.wicket.less.LessResourceReference;

/**
 * A {@link LessResourceReference} that requires {@link BootstrapCssReference}.
 * @author mahendri
 * @deprecated kayanya gak jadi, pake {@link ThemeManager} aja
 */
@Deprecated
public class DynamicLessResourceReference extends AfterBootstrapLessResourceReference {

	private static final long serialVersionUID = 1L;

	/**
	 * @param key
	 */
	public DynamicLessResourceReference(Key key) {
		super(key);
	}

	/**
	 * @param scope
	 * @param name
	 */
	public DynamicLessResourceReference(Class<?> scope, String name) {
		super(scope, name);
	}

	/**
	 * @param scope
	 * @param name
	 * @param locale
	 * @param style
	 * @param variation
	 */
	public DynamicLessResourceReference(Class<?> scope, String name,
			Locale locale, String style, String variation) {
		super(scope, name, locale, style, variation);
	}
	
	@Override
	public DynamicLessPackageResource getResource() {
		return new DynamicLessPackageResource(getScope(), getName(), getLocale(), getStyle(), getVariation());
	}
	
}
