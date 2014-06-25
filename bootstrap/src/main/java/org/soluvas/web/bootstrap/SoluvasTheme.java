package org.soluvas.web.bootstrap;

import java.util.List;

import org.soluvas.web.site.ThemePref;

import com.google.common.collect.ImmutableList;

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
	private final ImmutableList<String> lessDependencies;

	/**
	 * @param name
	 * @param scope The scope {@link Class} of the theme.
	 * 		The main LESS file must be put under <code>{scopePackage}/{themeName}/css/theme-style.less.st</code>. 
	 * @param resourceReferences
	 */
	public SoluvasTheme(String name, Class<?> scope, Format format) {
		this(name, scope, format, ImmutableList.<String>of());
	}
	
	/**
	 * @param name
	 * @param scope The scope {@link Class} of the theme.
	 * 		The main LESS file must be put under <code>{scopePackage}/{themeName}/css/theme-style.less.st</code>. 
	 * @param resourceReferences
	 * @param lessDependencies LESS files that are import-ed from {@code theme-syle.less.st}.
	 * 		They must be declared because <a href="https://github.com/l0rdn1kk0n/wicket-bootstrap/issues/390">Less4j needs them to be in the same location, i.e. filesystem</a>.
	 * 		They will be copied to be filesystem also by {@link ThemeManagerImpl#doGenerateThemeStyle(String, String, ThemePref)}.
	 */
	public SoluvasTheme(String name, Class<?> scope, Format format, List<String> lessDependencies) {
		super(name);
		this.scope = scope;
		this.path = scope.getPackage().getName().replace('.', '/') + "/" + name;
		this.styleFormat = format;
		this.lessDependencies = ImmutableList.copyOf(lessDependencies);
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

	public ImmutableList<String> getLessDependencies() {
		return lessDependencies;
	}
	
}
