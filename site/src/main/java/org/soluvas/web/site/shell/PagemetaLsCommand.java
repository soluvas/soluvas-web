package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.Bundle;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.inject.Supplied;
import org.soluvas.commons.shell.TenantCommandSupport;
import org.soluvas.web.site.pagemeta.ClassPageSelector;
import org.soluvas.web.site.pagemeta.PageDeclaration;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageRuleCollection;
import org.soluvas.web.site.pagemeta.PageSelector;
import org.soluvas.web.site.pagemeta.SourcePageDeclaration;
import org.soluvas.web.site.pagemeta.UriPatternPageSelector;

import com.google.common.base.Strings;

/**
 * List registered {@link PageRule}s.
 * @author ceefour
 */
@Command(scope="pagemeta", name="ls", description="List registered PageRules.")
public class PagemetaLsCommand extends TenantCommandSupport {
	
	@Inject @Supplied
	private PageRuleCollection pageRuleCollection;

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-30s|%4s|%-45s|%-40s|%-34s|@",
				"№", "Name", "Pos", "Page", "Path", "Bundle"));
		int i = 0;
		final EList<PageRule> pageRules = pageRuleCollection.getRules();
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
			} else throw new RuntimeException("Unknown PageSelector " + selector);
			final PageDeclaration declaration = pageRule.getDeclaration();
			final String declarationSymbol;
			final String declarationName;
			if (declaration instanceof SourcePageDeclaration) {
				declarationSymbol = "@|bold,blue ▲|@";
				declarationName = ((SourcePageDeclaration) declaration).getSource().toString();
			} else throw new RuntimeException("Unknown PageDeclaration " + declaration);
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
//			} else throw new RuntimeException("Unknown contributor " + contributor.getClass().getName() + " from " + contributor.getBundle().getSymbolicName());
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
			final Bundle bundle = pageRule.getBundle();
			// FIXME: Resource aware!
			System.out.println(ansi().render("@|bold,black %3d||@" + selectorSymbol + selectorNameAnsi + "@|bold,black ||@%4d@|bold,black ||@" + declarationSymbol + "%-44s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, pageRule.getPositioner(), declarationName,
				bundle.getSymbolicName(), bundle.getBundleId() ));
		}
		System.out.println(ansi().render("@|bold %d|@ contributors", i));
		return null;
	}

}
