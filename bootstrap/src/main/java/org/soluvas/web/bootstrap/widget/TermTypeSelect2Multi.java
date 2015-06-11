package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.TermType;

import com.google.common.collect.ImmutableList;

/**
 * @author anton
 *
 */
@SuppressWarnings("serial")
public class TermTypeSelect2Multi extends InteractiveSelect2MultiChoice<TermType>{

	private static final Logger log = LoggerFactory
			.getLogger(TermTypeSelect2Multi.class);
	private static final long serialVersionUID = 1L;
	
	private LoadableDetachableModel<List<TermType>> termTypeModel;
	
	public TermTypeSelect2Multi(String id, IModel<Collection<TermType>> termTypesModel) {
		super(id, termTypesModel);
		
		termTypeModel = new LoadableDetachableModel<List<TermType>>() {
			@Override
			protected List<TermType> load() {
				return ImmutableList.copyOf(TermType.values());
			}
		};
		setProvider(new TermTypeChoiceProvider(termTypeModel));
		
	}

}
