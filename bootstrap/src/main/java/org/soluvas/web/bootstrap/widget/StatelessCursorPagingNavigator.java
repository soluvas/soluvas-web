package org.soluvas.web.bootstrap.widget;

import com.google.common.collect.ImmutableSet;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.Set;

/**
 * Stateless Bootstrap Paging Navigator that uses cursor-based or keyset pagination.
 */
public class StatelessCursorPagingNavigator<T> extends GenericPanel<CursorPage<T>> {

    /**
     * Query parameters to exclude when creating navigation links, these are usually analytics tracking parameters,
     * that are useful for first click but will only clobber next pages.
     */
    private final Set<String> excludedParameters = ImmutableSet.of("ref",
            "utm_medium", "utm_source", "utm_campaign", "utm_content", "utm_term", "fb_ref");

    public StatelessCursorPagingNavigator(String id, IModel<CursorPage<T>> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        final WebMarkupContainer prevItem = new WebMarkupContainer("prevItem");
        queue(prevItem);
        if (getModelObject().getCurrentPage() >= 1) {
            final PageParameters pageParams = new PageParameters(getPage().getPageParameters());
            excludedParameters.forEach(it -> pageParams.set(it, null));
            long prevPageNumber = getModelObject().getCurrentPage() - 1;
            pageParams.set(StatelessDataView.PAGE_NUMBER_PARAMETER, prevPageNumber);
            final BookmarkablePageLink<WebPage> prev = new BookmarkablePageLink<>("prev", getPage().getPageClass(), pageParams);
            queue(prev);
        } else {
            prevItem.setEnabled(false);
            prevItem.add(new CssClassNameAppender("disabled"));
            final ExternalLink prev = new ExternalLink("prev", new Model<>("#"));
            queue(prev);
        }

        final WebMarkupContainer nextItem = new WebMarkupContainer("nextItem");
        queue(nextItem);
        if (getModelObject().isNextAvailable()) {
            final PageParameters pageParams = new PageParameters(getPage().getPageParameters());
            excludedParameters.forEach(it -> pageParams.set(it, null));
            long nextPageNumber = getModelObject().getCurrentPage() + 1;
            pageParams.set(StatelessDataView.PAGE_NUMBER_PARAMETER, nextPageNumber);
            final BookmarkablePageLink<WebPage> next = new BookmarkablePageLink<>("next", getPage().getPageClass(), pageParams);
            queue(next);
        } else {
            nextItem.setEnabled(false);
            nextItem.add(new CssClassNameAppender("disabled"));
            final ExternalLink next = new ExternalLink("next", new Model<>("#"));
            queue(next);
        }
    }
}
