package org.soluvas.web.backbone;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.soluvas.commons.WebAddress;
import org.soluvas.web.site.JavaScriptAlias;
import org.soluvas.web.site.JavaScriptMode;
import org.soluvas.web.site.JavaScriptModule;
import org.soluvas.web.site.JavaScriptShim;
import org.soluvas.web.site.RequireManager;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * @author ceefour
 *
 */
//@Path("org.soluvas.web.backbone")
public class BackboneResource {
	
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
	
	private final List<JavaScriptAlias> jsAliases;
	private final List<JavaScriptModule> jsModules;
	private final List<JavaScriptShim> jsShims;
	private final WebAddress webAddress;
	private @Context UriInfo uriInfo;
	private final RequireManager requireMgr;
	/**
	 * Think of those people (like myself) on GPRS connections in remote areas.
	 */
	private final int waitSeconds = 120;
	
	public BackboneResource(@Nonnull final WebAddress webAddress,
			@Nonnull final List<JavaScriptAlias> jsAliases,
			@Nonnull final List<JavaScriptModule> jsModules,
			@Nonnull final List<JavaScriptShim> jsShims,
			@Nonnull final RequireManager requireMgr) {
		super();
		this.webAddress = webAddress;
		this.jsAliases = jsAliases;
		this.jsModules = jsModules;
		this.jsShims = jsShims;
		this.requireMgr = requireMgr;
	}

	// http://localhost:8181/cxf/api/berbatik_dev/org.soluvas.web.backbone/requireConfig.js
	@GET @Path("requireConfig.js")
	@Produces("text/javascript")
	public String getRequireConfig(@Nonnull @Context final HttpServletRequest httpReq) throws IOException {
//		TenantRef tenantInfo = JaxrsUtils.getTenantInfo(uriInfo);
//		log.debug("Get RequireJS config for {} {} tenant={}:{}", uriInfo.getAbsolutePath().getPath(), uriInfo.getPath(),
//				tenantInfo.getTenantId(), tenantInfo.getTenantId());
		
//		log.debug("Get RequireJS config for {} {}", uriInfo.getAbsolutePath().getPath(), uriInfo.getPath() );
		
		final STGroupFile stg = new STGroupFile(BackboneResource.class.getResource("require_config.stg"), "UTF-8", '$', '$');
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
