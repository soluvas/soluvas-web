package org.soluvas.web.bootstrap.widget;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONStringer;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Quickly choose {@link Media}.
 * @todo Preview capability for {@code image/*} content types.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MediaMultiSelect extends BootstrapSelect2MultiChoice<Media> {

	private static class MediaChoiceProvider extends ChoiceProvider<Media> {

		@Inject
		private MediaRepository mediaRepo;
		
		public MediaChoiceProvider() {
			super();
			Injector.get().inject(this);
		}

		@Override
		public String getDisplayValue(Media choice) {
			return choice.getName();
		}

		@Override
		public String getIdValue(Media choice) {
			return choice.getId();
		}

		@Override
		public void query(String term, int page, Response<Media> response) {
			term = term.trim();
			// TODO: this is not practical when we've more than a thousand media documents, use Lucene or something
			final List<Media> all = mediaRepo.findAll(StatusMask.ACTIVE_ONLY, new CappedRequest(1000L)).getContent();
			for (final Media media : all) {
				if (StringUtils.containsIgnoreCase(media.getName(), term) || StringUtils.containsIgnoreCase(media.getId(), term)) {
					response.add(media);
				}
			}
		}

		@Override
		public Collection<Media> toChoices(Collection<String> ids) {
			//FIXME: do not hard coded for STATUS
			final List<Media> found = mediaRepo.findAll(/*StatusMask.ACTIVE_ONLY,*/ ids);
			// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
			if (!ids.isEmpty() && found.isEmpty()) {
				return Arrays.asList(new Media[] { null });
			} else {
				return found;
			}
		}
		
		@Override
		public void toJson(Media choice, JSONStringer writer)
				throws JSONException {
			writer.key("id").value(choice.getId())
				.key("text").value(choice.getName());
			if (choice.getAttachments().values().iterator().next().getContentType().startsWith("image/")) {
				final String mediaUri = mediaRepo.getPublicUri(choice);
				writer.key("mediaUri").value(mediaUri);
			} else {
				writer.key("mediaUri").value(null);
			}
		}
		
		@Override
		public void detach() {
			super.detach();
		}
		
	}


	/**
	 * @param id
	 * @param model
	 */
	@SuppressWarnings("unchecked")
	public MediaMultiSelect(String id, IModel<? extends Collection<Media>> model) {
		super(id, (IModel) model, new MediaChoiceProvider());
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		// do NOT put this (getAjax()) in constructor, you'll get NPE
		getSettings().getAjax().setDelay(250);
		getSettings().setTemplateResult(
				"function(object) {" +
				"if (!object.id) return object.text;" +
				"var d1 = $('<img>').css({float: 'left'}).attr({src: object.mediaUri, width: 50, height: 50});" +
				"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
				"  .append(document.createTextNode(object.text))" +
				"  ;" +
				"thediv.css({height: '45px'});" +
				"return [d1, thediv];" +
				"}");
		getSettings().setTemplateSelection(
				"function(object) {" +
				"return [" +
				"  $('<img>').attr({src: object.mediaUri, width: 50, height: 50})," +
				"  ' '," +
				"  document.createTextNode(object.text) ];" +
				"}");
	}

}
