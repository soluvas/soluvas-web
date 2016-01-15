package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.http.WebRequest;
import org.soluvas.web.bootstrap.sound.Howler;
import org.soluvas.web.site.Interaction;

import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Select2MultiChoice;

/**
 * Uses {@link Howler} to play sounds.
 * @author ceefour
 * @see InteractiveSelect2Choice
 * @see Select2Bootstrap
 */
@SuppressWarnings("serial")
public class InteractiveSelect2MultiChoice<T> extends Select2MultiChoice<T> {

	/**
	 * @param id
	 */
	public InteractiveSelect2MultiChoice(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param model
	 */
	public InteractiveSelect2MultiChoice(String id, IModel<Collection<T>> model) {
		super(id, model);
	}

	/**
	 * @param id
	 * @param model
	 * @param provider
	 */
	public InteractiveSelect2MultiChoice(String id,
			IModel<Collection<T>> model, ChoiceProvider<T> provider) {
		super(id, model, provider);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		final String dataInteraction = Howler.play(Interaction.LOADING_LIGHT, Howler.getActive());
		getSettings().getAjax().setData(String
				.format("function(term, page) { " + dataInteraction + " return { term: term, page:page, '%s':true, '%s':[window.location.protocol, '//', window.location.host, window.location.pathname].join('')}; }",
					WebRequest.PARAM_AJAX, WebRequest.PARAM_AJAX_BASE_URL));
		final String resultsInteraction = Howler.play(Interaction.FILTERED, Howler.getActive());
		getSettings().getAjax().setResults("function(data, page) { " + resultsInteraction + " return data; }");
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(Select2Bootstrap.asHeaderItem());
	}
	
}
