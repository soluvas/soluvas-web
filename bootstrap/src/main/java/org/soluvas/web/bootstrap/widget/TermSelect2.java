package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.data.Term;
import org.soluvas.data.Value;
import org.wicketstuff.select2.Select2Choice;

import java.util.List;

/**
 * A {@link Select2Choice} autocomplete component that provides {@link Term} as a choice.
 * @author rudi
 */
public class TermSelect2 extends BootstrapSelect2Choice<Term> {
	
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
	}
	
}
