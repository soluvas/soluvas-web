package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.model.IModel;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Select2BootstrapTheme;
import org.wicketstuff.select2.Select2Choice;

/**
 * Integrates {@link Select2BootstrapTheme}.
 *
 * @author ceefour
 * @see BootstrapSelect2MultiChoice
 * @see Select2BootstrapTheme
 */
@SuppressWarnings("serial")
public class BootstrapSelect2Choice<T> extends Select2Choice<T> {

    public BootstrapSelect2Choice(String id, IModel<T> model,
                                  ChoiceProvider<T> provider) {
        super(id, model, provider);
    }

    public BootstrapSelect2Choice(String id, ChoiceProvider<T> provider) {
        super(id, provider);
    }

    public BootstrapSelect2Choice(String id, IModel<T> model) {
        super(id, model);
    }

    public BootstrapSelect2Choice(String id) {
        super(id);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        getSettings().setTheme(new Select2BootstrapTheme(false));
    }

}
