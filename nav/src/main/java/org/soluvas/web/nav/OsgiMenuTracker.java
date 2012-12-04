package org.soluvas.web.nav;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.annotation.Nullable;

import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * Tracks nav files and registers them with the menu repository. 
 * @author ceefour
 */
@SuppressWarnings("rawtypes")
public class OsgiMenuTracker implements BundleTrackerCustomizer {

	private static final Logger log = LoggerFactory.getLogger(OsgiMenuTracker.class);
	private BundleContext bundleContext;
	
	public OsgiMenuTracker(BundleContext bundleContext) {
		super();
		this.bundleContext = bundleContext;
		log.info("Menu tracker loading EPackage {}", NavPackage.eINSTANCE);
	}
	
	protected void recursiveSetBundle(MenuItem menuItem, Bundle bundle) {
		menuItem.setBundle(bundle);
		for (MenuItem child : menuItem.getItems())
			recursiveSetBundle(child, bundle);
	}

	@SuppressWarnings("unchecked") @Override
	public List<ServiceRegistration> addingBundle(final Bundle bundle, BundleEvent event) {
		ArrayList<ServiceRegistration> regs = new ArrayList<ServiceRegistration>();
		Enumeration<URL> navEntries = bundle.findEntries("META-INF/nav", "*.xmi", true);
		while (navEntries != null && navEntries.hasMoreElements()) {
			URL navEntry = navEntries.nextElement();
			log.info("Loading nav from {}", navEntry);
			Registry.INSTANCE.put(NavPackage.eNS_URI, NavPackage.eINSTANCE);
			XMIResourceImpl resource = new XMIResourceImpl();
			log.trace("Package registry: {}", Registry.INSTANCE.keySet());
			try {
				resource.load(navEntry.openStream(), new HashMap<String, Object>());
				MenuCatalog catalog = (MenuCatalog) resource.getContents().get(0);
				List<String> menuItemIds = Lists.transform(catalog.getItems(), new Function<MenuItem, String>() {
					@Override @Nullable
					public String apply(@Nullable MenuItem input) {
						return input.getId();
					}
				});
				List<String> menuIds = Lists.transform(catalog.getMenus(), new Function<Menu, String>() {
					@Override @Nullable
					public String apply(@Nullable Menu input) {
						return input.getId();
					}
				});
				log.info("{} contains {} menu items: {}", new Object[] {
						navEntry, catalog.getItems().size(), menuItemIds });
				log.info("{} contains {} menus: {}", new Object[] {
						navEntry, catalog.getMenus().size(), menuIds });
				
				for (final Menu menu : catalog.getMenus()) {
					for (MenuItem item : menu.getItems()) {
						recursiveSetBundle(item, bundle);
					}
					regs.add( bundleContext.registerService(Menu.class.getName(), menu, new Hashtable()) );
				}

				for (final MenuItem item : catalog.getItems()) {
					if (Strings.isNullOrEmpty(item.getParentId())) {
						log.error("Menu item {} requires Parent ID", item.getId());
						continue;
					}
					recursiveSetBundle(item, bundle);
					regs.add( bundleContext.registerService(MenuItem.class.getName(), item, new Hashtable()) );
				}
				
				log.debug("Registered {} menu/menu item services", regs.size());
				return regs;
			} catch (IOException e) {
				log.error("Cannot load nav from " + navEntry, e);
			}
		}
		return null;
	}

	@Override
	public void modifiedBundle(Bundle bundle, BundleEvent event,
			Object object) {
	}

	@SuppressWarnings({ "unchecked" }) @Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			Object object) {
		if (object == null)
			return;
		List<ServiceRegistration> regs = (List<ServiceRegistration>)object;
		log.info("Bundle {} removed, removing {} ServiceRegistration objects", 
				new Object[] { bundle, regs.size() });
		
		for (ServiceRegistration ref : regs) {
			ref.unregister();
		}
	}

}
