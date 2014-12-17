package org.soluvas.web.site.opensearch;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by ceefour on 17/12/14.
 */
public class Image {

    private String uri;
    private String type;
    private int width;
    private int height;

    public Image() {
    }

    public Image(String uri, String type, int width, int height) {
        this.uri = uri;
        this.type = type;
        this.width = width;
        this.height = height;
    }

    @XmlValue
    public String getUri() {
        return uri;
    }

    @XmlAttribute
    public String getType() {
        return type;
    }

    @XmlAttribute
    public int getWidth() {
        return width;
    }

    @XmlAttribute
    public int getHeight() {
        return height;
    }

}
