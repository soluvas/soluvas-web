package org.soluvas.web.site.widget;

import java.util.Date;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.datetime.DateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.base.AbstractInstant;

/**
 * Wraps a {@link DateTime} model to be usable, it also uses <code>abbr</code>.
 * @author ceefour
 * @see DateTimeLabel2
 */
public class DateTimeLabel extends DateLabel {

	private static final long serialVersionUID = 1L;
	
	private IModel<? extends AbstractInstant> dateTimeModel;

	public DateTimeLabel(String id, DateConverter converter) {
		super(id, converter);
	}

	public DateTimeLabel(String id, final IModel<? extends AbstractInstant> model, DateConverter converter) {
		super(id, new AbstractReadOnlyModel<Date>() {
			@Override
			public Date getObject() {
				final Object modelObj = model.getObject();
				if (modelObj == null) {
					return null;
				} else if (modelObj instanceof AbstractInstant) {
					return ((AbstractInstant) modelObj).toDate();
				} else if (modelObj instanceof LocalDateTime) {
					return ((LocalDateTime) modelObj).toDate();
				} else {
					return new DateTime(modelObj).toDate();
				}
			}
		}, converter);
		this.dateTimeModel = model;
	}
	
	public DateTimeLabel(String id, DateTime model, DateConverter converter) {
		this(id, new Model<>(model), converter);
	}
	
	public DateTimeLabel(String id, LocalDateTime model, DateConverter converter) {
		this(id, new Model(model), converter);
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
