package org.soluvas.web.site.widget;

import java.util.Date;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.datetime.DateConverter;
import org.apache.wicket.datetime.StyleDateConverter;
import org.apache.wicket.datetime.markup.html.basic.DateLabel;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.joda.time.LocalDate;

/**
 * Wraps a {@link LocalDate} model to be usable, it also uses <code>abbr</code>.
 * @author ceefour
 */
public class LocalDateLabel extends DateLabel {

	private static final long serialVersionUID = 1L;
	
	private IModel<LocalDate> localDateModel;

	public LocalDateLabel(String id, DateConverter converter) {
		super(id, converter);
	}

	/**
	 * Uses the "M-" {@link StyleDateConverter}.
	 * @param id
	 * @param model
	 */
	public LocalDateLabel(String id, final IModel<LocalDate> model) {
		super(id, new AbstractReadOnlyModel<Date>() {
			@Override
			public Date getObject() {
				return model.getObject() != null ? model.getObject().toDate() : null;
			}
		}, new StyleDateConverter("M-", true));
		this.localDateModel = model;
	}
	
	public LocalDateLabel(String id, final IModel<LocalDate> model, DateConverter converter) {
		super(id, new AbstractReadOnlyModel<Date>() {
			@Override
			public Date getObject() {
				return model.getObject() != null ? model.getObject().toDate() : null;
			}
		}, converter);
		this.localDateModel = model;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeModifier("title", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return localDateModel.getObject() != null ? localDateModel.getObject().toString() : null;
			}
		}));
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("abbr");
		super.onComponentTag(tag);
	}
	
}
