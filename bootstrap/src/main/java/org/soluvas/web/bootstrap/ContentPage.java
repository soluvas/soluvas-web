package org.soluvas.web.bootstrap;

import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.site.MustacheRenderer;
import org.soluvas.web.site.WicketMountPoint;

/**
 * Reads HTML file from specified folder or classpath location.
 * URI is e.g. /p/how-to-order
 * 
 * <p>Page-specific sidebar is located in e.g. {@code common/content/about.sidebar.html}.
 * Fallback sidebar for all content pages is located in {@code common/content/_all.sidebar.html}.
 * @author rudi
 * @todo Merge with Soluvas Content.
 */
@SuppressWarnings("serial")
@WicketMountPoint(mountPoint="p/${slug}")
public class ContentPage extends BootstrapPage {

	private static final Logger log = LoggerFactory
			.getLogger(ContentPage.class);
	
	@SpringBean(name="contentLookup")
	private EntityLookup<String, String> contentLookup;
	
	public ContentPage(final PageParameters params) {
		super();
		final String slug = params.get("slug").toString();
		final LoadableDetachableModel<String> contentModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				return contentLookup.findOne(slug);
			}
		};
		final MustacheRenderer contentRenderer = new MustacheRenderer("content", new Model<>(), contentModel);
		add(contentRenderer);
		final LoadableDetachableModel<String> sidebarModel = new LoadableDetachableModel<String>() {
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
		sidebarBlocks.add(sidebarRenderer);
	}
	
}
