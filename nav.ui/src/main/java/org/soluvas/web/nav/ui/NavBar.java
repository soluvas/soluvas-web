package org.soluvas.web.nav.ui;

import java.util.List;
import java.util.Map.Entry;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuItem;
import org.soluvas.web.nav.PageMenuItem;

/**
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class NavBar extends Panel {

	private transient Logger log = LoggerFactory.getLogger(NavBar.class);
	
	public NavBar(String id, final IModel<Menu> model) {
		super(id, model);
		setRenderBodyOnly(true);
		LoadableDetachableModel<List<MenuItem>> menuItemsModel = new LoadableDetachableModel<List<MenuItem>>() {
			@Override
			protected List<MenuItem> load() {
				return model.getObject().getItems();
			}
		};
		add( new ListView<MenuItem>("nav", menuItemsModel) {
			@Override
			protected void populateItem(ListItem<MenuItem> listItem) {
				final MenuItem menuItem = listItem.getModelObject();
				Label iconComponent = new Label("icon") {
					protected void onComponentTag(org.apache.wicket.markup.ComponentTag tag) {
						super.onComponentTag(tag);
						if (menuItem.getIconName() != null)
							tag.getAttributes().put("class", "icon-" + menuItem.getIconName() + " icon-white");
						else
							setVisible(false);
					};
				};
				if (menuItem instanceof PageMenuItem) {
					final PageMenuItem pageMi = (PageMenuItem) menuItem;
					Class<Page> pageClass;
					try {
						log.debug("Loading Page class {} from bundle {} for menu item {}", new Object[] {
								pageMi.getPageClass(), menuItem.getBundle(), pageMi.getId() });
						pageClass = menuItem.getBundle().loadClass(pageMi.getPageClass());
						PageParameters pagePars = new PageParameters();
						for (Entry<String, String> param : pageMi.getParameters()) {
							pagePars.add(param.getKey(), param.getValue());
						}
						BookmarkablePageLink link = new BookmarkablePageLink<Page>("link", pageClass, pagePars) {
							{
								//setBody(new Model(pageMi.getLabel()));
							}
						};
						link.add(iconComponent);
						link.add(new Label("label", menuItem.getLabel()));
						listItem.add(link);
					} catch (ClassNotFoundException e) {
						log.error("Cannot load Page class " + pageMi.getPageClass() +
								" from bundle " + menuItem.getBundle() + " for menu item " + pageMi.getId(), e);
					}
				}/* else if (menuItem instanceof ProcessMenuItem) {
					final ProcessMenuItem processMi = (ProcessMenuItem) menuItem;
					PageParameters pagePars = new PageParameters();
					pagePars.add("process", processMi.getProcessId());
					listItem.add( new BookmarkablePageLink<ProcessRunPage>("link", ProcessRunPage.class, pagePars) {
						{
							setBody(new Model(processMi.getLabel()));
						}
					});
				}*/ else {
					log.warn("Unknown MenuItem subclass: {}", menuItem.eClass());
					WebMarkupContainer link = new WebMarkupContainer("link");
					link.add(iconComponent);
					link.add(new Label("label", menuItem.getLabel()));
					listItem.add(link);
				}
			}
		} );
	}

}
