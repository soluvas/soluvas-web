package org.soluvas.web.site.rs;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.wicket.util.io.IOUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.json.JsonUtils;
import org.soluvas.web.site.PermalinkCatalog;
import org.soluvas.web.site.SiteException;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * Provides {@link WebAddress}.
 * @author ceefour
 */
@Path("org.soluvas.web.site")
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
	
	private static final Logger log = LoggerFactory.getLogger(SiteResource.class);
	private final BundleContext bundleContext;
	private final String clientId;
	private final String tenantId;
	private final String tenantEnv;
	private final Supplier<WebAddress> webAddressSupplier;
	private final PermalinkCatalog permalinkCatalog;
	
	/**
	 * @param bundleContext
	 * @param clientId
	 * @param tenantId
	 * @param tenantEnv
	 */
	public SiteResource(BundleContext bundleContext, String clientId,
			String tenantId, String tenantEnv,
			Supplier<WebAddress> webAddressSupplier,
			@Nonnull final PermalinkCatalog permalinkCatalog) {
		super();
		this.bundleContext = bundleContext;
		this.clientId = clientId;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
		this.webAddressSupplier = webAddressSupplier;
		this.permalinkCatalog = permalinkCatalog;
	}

	@GET @Path("webAddress.js")
	@Produces("text/javascript")
	public String getImageConfigs() {
//		final TenantRef tenant = JaxrsUtils.getTenant(uriInfo);
//		final WebAddress webAddress = TenantUtils.getSupplied(bundleContext, tenant, WebAddress.class);
		final WebAddress webAddress = webAddressSupplier.get();

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
		final List<URL> resources = ImmutableList.copyOf(Iterators.forEnumeration(
				bundle.findEntries("templates_web", "*.mustache", false)));
		log.debug("Got {} Mustache templates: {}", resources.size(), resources);
		final Pattern namePattern = Pattern.compile(".*\\/([^/]+)\\.(mustache|handlebars)");
		final List<WebTemplate> templates = ImmutableList.copyOf(Lists.transform(resources, new Function<URL, WebTemplate>() {
			@Override @Nullable
			public WebTemplate apply(@Nullable URL input) {
				String body;
				try {
					body = IOUtils.toString(input.openStream());
				} catch (IOException e) {
					throw new SiteException("Cannot read template " + input, e);
				}
				final String fileName = input.getFile();
				final Matcher matcher = namePattern.matcher(fileName);
				Preconditions.checkState(matcher.matches(),
						"Template file name %s does not match %s",
						fileName, namePattern);
				final String name = matcher.group(1);
				return new WebTemplate(name, JsonUtils.asJson(body));
			}
		}));
		final URL stgUrl = SiteResource.class.getResource("templates.js.stg");
		final STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		final ST templatesSt = stg.getInstanceOf("templates");
		templatesSt.add("bundleName", bundleName);
		templatesSt.add("templates", templates);
		
		// render
		final String renderedJs = templatesSt.render(80);
		return renderedJs;
	}

}
