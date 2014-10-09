package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.soluvas.data.Term;
import org.soluvas.data.Value;
import org.soluvas.web.site.widget.TermLabel.TermDisplay;

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
	private final TermDisplay termDisplay;

	public TermColumn(IModel<String> displayModel, String termExpression) {
		super(displayModel, termExpression + ".term", termExpression);
		this.termDisplay = TermDisplay.IMAGE_AND_TEXT;
	}
	
	public TermColumn(IModel<String> displayModel, String termExpression, TermDisplay termDisplay) {
		super(displayModel, termExpression + ".term", termExpression);
		this.termDisplay = termDisplay;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void populateItem(Item<ICellPopulator<T>> item, String componentId, IModel<T> model) {
		final TermLabel label = new TermLabel(componentId, (IModel<Term>) model, termDisplay);
		item.add(label);
		item.add(new AttributeAppender("class", "term"));
	}

}
