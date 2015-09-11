package org.soluvas.web.site;

import java.math.BigDecimal;
import java.util.Locale;

import javax.money.Monetary;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.javamoney.moneta.Money;
import org.soluvas.web.site.widget.CurrencyLabel;

/**
 * Formats {@link BigDecimal} as money in current {@link Locale}, without currency.
 * @author agus
 * @deprecated Use {@link CurrencyLabel}.
 */
@Deprecated
@SuppressWarnings("serial")
public class MoneyLabel extends Label {

	public MoneyLabel(String id, IModel<BigDecimal> model) {
		super(id, model);
	}

	public MoneyLabel(String id, BigDecimal label) {
		super(id, label);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final MonetaryAmountFormat formatter = MonetaryFormats.getAmountFormat(getLocale());
		final BigDecimal amount = (BigDecimal) getDefaultModelObject();
		if (amount != null) {
			final Money money = Money.of(amount, Monetary.getCurrency("IDR"));
			return formatter.format(money);
		} else {
			return "";
		}
	}
	
}
