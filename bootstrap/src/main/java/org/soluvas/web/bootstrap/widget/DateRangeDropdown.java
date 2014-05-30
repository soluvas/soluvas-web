package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Range;

/**
 * A dropdown button that allows to select a date range,
 * can be from predefined ranges or custom user-defined range.
 * 
 * <p>To update your components when date range changes, use {@link #onDateRangeChanged(AjaxRequestTarget)}.
 * @author ceefour
 */
public class DateRangeDropdown extends GenericPanel<Range<LocalDate>> {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(DateRangeDropdown.class);

	private Label dateRangeLabel;
	private WebMarkupContainer dateRangeDropdown;
	private final IModel<RangeChoice> selectedRangeChoiceModel;
	private WebMarkupContainer dateRangeMenu;
	
	private class DateRangeMenuLink extends AjaxLink<String> {
		private static final long serialVersionUID = 1L;
		private RangeChoice forRangeChoice;
		private String infoText;
		
		private DateRangeMenuLink(String id,
				final RangeChoice forRangeChoice, final String infoText) {
			super(id);
			this.forRangeChoice = forRangeChoice;
			this.infoText = infoText;
			
			final WebMarkupContainer icon = new WebMarkupContainer("icon");
			icon.add(new AttributeModifier("style", new AbstractReadOnlyModel<String>() {
				private static final long serialVersionUID = 1L;

				@Override
				public String getObject() {
					return selectedRangeChoiceModel.getObject() == forRangeChoice ? "" : "visibility: hidden";
				}
			}));
			add(icon);
		}

		@Override
		public void onClick(AjaxRequestTarget target) {
			selectedRangeChoiceModel.setObject(forRangeChoice);
			// dateRangeModel.setObject(Range.singleton(new LocalDate(appManifest.getDefaultTimeZone())));
			doSetDateRange(DateRangeDropdown.this.getModel());
			target.appendJavaScript("$('#" + dateRangeDropdown.getMarkupId() + "').dropdown('toggle');");
			target.add(dateRangeMenu, dateRangeLabel);
			onDateRangeChanged(target);
			info(infoText);
		}
		
		/**
		 * Override this to actually set the date range.
		 * @param dateRangeModel
		 */
		protected void doSetDateRange(final IModel<Range<LocalDate>> dateRangeModel) {
		}
		
	}
	
	/**
	 * @param id
	 * @param model
	 * @param selectedRangeChoiceModel
	 * @param timeZone Used for creating {@link LocalDate} based on current time.
	 */
	public DateRangeDropdown(String id, IModel<Range<LocalDate>> model,
			final IModel<RangeChoice> selectedRangeChoiceModel, final DateTimeZone timeZone) {
		super(id, model);
		this.selectedRangeChoiceModel = selectedRangeChoiceModel;
		dateRangeDropdown = new WebMarkupContainer("dateRangeDropdown");
		dateRangeDropdown.setOutputMarkupId(true);
		dateRangeLabel = new Label("dateRangeLabel", new LoadableDetachableModel<String>() {
			private static final long serialVersionUID = 1L;

			@Override
			protected String load() {
				final Range<LocalDate> dateRange = getModelObject();
				log.debug("RangeLabel {}", dateRange);
				return dateRange.lowerEndpoint().equals(dateRange.upperEndpoint()) ? dateRange.lowerEndpoint().toString("MMM d, YYYY")
						: dateRange.lowerEndpoint().toString("MMM d, YYYY") + " - " + dateRange.upperEndpoint().toString("MMM d, YYYY");
			}
		});
		dateRangeLabel.setOutputMarkupId(true);
		dateRangeDropdown.add(dateRangeLabel);
		add(dateRangeDropdown);

		dateRangeMenu = new WebMarkupContainer("dateRangeMenu");
		dateRangeMenu.setOutputMarkupId(true);
		dateRangeMenu.add(new DateRangeMenuLink("todayLink", RangeChoice.TODAY, "Today") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void doSetDateRange(
					IModel<Range<LocalDate>> dateRangeModel) {
				dateRangeModel.setObject(Range.singleton(new LocalDate(timeZone)));
			}
		});
		dateRangeMenu.add(new DateRangeMenuLink("yesterdayLink", RangeChoice.YESTERDAY, "Yesterday") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void doSetDateRange(
					IModel<Range<LocalDate>> dateRangeModel) {
				dateRangeModel.setObject(Range.singleton(new LocalDate(timeZone).minusDays(1)));
			}
		});
		dateRangeMenu.add(new DateRangeMenuLink("thisWeekLink", RangeChoice.THIS_WEEK, "This week") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void doSetDateRange(
					IModel<Range<LocalDate>> dateRangeModel) {
				final LocalDate today = new LocalDate(timeZone);
				final LocalDate endDate;
				// if today is Sunday (7), add 6 days to get this week's Saturday, else get this week's Saturday based on current DOW
				if (today.getDayOfWeek() == DateTimeConstants.SUNDAY) {
					endDate = today.plusDays(6);
				} else {
					endDate = today.plusDays(7 - today.getDayOfWeek());
				}
				final LocalDate startDate = endDate.minusDays(6);
				dateRangeModel.setObject(Range.closed(startDate, endDate));
			}
		});
		dateRangeMenu.add(new DateRangeMenuLink("lastWeekLink", RangeChoice.LAST_WEEK, "Last week") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void doSetDateRange(
					IModel<Range<LocalDate>> dateRangeModel) {
				final LocalDate today = new LocalDate(timeZone);
				final LocalDate endDate;
				// if today is Sunday (7), set endDate as yesterday (Saturday), else set endDate as last week's Saturday
				if (today.getDayOfWeek() == DateTimeConstants.SUNDAY) {
					endDate = today.minusDays(1);
				} else {
					endDate = today.minusDays(today.getDayOfWeek() + 1);
				}
				final LocalDate startDate = endDate.minusDays(6);
				dateRangeModel.setObject(Range.closed(startDate, endDate));
			}
		});
		dateRangeMenu.add(new DateRangeMenuLink("thisMonthLink", RangeChoice.THIS_MONTH, "This month") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void doSetDateRange(
					IModel<Range<LocalDate>> dateRangeModel) {
				final LocalDate today = new LocalDate(timeZone);
				final LocalDate endDate = today.withDayOfMonth(today.dayOfMonth().getMaximumValue());
				final LocalDate startDate = endDate.withDayOfMonth(1);
				dateRangeModel.setObject(Range.closed(startDate, endDate));
			}
		});
		dateRangeMenu.add(new DateRangeMenuLink("lastMonthLink", RangeChoice.LAST_MONTH, "Last month") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void doSetDateRange(
					IModel<Range<LocalDate>> dateRangeModel) {
				final LocalDate today = new LocalDate(timeZone);
				final LocalDate endDate = today.minusMonths(1).withDayOfMonth(today.minusMonths(1).dayOfMonth().getMaximumValue());
				final LocalDate startDate = endDate.withDayOfMonth(1);
				dateRangeModel.setObject(Range.closed(startDate, endDate));
			}
		});
		dateRangeMenu.add(new DateRangeMenuLink("thisYearLink", RangeChoice.THIS_YEAR, "This year") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void doSetDateRange(
					IModel<Range<LocalDate>> dateRangeModel) {
				final LocalDate today = new LocalDate(timeZone);
				final LocalDate startDate = today.withDayOfYear(1);
				final LocalDate endDate = startDate.plusYears(1).minusDays(1);
				dateRangeModel.setObject(Range.closed(startDate, endDate));
			}
		});
		dateRangeMenu.add(new DateRangeMenuLink("lastYearLink", RangeChoice.LAST_YEAR, "Last year") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void doSetDateRange(
					IModel<Range<LocalDate>> dateRangeModel) {
				final LocalDate today = new LocalDate(timeZone);
				final LocalDate startDate = today.withDayOfYear(1).minusYears(1);
				final LocalDate endDate = startDate.plusYears(1).minusDays(1);
				dateRangeModel.setObject(Range.closed(startDate, endDate));
			}
		});
		final Form<Void> form = new Form<>("form");
		final DateRangeModal dateRangeModal = new DateRangeModal("dateRangeModal", getModel()) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				selectedRangeChoiceModel.setObject(RangeChoice.CUSTOM);
				target.add(dateRangeMenu, dateRangeLabel);
				onDateRangeChanged(target);
				log.debug("Custom date range: {}", getModelObject());
				info("Custom date range: " + getModelObject());
			};
		};
		form.add(dateRangeModal);
		add(form);
		dateRangeMenu.add(new DateRangeMenuLink("customLink", RangeChoice.CUSTOM, "Custom") {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void onClick(AjaxRequestTarget target) {
				target.appendJavaScript("$('#" + dateRangeDropdown.getMarkupId() + "').dropdown('toggle');");
				dateRangeModal.appendShowDialogJavaScript(target);
			}
		});
		add(dateRangeMenu);
	}
	
	/**
	 * Override this to do something when data range model changes.
	 * @param target
	 */
	protected void onDateRangeChanged(AjaxRequestTarget target) {
	}

}
