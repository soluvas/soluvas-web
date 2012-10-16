package org.soluvas.web.site.shell;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.web.site.JavaScriptShim;
import org.soluvas.web.site.JavaScriptShimImpl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

/**
 * List {@link JavaScriptShimImpl}s.
 * @author ceefour
 */
@Command(scope="js", name="lsshim", description="List JavaScript RequireJS shims.")
public class JsLsShimCommand extends OsgiCommandSupport {
	
	private List<JavaScriptShimImpl> shims;
	
	public static class NameOrdering extends Ordering<JavaScriptShimImpl> {

		@Override
		public int compare(@Nullable JavaScriptShimImpl left,
				@Nullable JavaScriptShimImpl right) {
			return left != null && right != null ? left.getName().compareToIgnoreCase(right.getName()) : 0;
		}
		
	}
	
	public JsLsShimCommand(List<JavaScriptShimImpl> shims) {
		super();
		this.shims = shims;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.format("%3s | %-20s | %-30s | %s\n",
				"#", "Name", "Dependencies", "Exports" );
		
		List<JavaScriptShimImpl> sortedShims = ImmutableList.copyOf(new NameOrdering().immutableSortedCopy(shims));
		
		int i = 0;
		for (JavaScriptShim it : sortedShims) {
			// TODO: use locale settings to format date, currency, amount, "and", many
			// TODO: format products
			System.out.format("%3d | %-20s | %-30s | %s\n",
				++i, it.getName(), it.getDependencies(), it.getExports() );
		}
		System.out.format("%d JavaScript shims\n",
			sortedShims.size());

		return null;
	}

}
