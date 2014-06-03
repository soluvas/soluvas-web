package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.soluvas.data.Term;
import org.soluvas.data.Value;

/**
 * Renders the {@link Value}-typed {@link IColumn}
 * using {@link ValueLabel}, with CSS class <code>value</code>.
 * @author ceefour
 *
 * @param <T>
 * @param <S>
 */
public class TermColumn<T> extends PropertyColumn<T, String> {

	private static final long serialVersionUID = 1L;
	private final boolean hideTextIfImageExists;

	public TermColumn(IModel<String> displayModel, String termExpression) {
		super(displayModel, termExpression + ".term", termExpression);
		this.hideTextIfImageExists = false;
	}
	
	public TermColumn(IModel<String> displayModel, String termExpression, boolean hideTextIfImageExists) {
		super(displayModel, termExpression + ".term", termExpression);
		this.hideTextIfImageExists = hideTextIfImageExists;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final TermLabel label = new TermLabel(componentId, (IModel<Term>) model, hideTextIfImageExists);
		item.add(label);
		item.add(new AttributeAppender("class", "term"));
	}

}
