package org.soluvas.web.site.widget;

import java.math.BigDecimal;
import java.util.Locale;

import javax.annotation.Nullable;
import javax.measure.unit.Unit;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.commons.util.Measures;
import org.soluvas.web.site.SiteException;

/**
 * Renders a {@link BigDecimal} with {@link Unit} in current {@link Locale}.
 * @author agus
 */
@SuppressWarnings("serial")
public class MeasureLabel extends Label {

	@Nullable
	private IModel<BigDecimal> amountModel;

	public MeasureLabel(String id, IModel<?> model) {
		super(id, model);
	}

	public MeasureLabel(String id, Unit<?> unit) {
		super(id, unit);
	}
	
	/**
	 * @param id
	 * @param unitModel Can be either a {@link Unit} or unit code {@link String}.
	 * @param amountModel
	 */
	public MeasureLabel(String id, IModel<?> unitModel, IModel<BigDecimal> amountModel) {
		super(id, unitModel);
		this.amountModel = amountModel;
	}

	public MeasureLabel(String id, Unit<?> unit, BigDecimal amount) {
		super(id, unit);
		this.amountModel = new Model<>(amount);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final Object unitObj = getDefaultModelObject();
		final Unit unit;
		if (unitObj != null) {
			try {
				unit = unitObj instanceof Unit ? 
						(Unit) unitObj : Unit.valueOf((String) unitObj);
			} catch (Exception e) {
				throw new SiteException(e, "Cannot convert %s to Unit", unitObj);
			}
		} else {
			unit = Unit.ONE;
		}
		final BigDecimal amount = amountModel != null ? amountModel.getObject() : null;
		final Locale locale = getLocale();
		if (amount != null) {
			return Measures.formatHtml(amount, unit, locale);
		} else {
			return unit.toString();
		}
	}
	
}
