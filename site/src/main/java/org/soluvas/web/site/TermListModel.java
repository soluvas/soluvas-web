package org.soluvas.web.site;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.domain.PageRequest;

/**
 * Model to return a {@link List} of {@link Term}s, which is {@link Serializable}.
 * @author haidar
 */
public class TermListModel extends
		LoadableDetachableModel<List<Term>> {
	private static final long serialVersionUID = 1L;
	
//	@SpringBean
//	private TermManager termMgr;
	@SpringBean(name="colorTermRepo")
	private TermRepository colorTermRepo;
	@SpringBean(name="sizeTermRepo")
	private TermRepository sizeTermRepo;
	private final String kindNsPrefix;
	private final String kindName;

	public TermListModel(String kindNsPrefix, String kindName) {
		super();
		Injector.get().inject(this);
		this.kindNsPrefix = kindNsPrefix;
		this.kindName = kindName;
	}

	@Override
	protected List<Term> load() {
		switch (kindName) {
		case "Color" :
			return colorTermRepo.findAll(new PageRequest(0, 5000)).getContent();
		case "Size" :
			return sizeTermRepo.findAll(new PageRequest(0, 5000)).getContent();
		default :
				throw new RuntimeException(String.format("%s not supported", kindName));
		}
//		return termMgr.findTerms(kindNsPrefix, kindName);
	}
	
}