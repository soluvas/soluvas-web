package org.soluvas.web.bootstrap.widget;

import com.google.common.base.Strings;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONStringer;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.Country;
import org.soluvas.geo.CountryRepository;
import org.soluvas.web.site.FlagsCssResourceReference;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;

import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * {@link Select2Choice} UI component for Joda {@link Country#getCallingCodes()}.
 *
 * @author ceefour
 * @see CountrySelect2
 * @see org.soluvas.web.site.widget.CallingCodeChoice
 */
@SuppressWarnings("serial")
public class CallingCodeSelect2 extends BootstrapSelect2Choice<Country> {

    private static class CallingCodeChoiceProvider extends ChoiceProvider<Country> {
        private static final Logger log = LoggerFactory.getLogger(CallingCodeChoiceProvider.class);

        @Inject
        private CountryRepository countryRepo;

        public CallingCodeChoiceProvider() {
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
            final String trimmedTerm = Strings.nullToEmpty(term).trim();
            final Page<Country> countries = countryRepo.searchCountryWithCallingCode(trimmedTerm, new PageRequest(page, 20));
            response.addAll(countries.getContent());
            response.setHasMore(!countries.isLastPage());
            log.debug("Query {} {} = {}", term, page, countries.getContent());
        }

        @Override
        public Collection<Country> toChoices(Collection<String> ids) {
            return ids.stream().map(it -> countryRepo.getCountry(it)).collect(Collectors.toList());
        }

        @Override
        protected void toJson(Country choice, JSONStringer writer)
                throws JSONException {
            super.toJson(choice, writer);
            log.debug("toJson {}", choice);
            writer.key("callingCode").value(choice.getCallingCodes().get(0));
        }

    }

    public CallingCodeSelect2(String id, IModel<Country> model) {
        super(id, model, new CallingCodeChoiceProvider());
    }

    public CallingCodeSelect2(String id) {
        super(id, new Model<>(), new CallingCodeChoiceProvider());
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
                        "/*console.log('res', object);*/" +
                        "if (!object.id) return object.text;" +
                        "var theflag = $('<span>').css({float: 'left', marginTop: '4px'}).attr({class: 'flag flag-' + object.id.toLowerCase(), title: object.text});" +
                        "/*var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, true);*/" +
                        "var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
                        "  .append(document.createTextNode(object.text)).append(' ').append($('<code>').text('+' + object.callingCode));" +
                        "return [theflag, ' ', thediv];" +
                        "}");
//        getSettings().setTemplateSelection(
//                "function(object) {" +
//                        "/*console.log('sel', object);*/" +
//                        "return [ $('<span>').attr({'class': 'flag flag-' + object.id.toLowerCase(), 'title': object.text})," +
//                        "' '," +
//                        "document.createTextNode(object.text)," +
//                        "' '," +
//                        "$('<code>').text('+' + object.callingCode) ];" +
//                        "}");
        // FIXME: buggy toJson()?
        getSettings().setTemplateSelection(
                "function(object) {" +
                        "/*console.log('sel', object);*/" +
                        "return [ $('<span>').attr({'class': 'flag flag-' + object.id.toLowerCase(), 'title': object.text})," +
                        "' '," +
                        "document.createTextNode(object.text) ];" +
                        "}");
    }

}
