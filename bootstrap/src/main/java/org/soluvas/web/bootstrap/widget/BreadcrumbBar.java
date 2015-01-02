package org.soluvas.web.bootstrap.widget;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.soluvas.commons.AppManifest;
import org.soluvas.web.nav.PageLink;

import de.agilecoders.wicket.core.util.Attributes;

/**
 * Stateless Bootstrap-styled breadcrumb bar that is SEO-optimized using <a href="https://support.google.com/webmasters/answer/185417?hl=en">Structured Data Breadcrumbs</a>.
 * "Home" (using {@link AppManifest#getTitle()}) is always the first breadcrumb.
 * @author atang
 * @see BreadcrumbListView
 */
@SuppressWarnings("serial")
public class BreadcrumbBar extends GenericPanel<List<PageLink>> {

	private static class BreadcrumbListView extends ListView<PageLink> {

		public BreadcrumbListView(String id,
				IModel<List<PageLink>> model) {
			super(id, model);
		}

		@Override
		protected void populateItem(ListItem<PageLink> item) {
			final BookmarkablePageLink<Page> crumbLink = new BookmarkablePageLink<>(
					"link", item.getModelObject().getPage(), item.getModelObject().getParams());
			crumbLink.add(new Label("title", new PropertyModel<>(item.getModel(), "title")));
			item.add(crumbLink);
		}
		
	}
	
	@Inject
	private AppManifest appManifest;

	/**
	 * @param id
	 * @param model A list of breadcrumbs, the last breadcrumb is the active page, which will be rendered unlinked
	 * 		to show up properly in SERPs.
	 */
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
		final BookmarkablePageLink<Page> homeLink = new BookmarkablePageLink<>("homeLink", getApplication().getHomePage());
		homeLink.add(new Label("title", appManifest.getTitle()));
		add(homeLink);
		add(new BreadcrumbListView("crumbs", new AbstractReadOnlyModel<List<PageLink>>() {
			@Override
			public List<PageLink> getObject() {
				return getModelObject().subList(0, getModelObject().size() - 1);
			}
		}));
		final IModel<String> activeTitleModel = new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return getModelObject().get(getModelObject().size() - 1).getTitle();
			}
		};
		add(new Label("active", activeTitleModel));
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
		checkComponentTag(tag, "ul");
		Attributes.addClass(tag, "breadcrumb");
	}

}
