package org.soluvas.web.nav;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.async.Callback;

import com.google.common.collect.ImmutableList;

/**
 * @deprecated Use {@link OsgiMenuRepository}.
 * @author ceefour
 */
@Deprecated
public class InMemoryMenuRepository implements MenuRepository {

	private static final Logger log = LoggerFactory.getLogger(InMemoryMenuRepository.class);
	private Map<String, Menu> menus = new ConcurrentHashMap<String, Menu>();
	
	public void add(Menu menu) {
		log.info("Adding menu {}", menu.getId());
		menus.put(menu.getId(), menu);
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.navigation.MenuRepository#findOne(java.lang.String, org.soluvas.navigation.Callback)
	 */
	@Override
	public void findOne(final String id, Callback<Menu> callback) {
		Menu menu = menus.get(id);
		callback.success(menu);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.navigation.MenuRepository#findAll(org.soluvas.navigation.Callback)
	 */
	@Override
	public void findAll(Callback<List<Menu>> callback) {
		callback.success(ImmutableList.copyOf( menus.values() ));
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
		log.info("Deleting menu {}", id);
		menus.remove(id);
	}

	@Override
	public void remove(MenuItem menuItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Menu menu) {
		// TODO Auto-generated method stub
		
	}

}
