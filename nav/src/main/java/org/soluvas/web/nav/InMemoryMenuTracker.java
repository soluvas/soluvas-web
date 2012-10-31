package org.soluvas.web.nav;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTrackerCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.async.Callback;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Tracks nav files and registers them with the menu repository.
 * @deprecated Use {@link OsgiMenuTracker}. 
 * @author ceefour
 */
@Deprecated
public class InMemoryMenuTracker implements BundleTrackerCustomizer {

	private transient Logger log = LoggerFactory.getLogger(InMemoryMenuTracker.class);
	private MenuRepository menuRepository;
	
	public InMemoryMenuTracker(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
		log.info("Menu tracker loading EPackage {}", NavPackage.eINSTANCE);
	}

	@Override
	public MenuCatalog addingBundle(final Bundle bundle, BundleEvent event) {
		Enumeration<URL> navEntries = bundle.findEntries("META-INF/nav", "*.xmi", true);
		while (navEntries != null && navEntries.hasMoreElements()) {
			URL navEntry = navEntries.nextElement();
			log.info("Loading nav from {}", navEntry);
			XMIResourceImpl resource = new XMIResourceImpl();
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
				
				for (final MenuItem item : catalog.getItems()) {
					if (Strings.isNullOrEmpty(item.getParentId())) {
						log.error("Menu item {} requires Parent ID", item.getId());
						continue;
					}
					menuRepository.findOne(item.getParentId(), new Callback<Menu>() {
						@Override
						public void success(Menu menu) {
							if (menu == null) {
								log.error("Menu item {} references non-existing parent {}", item.getId(), item.getParentId());
								return;
							}
							MenuItem cloned = EcoreUtil.copy(item);
							cloned.setBundle(bundle);
							log.info("Adding menu item {} to menu {}", item.getId(), menu.getId());
							menu.getItems().add(cloned);
						}
					});
				}
				
				for (final Menu menu : catalog.getMenus()) {
					Menu cloned = EcoreUtil.copy(menu);
					menuRepository.add(cloned);
				}

				return catalog;
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

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event,
			Object object) {
		if (object == null)
			return;
		MenuCatalog catalog = (MenuCatalog)object;

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
		log.info("Bundle {} removed, removing: {} menu items: {}; {} menus: {}", 
				new Object[] { bundle, catalog.getItems().size(), menuItemIds,
				catalog.getMenus().size(), menuIds });
		
		for (final MenuItem item : catalog.getItems()) {
			if (Strings.isNullOrEmpty(item.getParentId())) {
				continue;
			}
			menuRepository.findOne(item.getParentId(), new Callback<Menu>() {
				@Override
				public void success(Menu menu) {
					if (menu == null) {
						return;
					}
					try {
						MenuItem foundItem = Iterables.find(menu.getItems(), new Predicate<MenuItem>() {
							@Override
							public boolean apply(@Nullable MenuItem input) {
								return item.getId().equals(input.getId());
							}
						});
						log.info("Removing menu item {} from menu {}", item.getId(), menu.getId());
						menu.getItems().remove(foundItem);
					} catch (Exception e) {
						log.warn("Cannot find menu item " + item.getId() + " from " + menu.getId() + " to remove", e);
					}
				}
			});
		}
		
		for (final Menu menu : catalog.getMenus()) {
			menuRepository.delete(menu.getId());
		}
	}

}
