package org.soluvas.web.site;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EmfUtils;
import org.soluvas.web.site.pagemeta.PageDeclaration;
import org.soluvas.web.site.pagemeta.PageIcon;
import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageMetaPhase;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PagemetaFactory;
import org.soluvas.web.site.pagemeta.SourcePageDeclaration;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * Provides a {@link PageMeta} using an ordered list of {@link PageRule}s. The later rules
 * will override the information set by the previous rules.
 * @author ceefour
 */
public class RulesPageMetaSupplier implements PageMetaSupplier {
	
	private static final Logger log = LoggerFactory
			.getLogger(RulesPageMetaSupplier.class);
	
	/**
	 * Source of {@link PageRule}s, can be mutable.
	 */
	private final List<PageRule> ruleSource;
	private final PageRuleContext context;
	
	/**
	 * @param ruleSource Can be mutable.
	 * @param context
	 */
	public RulesPageMetaSupplier(final List<PageRule> ruleSource, final PageRuleContext context) {
		super();
		this.ruleSource = ruleSource;
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
		
		final List<PageRule> immutableRules = ImmutableList.copyOf(ruleSource);
		log.debug("Considering {} pageMeta rules with context: {}", immutableRules.size(), context);
		for (final PageRule rule : immutableRules) {
			if (!rule.getSelector().matches(context)) {
				continue;
			}
			processDeclaration(rule.getDeclaration(), pageMeta);
		}
		
		// turn to text
		final Map<String, IModel<?>> modelsScope = context.getPage().getModelsForPageMeta();
		final Map<String, Object> scope = Maps.transformValues(modelsScope, new Function<IModel<?>, Object>() {
			@Override
			@Nullable
			public Object apply(@Nullable IModel<?> input) {
				return input.getObject();
			}
		});
		final PageMeta textPageMeta = pageMeta.getPhase() == PageMetaPhase.TEMPLATE ? pageMeta.toText(scope) : pageMeta;
		final PageMeta finalPageMeta = pageMeta.getPhase() == PageMetaPhase.TEXT ? pageMeta.toFinal() : textPageMeta;
		
		// process Icon
		final PageIcon relativeIcon = finalPageMeta.getIcon();
		final String imagesUri = context.getWebAddress().getImagesUri(); // TODO: determine if secure or not
		final PageIcon absoluteIcon = relativeIcon.toAbsolute(imagesUri);
		finalPageMeta.setIcon(absoluteIcon);
		
		return finalPageMeta;
	}
	
	protected void processDeclaration(@Nonnull final PageDeclaration declaration, @Nonnull final PageMeta pageMeta) {
		log.debug("Applying pageMeta declaration {} to {}", declaration, pageMeta);
		if (declaration instanceof SourcePageDeclaration) {
			SourcePageDeclaration sourcePageDeclaration = (SourcePageDeclaration) declaration;
			final PageMeta source = sourcePageDeclaration.getSource();
			combinePage(pageMeta, source);
		} else {
			log.error("Unknown pageMeta declaration: " + declaration);
			throw new SiteException("Unknown pageMeta declaration: " + declaration);
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
