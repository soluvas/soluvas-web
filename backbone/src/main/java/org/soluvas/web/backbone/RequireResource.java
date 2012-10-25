package org.soluvas.web.backbone;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.JavaScriptModule;
import org.soluvas.web.site.JavaScriptModule.Base;
import org.soluvas.web.site.JavaScriptShim;
import org.soluvas.web.site.webaddress.WebAddress;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * @author ceefour
 *
 */
public class RequireResource {
	
	private List<JavaScriptModule> jsModules;
	private List<JavaScriptShim> jsShims;
	private transient Supplier<WebAddress> webAddressSupplier;
	@Context UriInfo uriInfo;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RequireResource(Supplier<WebAddress> webAddressSupplier, List<JavaScriptModule> jsModules, List<JavaScriptShim> jsShims) {
		super();
		this.webAddressSupplier = webAddressSupplier;
		this.jsModules = jsModules;
		this.jsShims = jsShims;
	}

	private transient Logger log = LoggerFactory
			.getLogger(RequireResource.class);
	// http://localhost:8181/cxf/require/
	@GET @Produces("text/javascript")
	public String getRequireConfig(@Context HttpServletRequest httpReq) throws IOException {
//		TenantRef tenantInfo = JaxrsUtils.getTenantInfo(uriInfo);
//		log.debug("Get RequireJS config for {} {} tenant={}:{}", uriInfo.getAbsolutePath().getPath(), uriInfo.getPath(),
//				tenantInfo.getTenantId(), tenantInfo.getTenantId());
		
//		log.debug("Get RequireJS config for {} {}", uriInfo.getAbsolutePath().getPath(), uriInfo.getPath() );
		
		STGroupFile stg = new STGroupFile(RequireResource.class.getResource("/require_config.stg"), "UTF-8", '$', '$');
		ST requireSt = stg.getInstanceOf("require");
		final WebAddress webAddress = webAddressSupplier.get();
		requireSt.add("webAddress", webAddress);
		List<Map<String, String>> preparedModules = Lists.transform( Ordering.natural().immutableSortedCopy(jsModules), new Function<JavaScriptModule, Map<String, String>>() {
			@Override
			@Nullable
			public Map<String, String> apply(@Nullable JavaScriptModule input) {
				String path;
				switch (input.getBase()) {
				case STATIC:
					path = input.getPath();
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
