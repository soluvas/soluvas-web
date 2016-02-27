package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort;
import org.soluvas.geo.Country;
import org.soluvas.geo.CountryRepository;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

public class CountryChoiceProvider extends ChoiceProvider<Country> {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(CountryChoiceProvider.class);
	
	@SpringBean
	public CountryRepository countryRepo;

	public CountryChoiceProvider() {
		super();
		Injector.get().inject(this);
	}

	@Override
	public void query(String term, int page, Response<Country> response) {
		final String trimmedTerm = term.trim();
		final Page<Country> pageCountry = countryRepo.searchCountry(trimmedTerm,
				new PageRequest(page, 20, Sort.Direction.ASC, "name"));
		log.debug("Search '{}' page '{}' returned {} countries", trimmedTerm, page, pageCountry.getContent().size());
		response.addAll(pageCountry.getContent());
		response.setHasMore(!pageCountry.isLastPage());
	}

	@Override
	public void toJson(Country choice, JSONWriter writer)
			throws JSONException {
		writer.key("id").value(choice.getIso())
		.key("text").value(choice.getName());
	}

	@Override
	public Collection<Country> toChoices(Collection<String> ids) {
		final List<Country> filteredCountries = FluentIterable.from(ids).transform(new Function<String, Country>() {

			@Override
			@Nullable
			public Country apply(@Nullable String input) {
				return countryRepo.getCountry(input);
			}
		}).toList();
		return filteredCountries;
	}
	
	@Override
	public void detach() {
		super.detach();
	}
	
}