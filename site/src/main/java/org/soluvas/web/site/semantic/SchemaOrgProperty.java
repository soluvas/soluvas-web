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
	 * @see SchemaOrgClass#REVIEW
	 * @see SchemaOrgProperty#AGGREGATE_RATING
	 */
	REVIEW,
	/**
	 * <a href="http://schema.org/aggregateRating">schema:aggregateRating</a> - The overall rating, based on a collection of reviews or ratings, of the item.
	 * @see SchemaOrgClass#AGGREGATE_RATING
	 * @see SchemaOrgProperty#REVIEW
	 */
	AGGREGATE_RATING,
	/**
	 * <a href="http://schema.org/itemReviewed">schema:itemReviewed</a> - The item that is being reviewed/rated.
	 * @see SchemaOrgClass#AGGREGATE_RATING
	 */
	ITEM_REVIEWED,
	/**
	 * <a href="http://schema.org/ratingCount">schema:ratingCount</a> - The count of total number of ratings.
	 * @see SchemaOrgClass#AGGREGATE_RATING
	 */
	RATING_COUNT,
	/**
	 * <a href="http://schema.org/reviewCount">schema:reviewCount</a> - The count of total number of reviews.
	 * @see SchemaOrgClass#AGGREGATE_RATING
	 */
	REVIEW_COUNT,
	/**
	 * <a href="http://schema.org/ratingValue">schema:ratingValue</a> - The rating for the content.
	 * @see SchemaOrgClass#AGGREGATE_RATING
	 */
	RATING_VALUE,
	/**
	 * <a href="http://schema.org/bestRating">schema:bestRating</a> - The highest value allowed in this rating system. If bestRating is omitted, 5 is assumed.
	 * @see SchemaOrgClass#AGGREGATE_RATING
	 */
	BEST_RATING,
	/**
	 * <a href="http://schema.org/worstRating">schema:worstRating</a> - The lowest value allowed in this rating system. If worstRating is omitted, 1 is assumed.
	 * @see SchemaOrgClass#AGGREGATE_RATING
	 */
	WORST_RATING,
	/**
	 * <a href="http://schema.org/reviewBody">schema:reviewBody</a> - The actual body of the review.
	 * @see SchemaOrgClass#REVIEW
	 */
	REVIEW_BODY,
	/**
	 * <a href="http://schema.org/reviewRating">schema:reviewRating</a> - The rating given in this review. 
	 * Note that reviews can themselves be rated. The reviewRating applies to rating given by the review. 
	 * The aggregateRating property applies to the review itself, as a creative work.
	 * @see SchemaOrgClass#REVIEW
	 * @see SchemaOrgClass#RATING
	 */
	REVIEW_RATING,
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
	 * <a href="http://schema.org/image">schema:image</a> - An image of the item. This can be a URL or a fully described ImageObject.
	 * Usage: Over 1,000,000 domains
	 */
	IMAGE,
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
	 * <a href="http://schema.org/contentUrl">schema:contentUrl</a> - Actual bytes of the media object, for example the image file or video file.
	 */
	CONTENT_URL,
	/**
	 * <a href="http://schema.org/thumbnailUrl">schema:thumbnailUrl</a> - A thumbnail image relevant to the Thing.
	 */
	THUMBNAIL_URL,
	/**
	 * <a href="http://schema.org/itemOffered">schema:itemOffered</a> - The item being offered.
	 */
	ITEM_OFFERED,
	/**
	 * <a href="http://schema.org/dateCreated">schema:dateCreated</a> - The date on which the CreativeWork was created.
	 */
	DATE_CREATED,
	/**
	 * <a href="http://schema.org/dateModified">schema:dateModified</a> - The date on which the CreativeWork was most recently modified.
	 */
	DATE_MODIFIED,
	/**
	 * <a href="http://schema.org/datePublished">schema:datePublished</a> - Date of first broadcast/publication.
	 */
	DATE_PUBLISHED,
	/**
	 * <a href="http://schema.org/releaseDate">schema:releaseDate</a> - The release date of a product or product model. This can be used to distinguish the exact variant of a product.
	 */
	RELEASE_DATE,
	/**
	 * <a href="http://schema.org/doorTime">schema:doorTime</a> - The time admission will commence.
	 */
	DOOR_TIME,
	/**
	 * <a href="http://schema.org/startDate">schema:startDate</a> - The start date and time of the item (in ISO 8601 date format).
	 * @see SchemaOrgClass#EVENT
	 */
	START_DATE,
	/**
	 * <a href="http://schema.org/endDate">schema:endDate</a> - The end date and time of the item (in ISO 8601 date format).
	 * @see SchemaOrgClass#EVENT
	 */
	END_DATE,
	/**
	 * <a href="http://schema.org/organizer">schema:organizer</a> - An organizer of an Event.
	 */
	ORGANIZER,
	/**
	 * <a href="http://schema.org/location">schema:location</a> - The location of the event, organization or action.
	 * @see SchemaOrgClass#PLACE
	 * @see SchemaOrgClass#POSTAL_ADDRESS
	 */
	LOCATION,
	/**
	 * <a href="http://schema.org/address">schema:address</a> - Physical address of the item.
	 * @see SchemaOrgClass#PLACE
	 * @see SchemaOrgClass#POSTAL_ADDRESS
	 */
	ADDRESS,
	/**
	 * <a href="http://schema.org/addressCountry">schema:addressCountry</a> - The country. For example, USA. You can also provide the two-letter ISO 3166-1 alpha-2 country code.
	 * @see SchemaOrgClass#PLACE
	 * @see SchemaOrgClass#POSTAL_ADDRESS
	 */
	ADDRESS_COUNTRY,
	/**
	 * <a href="http://schema.org/addressLocality">schema:addressLocality</a> - The locality. For example, Mountain View.
	 * @see SchemaOrgClass#PLACE
	 * @see SchemaOrgClass#POSTAL_ADDRESS
	 */
	ADDRESS_LOCALITY,
	/**
	 * <a href="http://schema.org/addressRegion">schema:addressRegion</a> - The region. For example, CA.
	 * @see SchemaOrgClass#PLACE
	 * @see SchemaOrgClass#POSTAL_ADDRESS
	 */
	ADDRESS_REGION,
	/**
	 * <a href="http://schema.org/postOfficeBoxNumber">schema:postOfficeBoxNumber</a> - The post office box number for PO box addresses.
	 * @see SchemaOrgClass#PLACE
	 * @see SchemaOrgClass#POSTAL_ADDRESS
	 */
	POST_OFFICE_BOX_NUMBER,
	/**
	 * <a href="http://schema.org/postalCode">schema:postalCode</a> - The postal code. For example, 94043.
	 * @see SchemaOrgClass#PLACE
	 * @see SchemaOrgClass#POSTAL_ADDRESS
	 */
	POSTAL_CODE,
	/**
	 * <a href="http://schema.org/streetAddress">schema:streetAddress</a> - The street address. For example, 1600 Amphitheatre Pkwy.
	 * @see SchemaOrgClass#PLACE
	 * @see SchemaOrgClass#POSTAL_ADDRESS
	 */
	STREET_ADDRESS,
	/**
	 * <a href="http://schema.org/author">schema:author</a> - The author of this content. Please note that author is special in that HTML 5 provides a special mechanism for indicating authorship via the rel tag. That is equivalent to this and may be used interchangeably.
	 * @see SchemaOrgClass#REVIEW
	 * @see SchemaOrgClass#PERSON
	 * @see SchemaOrgClass#ORGANIZATION
	 * @see SchemaOrgClass#CREATIVE_WORK
	 */
	AUTHOR,
	/**
	 * <a href="http://schema.org/author">schema:creator</a> - The creator/author of this CreativeWork. This is the same as the Author property for CreativeWork.
	 * @see SchemaOrgClass#REVIEW
	 * @see SchemaOrgClass#PERSON
	 * @see SchemaOrgClass#ORGANIZATION
	 * @see SchemaOrgClass#CREATIVE_WORK
	 */
	CREATOR,
	/**
	 * <a href="http://schema.org/headline">schema:headline</a> - Headline of the article.
	 * @see SchemaOrgClass#REVIEW
	 * @see SchemaOrgClass#CREATIVE_WORK
	 */
	HEADLINE,
	/**
	 * <a href="http://schema.org/geo">schema:geo</a> - The geo coordinates of the place.
	 * @see SchemaOrgClass#GEO_COORDINATES
	 */
	GEO,
	/**
	 * <a href="http://schema.org/elevation">schema:elevation</a> - The elevation of a location.
	 * @see SchemaOrgClass#GEO_COORDINATES
	 * @see SchemaOrgProperty#GEO
	 * @see SchemaOrgProperty#LATITUDE
	 * @see SchemaOrgProperty#LONGITUDE
	 */
	ELEVATION,
	/**
	 * <a href="http://schema.org/latitude">schema:latitude</a> - The latitude of a location. For example 37.42242.
	 * @see SchemaOrgClass#GEO_COORDINATES
	 * @see SchemaOrgProperty#GEO
	 * @see SchemaOrgProperty#ELEVATION
	 * @see SchemaOrgProperty#LONGITUDE
	 */
	LATITUDE,
	/**
	 * <a href="http://schema.org/longitude">schema:longitude</a> - The longitude of a location. For example -122.08585.
	 * @see SchemaOrgClass#GEO_COORDINATES
	 * @see SchemaOrgProperty#GEO
	 * @see SchemaOrgProperty#ELEVATION
	 * @see SchemaOrgProperty#LATITUDE
	 */
	LONGITUDE,
}
