package org.soluvas.web.site;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;

/**
 * Model to return a {@link List} of {@link Term}s, which is {@link Serializable}.
 * @author haidar
 */
public class TermListModel extends
		LoadableDetachableModel<List<Term>> {
	private static final long serialVersionUID = 1L;
	
	@SpringBean(name="colorTermRepo")
	private TermRepository colorTermRepo;
	@SpringBean(name="sizeTermRepo")
	private TermRepository sizeTermRepo;
	
	private final String kindName;

	public TermListModel(final String kindName) {
		super();
		Injector.get().inject(this);
		this.kindName = kindName;
	}

	@Override
	protected List<Term> load() {
		switch (kindName) {
		case "Color":
			return colorTermRepo.findAll(new Sort(Direction.ASC, "positioner"));
		case "Size":
			return sizeTermRepo.findAll(new Sort(Direction.ASC, "positioner"));
		default:
			throw new UnsupportedOperationException();
		}
		
	}
	
}