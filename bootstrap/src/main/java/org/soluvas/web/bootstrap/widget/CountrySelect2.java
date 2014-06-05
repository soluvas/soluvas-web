package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.annotation.Nullable;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.CityRepository;
import org.soluvas.geo.Country;
import org.soluvas.web.site.FlagsCssResourceReference;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.Select2Choice;

/**
 * {@link Select2Choice} UI component for Joda {@link Country}.
 * @author ceefour
 */
public class CountrySelect2 extends InteractiveSelect2Choice<Country> {

	private static final long serialVersionUID = 1L;
	
	private static class CountryChoiceProvider extends ChoiceProvider<Country> {

		private static final long serialVersionUID = 1L;

		@SpringBean
		private CityRepository cityRepo;

		public CountryChoiceProvider() {
			super();
			Injector.get().inject(this);
		}

		@Override
		public void query(String term, int page, Response<Country> response) {
			final String trimmedTerm = term.trim();
			final Page<Country> countries = cityRepo.searchCountry(trimmedTerm, new PageRequest(page, 20));
			response.addAll(countries.getContent());
			response.setHasMore(!countries.isLastPage());
		}

		@Override
		public Collection<Country> toChoices(Collection<String> ids) {
			return FluentIterable.from(ids).transform(new Function<String, Country>() {
				@Override @Nullable
				public Country apply(@Nullable String input) {
					return cityRepo.getCountry(input);
				}
			}).toSet();
//			// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
//			if (!ids.isEmpty() && found.isEmpty()) {
//				return Arrays.asList(new Country[] { null });
//			} else {
//				return found;
//			}
		}
		
		@Override
		public void toJson(Country choice, JSONWriter writer)
				throws JSONException {
			writer.key("id").value(choice.getIso())
				.key("text").value(choice.getName());
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
		getSettings().getAjax().setQuietMillis(400);
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
