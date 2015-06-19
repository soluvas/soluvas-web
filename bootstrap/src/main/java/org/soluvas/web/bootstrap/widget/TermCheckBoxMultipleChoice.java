package org.soluvas.web.bootstrap.widget;

import java.util.List;

import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.soluvas.data.Term;
import org.soluvas.web.site.TermListModel;

/**
 * @author rudi
 *
 */
public class TermCheckBoxMultipleChoice extends CheckBoxMultipleChoice<Term> {
	
	private static final long serialVersionUID = 1L;
	
	private class TermIChoiceRenderer implements IChoiceRenderer<Term> {

		private static final long serialVersionUID = 1L;

		@Override
		public Object getDisplayValue(Term object) {
			return object.getDisplayName();
		}

		@Override
		public String getIdValue(Term object, int index) {
			return object.getQName();
		}
	}

	public TermCheckBoxMultipleChoice(final String id, final IModel<List<Term>> model,
			final String kindNsPrefix, final String kindName) {
		super(id, model, new TermListModel(kindNsPrefix, kindName));
		setChoiceRenderer(new TermIChoiceRenderer());
		setPrefix("<span style='margin-right: 7px;'>");
		setSuffix("</span>");
	}
	
	@Override
	protected void detachModel() {
		super.detachModel();
	}


}
