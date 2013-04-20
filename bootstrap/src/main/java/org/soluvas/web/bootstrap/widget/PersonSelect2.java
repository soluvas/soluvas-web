package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.Select2Choice;

/**
 * @author adri
 *
 */
@SuppressWarnings("serial")
public class PersonSelect2 extends Select2Choice<SocialPerson> {

	@SpringBean(name="personLdapRepo")
	private LdapRepository<SocialPerson> personLdapRepo;
	@SpringBean
	private ImageManager imageMgr;
	
	private class PersonChoiceProvider extends ChoiceProvider<SocialPerson> {
		/**
		 * Preload image URIs to make it quicker to display. 
		 */
		private Map<String, DisplayImage> displayImages = ImmutableMap.of();
		
		@Override
		public void query(final String term, int page, Response<SocialPerson> response) {
			final List<SocialPerson> matching = personLdapRepo.search(term);
			response.addAll(matching);
			// preload image URIs
			displayImages = imageMgr.getSafePersonPhotos(ImageTypes.PERSON, matching, ImageStyles.THUMBNAIL);
		}

		@Override
		public Collection<SocialPerson> toChoices(Collection<String> ids) {
			return personLdapRepo.findAll(ids);
		}
		
		@Override
		public void toJson(SocialPerson choice, JSONWriter writer)
				throws JSONException {
			final DisplayImage displayImage = displayImages.get(choice.getId());
			writer.key("id").value(choice.getId())
				.key("text").value(choice.getName())
				.key("genderIconUri").value(imageMgr.getPersonIconUri(choice.getGender()))
				.key("photoUri").value(displayImage.getSrc())
				.key("location").value(Optional.fromNullable(choice.getCity()).or(""));
		}
	}

	public PersonSelect2(String id, IModel<SocialPerson> model) {
		super(id, model);
	}

	public PersonSelect2(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		setProvider(new PersonChoiceProvider());
		getSettings().setFormatResult(
			"function(object, container, query) {" +
			"container.append($('<img>').css({float: 'left'}).attr({src: object.photoUri, width: 50, height: 50}));" +		
			"container.append($('<img>').css({float: 'right', marginTop: '6px'}).attr('src', object.genderIconUri));" +
			"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append(document.createTextNode(object.text)).append('<br>')" +
			"  .append($('<small>').css({color: '#666'}).text(object.location));" +
			"container.append(thediv);" +
			"thediv.css({height: '50px'});" +
			"}");
		getSettings().setFormatSelection(
				"function(object, container, query) {" +
				"container.append($('<img>').attr('src', object.genderIconUri));" +
				"container.append(' ');" +
				"container.append(document.createTextNode(object.text));" +
				"}");
	}

}
