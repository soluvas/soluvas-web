package org.soluvas.web.site.rs;

import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.jaxrs.JaxrsUtils;
import org.soluvas.json.JsonUtils;
import org.soluvas.web.site.webaddress.WebAddress;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

/**
 * Provides {@link WebAddress}.
 * @author ceefour
 */
@Path("org.soluvas.web.site")
public class SiteResource {
	
	private static final Logger log = LoggerFactory.getLogger(SiteResource.class);
	private transient BundleContext bundleContext;
	@Context 
	private transient UriInfo uriInfo;
	
	public SiteResource(BundleContext bundleContext) {
		super();
		this.bundleContext = bundleContext;
	}

	@GET @Path("webAddress.js")
	@Produces("text/javascript")
	public String getImageConfigs() {
		final TenantRef tenant = JaxrsUtils.getTenant(uriInfo);
		final WebAddress webAddress = TenantUtils.getSupplied(bundleContext, tenant, WebAddress.class);

		URL stgUrl = SiteResource.class.getResource("webAddress.stg");
		STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		ST configsSt = stg.getInstanceOf("webAddress");
		configsSt.add("webAddress", JsonUtils.asJson(webAddress));
		
		// render
		String renderedJs = configsSt.render(80);
		return renderedJs;
	}

}
