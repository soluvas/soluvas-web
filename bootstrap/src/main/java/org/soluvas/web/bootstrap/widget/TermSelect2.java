package org.soluvas.web.bootstrap.widget;

import java.util.List;

import org.apache.wicket.model.IModel;
import org.soluvas.data.Term;
import org.soluvas.data.Value;

import com.vaynberg.wicket.select2.Select2Choice;

/**
 * A {@link Select2Choice} autocomplete component that provides {@link Term} as a choice.
 * @author rudi
 */
public class TermSelect2 extends Select2Choice<Term> {
	
	private static final long serialVersionUID = 1L;
	
	private TermChoiceProvider choiceProvider;

	public TermSelect2(String id, IModel<Term> model,
			String kindNsPrefix, String kindName) {
		super(id, model, new TermChoiceProvider(kindNsPrefix, kindName));
	}
	
	/**
	 * Filter only terms which match the values provided by whitelist. The whitelist can be dynamic.
	 * @param id
	 * @param model
	 * @param kindNsPrefix
	 * @param kindName
	 * @param whitelist
	 */
	public TermSelect2(String id, IModel<Term> model,
			String kindNsPrefix, String kindName, final IModel<List<Value<?>>> whitelist) {
		super(id, model);
		choiceProvider = new TermChoiceProvider(kindNsPrefix, kindName, whitelist);
		setProvider(choiceProvider);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		// do NOT put this (getAjax()) in constructor, you'll get NPE
		getSettings().getAjax().setQuietMillis(250);
		getSettings().setFormatResult(
				"function(object, container, query, escapeMarkup) {" +
						"if (object.imageUri !== undefined) {" +
						"  container.append($('<img>').attr('src', object.imageUri));" +
						"  container.append(' ');" +
						"} else if (object.color !== undefined && object.color != '') {" +
						"  container.append($('<span>').attr('style', 'background-color: ' + object.color + '; display: inline-block; width: 24px; border: 1px solid #999;').html('&nbsp;'));" +
						"  container.append(' ');" +
						"}" +
						"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
						"container.append(textMarkup.join(''));" +
				"}");
		getSettings().setFormatSelection(
				"function(object, container) {" +
						"if (object.imageUri !== undefined) {" +
						"  container.append($('<img>').attr('src', object.imageUri));" +
						"  container.append(' ');" +
						"} else if (object.color !== undefined && object.color != '') {" +
						"  container.append($('<span>').attr('style', 'background-color: ' + object.color + '; display: inline-block; width: 24px; border: 1px solid #999;').html('&nbsp;'));" +
						"  container.append(' ');" +
						"}" +
						"container.append(document.createTextNode(object.text));" +
				"}");
	}
	
	@Override
	protected void detachModel() {
		choiceProvider.detach();
		super.detachModel();
	}
	
}
