package org.soluvas.web.bootstrap.widget;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.locale.LocaleOrdering;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.CityRepository;
import org.soluvas.web.site.FlagsCssResourceReference;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;

/**
 * {@link Select2Choice} UI component for {@link Locale}.
 * @author ceefour
 */
public class LocaleSelect2 extends InteractiveSelect2Choice<Locale> {

	private static class LocaleChoiceProvider extends ChoiceProvider<Locale> {

		/**
		 * static cache to make it faster to search
		 */
		private static final ImmutableList<Locale> sorted = 
				LocaleOrdering.INSTANCE.immutableSortedCopy(Arrays.asList(Locale.getAvailableLocales()));

		@SpringBean
		private CityRepository cityRepo;
		
		public LocaleChoiceProvider() {
			super();
			Injector.get().inject(this);
		}

		@Override
		public String getDisplayValue(Locale choice) {
			return choice.getDisplayName();
		}

		@Override
		public String getIdValue(Locale choice) {
			return choice.toLanguageTag();
		}

		@Override
		public void query(String term, int page, Response<Locale> response) {
			final String trimmedTerm = term.trim();
			final PageRequest pageable = new PageRequest(page, 20);
			final FluentIterable<Locale> filtered = FluentIterable.from(sorted)
				.filter(locale -> {
                    final String searchable = locale.toLanguageTag() + " " + locale.getDisplayName();
                    return StringUtils.containsIgnoreCase(searchable, trimmedTerm);
                });
			response.addAll(filtered.skip((int) pageable.getOffset()).limit((int) pageable.getPageSize()).toList());
			response.setHasMore(!filtered.skip((int) ((page + 1) * pageable.getPageSize())).isEmpty());
		}

		@Override
		public Collection<Locale> toChoices(Collection<String> ids) {
			return FluentIterable.from(ids).transform(new Function<String, Locale>() {
				@Override @Nullable
				public Locale apply(@Nullable String input) {
					return Locale.forLanguageTag(input);
				}
			}).toSet();
//			// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
//			if (!ids.isEmpty() && found.isEmpty()) {
//				return Arrays.asList(new Locale[] { null });
//			} else {
//				return found;
//			}
		}
		
		@Override
		public void toJson(Locale choice, JSONWriter writer)
				throws JSONException {
			writer.key("id").value(choice.toLanguageTag())
				.key("text").value(choice.getDisplayName())
				.key("c").value(choice.getCountry());
		}
		
		@Override
		public void detach() {
			super.detach();
		}
		
	}

	public LocaleSelect2(String id, IModel<Locale> model) {
		super(id, model, new LocaleChoiceProvider());
	}

	public LocaleSelect2(String id) {
		super(id, new Model<Locale>(), new LocaleChoiceProvider());
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
			"container.append($('<span>').css({float: 'left', marginTop: '4px'}).attr({class: 'flag flag-' + object.c.toLowerCase(), title: object.text}));" +
			"container.append(' ');" +
			"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
			"var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append(textMarkup.join(''));" +
			"container.append(thediv);" +
			"}");
		getSettings().setFormatSelection(
				"function(object, container, query) {" +
				"container.append($('<span>').attr({'class': 'flag flag-' + object.c.toLowerCase(), 'title': object.text}));" +
				"container.append(' ');" +
				"container.append(document.createTextNode(object.text));" +
				"}");
	}

}
