package org.soluvas.web.site.rs;

import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private transient Supplier<WebAddress> webAddressSupplier;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SiteResource(final Supplier webAddressSupplier) {
		super();
		this.webAddressSupplier = (Supplier<WebAddress>) webAddressSupplier;
	}

	@GET @Path("webAddress.js")
	@Produces("text/javascript")
	public String getImageConfigs() {
		WebAddress webAddress = webAddressSupplier.get();
		
		URL stgUrl = SiteResource.class.getResource("webAddress.stg");
		STGroupFile stg = new STGroupFile(stgUrl, "UTF-8", '~', '~');
		ST configsSt = stg.getInstanceOf("webAddress");
		configsSt.add("webAddress", JsonUtils.asJson(webAddress));
		
		// render
		String renderedJs = configsSt.render(80);
		return renderedJs;
	}

}
