package org.soluvas.web.nav.ui;

import org.apache.wicket.Component;
import org.apache.wicket.model.Model;
import org.soluvas.async.AsyncUtils;
import org.soluvas.async.FailingCallback;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuRepository;
import org.soluvas.web.site.ComponentFactory;

import com.google.common.base.Function;

@SuppressWarnings("rawtypes")
public class SidebarNavFactory implements ComponentFactory {
	
	private MenuRepository menuRepository;
	
	public SidebarNavFactory(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
	}

	@Override
	public Component create(String id) {
		final Menu menu = AsyncUtils.wrap(new Function<FailingCallback<Menu>, Void>() {
			public Void apply(FailingCallback<Menu> callback) {
				menuRepository.findOne("main", callback);
				return null;
			};
		});
		return new SidebarNav(id, new Model<Menu>(menu));
	}

}
