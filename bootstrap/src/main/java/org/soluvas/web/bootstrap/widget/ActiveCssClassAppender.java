package org.soluvas.web.bootstrap.widget;

import javax.annotation.Nullable;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.AbstractReadOnlyModel;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;

/**
 * Bootstrap-enhances a component (usually {@link WebMarkupContainer} @{code li}) by appending
 * {@code class="active"} if at least one of the provided {@link BookmarkablePageLink} links to the current {@link Page}.
 * 
 * <p>Usage:
 * 
 * <pre>{@literal
 * final WebMarkupContainer dashboardItem = new WebMarkupContainer("dashboardItem");
 * final BookmarkablePageLink<Page> dashboardLink = new BookmarkablePageLink<>("dashboardLink", pageProvider.getDashboardPage());
 * dashboardItem.add(dashboardLink);
 * dashboardItem.add(new ActiveCssClassAppender(dashboardLink));
 * add(dashboardItem);
 * }</pre>
 * 
 * @author ceefour
 */
public class ActiveCssClassAppender extends CssClassNameAppender {
	
	private static final long serialVersionUID = 1L;
	
	public ActiveCssClassAppender(final BookmarkablePageLink<?>... links) {
		super(new AbstractReadOnlyModel<String>() {
			@Override @Nullable
			public String getObject() {
				for (BookmarkablePageLink<?> link : links) {
					if (link.linksTo(link.getPage())) {
						return "active";
					}
				}
				return null;
			}
		});
	}
	
}
