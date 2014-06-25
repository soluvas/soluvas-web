package org.soluvas.web.bootstrap;

import org.soluvas.web.site.ThemePref;

import de.agilecoders.wicket.core.settings.ITheme;
import de.agilecoders.wicket.core.settings.Theme;

/**
 * Wicket-Bootstrap {@link ITheme} with support for {@link ThemePref}-customizable LESS.
 * @author ceefour
 */
public class SoluvasTheme extends Theme {
	
	public static enum Format {
		/**
		 * e.g. web-pub_{style}.css
		 * 
		 * <p>Does not support customization via {@link ThemePref}.
		 */
		CSS,
		/**
		 * <p>Source: <code>{package}/{themeName}/css/theme-style.less.st</code>
		 * <p>Generated: <code>{package}/{themeName}/css/theme-style-{tenantId}.less</code>
		 * 
		 * <p>Supports customization via {@link ThemePref}. 
		 */
		LESS
	}

	private final Format styleFormat;
	private final String path;
	private final Class<?> scope;

	/**
	 * @param name
	 * @param scope The scope {@link Class} of the theme.
	 * 		The main LESS file must be put under <code>{scopePackage}/{themeName}/css/theme-style.less.st</code>. 
	 * @param resourceReferences
	 */
	public SoluvasTheme(String name, Class<?> scope, Format styleFormat) {
		super(name);
		this.scope = scope;
		this.path = scope.getPackage().getName().replace('.', '/') + name;
		this.styleFormat = styleFormat;
	}
	
	/**
	 * The scope {@link Class} of the theme.
	 * The main LESS file is put under <code>{scopePackage}/{themeName}/css/theme-style.less.st</code>.
	 * 
	 * @return
	 */
	public Class<?> getScope() {
		return scope;
	}
	
	/**
	 * The scope {@link Class} of the theme as path, <b>without</b> leading '/'.
	 * The main LESS file is put under <code>{scopePackage}/{themeName}/css/theme-style.less.st</code>.
	 * 
	 * @return
	 */
	public String getPath() {
		return path;
	}
	
	public Format getStyleFormat() {
		return styleFormat;
	}

}
