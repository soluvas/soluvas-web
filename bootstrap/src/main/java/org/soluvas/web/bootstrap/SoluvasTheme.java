package org.soluvas.web.bootstrap;

import org.apache.wicket.request.resource.ResourceReference;
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
	 * 		For import-ing LESS files, <a href="https://github.com/l0rdn1kk0n/wicket-bootstrap/issues/390#issuecomment-47447065">please use absolute <code>classpath!</code></a>. 
	 * @param resourceReferences
	 */
	public SoluvasTheme(String name, Class<?> scope, Format format, final ResourceReference... resourceReferences) {
		super(name, resourceReferences);
		this.scope = scope;
		this.path = scope.getPackage().getName().replace('.', '/') + "/" + name;
		this.styleFormat = format;
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
