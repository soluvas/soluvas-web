package org.soluvas.web.site.sitemap;

import java.util.List;

/**
 * Created by ceefour on 12/13/14.
 */
public interface SitemapSupplier {

    List<Url> getUrls(SitemapPart part);

}
