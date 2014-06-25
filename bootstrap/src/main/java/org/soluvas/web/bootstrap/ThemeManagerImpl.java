package org.soluvas.web.bootstrap;

import java.io.File;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.util.time.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantRepositoryListener;
import org.soluvas.commons.tenant.TenantXmiBeans;
import org.soluvas.commons.tenant.TenantsStarting;
import org.soluvas.commons.tenant.TenantsStopping;
import org.soluvas.web.site.SiteException;
import org.soluvas.web.site.SitePackage;
import org.soluvas.web.site.ThemePref;
import org.springframework.beans.factory.annotation.Autowired;
import org.stringtemplate.v4.ST;

import com.google.common.base.Charsets;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import de.agilecoders.wicket.less.LessResourceStream;

/**
 * Manage Themes and {@link ThemePref} for all tenants.
 * {@link TenantRepository} is supported but not required.
 * @author anton
 */
public class ThemeManagerImpl implements TenantRepositoryListener, ThemeManager {

	private static final Logger log = LoggerFactory
			.getLogger(ThemeManagerImpl.class);
//	private final Map<String, AppManifest> initialTenantIds;
	
	@Autowired(required=false)
	private TenantRepository<?> tenantRepo;
	@Inject
	private TenantXmiBeans<? extends ThemePref> themePrefs;

	private final Map<String, SoluvasTheme> themes = new LinkedHashMap<>();
	private final SoluvasTheme defaultTheme;
	private final File classesDir;
	private final Map<String, AppManifest> initialTenantIds;

	/**
	 * @param classesDir The filesystem path that corresponds to <code>$CATALINA_HOME/webapps/{context}/WEB-INF/classes</code>.
	 * 		You can get this using {@link Class#getResource(String)} (of a root WAR resource) then {@link URL#toURI()}
	 * 		then {@link File#File(java.net.URI)} then {@link File#getParentFile()} (which works even on non-servlet environments),
	 * 		or {@link ServletContext#getRealPath(String)}. However that's
	 * 		<a href="http://stackoverflow.com/a/18163288/122441">an assumption that works on Tomcat, but may not work in other servers</a>.
	 * @param defaultTheme
	 * @param initialTenantIds
	 */
	public ThemeManagerImpl(File classesDir, SoluvasTheme defaultTheme, Map<String, AppManifest> initialTenantIds) {
		super();
		this.classesDir = classesDir;
		this.defaultTheme = defaultTheme;
		themes.put(defaultTheme.name(), defaultTheme);
		this.initialTenantIds = initialTenantIds;
		log.info("Initializing ThemeManager classes={} defaultTheme={} and {} initial tenants: {}",
				classesDir, defaultTheme.name(), initialTenantIds.size(), initialTenantIds.keySet());
	}
	
	@PostConstruct
	public void init() {
		LinkedHashMap<String, File> generateds = new LinkedHashMap<>();
		for (Map.Entry<String, AppManifest> tenant : initialTenantIds.entrySet()) {
			final String tenantId = tenant.getKey();
			final String realStyle = Optional.fromNullable(tenant.getValue().getDefaultStyle()).or(defaultTheme.name());
			Optional<File> generated = doGenerateThemeStyle(tenantId, realStyle, themePrefs.getExpanded(tenantId));
			generateds.put(tenantId, generated.orNull());
		}
		log.info("Generated {} tenant theme style files: {}", generateds.size(), generateds);
	}
	
	/**
	 * Register a theme. 
	 * @param theme
	 */
	public void addTheme(SoluvasTheme theme) {
		themes.put(theme.name(), theme);
	}
	
	/**
	 * Regenerates <code>theme-style-{tenantId}.less</code> in classpath.
	 * @param tenantId
	 * @return TODO
	 */
	protected Optional<File> doGenerateThemeStyle(String tenantId, String style, ThemePref themePref) {
		Preconditions.checkArgument(themes.containsKey(style),
				"Theme '%s' for tenant '%s' not available. %s available themes: %s",
				style, tenantId, themes.size(), themes.keySet());
		final SoluvasTheme theme = themes.get(style);
		if (theme.getStyleFormat() != SoluvasTheme.Format.LESS) {
			log.debug("Theme '{}' for tenant '{}' is {} format, no need to regenerate",
					style, tenantId, theme.getStyleFormat());
			return Optional.absent();
		}
		String themeStPath = theme.name() + "/css/theme-style.less.st";
		URL themeStUrl = theme.getScope().getResource(themeStPath);
		Preconditions.checkNotNull(themeStUrl, "Cannot find LESS template '%s' using '%s' for style '%s' tenant '%s'",
				themeStPath, theme.getScope(), style, tenantId);
		// You cannot derive from Class.getResource URL, because in WAR you need to use WEB-INF/classes
		File tenantLessFile = new File(classesDir, theme.getPath() + "/css/theme-style-" + tenantId + ".less");
		log.debug("{}» Generating theme '{}' LESS '{}' from '{}'",
				tenantId, style, tenantLessFile, themeStUrl);
		try {
			ST st = new ST(IOUtils.toString(themeStUrl), '$', '$');
			st.add("tenantId", tenantId);
			st.add("style", style);
			st.add(SitePackage.Literals.THEME_PREF__NAVBAR_COLOR.getName(), themePref.getNavbarColor());
			st.add(SitePackage.Literals.THEME_PREF__NAVBAR_TEXT_COLOR.getName(), themePref.getNavbarTextColor());
			st.add(SitePackage.Literals.THEME_PREF__OUTLINE_COLOR.getName(), themePref.getOutlineColor());
			st.add(SitePackage.Literals.THEME_PREF__BACKGROUND_COLOR.getName(), themePref.getBackgroundColor());
			st.add(SitePackage.Literals.THEME_PREF__HIGHLIGHT_COLOR.getName(), themePref.getHighlightColor());
			String rendered = st.render();
			FileUtils.write(tenantLessFile, rendered, Charsets.UTF_8);
			return Optional.of(tenantLessFile);
		} catch (Exception e) {
			throw new SiteException(e, "%s» Cannot generate theme '%s' LESS '%s' from '%s'",
					tenantId, style, tenantLessFile, themeStUrl);
		}
	}
	
	@Override
	public Optional<File> generateThemeStyle(String tenantId, @Nullable String upStyle, ThemePref themePref) {
		final String realStyle = Optional.fromNullable(upStyle).or(defaultTheme.name());
		Optional<File> out = doGenerateThemeStyle(tenantId, realStyle, themePref);
		if (out.isPresent()) {
			log.info("{}» Generated theme '{}' LESS '{}'",
					tenantId, realStyle, out.get());
		}
		return out;
	}

	@Override
	public void renderThemeStyle(String tenantId, String style, IHeaderResponse response) {
		Preconditions.checkArgument(themes.containsKey(style),
				"Theme '%s' for tenant '%s' not available. %s available themes: %s",
				style, tenantId, themes.size(), themes.keySet());
		SoluvasTheme theme = themes.get(style);
		if (theme.getStyleFormat() != SoluvasTheme.Format.LESS) {
			log.trace("Theme '{}' for tenant '{}' is {} format, no need to render theme style",
					style, tenantId, theme.getStyleFormat());
			return;
		}
		String tenantLessPath = theme.name() + "/css/theme-style-" + tenantId + ".less";
		final AfterBootstrapLessResourceReference resourceRef = new AfterBootstrapLessResourceReference(theme.getScope(), tenantLessPath);
		if (log.isDebugEnabled()) {
			response.render(resourceRef.asHeaderItem());
			LessResourceStream stream = (LessResourceStream) resourceRef.getResource().getResourceStream();
			Time modificationTime = stream.lastModifiedTime();
			log.debug("Last modified for {}: {}", tenantLessPath, modificationTime);
		}
	}

	@Override
	public void onTenantsStarting(TenantsStarting starting) throws Exception {
		for (Map.Entry<String, AppManifest> tenant : starting.getAddeds().entrySet()) {
			final String style;
			if (tenant.getValue().getDefaultStyle() != null) {
				Preconditions.checkArgument(themes.containsKey(tenant.getValue().getDefaultStyle()),
						"Theme '%s' for tenant '%s' not available. %s available themes: %s",
						tenant.getValue().getDefaultStyle(), tenant.getKey(), themes.size(), themes.keySet());
				style = themes.get(tenant.getValue().getDefaultStyle()).name();
			} else {
				style = defaultTheme.name();
			}
			doGenerateThemeStyle(tenant.getKey(), style, themePrefs.getExpanded(tenant.getKey()));
		}
	}

	@Override
	public void onTenantsStopping(TenantsStopping stopping) throws Exception {
	}
	
	@Override
	public Map<String, SoluvasTheme> getThemes() {
		return ImmutableMap.copyOf(themes);
	}
	
	@Override
	public SoluvasTheme getDefaultTheme() {
		return defaultTheme;
	}

}
