package org.soluvas.web.site.category;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.ConfigurationRuleBuilderPerform;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.CategoryRepository;
import org.soluvas.category.CategoryStatus;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantState;
import org.soluvas.web.site.SeoBookmarkableMapper;

import com.google.common.collect.ImmutableSet;

/**
 * Works in conjunction with {@link CategoryRequestMapper}.
 * @author ceefour
 */
@RewriteConfiguration
public class CategoryRewriteConfiguration extends HttpConfigurationProvider {

	private static final Logger log = LoggerFactory
			.getLogger(CategoryRewriteConfiguration.class);
	
	@Inject
	private TenantBeans<? extends CategoryRepository> categoryRepos;
	@Inject
	private TenantRepository<?> tenantRepo;

	/* (non-Javadoc)
	 * @see org.ocpsoft.rewrite.config.ConfigurationProvider#getConfiguration(java.lang.Object)
	 */
	@Override
	public Configuration getConfiguration(ServletContext context) {
		log.debug("Preparing Product rewrite configuration");
		ConfigurationRuleBuilderPerform builder = ConfigurationBuilder.begin()
				// legacy URIs: shouldn't be needed after Bippo 7.0, but hey... Google doesn't forget :(
				.addRule().when(Direction.isInbound().and(Path.matches("/category/{path1}")))
				.perform(Redirect.permanent("/" + SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID + "/{path1}"))
				.addRule().when(Direction.isInbound().and(Path.matches("/category/{path1}/{path2}")))
				.perform(Redirect.permanent("/" + SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID + "/{path1}/{path2}"));
		
		for (Map.Entry<String, TenantState> entry : tenantRepo.getStates().entrySet()) {
			if (entry.getValue() == TenantState.ACTIVE) {
				final String tenantId = entry.getKey();
				final CategoryRepository categoryRepo = categoryRepos.get(tenantId);
				final Set<String> slugPaths = categoryRepo.findAllSlugPathsByStatus(ImmutableSet.of(CategoryStatus.ACTIVE));
				if (!slugPaths.isEmpty()) {
					log.debug("{}» Rewriting {} old Category URIs", tenantId, slugPaths.size());
					for (String slugPath : slugPaths) {
						builder.addRule()
							.when(Direction.isInbound().and(Path.matches("/" + slugPath)))
							.perform(Redirect.permanent("/" + SeoBookmarkableMapper.DEFAULT_LOCALE_PREF_ID + "/" + slugPath));
					}
				}
			}
		}
		return builder;
	}

	/* (non-Javadoc)
	 * @see org.ocpsoft.common.pattern.Weighted#priority()
	 */
	@Override
	public int priority() {
		return 10;
	}

}
