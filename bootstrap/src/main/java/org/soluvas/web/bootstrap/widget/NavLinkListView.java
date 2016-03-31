package org.soluvas.web.bootstrap.widget;

import com.google.common.collect.ImmutableList;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.AbstractReadOnlyModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	private List<Class<Page>> crumbs = new ArrayList<>();

	public NavLinkListView(String id, ImmutableList<BookmarkablePageLink<?>> primaryLinks) {
        super(id, primaryLinks);
    }

    @Override
	protected void populateItem(ListItem<BookmarkablePageLink<?>> item) {
		item.add(item.getModelObject());
		item.add(new CssClassNameAppender(new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				final ImmutableList<Class<Page>> realCrumbs = ImmutableList.<Class<Page>>builder()
						.add((Class<Page>) getPage().getClass()).addAll(crumbs).build();
				return realCrumbs.stream().anyMatch(it -> item.getModelObject().getPageClass().isAssignableFrom(it)) ? "active" : null;
			}
		}));
	}

	/**
	 * Adds specified page as an ancestor of the current page in navigation hierarchy.
	 * This is required so that a link's {@code active} state can be correctly determined
	 * even if we're in "child" pages.
	 * @param pageClasses
	 * @return
     */
	public NavLinkListView addCrumbs(Class<? extends Page>... pageClasses) {
		crumbs.addAll(Arrays.asList((Class<Page>[]) pageClasses));
		return this;
	}
}
