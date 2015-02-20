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
import org.soluvas.geo.District;
import org.soluvas.geo.DistrictRepository;

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
		
		public DistrictProvider(IModel<City> cityModel) {
			super();
			Injector.get().inject(this);
			this.cityModel = cityModel;
		}

		@SuppressWarnings("null")
		@Override
		public void query(String term, int page, Response<District> response) {
			final String trimedTerm = term.trim();
			final Page<District> pageDistrict; 
			@Nullable final City city = cityModel.getObject();
			if (city == null || !city.getCountry().getIso().equals("ID")) {
				pageDistrict = districtRepo.searchDistrict(trimedTerm, new PageRequest(page, 20));
			} else {
				pageDistrict = districtRepo.searchDistrictByCity(trimedTerm, city.getName(), new PageRequest(page, 20));
			}
			response.addAll(pageDistrict.getContent());
			response.setHasMore(!pageDistrict.isLastPage());
		}

		@Override
		public void toJson(District choice, JSONWriter writer) throws JSONException {
			writer.key("id").value(districtRepo.getKeyForDistrict(choice))
				.key("text").value(choice.getName())
				.key("country").value(choice.getCountry().getName())
				.key("countryCode").value(choice.getCountry().getIso());
		}

		@Override
		public Collection<District> toChoices(Collection<String> ids) {
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
			super.detach();
		}
		
	}

	public DistrictSelect2(final String id) {
		super(id, new Model<District>(), new DistrictProvider(new Model<City>()));
	}

	public DistrictSelect2(final String id, final IModel<District> model) {
		super(id, model, new DistrictProvider(new Model<City>()));
	}
	
	public DistrictSelect2(final String id, final IModel<District> model, final IModel<City> cityModel) {
		super(id, model, new DistrictProvider(cityModel));
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
