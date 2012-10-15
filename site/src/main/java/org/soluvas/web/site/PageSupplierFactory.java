package org.soluvas.web.site;

/**
 * @author ceefour
 */
public interface PageSupplierFactory<T extends PageSupplier> {
	
	T create(PageRuleContext context);

}
