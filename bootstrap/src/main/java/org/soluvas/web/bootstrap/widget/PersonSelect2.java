package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
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

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * For without {@link ImageManager} dependency, use {@link TextPersonSelect2}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class PersonSelect2 extends BootstrapSelect2Choice<Person> {

	private static class PersonChoiceProvider extends ChoiceProvider<Person> {

		/**
		 * Preload image URIs to make it quicker to display. 
		 */
		@Nullable
		private transient Map<String, DisplayImage> displayImages;

		@Inject
		private PersonRepository personRepo;
		@Inject
		private ImageManager imageMgr;
		
		public PersonChoiceProvider() {
			super();
			Injector.get().inject(this);
		}

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
		getSettings().setTemplateResult(
			"function(object) {" +
			"if (!object.id) return object.text;" +
			"var d1 = $('<img>').css({float: 'left'}).attr({src: object.photoUri, width: 50, height: 50});" +
			"var d2 = $('<img>').css({float: 'right', marginTop: '6px'}).attr('src', object.genderIconUri);" +
			"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append(document.createTextNode(object.text)).append(' (ID : '+ object.customerId + ') <br>')" +
			"  .append($('<small>').css({color: '#666'}).text(object.location));" +
			"thediv.css({height: '45px'});" +
			"return [d1, d2, thediv];" +
			"}");
		getSettings().setTemplateSelection(
				"function(object) {" +
				"return [" +
				"  $('<img>').attr('src', object.genderIconUri)," +
				"  ' '," +
				"  document.createTextNode(object.text + '  (ID : ' +  object.customerId + ') ') ];" +
				"}");
	}

}
