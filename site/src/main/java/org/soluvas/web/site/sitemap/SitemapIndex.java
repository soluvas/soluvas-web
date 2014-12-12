package org.soluvas.web.site.sitemap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ceefour
 *
 */
@XmlRootElement(name="sitemapindex", namespace="http://www.sitemaps.org/schemas/sitemap/0.9")
public class SitemapIndex {
	
	@XmlElement(name="sitemap")
	final List<Sitemap> sitemaps = new ArrayList<>();
	
	public List<Sitemap> getSitemaps() {
		return sitemaps;
	}

}
