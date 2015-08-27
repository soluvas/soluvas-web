package org.soluvas.web.bootstrap.term;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.Term2;
import org.soluvas.data.TermKind;
import org.soluvas.data.domain.PageOffsetRequest;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.mongo.MongoTermRepository;

/**
 * @author anton
 *
 */
public class Term2SDP extends SortableDataProvider<Term2, String> {
	
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private MongoTermRepository termCatalogRepo;
	
	private final IModel<TermKind> termKindModel;
	
	public Term2SDP(final IModel<TermKind> termKindModel) {
		super();
		Injector.get().inject(this);
		
		this.termKindModel = termKindModel;
	}

	@Override
	public Iterator<? extends Term2> iterator(long first, long count) {
		final SortParam<String> sortParam = getSort();
		final Sort sort = sortParam != null ? new Sort(sortParam.isAscending() ? Direction.ASC : Direction.DESC, sortParam.getProperty())
			: new Sort("name");
		
		final org.soluvas.data.domain.Page<Term2> page = termCatalogRepo.findAll(termKindModel.getObject(), new PageOffsetRequest(first, count, sort));
		return page.getContent().iterator();
	}

	@Override
	public long size() {
		return termCatalogRepo.count(termKindModel.getObject());
	}

	@Override
	public IModel<Term2> model(Term2 object) {
		return new Model<>(object);
	}

}
