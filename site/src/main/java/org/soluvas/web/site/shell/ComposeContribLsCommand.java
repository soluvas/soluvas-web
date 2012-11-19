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
		System.out.println(ansi().render("@|negative_on %3s|%-45s|%-45s|%-40s|%-34s|@",
				"№", "Name", "Page", "Path", "Bundle"));
		int i = 0;
		final Collection<LiveContributor> origContributors = contributorRepo.findAll();
		final Collection<LiveContributor> sortedContributors = origContributors;
		for (LiveContributor contributor : sortedContributors) {
			final String contribSymbol;
			final String contribName;
			if (contributor instanceof ChildContributor) {
				contribSymbol = "@|bold,blue ✚|@";
				contribName = ((ChildContributor) contributor).getClassName();
			} else if (contributor instanceof ReplaceContributor) {
				contribSymbol = "@|bold,yellow ☛|@";
				contribName = ((ReplaceContributor) contributor).getClassName();
			} else if (contributor instanceof HideContributor) {
				contribSymbol = "@|bold,red ✖|@";
				contribName = contributor.getTargetPath();
			} else throw new RuntimeException("Unknown contributor " + contributor.getClass().getName() + " from " + contributor.getBundle().getSymbolicName());
			final String stateSymbol;
			switch (contributor.getState()) {
			case UNRESOLVED:
				stateSymbol = "@|bold,yellow ?|@";
				break;
			case FAILED:
				stateSymbol = "@|bold,red ✖|@";
				break;
			case RESOLVED:
				stateSymbol = "@|bold,green ▶|@";
				break;
			default:
				throw new IllegalArgumentException("Unknown contributor state: " + contributor.getState());
			}
			final Bundle bundle = contributor.getBundle();
			System.out.println(ansi().render("@|bold,black %3d||@" + contribSymbol + stateSymbol + "%-43s@|bold,black ||@%-45s@|bold,black ||@%-40s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, contribName, contributor.getPageClassName(), contributor.getTargetPath(),
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ contributors", i));
		return null;
	}

}
