package org.soluvas.web.bootstrap.term;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.DataException;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.domain.PageOffsetRequest;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.web.site.EmfModel;

/**
 * @author anton
 *
 */
public class TermSDP extends SortableDataProvider<Term, String> {
	
	@SpringBean(name="sizeTermRepo")
	private TermRepository sizeTermRepo;
	@SpringBean(name="colorTermRepo")
	private TermRepository colorTermRepo;
	
	private TermRepository termRepo;
	private final IModel<String> kindNameModel;
	
	public TermSDP(final IModel<String> kindNameModel) {
		super();
		Injector.get().inject(this);
		
		this.kindNameModel = kindNameModel;
	}
	
	private void reloadRepo() {
		switch (kindNameModel.getObject()) {
		case "Color":
			termRepo = colorTermRepo;
			break;
		case "Size":
			termRepo = sizeTermRepo; 
			break;
		default:
			throw new DataException(String.format("Unsupported for kind '%s'", kindNameModel.getObject()));
		}
	}

	@Override
	public Iterator<? extends Term> iterator(long first, long count) {
		final SortParam<String> sortParam = getSort();
		final Sort sort = sortParam != null ? new Sort(sortParam.isAscending() ? Direction.ASC : Direction.DESC, sortParam.getProperty())
			: new Sort("name");
		
		final org.soluvas.data.domain.Page<Term> page = termRepo.findAll(new PageOffsetRequest(first, count, sort));
		return page.getContent().iterator();
	}

	@Override
	public long size() {
		reloadRepo();
		return termRepo.count();
	}

	@Override
	public IModel<Term> model(Term object) {
		return new EmfModel<>(object);
	}

}
