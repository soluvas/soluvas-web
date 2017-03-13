package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.geo.City;
import org.soluvas.geo.CityRepository;
import org.soluvas.geo.Country;
import org.soluvas.geo.Province;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;

/**
 * @author rudi
 */
@SuppressWarnings("serial")
public class CitySelect2 extends BootstrapSelect2Choice<City> {

    private static final Logger log = LoggerFactory
            .getLogger(CitySelect2.class);

    private static class CityProvider extends ChoiceProvider<City> {

        @Inject
        private CityRepository cityRepo;
        private final IModel<Country> countryModel;
        private final IModel<Province> provinceModel;

        public CityProvider(final IModel<Country> countryModel, final IModel<Province> provinceModel) {
            super();
            Injector.get().inject(this);
            this.countryModel = countryModel;
            this.provinceModel = provinceModel;
//			log.debug("Province: {}", provinceModel.getObject());
        }

        @Override
        public String getDisplayValue(City choice) {
            return choice.getName();
        }

        @Override
        public String getIdValue(City choice) {
            return cityRepo.getKeyForCity(choice);
        }

        @SuppressWarnings("null")
        @Override
        public void query(String term, int page, Response<City> response) {
            final String trimedTerm = Strings.nullToEmpty(term).trim();
            @Nullable final Country country = countryModel.getObject();
            @Nullable final Province province = provinceModel.getObject();
//			@Nullable Province province = null;
//			if (provinceModel != null){
//				province = provinceModel.getObject();
//			}
            final Page<City> pageCity;
            if (country != null && province != null) {
                log.debug("Querying city by country {}, province {}, and trimmedTerm '{}'",
                        country, province, trimedTerm);
                pageCity = cityRepo.searchCity(trimedTerm.toLowerCase(), province.getName().toLowerCase(), country.getIso(), new PageRequest(page, 20));
            } else if (country != null && province == null) {
                log.debug("Querying city by country {} and trimmedTerm '{}'", country, trimedTerm);
                pageCity = cityRepo.searchCity(trimedTerm.toLowerCase(), null, country.getIso(), new PageRequest(page, 20));
            } else if (country == null && province != null) {
                log.debug("Querying city by province {} and trimmedTerm '{}'", province, trimedTerm);
                pageCity = cityRepo.searchCity(trimedTerm.toLowerCase(), province.getName().toLowerCase(), new PageRequest(page, 20));
            } else {
                log.debug("Querying city by trimmedTerm '{}'", trimedTerm);
                pageCity = cityRepo.searchCity(trimedTerm.toLowerCase(), new PageRequest(page, 20));
            }
            response.addAll(pageCity.getContent());
            response.setHasMore(!pageCity.isLastPage());
        }

        @Override
        public void toJson(City choice, JSONWriter writer) throws JSONException {
            super.toJson(choice, writer);
            writer.key("country").value(choice.getCountry().getName())
                    .key("countryCode").value(choice.getCountry().getIso());
        }

        @Override
        public Collection<City> toChoices(Collection<String> ids) {
            return FluentIterable.from(ids).transform(new Function<String, City>() {
                @Override
                @Nullable
                public City apply(@Nullable String input) {
                    return cityRepo.getCity(input);
                }
            }).toSet();
        }

        @Override
        public void detach() {
            countryModel.detach();
//			if(provinceModel != null){
            provinceModel.detach();
//			}
            super.detach();
        }

    }

    public CitySelect2(final String id) {
        super(id, new Model<>(), new CityProvider(new Model<>(), new Model<>()));
    }

    public CitySelect2(final String id, final IModel<City> model) {
        super(id, model, new CityProvider(new Model<>(), new Model<>()));
    }

    public CitySelect2(final String id, final IModel<City> model, final IModel<Province> provinceModel) {
        super(id, model, new CityProvider(new Model<>(), provinceModel));
    }

    public CitySelect2(final String id, final IModel<City> model, final IModel<Country> countryModel, final IModel<Province> provinceModel) {
        super(id, model, new CityProvider(countryModel, provinceModel));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AttributeAppender("class", new Model<>("input-xxlarge"), " "));
        getSettings().getAjax().setDelay(250);
        getSettings().setCloseOnSelect(true);
        getSettings().setTemplateResult(
                "function(object) {" +
                        "if (!object.id) return object.text;" +
                        "var theflag = $('<span>').css({float: 'left', marginTop: '4px'}).attr({class: 'flag flag-' + object.countryCode.toLowerCase(), title: object.country});" +
                        "var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
                        "  .append(document.createTextNode(object.text)).append(' ').append($('<small>').text(object.country));" +
                        "return [theflag, ' ', thediv];" +
                        "}");
    }

}
