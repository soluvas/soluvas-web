/**
 * @author ceefour
 *
 */
@javax.annotation.ParametersAreNonnullByDefault
@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters(
	@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(type=DateTime.class, value=org.soluvas.commons.jaxb.JodaDateTimeAdapter.class)
)
@XmlSchema(
	xmlns={
		@XmlNs(prefix="", namespaceURI="http://www.sitemaps.org/schemas/sitemap/0.9"),
		@XmlNs(prefix="image", namespaceURI="http://www.google.com/schemas/sitemap-image/1.1"),
		@XmlNs(prefix="video", namespaceURI="http://www.google.com/schemas/sitemap-video/1.1")})
package org.soluvas.web.site.sitemap;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;

import org.joda.time.DateTime;

