package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.Currency;
import java.util.Locale;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.commons.MoneyUtils;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.CityRepository;
import org.soluvas.web.site.CurrencyUnitModel;
import org.soluvas.web.site.FlagsCssResourceReference;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

/**
 * {@link Select2Choice} UI component for {@link CurrencyUnit}.
 *
 * @author ceefour
 */
public class CurrencyUnitSelect2 extends BootstrapSelect2Choice<CurrencyUnit> {

    private static class CurrencyUnitChoiceProvider extends ChoiceProvider<CurrencyUnit> {

        @Inject
        private CityRepository cityRepo;

        public CurrencyUnitChoiceProvider() {
            super();
            Injector.get().inject(this);
        }

        @Override
        public String getDisplayValue(CurrencyUnit choice) {
            return MoneyUtils.getName(Locale.US, choice);
        }

        @Override
        public String getIdValue(CurrencyUnit choice) {
            return choice.getCurrencyCode();
        }

        @Override
        public void query(String term, int page, Response<CurrencyUnit> response) {
        	final String trimmedTerm = Optional.fromNullable(term).or("").trim();
            final PageRequest pageable = new PageRequest(page, 20);
            final Collection<CurrencyUnit> unsorted = Monetary.getCurrencies();
            final ImmutableList<CurrencyUnit> sorted = Ordering.natural().immutableSortedCopy(
                    unsorted);
            final FluentIterable<CurrencyUnit> filtered = FluentIterable.from(sorted)
                    .filter(currency -> {
                        final String searchable = currency + " " + MoneyUtils.getSymbol(Locale.US, currency);
                        return StringUtils.containsIgnoreCase(searchable, trimmedTerm);
                    });
            response.addAll(filtered.skip((int) pageable.getOffset()).limit((int) pageable.getPageSize()).toList());
            response.setHasMore(!filtered.skip((int) ((page + 1) * pageable.getPageSize())).isEmpty());
        }

        @Override
        public Collection<CurrencyUnit> toChoices(Collection<String> ids) {
            return FluentIterable.from(ids).transform(new Function<String, CurrencyUnit>() {
                @Override
                @Nullable
                public CurrencyUnit apply(@Nullable String input) {
                    return Monetary.getCurrency(input);
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
            writer.key("id").value(choice.getCurrencyCode())
                    .key("text").value(MoneyUtils.getName(Locale.US, choice))
                    .key("c").value(Currency.getInstance(choice.getCurrencyCode()).getCurrencyCode()); // TODO: use a more JSR-354 way for this
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
        super(id, new CurrencyUnitModel(), new CurrencyUnitChoiceProvider());
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
        getSettings().setTemplateResult(
                "function(object) {" +
                "if (!object.id) return object.text;" +
                "var d1 = $('<span>').css({float: 'left', marginTop: '4px'}).attr({class: 'flag flag-' + object.c.toLowerCase(), title: object.text});" +
                "var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
                "  .append($('<span>').attr({'class': 'label label-default', 'style': 'display: inline-block; margin-right: 0.2em; vertical-align: text-top; width: 4em'}).text(object.id))" +
                "  .append(' ')" +
                "  .append(document.createTextNode(object.text));" +
                "return [d1, ' ', thediv];" +
                "}");
        getSettings().setTemplateSelection(
                "function(object) {" +
                "return [" +
                "  $('<span>').attr({'class': 'flag flag-' + object.c.toLowerCase(), 'title': object.text})," +
                "  ' '," +
                "  $('<span>').attr({'class': 'label label-default', 'style': 'display: inline-block; margin-right: 0.2em; vertical-align: text-top; width: 4em'}).text(object.id)," +
                "  ' '," +
                "  document.createTextNode(object.text) ];" +
                "}");
    }

}
