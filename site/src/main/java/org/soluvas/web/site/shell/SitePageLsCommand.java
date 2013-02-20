package org.soluvas.web.site.shell;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.web.site.Page;
import org.soluvas.web.site.Section;
import org.soluvas.web.site.SiteCatalog;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * List registered (Wicket) {@link Page}s.
 * @author ceefour
 */
@Command(scope="site", name="pagels", description="List registered (Wicket) pages.")
public class SitePageLsCommand extends OsgiCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final SiteCatalog siteCatalog = getService(SiteCatalog.class, bundleContext.getServiceReference(SiteCatalog.class));
		final List<String> sectionFmts = Lists.transform(siteCatalog.getSections(), new Function<Section, String>() {
			@Override
			@Nullable
			public String apply(@Nullable Section section) {
				return section.getId() + " (" + section.getName() + ")";
			}
		});
		System.out.format("%d sections: %s\n", sectionFmts.size(), Joiner.on(", ").join(sectionFmts));
		
		final List<Page> concatPages = ImmutableList.copyOf(Iterables.concat(Lists.transform(siteCatalog.getSections(), new Function<Section, List<Page>>() {
			@Override
			@Nullable
			public List<Page> apply(@Nullable Section section) {
				return section.getPages();
			}
		})));
		
		System.out.format("%3s | %-20s | %-35s | %-20s | %s\n",
				"#", "Name", "Mount Point", "Type", "Section" );
		
		int i = 0;
		for (final Page it : concatPages) {
			// TODO: use locale settings to format date, currency, amount, "and", many
			// TODO: format products
			System.out.format("%3d | %-20s | %-35s | %-20s | %s\n",
				++i, it.getName(), it.getMountPoint(), it.eClass().getName(), it.getSection().getId() );
		}
		System.out.format("%d pages in %d sections\n", concatPages.size(), sectionFmts.size());

		return null;
	}

}
