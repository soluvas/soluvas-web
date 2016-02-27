package org.soluvas.web.bootstrap.widget;

import java.util.List;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.data.Term;
import org.soluvas.data.Value;

import org.wicketstuff.select2.Select2Choice;

/**
 * A {@link Select2Choice} autocomplete component that provides {@link Term} as a choice.
 * @author rudi
 */
public class TermSelect2 extends InteractiveSelect2Choice<Term> {
	
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
	 * @param whitelistModel
	 */
	public TermSelect2(String id, IModel<Term> model,
			String kindNsPrefix, String kindName, final IModel<List<Value<?>>> whitelistModel) {
		super(id, model, new TermChoiceProvider(kindNsPrefix, kindName, whitelistModel));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		// do NOT put this (getAjax()) in constructor, you'll get NPE
		getSettings().getAjax().setDelay(250);
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
	
}
