package org.soluvas.web.bootstrap.term;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.Kind;
import org.soluvas.data.Term;
import org.soluvas.data.TermType;
import org.soluvas.web.site.widget.LinkColumn;
import org.soluvas.web.site.widget.TagType;
import org.soluvas.web.site.widget.TermColumn;
import org.soluvas.web.site.widget.TitledEnumLabel;

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
 * @author anton
 */
@SuppressWarnings("serial")
public class TermTablePanel2 extends Panel {
	
	private static final Logger log = LoggerFactory
			.getLogger(TermTablePanel2.class);
	
	private final IModel<Class<? extends Page>> detailPageModel;
	
	public TermTablePanel2(String id, final String kindNsPrefix, final Model<TermType> termKindModel,
			IModel<Class<? extends Page>> addPageModel, final IModel<Class<? extends Page>> detailPageModel) {
		super(id);
		setOutputMarkupId(true);
		
		this.detailPageModel = detailPageModel;
		
		final TitledEnumLabel<TermType> kindDisplayNameLbl = new TitledEnumLabel<>("kindDisplayName", termKindModel);
		
		add(kindDisplayNameLbl);
		
//		final BookmarkablePageLink<Class<? extends Page>> addLink = new BookmarkablePageLink<>("addLink", addPageModel.getObject());
//		add(addLink);
		
		add(new AjaxLink<String>("addLink") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				getRequestCycle().setResponsePage(addPageModel.getObject());
			}
		});
		
		final SortableDataProvider<Term, String> termDp = new TermSDP(termKindModel);
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
	@Override
	protected void onDetach() {
		detailPageModel.detach();
		super.onDetach();
	}
	
}
