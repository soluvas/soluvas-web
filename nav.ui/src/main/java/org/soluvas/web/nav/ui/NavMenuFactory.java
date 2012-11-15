package org.soluvas.web.nav.ui;

import java.io.Serializable;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.async.AsyncUtils;
import org.soluvas.async.FailingCallback;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuRepository;
import org.soluvas.web.site.ComponentFactory;

import com.google.common.base.Function;

public class NavMenuFactory implements ComponentFactory<NavMenu, Serializable> {
	
	private transient MenuRepository menuRepository;
	
	public NavMenuFactory(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
	}

	@Override
	public NavMenu create(String id, IModel<Serializable> model) {
		final Menu menu = AsyncUtils.wrap(new Function<FailingCallback<Menu>, Void>() {
			@Override
			public Void apply(FailingCallback<Menu> callback) {
				menuRepository.findOne("main", callback);
				return null;
			};
		});
		return new NavMenu(id, new Model<Menu>(menu));
	}

}
