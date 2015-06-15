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
	ORGANIZATION,
	/**
	 * <a href="http://schema.org/WebPage">schema:WebPage</a> - A web page. Every web page is implicitly assumed to be declared to be of type WebPage, so the various properties about that webpage, such as breadcrumb may be used. 
	 * We recommend explicit declaration if these properties are specified, but if they are found outside of an itemscope, they will be assumed to be about the page
	 * @see #ITEM_PAGE
	 * @see #IMAGE_GALLERY
	 */
	WEB_PAGE,
	/**
	 * <a href="http://schema.org/CollectionPage">schema:CollectionPage</a> - Web page type: Collection page.
	 * @see #ITEM_PAGE
	 * @see #IMAGE_GALLERY
	 */
	COLLECTION_PAGE,
	/**
	 * <a href="http://schema.org/ImageGallery">schema:ImageGallery</a> - Web page type: Image gallery page.
	 * @see #ITEM_PAGE
	 */
	IMAGE_GALLERY,
	/**
	 * <a href="http://schema.org/ItemPage">schema:ItemPage</a> - A page devoted to a single item, such as a particular product or hotel.
	 * @see #WEB_PAGE
	 */
	ITEM_PAGE,
	/**
	 * <a href="http://schema.org/AboutPage">schema:AboutPage</a> - Web page type: About page.
	 * @see #WEB_PAGE
	 */
	ABOUT_PAGE,
	/**
	 * <a href="http://schema.org/ContactPage">schema:ContactPage</a> - Web page type: Contact page.
	 * @see #WEB_PAGE
	 */
	CONTACT_PAGE,
	/**
	 * <a href="http://schema.org/Event">schema:Event</a> - An event happening at a certain time and location, such as a concert, lecture, or festival. Ticketing information may be added via the 'offers' property. Repeated events may be structured as separate Event objects.
	 * Usage: Between 100,000 and 250,000 domains.
	 */
	EVENT,
	/**
	 * <a href="http://schema.org/VisualArtsEvent">schema:VisualArtsEvent</a> - Visual arts event.
	 */
	VISUAL_ARTS_EVENT,
	/**
	 * <a href="http://schema.org/MusicEvent">schema:MusicEvent</a> - Music event.
	 */
	MUSIC_EVENT,
	/**
	 * <a href="http://schema.org/EducationEvent">schema:EducationEvent</a> - Education event.
	 */
	EDUCATION_EVENT,
	/**
	 * <a href="http://schema.org/PublicationEvent">schema:PublicationEvent</a> - A PublicationEvent corresponds indifferently to the event of publication for a CreativeWork of any type e.g. a broadcast event, an on-demand event, a book/journal publication via a variety of delivery media.
	 * Usage: Between 100 and 1000 domains
	 */
	PUBLICATION_EVENT,
	/**
	 * <a href="http://schema.org/BusinessEvent">schema:BusinessEvent</a> - Business event.
	 * Usage: Between 100 and 1000 domains
	 */
	BUSINESS_EVENT,
	/**
	 * <a href="http://schema.org/SaleEvent">schema:SaleEvent</a> - Sales event.
	 * Usage: Between 100 and 1000 domains
	 */
	SALE_EVENT,
	/**
	 * <a href="http://schema.org/ImageObject">schema:ImageObject</a> - An image file.
	 * Usage: Over 1,000,000 domains
	 */
	IMAGE_OBJECT,
	/**
	 * <a href="http://schema.org/Place">schema:Place</a> - Entities that have a somewhat fixed, physical extension.
	 * Usage: Between 100,000 and 250,000 domains
	 * @see SchemaOrgProperty#LOCATION
	 */
	PLACE,
	/**
	 * <a href="http://schema.org/PostalAddress">schema:PostalAddress</a> - The mailing address
	 * @see SchemaOrgProperty#LOCATION
	 * @see SchemaOrgClass#PLACE
	 */
	POSTAL_ADDRESS,
}
