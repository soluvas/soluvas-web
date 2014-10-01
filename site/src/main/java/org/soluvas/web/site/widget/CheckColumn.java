package org.soluvas.web.site.widget;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DataTable;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;

/**
 * Choose models inside a {@link DataTable}.
 * 
 * <p>You have to wrap the DataTable inside a CheckGroup.
 * 
 * <p>HTML Markup:
 * 
 * <pre>{@literal
 * <div wicket:id="productTableCtr">
 * 	<div wicket:id="productTableCg">
 * 		<table class="table table-bordered table-striped" wicket:id="productTable">
 * 		</table>
 * 	</div>
 * </div>
 * }</pre>
 * 
 * <p>Java:
 * 
 * <pre>
 * final EmfListModel&lt;Product> selectedProductsModel = new EmfListModel<>(new ArrayList&lt;Product>());
 * final WebMarkupContainer productTableCtr = new WebMarkupContainer("productTableCtr");
 * productTableCtr.setOutputMarkupId(true);
 * final CheckGroup&lt;Product> productTableCg = new CheckGroup<>("productTableCg", selectedProductsModel);
 * log.debug("First Count Paging is {}", countPagingModel.getObject());
 * final AjaxFallbackDefaultDataTable<Product, String> productTable = new AjaxFallbackDefaultDataTable<>("productTable", columns, sdpProduct, countPagingModel.getObject());
 * productTableCg.add(productTable);
 * productTableCtr.add(productTableCg);
 * add(productTableCtr);
 * </pre>
 * 
 * @author rudi
 */
@SuppressWarnings("serial")
public class CheckColumn<T> extends
		AbstractColumn<T, String> {
	
	public CheckColumn(IModel<String> displayModel) {
		super(displayModel);
	}
	
	@Override
	public Component getHeader(String componentId) {
		return new CheckHeaderPanel(componentId);
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> cellItem,
			String componentId, IModel<T> rowModel) {
		cellItem.add(new CheckPanel<>(componentId, rowModel));
	}
	
}
