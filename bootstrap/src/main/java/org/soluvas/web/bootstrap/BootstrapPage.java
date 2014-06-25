package org.soluvas.web.bootstrap;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.nav.PageLink;
import org.soluvas.web.site.CssLink;
import org.soluvas.web.site.ExtensiblePage;
import org.soluvas.web.site.FaviconResourceReference;
import org.soluvas.web.site.JavaScriptLink;
import org.soluvas.web.site.JavaScriptMode;
import org.soluvas.web.site.JavaScriptSource;
import org.soluvas.web.site.PageMetaProvider;
import org.soluvas.web.site.PageRequestContext;
import org.soluvas.web.site.RequireManager;
import org.soluvas.web.site.Site;
import org.soluvas.web.site.alexa.AlexaCertify;
import org.soluvas.web.site.alexa.AlexaCertifyScript;
import org.soluvas.web.site.client.JsSource;
import org.soluvas.web.site.compose.ComposeUtils;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.pagemeta.PageMeta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
/**
 * Base page for Twitter Bootstrap-powered Wicket pages.
 * 
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BootstrapPage extends ExtensiblePage {
	
	public static enum SidebarVisibility {
		VISIBLE,
		HIDDEN
	}
	
	public static enum AddedInfoVisibility {
		VISIBLE,
		HIDDEN
	}

	public static class MetaTag extends WebMarkupContainer {

		/**
		 * @param id
		 * @param model
		 */
		public MetaTag(String id, IModel<String> model) {
			super(id, model);
			add(new AttributeModifier("content", model));
		}

		@Override
		protected void onConfigure() {
			super.onConfigure();
			setVisible(!Strings.isNullOrEmpty(getDefaultModelObjectAsString()));
		}

	}

	public static final class JsSourceVisitor implements
			IVisitor<Component, Void> {
		private final ImmutableList.Builder<String> jsSources;

		public JsSourceVisitor(ImmutableList.Builder<String> jsSources) {
			this.jsSources = jsSources;
		}

		@Override
		public void component(Component component, IVisit<Void> visit) {
			List<JsSource> jsSourceBehaviors = component
					.getBehaviors(JsSource.class);
			for (JsSource src : jsSourceBehaviors) {
				jsSources.add(src.getJsSource());
			}
		}
	}

	private static final Logger log = LoggerFactory.getLogger(BootstrapPage.class);
	public static final CssResourceReference PRINT_CSS = new CssResourceReference(BootstrapPage.class, "soluvas-web-print.css");
	
	@SpringBean(name="jacksonMapperFactory")
	private Supplier<ObjectMapper> jacksonMapperFactory;
	/**
	 * Should not use {@link Site} directly!
	 */
	// @Deprecated
	// private Site site;
	@SpringBean(name="cssLinks")
	private List<CssLink> cssLinks;
	@SpringBean(name="headJavaScripts")
	private List<JavaScriptLink> headJavaScripts;
	@SpringBean(name="requireMgr")
	protected RequireManager requireMgr;

	@SpringBean(name="footerJavaScripts")
	private List<JavaScriptLink> footerJavaScripts;
	@SpringBean(name="footerJavaScriptSources")
	private List<JavaScriptSource> footerJavaScriptSources;

	protected final RepeatingView sidebarBlocks;

//	@SpringBean(name="pageMetaSupplierFactory")
//	private PageMetaSupplierFactory<PageMetaSupplier> pageMetaSupplierFactory;
	@SpringBean
	private PageMetaProvider pageMetaProvider;
	@SpringBean
	protected WebAddress webAddress;
	@SpringBean(name="appManifest")
	protected AppManifest appManifest;
	@SpringBean(name="contributorRepo")
	private CrudRepository<LiveContributor, Integer> contributors;
	@SpringBean(name="alexaCertify")
	protected AlexaCertify alexaCertify;

	protected Component feedbackPanel;
	
	protected Component contentAddedInfo;

	protected TransparentWebMarkupContainer contentColumn;

	protected TransparentWebMarkupContainer sidebarColumn;

	@SpringBean
	private TenantRef tenant;

	protected final RepeatingView afterHeader;

	protected AddedInfoVisibility addedInfoVisibility;
	
	protected SidebarVisibility sidebarVisibility;

	protected Navbar navbar;
	
	private final IModel<List<PageLink>> breadcrumbModel = new LoadableDetachableModel<List<PageLink>>() {
		@Override
		protected List<PageLink> load() {
			final ArrayList<PageLink> pageLinks = new ArrayList<>();
			createPageLinksForBreadcrumb(pageLinks);
			return pageLinks;
		}
	};
	private IModel<PageMeta> pageMetaModel;
	
	/**
	 * @param pageLinks Mutable.
	 */
	protected void createPageLinksForBreadcrumb(List<PageLink> pageLinks) {
	}

	@SuppressWarnings("deprecation")
	public String smartPrefixUri(String prefix, String uri) {
		if (uri.startsWith("//") || uri.startsWith("https:")
				|| uri.startsWith("http:")) {
			return uri;
		} else {
			// cache bust for relative CSS URIs
			final String suffix = Strings.isNullOrEmpty(requireMgr
					.getCacheBust()) ? "" : "?"
					+ URLEncoder.encode(requireMgr.getCacheBust());
			return prefix + uri + suffix;
		}
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);

		// doesn't work, nginx as of 1.3.15 disables Etag if content is gzipped
//		if (requireMgr.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT) {
//			response.render(JavaScriptReferenceHeaderItem
//					.forUrl(webAddress.getJsUri() + "org.soluvas.web.bootstrap/live-soluvas.js"));
//		}

		final String currentStyle = getStyle();
		final List<CssLink> filteredCsses = ImmutableList.copyOf(Collections2
				.filter(cssLinks, new Predicate<CssLink>() {
					@Override
					public boolean apply(@Nullable CssLink input) {
						return Strings.isNullOrEmpty(input.getStyle())
								|| "*".equals(input.getStyle())
								|| Objects.equal(currentStyle, input.getStyle());
					}
				}));

		log.trace("Page {} has {} CSS links (from {} total)", getClass()
				.getName(), filteredCsses.size(), cssLinks.size());
		final Ordering<CssLink> cssOrdering = Ordering
				.from(new Comparator<CssLink>() {
					@Override
					public int compare(CssLink o1, CssLink o2) {
						return o1.getWeight() - o2.getWeight();
					};
				});
		final List<CssLink> sortedCsses = cssOrdering
				.immutableSortedCopy(filteredCsses);
		for (final CssLink css : sortedCsses) {
			if (requireMgr.getJavaScriptMode() != JavaScriptMode.DEVELOPMENT
					&& css.getMinifiedPath() != null) {
				response.render(CssHeaderItem.forUrl(smartPrefixUri(
						webAddress.getSkinUri(), css.getMinifiedPath())));
			} else {
				response.render(CssHeaderItem.forUrl(smartPrefixUri(
						webAddress.getSkinUri(), css.getPath())));
			}
		}
		
		response.render(CssHeaderItem.forReference(PRINT_CSS, "print"));

		log.trace("Page {} has {} head JavaScript links", getClass().getName(),
				headJavaScripts.size());
		final Ordering<JavaScriptLink> jsOrdering = Ordering
				.from(new Comparator<JavaScriptLink>() {
					@Override
					public int compare(JavaScriptLink o1, JavaScriptLink o2) {
						return o1.getWeight() - o2.getWeight();
					};
				});
		final List<JavaScriptLink> sortedJses = jsOrdering
				.immutableSortedCopy(headJavaScripts);
		for (JavaScriptLink js : sortedJses) {
			response.render(JavaScriptHeaderItem.forUrl(js.getSrc()));
		}
		
		response.render(JavaScriptHeaderItem.forReference(TinyNavJs.instance()));
		response.render(JavaScriptHeaderItem.forReference(JQueryUiToTop.instance()));
//		response.render(JavaScriptHeaderItem.forReference(
//				new JavaScriptResourceReference(BootstrapPage.class, "require-2.1.5-soluvas.js")));		
	}

	@Override
	protected void renderPlaceholderTag(ComponentTag tag, Response response) {
		super.renderPlaceholderTag(tag, response);
	}

	/**
	 * Please override this.
	 * 
	 * @return
	 */
	protected String getTitle() {
		return null;
	}

	public BootstrapPage() {
		this(null, SidebarVisibility.VISIBLE);
	}

	public BootstrapPage(@Nullable PageParameters params, SidebarVisibility sidebarVisibility) {
		super(params);
		this.sidebarVisibility = sidebarVisibility;
		this.addedInfoVisibility = AddedInfoVisibility.HIDDEN;
		
		if (getApplication().getDebugSettings().isDevelopmentUtilitiesEnabled()) {
			try {
				add(new DebugBar("dev"));
				log.trace("Enabled Wicket development utilities: DebugBar");
			} catch (NoClassDefFoundError e) {
				log.debug("Cannot enable DebugBar in development mode, if you want to use it please add 'wicket-devutils' dependency", e);
				add(new EmptyPanel("dev").setVisible(false));
			}
		} else {
			add(new EmptyPanel("dev").setVisible(false));
		}
		
		add(new BootstrapBaseBehavior());
		add(new HeaderResponseContainer("footer-container", "footer-container"));
		
		final Ordering<JavaScriptSource> sourceOrdering = Ordering.natural();
		final Ordering<JavaScriptLink> linkOrdering = Ordering.natural();
		
//		add(new WebMarkupContainer("soluvasCss")
//				.add(new AttributeModifier(
//						"href",
//						webAddress.getSkinUri()
//								+ "org.soluvas.web.bootstrap/css/soluvas.css")));
		// For now we use soluvas's fork of RequireJS.
		// See https://github.com/jrburke/requirejs/issues/376 for reasons.
		// too bad we can't use "//cdnjs.cloudflare.com/ajax/libs/require.js/2.1.4/require.min.js";
//		final String requireJsUri = requireMgr.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT ?
//				webAddress .getJsUri() + "org.soluvas.web.bootstrap/require-2.1.5-soluvas.js" :
//				webAddress.getJsUri() + "org.soluvas.web.bootstrap/require-2.1.5-soluvas.min.js";
//		add(new WebMarkupContainer("requireJs").add(new AttributeModifier(
//				"src", requireJsUri)));

		// Carousel
		add(afterHeader = new RepeatingView("afterHeader"));

		navbar = new Navbar("navbar");
		add(navbar);
		// add(new Label("logoText",
		// site.getLogoText()).setRenderBodyOnly(true));
		// add(new Label("logoAlt",
		// site.getLogoAlt()).setRenderBodyOnly(true));
		navbar.add(new BookmarkablePageLink<Page>("homeLink",
				getApplication().getHomePage()) {
			{
				this.setBody(new Model<String>(appManifest.getTitle()));
			}

			@Override
			protected void onComponentTag(ComponentTag tag) {
				super.onComponentTag(tag);
				tag.getAttributes().put("title", appManifest.getTitle());
			}
		});

		add(new Header());
		// deprecated
//		final String requireConfigPath = webAddress.getApiPath()
//				+ "org.soluvas.web.site/requireConfig.js";
//		add(new WebMarkupContainer("requireConfig")
//				.add(new AttributeModifier("src", requireConfigPath)));

		// SIDEBAR
		sidebarColumn = new TransparentWebMarkupContainer("sidebarColumn");
		sidebarColumn.add(new CssClassNameAppender(new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return BootstrapPage.this.sidebarVisibility == SidebarVisibility.VISIBLE ? "col-md-3" : "";
			}
		}));
		sidebarBlocks = new RepeatingView("sidebarBlocks");
		sidebarColumn.add(sidebarBlocks);
		add(sidebarColumn);

		// CONTENT
		contentColumn = new TransparentWebMarkupContainer("contentColumn");
		contentColumn.add(new CssClassNameAppender(new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return BootstrapPage.this.sidebarVisibility == SidebarVisibility.VISIBLE ? "col-sm-9 col-md-9" : "col-md-12";
			}
		}));
		add(contentColumn);

		add(new FeedbackPanel("feedback").setVisible(false));
		
		// ADDED INFO
		contentAddedInfo = new WebMarkupContainer("addedInfo");
		add(contentAddedInfo);

		// FOOTER
		add(new Footer("© " + new DateTime().toString("yyyy") + " " + appManifest.getTitle()));

		// JAVASCRIPT

		final RepeatingView beforeFooterJs = new RepeatingView("beforeFooterJs");
		add(beforeFooterJs);

		log.trace("Page {} has {} footer JavaScript links", getClass()
				.getName(), footerJavaScripts.size());
		final List<JavaScriptLink> sortedJsLinks = linkOrdering
				.immutableSortedCopy(footerJavaScripts);
		final RepeatingView footerJavaScriptLinks = new RepeatingView(
				"footerJavaScriptLinks");
		for (JavaScriptLink js : sortedJsLinks) {
			footerJavaScriptLinks.add(new WebMarkupContainer(
					footerJavaScriptLinks.newChildId())
					.add(new AttributeModifier("src", js.getSrc())));
		}
		add(footerJavaScriptLinks);

		log.trace("Page {} has {} footer JavaScript sources", getClass()
				.getName(), footerJavaScriptSources.size());
		final List<JavaScriptSource> sortedJsSources = sourceOrdering
				.immutableSortedCopy(footerJavaScriptSources);
		final RepeatingView footerJavaScriptSources = new RepeatingView(
				"footerJavaScriptSources");
		for (JavaScriptSource js : sortedJsSources) {
			footerJavaScriptSources
					.add(new Label(footerJavaScriptSources.newChildId(), js
							.getScript()).setEscapeModelStrings(false));
		}
		add(footerJavaScriptSources);

		add(new AlexaCertifyScript("alexaCertifyScript", new Model<>(alexaCertify)));
		
		add(new GrowlBehavior());
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		// sidebar visibility
		if (sidebarVisibility == SidebarVisibility.HIDDEN) {
			sidebarColumn.setVisible(false);
		}
		// compose other components
		ComposeUtils.compose(this, contributors.findAll());
		
		contentAddedInfo.setVisible(addedInfoVisibility == AddedInfoVisibility.VISIBLE);
		
		pageMetaModel = createPageMetaModel();

		// HTML
		add(new TransparentWebMarkupContainer("html")
				.add(new AttributeModifier("lang", new PropertyModel<String>(
						pageMetaModel, "languageCode"))));

		// HEAD
		// add(new Label("pageTitle", "Welcome").setRenderBodyOnly(true));
		// do NOT use AsyncModel here, because it depends on PageMeta model
		// loading last
		final IModel<String> titleModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				return Optional
						.fromNullable(getTitle())
						.or(Optional.fromNullable(pageMetaModel.getObject()
								.getTitle())).orNull();
			}
		};
		final IModel<String> titleSuffixModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				return " | " + appManifest.getTitle();
			}
		};
		add(new Label("pageTitle", titleModel).setRenderBodyOnly(true));
		add(new Label("pageTitleSuffix", titleSuffixModel)
				.setRenderBodyOnly(true));
		// Get favicon from FaviconResourceReference if set, otherwise use PageMetaModel
		final WebMarkupContainer faviconLink = new WebMarkupContainer(
				"faviconLink");
		final IModel<String> faviconUriModel;
		if (FaviconResourceReference.INSTANCE != null) {
			faviconUriModel = new Model<>(urlFor(FaviconResourceReference.INSTANCE, null).toString());
		} else {
			faviconUriModel = new PropertyModel<>(pageMetaModel, "icon.faviconUri");
		}
		faviconLink.add(new AttributeModifier("href", faviconUriModel));
		add(faviconLink);
		add(new MetaTag("metaDescription", new PropertyModel<String>(pageMetaModel, "description")),
			new MetaTag("metaKeywords", new PropertyModel<String>(pageMetaModel, "keywords")),
			new MetaTag("ogTitle", new PropertyModel<String>(pageMetaModel, "openGraph.title")),
			new MetaTag("ogType", new PropertyModel<String>(pageMetaModel,"openGraph.type")),
			new MetaTag("ogUrl", new PropertyModel<String>(pageMetaModel, "openGraph.url")),
			new MetaTag("ogImage", new PropertyModel<String>(pageMetaModel,"openGraph.image")));
	}

	@Override
	protected void onConfigure() {
		super.onConfigure();
		final List<String> visibleChildren = new ArrayList<>();
		for (Component child : sidebarBlocks) {
			child.configure();
			if (child.isVisible()) {
				visibleChildren.add(child.getPageRelativePath());
			}
		}
		log.debug("Visible sidebarBlocks children: {}", visibleChildren);
		sidebarColumn.setVisible(sidebarVisibility == SidebarVisibility.VISIBLE && !visibleChildren.isEmpty());
	}

	/**
	 * Most of the times you'll want to override this,
	 * use {@code MustachePageMetaModel} (TODO) for common cases
	 * or your own {@link LoadableDetachableModel} for dynamic cases.
	 * Will be called during {@link #onInitialize()} so make sure any dependencies
	 * you need are already available. 
	 * @return
	 */
	protected IModel<PageMeta> createPageMetaModel() {
		// do NOT use AsyncModel here because we need it to load LAST
		// (i.e. after all scopes has been attached as page model using
		// addModelForPageMeta)
		return new LoadableDetachableModel<PageMeta>() {
			@Override
			protected PageMeta load() {
				final String currentUri = getRequest().getUrl().toString();
				final PageRequestContext context = new PageRequestContext(
						tenant.getClientId(), tenant.getTenantId(),
						tenant.getTenantEnv(), BootstrapPage.this, currentUri, webAddress,
						appManifest);
				// final List<PageRule> pageRules = pageRulesSupplier.get();
				// final PageMetaSupplier pageSupplier = new
				// RulesPageMetaSupplier(pageRules, context);
				final PageMeta pageMeta = pageMetaProvider.get(context);
				return pageMeta;
			}
		};
	}
	
	public final IModel<PageMeta> getPageMetaModel() {
		return pageMetaModel;
	}
	
	public final IModel<List<PageLink>> getBreadcrumbModel() {
		return breadcrumbModel;
	}
	
	@Override
	protected void detachModel() {
		super.detachModel();
		createPageMetaModel().detach();
		breadcrumbModel.detach();
	}
	
}
