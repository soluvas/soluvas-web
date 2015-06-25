package org.soluvas.web.site.semantic;

/**
 * The availability of this item—for example In stock, Out of stock, Pre-order, etc.
 * When stored in database, it can be used to override automatically calculated availability.
 * 
 * <p><a href="https://developers.google.com/structured-data/rich-snippets/products?hl=en&rd=1">For Google:</a>
 * Value is taken from a constrained list of options, expressed in markup using URL links. Google also understands their short names (for example InStock or OutOfStock, without the full URL scope.)</p>
 * 
 * @author ceefour
 * @see <a href="http://schema.org/ItemAvailability">schema:ItemAvailability</a>
 * @see SchemaOrgProperty#AVAILABILITY
 */
public enum ItemAvailability {
	/**
	 * Indicates that the item has been discontinued.
	 * @see http://schema.org/Discontinued 
	 */
	DISCONTINUED("http://schema.org/Discontinued"),
	/**
	 * Indicates that the item is in stock.
	 * @see http://schema.org/InStock
	 */
	IN_STOCK("http://schema.org/InStock"),
	/**
	 * Indicates that the item is available only at physical locations.
	 * @see http://schema.org/InStoreOnly
	 */
	IN_STORE_ONLY("http://schema.org/InStoreOnly"),
	/**
	 * Indicates that the item has limited availability.
	 * @see http://schema.org/LimitedAvailability
	 */
	LIMITED_AVAILABILITY("http://schema.org/LimitedAvailability"),
	/**
	 * Indicates that the item is available only online.
	 * @see http://schema.org/OnlineOnly
	 */
	ONLINE_ONLY("http://schema.org/OnlineOnly"),
	/**
	 * Indicates that the item is out of stock.
	 * @see http://schema.org/OutOfStock
	 */
	OUT_OF_STOCK("http://schema.org/OutOfStock"),
	/**
	 * Indicates that the item is available for pre-order.
	 * @see http://schema.org/PreOrder
	 */
	PRE_ORDER("http://schema.org/PreOrder"),
	/**
	 * Indicates that the item has sold out.
	 * @see http://schema.org/SoldOut
	 */
	SOLD_OUT("http://schema.org/SoldOut");
	
	private String href;

	private ItemAvailability(String href) {
		this.href = href;
	}
	
	public String getHref() {
		return href;
	}
	
}
