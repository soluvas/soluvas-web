package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.http.WebRequest;
import org.soluvas.web.bootstrap.sound.Howler;
import org.soluvas.web.site.Interaction;

import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Select2Choice;

/**
 * Uses {@link Howler} to play sounds.
 * @author ceefour
 * @see InteractiveSelect2MultiChoice
 * @see Select2Bootstrap
 */
@SuppressWarnings("serial")
public class InteractiveSelect2Choice<T> extends Select2Choice<T> {

	public InteractiveSelect2Choice(String id, IModel<T> model,
			ChoiceProvider<T> provider) {
		super(id, model, provider);
	}

	public InteractiveSelect2Choice(String id, IModel<T> model) {
		super(id, model);
	}

	public InteractiveSelect2Choice(String id) {
		super(id);
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
