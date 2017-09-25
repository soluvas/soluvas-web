package org.soluvas.web.bootstrap.widget;

import java.util.List;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.data.Term2;
import org.soluvas.data.entity.Value;
import org.wicketstuff.select2.Select2Choice;

/**
 * A {@link Select2Choice} autocomplete component that provides {@link Term2} as a choice.
 * @author rudi
 */
public class Term2Select2 extends BootstrapSelect2Choice<Term2> {
	
	private static final long serialVersionUID = 1L;

	public Term2Select2(String id, IModel<Term2> model, final String enumerationId) {
		super(id, model, new Term2ChoiceProvider(enumerationId));
	}
	
	public Term2Select2(String id, IModel<Term2> model, final IModel<String> enumerationIdModel) {
		super(id, model, new Term2ChoiceProvider(enumerationIdModel));
	}
	
	/**
	 * Filter only terms which match the values provided by whitelist. The whitelist can be dynamic.
	 * @param id
	 * @param model
	 * @param whitelistModel
	 */
	public Term2Select2(String id, IModel<Term2> model,
			final IModel<String> enumerationIdModel, final IModel<List<Value<?>>> whitelistModel) {
		super(id, model, new Term2ChoiceProvider(enumerationIdModel, whitelistModel));
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		// do NOT put this (getAjax()) in constructor, you'll get NPE
		getSettings().getAjax().setDelay(250);
		getSettings().setTemplateResult(
				"function(object) {" +
				"if (!object.id) return object.text;" +
				"var d1 = null;" +
				"if (object.imageUri !== undefined) {" +
				"  d1 = $('<img>').attr('src', object.imageUri);" +
				"} else if (object.color !== undefined && object.color != '') {" +
				"  d1 = $('<span>').attr('style', 'background-color: ' + object.color + '; display: inline-block; width: 24px; border: 1px solid #999;').html('&nbsp;');" +
				"}" +
				"return [d1, ' ', document.createTextNode(object.text)];" +
				"}");
		getSettings().setTemplateSelection(
				"function(object) {" +
				"var d1 = null;" +
				"if (object.imageUri !== undefined) {" +
				"  d1 = $('<img>').attr('src', object.imageUri);" +
				"} else if (object.color !== undefined && object.color != '') {" +
				"  d1 = $('<span>').attr('style', 'background-color: ' + object.color + '; display: inline-block; width: 24px; border: 1px solid #999;').html('&nbsp;');" +
				"}" +
				"return [d1, ' ', document.createTextNode(object.text)];" +
				"}");
		
		getSettings().setCloseOnSelect(true);
	}
	
}
