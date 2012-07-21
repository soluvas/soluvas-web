package org.soluvas.web.nav.ui;

import java.util.concurrent.atomic.AtomicReference;

import org.apache.wicket.Component;
import org.apache.wicket.model.LoadableDetachableModel;
import org.soluvas.async.Callback;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuRepository;
import org.soluvas.web.site.SidebarBlock;

public class SidebarNavFactory implements SidebarBlock {
	
	private MenuRepository menuRepository;
	
	public SidebarNavFactory(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
	}

	@Override
	public Component create(String id) {
		// TODO: synchronous repo
		final AtomicReference<Menu> menu = new AtomicReference<Menu>();
		menuRepository.findOne("main", new Callback<Menu>() {
			@Override
			public void success(Menu data) {
				menu.set(data);
			}
		});
		return new SidebarNav(id, new LoadableDetachableModel<Menu>() {
			@Override
			protected Menu load() {
				return menu.get();
			}
		});
	}

}
