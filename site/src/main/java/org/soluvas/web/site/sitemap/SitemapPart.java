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
    /**
     * Like {@link #PERSON}, but is meant to be (partially) public.
     */
    PROFILE,
    CATEGORY,
    ARTICLE,
    SHOP,
    /**
     * <a href="http://schema.org/Product">schema:Product</a>
     */
    PRODUCT,
    PRODUCT_RELEASE,
    /**
     * <a href="http://schema.org/Place">schema:Place</a>
     */
    PLACE,
    /**
     * <a href="http://schema.org/Event">schema:Event</a>
     */
    EVENT,
}
