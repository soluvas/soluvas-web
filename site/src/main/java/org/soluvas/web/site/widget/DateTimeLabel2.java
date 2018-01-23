package org.soluvas.web.site.widget;

import java.util.Locale;

import javax.annotation.Nullable;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.web.site.semantic.ItemPropContentBehavior;
import org.soluvas.web.site.semantic.SchemaOrgProperty;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Optional;

/**
 * Displays a {@link DateTime} model converted to {@link AppManifest#getDefaultTimeZone()} (if available), and also uses <code>abbr</code>.
 * By default time zone is not displayed to save UI space and because time zone is consistent,
 * this can be changed with {@link #zone(boolean)}.
 *
 * <p>Time zone can be hidden by calling {@link #zone(boolean)}.
 * @author ceefour
 * @see DateColumn2
 */
@SuppressWarnings("serial")
public class DateTimeLabel2 extends Label {
	
	private static final Logger log = LoggerFactory.getLogger(DateTimeLabel2.class);

	public enum ZoneConversion {
		ORIGINAL,
		TENANT,
		CUSTOM
	}

	@Autowired(required = false)
	private AppManifest appManifest;

	private ZoneConversion zoneConversion = ZoneConversion.TENANT;
	private DateTimeZone customZone;
	boolean displayZone = false;
	private String tagName = "abbr";
	
	public DateTimeLabel2(String id, final IModel<DateTime> model) {
		super(id, model);
	}
	
	public DateTimeLabel2(String id, final IModel<DateTime> model, SchemaOrgProperty schemaOrgProperty) {
		super(id, model);
		add(new ItemPropContentBehavior(schemaOrgProperty, model));
	}

	public DateTimeLabel2(String id, final DateTime dateTime) {
		super(id, new Model<>(dateTime));
	}

	public DateTimeLabel2 withOriginalZone() {
		this.zoneConversion = ZoneConversion.ORIGINAL;
		return this;
	}

	public DateTimeLabel2 withTenantZone() {
		this.zoneConversion = ZoneConversion.TENANT;
		return this;
	}

	public DateTimeLabel2 withCustomZone(DateTimeZone zone) {
		this.zoneConversion = ZoneConversion.CUSTOM;
		this.customZone = zone;
		return this;
	}
	
	/**
	 * Change tag name, default is {@code abbr}. If {@code null}, tag name will be specified by markup.
	 * @param tagName
     */
	public DateTimeLabel2 tagName(@Nullable String tagName) {
		this.tagName = tagName;
		return this;
	}
	
	public DateTimeLabel2 zone(boolean displayZone) {
		this.displayZone = displayZone;
		return this;
	}

	protected DateTime getConvertedModelObject() {
		DateTime dateTime = (DateTime) getDefaultModelObject();
		if (dateTime != null) {
			if (ZoneConversion.TENANT == zoneConversion && null != appManifest && null != appManifest.getDefaultTimeZone()) {
				dateTime = dateTime.withZone(appManifest.getDefaultTimeZone());
			} else if (ZoneConversion.CUSTOM == zoneConversion && null != customZone) {
				dateTime = dateTime.withZone(customZone);
			}
		}
		log.trace(String.format("dateTime '%s' withZone '{}'", dateTime, dateTime.getZone()));
		return dateTime;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeModifier("title", new AbstractReadOnlyModel<Object>() {
			@Override
			public Object getObject() {
				return getConvertedModelObject();
			}
		}));
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		if (null != tagName) {
			tag.setName(tagName);
		}
		super.onComponentTag(tag);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
		final Locale locale;
		if (appManifest != null) {
			locale = Optional.fromNullable(appManifest.getDefaultLocale()).or(getLocale());
		} else {
			locale = getLocale();
		}
		final DateTime dateTime = getConvertedModelObject();
		if (dateTime != null) {
			DateTimeFormatter format = DateTimeFormat.forStyle("MS")
					.withLocale(locale)
					.withPivotYear(2000);
			final String str;
			if (displayZone) {
				DateTimeFormatter zoneFormat = DateTimeFormat.forPattern("ZZ").withLocale(locale);
				str = format.print(dateTime) + " " + zoneFormat.print(dateTime);
			} else {
				str = format.print(dateTime);
			}
			replaceComponentTagBody(markupStream, openTag, str);
		} else {
			super.onComponentTagBody(markupStream, openTag);
		}
	}

}
