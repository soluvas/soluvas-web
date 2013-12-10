package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.joda.time.LocalTime;

/**
 * input type="time". Uses String because not guaranteed that {@link LocalTime} would work,
 * see {@link #getModelObjectAsLocalTime()}.
 * @see #getModelObjectAsLocalTime()
 * @author ceefour
 * @todo Use {@link LocalTime} model value.
 */
public class TimeTextField extends TextField<String> {

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public TimeTextField(String id) {
		super(id, String.class);
	}

	/**
	 * @param id
	 * @param model
	 */
	public TimeTextField(String id, IModel<String> model) {
		super(id, model, String.class);
	}

	@Override
	protected String getInputType() {
		return "time";
	}
	
	public LocalTime getModelObjectAsLocalTime() {
		return getModelObject() != null ? new LocalTime(getModelObject()) : null;
	}

}
