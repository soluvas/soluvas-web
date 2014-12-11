package org.soluvas.web.bootstrap.content;

import java.io.StringReader;
import java.io.StringWriter;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.bootstrap.CommonFolderContentLookup;
import org.soluvas.web.bootstrap.ContentNode;
import org.soluvas.web.site.MustacheRenderer;
import org.soluvas.web.site.Nl2Br;
import org.soluvas.web.site.SiteException;
import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageMetaPhase;
import org.soluvas.web.site.pagemeta.PagemetaFactory;
import org.soluvas.web.site.semantic.ItemScopeBehavior;
import org.soluvas.web.site.semantic.SchemaOrgClass;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.collect.ImmutableMap;

/**
 * Reads HTML file from specified folder or classpath location.
 * URI is e.g. /p/how-to-order
 * 
 * <p>Page-specific sidebar is located in e.g. {@code common/content/about.sidebar.html}.
 * Fallback sidebar for all content pages is located in {@code common/content/_all.sidebar.html}.
 * 
 * <p>Title and meta description is read from {@code head/title} and {@code head/meta} tags.
 * 
 * @author rudi
 * @todo Merge with Soluvas Content.
 * @see CommonFolderContentLookup
 */
@SuppressWarnings("serial")
public class ContentPanel extends GenericPanel<ContentNode> {

	private static final Logger log = LoggerFactory
			.getLogger(ContentPanel.class);
	private static final DefaultMustacheFactory MF = new DefaultMustacheFactory();

	@SpringBean(name="contentLookup")
	private EntityLookup<String, String> contentLookup;
	@SpringBean
	private AppManifest appManifest;
	@SpringBean
	private WebAddress webAddress;

	private RepeatingView sidebarBlocks;
	private String slugPath;
	private LoadableDetachableModel<PageMeta> pageMetaModel;
	
	public static PageParameters bySlugPath(String slugPath) {
		return new PageParameters().set("slugPath", slugPath);
	}
	
	/**
	 * @param id
	 * @param sidebarBlocks
	 * @param html Where to put the {@link ItemScopeBehavior}.
	 * @param slugPath
	 */
	public ContentPanel(String id, RepeatingView sidebarBlocks, @Nullable Component html, @Nullable final String slugPath) {
		super(id); 
		this.sidebarBlocks = sidebarBlocks;
		setModel(new LoadableDetachableModel<ContentNode>() {
			@Override
			protected ContentNode load() {
				final String wantedSlugPath = slugPath != null ? slugPath : getPage().getPageParameters().get("slugPath").toString();
				final String original = contentLookup.findOne(wantedSlugPath);
				final ContentNode contentNode = ContentNode.importHtml(original);
				log.debug("Content node for '{}': title={} metaDescription={} body={}",
						wantedSlugPath, contentNode.getTitle(), contentNode.getMetaDescription(), StringUtils.abbreviateMiddle(contentNode.getBody(), "…", 200));
//				log.debug("Body of contentNode: {}", contentNode.getBody());
				return contentNode;
			}
		});
		
		if (html != null) {
			html.add(new ItemScopeBehavior(new AbstractReadOnlyModel<SchemaOrgClass>() {
				@Override
				public SchemaOrgClass getObject() {
					final String wantedSlugPath = slugPath != null ? slugPath : getPage().getPageParameters().get("slugPath").toString();
					// TODO: make this flexible from the html itself or "node types" (a la Drupal / HippoCMS)
					if ("about".equalsIgnoreCase(wantedSlugPath)) {
						return SchemaOrgClass.ABOUT_PAGE;
					} else if ("contact".equalsIgnoreCase(wantedSlugPath)) {
						return SchemaOrgClass.CONTACT_PAGE;
					} else {
						return SchemaOrgClass.WEB_PAGE;
					}
				}
			}));
		}
		
		pageMetaModel = new LoadableDetachableModel<PageMeta>() {
			@Override
			protected PageMeta load() {
				final PageMeta pageMeta = PagemetaFactory.eINSTANCE.createPageMeta();
				pageMeta.setPhase(PageMetaPhase.TEXT);
				pageMeta.setAuthor(appManifest.getOrganizationName());
				final ContentNode contentNode = getModelObject();
				switch (contentNode.getTemplateSystem()) {
				case NONE:
					pageMeta.setTitle(contentNode.getTitle());
					pageMeta.setDescription(contentNode.getMetaDescription());
					break;
				case MUSTACHE:
					try {
						final Mustache titleMustache = MF.compile(new StringReader(contentNode.getTitle()), "title");
						try (final StringWriter writer = new StringWriter()) {
							final Object[] scope = new Object[] { getDefaultModelObject(),
									ImmutableMap.of("nl2br", new Nl2Br(), "appManifest", appManifest, "webAddress", webAddress) };
							titleMustache.execute(writer, scope);
							pageMeta.setTitle(writer.toString());
						}
						final Mustache metaDescriptionMustache = MF.compile(new StringReader(contentNode.getMetaDescription()), "metaDescription");
						try (final StringWriter writer = new StringWriter()) {
							final Object[] scope = new Object[] { getDefaultModelObject(),
									ImmutableMap.of("nl2br", new Nl2Br(), "appManifest", appManifest, "webAddress", webAddress) };
							metaDescriptionMustache.execute(writer, scope);
							pageMeta.setDescription(writer.toString());
						}
					} catch (Exception e) {
						throw new SiteException(e, "Cannot render mustache PageMeta for content '%s'",
								getPageRelativePath(), slugPath);
					}
					break;
				default:
					throw new SiteException("Unknown soluvas:templateSystem: " + contentNode.getTemplateSystem());
				}
				return pageMeta;
			}
		};
	}
	
	/**
	 * @param id
	 * @param sidebarBlocks Where to put the sidebar content renderer.
	 */
	public ContentPanel(String id, RepeatingView sidebarBlocks) {
		this(id, sidebarBlocks, null, null);
	}
	
	public ContentPanel(String id, RepeatingView sidebarBlocks, Component html) {
		this(id, sidebarBlocks, html, null);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		slugPath = getPage().getPageParameters().get("slugPath").toString();
		final Component contentRenderer;
		switch (getModelObject().getTemplateSystem()) {
		case NONE:
			contentRenderer = new Label("content", new PropertyModel<String>(getModel(), "body"))
				.setEscapeModelStrings(false);
			break;
		case MUSTACHE:
			// MustacheRenderer already includes AppManifest, WebAddress as default scope
			contentRenderer = new MustacheRenderer("content", new Model<>(), new PropertyModel<String>(getModel(), "body"));
			break;
		default:
			throw new SiteException("Unknown soluvas:templateSystem: " + getModelObject().getTemplateSystem());
		}
		add(contentRenderer);
		final IModel<String> sidebarModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				try {
					return contentLookup.findOne(slugPath + ".sidebar");
				} catch (Exception e) {
					try {
						return contentLookup.findOne("_all.sidebar");
					} catch (Exception e1) {
						log.debug("Sidebar not found for content page {}", slugPath);
						return null;
					}
				}
			}
		};
		final MustacheRenderer sidebarRenderer = new MustacheRenderer(sidebarBlocks.newChildId(), new Model<>(), sidebarModel);
		sidebarBlocks.add(sidebarRenderer);
	}
	
	public LoadableDetachableModel<PageMeta> getPageMetaModel() {
		return pageMetaModel;
	}
	
}
