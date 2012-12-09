package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.Bundle;
import org.soluvas.commons.NameUtils;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.compose.LivePlaceholder;
import org.soluvas.web.site.compose.Placeholder;

/**
 * List registered {@link Placeholder}s.
 * @author ceefour
 */
@Command(scope="compose", name="placels", description="List registered Placeholders.")
public class ComposePlaceLsCommand extends OsgiCommandSupport {
	
	private final transient CrudRepository<LivePlaceholder, Integer> placeholderRepo;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ComposePlaceLsCommand(CrudRepository placeholderRepo) {
		super();
		this.placeholderRepo = placeholderRepo;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-25s|%-40s|%-25s|%-34s|@",
				"№", "Page", "Path", "IModel", "Bundle"));
		int i = 0;
		final Collection<LivePlaceholder> origPlaceholders = placeholderRepo.findAll();
		final Collection<LivePlaceholder> sortedPlaceholders = origPlaceholders;
		for (LivePlaceholder placeholder : sortedPlaceholders) {
			final Bundle bundle = placeholder.getBundle(); // TODO: Use BundleAware, and either use bridge pattern or merge into one class
			final String pageName = placeholder.getPageClassName();
			final String pageNameAnsi = NameUtils.shortenClassAnsi(pageName, 25);
			final String modelName = placeholder.getModelClassName();
			final String modelNameAnsi = NameUtils.shortenClassAnsi(modelName, 25);
			System.out.println(ansi().render("@|bold,black %3d||@" + pageNameAnsi + "@|bold,black ||@%-40s@|bold,black ||@" + modelNameAnsi + "@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, placeholder.getPath(),
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ placeholders", i));
		return null;
	}

}
