package org.soluvas.web.bootstrap.widget;

import java.util.List;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.soluvas.web.bootstrap.BootstrapPage;
import org.soluvas.web.nav.PageLink;
import org.soluvas.web.site.pagemeta.PageMeta;

/**
 * @author atang
 *
 */
public class BreadcrumbBar extends GenericPanel<List<PageLink>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static class BreadcrumbListView extends ListView<PageLink> {

		public BreadcrumbListView(String id,
				IModel<List<PageLink>> model) {
			super(id, model);
		}

		@Override
		protected void populateItem(ListItem<PageLink> item) {
//			new ExternalLink("crumbUri", href);
			final BookmarkablePageLink<Page> crumbLink = new BookmarkablePageLink<>(
					"crumbLink", item.getModelObject().getPage(), item.getModelObject().getParams());
			crumbLink.add(new Label("crumbLabel", new PropertyModel<>(item.getModel(), "title")));
			item.add(crumbLink);
		}
		
	}
	
	public BreadcrumbBar(String id, IModel<List<PageLink>> model) {
		super(id, model);
	}

	public BreadcrumbBar(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
//		final Request request = getRequest();
//		String stringUri = null;
//		final String[] homecrumb = {"Home"};
//		if (request instanceof WebRequest) {
//			final WebRequest wr = (WebRequest) request;
//			stringUri = wr.getUrl().toString();
//			log.info("String Uri Before splited {}", stringUri);
//		}
//		final String[] tmpCrumbUri = stringUri.split("\\/");
//		final String[] addAll = (String[]) ArrayUtils.addAll(homecrumb, tmpCrumbUri);
//		log.info("String Uri after splited {}", addAll);
//		final Iterable<String> crumbStr = Iterables.filter(ImmutableList.copyOf(addAll), new Predicate<String>() {
//			@Override
//			public boolean apply(@Nullable String input) {
//				return (!input.equals("category")) && (!input.equals(""));
//			}
//		});
//		final LoadableDetachableModel<List<String>> crumbModel = new LoadableDetachableModel<List<String>>() {
//			@Override
//			protected List<String> load() {
//				return ImmutableList.copyOf(crumbStr);
//			}
//		};
		add(new BreadcrumbListView("crumbs", getModel()));
		final IModel<PageMeta> pageMetaModel = ((BootstrapPage) getPage()).getPageMetaModel();
		String activeTitle = new PropertyModel<String>(pageMetaModel, "title").getObject();
		if (activeTitle == null) {
			activeTitle = getPage().getClass().getSimpleName();
		}
		add(new Label("active", activeTitle));
	}

}
