package org.soluvas.web.bootstrap;

import java.io.Serializable;
import java.io.StringReader;
import java.util.List;

import javax.xml.stream.XMLInputFactory;

import org.apache.commons.lang3.StringUtils;
import org.ccil.cowan.tagsoup.Parser;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXContentHandler;
import org.soluvas.web.site.SiteException;
import org.xml.sax.InputSource;

/**
 * @author atang
 *
 */
public class ContentNode implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String metaDescription;
	private String body;
	
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * From Soluvas Content's ContentUtils#importHtml().
	 * @param html
	 * @return
	 */
	public static ContentNode importHtml(String html) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		Parser parser = new Parser();
		final SAXContentHandler handler = new SAXContentHandler();
		parser.setContentHandler(handler);
		try {
			parser.setFeature(Parser.CDATAElementsFeature, false);
			parser.setFeature(Parser.namespacesFeature, false);
			parser.parse(new InputSource(new StringReader(html)));
			Document doc = handler.getDocument();
			ContentNode page = new ContentNode();
			final Element titleEl = (Element)doc.selectSingleNode("//title");
			page.setTitle( titleEl != null ? titleEl.getText() : null );
			
//			final Attribute slugAttr = (Attribute)doc.selectSingleNode("//meta[@name='slug']/@content");
//			page.setSlug( slugAttr != null ? slugAttr.getText() : null );
//			final Attribute keywordsAttr = (Attribute)doc.selectSingleNode("//meta[@name='keywords']/@content");
//			page.setMetaKeywords( keywordsAttr != null ? keywordsAttr.getText() : null );
			
			final Attribute descriptionAttribute = (Attribute)doc.selectSingleNode("//meta[@name='description']/@content");
			page.setMetaDescription( descriptionAttribute != null ? descriptionAttribute.getText() : null );
			
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
			
			final List<Node> bodyContents = doc.selectNodes("//body/*");
			String content = "";
			for (Node node : bodyContents) {
				content += node.asXML();
			}
			page.setBody( content );
			return page;
		} catch (Exception e) {
			throw new SiteException(e, "Cannot import HTML to ContentNode from: %s", StringUtils.abbreviateMiddle(html, "…", 200));
		}
	}

}
