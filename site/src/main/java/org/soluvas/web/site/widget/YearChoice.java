package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Opera Mini-compatible {@link DropDownChoice} UI component for year.
 *
 * @author ceefour
 */
@SuppressWarnings("serial")
public class YearChoice extends DropDownChoice<Integer> {

    public YearChoice(String id, IModel<Integer> model) {
        super(id);
        setChoices(new LoadableDetachableModel<List<Integer>>() {
            @Override
            protected List<Integer> load() {
                final LocalDate today = LocalDate.now();
                Integer youngest = today.getYear() - 13;
                final ArrayList<Integer> years = new ArrayList<>();
                for (int year = youngest; year >= today.getYear() - 100; year--) {
                    years.add(year);
                }
                return years;
            }
        });
        setModel(model);
        setChoiceRenderer(new ChoiceRenderer<Integer>() {
            @Override
            public Object getDisplayValue(Integer object) {
                return Objects.toString(object, "");
            }

            @Override
            public String getIdValue(Integer object, int index) {
                return object != null ? object.toString() : "";
            }
        });
    }

    public YearChoice(String id) {
        this(id, new Model<>());
    }

}