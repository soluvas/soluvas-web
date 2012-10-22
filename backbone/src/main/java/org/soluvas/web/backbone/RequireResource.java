package org.soluvas.web.backbone;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;
import org.soluvas.web.site.JavaScriptModule;
import org.soluvas.web.site.JavaScriptShim;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

import com.google.common.collect.Ordering;

/**
 * @author ceefour
 *
 */
public class RequireResource {
	
	private List<JavaScriptModule> jsModules;
	private List<JavaScriptShim> jsShims;
	@Context UriInfo uriInfo;
	
	public RequireResource(List<JavaScriptModule> jsModules, List<JavaScriptShim> jsShims) {
		super();
		this.jsModules = jsModules;
		this.jsShims = jsShims;
	}

	private transient Logger log = LoggerFactory
			.getLogger(RequireResource.class);
	// http://localhost:8181/cxf/require/
	@GET @Produces("text/javascript")
	public String getRequireConfig(@Context HttpServletRequest httpReq) throws IOException {
		log.info("{} {}", uriInfo.getAbsolutePath().getPath(), uriInfo.getPath());
		
		STGroupFile stg = new STGroupFile(RequireResource.class.getResource("/require_config.stg"), "UTF-8", '$', '$');
		ST requireSt = stg.getInstanceOf("require");
		requireSt.add("modules", Ordering.natural().immutableSortedCopy(jsModules));
		requireSt.add("shims", Ordering.natural().immutableSortedCopy(jsShims));
		return requireSt.render(80);
	}

}
