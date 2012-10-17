package org.soluvas.web.nav.ui;

import java.util.concurrent.atomic.AtomicReference;

import org.apache.wicket.model.Model;
import org.soluvas.async.AsyncUtils;
import org.soluvas.async.Callback;
import org.soluvas.async.FailingCallback;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuRepository;
import org.soluvas.web.site.ComponentFactory;

import com.google.common.base.Function;

public class NavMenuFactory implements ComponentFactory<NavMenu> {
	
	private transient MenuRepository menuRepository;
	
	public NavMenuFactory(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
	}

	@SuppressWarnings("serial")
	@Override
	public NavMenu create(String id) {
		final Menu menu = AsyncUtils.wrap(new Function<FailingCallback<Menu>, Void>() {
			public Void apply(FailingCallback<Menu> callback) {
				menuRepository.findOne("main", callback);
				return null;
			};
		});
		return new NavMenu(id, new Model<Menu>(menu));
	}

}
