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
	
	public void add(Menu menu);
	public void delete(String id);
	public void findOne(String id, Callback<Menu> callback);
	public void findAll(Callback<List<Menu>> callback);
	public void findAllIds(Callback<List<String>> callback);

}
