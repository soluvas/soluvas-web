package org.soluvas.web.bootstrap.term;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.data.Kind;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.domain.PageOffsetRequest;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.web.site.EmfModel;
import org.soluvas.web.site.widget.LinkColumn;

/**
 * List {@link Term}s for a {@link Kind}.
 * 
 * <pre>{@literal
 * @MountPath("term/base/Color/")
 * public class ColorListPage extends AuthorizedMallPage {
 * 	
 * 	@SpringBean(name="colorTermRepo")
 * 	private TermRepository colorTermRepo;
 * 	
 * 	public ColorListPage(final PageParameters params) {
 * 		super(params);
 * 		add(new TermTablePanel("tablePanel", colorTermRepo, "base", "Color", "Colors",
 * 				ColorDetailPage.class));
 * 	}
 * 
 * }
 * }</pre>
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class TermTablePanel extends Panel {
	
	private TermRepository termRepo;

	public TermTablePanel(String id, TermRepository termRepo, final String kindNsPrefix, final String kindName, String kindDisplayName,
			final Class<? extends Page> addPage, final Class<? extends Page> detailPage) {
		super(id);
		this.termRepo = termRepo;
		add(new Label("kindDisplayName", kindDisplayName));
		add(new BookmarkablePageLink<>("addLink", addPage));
		
		final SortableDataProvider<Term, String> termDp = new SortableDataProvider<Term, String>() {
			@Override
			public Iterator<? extends Term> iterator(long first, long count) {
				final SortParam<String> sortParam = getSort();
				final Sort sort = sortParam != null ? new Sort(sortParam.isAscending() ? Direction.ASC : Direction.DESC, sortParam.getProperty())
					: new Sort("name");
				final org.soluvas.data.domain.Page<Term> page = TermTablePanel.this.termRepo.findAll(new PageOffsetRequest(first, count, sort));
				return page.getContent().iterator();
			}

			@Override
			public long size() {
				return TermTablePanel.this.termRepo.count();
			}

			@Override
			public IModel<Term> model(Term object) {
				return new EmfModel<>(object);
			}
		};
		termDp.setSort("name", SortOrder.ASCENDING);
		final List<IColumn<Term, String>> columns = new ArrayList<>();
		columns.add(new LinkColumn<Term, String>(new Model<>("Name"), "name", "name", detailPage,
				"uName", "qName"));
		columns.add(new PropertyColumn<Term, String>(new Model<>("Display Name"), "displayName", "displayName"));
		columns.add(new PropertyColumn<Term, String>(new Model<>("Namespace"), "nsPrefix", "nsPrefix"));
//		columns.add(new PropertyColumn<Term, String>(new Model<>("Image ID"), "imageId", "imageId"));
//		columns.add(new PropertyColumn<Term, String>(new Model<>("HTML Color"), "color", "color"));
//		columns.add(new TermColumn<Term>(new Model<>("Color"), "color"));
		add(new AjaxFallbackDefaultDataTable<>("table", columns, termDp, 20));
	}
	
}
