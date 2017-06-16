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
public class SelectedTermModel extends Model<Term2> {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(SelectedTermModel.class);
	
//	private final TermRepository termRepo;
//	private String qName = "";
	
//	/**
//	 * @param termRepo Term repository that must be a {@link SpringBean} proxy.
//	 */
//	public SelectedTermModel(TermRepository termRepo) {
//		super();
//		this.termRepo = termRepo;
//	}
	
	public SelectedTermModel(final Term2 term) {
		super(term);
	}

//	@Override
//	protected Term load() {
//		log.debug("Loading term by qName: {}", qName);
//		return !qName.isEmpty() ? termRepo.findOne(qName) : null;
//	}
//
//	@Override
//	public void detach() {
//		super.detach();
//		qName = getObject() != null ? getObject().getQName() : "";
//	}
}