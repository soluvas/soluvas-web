package org.soluvas.web.bootstrap.widget;

import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DatetimePicker;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DatetimePickerConfig;
import org.apache.wicket.model.IModel;
import org.soluvas.web.site.DatePropertyModel;
import org.soluvas.web.site.JavaTimePropertyModel;

import java.time.LocalDate;
import java.util.Date;

/**
 * Convenience component to use {@link DatetimePicker} with a {@link java.time.LocalDate} model instead of {@link Date}.
 * Created by ceefour on 18/04/2016.
 *
 * <p>Example:</p>
 *
 * {@code
 * // must be at least 13 years old
 * final Date maxDate = new LocalDate().minusYears(13).toDate();
 * final DatetimePickerConfig dtpConfig = new DatetimePickerConfig()
 *     .withFormat("dd-MM-YYYY").useLocale(getLocale().toLanguageTag())
 *     .useView(DatetimePickerConfig.ViewModeType.YEARS)
 *     .useCurrent(false).withMaxDate(maxDate);
 * editForm.add(new LocalDatePicker("birthDate", new PropertyModel<>(personModel, "birthDate"), dtpConfig)
 *     .setRequired(true));
 * }
 *
 * @see DateTimePicker
 * @see DatePropertyModel
 */
public class JavaTimeLocalDatePicker extends DatetimePicker {
    /**
     * @param id
     * @param datePattern See <a href="http://momentjs.com/docs/#/displaying/format/">momentjs' docs</a> for valid formats. Format also dictates what components are shown, e.g. MM/dd/YYYY will not display the time picker. Default is {@code MM/dd/YYYY}.
     */
    public JavaTimeLocalDatePicker(String id, String datePattern) {
        super(id, datePattern);
    }

    /**
     * @param id
     * @param datePattern See <a href="http://momentjs.com/docs/#/displaying/format/">momentjs' docs</a> for valid formats. Format also dictates what components are shown, e.g. MM/dd/YYYY will not display the time picker. Default is {@code MM/dd/YYYY}.
     * @param id
     * @param model
     * @param datePattern
     */
    public JavaTimeLocalDatePicker(String id, IModel<LocalDate> model, String datePattern) {
        super(id, new JavaTimePropertyModel(model, LocalDate.class), datePattern);
    }

    public JavaTimeLocalDatePicker(String id, DatetimePickerConfig config) {
        super(id, config);
    }

    public JavaTimeLocalDatePicker(String id, IModel<LocalDate> model, DatetimePickerConfig config) {
        super(id, new JavaTimePropertyModel(model, LocalDate.class), config);
    }
}
