package org.soluvas.web.nav;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Nullable;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.async.Callback;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

/**
 * @author ceefour
 */
public class LegacyOsgiMenuRepository implements MenuRepository {

	private transient Logger log = LoggerFactory.getLogger(LegacyOsgiMenuRepository.class);
	/**
	 * Source menus.
	 */
	@Deprecated
	private Map<String, Menu> menus = new ConcurrentHashMap<String, Menu>();
	/**
	 * Source menu items.
	 */
	private Map<String, MenuItem> menuItems = new ConcurrentHashMap<String, MenuItem>();
	/**
	 * Resulting live menus.
	 */
	private Map<String, Menu> liveMenus = new ConcurrentHashMap<String, Menu>();
	
	public void add(final Menu menu) {
		log.debug("Adding menu {}", menu.getId());
		menus.put(menu.getId(), menu);
		rebuildMenus();
	}
	
	public void add(MenuItem menuItem) {
		log.debug("Adding menu item {}", menuItem.getId());
		menuItems.put(menuItem.getId(), menuItem);
		rebuildMenus();
	}
	
	protected void recursiveSort(MenuItemContainer menu) {
		// Sort the parent
		Ordering<MenuItem> ordering = Ordering.from(new Comparator<MenuItem>() {
			@Override
			public int compare(MenuItem o1, MenuItem o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});
		List<MenuItem> ordered = ordering.immutableSortedCopy(menu.getItems());
		menu.getItems().clear();
		menu.getItems().addAll(ordered);
		// Then sort the children
		for (MenuItem menuItem : menu.getItems()) {
			recursiveSort(menuItem);
		}
	}
	
	protected void rebuildMenus() {
		log.debug("Rebuilding menus from {} menus and {} menu items registered",
				menus.size(), menuItems.size() );
		liveMenus.clear();
		liveMenus.putAll( Maps.uniqueIndex(EcoreUtil.copyAll(menus.values()), new Function<Menu, String>() {
			@Override @Nullable
			public String apply(@Nullable Menu input) {
				return input.getId();
			}
		}) );
		for (MenuItem menuItem : menuItems.values()) {
			Menu parentMenu = liveMenus.get(menuItem.getParentId());
			if (parentMenu == null) {
				log.warn("For menu item {}, cannot find parent menu {}, ignoring for now",
						menuItem.getId(), menuItem.getParentId());
				continue;
			}
			parentMenu.getItems().add( EcoreUtil.copy(menuItem) );
		}
		// Sort menu items
		for (Menu menu : liveMenus.values()) {
			recursiveSort(menu);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.navigation.MenuRepository#findOne(java.lang.String, org.soluvas.navigation.Callback)
	 */
	@Override
	public void findOne(final String id, Callback<Menu> callback) {
		Menu menu = liveMenus.get(id);
		callback.success(menu);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.navigation.MenuRepository#findAll(org.soluvas.navigation.Callback)
	 */
	@Override
	public void findAll(Callback<List<Menu>> callback) {
		callback.success(ImmutableList.copyOf( liveMenus.values() ));
	}

	/* (non-Javadoc)
	 * @see org.soluvas.navigation.MenuRepository#findAllIds(org.soluvas.navigation.Callback)
	 */
	@Override
	public void findAllIds(Callback<List<String>> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		log.debug("Deleting menu {}", id);
		menus.remove(id);
		rebuildMenus();
	}

	@Override
	public void remove(Menu menu) {
		log.debug("Deleting menu {}", menu.getId());
		menus.remove(menu.getId());
		rebuildMenus();
	}

	@Override
	public void remove(MenuItem menuItem) {
		log.debug("Deleting menu item {}", menuItem.getId());
		menuItems.remove(menuItem.getId());
		rebuildMenus();
	}

}
