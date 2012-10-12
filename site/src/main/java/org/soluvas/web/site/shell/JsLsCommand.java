package org.soluvas.web.site.shell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.soluvas.web.site.JavaScriptModule;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

/**
 * List {@link JavaScriptModule}s.
 * @author ceefour
 */
@Command(scope="js", name="ls", description="List JavaScript RequireJS modules.")
public class JsLsCommand extends OsgiCommandSupport {
	
	private BundleContext bundleContext;
	private List<ServiceReference> modules;
	private Map<JavaScriptModule, ServiceReference> moduleMap = new HashMap<JavaScriptModule, ServiceReference>();
	
	public static class NameOrdering extends Ordering<JavaScriptModule> {

		@Override
		public int compare(@Nullable JavaScriptModule left,
				@Nullable JavaScriptModule right) {
			return left != null && right != null ? left.getName().compareToIgnoreCase(right.getName()) : 0;
		}
		
	}
	
	public JsLsCommand(BundleContext bundleContext, List<ServiceReference> modules) {
		super();
		this.bundleContext = bundleContext;
		this.modules = ImmutableList.copyOf(modules);
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		for (ServiceReference module : modules) {
			JavaScriptModule jsModule = (JavaScriptModule) bundleContext.getService(module);
			moduleMap.put(jsModule, module);
		}
		
		try {
			System.out.format("%3s | %-20s | %-30s [  ID] | %-30s | %s\n",
					"#", "Name", "Bundle", "Path", "Minified" );
			
			List<JavaScriptModule> sortedModules = ImmutableList.copyOf(new NameOrdering().immutableSortedCopy(moduleMap.keySet()));
			
			int i = 0;
			for (JavaScriptModule it : sortedModules) {
				// TODO: use locale settings to format date, currency, amount, "and", many
				// TODO: format products
				final Bundle bundle = moduleMap.get(it).getBundle();
				System.out.format("%3d | %-20s | %-30s [%4d] | %-30s | %s\n",
					++i, it.getName(), bundle.getSymbolicName(), bundle.getBundleId(), it.getPath(), it.getMinifiedPath() );
			}
			System.out.format("%d JavaScript modules\n",
				sortedModules.size());

			return null;
		} finally {
			for (ServiceReference module : modules) {
				bundleContext.ungetService(module);
			}
		}
	}

}
