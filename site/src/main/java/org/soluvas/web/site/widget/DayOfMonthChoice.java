package org.soluvas.web.site.widget;

import com.google.common.collect.ImmutableList;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import java.util.List;
import java.util.Objects;

/**
 * Opera Mini-compatible {@link DropDownChoice} UI component for day of month.
 *
 * @author ceefour
 */
@SuppressWarnings("serial")
public class DayOfMonthChoice extends DropDownChoice<Integer> {

    public DayOfMonthChoice(String id, IModel<Integer> model) {
        super(id);
        setChoices(new LoadableDetachableModel<List<Integer>>() {
            @Override
            protected List<Integer> load() {
                return ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                        21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
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

    public DayOfMonthChoice(String id) {
        this(id, new Model<>());
    }

}