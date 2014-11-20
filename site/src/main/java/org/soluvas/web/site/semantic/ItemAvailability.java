package org.soluvas.web.site.semantic;

/**
 * The availability of this item—for example In stock, Out of stock, Pre-order, etc.
 * When stored in database, it can be used to override automatically calculated availability.
 * @author ceefour
 * @see <a href="http://schema.org/ItemAvailability">schema:ItemAvailability</a>
 */
public enum ItemAvailability {
	/**
	 * Indicates that the item has been discontinued.
	 * @see http://schema.org/Discontinued 
	 */
	DISCONTINUED,
	/**
	 * Indicates that the item is in stock.
	 * @see http://schema.org/InStock
	 */
	IN_STOCK,
	/**
	 * Indicates that the item is available only at physical locations.
	 * @see http://schema.org/InStoreOnly
	 */
	IN_STORE_ONLY,
	/**
	 * Indicates that the item has limited availability.
	 * @see http://schema.org/LimitedAvailability
	 */
	LIMITED_AVAILABILITY,
	/**
	 * Indicates that the item is available only online.
	 * @see http://schema.org/OnlineOnly
	 */
	ONLINE_ONLY,
	/**
	 * Indicates that the item is out of stock.
	 * @see http://schema.org/OutOfStock
	 */
	OUT_OF_STOCK,
	/**
	 * Indicates that the item is available for pre-order.
	 * @see http://schema.org/PreOrder
	 */
	PRE_ORDER,
	/**
	 * Indicates that the item has sold out.
	 * @see http://schema.org/SoldOut
	 */
	SOLD_OUT
}
