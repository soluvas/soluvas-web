package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.model.IModel;
import org.soluvas.data.Term;

import com.vaynberg.wicket.select2.Select2Choice;

/**
 * A {@link Select2Choice} autocomplete component that provides {@link Term} as a choice.
 * @author rudi
 */
@SuppressWarnings("serial")
public class TermSelect2 extends Select2Choice<Term> {
	
	public TermSelect2(String id, IModel<Term> model,
			String kindNsPrefix, String kindName) {
		super(id, model, new TermChoiceProvider(kindNsPrefix, kindName));
//		acColorTerm.add(new OnChangeAjaxBehavior() {
//			@Override
//			protected void onUpdate(AjaxRequestTarget target) {
//				log.debug("Selected color term is {}", selectedColorTermModel.getObject());
//			}
//		});
		getSettings().setFormatResult(
				"function(object, container, query) {" +
						"if (object.imageUri !== undefined) {" +
						"  container.append($('<img>').attr('src', object.imageUri));" +
						"  container.append(' ');" +
						"} else if (object.color !== undefined && object.color != '') {" +
						"  container.append($('<span>').attr('style', 'background-color: ' + object.color + '; display: inline-block; width: 24px; border: 1px solid #999;').html('&nbsp;'));" +
						"  container.append(' ');" +
						"}" +
						"container.append(document.createTextNode(object.text));" +
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
