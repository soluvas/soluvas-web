 package org.soluvas.web.site.shell; 

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.web.site.alexa.AlexaCertify;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Show {@link AlexaCertify} configuration.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="site", name="alexacertify", description="Show Alexa Certify configuration.")
public class AlexaCertifyCommand extends ExtCommandSupport {

	@Override
	protected AlexaCertify doExecute() throws Exception {
		final AlexaCertify alexaCertify = getBean(AlexaCertify.class);
		return alexaCertify;
	}

}