package org.soluvas.web.site.rs;

import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.jaxrs.JaxrsUtils;
import org.soluvas.json.JsonUtils;
import org.soluvas.web.site.webaddress.WebAddress;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.google.common.base.Supplier;

/**
 * Provides {@link WebAddress}.
 * @author ceefour
 */
@Path("org.soluvas.web.site")
public class SiteResource {
	
	private transient Logger log = LoggerFactory.getLogger(SiteResource.class);
	private transient BundleContext bundleContext;
	@Context 
	private transient UriInfo uriInfo;
	
	public SiteResource(BundleContext bundleContext) {
		super();
		this.bundleContext = bundleContext;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GET @Path("webAddress.js")
	@Produces("text/javascript")
	public String getImageConfigs() {
		final WebAddress webAddress;
		
		TenantRef tenant = JaxrsUtils.getTenant(uriInfo);
		final String filter = String.format("(&(suppliedClass=%s)(tenantId=%s)(tenantEnv=%s)",
				WebAddress.class.getName(), tenant.getTenantId(), tenant.getTenantEnv());
		try {
			ServiceReference<Supplier> ref = bundleContext.getServiceReferences(Supplier.class, filter).iterator().next();
			Supplier<WebAddress> webAddressSupplier = bundleContext.getService(ref);
			try {
				webAddress = webAddressSupplier.get();
			} finally {
				bundleContext.ungetService(ref);
			}
		} catch (InvalidSyntaxException e) {
			throw new RuntimeException("Cannot get Supplier with filter " + filter, e);
		}
		
		URL stgUrl = SiteResource.class.getResource("webAddress.stg");
		STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		ST configsSt = stg.getInstanceOf("webAddress");
		configsSt.add("webAddress", JsonUtils.asJson(webAddress));
		
		// render
		String renderedJs = configsSt.render(80);
		return renderedJs;
	}

}
