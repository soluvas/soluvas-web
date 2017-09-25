package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.TermKind;

/**
 * @author anton
 *
 */
public class TermKindSelect2 extends BootstrapSelect2Choice<TermKind> {

	private static final Logger log = LoggerFactory
			.getLogger(TermKindSelect2.class);
	
	public TermKindSelect2(String id, IModel<TermKind> selectedTermKindModel) {
		super(id, selectedTermKindModel);
		
		setProvider(new TermKindChoiceProvider());
		
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		getSettings().setCloseOnSelect(true);
	}

}
