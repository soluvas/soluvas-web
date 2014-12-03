package org.soluvas.web.site.semantic;

/**
 * @author ceefour
 *
 */
public enum SchemaOrgProperty {
	/**
	 * <a href="http://schema.org/description">schema:description</a> - A short description of the item.
	 */
	DESCRIPTION,
	/**
	 * <a href="http://schema.org/offers">schema:offers</a> - An offer to provide this item—for example, an offer to sell a product, rent the DVD of a movie, or give away tickets to an event.
	 */
	OFFERS, 
	/**
	 * <a href="http://schema.org/availability">schema:availability</a> - The availability of this item—for example In stock, Out of stock, Pre-order, etc. 
	 */
	AVAILABILITY, 
	/**
	 * <a href="http://schema.org/priceCurrency">schema:priceCurrency</a> - The currency (in 3-letter ISO 4217 format) of the price or a price component, when attached to PriceSpecification and its subtypes. 
	 */
	PRICE_CURRENCY,
	/**
	 * <a href="http://schema.org/price">schema:price</a> - The offer price of a product, or of a price component when attached to PriceSpecification and its subtypes.
	 * 
	 * <p>Usage guidelines:
	 * 
	 * <ul>
	 * 	<li>Use the priceCurrency property (with ISO 4217 codes e.g. "USD") instead of including ambiguous symbols such as '$' in the value.</li>
	 * 	<li>Use '.' (Unicode 'FULL STOP' (U+002E)) rather than ',' to indicate a decimal point. Avoid using these symbols as a readability separator.</li>
	 * 	<li>Note that both RDFa and Microdata syntax allow the use of a "content=" attribute for publishing simple machine-readable values alongside more human-friendly formatting.</li>
	 * 	<li>Use values from 0123456789 (Unicode 'DIGIT ZERO' (U+0030) to 'DIGIT NINE' (U+0039)) rather than superficially similiar Unicode symbols.</li>
	 * </ul> 
	 */
	PRICE, 
	/**
	 * <a href="http://schema.org/sku">schema:sku</a> - The Stock Keeping Unit (SKU), 
	 * i.e. a merchant-specific identifier for a product or service, or the product to which the offer refers.
	 */
	SKU, 
	/**
	 * <a href="http://schema.org/name">schema:name</a> - The name of the item.
	 */
	NAME,
	/**
	 * <a href="http://schema.org/category">schema:category</a> - A category for the item.
	 * Greater signs or slashes can be used to informally indicate a category hierarchy.
	 * 
	 * <p>Note: <a href="https://support.google.com/webmasters/answer/146750?hl=en">Google recognizes category as a Product property</a>, but this not recognized by schema.org.
	 */
	CATEGORY,
	/**
	 * <a href="http://schema.org/review">schema:review</a> - A review of the item.
	 */
	REVIEW,
	/**
	 * <a href="http://schema.org/brand">schema:brand</a> - The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
	 * @see SchemaOrgClass#BRAND
	 * @see SchemaOrgClass#ORGANIZATION
	 */
	BRAND,
	/**
	 * <a href="http://schema.org/brand">schema:manufacturer</a> - The manufacturer of the product.
	 * @see SchemaOrgClass#ORGANIZATION
	 */
	MANUFACTURER,
	/**
	 * <a href="http://schema.org/color">schema:color</a> - The color of the product.
	 */
	COLOR,
	/**
	 * <a href="http://schema.org/mainContentOfPage">schema:mainContentOfPage</a> - Indicates if this web page element is the main subject of the page.
	 */
	MAIN_CONTENT_OF_PAGE,
	/**
	 * <a href="http://schema.org/primaryImageOfPage">schema:primaryImageOfPage</a> - Indicates the main image on the page.
	 */
	PRIMARY_IMAGE_OF_PAGE,
	/**
	 * <a href="http://schema.org/relatedLink">schema:relatedLink</a> - A link related to this web page, for example to other related web pages.
	 */
	RELATED_LINK,
	/**
	 * <a href="http://schema.org/significantLink">schema:significantLink</a> - One of the more significant URLs on the page. Typically, these are the non-navigation links that are clicked on the most.
	 */
	SIGNIFICANT_LINK,
	/**
	 * <a href="http://schema.org/breadcrumb">schema:breadcrumb</a> - A set of links that can help a user understand and navigate a website hierarchy.
	 */
	BREADCRUMB, 
	/**
	 * <a href="http://schema.org/url">schema:url</a> - URL of the item.
	 */
	URL,
	/**
	 * <a href="http://schema.org/thumbnailUrl">schema:thumbnailUrl</a> - A thumbnail image relevant to the Thing.
	 */
	THUMBNAIL_URL,
	/**
	 * <a href="http://schema.org/itemOffered">schema:itemOffered</a> - The item being offered.
	 */
	ITEM_OFFERED
}
