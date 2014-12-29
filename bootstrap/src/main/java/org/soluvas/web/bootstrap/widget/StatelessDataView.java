package org.soluvas.web.bootstrap.widget;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
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
	protected static final Pattern SORT_PATTERN = Pattern.compile("([^+,]+)(\\+(asc|\\+desc))?");

    public StatelessDataView(String id, IDataProvider<T> dataProvider) {
        super(id, dataProvider);
    }

    public StatelessDataView(String id, IDataProvider<T> dataProvider, long itemsPerPage) {
        super(id, dataProvider, itemsPerPage);
    }

    @SuppressWarnings("unchecked")
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
		final String sortStr = getPage().getPageParameters().get(SORT_PARAMETER).toString("");
		final Matcher matcher = SORT_PATTERN.matcher(sortStr.toString());
		if (matcher.matches() && getDataProvider() instanceof SortableDataProvider) {
          ((SortableDataProvider<T, String>) getDataProvider()).setSort(
        		  matcher.group(1),
        		  "desc".equalsIgnoreCase(matcher.group(3)) ? SortOrder.DESCENDING : SortOrder.ASCENDING);
		}
    }
}
