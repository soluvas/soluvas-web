/**
 * Created by ceefour on 17/12/14.
 */
@javax.annotation.ParametersAreNonnullByDefault
@javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters(
        @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(type=DateTime.class, value=org.soluvas.commons.jaxb.JodaDateTimeAdapter.class)
)
@XmlSchema(
        xmlns={
                @XmlNs(prefix="", namespaceURI="http://a9.com/-/spec/opensearch/1.1/"),
                @XmlNs(prefix="moz", namespaceURI="http://www.mozilla.org/2006/browser/search/")})
package org.soluvas.web.site.opensearch;

import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;