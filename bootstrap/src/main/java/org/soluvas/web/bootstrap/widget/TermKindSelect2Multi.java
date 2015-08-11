package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.TermKind;

import com.google.common.collect.ImmutableList;

/**
 * @author anton
 *
 */
@SuppressWarnings("serial")
public class TermKindSelect2Multi extends InteractiveSelect2MultiChoice<TermKind>{

	private static final Logger log = LoggerFactory
			.getLogger(TermKindSelect2Multi.class);
	private static final long serialVersionUID = 1L;
	
	public TermKindSelect2Multi(String id, IModel<Collection<TermKind>> selectedTermTypesModel) {
		super(id, selectedTermTypesModel);
		
		final LoadableDetachableModel<Collection<TermKind>> termTypesModel = new LoadableDetachableModel<Collection<TermKind>>() {
			@Override
			protected Collection<TermKind> load() {
				return ImmutableList.copyOf(TermKind.values());
			}
		};
		setProvider(new TermTypeChoiceProvider(termTypesModel));
		
	}

}
