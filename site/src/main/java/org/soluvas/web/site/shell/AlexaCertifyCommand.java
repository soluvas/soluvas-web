 package org.soluvas.web.site.shell; 

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.commons.AppManifest;
import org.soluvas.web.site.alexa.AlexaCertify;

/**
 * Show {@link AlexaCertify} configuration.
 *
 * @author ceefour
 */
@Command(scope="site", name="alexacertify", description="Show Alexa Certify configuration.")
public class AlexaCertifyCommand extends OsgiCommandSupport {

	@Override
	protected AlexaCertify doExecute() throws Exception {
		final AlexaCertify alexaCertify = getService(AlexaCertify.class,
				bundleContext.getServiceReference(AppManifest.class));
		return alexaCertify;
	}

}