package org.soluvas.web.site;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;

/**
 * Model to return a {@link List} of {@link Term}s, which is {@link Serializable}.
 * @author haidar
 */
public class TermListModel extends
		LoadableDetachableModel<List<Term>> {
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private TermManager termMgr;
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
		return termMgr.findTerms(kindNsPrefix, kindName);
	}
	
}