package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.Bundle;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.compose.Contributor;
import org.soluvas.web.site.compose.LiveContributor;

/**
 * List registered {@link Contributor}s.
 * @author ceefour
 */
@Command(scope="compose", name="placels", description="List registered Contributors.")
public class ComposeContribLsCommand extends OsgiCommandSupport {
	
	private final transient CrudRepository<LiveContributor, Integer> contributorRepo;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ComposeContribLsCommand(CrudRepository contributorRepo) {
		super();
		this.contributorRepo = contributorRepo;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-40s|%-40s|%-10s|%-34s|@",
				"№", "Page", "Path", "State", "Bundle"));
		int i = 0;
		final Collection<LiveContributor> origContributors = contributorRepo.findAll();
		final Collection<LiveContributor> sortedContributors = origContributors;
		for (LiveContributor contributor : sortedContributors) {
			Bundle bundle = contributor.getBundle();
			System.out.println(ansi().render("@|bold,black %3d||@%-40s@|bold,black ||@%-40s@|bold,black ||@%-10s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, contributor.getPageClassName(), contributor.getTargetPath(), contributor.getState(),
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ contributors", i));
		return null;
	}

}
