package org.soluvas.web.site;

/**
 * @author ceefour
 */
public interface PageMetaSupplierFactory<T extends PageMetaSupplier> {
	
	T create(PageRuleContext context);

}
