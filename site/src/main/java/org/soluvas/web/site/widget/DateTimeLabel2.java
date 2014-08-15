package org.soluvas.web.site.widget;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Displays a {@link DateTime} model, by default with time zone (for safety), and also uses <code>abbr</code>.
 * 
 * <p>Time zone can be hidden by calling {@link #zone(boolean)}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class DateTimeLabel2 extends Label {

	boolean displayZone = true;
	
	public DateTimeLabel2(String id, final IModel<DateTime> model) {
		super(id, model);
	}
	
	public DateTimeLabel2(String id, final DateTime dateTime) {
		super(id, new Model<>(dateTime));
	}
	
	public DateTimeLabel2 zone(boolean displayZone) {
		this.displayZone = displayZone;
		return this;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeModifier("title", new AbstractReadOnlyModel<Object>() {
			@Override
			public Object getObject() {
				return getDefaultModelObject();
			}
		}));
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("abbr");
		super.onComponentTag(tag);
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
		final DateTime dateTime = (DateTime) getDefaultModelObject();
		if (dateTime != null) {
			DateTimeFormatter format = DateTimeFormat.forStyle("MS")
					.withLocale(getLocale())
					.withPivotYear(2000);
			final String str;
			if (displayZone) {
				DateTimeFormatter zoneFormat = DateTimeFormat.forPattern("ZZ").withLocale(getLocale());
				str = format.print(dateTime) + " " + zoneFormat.print(dateTime);
			} else {
				str = format.print(dateTime);
			}
			replaceComponentTagBody(markupStream, openTag, str);
		}
	}

}
