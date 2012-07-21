package org.soluvas.web.bootstrap;

import java.util.Comparator;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.ComponentFactory;
import org.soluvas.web.site.CssLink;
import org.soluvas.web.site.JavaScriptLink;
import org.soluvas.web.site.Site;

import com.google.common.collect.Ordering;

/**
 * Base page for Twitter Bootstrap-powered Wicket pages.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BootstrapPage extends WebPage {

	private transient Logger log = LoggerFactory.getLogger(BootstrapPage.class);
	@PaxWicketBean(name="site") private Site site;
	@PaxWicketBean(name="cssLinks") private List<CssLink> cssLinks;
	@PaxWicketBean(name="headJavaScripts") private List<JavaScriptLink> headJavaScripts;
	@PaxWicketBean(name="footerJavaScripts") private List<JavaScriptLink> footerJavaScripts;
	@PaxWicketBean(name="sidebarBlocks") private List<ComponentFactory<?>> sidebarBlocks;
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		
		log.debug("Page {} has {} CSS links", getClass().getName(), cssLinks.size());
		Ordering<CssLink> cssOrdering = Ordering.from(new Comparator<CssLink>() {
			public int compare(CssLink o1, CssLink o2) {
				return o1.getWeight() - o2.getWeight();
			};
		});
		List<CssLink> sortedCsses = cssOrdering.immutableSortedCopy(cssLinks);
		for (CssLink css : sortedCsses) {
			response.renderCSSReference(css.getHref());
		}
		
		log.debug("Page {} has {} head JavaScript links", getClass().getName(), headJavaScripts.size());
		Ordering<JavaScriptLink> jsOrdering = Ordering.from(new Comparator<JavaScriptLink>() {
			public int compare(JavaScriptLink o1, JavaScriptLink o2) {
				return o1.getWeight() - o2.getWeight();
			};
		});
		List<JavaScriptLink> sortedJses = jsOrdering.immutableSortedCopy(headJavaScripts);
		for (JavaScriptLink js : sortedJses) {
			response.renderJavaScriptReference(js.getSrc());
		}
	}
	
	public BootstrapPage() {
		// HEAD
		add(new Label("pageTitle", "Welcome").setRenderBodyOnly(true));
		add(new Label("pageTitleSuffix", site.getPageTitleSuffix()).setRenderBodyOnly(true));
		
		// BODY
		
//		add(new Label("logoText", site.getLogoText()).setRenderBodyOnly(true));
//		add(new Label("logoAlt", site.getLogoAlt()).setRenderBodyOnly(true));
		add(new BookmarkablePageLink<Page>("homeLink", getApplication().getHomePage()) {
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
		
		log.info("Page {} has {} sidebar blocks", getClass().getName(), sidebarBlocks.size());
		add(new ListView<ComponentFactory<?>>("sidebarBlocks", sidebarBlocks) {
			@Override
			protected void populateItem(ListItem<ComponentFactory<?>> item) {
				final ComponentFactory<?> sidebarBlockFactory = (ComponentFactory<?>) item.getModelObject();
				Component sidebarBlock = sidebarBlockFactory.create("block");
				item.add(sidebarBlock);
			}
		});
		
		add(new Footer(new Model<String>(site.getFooterText())));

		log.debug("Page {} has {} footer JavaScript links", getClass().getName(), footerJavaScripts.size());
		Ordering<JavaScriptLink> jsOrdering = Ordering.from(new Comparator<JavaScriptLink>() {
			public int compare(JavaScriptLink o1, JavaScriptLink o2) {
				return o1.getWeight() - o2.getWeight();
			};
		});
		List<JavaScriptLink> sortedJses = jsOrdering.immutableSortedCopy(footerJavaScripts);
		add(new ListView<JavaScriptLink>("footerJavaScripts", sortedJses) {
			@Override
			protected void populateItem(ListItem<JavaScriptLink> item) {
				item.setRenderBodyOnly(true);
				final JavaScriptLink js = item.getModelObject();
				item.add(new Label("js") {
					protected void onComponentTag(ComponentTag tag) {
						super.onComponentTag(tag);
						tag.getAttributes().put("src", js.getSrc());
					};
				});
			}
		});
	}

}
