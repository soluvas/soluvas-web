package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.Currency;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.joda.money.CurrencyUnit;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.CityRepository;
import org.soluvas.web.site.FlagsCssResourceReference;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.Select2Choice;

/**
 * {@link Select2Choice} UI component for {@link CurrencyUnit}.
 * @author ceefour
 */
public class CurrencyUnitSelect2 extends InteractiveSelect2Choice<CurrencyUnit> {

	private static final long serialVersionUID = 1L;
	
	private static class CurrencyUnitChoiceProvider extends ChoiceProvider<CurrencyUnit> {

		private static final long serialVersionUID = 1L;

		@SpringBean
		private CityRepository cityRepo;
		
		public CurrencyUnitChoiceProvider() {
			super();
			Injector.get().inject(this);
		}

		@Override
		public void query(String term, int page, Response<CurrencyUnit> response) {
			final String trimmedTerm = term.trim();
			final PageRequest pageable = new PageRequest(page, 20);
			final List<CurrencyUnit> sorted = CurrencyUnit.registeredCurrencies();
//			final ImmutableList<CurrencyUnit> sorted = CurrencyUnitOrdering.INSTANCE.immutableSortedCopy(Arrays.asList(CurrencyUnit.getAvailableCurrencyUnits()));
			final FluentIterable<CurrencyUnit> filtered = FluentIterable.from(sorted)
				.filter(new Predicate<CurrencyUnit>() {
					@Override
					public boolean apply(@Nullable CurrencyUnit currency) {
						final String searchable = currency + " " + currency.getSymbol();
						return StringUtils.containsIgnoreCase(searchable, trimmedTerm);
					}
				});
			response.addAll(filtered.skip((int) pageable.getOffset()).limit((int) pageable.getPageSize()).toList());
			response.setHasMore(!filtered.skip((int) ((page + 1) * pageable.getPageSize())).isEmpty());
		}

		@Override
		public Collection<CurrencyUnit> toChoices(Collection<String> ids) {
			return FluentIterable.from(ids).transform(new Function<String, CurrencyUnit>() {
				@Override @Nullable
				public CurrencyUnit apply(@Nullable String input) {
					return CurrencyUnit.of(input);
				}
			}).toSet();
//			// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
//			if (!ids.isEmpty() && found.isEmpty()) {
//				return Arrays.asList(new CurrencyUnit[] { null });
//			} else {
//				return found;
//			}
		}
		
		@Override
		public void toJson(CurrencyUnit choice, JSONWriter writer)
				throws JSONException {
			writer.key("id").value(choice.getCode())
				.key("text").value(Currency.getInstance(choice.getCode()).getDisplayName())
				.key("c").value(Iterables.getFirst(choice.getCountryCodes(), null));
		}
		
		@Override
		public void detach() {
			super.detach();
		}
		
	}

	public CurrencyUnitSelect2(String id, IModel<CurrencyUnit> model) {
		super(id, model, new CurrencyUnitChoiceProvider());
	}

	public CurrencyUnitSelect2(String id) {
		super(id, new Model<CurrencyUnit>(), new CurrencyUnitChoiceProvider());
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
			"container.append($('<span>').css({float: 'left', marginTop: '4px'}).attr({class: 'flag flag-' + object.c.toLowerCase(), title: object.text}));" +
			"container.append(' ');" +
			"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
			"var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append($('<span>').attr({'class': 'label label-default', 'style': 'display: inline-block; margin-right: 0.2em; vertical-align: text-top; width: 4em'}).text(object.id))" +
			"  .append(' ')" +
			"  .append(textMarkup.join(''));" +
			"container.append(thediv);" +
			"}");
		getSettings().setFormatSelection(
				"function(object, container, query) {" +
				"container.append($('<span>').attr({'class': 'flag flag-' + object.c.toLowerCase(), 'title': object.text}));" +
				"container.append(' ');" +
				"container.append($('<span>').attr({'class': 'label label-default', 'style': 'display: inline-block; margin-right: 0.2em; vertical-align: text-top; width: 4em'}).text(object.id));" +
				"container.append(' ');" +
				"container.append(document.createTextNode(object.text));" +
				"}");
	}

}
