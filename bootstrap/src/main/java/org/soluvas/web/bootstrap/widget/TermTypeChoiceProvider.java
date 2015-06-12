package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.TermType;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.TextChoiceProvider;

@SuppressWarnings("serial")
public class TermTypeChoiceProvider extends TextChoiceProvider<TermType>{

	private final IModel<Collection<TermType>> termTypesModel;
	
	private static final Logger log = LoggerFactory
			.getLogger(TermTypeChoiceProvider.class);
	
	public TermTypeChoiceProvider(IModel<Collection<TermType>> termTypesModel) {
		super();
		Injector.get().inject(this);
		this.termTypesModel = termTypesModel;
	}

	@Override
	protected String getDisplayText(TermType choice) {
		switch (choice.getName()) {
		case "color":
				return "Color";
		case "cloth_size":
			return "Cloth Size";
		case "shoe_size":
			return "Shoe Size";
		default:
			return choice.getName();
		}
	}

	@Override
	protected Object getId(TermType choice) {
		return choice.getValue();
	}

	@Override
	public void query(String term, int page, Response<TermType> response) {
		final Collection<TermType> termTypeCollection = Collections2.filter(termTypesModel.getObject(), new Predicate<TermType>() {
			@Override
			public boolean apply(@Nullable TermType input) {
				return StringUtils.containsIgnoreCase(input.getName(), term.trim());
			}
		});
		response.addAll(termTypeCollection);
	}

	@Override
	public Collection<TermType> toChoices(Collection<String> ids) {
		return FluentIterable.from(ids).transform(new Function<String, TermType>() {
			@Override
			@Nullable
			public TermType apply(@Nullable String id) {
				final TermType termType = Iterables.find(termTypesModel.getObject(), new Predicate<TermType>(){
					@Override
					public boolean apply(TermType termType) {
						return String.valueOf(termType.getValue()).equals(id);
					}
				});
				return termType;
			}
		}).toList();
	}

}
