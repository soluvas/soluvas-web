package org.soluvas.web.bootstrap.widget;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.image.Media;
import org.soluvas.image.MediaRepository;

import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.Select2MultiChoice;

/**
 * Quickly choose {@link Media}.
 * @todo Preview capability for {@code image/*} content types.
 * @author ceefour
 */
public class MediaMultiSelect extends Select2MultiChoice<Media> {

	private static final long serialVersionUID = 1L;

	private static class MediaChoiceProvider extends ChoiceProvider<Media> {

		private static final long serialVersionUID = 1L;

		@SpringBean
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
	}

}
