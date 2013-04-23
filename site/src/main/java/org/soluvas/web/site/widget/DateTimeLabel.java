package org.soluvas.web.site.widget;

import java.util.Date;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.datetime.DateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.joda.time.DateTime;
import org.joda.time.base.AbstractInstant;

/**
 * Wraps a {@link DateTime} model to be usable, it also uses <code>abbr</code>.
 * @author adri
 */
@SuppressWarnings("serial")
public class DateTimeLabel extends DateLabel {

	private IModel<? extends AbstractInstant> dateTimeModel;

	public DateTimeLabel(String id, DateConverter converter) {
		super(id, converter);
	}

	public DateTimeLabel(String id, final IModel<? extends AbstractInstant> model, DateConverter converter) {
		super(id, new AbstractReadOnlyModel<Date>() {
			@Override
			public Date getObject() {
				return model.getObject() != null ? model.getObject().toDate() : null;
			}
		}, converter);
		this.dateTimeModel = model;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeModifier("title", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return dateTimeModel.getObject() != null ? dateTimeModel.getObject().toString() : null;
			}
		}));
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("abbr");
		super.onComponentTag(tag);
	}
	
}
