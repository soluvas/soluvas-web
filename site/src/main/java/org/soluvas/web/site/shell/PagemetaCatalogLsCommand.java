package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceReference;
import org.soluvas.web.site.pagemeta.PageMetaCatalog;
import org.soluvas.web.site.pagemeta.PageRuleCollection;

import com.google.common.base.Supplier;

/**
 * List registered {@link PageMetaCatalog}s.
 * @author ceefour
 */
@Command(scope="pagemeta", name="catalogls", description="List registered PageMetaCatalogs.")
public class PagemetaCatalogLsCommand extends OsgiCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Object doExecute() throws Exception {
		final Collection<ServiceReference<Supplier>> refs = bundleContext.getServiceReferences(Supplier.class,
				"(&(suppliedClass=org.soluvas.web.site.pagemeta.PageMetaCatalog)(layer=module))");
		System.out.println(ansi().render("@|negative_on %3s|%-50s|%-2s|%-34s|@",
				"№", "Name", "∑", "Bundle"));
		int i = 0;
		for (final ServiceReference<Supplier> ref : refs) {
			final Bundle bundle = ref.getBundle();
			final Supplier<PageRuleCollection> supplier = getService(Supplier.class, ref);
			int ruleCount = supplier.get().getRules().size();
//			final String contribSymbol;
//			final String contribName;
//			if (contributor instanceof ChildContributor) {
//				contribSymbol = "@|bold,blue ✚|@";
//				contribName = ((ChildContributor) contributor).getClassName();
//			} else if (contributor instanceof ReplaceContributor) {
//				contribSymbol = "@|bold,yellow ☛|@";
//				contribName = ((ReplaceContributor) contributor).getClassName();
//			} else if (contributor instanceof HideContributor) {
//				contribSymbol = "@|bold,red ✖|@";
//				contribName = contributor.getTargetPath();
//			} else throw new SiteException("Unknown contributor " + contributor.getClass().getName() + " from " + contributor.getBundle().getSymbolicName());
//			final String stateSymbol;
//			switch (contributor.getState()) {
//			case UNRESOLVED:
//				stateSymbol = "@|bold,yellow ?|@";
//				break;
//			case FAILED:
//				stateSymbol = "@|bold,red ✖|@";
//				break;
//			case RESOLVED:
//				stateSymbol = "@|bold,green ▶|@";
//				break;
//			default:
//				throw new IllegalArgumentException("Unknown contributor state: " + contributor.getState());
//			}
			System.out.println(ansi().render("@|bold,black %3d||@%-50s@|bold,black ||@%2d@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, supplier, ruleCount, bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ PageMetaCatalogs", i));
		return null;
	}

}
