package org.soluvas.web.site.widget;

import java.math.BigDecimal;
import java.util.Locale;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.NumberTextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;
import org.joda.money.CurrencyUnit;

/**
 * Extends {@link NumberTextField} for amount, and prepended with a fixed
 * {@link CurrencyUnit} add-on.
 * <p><b>KNOWN ISSUE</b>: You cannot {@link AjaxRequestTarget} this component.
 * If you need to, you must wrap it inside a {@code <div>} then target the div.
 * @author ceefour
 */
public class CurrencyTextField extends NumberTextField<BigDecimal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final IModel<CurrencyUnit> currencyModel;
	
	public CurrencyTextField(String id, IModel<BigDecimal> model, IModel<CurrencyUnit> currencyModel) {
		super(id, model, BigDecimal.class);
		this.currencyModel = currencyModel;
	}
	
	@Override
	protected void onRender() {
		final CurrencyUnit currency = currencyModel.getObject();
		final Locale locale = getLocale();
		final String currencyHtml;
		if (currency != null) {
			currencyHtml = Strings.escapeMarkup(currency.getSymbol(locale)).toString();
		} else {
			currencyHtml = "";
		}
		getResponse().write("<div class=\"input-group\"><span class=\"input-group-addon btn-info\">" + currencyHtml + "</span>");
		super.onRender();
		getResponse().write("</div>");
	}
	
	public IModel<CurrencyUnit> getCurrencyModel() {
		return currencyModel;
	}
	
}
