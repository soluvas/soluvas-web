package org.soluvas.web.site.shell; 

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.web.site.PermalinkCatalog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Show current {@link PermalinkCatalog}.
 *
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="perma", name="info", description="Show current PermalinkCatalog.")
public class PermaInfoCommand extends ExtCommandSupport {

	@Override
	protected Object doExecute() throws Exception {
		final PermalinkCatalog permalinkCatalog = getBean(PermalinkCatalog.class);
		return permalinkCatalog;
	}

}