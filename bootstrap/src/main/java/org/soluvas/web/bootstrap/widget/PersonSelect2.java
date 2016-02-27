package org.soluvas.web.bootstrap.widget;

import java.util.Arrays;
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
import org.soluvas.web.site.EmfModel;

import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

/**
 * For without {@link ImageManager} dependency, use {@link TextPersonSelect2}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class PersonSelect2 extends InteractiveSelect2Choice<Person> {

	private static class PersonChoiceProvider extends ChoiceProvider<Person> {

		/**
		 * Preload image URIs to make it quicker to display. 
		 */
		@Nullable
		private transient Map<String, DisplayImage> displayImages;

		@SpringBean
		private PersonRepository personRepo;
		@SpringBean
		private ImageManager imageMgr;
		
		public PersonChoiceProvider() {
			super();
			Injector.get().inject(this);
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
			displayImages = imageMgr.getSafePersonPhotos(ImageTypes.PERSON, peoplePage.getContent(), ImageStyles.THUMBNAIL);
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
	
	private String inputSize = "xxlarge";

	public PersonSelect2(String id, IModel<Person> model) {
		super(id, model, new PersonChoiceProvider());
	}

	public PersonSelect2(String id) {
		super(id, new EmfModel<Person>(), new PersonChoiceProvider());
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
