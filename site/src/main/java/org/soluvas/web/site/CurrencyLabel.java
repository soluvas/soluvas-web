package org.soluvas.web.site;

import java.math.BigDecimal;
import java.util.Locale;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;

/**
 * Formats a {@link CurrencyUnit} code as symbol in current {@link Locale}.
 * @author agus
 */
@SuppressWarnings("serial")
public class CurrencyLabel extends Label {

	public CurrencyLabel(String id, IModel<CurrencyUnit> model) {
		super(id, model);
	}

	public CurrencyLabel(String id, CurrencyUnit label) {
		super(id, label);
	}
	
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final CurrencyUnit currency = (CurrencyUnit) getDefaultModelObject();
		if (currency != null) {
			// TODO: proper locale support
			return currency.getSymbol(Locale.forLanguageTag("id-ID"));
		} else {
			return "";
		}
	}
	
}
