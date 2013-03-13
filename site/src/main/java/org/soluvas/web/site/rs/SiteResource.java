package org.soluvas.web.site.rs;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.apache.wicket.util.io.IOUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.StyleConfiguration;
import org.soluvas.commons.WebAddress;
import org.soluvas.json.JsonUtils;
import org.soluvas.web.site.JavaScriptAlias;
import org.soluvas.web.site.JavaScriptMode;
import org.soluvas.web.site.JavaScriptModule;
import org.soluvas.web.site.JavaScriptShim;
import org.soluvas.web.site.PermalinkCatalog;
import org.soluvas.web.site.RequireManager;
import org.soluvas.web.site.SiteException;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

/**
 * Provides {@link WebAddress}.
 * @author ceefour
 */
//@Path("org.soluvas.web.site")
public class SiteResource {
	
	public static class WebTemplate {
		public String name;
		public String json;
		
		public WebTemplate(String name, String json) {
			super();
			this.name = name;
			this.json = json;
		}
	}
	
	public static class ModuleAlias {
		public String from;
		public String to;
		
		/**
		 * @param from
		 * @param to
		 */
		public ModuleAlias(String from, String to) {
			super();
			this.from = from;
			this.to = to;
		}
	}
	
	private static final Logger log = LoggerFactory.getLogger(SiteResource.class);
	/**
	 * Think of those people (like myself) on GPRS connections in remote areas.
	 */
	private static final int waitSeconds = 120;
	
	private final BundleContext bundleContext;
	private final WebAddress webAddress;
	private final PermalinkCatalog permalinkCatalog;
	private final StyleConfiguration styleConfig;
	
	private final List<JavaScriptAlias> jsAliases;
	private final List<JavaScriptModule> jsModules;
	private final List<JavaScriptShim> jsShims;
	private final RequireManager requireMgr;
	
	/**
	 * @param bundleContext
	 * @param clientId
	 * @param tenantId
	 * @param tenantEnv
	 */
	public SiteResource(BundleContext bundleContext, String clientId,
			String tenantId, String tenantEnv,
			WebAddress webAddress,
			@Nonnull final PermalinkCatalog permalinkCatalog,
			@Nonnull final StyleConfiguration styleConfig,
			@Nonnull final List<JavaScriptAlias> jsAliases,
			@Nonnull final List<JavaScriptModule> jsModules,
			@Nonnull final List<JavaScriptShim> jsShims,
			@Nonnull final RequireManager requireMgr) {
		super();
		this.bundleContext = bundleContext;
		this.webAddress = Preconditions.checkNotNull(webAddress,
				"webAddress cannot be null");
		this.permalinkCatalog = permalinkCatalog;
		this.styleConfig = styleConfig;
		this.jsAliases = jsAliases;
		this.jsModules = jsModules;
		this.jsShims = jsShims;
		this.requireMgr = requireMgr;
	}

	@GET @Path("webAddress.js")
	@Produces("text/javascript")
	public String getImageConfigs() {
//		final TenantRef tenant = JaxrsUtils.getTenant(uriInfo);
//		final WebAddress webAddress = TenantUtils.getSupplied(bundleContext, tenant, WebAddress.class);

		final URL stgUrl = SiteResource.class.getResource("webAddress.js.stg");
		final STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		final ST configsSt = stg.getInstanceOf("webAddress");
		configsSt.add("webAddress", JsonUtils.asJson(webAddress));
		
		// render
		final String renderedJs = configsSt.render(80);
		return renderedJs;
	}

	@GET @Path("permalinkConfigs.js")
	@Produces("text/javascript")
	public String getPermalinkConfigs() {
//		final TenantRef tenant = JaxrsUtils.getTenant(uriInfo);
//		final WebAddress webAddress = TenantUtils.getSupplied(bundleContext, tenant, WebAddress.class);

		final URL stgUrl = SiteResource.class.getResource("permalinkConfigs.js.stg");
		final STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		final ST configsSt = stg.getInstanceOf("permalinkConfigs");
		configsSt.add("permalinks", JsonUtils.asJson(permalinkCatalog.getPermalinks()));
		
		// render
		final String renderedJs = configsSt.render(80);
		return renderedJs;
	}

	/**
	 * Usage:
	 * 
	 * <pre>{@literal
	 * <service auto-export="interfaces">
	 * 	<bean class="org.soluvas.web.site.JavaScriptModuleImpl">
	 * 		<argument value="id.co.bippo.story.web/templates" />
	 * 		<argument value="org.soluvas.web.site/templates/id.co.bippo.story.web" />
	 * 		<argument value="org.soluvas.web.site/templates/id.co.bippo.story.web" />
	 * 		<argument value="DYNAMIC" />
	 * 	</bean>
	 * </service>
	 * }</pre>
	 * 
	 * @param bundleName
	 * @return
	 * @throws IOException
	 */
	@GET @Path("templates/{bundleName}.js")
	@Produces("text/javascript")
	public String getTemplates(@PathParam("bundleName") @Nonnull final String bundleName) throws IOException {
		final String defaultStyle = styleConfig.getDefaultStyle();
		final Bundle bundle;
		try {
			bundle = Iterables.find(Arrays.asList(bundleContext.getBundles()),
					new Predicate<Bundle>() {
				@Override
				public boolean apply(@Nullable Bundle input) {
					return bundleName.equals(input.getSymbolicName());
				}
			});
		} catch (final NoSuchElementException e) {
			throw new SiteException("Cannot find bundle " + bundleName, e);
		}
		List<URL> resources = ImmutableList.of();
		try {
			resources = ImmutableList.copyOf(Iterators.forEnumeration(
					bundle.findEntries("templates_web", "*.mustache", false)));
			log.debug("Got {} Mustache templates: {}", resources.size(), resources);
		} catch (NullPointerException e1) {
			log.warn("Cannot find any templates_web/*.mustache in bundle " + bundle.getSymbolicName(), e1);
		}
		final Pattern skinnedPattern = Pattern.compile(".*\\/([^/]+)\\_([a-z0-9]+)\\.(mustache|handlebars)");
		final Pattern generalPattern = Pattern.compile(".*\\/([^/]+)\\.(mustache|handlebars)");
		final Map<String, WebTemplate> templateMap = Maps.newHashMap();
		for (final URL input : resources) {
			final String fileName = input.getFile();
			final Matcher skinnedMatcher = skinnedPattern.matcher(fileName);
			final String name;
			final boolean overrideIfExists;
			if (skinnedMatcher.matches()) {
				if (!Objects.equal(defaultStyle, skinnedMatcher.group(2))) {
					log.trace("Skipping template {} because defaultStyle is {}", input, defaultStyle);
					continue;
				}
				name = skinnedMatcher.group(1);
				overrideIfExists = true;
			} else {
				final Matcher generalMatcher = generalPattern.matcher(fileName);
				Preconditions.checkState(generalMatcher.matches(),
						"Template file name %s does not match %s",
						fileName, generalPattern);
				name = generalMatcher.group(1);
				overrideIfExists = false;
			}
			final String body;
			try {
				body = IOUtils.toString(input.openStream());
			} catch (IOException e) {
				throw new SiteException("Cannot read template " + input, e);
			}
			final WebTemplate webTemplate = new WebTemplate(name, JsonUtils.asJson(body));
			if (overrideIfExists || !templateMap.containsKey(name)) {
				templateMap.put(name, webTemplate);
			}
		}
		final URL stgUrl = SiteResource.class.getResource("templates.js.stg");
		final STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		final ST templatesSt = stg.getInstanceOf("templates");
		templatesSt.add("bundleName", bundleName);
		templatesSt.add("templates", templateMap.values());
		
		// render
		final String renderedJs = templatesSt.render(80);
		return renderedJs;
	}

	// http://localhost:8181/cxf/api/org.soluvas.web.site/requireConfig.js
	@GET @Path("requireConfig.js")
	@Produces("text/javascript")
	public String getRequireConfig(@Nonnull @Context final HttpServletRequest httpReq) throws IOException {
//		TenantRef tenantInfo = JaxrsUtils.getTenantInfo(uriInfo);
//		log.debug("Get RequireJS config for {} {} tenant={}:{}", uriInfo.getAbsolutePath().getPath(), uriInfo.getPath(),
//				tenantInfo.getTenantId(), tenantInfo.getTenantId());
		
//		log.debug("Get RequireJS config for {} {}", uriInfo.getAbsolutePath().getPath(), uriInfo.getPath() );
		
		final STGroupFile stg = new STGroupFile(SiteResource.class.getResource("require_config.stg"), "UTF-8", '$', '$');
		final ST requireSt = stg.getInstanceOf("require");
		requireSt.add("urlArgs", Strings.isNullOrEmpty(requireMgr.getCacheBust()) ? "" :
			URLEncoder.encode(requireMgr.getCacheBust(), "UTF-8"));
		requireSt.add("waitSeconds", waitSeconds);
		requireSt.add("webAddress", webAddress);
		final List<ModuleAlias> aliases = Lists.newArrayList();
		for (final JavaScriptAlias alias : jsAliases) {
			switch (requireMgr.getJavaScriptMode()) {
			case DEVELOPMENT:
				if (alias.getDevelopmentTo() != null) {
					aliases.add( new ModuleAlias(alias.getFrom(), alias.getDevelopmentTo()) );
				}
				break;
			case MINIFIED:
			case AGGREGATED_MINIFIED:
				aliases.add( new ModuleAlias(alias.getFrom(), alias.getMinifiedTo()) );
				break;
			}
		}
		requireSt.add("aliases", aliases);
		final List<Map<String, String>> preparedModules = Lists.transform( Ordering.natural().immutableSortedCopy(jsModules), new Function<JavaScriptModule, Map<String, String>>() {
			@Override @Nullable
			public Map<String, String> apply(@Nullable JavaScriptModule input) {
				String path;
				switch (input.getBase()) {
				case STATIC:
					path = Preconditions.checkNotNull(requireMgr.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT ? input.getPath() : Optional.fromNullable(input.getMinifiedPath()).or(input.getPath()),
							"Cannot get path for JavaScriptModule %s", input.getName());
					break;
				case DYNAMIC:
					path = webAddress.getApiPath() + input.getPath();
					break;
				default:
					throw new IllegalArgumentException("Unknown JavaScriptModule Base: " + input.getBase());
				}
				return ImmutableMap.of("name", input.getName(), "path", path);
			}
		});
		requireSt.add("modules", preparedModules);
		requireSt.add("shims", Ordering.natural().immutableSortedCopy(jsShims));
		return requireSt.render(80);
	}

}
