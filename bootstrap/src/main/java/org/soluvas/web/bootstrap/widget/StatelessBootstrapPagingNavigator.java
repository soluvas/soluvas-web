package org.soluvas.web.bootstrap.widget;

import com.google.common.collect.ImmutableSet;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.list.LoopItem;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.navigation.paging.IPagingLabelProvider;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigation;

import com.google.common.base.Preconditions;

import java.util.Set;

/**
 * Created by ceefour on 28/12/14.
 */
@SuppressWarnings("serial")
public class StatelessBootstrapPagingNavigator extends BootstrapPagingNavigator {

    /**
     * Query parameters to exclude when creating navigation links, these are usually analytics tracking parameters,
     * that are useful for first click but will only clobber next pages.
     */
    private final Set<String> excludedParameters = ImmutableSet.of("ref",
            "utm_medium", "utm_source", "utm_campaign", "utm_content", "utm_term", "fb_ref");

    public StatelessBootstrapPagingNavigator(String markupId, IPageable pageable) {
		super(markupId, pageable);
	}

	public StatelessBootstrapPagingNavigator(String markupId, IPageable pageable, IPagingLabelProvider labelProvider) {
        super(markupId, pageable, labelProvider);
    }

    @Override
    public PagingNavigation newNavigation(String id, IPageable pageable, IPagingLabelProvider labelProvider) {
        return new PagingNavigation(id, pageable, labelProvider) {
            /** Attribute for active state */
            private final AttributeModifier activeAttribute = AttributeModifier.append("class", "active");

            @Override
            protected void populateItem(LoopItem loopItem) {
                super.populateItem(loopItem);
                if ((getStartIndex() + loopItem.getIndex()) == pageable.getCurrentPage()) {
                    loopItem.add(activeAttribute);
                }
            }

            @Override
            protected AbstractLink newPagingNavigationLink(String id, IPageable pageable, long pageIndex) {
                Preconditions.checkNotNull(getPage().getPageClass(), "page.pageClass must not be null");
                return new StatelessPagingNavigationLink<>(id, pageable, pageIndex, getPage().getPageClass())
                        .exclude(excludedParameters);
            }
        };
    }

    @Override
    protected AbstractLink newPagingNavigationIncrementLink(String id, IPageable pageable, int increment) {
        Preconditions.checkNotNull(getPage().getPageClass(), "page.pageClass must not be null");
        return new StatelessPagingNavigationIncrementLink<>(id, pageable, increment, getPage().getPageClass())
                .exclude(excludedParameters);
    }

    @Override
    protected AbstractLink newPagingNavigationLink(String id, IPageable pageable, int pageNumber) {
        Preconditions.checkNotNull(getPage().getPageClass(), "page.pageClass must not be null");
        return new StatelessPagingNavigationLink<>(id, pageable, pageNumber, getPage().getPageClass())
                .exclude(excludedParameters);
    }

}
