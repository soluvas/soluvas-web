package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONStringer;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Person2;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author ceefour
 */
public class TextPerson2Select2 extends BootstrapSelect2Choice<Person2> {
    private static final Logger log = LoggerFactory.getLogger(TextPerson2Select2.class);

    private static class PersonChoiceProvider extends ChoiceProvider<Person2> {

        @Inject
        private PersonRepository2 personRepo;
        @Inject
        private TenantRef tenant;

        public PersonChoiceProvider() {
            super();
            Injector.get().inject(this);
        }

        @Override
        public String getDisplayValue(Person2 choice) {
            return choice.getName();
        }

        @Override
        public String getIdValue(Person2 choice) {
            return choice.getId();
        }

        @Override
        public void query(String term, int page, Response<Person2> response) {
            term = term.trim();
            final PageRequest pageable = new PageRequest(page, 10, Sort.Direction.ASC, "name");
            //FIXME: do not hard coded for STATUS
            final Page<Person2> peoplePage = personRepo.findBySearchText(tenant.getTenantId(), StatusMask.ACTIVE_ONLY, term, pageable);
            response.addAll(peoplePage.getContent());
            response.setHasMore(!peoplePage.isLast());
        }

        @Override
        public Collection<Person2> toChoices(Collection<String> ids) {
            //FIXME: do not hard coded for STATUS
            final List<Person2> found = personRepo.findAll(tenant.getTenantId(), StatusMask.ACTIVE_ONLY, ids);
            // Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
            if (!ids.isEmpty() && found.isEmpty()) {
                return Arrays.asList(new Person2[]{null});
            } else {
                return found;
            }
        }

        @Override
        public void toJson(Person2 choice, JSONStringer writer)
                throws JSONException {
            writer.key("id").value(choice.getId())
                    .key("customerId").value(choice.getId())
                    .key("text").value(choice.getName());
            try {
                final String location = choice.getPrimaryAddress() != null ? choice.getPrimaryAddress().getCity() : "";
                writer.key("location").value(location);
            } catch (Exception e) { // org.hibernate.LazyInitializationException
                log.trace("Cannot get address for " + choice.getId(), e);
            }
        }

        @Override
        public void detach() {
            super.detach();
        }

    }

    private String inputSize = "xxlarge";

    public TextPerson2Select2(String id, IModel<Person2> model) {
        super(id, model, new PersonChoiceProvider());
    }

    public TextPerson2Select2(String id) {
        super(id, new Model<Person2>(), new PersonChoiceProvider());
    }

    public void setInputSize(String inputSize) {
        this.inputSize = inputSize;
    }

    public String getInputSize() {
        return inputSize;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AttributeAppender("class", new Model<>("input-" + inputSize), " "));
        getSettings().getAjax().setDelay(250);
        getSettings().setTemplateResult(
                "function(object) {" +
                "if (!object.id) return object.text;" +
                "var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
                "  .append(document.createTextNode(object.text)).append(' (ID : '+ object.customerId + ') <br>')" +
                "  .append($('<small>').css({color: '#666'}).text(object.location));" +
                "thediv.css({height: '45px'});" +
                "return thediv;" +
                "}");
        getSettings().setTemplateSelection(
                "function(object) {" +
                "var span = $('<span>').append(document.createTextNode(object.text + '  (ID : ' +  object.customerId + ') '));" +
                "return span;" +
                "}");
    }

}
