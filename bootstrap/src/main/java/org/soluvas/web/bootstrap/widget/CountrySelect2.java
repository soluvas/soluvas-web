package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.annotation.Nullable;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.Country;
import org.soluvas.geo.CountryRepository;
import org.soluvas.web.site.FlagsCssResourceReference;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;

/**
 * {@link Select2Choice} UI component for Joda {@link Country}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CountrySelect2 extends InteractiveSelect2Choice<Country> {

	private static class CountryChoiceProvider extends ChoiceProvider<Country> {

		@SpringBean
		private CountryRepository countryRepo;

		public CountryChoiceProvider() {
			super();
			Injector.get().inject(this);
		}

		@Override
		public String getDisplayValue(Country choice) {
			return choice.getName();
		}

		@Override
		public String getIdValue(Country choice) {
			return choice.getIso();
		}

		@Override
		public void query(String term, int page, Response<Country> response) {
			final String trimmedTerm = term.trim();
			final Page<Country> countries = countryRepo.searchCountry(trimmedTerm, new PageRequest(page, 20));
			response.addAll(countries.getContent());
			response.setHasMore(!countries.isLastPage());
		}

		@Override
		public Collection<Country> toChoices(Collection<String> ids) {
			return FluentIterable.from(ids).transform(new Function<String, Country>() {
				@Override @Nullable
				public Country apply(@Nullable String input) {
					return countryRepo.getCountry(input);
				}
			}).toSet();
		}
		
		@Override
		public void toJson(Country choice, JSONWriter writer)
				throws JSONException {
			writer.key("id").value(choice.getIso()).key("text").value(choice.getName());
		}
		
		@Override
		public void detach() {
			super.detach();
		}
		
	}

	public CountrySelect2(String id, IModel<Country> model) {
		super(id, model, new CountryChoiceProvider());
	}

	public CountrySelect2(String id) {
		super(id, new Model<Country>(), new CountryChoiceProvider());
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(FlagsCssResourceReference.INSTANCE));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		getSettings().getAjax().setDelay(400);
		getSettings().setFormatResult(
			"function(object, container, query, escapeMarkup) {" +
			"container.append($('<span>').css({float: 'left', marginTop: '4px'}).attr({class: 'flag flag-' + object.id.toLowerCase(), title: object.text}));" +
			"container.append(' ');" +
			"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
			"var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append(textMarkup.join(''));" +
			"container.append(thediv);" +
			"}");
		getSettings().setFormatSelection(
				"function(object, container, query) {" +
				"container.append($('<span>').attr({'class': 'flag flag-' + object.id.toLowerCase(), 'title': object.text}));" +
				"container.append(' ');" +
				"container.append(document.createTextNode(object.text));" +
				"}");
	}

}
