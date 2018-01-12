package org.soluvas.web.site.widget;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.ITenant;
import org.soluvas.web.site.semantic.ItemPropContentBehavior;
import org.soluvas.web.site.semantic.SchemaOrgProperty;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Displays a {@link java.time.OffsetDateTime} model converted to {@link ITenant#getDefaultTimeZone()} (if available), and also uses <code>abbr</code>.
 * By default time zone is not displayed to save UI space and because time zone is consistent,
 * this can be changed with {@link #zone(boolean)}.
 *
 * <p>Time zone can be hidden by calling {@link #zone(boolean)}.
 * @author ceefour
 * @see DateColumn2
 */
@SuppressWarnings("serial")
public class OffsetDateTimeLabel extends Label {

	private static final Logger log = LoggerFactory.getLogger(OffsetDateTimeLabel.class);

	public enum ZoneConversion {
		ORIGINAL,
		TENANT,
		CUSTOM
	}

	@SpringBean(required = false)
	private ITenant tenant;

	private ZoneConversion zoneConversion = ZoneConversion.TENANT;
	private ZoneId customZone;
	boolean displayZone = false;
	private String tagName = "abbr";
	
	public OffsetDateTimeLabel(String id, final IModel<OffsetDateTime> model) {
		super(id, model);
	}
	
	public OffsetDateTimeLabel(String id, final IModel<OffsetDateTime> model, SchemaOrgProperty schemaOrgProperty) {
		super(id, model);
		add(new ItemPropContentBehavior(schemaOrgProperty, model));
	}

	public OffsetDateTimeLabel(String id, final OffsetDateTime dateTime) {
		super(id, new Model<>(dateTime));
	}

	public OffsetDateTimeLabel withOriginalZone() {
		this.zoneConversion = ZoneConversion.ORIGINAL;
		return this;
	}

	public OffsetDateTimeLabel withTenantZone() {
		this.zoneConversion = ZoneConversion.TENANT;
		return this;
	}

	public OffsetDateTimeLabel withCustomZone(ZoneId zone) {
		this.zoneConversion = ZoneConversion.CUSTOM;
		this.customZone = zone;
		return this;
	}

	/**
	 * Change tag name, default is {@code abbr}. If {@code null}, tag name will be specified by markup.
	 * @param tagName
     */
	public OffsetDateTimeLabel tagName(@Nullable String tagName) {
		this.tagName = tagName;
		return this;
	}
	
	public OffsetDateTimeLabel zone(boolean displayZone) {
		this.displayZone = displayZone;
		return this;
	}

	protected OffsetDateTime getConvertedModelObject() {
		OffsetDateTime dateTime = (OffsetDateTime) getDefaultModelObject();
		if (dateTime != null) {
			if (ZoneConversion.TENANT == zoneConversion) {
				if (null != tenant && null != tenant.getDefaultTimeZone()) {
					log.trace("Converting {} using {} to {}", dateTime, zoneConversion, tenant.getDefaultTimeZone());
					dateTime = dateTime.atZoneSameInstant(ZoneId.of(tenant.getDefaultTimeZone().toString())).toOffsetDateTime();
				} else {
					log.warn("Not converting {} using {}, tenant={} tenant.defaultTimeZone={}",
							dateTime, zoneConversion, tenant, tenant != null ? tenant.getDefaultTimeZone() : null);
				}
			} else if (ZoneConversion.CUSTOM == zoneConversion && null != customZone) {
				log.trace("Converting {} using {} to {}", dateTime, zoneConversion, customZone);
				dateTime = dateTime.atZoneSameInstant(customZone).toOffsetDateTime();
			} else {
				log.trace("Not converting {}", dateTime);
			}
		}
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
		final OffsetDateTime dateTime = getConvertedModelObject();
		if (dateTime != null) {
			DateTimeFormatter format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT)
					.withLocale(getLocale());
			final String str;
			if (displayZone) {
				DateTimeFormatter zoneFormat = DateTimeFormatter.ofPattern("ZZ").withLocale(getLocale());
				str = format.format(dateTime) + " " + zoneFormat.format(dateTime);
			} else {
				str = format.format(dateTime);
			}
			replaceComponentTagBody(markupStream, openTag, str);
		} else {
			super.onComponentTagBody(markupStream, openTag);
		}
	}

}
