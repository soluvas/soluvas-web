package org.soluvas.web.bootstrap.widget;

import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.domain.PageRequest;

/**
 * @author rudi
 *
 */
public class TermCheckBoxMultipleChoice extends CheckBoxMultipleChoice<Term> {
	
	private static final long serialVersionUID = 1L;
	
	@SpringBean(name="shoeSizeTermRepo")
	private TermRepository shoeSizeTermRepo;
	
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
		//FIXME: harusnya pake TermListModel, tapi karena ada di soluvas, tidak bisa di pakai dlo karena bentrok ama versi 6.2
//		super(id, model, new TermListModel(kindNsPrefix, kindName));
		super(id);
		Injector.get().inject(this);
		setModel( (IModel) model);
		setChoices(new ListModel<>(shoeSizeTermRepo.findAll(new PageRequest(0, 5000)).getContent()));
		setChoiceRenderer(new TermIChoiceRenderer());
		setPrefix("<span style='margin-right: 7px;'>");
		setSuffix("</span>");
	}
	
	@Override
	protected void detachModel() {
		super.detachModel();
	}


}
