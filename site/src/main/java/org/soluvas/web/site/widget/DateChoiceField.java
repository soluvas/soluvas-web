package org.soluvas.web.site.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.convert.ConversionException;
import org.apache.wicket.validation.ValidationError;
import org.slf4j.LoggerFactory;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Opera Mini-compatible {@link DropDownChoice} UI components for {@link LocalDate}.
 * Created by ceefour on 22/07/2017.
 * @see DayOfMonthChoice
 * @see MonthChoice
 * @see YearChoice
 */
public class DateChoiceField extends FormComponentPanel<LocalDate> {

    private IModel<Integer> domModel = new Model<>();
    private IModel<Integer> monthModel = new Model<>();
    private IModel<Integer> yearModel = new Model<>();
    private DayOfMonthChoice domChoice;
    private MonthChoice monthChoice;
    private YearChoice yearChoice;

    public DateChoiceField(String id) {
        super(id);
    }

    public DateChoiceField(String id, IModel<LocalDate> model) {
        super(id, model);
    }

    @Override
    public void convertInput() {
        final Integer year = yearChoice.getConvertedInput();
        final Integer month = monthChoice.getConvertedInput();
        final Integer dom = domChoice.getConvertedInput();
        if (null != year && null != month && null != dom) {
            try {
                setConvertedInput(LocalDate.of(year, month, dom));
            } catch (DateTimeException e) {
                final ConversionException ex = new ConversionException(
                        "Failed to construct LocalDate from '" + year + "-" + month + "-" + dom + "'", e)
                        .setResourceKey("Date")
                        .setVariable("year", year).setVariable("month", month).setVariable("dom", dom);
                error(newValidationError(ex));
            } catch (Exception e) {
                throw new ConversionException(
                        "Failed to construct LocalDate from '" + year + "-" + month + "-" + dom + "'", e);
            }
        } else {
            setConvertedInput(null);
        }
    }

    @Override
    public void validate() {
        super.validate();
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();
        if (null != getModelObject()) {
            domChoice.setModelObject(getModelObject().getDayOfMonth());
            monthChoice.setModelObject(getModelObject().getMonthValue());
            yearChoice.setModelObject(getModelObject().getYear());
        } else {
            domChoice.setModelObject(null);
            monthChoice.setModelObject(null);
            yearChoice.setModelObject(null);
        }
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AttributeAppender("class", "row"));
        domChoice = new DayOfMonthChoice("dom", domModel);
        add(domChoice);
        monthChoice = new MonthChoice("month", monthModel);
        add(monthChoice);
        yearChoice = new YearChoice("year", yearModel);
        add(yearChoice);
    }
}
