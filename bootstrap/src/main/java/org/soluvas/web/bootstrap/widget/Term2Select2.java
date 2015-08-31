package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.data.Term2;

import com.vaynberg.wicket.select2.Select2Choice;

/**
 * A {@link Select2Choice} autocomplete component that provides {@link Term2} as a choice.
 * @author rudi
 */
public class Term2Select2 extends InteractiveSelect2Choice<Term2> {
	
	private static final long serialVersionUID = 1L;
	
	public Term2Select2(String id, IModel<Term2> model, final String enumerationId) {
		super(id, model, new Term2ChoiceProvider(enumerationId));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
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
	
}
