package org.soluvas.web.nav;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Nullable;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.async.Callback;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * @author ceefour
 */
public class OsgiMenuRepository implements MenuRepository {

	public static final class MenuItemComparator implements
			Comparator<MenuItem> {
		@Override
		public int compare(MenuItem o1, MenuItem o2) {
			return o1.getWeight() - o2.getWeight();
		}
	}

	private transient Logger log = LoggerFactory.getLogger(OsgiMenuRepository.class);
	/**
	 * Source menu items.
	 */
	private Map<String, MenuItem> menuItems = new ConcurrentHashMap<String, MenuItem>();
	
	private MenuCatalog current;
	
	public OsgiMenuRepository() {
		current = NavFactory.eINSTANCE.createMenuCatalog();
	}
	
	public OsgiMenuRepository(Adapter adapter) {
		this();
		current.eAdapters().add(adapter);
	}
	
	public void add(final Menu menu) {
		log.debug("Adding menu {}", menu.getId());
		Menu existing = Iterables.find(current.getMenus(), new Predicate<Menu>() {
			@Override
			public boolean apply(@Nullable Menu input) {
				return input.getId().equals(menu.getId());
			}
		}, null);
		if (existing == null) {
			current.getMenus().add(EcoreUtil.copy(menu));
			recheckMenus();
		} else {
			log.info("Skipping already existing menu {}", menu.getId());
		}
	}
	
	public void add(MenuItem menuItem) {
		log.debug("Adding menu item {}", menuItem.getId());
		menuItems.put(menuItem.getId(), EcoreUtil.copy(menuItem));
		recheckMenus();
	}
	
	protected void recursiveSmoothSort(MenuItemContainer menu) {
		// Sort items in the parent
		Ordering<MenuItem> ordering = Ordering.from(new MenuItemComparator());
		List<MenuItem> ordered = ordering.immutableSortedCopy(menu.getItems());
		// reorder until match
		while (true) {
			boolean stable = true;
			for (MenuItem item : menu.getItems()) {
				int oldIndex = menu.getItems().indexOf(item);
				int newIndex = ordered.indexOf(item);
				if (oldIndex != newIndex) {
					menu.getItems().move(newIndex, item);
					stable = false;
					break;
				}
			}
			if (stable)
				break;
		}
		// Then sort the children
		for (MenuItem menuItem : menu.getItems()) {
			recursiveSmoothSort(menuItem);
		}
	}
	
	/**
	 * Not a rebuild, more like a diff. :-)
	 * - Add missing menu items
	 * - Reorder menu items
	 */
	protected void recheckMenus() {
		// Sort existing menus and menu items
		for (Menu menu : current.getMenus()) {
			recursiveSmoothSort(current);
		}
		// Add additional menu items
		for (final MenuItem item : menuItems.values()) {
			if (item.getParentId() == null)
				continue;
			final String parentId = item.getParentId();
			Menu parent = Iterables.find(current.getMenus(), new Predicate<Menu>() {
				@Override
				public boolean apply(@Nullable Menu input) {
					return input.getId().equals(parentId);
				}
			}, null);
			if (parent == null) {
				log.debug("Skipping menu item {} because parent {} not exist yet", item.getId(), parentId);
				continue;
			}
			// check if item already exists
			MenuItem foundItem = Iterables.find(parent.getItems(), new Predicate<MenuItem>() {
				@Override
				public boolean apply(@Nullable MenuItem input) {
					return input.getId().equals(item.getId());
				}
			}, null);
			if (foundItem != null)
				continue;
			// We've found an ex-orphan, let's add it to the rightful parent
			List<MenuItem> tmpList = new ArrayList<MenuItem>(parent.getItems());
			tmpList.add(item);
			List<MenuItem> ordered = Ordering.from(new MenuItemComparator()).immutableSortedCopy(tmpList);
			// Find the new position of this thing
			int newIndex = ordered.indexOf(item);
			// Add directly to that index
			parent.getItems().add(newIndex, item);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.navigation.MenuRepository#findOne(java.lang.String, org.soluvas.navigation.Callback)
	 */
	@Override
	public void findOne(final String id, Callback<Menu> callback) {
		Menu menu = Iterables.find(current.getMenus(), new Predicate<Menu>() {
			@Override
			public boolean apply(@Nullable Menu input) {
				return input.getId().equals(id);
			}
		}, null);
		callback.success(menu);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.navigation.MenuRepository#findAll(org.soluvas.navigation.Callback)
	 */
	@Override
	public void findAll(Callback<List<Menu>> callback) {
		callback.success(ImmutableList.copyOf( current.getMenus() ));
	}

	/* (non-Javadoc)
	 * @see org.soluvas.navigation.MenuRepository#findAllIds(org.soluvas.navigation.Callback)
	 */
	@Override
	public void findAllIds(Callback<List<String>> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(final String id) {
		if (id == null)
			return;
		log.debug("Deleting menu {}", id);
		Menu menu = Iterables.find(current.getMenus(), new Predicate<Menu>() {
			@Override
			public boolean apply(@Nullable Menu input) {
				return input.getId().equals(id);
			}
		}, null);
		if (menu != null)
			current.getMenus().remove(id);
	}

	@Override
	public void remove(final Menu menu) {
		if (menu == null)
			return;
		log.debug("Deleting menu {}", menu.getId());
		Menu found = Iterables.find(current.getMenus(), new Predicate<Menu>() {
			@Override
			public boolean apply(@Nullable Menu input) {
				return input.getId().equals(menu.getId());
			}
		}, null);
		if (found != null) {
			current.getMenus().remove(found);
		} else {
			log.info("Cannot delete menu {}, not found", menu.getId());
		}
	}

	@Override
	public void remove(MenuItem menuItem) {
		if (menuItem == null)
			return;
		log.debug("Deleting menu item {}", menuItem.getId());
		menuItems.remove(menuItem.getId());
		for (Menu menu : current.getMenus()) {
			recursiveDelete(menu, menuItem);
		}
	}

	private void recursiveDelete(MenuItemContainer parent, final MenuItem hunted) {
		MenuItem foundItem = Iterables.find(parent.getItems(), new Predicate<MenuItem>() {
			@Override
			public boolean apply(@Nullable MenuItem input) {
				return input.getId().equals(hunted.getId());
			}
		}, null);
		if (foundItem != null) {
			// Bye bye
			log.debug("Menu item {} deleted from parent {}", foundItem.getId(), parent);
			parent.getItems().remove(foundItem);
		} else {
			// Try in children
			for (MenuItem child : parent.getItems()) {
				recursiveDelete(child, hunted);
			}
		}
	}

}
