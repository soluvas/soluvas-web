package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.commons.NameUtils;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.SiteException;
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
	
	private final CrudRepository<LiveContributor, Integer> contributorRepo;

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
		System.out.println(ansi().render("@|negative_on %3s|%-27s|%-25s|%-40s|%-20s|@",
				"№", "Name", "Page", "Path", "Bundle"));
		int i = 0;
		final Collection<LiveContributor> origContributors = contributorRepo.findAll();
		final Collection<LiveContributor> sortedContributors = origContributors;
		for (final LiveContributor contributor : sortedContributors) {
			final String contribSymbol;
			final String contribName;
			final String contribNameAnsi;
			if (contributor instanceof ChildContributor) {
				contribSymbol = "@|bold,blue ✚|@";
				contribName = ((ChildContributor) contributor).getClassName();
				contribNameAnsi = NameUtils.shortenClassAnsi(contribName, 25);
			} else if (contributor instanceof ReplaceContributor) {
				contribSymbol = "@|bold,yellow ☛|@";
				contribName = ((ReplaceContributor) contributor).getClassName();
				contribNameAnsi = NameUtils.shortenClassAnsi(contribName, 25);
			} else if (contributor instanceof HideContributor) {
				contribSymbol = "@|bold,red ✖|@";
				contribName = contributor.getTargetPath();
				contribNameAnsi = contribName.substring(0, 25);
			} else
				throw new SiteException("Unknown contributor " + contributor.getClass().getName() + " from " + contributor.getBundle().getSymbolicName());
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
			final String bundleAnsi = NameUtils.shortenBundleAnsi(contributor.getBundle(), 20);
			final String pageName = contributor.getPageClassName();
			final String pageNameAnsi = NameUtils.shortenClassAnsi(pageName, 25);
			System.out.println(ansi().render(
					"@|bold,black %3d||@" + contribSymbol + stateSymbol + contribNameAnsi + "@|bold,black ||@" + pageNameAnsi + "@|bold,black ||@%-40s@|bold,black ||@" + bundleAnsi,
				++i, contributor.getTargetPath() ));
		}
		System.out.println(ansi().render("@|bold %d|@ contributors", i));
		return null;
	}

}
