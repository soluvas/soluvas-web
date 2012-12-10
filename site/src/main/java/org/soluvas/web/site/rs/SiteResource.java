package org.soluvas.web.site.rs;

import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;
import org.soluvas.web.site.PermalinkCatalog;
import org.soluvas.web.site.webaddress.WebAddress;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;

/**
 * Provides {@link WebAddress}.
 * @author ceefour
 */
@Path("org.soluvas.web.site")
public class SiteResource {
	
	private static final Logger log = LoggerFactory.getLogger(SiteResource.class);
	private final BundleContext bundleContext;
	private final String clientId;
	private final String tenantId;
	private final String tenantEnv;
	private final Supplier<WebAddress> webAddressSupplier;
	private final Supplier<PermalinkCatalog> permalinkCatalogSupplier;
	
	/**
	 * @param bundleContext
	 * @param clientId
	 * @param tenantId
	 * @param tenantEnv
	 */
	public SiteResource(BundleContext bundleContext, String clientId,
			String tenantId, String tenantEnv,
			Supplier<WebAddress> webAddressSupplier,
			Supplier<PermalinkCatalog> permalinkCatalogSupplier) {
		super();
		this.bundleContext = bundleContext;
		this.clientId = clientId;
		this.tenantId = tenantId;
		this.tenantEnv = tenantEnv;
		this.webAddressSupplier = webAddressSupplier;
		this.permalinkCatalogSupplier = permalinkCatalogSupplier;
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
		final PermalinkCatalog permalinkCatalog = Preconditions.checkNotNull(permalinkCatalogSupplier.get(),
				"Supplied permalinkCatalog cannot be null");

		final URL stgUrl = SiteResource.class.getResource("permalinkConfigs.js.stg");
		final STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		final ST configsSt = stg.getInstanceOf("permalinkConfigs");
		configsSt.add("permalinks", JsonUtils.asJson(permalinkCatalog.getPermalinks()));
		
		// render
		final String renderedJs = configsSt.render(80);
		return renderedJs;
	}

}
