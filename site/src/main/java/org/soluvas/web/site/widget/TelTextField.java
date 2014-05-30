package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

/**
 * Define a field for entering a telephone number ({@code <input type="tel">}).
 * @author ceefour
 * @see TelLink
 */
public class TelTextField extends TextField<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 */
	public TelTextField(String id) {
		super(id, String.class);
	}

	/**
	 * @param id
	 * @param model
	 */
	public TelTextField(String id, IModel<String> model) {
		super(id, model);
	}
	
	@Override
	protected String getInputType() {
		return "tel";
	}

}
