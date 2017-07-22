package org.soluvas.web.site.widget;

import com.google.common.collect.ImmutableList;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;

/**
 * Opera Mini-compatible {@link DropDownChoice} UI component for month.
 *
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MonthChoice extends DropDownChoice<Integer> {

    private TextStyle textStyle = TextStyle.FULL;

    public MonthChoice(String id, IModel<Integer> model) {
        super(id);
        setChoices(new LoadableDetachableModel<List<Integer>>() {
            @Override
            protected List<Integer> load() {
                return ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
            }
        });
        setModel(model);
        setChoiceRenderer(new ChoiceRenderer<Integer>() {
            @Override
            public Object getDisplayValue(Integer object) {
                return object != null ? Month.of(object).getDisplayName(textStyle, getLocale()) : "";
            }

            @Override
            public String getIdValue(Integer object, int index) {
                return object != null ? object.toString() : "";
            }
        });
    }

    public MonthChoice(String id) {
        this(id, new Model<>());
    }

    public TextStyle getTextStyle() {
        return textStyle;
    }

    public void setTextStyle(TextStyle textStyle) {
        this.textStyle = textStyle;
    }
}