package org.soluvas.web.bootstrap;

import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.SidebarBlock;
import org.soluvas.web.site.Site;

/**
 * Base page for Twitter Bootstrap-powered Wicket pages.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BootstrapPage extends WebPage {

	private transient Logger log = LoggerFactory.getLogger(BootstrapPage.class);
	@PaxWicketBean(name="site") private Site site;
	@PaxWicketBean(name="sidebarBlocks") private List<SidebarBlock> sidebarBlocks;
	
	public BootstrapPage() {
		add(new Label("pageTitle", "Welcome").setRenderBodyOnly(true));
		add(new Label("pageTitleSuffix", site.getPageTitleSuffix()).setRenderBodyOnly(true));
//		add(new Label("logoText", site.getLogoText()).setRenderBodyOnly(true));
//		add(new Label("logoAlt", site.getLogoAlt()).setRenderBodyOnly(true));
		add(new BookmarkablePageLink("homeLink", getApplication().getHomePage()) {
			{
				this.setBody(new Model<String>(site.getLogoText()));
			}
			@Override
			protected void onComponentTag(ComponentTag tag) {
				super.onComponentTag(tag);
				tag.getAttributes().put("title", site.getLogoAlt());
			}
		});
		
		add(new Header());
		
		log.info("You have {} sidebar blocks", sidebarBlocks.size());
		add(new ListView<SidebarBlock>("sidebarBlocks", sidebarBlocks) {
			@Override
			protected void populateItem(ListItem<SidebarBlock> item) {
				final SidebarBlock sidebarBlockFactory = (SidebarBlock) item.getModelObject();
				Component sidebarBlock = sidebarBlockFactory.create();
				item.add(sidebarBlock);
			}
		});
		
		
		add(new Footer());
	}

}
