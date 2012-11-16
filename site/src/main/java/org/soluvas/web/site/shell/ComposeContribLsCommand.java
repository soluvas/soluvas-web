package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.Bundle;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.compose.ChildContributor;
import org.soluvas.web.site.compose.Contributor;
import org.soluvas.web.site.compose.HideContributor;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.compose.ReplaceContributor;

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
		System.out.println(ansi().render("@|negative_on %3s|%-40s|%-40s|%-20s|%-10s|%-34s|@",
				"№", "Page", "Path", "Type", "State", "Bundle"));
		int i = 0;
		final Collection<LiveContributor> origContributors = contributorRepo.findAll();
		final Collection<LiveContributor> sortedContributors = origContributors;
		for (LiveContributor contributor : sortedContributors) {
			final String contribSymbol;
			if (contributor instanceof ChildContributor) {
				contribSymbol = "@|bold,blue ✚|@"; 
			} else if (contributor instanceof ReplaceContributor) {
				contribSymbol = "@|bold,yellow ☛|@";
			} else if (contributor instanceof HideContributor) {
				contribSymbol = "@|bold,red ✖|@";
			} else throw new RuntimeException("Unknown contributor " + contributor.getClass().getName() + " from " + contributor.getBundle().getSymbolicName());
			Bundle bundle = contributor.getBundle();
			System.out.println(ansi().render("@|bold,black %3d||@%-40s@|bold,black ||@" + contribSymbol + "%-39s@|bold,black ||@%-10s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, contributor.getPageClassName(), contributor.getTargetPath(), contributor.getState(),
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ contributors", i));
		return null;
	}

}
