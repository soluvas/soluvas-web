package org.soluvas.web.bootstrap.widget;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;

import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;

/**
 * Quickly choose {@link Media}.
 * @todo Preview capability for {@code image/*} content types.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class MediaMultiSelect extends InteractiveSelect2MultiChoice<Media> {

	private static class MediaChoiceProvider extends ChoiceProvider<Media> {

		@Inject
		private MediaRepository mediaRepo;
		
		public MediaChoiceProvider() {
			super();
			Injector.get().inject(this);
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
		public void toJson(Media choice, JSONWriter writer)
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
		getSettings().getAjax().setQuietMillis(250);
		getSettings().setFormatResult(
				"function(object, container, query, escapeMarkup) {" +
				"container.append($('<img>').css({float: 'left'}).attr({src: object.mediaUri, width: 50, height: 50}));" +		
				"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
				"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
				"  .append(textMarkup.join(''))" +
				"  ;" +
				"container.append(thediv);" +
				"thediv.css({height: '45px'});" +
				"}");
		getSettings().setFormatSelection(
				"function(object, container, query) {" +
				"container.append($('<img>').attr({src: object.mediaUri, width: 50, height: 50}));" +
				"container.append(' ');" +
				"container.append(document.createTextNode(object.text));" +
				"}");
	}

}
