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
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.Country;
import org.soluvas.geo.Province;
import org.soluvas.geo.ProvinceRepository;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;

/**
 * @author anton
 *
 */

@SuppressWarnings("serial")
public class ProvinceSelect2 extends InteractiveSelect2Choice<Province>{
	
	
	private static class ProvinceProvider extends ChoiceProvider<Province>{
		
		@Inject
		private ProvinceRepository provinceRepo;
		
		private final IModel<Country> countryModel;
		
		public ProvinceProvider(IModel<Country> countryModel) {
			super();
			Injector.get().inject(this);
			this.countryModel = countryModel;
		}
		
		
		@Override
		public void query(String term, int page, Response<Province> response) {
			final String trimedTerm = term.trim();
			final Page<Province> pageProvince;
			@Nullable final Country country = countryModel.getObject();
//			if (country != null) {
//				pageProvince =  provinceRepo.searchProvince(trimedTerm, new PageRequest(page, 20));
//			} else {
//				pageProvince =  provinceRepo.searchProvince(trimedTerm, country.getIso(), new PageRequest(page, 20));
//			}
			pageProvince =  provinceRepo.searchProvince(trimedTerm, country != null ? country.getIso() : null, new PageRequest(page, 20));
			
			response.addAll(pageProvince.getContent());
			response.setHasMore(!pageProvince.isLastPage());
		}

		@Override
		public void toJson(Province choice, JSONWriter writer)
				throws JSONException {
			writer.key("id").value(provinceRepo.getKeyForProvince(choice))
				.key("text").value(choice.getName())
				.key("country").value(choice.getCountry().getName())
				.key("countryCode").value(choice.getCountry().getIso());
		}

		@Override
		public Collection<Province> toChoices(Collection<String> ids) {
			return FluentIterable.from(ids).transform(new Function<String, Province>() {
				@Override @Nullable
				public Province apply(@Nullable String input) {
					return provinceRepo.getProvinceByCountryAndName(input);
				}
			}).toSet();
		}
		
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

	public ProvinceSelect2(String id){
		super(id, new Model<Province>(), new ProvinceProvider(new Model<Country>()));
	}
	
	public ProvinceSelect2(String id, IModel<Province> curModel, IModel<Country> countryModel){
		super(id, new Model<Province>(), new ProvinceProvider(new Model<Country>()));
	}

}
