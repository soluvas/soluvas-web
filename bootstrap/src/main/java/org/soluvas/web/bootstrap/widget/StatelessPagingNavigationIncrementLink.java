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
		final long realPageNumber = getPageNumber();
		if (realPageNumber >= 0) { // for first page, leave out the ?page=0
			getPageParameters().set(StatelessDataView.PAGE_NUMBER_PARAMETER, realPageNumber);
		}
		setEnabled(realPageNumber != getPage().getPageParameters().get(StatelessDataView.PAGE_NUMBER_PARAMETER).toInt(0));
	}

}
