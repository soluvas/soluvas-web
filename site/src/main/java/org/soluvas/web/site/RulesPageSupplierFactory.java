package org.soluvas.web.site;

import java.util.List;

/**
 * @author ceefour
 *
 */
public class RulesPageSupplierFactory implements PageSupplierFactory<RulesPageSupplier> {

	private List<PageRule> rules;
	
	public RulesPageSupplierFactory(List<PageRule> rules) {
		super();
		this.rules = rules;
	}

	@Override
	public RulesPageSupplier create(PageRuleContext context) {
		return new RulesPageSupplier(rules, context);
	}

}
