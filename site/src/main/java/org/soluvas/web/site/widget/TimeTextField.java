package org.soluvas.web.site.widget;

import com.google.common.base.Strings;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.joda.time.LocalTime;

/**
 * input type="time". Uses String because not guaranteed that {@link LocalTime} would work,
 * see {@link #getModelObjectAsLocalTime()}.
 * @see #getModelObjectAsLocalTime()
 * @author ceefour
 */
public class TimeTextField extends TextField<LocalTime> {

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public TimeTextField(String id) {
		super(id, LocalTime.class);
	}

	/**
	 * @param id
	 * @param model
	 */
	public TimeTextField(String id, IModel<LocalTime> model) {
		super(id, model, LocalTime.class);
	}

	@Override
	protected String getInputType() {
		return "time";
	}

	@Override
	protected void convertInput() {
		if (!Strings.isNullOrEmpty(getInput())) {
			setConvertedInput(new LocalTime(getInput()));
		} else {
			setConvertedInput(null);
		}
	}

	@Override
	protected String getModelValue() {
		return getModelObject() != null ? getModelObject().toString() : null;
	}

	public LocalTime getModelObjectAsLocalTime() {
		return getModelObject() != null ? new LocalTime(getModelObject()) : null;
	}

}
