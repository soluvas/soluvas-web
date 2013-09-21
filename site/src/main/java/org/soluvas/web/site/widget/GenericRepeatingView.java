package org.soluvas.web.site.widget;

import javax.annotation.Nullable;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * Same in spirit as {@link GenericPanel} but for {@link RepeatingView}.
 * @author ceefour
 */
public class GenericRepeatingView<T> extends RepeatingView {

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public GenericRepeatingView(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param model
	 */
	public GenericRepeatingView(String id, IModel<T> model) {
		super(id, model);
	}
	
	@SuppressWarnings("null")
	public IModel<T> getModel() {
		return (IModel<T>) getDefaultModel();
	}

	@Nullable
	public T getModelObject() {
		return (T) getDefaultModelObject();
	}

}
