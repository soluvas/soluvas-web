package org.soluvas.web.site;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.joda.time.*;

import java.util.Date;

/**
 * Wraps a {@link DateTime}/{@link LocalDate}/{@link LocalDateTime}/{@link LocalTime} model as regular {@link Date} model,
 * for use with {@code de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DateTimePicker}.
 * Created by ceefour on 9/29/15.
 */
public class DatePropertyModel implements IModel<Date> {

    final IModel<Object> innerModel;
    private final Class<?> clazz;

    public DatePropertyModel(final Object modelObject, final String expression,
                             final Class<?> clazz) {
        this.innerModel = new PropertyModel<>(modelObject, expression);
        this.clazz = clazz;
    }

    public <T> DatePropertyModel(final IModel<T> innerModel, final Class<T> clazz) {
        this.innerModel = (IModel) innerModel;
        this.clazz = clazz;
    }

    public IModel<Object> getInnerModel() {
        return innerModel;
    }

    @Override
    public Date getObject() {
        final Object inner = innerModel.getObject();
        if (inner instanceof LocalDate) {
            return ((LocalDate) inner).toDate();
        } else if (inner instanceof DateTime) {
            return ((DateTime) inner).toDate();
        } else if (inner instanceof LocalDateTime) {
            return ((LocalDateTime) inner).toDate();
        } else if (inner instanceof LocalTime) {
            return ((LocalTime) inner).toDateTimeToday().toDate();
        } else if (inner instanceof Date) {
            return (Date) inner;
        } else {
            return null;
        }
    }

    @Override
    public void setObject(Date object) {
        if (object != null) {
            if (LocalDate.class.isAssignableFrom(clazz)) {
                innerModel.setObject(new LocalDate(object));
            } else if (DateTime.class.isAssignableFrom(clazz)) {
                if (innerModel != null && innerModel.getObject() instanceof DateTime) {
                    final DateTimeZone zone = ((DateTime) innerModel.getObject()).getZone();
                    innerModel.setObject(new DateTime(object).withZone(zone));
                } else {
                    innerModel.setObject(new DateTime(object));
                }
            } else if (LocalDateTime.class.isAssignableFrom(clazz)) {
                innerModel.setObject(new LocalDateTime(object));
            } else if (LocalTime.class.isAssignableFrom(clazz)) {
                innerModel.setObject(new LocalTime(object));
            } else if (Date.class.isAssignableFrom(clazz)) {
                innerModel.setObject(object);
            }
        } else {
            innerModel.setObject(null);
        }
    }

    @Override
    public void detach() {
        innerModel.detach();
    }
}
