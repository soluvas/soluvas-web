package org.soluvas.web.site.widget;

import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.export.IExportableColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author ceefour
 */
public class CompositeColumnPanel<T> extends GenericPanel<T> {

	private static final long serialVersionUID = 1L;
	private final List<IExportableColumn<T, ?, ?>> columns;

	public CompositeColumnPanel(String id, final IModel<T> rowModel, 
			final IExportableColumn<T, ?, ?> primaryColumn, List<IExportableColumn<T, ?, ?>> columns) {
		super(id, rowModel);
		this.columns = columns;
		add(new Label("primary", primaryColumn.getDataModel(rowModel)));
		add(new ListView<IExportableColumn<T, ?, ?>>("columns", columns) {
			@Override
			protected void populateItem(ListItem<IExportableColumn<T, ?, ?>> item) {
				final IExportableColumn<T, ?, ?> column = item.getModelObject();
				item.add(column.getHeader("header"));
				final IModel<?> cellModel = column.getDataModel(rowModel);
				item.add(new Label("content", cellModel));
			}
		});
	}

}
