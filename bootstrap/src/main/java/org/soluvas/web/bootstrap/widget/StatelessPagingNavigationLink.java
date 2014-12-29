package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;

/**
 * Created by ceefour on 28/12/14.
 * 
 * @see org.apache.wicket.markup.html.navigation.paging.PagingNavigationLink
 */
@SuppressWarnings("serial")
public class StatelessPagingNavigationLink<C extends Page> extends
		BookmarkablePageLink<C> {

	private final IPageable pageable;
	private final long pageNumber;

	public StatelessPagingNavigationLink(String id, IPageable pageable,
			long pageNumber, Class<C> pageClass) {
		super(id, pageClass);
		this.pageable = pageable;
		this.pageNumber = pageNumber;
		// FIXME: setAutoEnable(true)
	}

	public long getPageNumber() {
		return pageNumber;
	}

	@Override
	public void onConfigure() {
		super.onConfigure();
		getPageParameters().clearIndexed();
		getPageParameters().clearNamed();
		getPageParameters().mergeWith(getPage().getPageParameters());
		// PagingNavigator's magic number -1 means last page
		getPageParameters().set("page",
				pageNumber >= 0 ? pageNumber : pageable.getPageCount() - 1);
	}

}