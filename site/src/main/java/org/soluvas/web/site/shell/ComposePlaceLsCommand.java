package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.ExtCommandSupport;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.annotation.PlaceholderRelated;
import org.soluvas.web.site.compose.LivePlaceholder;
import org.soluvas.web.site.compose.Placeholder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * List registered {@link Placeholder}s.
 * @author ceefour
 */
@Service @Scope("prototype")
@Command(scope="compose", name="placels", description="List registered Placeholders.")
public class ComposePlaceLsCommand extends ExtCommandSupport {
	
	@Inject
	public ComposePlaceLsCommand() {
		super();
	}
	
	@Override
	protected Object doExecute() throws Exception {
		final CrudRepository<LivePlaceholder, String> placeholderRepo = getBean(CrudRepository.class, PlaceholderRelated.class);
		System.out.println(ansi().render("@|negative_on %3s|%-25s|%-40s|%-25s|%-20s|@",
				"№", "Page", "Path", "IModel", "Bundle"));
		int i = 0;
		final Collection<LivePlaceholder> origPlaceholders = placeholderRepo.findAll();
		final Collection<LivePlaceholder> sortedPlaceholders = origPlaceholders;
		for (LivePlaceholder placeholder : sortedPlaceholders) {
			final String bundleAnsi = NameUtils.shortenBundleAnsi(placeholder.getBundle(), 20);
			final String pageName = placeholder.getPageClassName();
			final String pageNameAnsi = NameUtils.shortenClassAnsi(pageName, 25);
			final String modelName = placeholder.getModelClassName();
			final String modelNameAnsi = NameUtils.shortenClassAnsi(modelName, 25);
			System.out.println(ansi().render("@|bold,black %3d||@" + pageNameAnsi + "@|bold,black ||@%-40s@|bold,black ||@" + modelNameAnsi + "@|bold,black ||@" + bundleAnsi,
				++i, placeholder.getPath() ));
		}
		System.out.println(ansi().render("@|bold %d|@ placeholders", i));
		return null;
	}

}
