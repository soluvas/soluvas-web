package org.soluvas.web.bootstrap.widget;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.commons.entity.Person2;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.image.DisplayImage2;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

@SuppressWarnings("serial")
public class PersonSelect2Multichoice extends BootstrapSelect2MultiChoice<Person2> {

    public PersonSelect2Multichoice(String id, IModel<Collection<Person2>> model) {
        super(id, model);
        setProvider(new Person2ChoiceProvider());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
        add(new AttributeModifier("placeholder", "Choose Person2"));
        getSettings().getAjax().setDelay(250);
    }

    @Override
    protected void onDetach() {
        super.onDetach();
    }

    private static class Person2ChoiceProvider extends ChoiceProvider<Person2> {

        /**
         * Preload image URIs to make it quicker to display.
         */
        @Nullable
        private transient Map<String, DisplayImage2> displayImages;

        @Inject
        private PersonRepository personRepo;
        @Inject
        private ImageManager imageMgr;

        public Person2ChoiceProvider() {
            super();
            Injector.get().inject(this);
        }

        @Override
        public String getDisplayValue(Person2 object) {
            return object.getName();
        }

        @Override
        public String getIdValue(Person2 object) {
            return object.getId();
        }

        @Override
        public void query(String term, int page, Response<Person2> response) {
            term = term.trim();
            final PageRequest pageable = new PageRequest(page, 10L, Direction.ASC, "name");
            //FIXME: do not hard coded for STATUS
            final Page<Person2> peoplePage = personRepo.findBySearchText(StatusMask.ACTIVE_ONLY, term, pageable);
            response.addAll(peoplePage.getContent());
            response.setHasMore(!peoplePage.isLastPage());
            // preload image URIs
            displayImages = imageMgr.getSafePersonPhotos(ImageTypes.PERSON, peoplePage.getContent(), ImageStyles.THUMBNAIL);
        }

        @Override
        public Collection<Person2> toChoices(Collection<String> ids) {
            //FIXME: do not hard coded for STATUS
            final List<Person2> found = personRepo.findAll(StatusMask.ACTIVE_ONLY, ids);
            // Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
            if (!ids.isEmpty() && found.isEmpty()) {
                return Arrays.asList(new Person2[]{null});
            } else {
                return found;
            }
        }

        @Override
        public void toJson(Person2 choice, JSONWriter writer)
                throws JSONException {
            writer.key("id").value(choice.getId())
                    .key("customerId").value(choice.getId())
                    .key("text").value(choice.getName())
                    .key("genderIconUri").value(imageMgr.getPersonIconUri(choice.getGender()))
                    .key("location").value(choice.getPrimaryAddress() != null ? choice.getPrimaryAddress().getCity() : "");
            if (displayImages != null && choice.getId() != null) {
                final DisplayImage2 displayImage = displayImages.get(choice.getId());
                if (displayImage != null) {
                    writer.key("photoUri").value(displayImage.getSrc());
                }
            }
        }

        @Override
        public void detach() {
            super.detach();
        }

    }
}
