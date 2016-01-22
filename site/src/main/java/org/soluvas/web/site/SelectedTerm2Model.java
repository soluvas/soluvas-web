package org.soluvas.web.site;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.Term;
import org.soluvas.data.Term2;

/**
 * For using single-select {@link DropDownChoice} components with {@link Term} model.
 * It's more memory efficient because doesn't save the whole {@link Term} object, just the {@link Term#getQName()}.
 * 
 * <p>Usage:
 * 
 * <pre>
 * @SpringBean(name="sizeTermRepo")
 * private TermRepository sizeTermRepo;
 * 
 * private final IModel<Term> selectedSizeModel = new SelectedTermModel(sizeTermRepo);
 * </pre>
 * 
 * @author ceefour
 */
public class SelectedTerm2Model extends Model<Term2> {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(SelectedTerm2Model.class);
	
	public SelectedTerm2Model(final Term2 term) {
		super(term);
	}

}