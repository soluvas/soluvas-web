package org.soluvas.web.site;

import java.math.BigDecimal;
import java.util.Locale;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;

/**
 * Formats a {@link CurrencyUnit} code as symbol in current {@link Locale},
 * optionally with a {@link BigDecimal} amount.
 * @author agus
 */
@SuppressWarnings("serial")
public class CurrencyLabel extends Label {

	private IModel<BigDecimal> amountModel;

	public CurrencyLabel(String id, IModel<CurrencyUnit> model) {
		super(id, model);
	}

	public CurrencyLabel(String id, CurrencyUnit label) {
		super(id, label);
	}
	
	public CurrencyLabel(String id, IModel<CurrencyUnit> model, IModel<BigDecimal> amountModel) {
		super(id, model);
		this.amountModel = amountModel;
	}

	public CurrencyLabel(String id, CurrencyUnit label, BigDecimal amount) {
		super(id, label);
		this.amountModel = new Model<>(amount);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final CurrencyUnit currency = (CurrencyUnit) getDefaultModelObject();
		if (currency != null) {
			final BigDecimal amount = amountModel.getObject();
			// TODO: proper locale support
			final Locale locale = Locale.forLanguageTag("id-ID");
			if (amount != null) {
				final MoneyFormatter formatter = new MoneyFormatterBuilder()
					.appendCurrencySymbolLocalized().appendAmountLocalized().toFormatter(locale);
				return formatter.print(BigMoney.of(currency, amount));
			} else {
				return currency.getSymbol(locale);
			}
//			return "IDR";
		} else {
			return "";
		}
	}
	
}
