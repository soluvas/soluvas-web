package org.soluvas.web.site;

import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageRuleCollection;

/**
 * Creates {@link RulesPageMetaSupplier} from a {@link PageRuleContext} (which contains tenant information)
 * and a list of {@link PageRule}s.
 * @author ceefour
 */
public class RulesPageMetaSupplierFactory implements PageMetaSupplierFactory<RulesPageMetaSupplier> {

	private final PageRuleCollection rules;
	
	public RulesPageMetaSupplierFactory(PageRuleCollection rules) {
		super();
		this.rules = rules;
	}

	@Override
	public RulesPageMetaSupplier create(PageRuleContext context) {
		return new RulesPageMetaSupplier(rules.getRules(), context);
	}

}
