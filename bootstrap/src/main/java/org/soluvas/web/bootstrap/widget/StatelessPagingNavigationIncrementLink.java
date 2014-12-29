package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;

/**
 * Created by ceefour on 28/12/14.
 * 
 * @see org.apache.wicket.markup.html.navigation.paging.PagingNavigationIncrementLink
 */
@SuppressWarnings("serial")
public class StatelessPagingNavigationIncrementLink<C extends Page> extends
		BookmarkablePageLink<C> {

	private final IPageable pageable;
	private final int increment;

	public StatelessPagingNavigationIncrementLink(String id,
			IPageable pageable, int increment, Class<C> pageClass) {
		super(id, pageClass);
		this.pageable = pageable;
		this.increment = increment;
		// FIXME: setAutoEnable(true)
	}

	/**
	 * Determines the next page number for the pageable component.
	 *
	 * @return the new page number
	 */
	public long getPageNumber() {
		final long idx = pageable.getCurrentPage() + increment;
		return Math.max(0, Math.min(pageable.getPageCount() - 1, idx));
	}

	@Override
	public void onConfigure() {
		super.onConfigure();
		getPageParameters().clearIndexed();
		getPageParameters().clearNamed();
		getPageParameters().mergeWith(getPage().getPageParameters());
		getPageParameters().set("page", getPageNumber());
	}

}
