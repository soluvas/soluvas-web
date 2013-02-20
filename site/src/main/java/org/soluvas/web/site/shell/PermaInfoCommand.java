 package org.soluvas.web.site.shell; 

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.web.site.PermalinkCatalog;

/**
 * Show current {@link PermalinkCatalog}.
 *
 * @author ceefour
 */
@Command(scope="perma", name="info", description="Show current PermalinkCatalog.")
public class PermaInfoCommand extends OsgiCommandSupport {

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final PermalinkCatalog featuredShop = getService(PermalinkCatalog.class, 
				bundleContext.getServiceReference(PermalinkCatalog.class));
		return featuredShop;
	}

}