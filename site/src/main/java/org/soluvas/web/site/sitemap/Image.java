package org.soluvas.web.site.sitemap;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author ceefour
 *
 */
public class Image {
	
	@XmlElement(name="loc")
	private final String loc;
	@Nullable @XmlElement(name="caption")
	private final String caption;
	@Nullable @XmlElement(name="geo_location")
	private final String geoLocation;
	@Nullable @XmlElement(name="title")
	private final String title;
	@Nullable @XmlElement(name="license")
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
