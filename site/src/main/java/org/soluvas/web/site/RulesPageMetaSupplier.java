package org.soluvas.web.site;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EmfUtils;

/**
 * Provides a {@link PageMeta} using an ordered list of rules. The later rules
 * will override the information set by the previous rules.
 * @author ceefour
 */
public class RulesPageMetaSupplier implements PageMetaSupplier {
	
	private transient Logger log = LoggerFactory
			.getLogger(RulesPageMetaSupplier.class);
	
	private List<PageRule> rules;
	private PageRuleContext context;
	
	public RulesPageMetaSupplier(List<PageRule> rules, PageRuleContext context) {
		super();
		this.rules = rules;
		this.context = context;
	}

	/* (non-Javadoc)
	 * @see com.google.common.base.Supplier#get()
	 */
	@Override
	public PageMeta get() {
		// create blank (should be from somewhere)
		PageMeta pageMeta = SiteFactory.eINSTANCE.createPageMeta();
		pageMeta.setIcon(SiteFactory.eINSTANCE.createPageIcon());
		pageMeta.setOpenGraph(SiteFactory.eINSTANCE.createOpenGraphMeta());
		
		log.debug("Considering {} pageMeta rules with context: {}", rules.size(), context);
		for (PageRule rule : rules) {
			if (!selectorMatches(rule.getSelector(), context)) {
				continue;
			}
			processDeclaration(rule.getDeclaration(), pageMeta);
		}
		return pageMeta;
	}
	
	protected boolean selectorMatches(PageSelector selector, PageRuleContext context) {
		if (selector instanceof UriPatternPageSelector) {
			UriPatternPageSelector uriSelector = (UriPatternPageSelector) selector;
//			Pattern regexPattern = new UriTemplateParser(uriSelector.getPattern()).getPattern();
			Pattern regexPattern = Pattern.compile(uriSelector.getPattern());
			log.debug("Regex pattern for URI pattern {} is {}", uriSelector.getPattern(), regexPattern);
			if (regexPattern.matcher(context.getUri()).matches()) {
				log.debug("URI {} matches pageMeta selector {}", context.getUri(), selector);
				return true;
			}
			return false;
		} else {
			log.error("Unknown pageMeta selector: " + selector);
			throw new RuntimeException("Unknown pageMeta selector: " + selector);
		}
	}
	
	protected void processDeclaration(PageDeclaration declaration, PageMeta pageMeta) {
		log.debug("Applying pageMeta declaration {} to {}", declaration, pageMeta);
		if (declaration instanceof SourcePageDeclaration) {
			SourcePageDeclaration sourcePageDeclaration = (SourcePageDeclaration) declaration;
			PageMeta source = sourcePageDeclaration.getSource();
			combinePage(pageMeta, source);
		} else {
			log.error("Unknown pageMeta declaration: " + declaration);
			throw new RuntimeException("Unknown pageMeta declaration: " + declaration);
		}
	}
	
	/**
	 * Overlays a pageMeta on top of current pageMeta.
	 * @param current
	 * @param overlay
	 */
	protected void combinePage(PageMeta current, PageMeta overlay) {
		log.info("Combining {} with {}", current, overlay);
		EmfUtils.combineEObject(current, overlay);
	}

}
