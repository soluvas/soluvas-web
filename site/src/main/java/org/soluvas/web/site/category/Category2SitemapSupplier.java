package org.soluvas.web.site.category;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.Category2;
import org.soluvas.category.CategoryStatus;
import org.soluvas.category.MongoCategoryRepository;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Sort;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.soluvas.web.site.sitemap.ChangeFreq;
import org.soluvas.web.site.sitemap.SitemapPart;
import org.soluvas.web.site.sitemap.SitemapSupplier;
import org.soluvas.web.site.sitemap.Url;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Created by ceefour on 12/13/14.
 */
public class Category2SitemapSupplier implements SitemapSupplier {

    private static final Logger log = LoggerFactory.getLogger(Category2SitemapSupplier.class);

    @Inject
    private MongoCategoryRepository categoryRepo;
    @Inject
    private WebAddress webAddress;
    @Inject
    private GeneralSysConfig sysConfig;
    @Inject
    private AppManifest appManifest;

    @Override
    public List<Url> getUrls(SitemapPart part) {
        if (part == SitemapPart.CATEGORY) {
            final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
            final ImmutableList.Builder<Url> result = ImmutableList.builder();

            final UriComponentsBuilder categoryUriBuilder = UriComponentsBuilder.fromUriString(baseUri)
                    .path("/{localePrefId}/{slugPath}");
            final Page<Category2> categories = categoryRepo.findAllByStatus(ImmutableSet.of(CategoryStatus.ACTIVE),
            new CappedRequest(10000l, Sort.Direction.DESC, "modificationTime"));


            result.addAll(
                    FluentIterable.from(categories)
                            .transform(new Function<Category2, Url>() {
                                @Nullable @Override
                                public Url apply(Category2 input) {
                                    return new Url(
                                            categoryUriBuilder.buildAndExpand(SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID, input.getSlugPath()).toString(),
                                            new DateTime(appManifest.getDefaultTimeZone()),
                                            ChangeFreq.daily, 0.9);
                                }
                            }) );
            return result.build();
        } else {
            return ImmutableList.of();
        }
    }

}
