package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.time.LocalDate;

/**
 * Opera Mini-compatible {@link DropDownChoice} UI components for {@link LocalDate}.
 * Created by ceefour on 22/07/2017.
 * @see DayOfMonthChoice
 * @see MonthChoice
 * @see YearChoice
 */
public class DateChoicePanel extends FormComponent<LocalDate> {

    private IModel<Integer> domModel = new Model<>();
    private IModel<Integer> monthModel = new Model<>();
    private IModel<Integer> yearModel = new Model<>();

    public DateChoicePanel(String id) {
        super(id);
    }

    public DateChoicePanel(String id, IModel<LocalDate> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new DayOfMonthChoice("dom", domModel));
        add(new MonthChoice("month", monthModel));
        add(new YearChoice("year", monthModel));
    }
}
