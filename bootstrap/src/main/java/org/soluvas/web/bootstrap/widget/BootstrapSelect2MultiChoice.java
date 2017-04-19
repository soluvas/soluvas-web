package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.model.IModel;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Select2BootstrapTheme;
import org.wicketstuff.select2.Select2MultiChoice;

/**
 * Integrates {@link Select2BootstrapTheme}.
 *
 * @author ceefour
 * @see BootstrapSelect2Choice
 * @see org.wicketstuff.select2.Select2BootstrapTheme
 */
@SuppressWarnings("serial")
public class BootstrapSelect2MultiChoice<T> extends Select2MultiChoice<T> {

	public BootstrapSelect2MultiChoice(String id) {
		super(id);
	}

	public BootstrapSelect2MultiChoice(String id, IModel<Collection<T>> model) {
		super(id, model);
	}

	public BootstrapSelect2MultiChoice(String id, IModel<Collection<T>> model, ChoiceProvider<T> provider) {
		super(id, model, provider);
	}

	public BootstrapSelect2MultiChoice(String id, ChoiceProvider<T> provider) {
		super(id, provider);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		getSettings().setTheme(new Select2BootstrapTheme(false));
	}
	
}
