package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.util.string.StringValue;

/**
 * To be used with {@link org.soluvas.web.bootstrap.widget.StatelessBootstrapPagingNavigator}.
 * Created by ceefour on 29/12/14.
 */
@SuppressWarnings("serial")
public abstract class StatelessDataView<T> extends DataView<T> {

    public static final String PAGE_NUMBER_PARAMETER = "page";
    public static final String PAGE_SIZE_PARAMETER = "size";
    public static final String SORT_PARAMETER = "sort";

    public StatelessDataView(String id, IDataProvider<T> dataProvider) {
        super(id, dataProvider);
    }

    public StatelessDataView(String id, IDataProvider<T> dataProvider, long itemsPerPage) {
        super(id, dataProvider, itemsPerPage);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        final StringValue pageNumberParam = getPage().getPageParameters().get(PAGE_NUMBER_PARAMETER);
        if (!pageNumberParam.isEmpty()) {
            setCurrentPage(pageNumberParam.toInt());
        }
        final StringValue pageSizeParam = getPage().getPageParameters().get(PAGE_SIZE_PARAMETER);
        if (!pageSizeParam.isEmpty()) {
            setItemsPerPage(pageSizeParam.toInt());
        }
        // TODO: use Spring Data REST format
//        final StringValue sortParam = getPage().getPageParameters().get(SORT_PARAMETER);
//        if (!sortParam.isEmpty() && getDataProvider() instanceof ISortableDataProvider) {
//            ((ISortableDataProvider) getDataProvider()).getSortState()
//                    .setPropertySortOrder(sortParam.toString(), SortOrder.ASCENDING);
//        }
    }
}
