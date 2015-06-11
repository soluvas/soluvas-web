package org.soluvas.web.bootstrap.term;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.soluvas.data.Kind;
import org.soluvas.data.Term;
import org.soluvas.web.site.widget.LinkColumn;
import org.soluvas.web.site.widget.TagType;
import org.soluvas.web.site.widget.TermColumn;

/**
 * List {@link Term}s for a {@link Kind}.
 * 
 * <pre>{@literal
 * @ManageMountPath("term/base/Color/")
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
public class TermTablePanel2 extends Panel {
	
	public TermTablePanel2(String id, final String kindNsPrefix, final IModel<String> kindNameModel, String kindDisplayName,
			final IModel<Class<? extends Page>> addPageModel, final IModel<Class<? extends Page>> detailPageModel) {
		super(id);
		setOutputMarkupId(true);
		add(new Label("kindDisplayName", kindDisplayName));
		
		final IModel<Class<? extends Page>> addPageModelDetach = new LoadableDetachableModel<Class<? extends Page>>() {
			@Override
			protected Class<? extends Page> load() {
				return addPageModel.getObject();
			}
		};
		
		add(new BookmarkablePageLink<>("addLink", addPageModelDetach.getObject()));
		
		final SortableDataProvider<Term, String> termDp = new TermSDP(kindNameModel);
		termDp.setSort("name", SortOrder.ASCENDING);
		final List<IColumn<Term, String>> columns = new ArrayList<>();
		columns.add(new LinkColumn<Term, String>(new Model<>("ID"), "name", "name", detailPageModel.getObject(),
				"uName", "qName").tag(TagType.CODE));
//		columns.add(new PropertyColumn<Term, String>(new Model<>("Display Name"), "displayName", "displayName"));
		columns.add(new TermColumn<Term>(new Model<>("Display Name"), null));
		columns.add(new PropertyColumn<Term, String>(new Model<>("Namespace"), "nsPrefix", "nsPrefix"));
//		columns.add(new PropertyColumn<Term, String>(new Model<>("Image ID"), "imageId", "imageId"));
//		columns.add(new PropertyColumn<Term, String>(new Model<>("HTML Color"), "color", "color"));
//		columns.add(new TermColumn<Term>(new Model<>("Color"), "color"));
		add(new AjaxFallbackDefaultDataTable<>("table", columns, termDp, 20));
	}
	
}
