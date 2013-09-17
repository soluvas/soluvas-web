package org.soluvas.web.bootstrap;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.EntityLookup;
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
public class ContentPanel extends GenericPanel<ContentNode> {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory
			.getLogger(ContentPanel.class);
	
	@SpringBean(name="contentLookup")
	private EntityLookup<String, String> contentLookup;
	
	public ContentPanel(String id) {
		super(id);
		setModel(new LoadableDetachableModel<ContentNode>() {
			@Override
			protected ContentNode load() {
				final String slug = getPage().getPageParameters().get("slug").toString();
				final String original = contentLookup.findOne(slug);
				final ContentNode contentNode = ContentNode.importHtml(original);
				log.debug("Content node for '{}': title={} metaDescription={} body={}",
						slug, contentNode.getTitle(), contentNode.getMetaDescription(), StringUtils.abbreviateMiddle(contentNode.getBody(), "…", 200));
				return contentNode;
			}
		});
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		final String slug = getPage().getPageParameters().get("slug").toString();
		final MustacheRenderer contentRenderer = new MustacheRenderer("content", new Model<>(), new PropertyModel<String>(getModel(), "body"));
		add(contentRenderer);
		final IModel<String> sidebarModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				try {
					return contentLookup.findOne(slug + ".sidebar");
				} catch (Exception e) {
					try {
						return contentLookup.findOne("_all.sidebar");
					} catch (Exception e1) {
						log.debug("Sidebar not found for content page {}", slug);
						return null;
					}
				}
			}
		};
		final MustacheRenderer sidebarRenderer = new MustacheRenderer("contentSidebar", new Model<>(), sidebarModel);
		((BootstrapPage) getPage()).sidebarBlocks.add(sidebarRenderer);
	}
	
}
