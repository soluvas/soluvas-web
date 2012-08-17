package org.soluvas.web.backbone;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import org.apache.wicket.util.io.IOUtils;

/**
 * @author ceefour
 *
 */
public class RequireResource {
	
	// http://localhost:8181/cxf/require/
	@GET @Produces("text/javascript")
	public String getRequireConfig() throws IOException {
		return IOUtils.toString( getClass().getResourceAsStream("/require_config.st") );
	}

}
