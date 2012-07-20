package org.soluvas.web.nav;

import java.util.List;

import org.soluvas.async.Callback;

/**
 * A service that provides menu data.
 * Menu is structured like Drupal menus.
 * The API is meant for asynchronous callbacks, i.e. the callback
 * should be an Akka typed actor or a Camel proxy.
 * @author ceefour
 */
public interface MenuRepository {
	
	void add(Menu menu);
	void delete(String id);
	void findOne(String id, Callback<Menu> callback);
	void findAll(Callback<List<Menu>> callback);
	void findAllIds(Callback<List<String>> callback);
	void remove(MenuItem menuItem);
	void remove(Menu menu);

}
