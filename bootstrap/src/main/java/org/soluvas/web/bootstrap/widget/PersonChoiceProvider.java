/**
 * 
 */
package org.soluvas.web.bootstrap.widget;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.model.IModel;
import org.soluvas.commons.Person;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.web.site.EmfMapModel;

import com.google.common.collect.ImmutableMap;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

/**
 * @author mahendri
 *
 */
public class PersonChoiceProvider extends ChoiceProvider<Person> {
	
	private final PersonRepository personRepo;
	private final ImageManager imageMgr;
	
	public PersonChoiceProvider(PersonRepository personRepo, ImageManager imageMgr) {
		super();
		this.personRepo = personRepo;
		this.imageMgr = imageMgr;
	}

	/**
	 * Preload image URIs to make it quicker to display. 
	 */
	private final IModel<Map<String, DisplayImage>> displayImagesModel = new EmfMapModel<>(ImmutableMap.<String, DisplayImage>of());

	@Override
	public String getDisplayValue(Person choice) {
		return choice.getName();
	}

	@Override
	public String getIdValue(Person choice) {
		return choice.getId();
	}

	@Override
	public void query(String term, int page, Response<Person> response) {
		term = term.trim();
		final PageRequest pageable = new PageRequest(page, 10L, Direction.ASC, "name");
		//FIXME: do not hard coded for STATUS
		final Page<Person> peoplePage = personRepo.findBySearchText(StatusMask.ACTIVE_ONLY, term, pageable);
		response.addAll(peoplePage.getContent());
		response.setHasMore(!peoplePage.isLastPage());
		// preload image URIs
		displayImagesModel.setObject( imageMgr.getSafePersonPhotos(ImageTypes.PERSON, peoplePage.getContent(), ImageStyles.THUMBNAIL) );
	}

	@Override
	public Collection<Person> toChoices(Collection<String> ids) {
		//FIXME: do not hard coded for STATUS
		final List<Person> found = personRepo.findAll(StatusMask.ACTIVE_ONLY, ids);
		// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
		if (!ids.isEmpty() && found.isEmpty()) {
			return Arrays.asList(new Person[] { null });
		} else {
			return found;
		}
	}
	
	@Override
	public void toJson(Person choice, JSONWriter writer)
			throws JSONException {
		writer.key("id").value(choice.getId())
			.key("customerId").value(choice.getId())
			.key("text").value(choice.getName())
			.key("genderIconUri").value(imageMgr.getPersonIconUri(choice.getGender()))
			.key("location").value(choice.getPrimaryAddress() != null ? choice.getPrimaryAddress().getCity() : "");
		if (choice.getId() != null && displayImagesModel.getObject() != null) {
			final DisplayImage displayImage = displayImagesModel.getObject().get(choice.getId());
			if (displayImage != null) {
				writer.key("photoUri").value(displayImage.getSrc());
			}
		}
	}
	
}
