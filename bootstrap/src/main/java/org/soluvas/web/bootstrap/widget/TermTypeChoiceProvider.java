package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.TermType;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.TextChoiceProvider;

public class TermTypeChoiceProvider extends TextChoiceProvider<TermType>{

	private final IModel<List<TermType>> termTypesModel;
	
	private static final Logger log = LoggerFactory
			.getLogger(TermTypeChoiceProvider.class);
	
	public TermTypeChoiceProvider(IModel<List<TermType>> termTypesModel) {
		super();
		Injector.get().inject(this);
		this.termTypesModel = termTypesModel;
	}

	@Override
	protected String getDisplayText(TermType choice) {
		return choice.getName();
	}

	@Override
	protected Object getId(TermType choice) {
		return choice.getValue();
	}

	@Override
	public void query(String term, int page, Response<TermType> response) {
		final Collection<TermType> termTypeList = Collections2.filter(termTypesModel.getObject(), new Predicate<TermType>() {
			@Override
			public boolean apply(@Nullable TermType input) {
				return StringUtils.containsIgnoreCase(input.getName(), term.trim());
			}
		});
		response.addAll(termTypeList);
	}

	@Override
	public Collection<TermType> toChoices(Collection<String> ids) {
//		return FluentIterable.from(ids).transform(new Function<String, TermType>() {
//			@Override @Nullable
//			public TermType apply(@Nullable final String name) {
//				log.trace("TermType Name is {}. Term Type has {} records", name, termTypesModel.getObject().size());
//				@Nullable
//				Category found = categoryRepo.findOne(name);
//				if (found == null) {
//					log.warn("Invalid category UName '{}', {} valid category UNames are: {}",
//							name, sortedCategoriesModel.getObject().size(), 
//							Lists.transform(sortedCategoriesModel.getObject(), new Function<Category, String>() {
//								@Override
//								public String apply(Category input) {
//									return input.getUName();
//								}
//							}));
//				}
//				return found;
//			}
//		})
//		.filter(new NotNullPredicate<>())
//		.toList();
		return null;
	}

}
