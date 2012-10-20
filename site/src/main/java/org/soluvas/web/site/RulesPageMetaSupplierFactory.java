package org.soluvas.web.site;

import java.util.List;

import org.soluvas.web.site.pagemeta.PageRule;

/**
 * Creates {@link RulesPageMetaSupplier} from a {@link PageRuleContext} (which contains tenant information)
 * and a list of {@link PageRule}s.
 * @author ceefour
 */
public class RulesPageMetaSupplierFactory implements PageMetaSupplierFactory<RulesPageMetaSupplier> {

	private List<PageRule> rules;
	
	public RulesPageMetaSupplierFactory(List<PageRule> rules) {
		super();
		this.rules = rules;
	}

	@Override
	public RulesPageMetaSupplier create(PageRuleContext context) {
		return new RulesPageMetaSupplier(rules, context);
	}

}
