package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.ServiceReference;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.web.site.SiteException;
import org.soluvas.web.site.pagemeta.ClassPageSelector;
import org.soluvas.web.site.pagemeta.PageDeclaration;
import org.soluvas.web.site.pagemeta.PageMetaCatalog;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageSelector;
import org.soluvas.web.site.pagemeta.SourcePageDeclaration;
import org.soluvas.web.site.pagemeta.UriPatternPageSelector;

import com.google.common.base.Strings;
import com.google.common.base.Supplier;

/**
 * List registered {@link PageRule}s.
 * @author ceefour
 */
@Command(scope="pagemeta", name="ls", description="List registered PageRules.")
public class PagemetaLsCommand extends TenantCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<Supplier> pageMetaCatalogSupplierRef = bundleContext.getServiceReferences(Supplier.class,
				"(&(suppliedClass=" + PageMetaCatalog.class.getName() + ")(layer=application))").iterator().next();
		final Supplier pageMetaCatalogSupplier = getService(Supplier.class, pageMetaCatalogSupplierRef);
		final PageMetaCatalog pageMetaCatalog = (PageMetaCatalog) pageMetaCatalogSupplier.get();
		System.out.println(ansi().render("@|negative_on %3s|%-30s|%4s|%-45s|%-40s|%-20s|@",
				"№", "Name", "Pos", "Page", "Path", "Bundle"));
		int i = 0;
		final EList<PageRule> pageRules = pageMetaCatalog.getRules();
		for (final PageRule pageRule : pageRules) {
			final PageSelector selector = pageRule.getSelector();
			final String selectorSymbol;
			final String selectorNameAnsi;
			if (selector instanceof UriPatternPageSelector) {
				selectorSymbol = "@|bold,blue ✎|@";
				final String pattern = ((UriPatternPageSelector) selector).getPattern();
				selectorNameAnsi = "@|bold " + Strings.padEnd(pattern, 29, ' ') + "|@";
			} else if (selector instanceof ClassPageSelector) {
				selectorSymbol = "@|bold,green ©|@";
				final String className = ((ClassPageSelector) selector).getClassName();
				selectorNameAnsi = NameUtils.shortenClassAnsi(className, 29);
			} else throw new SiteException("Unknown PageSelector " + selector);
			final PageDeclaration declaration = pageRule.getDeclaration();
			final String declarationSymbol;
			final String declarationName;
			if (declaration instanceof SourcePageDeclaration) {
				declarationSymbol = "@|bold,blue ▲|@";
				declarationName = ((SourcePageDeclaration) declaration).getSource().toString();
			} else throw new SiteException("Unknown PageDeclaration " + declaration);
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
			final String bundleAnsi = NameUtils.shortenBundleAnsi(pageRule.getBundle(), 20);
			// FIXME: Resource aware!
			System.out.println(ansi().render("@|bold,black %3d||@" + selectorSymbol + selectorNameAnsi + "@|bold,black ||@%4d@|bold,black ||@" + declarationSymbol + "%-44s@|bold,black ||@" + bundleAnsi,
				++i, pageRule.getPositioner(), declarationName ));
		}
		System.out.println(ansi().render("@|bold %d|@ contributors", i));
		return null;
	}

}
