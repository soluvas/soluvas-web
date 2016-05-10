package org.soluvas.web.bootstrap.widget;

import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DatetimePicker;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DatetimePickerConfig;
import org.apache.wicket.model.IModel;
import org.joda.time.DateTime;
import org.soluvas.web.site.DatePropertyModel;

import java.util.Date;

/**
 * Convenience component to use {@link DatetimePicker} with a {@link DateTime} model instead of {@link Date}.
 * Created by ceefour on 18/04/2016.
 * @see LocalDatePicker
 */
public class DateTimePicker extends DatetimePicker {
    /**
     * @param id
     * @param datePattern See <a href="http://momentjs.com/docs/#/displaying/format/">momentjs' docs</a> for valid formats. Format also dictates what components are shown, e.g. MM/dd/YYYY will not display the time picker. Default is {@code MM/dd/YYYY}.
     */
    public DateTimePicker(String id, String datePattern) {
        super(id, datePattern);
    }

    /**
     * @param id
     * @param datePattern See <a href="http://momentjs.com/docs/#/displaying/format/">momentjs' docs</a> for valid formats. Format also dictates what components are shown, e.g. MM/dd/YYYY will not display the time picker. Default is {@code MM/dd/YYYY}.
     * @param id
     * @param model
     * @param datePattern
     */
    public DateTimePicker(String id, IModel<DateTime> model, String datePattern) {
        super(id, new DatePropertyModel(model, DateTime.class), datePattern);
    }

    public DateTimePicker(String id, DatetimePickerConfig config) {
        super(id, config);
    }

    public DateTimePicker(String id, IModel<DateTime> model, DatetimePickerConfig config) {
        super(id, new DatePropertyModel(model, DateTime.class), config);
    }
}
