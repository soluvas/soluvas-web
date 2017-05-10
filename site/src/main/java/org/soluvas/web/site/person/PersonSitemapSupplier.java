package org.soluvas.web.site.person;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.commons.lang3.StringEscapeUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.Person;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.entity.Person2;
import org.soluvas.data.StatusMask;
import org.soluvas.data.domain.CappedRequest;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Projection;
import org.soluvas.data.domain.Sort;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.web.site.SeoBookmarkableMapper;
import org.soluvas.web.site.sitemap.ChangeFreq;
import org.soluvas.web.site.sitemap.Image;
import org.soluvas.web.site.sitemap.SitemapPart;
import org.soluvas.web.site.sitemap.SitemapSupplier;
import org.soluvas.web.site.sitemap.Url;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Created by ceefour on 12/13/14.
 */
public class PersonSitemapSupplier implements SitemapSupplier {

    private static final Logger log = LoggerFactory.getLogger(PersonSitemapSupplier.class);

    @Inject
    private PersonRepository personRepo;
    @Inject
    private WebAddress webAddress;
    @Inject
    private GeneralSysConfig sysConfig;
    @Inject
    private AppManifest appManifest;
    @Inject
    private ImageManager imageMgr;

    @Override
    public List<Url> getUrls(SitemapPart part) {
        if (part == SitemapPart.PERSON) {
            final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
            final ImmutableList.Builder<Url> result = ImmutableList.builder();

            final UriComponentsBuilder personUriBuilder = UriComponentsBuilder.fromUriString(baseUri)
                    .path("/{localePrefId}/{slug}");
            final Page<Person2> people = personRepo.findAll(StatusMask.ACTIVE_ONLY,
                    Projection.only("slug", "name", "photoId", "modificationTime"),
                    new CappedRequest(10000l, Sort.Direction.DESC, "modificationTime"));
            final DateTime oneMonthAgo = new DateTime().minusMonths(1);

            final ImmutableSet<String> imageIds = FluentIterable.from(people)
                    .transformAndConcat(new Function<Person2, ImmutableList<String>>() {
                        @Nullable @Override
                        public ImmutableList<String> apply(@Nullable Person2 input) {
                            return !Strings.isNullOrEmpty(input.getImageId()) ?
                                    ImmutableList.of(input.getImageId()) : ImmutableList.<String>of();
                        }
                    }).toSet();
            final Map<String, DisplayImage> personImages = imageMgr.getSafeImagesByIds(ImageTypes.PERSON, imageIds, ImageStyles.LARGE);
            result.addAll(
                    FluentIterable.from(people)
                        .transform(new Function<Person2, Url>() {
                            @Nullable @Override
                            public Url apply(Person2 input) {
                                double priority = 0.1;
                                if (input.getModificationTime().isAfter(oneMonthAgo)) {
                                    priority += 0.2;
                                }
                                if (!Strings.isNullOrEmpty(input.getImageId())) {
                                    priority += 0.2;
                                }
                                final Url url = new Url(
                                        personUriBuilder.buildAndExpand(SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID, input.getSlug()).toString(),
                                        Optional.fromNullable(input.getModificationTime()).or(new DateTime()).withZone(appManifest.getDefaultTimeZone()),
                                        ChangeFreq.monthly, priority);
                                if (!Strings.isNullOrEmpty(input.getImageId())) {
                                    final DisplayImage img = personImages.get(input.getImageId());
                                    url.getImages().add(new Image(img.getSrc(),
                                    		StringEscapeUtils.escapeHtml3(input.getName()),
                                    		StringEscapeUtils.escapeHtml3(img.getTitle())));
                                }
                                return url;
                            }
                        }) );
            return result.build();
        } else {
            return ImmutableList.of();
        }
    }

}
