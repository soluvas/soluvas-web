package org.soluvas.web.nav.ui;

import java.util.List;
import java.util.Map.Entry;

import org.apache.wicket.Page;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.osgi.service.blueprint.container.ServiceUnavailableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuItem;
import org.soluvas.web.nav.PageMenuItem;
import org.soluvas.web.nav.ProcessMenuItem;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class SidebarNav extends Panel {

	private static final Logger log = LoggerFactory.getLogger(SidebarNav.class);
	@SpringBean(name="processLinkFactory")
	private ProcessLinkFactory processLinkFactory; 
	
	public SidebarNav(String id, final IModel<Menu> model) {
		super(id, model);
		LoadableDetachableModel<List<MenuItem>> menuItemsModel = new LoadableDetachableModel<List<MenuItem>>() {
			@Override
			protected List<MenuItem> load() {
				return model.getObject().getItems();
			}
		};
		add( new Label("menuLabel", model.getObject().getId() ));
		add( new ListView<MenuItem>("menuItems", menuItemsModel) {
			@SuppressWarnings("unchecked")
			@Override
			protected void populateItem(ListItem<MenuItem> listItem) {
				final MenuItem menuItem = listItem.getModelObject();
				listItem.add(new AttributeAppender("id", "sidebar-nav-item-" + menuItem.getId()));
				final Label icon = new Label("icon") {
					@Override
					protected void onComponentTag(org.apache.wicket.markup.ComponentTag tag) {
						super.onComponentTag(tag);
						if (menuItem.getIconName() != null)
							tag.getAttributes().put("class", "icon-" + menuItem.getIconName());
					};
				};
				final Label label = new Label("label", menuItem.getLabel());
				if (menuItem instanceof PageMenuItem) {
					final PageMenuItem pageMi = (PageMenuItem) menuItem;
					Class<Page> pageClass;
					try {
						log.debug("Loading Page class {} from bundle {} for menu item {}", new Object[] {
								pageMi.getPageClass(), menuItem.getBundle(), pageMi.getId() });
						pageClass = (Class<Page>) menuItem.getBundle().loadClass(pageMi.getPageClass());
						PageParameters pagePars = new PageParameters();
						for (Entry<String, String> param : pageMi.getParameters()) {
							pagePars.add(param.getKey(), param.getValue());
						}
						final BookmarkablePageLink<Page> link = new BookmarkablePageLink<Page>("link", pageClass, pagePars);
						link.add(icon);
						link.add(label);
						listItem.add(link);
					} catch (ClassNotFoundException e) {
						log.error("Cannot load Page class " + pageMi.getPageClass() +
								" from bundle " + menuItem.getBundle() + " for menu item " + pageMi.getId(), e);
					}
				} else if (menuItem instanceof ProcessMenuItem) {
					final ProcessMenuItem processMi = (ProcessMenuItem) menuItem;
					try {
						Link<? extends Page> link = processLinkFactory.create("link", processMi);
						link.add(icon);
						link.add(label);
						listItem.add(link);
					} catch (ServiceUnavailableException e) {
						log.error("Cannot create process page link for menu item " + menuItem.getId() +
								", process " + processMi.getProcessId(), e);
					}
				} else {
					log.warn("Unknown MenuItem subclass: {}", menuItem.eClass());
					WebMarkupContainer link = new WebMarkupContainer("link");
					link.add(icon);
					link.add(label);
					listItem.add(link);
				}
			}
		} );
	}

}
