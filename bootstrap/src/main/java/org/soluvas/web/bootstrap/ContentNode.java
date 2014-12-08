package org.soluvas.web.bootstrap;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.soluvas.web.site.SiteException;

/**
 * @author atang
 * @see CommonFolderContentLookup
 */
public class ContentNode implements Serializable {
	
//	private static final Logger log = LoggerFactory
//			.getLogger(ContentNode.class);
	
	public static enum TemplateSystem {
		NONE,
		MUSTACHE;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String metaDescription;
	private String body;
	private TemplateSystem templateSystem = TemplateSystem.NONE;
	
	public ContentNode() {
		super();
	}

	public ContentNode(String title, String metaDescription, String body) {
		super();
		this.title = title;
		this.metaDescription = metaDescription;
		this.body = body;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	
	public TemplateSystem getTemplateSystem() {
		return templateSystem;
	}
	
	public void setTemplateSystem(TemplateSystem templateSystem) {
		this.templateSystem = templateSystem;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * From Soluvas Content's ContentUtils#importHtml(), but now using JSoup.
	 * @param html
	 * @return
	 */
	public static ContentNode importHtml(String html) {
		ContentNode page = new ContentNode();
		try {
			org.jsoup.nodes.Document doc = Jsoup.parse(html);
			org.jsoup.nodes.Element titleEl = doc.select("head title").first();
			page.setTitle( titleEl != null ? titleEl.text() : null );
			
//			final Attribute slugAttr = (Attribute)doc.selectSingleNode("//meta[@name='slug']/@content");
//			page.setSlug( slugAttr != null ? slugAttr.getText() : null );
//			final Attribute keywordsAttr = (Attribute)doc.selectSingleNode("//meta[@name='keywords']/@content");
//			page.setMetaKeywords( keywordsAttr != null ? keywordsAttr.getText() : null );
			
			final org.jsoup.nodes.Element descriptionEl = doc.select("head meta[name=description]").first();
			page.setMetaDescription( descriptionEl != null ? descriptionEl.attr("content") : null );

			final org.jsoup.nodes.Element templateSystemEl = doc.select("head meta[property=soluvas:templateSystem]").first();
			if (templateSystemEl != null) {
				page.setTemplateSystem(TemplateSystem.valueOf(templateSystemEl.attr("content")));
			}
			
//			final Attribute headingAttr = (Attribute)doc.selectSingleNode("//meta[@name='content:heading']/@content");
//			page.setContentHeading( headingAttr != null ? headingAttr.getText() : null );
//			final Attribute layoutAttr = (Attribute)doc.selectSingleNode("//meta[@name='content:layout']/@content");
//			page.setLayout( layoutAttr != null ? layoutAttr.getText() : null );
//			final Attribute activeAttr = (Attribute)doc.selectSingleNode("//meta[@name='content:active']/@content");
//			page.setActive( activeAttr != null ? Boolean.valueOf(activeAttr.getText()) : null );
//			final Attribute createdAttr = (Attribute)doc.selectSingleNode("//meta[@name='created']/@content");
//			page.setCreated( createdAttr != null ? new DateTime(createdAttr.getText(), DateTimeZone.UTC) : null );
//			final Attribute modifiedAttr = (Attribute)doc.selectSingleNode("//meta[@name='modified']/@content");
//			page.setModified( modifiedAttr != null ? new DateTime(modifiedAttr.getText(), DateTimeZone.UTC) : null );
//			
//			final Element layoutUpdateEl = (Element)doc.selectSingleNode("//script[@type='text/magento-layout+xml']");
//			page.setLayoutUpdateXml( layoutUpdateEl != null ? layoutUpdateEl.getStringValue() : null );
			
			final String bodyContents = doc.body().html();
//			log.debug("Content: {}", content);
			page.setBody( bodyContents );
			return page;
		} catch (Exception e) {
			throw new SiteException(e, "Cannot import HTML to ContentNode from: %s", StringUtils.abbreviateMiddle(html, "…", 200));
		}
	}

}
