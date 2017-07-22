package org.soluvas.web.site.widget;

import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.soluvas.geo.Country;
import org.soluvas.geo.CountryRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Opera Mini-compatible {@link DropDownChoice} UI component for {@link Country#getCallingCodes()}.
 *
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CallingCodeChoice extends DropDownChoice<Country> {

    @Inject
    private CountryRepository countryRepo;
    private boolean displayCallingCode = true;

    public CallingCodeChoice(String id, IModel<Country> model) {
        super(id);
        setChoices(new LoadableDetachableModel<List<? extends Country>>() {
            @Override
            protected List<? extends Country> load() {
                return countryRepo.findAllWithCallingCode();
            }
        });
        setModel(model);
        setChoiceRenderer(new ChoiceRenderer<Country>() {
            @Override
            public Object getDisplayValue(Country object) {
                return object != null ?
                        object.getName() + (displayCallingCode ? " (+" + object.getCallingCodes().get(0) + ")" : "")
                        : "";
            }

            @Override
            public String getIdValue(Country object, int index) {
                return object != null ? object.getIso() : "";
            }
        });
    }

    public CallingCodeChoice(String id) {
        this(id, new Model<>());
    }

    public boolean isDisplayCallingCode() {
        return displayCallingCode;
    }

    public void setDisplayCallingCode(boolean displayCallingCode) {
        this.displayCallingCode = displayCallingCode;
    }

}