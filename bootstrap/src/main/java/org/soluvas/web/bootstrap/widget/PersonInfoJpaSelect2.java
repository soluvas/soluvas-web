package org.soluvas.web.bootstrap.widget;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONStringer;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.image.DisplayImage2;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.jpa.jpa.PersonInfo;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import com.google.common.base.Optional;

/**
 * For without {@link ImageManager} dependency, use {@link TextPersonSelect2}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class PersonInfoJpaSelect2 extends BootstrapSelect2Choice<PersonInfo> {

	private static class PersonInfoJpaChoiceProvider extends ChoiceProvider<PersonInfo> {

		/**
		 * Preload image URIs to make it quicker to display. 
		 */
		@Nullable
		private transient Map<String, DisplayImage2> displayImages;

		@Inject
		private ImageManager imageMgr;

		private final IModel<List<PersonInfo>> personListModel;
		
		public PersonInfoJpaChoiceProvider(final IModel<List<PersonInfo>> personListModel) {
			super();
			Injector.get().inject(this);
			this.personListModel = personListModel;
		}

		@Override
		public String getDisplayValue(PersonInfo choice) {
			return choice.getName();
		}

		@Override
		public String getIdValue(PersonInfo choice) {
			return choice.getId();
		}

		@Override
		public void query(String term, int page, Response<PersonInfo> response) {
			final String timmedTerm = Optional.fromNullable(term).or("").trim();
			final List<PersonInfo> personList = personListModel.getObject();
			final List<PersonInfo> filteredPersonList = personList.stream().filter(new Predicate<PersonInfo>() {
				@Override
				public boolean test(PersonInfo t) {
					return t.getId().toLowerCase().startsWith(timmedTerm.toLowerCase()) ||
							t.getName().toLowerCase().startsWith(timmedTerm.toLowerCase());
				}
			}).collect(Collectors.toList());
			
			response.addAll(filteredPersonList);
			// preload image URIs
			displayImages = imageMgr.getSafePersonPhotos(ImageTypes.PERSON, filteredPersonList, ImageStyles.THUMBNAIL);
		}

		@Override
		public Collection<PersonInfo> toChoices(Collection<String> ids) {
			final List<PersonInfo> personList = personListModel.getObject();
			final List<PersonInfo> found = personList.stream().filter(new Predicate<PersonInfo>() {
				@Override
				public boolean test(PersonInfo t) {
					return ids.contains(t.getId());
				}
			}).collect(Collectors.toList());
			
			// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
			if (!ids.isEmpty() && found.isEmpty()) {
				return Arrays.asList(new PersonInfo[] { null });
			} else {
				return found;
			}
		}
		
		@Override
		public void toJson(PersonInfo choice, JSONStringer writer)
				throws JSONException {
			writer.key("id").value(choice.getId())
				.key("text").value(choice.getName())
				.key("genderIconUri").value(imageMgr.getPersonIconUri(choice.getGender()));
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
	
	private String inputSize = "xxlarge";

	public PersonInfoJpaSelect2(String id, IModel<PersonInfo> model, final IModel<List<PersonInfo>> personListModel) {
		super(id, model, new PersonInfoJpaChoiceProvider(personListModel));
	}

	public PersonInfoJpaSelect2(String id, final IModel<List<PersonInfo>> personListModel) {
		super(id, new Model<PersonInfo>(), new PersonInfoJpaChoiceProvider(personListModel));
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
				"  .append(document.createTextNode(object.text)).append(' (ID : '+ object.id + ') <br>')" +
				"  ;" +
				"thediv.css({height: '45px'});" +
				"return [d1, d2, thediv];" +
				"}");
		getSettings().setTemplateSelection(
					"function(object) {" +
					"return [" +
					"  $('<img>').attr('src', object.genderIconUri)," +
					"  ' '," +
					"  document.createTextNode(object.text + '  (ID : ' +  object.id + ') ') ];" +
					"}");
		getSettings().setCloseOnSelect(true);
	}

}
