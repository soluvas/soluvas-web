package org.soluvas.web.bootstrap;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
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
import org.soluvas.web.site.AmdJavaScriptSource;
import org.soluvas.web.site.CssLink;
import org.soluvas.web.site.ExtensiblePage;
import org.soluvas.web.site.JavaScriptLink;
import org.soluvas.web.site.JavaScriptMode;
import org.soluvas.web.site.JavaScriptSource;
import org.soluvas.web.site.PageMetaProvider;
import org.soluvas.web.site.PageRequestContext;
import org.soluvas.web.site.RequireManager;
import org.soluvas.web.site.Site;
import org.soluvas.web.site.alexa.AlexaCertify;
import org.soluvas.web.site.alexa.AlexaCertifyScript;
import org.soluvas.web.site.client.AmdDependency;
import org.soluvas.web.site.client.JsSource;
import org.soluvas.web.site.compose.ComposeUtils;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.pagemeta.PageMeta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;

import de.agilecoders.wicket.core.markup.html.references.BootstrapJavaScriptReference;

/**
 * Base page for Twitter Bootstrap-powered Wicket pages.
 * 
 * @author ceefour
 */
public class BootstrapPage extends ExtensiblePage {
	
	private static final long serialVersionUID = 1L;

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

	/**
	 * Usage:
	 * 
	 * <pre>
	 * {
	 * 	&#064;code
	 * 	final Builder&lt;String, String&gt; dependencies = ImmutableMap.builder();
	 * 	new AmdDependencyVisitor(dependencies).component(BootstrapPage.this, null);
	 * 	visitChildren(new AmdDependencyVisitor(dependencies));
	 * 	final Map&lt;String, String&gt; dependencyMap = dependencies.build();
	 * 	log.debug(&quot;Page {} has {} AMD dependencies: {}&quot;, getClass().getName(),
	 * 			dependencyMap.size(), dependencyMap.keySet());
	 * }
	 * </pre>
	 * 
	 * @author ceefour
	 */
	public static final class AmdDependencyVisitor implements
			IVisitor<Component, Void> {
		private final Map<String, String> dependencies;

		public AmdDependencyVisitor(Map<String, String> dependencyMap) {
			this.dependencies = dependencyMap;
		}

		@Override
		public void component(Component component, IVisit<Void> visit) {
			final List<AmdDependency> amdDeps = component
					.getBehaviors(AmdDependency.class);
			for (AmdDependency dep : amdDeps) {
				dependencies.put(dep.getPath(), dep.getName());
			}
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

	private static final Logger log = LoggerFactory
			.getLogger(BootstrapPage.class);
	public static final CssResourceReference BOOTSTRAP_PRINT_CSS = new CssResourceReference(BootstrapPage.class, "bootstrap-print.css");
	
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
	
	/**
	 * @param pageLinks Mutable.
	 */
	protected void createPageLinksForBreadcrumb(List<PageLink> pageLinks) {
	}

	// do NOT use AsyncModel here because we need it to load LAST
	// (i.e. after all scopes has been attached as page model using
	// addModelForPageMeta)
	protected final IModel<PageMeta> pageMetaModel = new LoadableDetachableModel<PageMeta>() {
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

		response.render(JavaScriptReferenceHeaderItem
				.forReference(getApplication().getJavaScriptLibrarySettings()
						.getJQueryReference()));
		
		// TODO: workaround before we have proper wicket-bootstrap integration
		response.render(
				JavaScriptReferenceHeaderItem.forReference(BootstrapJavaScriptReference.instance()));

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
		for (CssLink css : sortedCsses) {
			if (requireMgr.getJavaScriptMode() != JavaScriptMode.DEVELOPMENT
					&& css.getMinifiedPath() != null) {
				response.render(CssHeaderItem.forUrl(smartPrefixUri(
						webAddress.getSkinUri(), css.getMinifiedPath())));
			} else {
				response.render(CssHeaderItem.forUrl(smartPrefixUri(
						webAddress.getSkinUri(), css.getPath())));
			}
		}
		
		response.render(CssHeaderItem.forReference(BOOTSTRAP_PRINT_CSS, "print"));

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
		
		response.render(JavaScriptHeaderItem.forReference(TinyNavJs.INSTANCE));
		response.render(JavaScriptHeaderItem.forReference(ToTopJs.EASING));
		response.render(JavaScriptHeaderItem.forReference(ToTopJs.TO_TOP));
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

	public BootstrapPage(PageParameters params, SidebarVisibility sidebarVisibility) {
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
		
		// Use CDN jQuery if we're in production
		if (requireMgr.getJavaScriptMode() != JavaScriptMode.DEVELOPMENT) {
			getApplication()
					.getJavaScriptLibrarySettings()
					.setJQueryReference(
							new UrlResourceReference(
									Url.parse("http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js")));
		}

		final Ordering<JavaScriptSource> sourceOrdering = Ordering.natural();
		final Ordering<JavaScriptLink> linkOrdering = Ordering.natural();

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
		final WebMarkupContainer faviconLink = new WebMarkupContainer(
				"faviconLink");
		faviconLink
				.add(new AttributeModifier("href",
						new PropertyModel<String>(pageMetaModel,
								"icon.faviconUri")));
		add(faviconLink);
		add(new MetaTag("metaDescription", new PropertyModel<String>(pageMetaModel, "description")),
			new MetaTag("metaKeywords", new PropertyModel<String>(pageMetaModel, "keywords")),
			new MetaTag("ogTitle", new PropertyModel<String>(pageMetaModel, "openGraph.title")),
			new MetaTag("ogType", new PropertyModel<String>(pageMetaModel,"openGraph.type")),
			new MetaTag("ogUrl", new PropertyModel<String>(pageMetaModel, "openGraph.url")),
			new MetaTag("ogImage", new PropertyModel<String>(pageMetaModel,"openGraph.image")));

		final String bootstrapCssUri = requireMgr.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT ? webAddress
				.getSkinUri()
//				+ "org.soluvas.web.bootstrap/css/bootstrap3.min.css"
				+ "org.soluvas.web.bootstrap/css/bootstrap.css"
				: "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css";
		final String bootstrapThemeCssUri = requireMgr.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT ? webAddress
				.getSkinUri()
				+ "org.soluvas.web.bootstrap/css/bootstrap3-theme.min.css"
				: "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css";
		final String bootstrapResponsiveCssUri = requireMgr
				.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT ? webAddress
				.getSkinUri()
				+ "org.soluvas.web.bootstrap/css/bootstrap-responsive.css"
				: "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-responsive.min.css";
		add(new WebMarkupContainer("bootstrapCss")
				.add(new AttributeModifier("href", bootstrapCssUri)));
		add(new WebMarkupContainer("bootstrapThemeCss")
		.add(new AttributeModifier("href", bootstrapThemeCssUri)));
		add(new WebMarkupContainer("bootstrapResponsiveCss")
				.add(new AttributeModifier("href",
						bootstrapResponsiveCssUri)));
		add(new WebMarkupContainer("soluvasCss")
				.add(new AttributeModifier(
						"href",
						webAddress.getSkinUri()
								+ "org.soluvas.web.bootstrap/css/soluvas.css")));
		// For now we use soluvas's fork of RequireJS.
		// See https://github.com/jrburke/requirejs/issues/376 for reasons.
		// too bad we can't use "//cdnjs.cloudflare.com/ajax/libs/require.js/2.1.4/require.min.js";
		final String requireJsUri = requireMgr.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT ?
				webAddress .getJsUri() + "org.soluvas.web.bootstrap/require-2.1.5-soluvas.js" :
				webAddress.getJsUri() + "org.soluvas.web.bootstrap/require-2.1.5-soluvas.min.js";
		add(new WebMarkupContainer("requireJs").add(new AttributeModifier(
				"src", requireJsUri)));

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
		final String requireConfigPath = webAddress.getApiPath()
				+ "org.soluvas.web.site/requireConfig.js";
		add(new WebMarkupContainer("requireConfig")
				.add(new AttributeModifier("src", requireConfigPath)));

		// ADDED INFO
		contentAddedInfo = new WebMarkupContainer("addedInfo");
		add(contentAddedInfo);
		
		// SIDEBAR
		sidebarColumn = new TransparentWebMarkupContainer("sidebarColumn");
		add(sidebarColumn);
		sidebarBlocks = new RepeatingView("sidebarBlocks");
		sidebarColumn.add(sidebarBlocks);

		// CONTENT
		contentColumn = new TransparentWebMarkupContainer("contentColumn");
		add(contentColumn);
		feedbackPanel = new FeedbackPanel("feedback")
				.setOutputMarkupId(true);
		add(feedbackPanel);

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

		final IModel<String> pageJavaScriptSourcesModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				// cannot use ImmutableMap, because AMD dependencies can be duplicated
				final Map<String, String> dependencyMap = new HashMap<>();
				final AmdDependencyVisitor amdDependencyVisitor = new AmdDependencyVisitor(
						dependencyMap);
				amdDependencyVisitor.component(BootstrapPage.this, null);
				visitChildren(amdDependencyVisitor);
				log.trace("Page {} has {} AMD dependencies: {}", getClass()
						.getName(), dependencyMap.size(), dependencyMap.keySet());

				final ImmutableList.Builder<String> pageJsSourcesBuilder = ImmutableList
						.builder();
				final JsSourceVisitor jsSourceVisitor = new JsSourceVisitor(
						pageJsSourcesBuilder);
				jsSourceVisitor.component(BootstrapPage.this, null);
				visitChildren(jsSourceVisitor);
				final List<String> pageJsSources = pageJsSourcesBuilder.build();
				log.trace("Page {} has {} page JavaScript sources", getClass()
						.getName(), pageJsSources.size());
				final String merged = Joiner.on('\n').join(pageJsSources);

				JavaScriptSource js = new AmdJavaScriptSource(merged,
						dependencyMap);
				return js.getScript();
			};
		};
		add(new Label("pageJavaScriptSources", pageJavaScriptSourcesModel)
				.setEscapeModelStrings(false));
		
		add(new AlexaCertifyScript("alexaCertifyScript", new Model<>(alexaCertify)));
		
		add(new GrowlBehavior());
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		// sidebar visibility
		if (sidebarVisibility == SidebarVisibility.HIDDEN) {
			sidebarColumn.setVisible(false);
			contentColumn.add(new AttributeModifier("class", "span12"));
		}
		// compose other components
		ComposeUtils.compose(this, contributors.findAll());
		
		if (addedInfoVisibility == AddedInfoVisibility.VISIBLE) {
			contentAddedInfo.setVisible(true);
		}
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
		sidebarColumn.setVisible(!visibleChildren.isEmpty());
	}

	public IModel<PageMeta> getPageMetaModel() {
		return pageMetaModel;
	}
	
	public IModel<List<PageLink>> getBreadcrumbModel() {
		return breadcrumbModel;
	}
	
	@Override
	protected void detachModel() {
		super.detachModel();
		pageMetaModel.detach();
		breadcrumbModel.detach();
	}
	
}
