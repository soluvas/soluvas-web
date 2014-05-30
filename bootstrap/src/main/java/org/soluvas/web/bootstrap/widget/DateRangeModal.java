package org.soluvas.web.bootstrap.widget;

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.markup.html.form.DateTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.collect.Range;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.core.markup.html.bootstrap.dialog.Modal;

/**
 *
 * @author ceefour
 */
public abstract class DateRangeModal extends Modal {
	private static final Logger log = LoggerFactory
			.getLogger(DateRangeModal.class);
	private static final long serialVersionUID = 1L;
	private Form<Range<LocalDate>> form;
	private DateTextField startDateFld;
	private IModel<Range<LocalDate>> model;
	private IModel<Date> startDateModel;
	private IModel<Date> endDateModel;

	public DateRangeModal(String markupId, final IModel<Range<LocalDate>> model) {
		super(markupId);
		this.model = model;
		final Range<LocalDate> inputRange = Optional.fromNullable(model.getObject()).or(Range.singleton(new LocalDate()));
		startDateModel = new Model<Date>(inputRange.lowerEndpoint().toDate());
		endDateModel = new Model<Date>(inputRange.upperEndpoint().toDate());
		
		addCloseButton(new Model<>("Cancel"));
		header(new Model<>("Select date range"));

		form = new Form<Range<LocalDate>>("form", model) {
			@Override
			protected void onSubmit() {
				info("Submitted " + getModelObject());
				super.onSubmit();
			}
		};
		add(form);
		
		final String datePattern = "yyyy-MM-dd";
		startDateFld = new DateTextField("startDateFld", startDateModel, datePattern) {
			@Override
			protected String getInputType() {
				return "date";
			};
		};
		startDateFld.setRequired(true);
		// buggy inside Modal
//		final DatePicker dateStartPicker = new DatePicker();
//		dateStartPicker.setShowOnFieldClick(true);
//		dateStartPicker.setAutoHide(true);
//		startDateFld.add(dateStartPicker);
		form.add(startDateFld);
		
		final DateTextField endDateFld = new DateTextField("endDateFld", endDateModel, datePattern) {
			@Override
			protected String getInputType() {
				return "date";
			};
		};
		endDateFld.setRequired(true);
		// buggy inside Modal
//		final DatePicker dateEndPicker = new DatePicker();
//		dateEndPicker.setShowOnFieldClick(true);
//		dateEndPicker.setAutoHide(true);
//		endDateFld.add(dateEndPicker);
		form.add(endDateFld);
		
		addButton(new BootstrapAjaxButton("button", new Model<>("OK"), form, Buttons.Type.Primary) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				final LocalDate startDate = new LocalDate(startDateModel.getObject());
				final LocalDate endDate = new LocalDate(endDateModel.getObject());
				model.setObject(Range.closed(startDate, endDate));
				log.debug("Selected date range is {}", model.getObject());
				DateRangeModal.this.appendCloseDialogJavaScript(target);
				DateRangeModal.this.onSubmit(target);
			}
		});
	}

	@Override
	protected String createBasicInitializerScript(String markupId) {
		String script = super.createBasicInitializerScript(markupId) + ";";
		script += "$('#" + markupId + "').on('shown', function() {" +
				"$('#" + startDateFld.getMarkupId() + "').focus();" +
				"});";
		return script;
	}
	
	@Override
	protected void onDetach() {
		model.detach();
		super.onDetach();
	}
	
	protected abstract void onSubmit(AjaxRequestTarget target);
	
}
