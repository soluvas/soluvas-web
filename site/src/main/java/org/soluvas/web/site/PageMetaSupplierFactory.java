package org.soluvas.web.site;

import org.soluvas.web.site.pagemeta.PageMeta;

/**
 * The name is unfortunate, but I think necessary: To get a {@link PageMeta} instance,
 * first we need to pass the {@link PageRequestContext} which contains tenant information,
 * to the {@link PageMetaSupplierFactory}, so that we get a configured {@link PageMetaSupplier}
 * (usually a {@link RulesPageMetaSupplier}) for that tenant.
 * A {@link PageMetaSupplier} is already tenant-scoped, so it can then perform a lookup
 * based on its own algorithm.
 * @author ceefour
 */
public interface PageMetaSupplierFactory<T extends PageMetaSupplier> {
	
	T create(PageRequestContext context);

}
