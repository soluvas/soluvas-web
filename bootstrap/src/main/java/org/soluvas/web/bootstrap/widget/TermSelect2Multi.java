package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.model.IModel;
import org.soluvas.data.Term;

import java.util.Collection;

/**
 * @author rudi
 *
 */
public class TermSelect2Multi extends BootstrapSelect2MultiChoice<Term> {
	
	public TermSelect2Multi(String id, IModel<? extends Collection<Term>> model,
			String kindNsPrefix, String kindName) {
		super(id, (IModel) model, new TermChoiceProvider(kindNsPrefix, kindName));
//		acColorTerm.add(new OnChangeAjaxBehavior() {
//			@Override
//			protected void onUpdate(AjaxRequestTarget target) {
//				log.debug("Selected color term is {}", selectedColorTermModel.getObject());
//			}
//		});
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
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
				"  var d1 = $('<img>').attr('src', object.imageUri);" +
				"} else if (object.color !== undefined && object.color != '') {" +
				"  var d1 = $('<span>').attr('style', 'background-color: ' + object.color + '; display: inline-block; width: 24px; border: 1px solid #999;').html('&nbsp;');" +
				"}" +
				"return [d1, ' ', document.createTextNode(object.text)];" +
				"}");
	}
	
}
