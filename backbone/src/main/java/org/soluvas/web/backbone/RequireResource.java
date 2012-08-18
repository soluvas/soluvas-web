package org.soluvas.web.backbone;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.soluvas.web.site.JavaScriptModule;
import org.soluvas.web.site.JavaScriptShim;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;

/**
 * @author ceefour
 *
 */
public class RequireResource {
	
	private List<JavaScriptModule> jsModules;
	private List<JavaScriptShim> jsShims;
	
	public RequireResource(List<JavaScriptModule> jsModules, List<JavaScriptShim> jsShims) {
		super();
		this.jsModules = jsModules;
		this.jsShims = jsShims;
	}

	// http://localhost:8181/cxf/require/
	@GET @Produces("text/javascript")
	public String getRequireConfig() throws IOException {
		STGroupFile stg = new STGroupFile(RequireResource.class.getResource("/require_config.stg"), "UTF-8", '$', '$');
		ST requireSt = stg.getInstanceOf("require");
		requireSt.add("modules", jsModules);
		requireSt.add("shims", jsShims);
		return requireSt.render(80);
	}

}
