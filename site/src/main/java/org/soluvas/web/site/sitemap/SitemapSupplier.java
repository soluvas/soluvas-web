package org.soluvas.web.site.sitemap;

import org.soluvas.commons.AppManifest;

import java.util.List;

/**
 * Created by ceefour on 12/13/14.
 * @todo {@code baseUri} should be calculated and prepended by {@link SitemapController} to final URIs.
 *      Also make {@link org.joda.time.DateTime} conform to {@link AppManifest#getDefaultTimeZone()}.
 */
public interface SitemapSupplier {

    List<Url> getUrls(SitemapPart part);

}
