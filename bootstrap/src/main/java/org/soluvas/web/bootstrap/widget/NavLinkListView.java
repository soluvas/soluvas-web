package org.soluvas.web.bootstrap.widget;

import com.google.common.collect.ImmutableList;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * Usage:
 *
 * <pre>{@code
 * add(new NavLinkListView("navbarPrimaryLinks", ImmutableList.of(
 *     new NavLink(pageProvider.getDashboardPage(), "Dashboard", "home"),
 *     new NavLink(pageProvider.getFrequencyPage(), "Frequency", "signal"),
 *     new NavLink(pageProvider.getMediaPage(), "Media Library", "paperclip"),
 *     new NavLink(PlaceListPage.class, "Locations", "map-marker"),
 *     new NavLink(ThingListPage.class, "Things", "archive")
 * )));
 * }</pre>
 * Created by ceefour on 31/03/2016.
 *
 * @see NavLink
 */
public class NavLinkListView extends ListView<BookmarkablePageLink<?>> {
    public NavLinkListView(String id, ImmutableList<BookmarkablePageLink<?>> primaryLinks) {
        super(id, primaryLinks);
    }

    @Override
	protected void populateItem(ListItem<BookmarkablePageLink<?>> item) {
		item.add(item.getModelObject());
		item.add(new CssClassNameAppender(new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return item.getModelObject().getPageClass().isInstance(getPage()) ? "active" : null;
			}
		}));
	}
}
