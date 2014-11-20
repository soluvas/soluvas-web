package org.soluvas.web.site.semantic;

/**
 * <a href="http://schema.org/">Schema.org</a> classes.
 * @author ceefour
 */
public enum SchemaOrgClass {
	/**
	 * <a href="http://schema.org/Product">schema:Product</a> - Any offered product or service.
	 * For example: a pair of shoes; a concert ticket; the rental of a car; a haircut; or an episode of a TV show streamed online.
	 */
	PRODUCT,
	/**
	 * <a href="http://schema.org/Offer">schema:Offer</a> - An offer to transfer some rights to an item or to provide a service—for example, an offer to sell tickets to an event, to rent the DVD of a movie, to stream a TV show over the internet, to repair a motorcycle, or to loan a book.
	 * 
	 * <p>For GTIN-related fields, see Check Digit calculator and validation guide from GS1.
	 * @see SchemaOrgProperty#OFFERS
	 */
	OFFER,
	/**
	 * <a href="http://schema.org/Review">schema:Review</a> - A review of an item - for example, of a restaurant, movie, or store.
	 * @see SchemaOrgProperty#REVIEW
	 */
	REVIEW,
	/**
	 * <a href="http://schema.org/Brand">schema:Brand</a> - A brand is a name used by an organization or business person for labeling a product, product group, or similar..
	 * @see SchemaOrgProperty#BRAND
	 */
	BRAND,
	/**
	 * <a href="http://schema.org/Organization">schema:Organization</a> - An organization such as a school, NGO, corporation, club, etc.
	 * @see SchemaOrgProperty#BRAND
	 * @see SchemaOrgProperty#MANUFACTURER
	 */
	ORGANIZATION
}
