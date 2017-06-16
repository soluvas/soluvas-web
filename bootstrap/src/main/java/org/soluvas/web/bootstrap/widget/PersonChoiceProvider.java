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
import org.apache.wicket.model.util.MapModel;
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

import com.google.common.collect.ImmutableMap;

/**
 * @author mahendri
 *
 */
public class PersonChoiceProvider extends ChoiceProvider<Person2> {
	
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
	private final IModel<Map<String, DisplayImage2>> displayImagesModel = new MapModel<>(ImmutableMap.<String, DisplayImage2>of());

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
		final PageRequest pageable = new PageRequest(page, 10L, Direction.ASC, "name");
		//FIXME: do not hard coded for STATUS
		final Page<Person2> peoplePage = personRepo.findBySearchText(StatusMask.ACTIVE_ONLY, term, pageable);
		response.addAll(peoplePage.getContent());
		response.setHasMore(!peoplePage.isLastPage());
		// preload image URIs
		displayImagesModel.setObject( imageMgr.getSafePersonPhotos(ImageTypes.PERSON, peoplePage.getContent(), ImageStyles.THUMBNAIL) );
	}

	@Override
	public Collection<Person2> toChoices(Collection<String> ids) {
		//FIXME: do not hard coded for STATUS
		final List<Person2> found = personRepo.findAll(StatusMask.ACTIVE_ONLY, ids);
		// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
		if (!ids.isEmpty() && found.isEmpty()) {
			return Arrays.asList(new Person2[] { null });
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
		if (choice.getId() != null && displayImagesModel.getObject() != null) {
			final DisplayImage2 displayImage = displayImagesModel.getObject().get(choice.getId());
			if (displayImage != null) {
				writer.key("photoUri").value(displayImage.getSrc());
			}
		}
	}
	
}
