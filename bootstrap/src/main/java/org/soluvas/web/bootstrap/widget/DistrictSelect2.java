package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.json.JSONException;
import org.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.City;
import org.soluvas.geo.Country;
import org.soluvas.geo.District;
import org.soluvas.geo.DistrictRepository;
import org.soluvas.geo.Province;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;

/**
 * @author anton
 *
 */
@SuppressWarnings("serial")
public class DistrictSelect2 extends InteractiveSelect2Choice<District> {
	
	private static final Logger log = LoggerFactory
			.getLogger(DistrictSelect2.class);
	
	private static class DistrictProvider extends ChoiceProvider<District> {
		
		@Inject
		private DistrictRepository districtRepo;
		
		private final IModel<City> cityModel;

		private final IModel<Province> provinceModel;

		private final IModel<Country> countryModel;
		
		public DistrictProvider(IModel<City> cityModel, IModel<Province> provinceModel,
				IModel<Country>countryModel) {
			super();
			Injector.get().inject(this);
			this.cityModel = cityModel;
			this.provinceModel = provinceModel;
			this.countryModel = countryModel;
			
//			log.debug("Contructor districtSelect2 for city {}, province {} and country {}", cityModel.getObject(), provinceModel.getObject(), countryModel.getObject());
		}

		@SuppressWarnings("null")
		@Override
		public void query(String term, int page, Response<District> response) {
			
			@Nullable final City city = cityModel.getObject();
			@Nullable final Province province = provinceModel.getObject();
			@Nullable final Country country = countryModel.getObject();
			
			final String trimedTerm = term.trim();
			final Page<District> pageDistrict; 
			log.debug("Querying districtSelect2 for term '{}', city {}, province {} and country {}", trimedTerm, city, province, country);
			if (city != null && province != null && country != null){
				pageDistrict = districtRepo.searchDistrict(trimedTerm.toLowerCase()
						, new PageRequest(page, 20), city.getName(), province.getName(), country.getIso());
			} else if (city != null && province == null && country == null){
				pageDistrict = districtRepo.searchDistrict(trimedTerm.toLowerCase()
						, new PageRequest(page, 20), city.getName(), null, null);
			} else if (city != null && province != null && country == null){
				pageDistrict = districtRepo.searchDistrict(trimedTerm.toLowerCase()
						, new PageRequest(page, 20), city.getName(), province.getName(), null);
			} else if (city != null && province == null && country != null){
				pageDistrict = districtRepo.searchDistrict(trimedTerm.toLowerCase()
						, new PageRequest(page, 20), city.getName(), null, country.getIso());
			} else if (city == null && province != null && country != null){
				pageDistrict = districtRepo.searchDistrict(trimedTerm.toLowerCase()
						, new PageRequest(page, 20), null, province.getName(), country.getIso());
			} else if (city == null && province != null && country == null){
				pageDistrict = districtRepo.searchDistrict(trimedTerm.toLowerCase()
						, new PageRequest(page, 20), null, province.getName(), null);
			} else if (city == null && province == null && country != null){
				 pageDistrict = districtRepo.searchDistrict(trimedTerm.toLowerCase()
						 , new PageRequest(page, 20), null, null, country.getIso());
			} else {
				pageDistrict = districtRepo.searchDistrict(trimedTerm.toLowerCase()
						 , new PageRequest(page, 20), null, null, null);
			}
			
			response.addAll(pageDistrict.getContent());
			response.setHasMore(!pageDistrict.isLastPage());
		}

		@Override
		public void toJson(District choice, JSONWriter writer) throws JSONException {
//			log.debug("District.toJson {}", choice);
			writer.key("id").value(districtRepo.getKeyForDistrict(choice))
				.key("text").value(choice.getName())
				.key("country").value(choice.getCountry().getName())
				.key("countryCode").value(choice.getCountry().getIso());
		}

		@Override
		public Collection<District> toChoices(Collection<String> ids) {
//			log.debug("District.toChoices {}", ids);
			return FluentIterable.from(ids).transform(new Function<String, District>() {
				@Override @Nullable
				public District apply(@Nullable String input) {
					return districtRepo.getDistrict(input);
				}
			}).toSet();
		}
		
		@Override
		public void detach() {
			cityModel.detach();
			provinceModel.detach();
			countryModel.detach();
			super.detach();
		}
		
	}

	public DistrictSelect2(final String id) {
		super(id, new Model<District>(), new DistrictProvider(new Model<City>(), new Model<Province>(), new Model<Country>()));
	}

	public DistrictSelect2(final String id, final IModel<District> districtModel) {
		super(id, districtModel, new DistrictProvider(new Model<City>(), new Model<Province>(), new Model<Country>()));
	}
	
	public DistrictSelect2(final String id, final IModel<District> districtModel, final IModel<City> cityModel) {
		super(id, districtModel, new DistrictProvider(cityModel, new Model<Province>(), new Model<Country>()));
	}
	public DistrictSelect2(final String id, final IModel<District> districtModel, final IModel<City> cityModel, final IModel<Province> provinceModel) {
		super(id, districtModel, new DistrictProvider(cityModel, provinceModel, new Model<Country>()));
	}
	public DistrictSelect2(final String id, final IModel<District> districtModel, final IModel<City> cityModel, final IModel<Province> provinceModel,
			final IModel<Country> countryModel) {
		super(id, districtModel, new DistrictProvider(cityModel, provinceModel, countryModel));
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
