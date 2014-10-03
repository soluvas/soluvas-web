package org.soluvas.web.site.widget;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

import javax.annotation.Nullable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Formats a {@link CurrencyUnit} code as symbol in current {@link Locale},
 * optionally with a {@link BigDecimal} amount.
 * The {@link BigDecimal#setScale(int, java.math.RoundingMode)} will be set to either {@link #scale}
 * or {@link CurrencyUnit#getDecimalPlaces()} using {@link RoundingMode#HALF_EVEN} if available, or left as is.
 * @author agus
 */
@SuppressWarnings("serial")
public class CurrencyLabel extends Label {
	
	private static final Logger log = LoggerFactory
			.getLogger(CurrencyLabel.class);

	@Nullable
	private IModel<BigDecimal> amountModel;
	@Nullable
	private final Integer scale;
	
	public CurrencyLabel(String id, IModel<?> model) {
		super(id, model);
		this.scale = null;
	}

	public CurrencyLabel(String id, CurrencyUnit currency) {
		super(id, currency);
		this.scale = null;
	}
	
	/**
	 * @param id
	 * @param currencyModel Can be either a {@link CurrencyUnit} or currency code {@link String}.
	 * @param amountModel
	 */
	public CurrencyLabel(String id, IModel<?> currencyModel, IModel<BigDecimal> amountModel) {
		super(id, currencyModel);
		this.amountModel = amountModel;
		this.scale = null;
	}
	
	public CurrencyLabel(String id, IModel<?> currencyModel, IModel<BigDecimal> amountModel, int scale) {
		super(id, currencyModel);
		this.amountModel = amountModel;
		this.scale = scale;
	}

	public CurrencyLabel(String id, CurrencyUnit currency, BigDecimal amount) {
		super(id, currency);
		this.amountModel = new Model<>(amount);
		this.scale = null;
	}
	
	public void setAmountModel(IModel<BigDecimal> amountModel) {
		this.amountModel = amountModel;
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final Object currencyObj = getDefaultModelObject();
		final BigDecimal amount = amountModel != null ? amountModel.getObject() : null;
		final Locale locale = getLocale();
		if (currencyObj != null) {
			final CurrencyUnit currency = currencyObj instanceof CurrencyUnit ? 
					(CurrencyUnit) currencyObj : CurrencyUnit.of((String) currencyObj);
			final String currencyHtml = amount != null ? "<small class=\"text-muted\">" + currency.getSymbol(locale) + "</small>" : currency.getSymbol(locale);
			if (amount != null) {
				final BigDecimal scaled;
				if (scale != null) {
					scaled = amount.setScale(scale, RoundingMode.HALF_EVEN);
				} else {
					scaled = amount.setScale(currency.getDecimalPlaces(), RoundingMode.HALF_EVEN);
				}
				final MoneyFormatter formatter = new MoneyFormatterBuilder()
					.appendAmountLocalized().toFormatter(locale);
				return currencyHtml + formatter.print(BigMoney.of(currency, scaled));
			} else {
				return currencyHtml;
			}
		} else {
			if (amount != null) {
				final BigDecimal scaled = scale != null ? amount.setScale(scale, RoundingMode.HALF_EVEN) : amount;
				return "<small class=\"text-muted\">?</small> " + DecimalFormat.getInstance(locale).format(scaled.doubleValue());
			} else {
				return "";
			}
		}
	}
	
}
