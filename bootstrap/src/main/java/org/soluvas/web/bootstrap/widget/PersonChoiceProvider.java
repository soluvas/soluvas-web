/**
 * 
 */
package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.wicket.model.IModel;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.web.site.EmfMapModel;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;

/**
 * @author mahendri
 *
 */
@SuppressWarnings("serial")
public class PersonChoiceProvider extends ChoiceProvider<SocialPerson> {
	
	private final LdapRepository<SocialPerson> personLdapRepo;
	private final ImageManager imageMgr;
	
	public PersonChoiceProvider(LdapRepository<SocialPerson> personLdapRepo, ImageManager imageMgr) {
		super();
		this.personLdapRepo = personLdapRepo;
		this.imageMgr = imageMgr;
	}

	/**
	 * Preload image URIs to make it quicker to display. 
	 */
	private final IModel<Map<String, DisplayImage>> displayImagesModel = new EmfMapModel<>(ImmutableMap.<String, DisplayImage>of());
	
	@Override
	public void query(final String term, int page, Response<SocialPerson> response) {
		final List<SocialPerson> matching = personLdapRepo.search(term);
		response.addAll(matching);
		// preload image URIs
		displayImagesModel.setObject( imageMgr.getSafeSocialPersonPhotos(ImageTypes.PERSON, matching, ImageStyles.THUMBNAIL) );
	}

	@Override
	public Collection<SocialPerson> toChoices(Collection<String> ids) {
		final List<SocialPerson> found = personLdapRepo.findAll(ids);
		// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
		if (!ids.isEmpty() && found.isEmpty()) {
			return ImmutableList.copyOf(new SocialPerson[] { null });
		} else {
			return found;
		}
	}
	
	@Override
	public void toJson(SocialPerson choice, JSONWriter writer)
			throws JSONException {
		writer.key("id").value(choice.getId())
			.key("customerId").value(choice.getId())
			.key("text").value(choice.getName())
			.key("genderIconUri").value(imageMgr.getPersonIconUri(choice.getGender()))
			.key("location").value(Optional.fromNullable(choice.getCity()).or(""));
		if (choice.getId() != null && displayImagesModel.getObject() != null) {
			final DisplayImage displayImage = displayImagesModel.getObject().get(choice.getId());
			if (displayImage != null) {
				writer.key("photoUri").value(displayImage.getSrc());
			}
		}
	}
	
}
