package org.soluvas.web.site.sitemap;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ceefour on 12/13/14.
 */
public enum SitemapPart {
    PAGE,
    PERSON,
    CATEGORY,
    ARTICLE,
    SHOP,
    PRODUCT,
    PRODUCT_RELEASE
}
