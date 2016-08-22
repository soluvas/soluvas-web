package org.soluvas.web.site.person;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantState;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.web.site.SeoBookmarkableMapper;

/**
 * Works in conjunction with {@link PersonRequestMapper}.
 * @author ceefour
 */
// Old person URIs, which were never used anyway!
//@Component
public class PersonRewriteConfiguration extends HttpConfigurationProvider {

	private static final Logger log = LoggerFactory
			.getLogger(PersonRewriteConfiguration.class);
	
	@Inject
	private TenantBeans<? extends PersonRepository> personRepos;
	@Inject
	private TenantRepository<?> tenantRepo;

	/* (non-Javadoc)
	 * @see org.ocpsoft.rewrite.config.ConfigurationProvider#getConfiguration(java.lang.Object)
	 */
	@Override
	public Configuration getConfiguration(ServletContext context) {
		log.debug("Preparing legacy Person rewrite configuration");
		final ConfigurationBuilder builder = ConfigurationBuilder.begin();
		for (Map.Entry<String, TenantState> entry : tenantRepo.getStates().entrySet()) {
			if (entry.getValue() == TenantState.ACTIVE) {
				final String tenantId = entry.getKey();
				final PersonRepository personRepo = personRepos.get(tenantId);
				final Set<String> slugPaths = personRepo.findAllSlugsByStatus(StatusMask.ACTIVE_ONLY);
				if (!slugPaths.isEmpty()) {
					log.debug("{}» Rewriting {} old Person URIs", tenantId, slugPaths.size());
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
