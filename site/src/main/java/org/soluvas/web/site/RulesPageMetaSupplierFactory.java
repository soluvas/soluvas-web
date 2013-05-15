package org.soluvas.web.site;

import org.soluvas.web.site.pagemeta.PageMetaCatalog;
import org.soluvas.web.site.pagemeta.PageRule;

import com.google.common.base.Supplier;

/**
 * Creates {@link RulesPageMetaSupplier} from a {@link PageRequestContext} (which contains tenant information)
 * and a list of {@link PageRule}s.
 * @author ceefour
 */
@Deprecated
public class RulesPageMetaSupplierFactory implements PageMetaSupplierFactory<RulesPageMetaSupplier> {

	private final Supplier<PageMetaCatalog> rulesSupplier;
	
	public RulesPageMetaSupplierFactory(final Supplier<PageMetaCatalog> rulesSupplier) {
		super();
		this.rulesSupplier = rulesSupplier;
	}

	@Override
	public RulesPageMetaSupplier create(final PageRequestContext context) {
		return new RulesPageMetaSupplier(rulesSupplier.get().getRules(), context);
	}

}
