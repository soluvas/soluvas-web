package org.soluvas.web.bootstrap.content;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.StatusMask;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.soluvas.web.site.sitemap.ChangeFreq;
import org.soluvas.web.site.sitemap.SitemapPart;
import org.soluvas.web.site.sitemap.SitemapSupplier;
import org.soluvas.web.site.sitemap.Url;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;

/**
 * Created by ceefour on 12/13/14.
 */
public class ContentSitemapSupplier implements SitemapSupplier {

    private static final Logger log = LoggerFactory.getLogger(ContentSitemapSupplier.class);

    @Inject
    private ContentRepository contentRepo;
    @Inject
    private WebAddress webAddress;
    @Inject
    private GeneralSysConfig sysConfig;
    @Inject
    private AppManifest appManifest;
//    @Inject
//    private ImageManager imageMgr;

    @Override
    public List<Url> getUrls(SitemapPart part) {
        if (part == SitemapPart.PAGE) {
            final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
            final ImmutableList.Builder<Url> result = ImmutableList.builder();

            final UriComponentsBuilder contentUriBuilder = UriComponentsBuilder.fromUriString(baseUri)
                    .path("/{localePrefId}/{slug}");
            final Set<String> slugs = contentRepo.findAllSlugPathsByStatus(StatusMask.ACTIVE_ONLY);

            result.addAll(
                    FluentIterable.from(slugs)
                        .transform(new Function<String, Url>() {
                            @Nullable @Override
                            public Url apply(String input) {
                                return new Url(
                                        contentUriBuilder.buildAndExpand(SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID, input).toString(),
                                        new DateTime(appManifest.getDefaultTimeZone()),
                                        ChangeFreq.weekly, 0.6);
                            }
                        }) );
            return result.build();
        } else {
            return ImmutableList.of();
        }
    }

}
