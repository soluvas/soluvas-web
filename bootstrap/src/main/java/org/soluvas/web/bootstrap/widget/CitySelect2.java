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

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.Select2Choice;

/**
 * @author rudi
 *
 */
public class CitySelect2 extends Select2Choice<City> {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory
			.getLogger(CitySelect2.CityProvider.class);
	
	private static class CityProvider extends ChoiceProvider<City> {
		
		@SpringBean
		private CityRepository cityRepo;
		
		public CityProvider() {
			super();
			Injector.get().inject(this);
		}

		@SuppressWarnings("null")
		@Override
		public void query(String term, int page, Response<City> response) {
			final String trimedTerm = term.trim();
			final Page<City> pageCity = cityRepo.searchCity(trimedTerm, new PageRequest(page, 20));
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
			super.detach();
		}
		
	}
	
	public CitySelect2(final String id) {
		super(id, new Model<City>(), new CityProvider());
	}

	public CitySelect2(final String id, final IModel<City> model) {
		super(id, model, new CityProvider());
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