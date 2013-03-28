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
 * Formats {@link BigDecimal} as money in current {@link Locale}, without currency.
 * @author agus
 */
@SuppressWarnings("serial")
public class MoneyLabel extends Label {

	/**
	 * @todo Proper support locale.
	 */
	private static MoneyFormatter formatter = new MoneyFormatterBuilder().appendAmountLocalized().toFormatter(Locale.forLanguageTag("id-ID"));
	
	public MoneyLabel(String id, IModel<BigDecimal> model) {
		super(id, model);
	}

	public MoneyLabel(String id, BigDecimal label) {
		super(id, label);
	}
	
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final BigDecimal amount = (BigDecimal) getDefaultModelObject();
		if (amount != null) {
			final BigMoney money = BigMoney.of(CurrencyUnit.of("IDR"), amount);
			return formatter.print(money);
		} else {
			return "";
		}
	}
	
}
