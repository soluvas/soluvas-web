package org.soluvas.web.site.widget;

import java.math.BigDecimal;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;

/**
 * Extends {@link NumberTextField} for amount, and append with a fixed
 * {@code %} add-on.
 * <p><b>KNOWN ISSUE</b>: You cannot {@link AjaxRequestTarget} this component.
 * If you need to, you must wrap it inside a {@code <div>} then target the div.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class PercentTextField extends NumberTextField<BigDecimal> {

	public PercentTextField(String id, IModel<BigDecimal> model) {
		super(id, model, BigDecimal.class);
	}
	
	@Override
	protected void onRender() {
		getResponse().write("<div class=\"input-group\">");
		super.onRender();
		getResponse().write("<span class=\"input-group-addon aneh\">%</span></div>");
	}
	
}
