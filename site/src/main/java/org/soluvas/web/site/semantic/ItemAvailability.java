package org.soluvas.web.site.semantic;

/**
 * The availability of this item—for example In stock, Out of stock, Pre-order, etc.
 * When stored in database, it can be used to override automatically calculated availability.
 * 
 * <p><a href="https://support.google.com/webmasters/answer/146750?hl=en&ref_topic=4599102">For Google:</a> Any text may be specified, but the value of the content attribute must be one of the following recognized values:
 * <ul>
 * 	<li>out_of_stock</li>
 * 	<li>in_stock</li>
 * 	<li>instore_only</li>
 * 	<li>preorder</li>
 * </ul>
 * 
 * @author ceefour
 * @see <a href="http://schema.org/ItemAvailability">schema:ItemAvailability</a>
 */
public enum ItemAvailability {
	/**
	 * Indicates that the item has been discontinued.
	 * @see http://schema.org/Discontinued 
	 */
	DISCONTINUED("discontinued"),
	/**
	 * Indicates that the item is in stock.
	 * @see http://schema.org/InStock
	 */
	IN_STOCK("in_stock"),
	/**
	 * Indicates that the item is available only at physical locations.
	 * @see http://schema.org/InStoreOnly
	 */
	IN_STORE_ONLY("instore_only"),
	/**
	 * Indicates that the item has limited availability.
	 * @see http://schema.org/LimitedAvailability
	 */
	LIMITED_AVAILABILITY("limited_availability"),
	/**
	 * Indicates that the item is available only online.
	 * @see http://schema.org/OnlineOnly
	 */
	ONLINE_ONLY("online_only"),
	/**
	 * Indicates that the item is out of stock.
	 * @see http://schema.org/OutOfStock
	 */
	OUT_OF_STOCK("out_of_stock"),
	/**
	 * Indicates that the item is available for pre-order.
	 * @see http://schema.org/PreOrder
	 */
	PRE_ORDER("preorder"),
	/**
	 * Indicates that the item has sold out.
	 * @see http://schema.org/SoldOut
	 */
	SOLD_OUT("sold_out");
	
	private String content;

	private ItemAvailability(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
}
