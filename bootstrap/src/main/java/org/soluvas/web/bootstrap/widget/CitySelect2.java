package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.annotation.Nullable;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.City;
import org.soluvas.geo.CityRepository;
import org.soluvas.geo.Country;
import org.soluvas.geo.Province;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class CitySelect2 extends InteractiveSelect2Choice<City> {
	
	private static final Logger log = LoggerFactory
			.getLogger(CitySelect2.class);
	
	private static class CityProvider extends ChoiceProvider<City> {
		
		@SpringBean
		private CityRepository cityRepo;
		private final IModel<Country> countryModel;
		private final IModel<Province> provinceModel;
		
		public CityProvider(final IModel<Country> countryModel, final IModel<Province> provinceModel) {
			super();
			Injector.get().inject(this);
			this.countryModel = countryModel;
			this.provinceModel = provinceModel;
		}

		@SuppressWarnings("null")
		@Override
		public void query(String term, int page, Response<City> response) {
			final String trimedTerm = term.trim();
			@Nullable final Country country = countryModel.getObject();
			@Nullable Province province = null;
			if (provinceModel != null){
				province = provinceModel.getObject();
			}
			final Page<City> pageCity;
			if (country != null && province != null) {
				pageCity = cityRepo.searchCity(trimedTerm.toLowerCase(), province.getName().toLowerCase(), country.getIso(), new PageRequest(page, 20));
			} else if (country != null && province == null) {
				pageCity = cityRepo.searchCity(trimedTerm.toLowerCase(), null, country.getIso(), new PageRequest(page, 20));
			} else if (country == null && province != null) {
				pageCity = cityRepo.searchCity(trimedTerm.toLowerCase(), province.getName().toLowerCase(), new PageRequest(page, 20));
			} else {
				pageCity = cityRepo.searchCity(trimedTerm.toLowerCase(), new PageRequest(page, 20));
			}
			response.addAll(pageCity.getContent());
			response.setHasMore(!pageCity.isLastPage());
		}

		@Override
		public void toJson(City choice, JSONWriter writer) throws JSONException {
			writer.key("id").value(cityRepo.getKeyForCity(choice))
				.key("text").value(choice.getName())
				.key("country").value(choice.getCountry().getName())
				.key("countryCode").value(choice.getCountry().getIso());
		}

		@Override
		public Collection<City> toChoices(Collection<String> ids) {
			return FluentIterable.from(ids).transform(new Function<String, City>() {
				@Override @Nullable
				public City apply(@Nullable String input) {
					return cityRepo.getCity(input);
				}
			}).toSet();
		}
		
		@Override
		public void detach() {
			countryModel.detach();
			if(provinceModel != null){
				provinceModel.detach();
			}
			super.detach();
		}
		
	}
	
	public CitySelect2(final String id) {
		super(id, new Model<City>(), new CityProvider(new Model<Country>(), new Model<Province>()));
	}

	public CitySelect2(final String id, final IModel<City> model) {
		super(id, model, new CityProvider(new Model<Country>(), new Model<Province>()));
	}

	public CitySelect2(final String id, final IModel<City> model, final IModel<Province> provinceModel) {
		super(id, model, new CityProvider(new Model<Country>(), provinceModel));
	}
	
	public CitySelect2(final String id, final IModel<City> model, final IModel<Country> countryModel, final IModel<Province> provinceModel) {
		super(id, model, new CityProvider(countryModel, provinceModel));
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xxlarge"), " "));
		getSettings().getAjax().setQuietMillis(250);
		getSettings().setFormatResult(
				"function(object, container, query, escapeMarkup) {" +
				"container.append($('<span>').css({float: 'left', marginTop: '4px'}).attr({class: 'flag flag-' + object.countryCode.toLowerCase(), title: object.country}));" +
				"container.append(' ');" +
				"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
				"var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
				"  .append(textMarkup.join('')).append(' ').append($('<small>').text(object.country));" +
				"container.append(thediv);" +
				"}");
	}

}
