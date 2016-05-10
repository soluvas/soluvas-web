package org.soluvas.web.site;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Wraps a {@link DateTime} model as regular {@link Date} model,
 * for use with {@code de.agilecoders.wicket.extensions.markup.html.bootstrap.form.datetime.DateTimePicker}.
 * Created by ceefour on 18/04/2016.
 * @see DatePropertyModel
 * @deprecated Use {@link DatePropertyModel}
 */
public class DateTimeModel implements IModel<Date> {

    private IModel<DateTime> actualModel;

    public DateTimeModel(IModel<DateTime> actualModel) {
        this.actualModel = actualModel;
    }

    @Override
    public Date getObject() {
        return actualModel != null && actualModel.getObject() != null ?
                actualModel.getObject().toDate() : null;
    }

    @Override
    public void setObject(Date object) {
        if (object != null && actualModel != null && actualModel.getObject() != null) {
            actualModel.setObject(new DateTime(object).withZone(actualModel.getObject().getZone()));
        } else if (object != null) {
            actualModel.setObject(new DateTime(object));
        } else {
            actualModel.setObject(null);
        }
    }

    @Override
    public void detach() {
        actualModel.detach();
    }
}
