package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.TermKind;
import org.soluvas.data.TermKindRepository;

import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.TextChoiceProvider;

@SuppressWarnings("serial")
public class TermTypeChoiceProvider extends TextChoiceProvider<TermKind>{

	private static final Logger log = LoggerFactory
			.getLogger(TermTypeChoiceProvider.class);
	
	@Inject
	private TermKindRepository termKindRepo;
	
	public TermTypeChoiceProvider() {
		super();
		Injector.get().inject(this);
	}

	@Override
	protected String getDisplayText(TermKind choice) {
		return choice.getName();
	}

	@Override
	protected Object getId(TermKind choice) {
		return choice.getId();
	}

	@Override
	public void query(String term, int page, Response<TermKind> response) {
		response.addAll(termKindRepo.findAll());
	}

	@Override
	public Collection<TermKind> toChoices(Collection<String> ids) {
		return termKindRepo.findAll(ids);
	}

}
