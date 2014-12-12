package org.soluvas.web.site.sitemap;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author ceefour
 *
 */
public class Image {
	
	@XmlElement(name="loc")
	private final String loc;
	
	public Image() {
		this(null);
	}

	public Image(String loc) {
		super();
		this.loc = loc;
	}

}
