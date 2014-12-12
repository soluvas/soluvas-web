package org.soluvas.web.site.sitemap;

import javax.xml.bind.annotation.XmlElement;

import org.joda.time.DateTime;

/**
 * @author ceefour
 *
 */
public class Sitemap {

	@XmlElement(name="loc")
	private final String loc;
	@XmlElement(name="lastmod")
	private final DateTime lastMod;
	
	public Sitemap() {
		this(null, null);
	}
	
	public Sitemap(String loc, DateTime lastMod) {
		super();
		this.loc = loc;
		this.lastMod = lastMod;
	}
	
}
