package org.soluvas.web.site;

import java.util.List;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EmfUtils;
import org.soluvas.web.site.pagemeta.PageDeclaration;
import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PagemetaFactory;
import org.soluvas.web.site.pagemeta.SourcePageDeclaration;

/**
 * Provides a {@link PageMeta} using an ordered list of {@link PageRule}s. The later rules
 * will override the information set by the previous rules.
 * @author ceefour
 */
public class RulesPageMetaSupplier implements PageMetaSupplier {
	
	private transient Logger log = LoggerFactory
			.getLogger(RulesPageMetaSupplier.class);
	
	private final List<PageRule> rules;
	private final PageRuleContext context;
	
	public RulesPageMetaSupplier(final List<PageRule> rules, final PageRuleContext context) {
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
		final PageMeta pageMeta = PagemetaFactory.eINSTANCE.createPageMeta();
		pageMeta.setIcon(PagemetaFactory.eINSTANCE.createPageIcon());
		pageMeta.setOpenGraph(PagemetaFactory.eINSTANCE.createOpenGraphMeta());
		
		log.debug("Considering {} pageMeta rules with context: {}", rules.size(), context);
		for (final PageRule rule : rules) {
			if (!rule.getSelector().matches(context)) {
				continue;
			}
			processDeclaration(rule.getDeclaration(), pageMeta);
		}
		return pageMeta;
	}
	
	protected void processDeclaration(@Nonnull final PageDeclaration declaration, @Nonnull final PageMeta pageMeta) {
		log.debug("Applying pageMeta declaration {} to {}", declaration, pageMeta);
		if (declaration instanceof SourcePageDeclaration) {
			SourcePageDeclaration sourcePageDeclaration = (SourcePageDeclaration) declaration;
			final PageMeta source = sourcePageDeclaration.getSource();
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
