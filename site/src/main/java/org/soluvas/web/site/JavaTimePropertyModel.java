package org.soluvas.web.site;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.time.*;
import java.util.Date;

/**
 * Wraps a {@link java.time.OffsetDateTime}/{@link java.time.LocalDate}/{@link java.time.LocalDateTime}/{@link java.time.LocalTime} model as regular {@link Date} model,
 * for use with {@code de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DateTimePicker}.
 * Created by ceefour on 6 Jan 2017.
 */
public class JavaTimePropertyModel implements IModel<Date> {

    final IModel<Object> innerModel;
    private final Class<?> clazz;

    public JavaTimePropertyModel(final Object modelObject, final String expression,
                                 final Class<?> clazz) {
        this.innerModel = new PropertyModel<>(modelObject, expression);
        this.clazz = clazz;
    }

    public <T> JavaTimePropertyModel(final IModel<T> innerModel, final Class<T> clazz) {
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
            return Date.from(((LocalDate) inner).atStartOfDay(ZoneId.systemDefault()).toInstant());
        } else if (inner instanceof OffsetDateTime) {
            return Date.from(((OffsetDateTime) inner).toInstant());
        } else if (inner instanceof LocalDateTime) {
            return Date.from(((LocalDateTime) inner).atZone(ZoneId.systemDefault()).toInstant());
        } else if (inner instanceof LocalTime) {
            return Date.from(((LocalTime) inner).atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
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
                innerModel.setObject(object.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            } else if (OffsetDateTime.class.isAssignableFrom(clazz)) {
                if (innerModel != null && innerModel.getObject() instanceof OffsetDateTime) {
                    final ZoneOffset zone = ((OffsetDateTime) innerModel.getObject()).getOffset();
                    innerModel.setObject(OffsetDateTime.ofInstant(object.toInstant(), zone));
                } else {
                    innerModel.setObject(OffsetDateTime.ofInstant(object.toInstant(), ZoneId.systemDefault()));
                }
            } else if (LocalDateTime.class.isAssignableFrom(clazz)) {
                innerModel.setObject(LocalDateTime.ofInstant(object.toInstant(), ZoneId.systemDefault()));
            } else if (LocalTime.class.isAssignableFrom(clazz)) {
                innerModel.setObject(LocalDateTime.ofInstant(object.toInstant(), ZoneId.systemDefault()).toLocalTime());
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
