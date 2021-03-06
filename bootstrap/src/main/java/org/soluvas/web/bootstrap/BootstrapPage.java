package org.soluvas.web.bootstrap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.BooleanUtils;
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
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.protocol.http.RequestUtils;
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
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.bootstrap.widget.PageMetaPanel;
import org.soluvas.web.nav.PageLink;
import org.soluvas.web.site.ExtensiblePage;
import org.soluvas.web.site.FaviconResourceReference;
import org.soluvas.web.site.JavaScriptLink;
import org.soluvas.web.site.JavaScriptSource;
import org.soluvas.web.site.ModelVisibilityBehavior;
import org.soluvas.web.site.PageMetaProvider;
import org.soluvas.web.site.PageRequestContext;
import org.soluvas.web.site.Site;
import org.soluvas.web.site.alexa.AlexaCertify;
import org.soluvas.web.site.alexa.AlexaCertifyScript;
import org.soluvas.web.site.client.JsSource;
import org.soluvas.web.site.compose.ComposeUtils;
import org.soluvas.web.site.compose.LiveContributor;
import org.soluvas.web.site.pagemeta.PageMeta;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Ordering;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MetaTag;
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
	/**
	 * Common tracking parameters from <a href="https://support.google.com/analytics/answer/1033867?hl=en">Google Analytics</a>, etc. that should be stripped
	 * from Canonical URI.
	 * 
	 * @see <a href="https://idbippo.atlassian.net/browse/BC-2480">BC-2480: rel=canonical on all (Bootstrap) pages to remove ?0 from search engine result pages</a>
	 */
	public static final ImmutableSet<String> TRACKING_PARAMETERS = ImmutableSet.of(
			"utm_source", "utm_medium", "utm_term", "utm_content", "utm_campaign");
	
//	@SpringBean(name="jacksonMapperFactory")
//	private Supplier<ObjectMapper> jacksonMapperFactory;
	/**
	 * Should not use {@link Site} directly!
	 */
	// @Deprecated
	// private Site site;
//	@SpringBean(name="cssLinks", required=false)
//	private List<CssLink> cssLinks;
	@SpringBean(name="headJavaScripts", required=false)
	private List<JavaScriptLink> headJavaScripts;

	@SpringBean(name="footerJavaScripts", required=false)
	private List<JavaScriptLink> footerJavaScripts;
	@SpringBean(name="footerJavaScriptSources", required=false)
	private List<JavaScriptSource> footerJavaScriptSources;

	protected final RepeatingView sidebarBlocks;

//	@SpringBean(name="pageMetaSupplierFactory")
//	private PageMetaSupplierFactory<PageMetaSupplier> pageMetaSupplierFactory;
	@Inject
	private PageMetaProvider pageMetaProvider;
	@Inject
	protected GeneralSysConfig sysConfig;
	@Inject
	protected WebAddress webAddress;
	@Inject @Named("appManifest")
	protected AppManifest appManifest;
	@SpringBean(name="contributorRepo", required=false)
	private CrudRepository<LiveContributor, Integer> contributorRepo;
	@SpringBean(required=false)
	protected AlexaCertify alexaCertify;
	@Inject
	private TenantRef tenant;

	protected Component feedbackPanel;
	
	protected Component contentAddedInfo;

	protected TransparentWebMarkupContainer contentColumn;

	protected TransparentWebMarkupContainer sidebarColumn;

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
	protected TransparentWebMarkupContainer html;
	
	/**
	 * @param pageLinks Mutable.
	 */
	protected void createPageLinksForBreadcrumb(List<PageLink> pageLinks) {
	}

	public String smartPrefixUri(String prefix, String uri) {
		if (uri.startsWith("//") || uri.startsWith("https:")
				|| uri.startsWith("http:")) {
			return uri;
		} else {
			// no more cache bust for relative CSS URIs
			return prefix + uri;
		}
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		response.render(CssHeaderItem.forReference(Bootstrap.getSettings().getCssResourceReference()));

		// doesn't work, nginx as of 1.3.15 disables Etag if content is gzipped
//		if (requireMgr.getJavaScriptMode() == JavaScriptMode.DEVELOPMENT) {
//			response.render(JavaScriptReferenceHeaderItem
//					.forUrl(webAddress.getJsUri() + "org.soluvas.web.bootstrap/live-soluvas.js"));
//		}

		final String currentStyle = getStyle();
		
//		if (cssLinks != null) {
//			final List<CssLink> filteredCsses = ImmutableList.copyOf(Collections2
//					.filter(cssLinks, new Predicate<CssLink>() {
//						@Override
//						public boolean apply(@Nullable CssLink input) {
//							return Strings.isNullOrEmpty(input.getStyle())
//									|| "*".equals(input.getStyle())
//									|| Objects.equal(currentStyle, input.getStyle());
//						}
//					}));
//	
//			log.trace("Page {} has {} CSS links (from {} total)", getClass()
//					.getName(), filteredCsses.size(), cssLinks.size());
//			final Ordering<CssLink> cssOrdering = Ordering
//					.from(new Comparator<CssLink>() {
//						@Override
//						public int compare(CssLink o1, CssLink o2) {
//							return o1.getWeight() - o2.getWeight();
//						};
//					});
//			final List<CssLink> sortedCsses = cssOrdering
//					.immutableSortedCopy(filteredCsses);
//			for (final CssLink css : sortedCsses) {
//				if (getApplication().usesDeploymentConfig() && css.getMinifiedPath() != null) {
//					response.render(CssHeaderItem.forUrl(smartPrefixUri(
//							webAddress.getSkinUri(), css.getMinifiedPath())));
//				} else {
//					response.render(CssHeaderItem.forUrl(smartPrefixUri(
//							webAddress.getSkinUri(), css.getPath())));
//				}
//			}
//		}
		
		response.render(CssHeaderItem.forReference(PRINT_CSS, "print"));
		
//		response.render(CssHeaderItem.forReference(new CssResourceReference(BootstrapPage.class, "slidebars/slidebars.css")));
//		response.render(CssHeaderItem.forReference(new CssResourceReference(BootstrapPage.class, "slidebars/demos.css")));

		if (headJavaScripts != null) {
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
		}
		
		response.render(JavaScriptHeaderItem.forReference(TinyNavJs.instance()));
		response.render(JavaScriptHeaderItem.forReference(JQueryUiToTop.instance()));
		
//		response.render(JavaScriptHeaderItem.forReference(new JQueryPluginResourceReference(BootstrapPage.class, "slidebars/slidebars.js")));
		
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

	/**
	 * @deprecated Please use {@link #BootstrapPage(PageParameters)} to retain {@code localePrefId} and other {@link PageParameters} for {@code rel=canonical} purpose
	 */
	@Deprecated
	public BootstrapPage() {
		this(null, SidebarVisibility.VISIBLE);
	}

	public BootstrapPage(PageParameters params) {
		this(params, SidebarVisibility.VISIBLE);
	}
	
	public BootstrapPage(@Nullable PageParameters params, SidebarVisibility sidebarVisibility) {
		super(params);
		this.sidebarVisibility = sidebarVisibility;
		this.addedInfoVisibility = AddedInfoVisibility.HIDDEN;
		
		// HTML
		html = new TransparentWebMarkupContainer("html");
		add(html);
		
		if (getApplication().getDebugSettings().isDevelopmentUtilitiesEnabled()) {
			try {
				add(new DebugBar("dev"));
				log.debug("Enabled Wicket development utilities: DebugBar");
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
				this.setBody(new Model<>(appManifest.getTitle()));
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
//		sidebarColumn.add(new CssClassNameAppender(new AbstractReadOnlyModel<String>() {
//			@Override
//			public String getObject() {
//				return BootstrapPage.this.sidebarVisibility == SidebarVisibility.VISIBLE ? "col-xs-12 col-sm-6 col-md-3 col-lg-3" : "";
//			}
//		}));
		sidebarBlocks = new RepeatingView("sidebarBlocks");
		sidebarColumn.add(sidebarBlocks);
		add(sidebarColumn);

		// CONTENT
		contentColumn = new TransparentWebMarkupContainer("contentColumn");
		//pindah ke anak page sebenernya..
//		contentColumn.add(new CssClassNameAppender(new AbstractReadOnlyModel<String>() {
//			@Override
//			public String getObject() {
////				log.debug("Sidebar Visibility is {}", BootstrapPage.this.sidebarVisibility);
//				return BootstrapPage.this.sidebarVisibility == SidebarVisibility.VISIBLE ? "product-section col-xs-12 col-sm-6 col-md-9 col-lg-9" : "col-md-12";
//			}
//		}));
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

		final RepeatingView footerJavaScriptLinks = new RepeatingView(
				"footerJavaScriptLinks");
		if (footerJavaScripts != null) {
			log.trace("Page {} has {} footer JavaScript links", getClass()
					.getName(), footerJavaScripts.size());
			final List<JavaScriptLink> sortedJsLinks = linkOrdering
					.immutableSortedCopy(footerJavaScripts);
			for (JavaScriptLink js : sortedJsLinks) {
				footerJavaScriptLinks.add(new WebMarkupContainer(
						footerJavaScriptLinks.newChildId())
						.add(new AttributeModifier("src", js.getSrc())));
			}
		}
		add(footerJavaScriptLinks);

		final RepeatingView footerJavaScriptSourcesView = new RepeatingView(
				"footerJavaScriptSources");
		if (footerJavaScriptSources != null) {
			log.trace("Page {} has {} footer JavaScript sources", getClass()
					.getName(), footerJavaScriptSources.size());
			final List<JavaScriptSource> sortedJsSources = sourceOrdering
					.immutableSortedCopy(footerJavaScriptSources);
			for (JavaScriptSource js : sortedJsSources) {
				footerJavaScriptSourcesView
						.add(new Label(footerJavaScriptSourcesView.newChildId(), js
								.getScript()).setEscapeModelStrings(false));
			}
		}
		add(footerJavaScriptSourcesView);

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
		if (contributorRepo != null) {
			ComposeUtils.compose(this, contributorRepo.findAll());
		}
		
		contentAddedInfo.setVisible(addedInfoVisibility == AddedInfoVisibility.VISIBLE);
		
		final IModel<PageMeta> origPageMetaModel = createPageMetaModel();
		pageMetaModel = new LoadableDetachableModel<PageMeta>() {
			@Override
			protected PageMeta load() {
				return origPageMetaModel.getObject().toFinal(appManifest.getTitle());
			}
		};

		html.add(new AttributeModifier("lang", new PropertyModel<String>(
				pageMetaModel, "languageCode")));
		// HEAD
		add(new PageMetaPanel("meta", pageMetaModel));
		// add(new Label("pageTitle", "Welcome").setRenderBodyOnly(true));
		final IModel<String> titleModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				return Optional
						.fromNullable(getTitle())
						.or(Optional.fromNullable(pageMetaModel.getObject()
								.getTitle())).orNull();
			}
		};
//		final IModel<String> titleSuffixModel = new LoadableDetachableModel<String>() {
//			@Override
//			protected String load() {
//				return " | " + appManifest.getTitle();
//			}
//		};
		add(new Label("pageTitle", titleModel));
//		add(new Label("pageTitleSuffix", titleSuffixModel)
//				.setRenderBodyOnly(true));
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
		
		final String realBaseUri = BooleanUtils.isTrue(sysConfig.getSslSupported()) ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
		final PageParameters canonicalParameters = new PageParameters(getPageParameters());
		for (final String trackingParameter : TRACKING_PARAMETERS) {
			canonicalParameters.remove(trackingParameter);
		}
		final String canonicalUri = realBaseUri + RequestUtils.toAbsolutePath(getRequest().getUrl().toString(), 
				urlFor(getClass(), canonicalParameters).toString());
		log.trace("Canonical URI for {} {}: {}", getClass().getName(), getPageParameters(), canonicalUri);
		add(new ExternalLink("canonical", canonicalUri));
		
		final PropertyModel<String> descriptionModel = new PropertyModel<>(pageMetaModel, "description");
		final PropertyModel<String> keywordsModel = new PropertyModel<>(pageMetaModel, "keywords");
		final PropertyModel<String> authorModel = new PropertyModel<>(pageMetaModel, "author");
		add(new MetaTag("metaDescription", new Model<>("description"), descriptionModel).add(new ModelVisibilityBehavior(descriptionModel)),
			new MetaTag("metaKeywords", new Model<>("keywords"), keywordsModel).add(new ModelVisibilityBehavior(keywordsModel)),
			new MetaTag("author", new Model<>("author"), authorModel).add(new ModelVisibilityBehavior(authorModel)) );
		final PropertyModel<String> ogTitleModel = new PropertyModel<>(pageMetaModel, "openGraph.title");
		final PropertyModel<String> ogTypeModel = new PropertyModel<>(pageMetaModel,"openGraph.type");
		final IModel<String> ogUrlModel = new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				if (pageMetaModel.getObject().getOpenGraph() != null && pageMetaModel.getObject().getOpenGraph().getUrl() != null) {
					return pageMetaModel.getObject().getOpenGraph().getUrl();
				} else {
					return canonicalUri;
				}
			}
		};
		final PropertyModel<String> ogImageModel = new PropertyModel<>(pageMetaModel,"openGraph.image");
		final PropertyModel<String> ogDescriptionModel = new PropertyModel<>(pageMetaModel,"openGraph.description");
		add(new WebMarkupContainer("ogTitle").add(new AttributeModifier("content", ogTitleModel)).add(new ModelVisibilityBehavior(ogTitleModel)),
			new WebMarkupContainer("ogType").add(new AttributeModifier("content", ogTypeModel)).add(new ModelVisibilityBehavior(ogTypeModel)),
			new WebMarkupContainer("ogUrl").add(new AttributeModifier("content", ogUrlModel)).add(new ModelVisibilityBehavior(ogUrlModel)),
			new WebMarkupContainer("ogImage").add(new AttributeModifier("content", ogImageModel)).add(new ModelVisibilityBehavior(ogImageModel)),
			new WebMarkupContainer("ogDescription").add(new AttributeModifier("content", ogDescriptionModel)).add(new ModelVisibilityBehavior(ogDescriptionModel)));
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
	 * 
	 * Example:
	 * 
	 * <pre>
	 * &commat;Override
	 * protected IModel&lt;PageMeta> createPageMetaModel() {
	 * 	return new LoadableDetachableModel&lt;PageMeta>() {
	 * 		&commat;Override
	 * 		protected PageMeta load() {
	 * 			final ProductRelease release = productReleaseModel.getObject();
	 * 			final PageMeta pageMeta = PagemetaFactory.eINSTANCE.createPageMeta();
	 * 			pageMeta.setPhase(PageMetaPhase.TEXT);
	 * 			if (!Strings.isNullOrEmpty(release.getMetaTitle())) {
	 * 				pageMeta.setTitle(release.getMetaTitle());
	 * 			} else {
	 * 				pageMeta.setTitle(release.getDisplayName());
	 * 			}
	 * 			if (!Strings.isNullOrEmpty(release.getMetaDescription())) {
	 * 				pageMeta.setDescription(release.getMetaDescription());
	 * 			} else if (!Strings.isNullOrEmpty(release.getDescription())) {
	 * 				pageMeta.setDescription(release.getDescription());
	 * 			}
	 * 			if (!Strings.isNullOrEmpty(release.getMetaKeywords())) {
	 * 				pageMeta.setKeywords(release.getMetaKeywords());
	 * 			}
	 * 			pageMeta.setAuthor(appManifest.getOrganizationName());
	 * 			return pageMeta;
	 * 		}
	 * 	};
	 * }
	 * </pre>
	 * 
	 * @return
	 */
	protected IModel<PageMeta> createPageMetaModel() {
		log.debug("Creating PageMeta..");
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
