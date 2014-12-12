package org.soluvas.web.site.sitemap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ceefour
 *
 */
@XmlRootElement(name="urlset", namespace="http://www.sitemaps.org/schemas/sitemap/0.9")
public class UrlSet {
	
	@XmlElement(name="url")
	private final List<Url> urls = new ArrayList<>();
	
	public List<Url> getUrls() {
		return urls;
	}

}
