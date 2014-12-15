package org.soluvas.web.site.sitemap;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.joda.time.DateTime;

/**
 * @author ceefour
 *
 */
public class Url {
	
	@XmlElement(name="loc")
	private final String loc;
	@XmlElement(name="lastmod")
	private final DateTime lastMod;
	@XmlElement(name="changefreq")
	private final ChangeFreq changeFreq;
	@XmlElement(name="priority")
	private final double priority;
	@XmlElement(name="image", namespace="http://www.google.com/schemas/sitemap-image/1.1")
	private final List<Image> images = new ArrayList<>();
	
	public Url() {
		this(null, null, null, 0);
	}
	
	public Url(String loc, DateTime lastMod, ChangeFreq changeFreq,
			double priority) {
		super();
		this.loc = loc;
		this.lastMod = lastMod;
		this.changeFreq = changeFreq;
		this.priority = priority;
	}

	public List<Image> getImages() {
		return images;
	}

}
