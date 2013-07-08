/**
 * 
 */
package org.soluvas.web.site.widget;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.soluvas.data.Term;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class TermColumn<T> extends PropertyColumn<T, String> {

	public TermColumn(IModel<String> displayModel, String sortProperty,
			String propertyExpression) {
		super(displayModel, sortProperty, propertyExpression);
	}
	
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId,
			IModel<T> rowModel) {
//		super.populateItem(item, componentId, rowModel);
		item.add(new TermLabel(componentId, (IModel<Term>) rowModel, true));
	}

}
