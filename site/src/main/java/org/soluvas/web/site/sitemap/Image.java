package org.soluvas.web.site.sitemap;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ceefour
 *
 */
public class Image {
	
	@XmlElement(name="loc", namespace="http://www.google.com/schemas/sitemap-image/1.1")
	private final String loc;
	@Nullable @XmlElement(name="caption", namespace="http://www.google.com/schemas/sitemap-image/1.1")
	private final String caption;
	@Nullable @XmlElement(name="geo_location", namespace="http://www.google.com/schemas/sitemap-image/1.1")
	private final String geoLocation;
	@Nullable @XmlElement(name="title", namespace="http://www.google.com/schemas/sitemap-image/1.1")
	private final String title;
	@Nullable @XmlElement(name="license", namespace="http://www.google.com/schemas/sitemap-image/1.1")
	private final String license;

	public Image() {
		this(null);
	}

	public Image(String loc) {
		super();
		this.loc = loc;
		this.title = null;
		this.caption = null;
		this.geoLocation = null;
		this.license = null;
	}

	public Image(String loc, String title, String caption) {
		super();
		this.loc = loc;
		this.title = title;
		this.caption = caption;
		this.geoLocation = null;
		this.license = null;
	}

	public Image(String loc, String title, String caption, String geoLocation) {
		super();
		this.loc = loc;
		this.title = title;
		this.caption = caption;
		this.geoLocation = geoLocation;
		this.license = null;
	}

	public Image(String loc, String title, String caption, String geoLocation, String license) {
		super();
		this.loc = loc;
		this.title = title;
		this.caption = caption;
		this.geoLocation = geoLocation;
		this.license = license;
	}

}
