package org.soluvas.web.site.opensearch;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.WebAddress;

import javax.inject.Inject;

/**
 * Usage in your base page(s):
 *
 * <pre>
 * &lt;link wicket:id="openSearch"/>
 * </pre>
 *
 * Created by ceefour on 17/12/14.
 * @see org.soluvas.web.site.opensearch.OpenSearchController
 */
public class OpenSearchLink extends ExternalLink {

//    @Inject
//    private GeneralSysConfig sysConfig;
//    @Inject
//    private WebAddress webAddress;
    @Inject
    private AppManifest appManifest;

    public OpenSearchLink(String id) {
        super(id, "/search.xml");
//        final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
//        setDefaultModelObject(baseUri + "search.xml");
        add(new AttributeModifier("rel", "search"));
        add(new AttributeModifier("type", OpenSearchController.APPLICATION_OPENSEARCHDESCRIPTION_XML));
        add(new AttributeModifier("title", appManifest.getTitle()));
    }

}
