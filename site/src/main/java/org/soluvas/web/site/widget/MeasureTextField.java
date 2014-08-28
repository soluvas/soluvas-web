package org.soluvas.web.site.widget;

import java.math.BigDecimal;

import javax.measure.unit.Unit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

/**
 * Extends {@link NumberTextField} for amount, and appended with a {@link Unit}
 * add-on. For {@link Unit#ONE}, {@code pcs} is displayed.
 * <p><b>KNOWN ISSUE</b>: You cannot {@link AjaxRequestTarget} this component.
 * If you need to, you must wrap it inside a {@code <div>} then target the div.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MeasureTextField extends NumberTextField<BigDecimal> {

	private final IModel<Unit<?>> unitModel;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MeasureTextField(String id, BigDecimal value, Unit<?> unit) {
		this(id, new Model<>(value), new Model(unit));
	}
	
	public MeasureTextField(String id, IModel<BigDecimal> model, IModel<Unit<?>> unitModel) {
		super(id, model, BigDecimal.class);
		this.unitModel = unitModel;
	}
	
	@Override
	protected void onRender() {
		final Unit<?> unit = unitModel.getObject();
		final String unitHtml;
		if (Unit.ONE == unit) {
			unitHtml = Strings.escapeMarkup(getString("pcs", getModel(), "pcs")).toString();
		} else if (unit != null) {
			unitHtml = Strings.escapeMarkup(getString(unit.toString(), getModel(), unit.toString())).toString();
		} else {
			unitHtml = "??";
		}
		getResponse().write("<div class=\"input-group\">");
		super.onRender();
		getResponse().write("<span class=\"input-group-addon\">" + unitHtml + "</span></div>");
	}
	
	public IModel<Unit<?>> getUnitModel() {
		return unitModel;
	}
	
}
