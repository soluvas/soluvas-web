package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;

import java.util.HashSet;
import java.util.Set;

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
	private Set<String> excludedParameters = new HashSet<>();

	public StatelessPagingNavigationLink(String id, IPageable pageable,
			long pageNumber, Class<C> pageClass) {
		super(id, pageClass);
		this.pageable = pageable;
		this.pageNumber = pageNumber;
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
		excludedParameters.forEach(it -> getPageParameters().set(it, null));

		// PagingNavigator's magic number -1 means last page
		final long realPageNumber = pageNumber >= 0 ? pageNumber : pageable.getPageCount() - 1;
		if (realPageNumber >= 0) { // for first page, leave out the ?page=0
			getPageParameters().set(StatelessDataView.PAGE_NUMBER_PARAMETER, realPageNumber);
		} 
		
		setEnabled(realPageNumber != getPage().getPageParameters().get(StatelessDataView.PAGE_NUMBER_PARAMETER).toInt(0)); 
	}

	public StatelessPagingNavigationLink exclude(Set<String> excludedParameters) {
		this.excludedParameters.addAll(excludedParameters);
		return this;
	}

}