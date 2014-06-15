package org.soluvas.web.bootstrap.content;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.bootstrap.ContentNode;
import org.soluvas.web.site.MustacheRenderer;

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
 */
@SuppressWarnings("serial")
public class ContentPanel extends GenericPanel<ContentNode> {

	private static final Logger log = LoggerFactory
			.getLogger(ContentPanel.class);
	
	@SpringBean(name="contentLookup")
	private EntityLookup<String, String> contentLookup;
	@SpringBean
	private AppManifest appManifest;

	private RepeatingView sidebarBlocks;
	
	public static PageParameters bySlugPath(String slugPath) {
		return new PageParameters().set("slugPath", slugPath);
	}
	
	/**
	 * @param id
	 * @param sidebarBlocks Where to put the sidebar content renderer.
	 */
	public ContentPanel(String id, RepeatingView sidebarBlocks) {
		super(id);
		this.sidebarBlocks = sidebarBlocks;
		setModel(new LoadableDetachableModel<ContentNode>() {
			@Override
			protected ContentNode load() {
				final String slugPath = getPage().getPageParameters().get("slugPath").toString();
				final String original = contentLookup.findOne(slugPath);
				final ContentNode contentNode = ContentNode.importHtml(original);
				log.debug("Content node for '{}': title={} metaDescription={} body={}",
						slugPath, contentNode.getTitle(), contentNode.getMetaDescription(), StringUtils.abbreviateMiddle(contentNode.getBody(), "…", 200));
//				log.debug("Body of contentNode: {}", contentNode.getBody());
				return contentNode;
			}
		});
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		final String slugPath = getPage().getPageParameters().get("slugPath").toString();
		final Component contentRenderer;
		switch (getModelObject().getTemplateSystem()) {
		case NONE:
			contentRenderer = new Label("content", new PropertyModel<String>(getModel(), "body"));
			break;
		case MUSTACHE:
			// MustacheRenderer already includes AppManifest, WebAddress as default scope
			contentRenderer = new MustacheRenderer("content", new Model<>(), new PropertyModel<String>(getModel(), "body"));
			break;
		default:
			throw new RuntimeException("Unknown soluvas:templateSystem: " + getModelObject().getTemplateSystem());
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
	
}
