package org.soluvas.web.site;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.EmfUtils;
import org.soluvas.web.site.pagemeta.PageDeclaration;
import org.soluvas.web.site.pagemeta.PageIcon;
import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageMetaCatalog;
import org.soluvas.web.site.pagemeta.PageMetaPhase;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PagemetaFactory;
import org.soluvas.web.site.pagemeta.SourcePageDeclaration;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * Provides {@link PageMeta} instances (metadata for {@link org.soluvas.web.site.Page})
 * to be rendered in a web page template,
 * using an ordered list of {@link PageRule}s. The later rules
 * will override the information set by the previous rules.
 * @author ceefour
 */
public class RulesPageMetaProvider implements PageMetaProvider {
	
	private static final Logger log = LoggerFactory
			.getLogger(RulesPageMetaProvider.class);
	
	/**
	 * Source of {@link PageRule}s, can be dynamic.
	 */
	private final List<PageRule> ruleSource;
	
	/**
	 * @param ruleSource Can be dynamic.
	 * @param context
	 */
	public RulesPageMetaProvider(final List<PageRule> ruleSource) {
		super();
		this.ruleSource = ruleSource;
	}

	/**
	 * @param ruleSource Can be dynamic.
	 * @param context
	 */
	public RulesPageMetaProvider(final PageMetaCatalog pageMetaCatalog) {
		super();
		this.ruleSource = pageMetaCatalog.getRules();
	}

	/**
	 * Creates {@link PageMeta} from a {@link PageRequestContext} (which contains tenant information)
	 * and a list of {@link PageRule}s (in {@link #ruleSource}).
	 * @see org.soluvas.web.site.PageMetaProvider#get(org.soluvas.web.site.PageRequestContext)
	 */
	@Override
	public PageMeta get(PageRequestContext context) {
		// create blank (should be from somewhere)
		final PageMeta pageMeta = PagemetaFactory.eINSTANCE.createPageMeta();
		pageMeta.setIcon(PagemetaFactory.eINSTANCE.createPageIcon());
		pageMeta.setOpenGraph(PagemetaFactory.eINSTANCE.createOpenGraphMeta());
		
		// copy it, so even in dynamic environments, the list won't change during processing
		final List<PageRule> immutableRules = ImmutableList.copyOf(ruleSource);
		log.trace("Considering {} pageMeta rules with context: {}", immutableRules.size(), context);
		for (final PageRule rule : immutableRules) {
			if (!rule.getSelector().matches(context)) {
				continue;
			}
			processDeclaration(rule.getDeclaration(), pageMeta);
		}
		
		// turn to text
		final Map<String, IModel<?>> modelsScope = context.getPage().getModelsForPageMeta();
		final Map<String, Object> modelsScopeMap = Maps.transformValues(modelsScope, new Function<IModel<?>, Object>() {
			@Override @Nullable
			public Object apply(@Nullable IModel<?> model) {
				return model.getObject();
			}
		});
		// cannot use ImmutableMap because modelsScopeMap may contain null values
		final Map<String, Object> scope = Maps.newHashMap();
		scope.put("webAddress", context.getWebAddress());
		scope.put("appManifest", context.getAppManifest());
		scope.putAll(modelsScopeMap);
		final PageMeta textPageMeta = pageMeta.getPhase() == PageMetaPhase.TEMPLATE ? pageMeta.toText(scope) : pageMeta;
		final PageMeta finalPageMeta = pageMeta.getPhase() == PageMetaPhase.TEXT ? pageMeta.toFinal() : textPageMeta;
		
		// process Icon
		final PageIcon relativeIcon = finalPageMeta.getIcon();
		final String imagesUri = context.getWebAddress().getImagesUri(); // TODO: determine if secure or not
		final PageIcon absoluteIcon = relativeIcon.toAbsolute(imagesUri);
		finalPageMeta.setIcon(absoluteIcon);
		
		return finalPageMeta;
	}
	
	protected void processDeclaration(final PageDeclaration declaration, final PageMeta pageMeta) {
		log.trace("Applying pageMeta declaration {} to {}", declaration, pageMeta);
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
		log.trace("Combining {} with {}", current, overlay);
		EmfUtils.combineEObject(current, overlay);
	}

}
