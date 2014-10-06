package org.soluvas.web.site.widget;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
 * The {@link BigDecimal#setScale(int, java.math.RoundingMode)} will be set to either {@link #scale}
 * or {@code 0} if requires no rounding, otherwise {@code 2} with {@link RoundingMode#HALF_EVEN}.
 * @author agus
 */
@SuppressWarnings("serial")
public class MeasureLabel extends Label {

	public static final int ROUNDED_SCALE = 2;
	
	@Nullable
	private IModel<BigDecimal> amountModel;
	@Nullable
	private final Integer scale;

	public MeasureLabel(String id, IModel<?> model) {
		super(id, model);
		this.scale = null;
	}

	public MeasureLabel(String id, Unit<?> unit) {
		super(id, unit);
		this.scale = null;
	}
	
	public MeasureLabel(String id, IModel<?> model, int scale) {
		super(id, model);
		this.scale = scale;
	}

	public MeasureLabel(String id, Unit<?> unit, int scale) {
		super(id, unit);
		this.scale = scale;
	}
	
	/**
	 * @param id
	 * @param unitModel Can be either a {@link Unit} or unit code {@link String}.
	 * @param amountModel
	 */
	public MeasureLabel(String id, IModel<?> unitModel, IModel<BigDecimal> amountModel) {
		super(id, unitModel);
		this.amountModel = amountModel;
		this.scale = null;
	}

	public MeasureLabel(String id, Unit<?> unit, BigDecimal amount) {
		super(id, unit);
		this.amountModel = new Model<>(amount);
		this.scale = null;
	}
	
	/**
	 * @param id
	 * @param unitModel Can be either a {@link Unit} or unit code {@link String}.
	 * @param amountModel
	 */
	public MeasureLabel(String id, IModel<?> unitModel, IModel<BigDecimal> amountModel, int scale) {
		super(id, unitModel);
		this.amountModel = amountModel;
		this.scale = scale;
	}

	public MeasureLabel(String id, Unit<?> unit, BigDecimal amount, int scale) {
		super(id, unit);
		this.amountModel = new Model<>(amount);
		this.scale = scale;
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final Object unitObj = getDefaultModelObject();
		final Unit<?> unit;
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
		if (amountModel != null && amountModel.getObject() != null) {
			BigDecimal scaled;
			if (scale != null) {
				scaled = amountModel.getObject().setScale(scale, RoundingMode.HALF_EVEN);
			} else {
				try {
					scaled = amountModel.getObject().setScale(0, RoundingMode.UNNECESSARY);
				} catch (ArithmeticException e) {
					scaled = amountModel.getObject().setScale(ROUNDED_SCALE, RoundingMode.HALF_EVEN);
				}
			}
			final Locale locale = getLocale();
			return Measures.formatHtml(scaled, unit, locale);
		} else {
			return unit.toString();
		}
	}
	
}
