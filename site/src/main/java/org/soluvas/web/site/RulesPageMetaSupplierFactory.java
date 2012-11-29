package org.soluvas.web.site;

import javax.annotation.Nonnull;

import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageRuleCollection;

import com.google.common.base.Supplier;

/**
 * Creates {@link RulesPageMetaSupplier} from a {@link PageRuleContext} (which contains tenant information)
 * and a list of {@link PageRule}s.
 * @author ceefour
 */
public class RulesPageMetaSupplierFactory implements PageMetaSupplierFactory<RulesPageMetaSupplier> {

	private final Supplier<PageRuleCollection> rulesSupplier;
	
	public RulesPageMetaSupplierFactory(@Nonnull final Supplier<PageRuleCollection> rulesSupplier) {
		super();
		this.rulesSupplier = rulesSupplier;
	}

	@Override
	public RulesPageMetaSupplier create(@Nonnull final PageRuleContext context) {
		return new RulesPageMetaSupplier(rulesSupplier.get().getRules(), context);
	}

}
