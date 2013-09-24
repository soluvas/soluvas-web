package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.ldap.LdapRepository;
import org.soluvas.ldap.SocialPerson;

import scala.actors.threadpool.Arrays;

import com.google.common.base.Optional;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.Select2Choice;

/**
 * @author adri
 *
 */
public class PersonSelect2 extends Select2Choice<SocialPerson> {

	private static final long serialVersionUID = 1L;

	private static class PersonChoiceProvider extends ChoiceProvider<SocialPerson> {

		private static final long serialVersionUID = 1L;

		/**
		 * Preload image URIs to make it quicker to display. 
		 */
		@Nullable
		private transient Map<String, DisplayImage> displayImages;

		@SpringBean(name="personLdapRepo")
		private LdapRepository<SocialPerson> personLdapRepo;
		@SpringBean
		private ImageManager imageMgr;
		
		public PersonChoiceProvider() {
			super();
			Injector.get().inject(this);
		}

		@Override
		public void query(final String term, int page, Response<SocialPerson> response) {
			final List<SocialPerson> matching = personLdapRepo.search(term);
			response.addAll(matching);
			// preload image URIs
			displayImages = imageMgr.getSafeSocialPersonPhotos(ImageTypes.PERSON, matching, ImageStyles.THUMBNAIL);
		}

		@Override
		public Collection<SocialPerson> toChoices(Collection<String> ids) {
			final List<SocialPerson> found = personLdapRepo.findAll(ids);
			// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
			if (!ids.isEmpty() && found.isEmpty()) {
				return Arrays.asList(new SocialPerson[] { null });
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
			if (displayImages != null && choice.getId() != null) {
				final DisplayImage displayImage = displayImages.get(choice.getId());
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

	public PersonSelect2(String id, IModel<SocialPerson> model) {
		super(id, model, new PersonChoiceProvider());
	}

	public PersonSelect2(String id) {
		super(id, new Model<SocialPerson>(), new PersonChoiceProvider());
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xxlarge"), " "));
		getSettings().getAjax().setQuietMillis(250);
		getSettings().setFormatResult(
			"function(object, container, query, escapeMarkup) {" +
			"container.append($('<img>').css({float: 'left'}).attr({src: object.photoUri, width: 50, height: 50}));" +		
			"container.append($('<img>').css({float: 'right', marginTop: '6px'}).attr('src', object.genderIconUri));" +
			"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
			"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append(textMarkup.join('')).append(' (ID : '+ object.customerId + ') <br>')" +
			"  .append($('<small>').css({color: '#666'}).text(object.location));" +
			"container.append(thediv);" +
			"thediv.css({height: '45px'});" +
			"}");
		getSettings().setFormatSelection(
				"function(object, container, query) {" +
				"container.append($('<img>').attr('src', object.genderIconUri));" +
				"container.append(' ');" +
				"container.append(document.createTextNode(object.text + '  (ID : ' +  object.customerId + ') '));" +
				"}");
	}

}
