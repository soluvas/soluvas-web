package org.soluvas.web.bootstrap;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantRepositoryListener;
import org.soluvas.commons.tenant.TenantsStarting;
import org.soluvas.commons.tenant.TenantsStopping;
import org.soluvas.web.site.ThemePref;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Manage Themes and {@link ThemePref} for all tenants.
 * {@link TenantRepository} is supported but not required.
 * @author anton
 */
public class ThemeManager implements TenantRepositoryListener {

	private final Map<String, AppManifest> initialTenantIds;
	
	@Autowired(required=false)
	private TenantRepository<?> tenantRepo;

	public ThemeManager(Map<String, AppManifest> initialTenantIds) {
		super();
		this.initialTenantIds = initialTenantIds;
	}
	
	@PostConstruct
	public void init() {
		
	}
	
	/**
	 * Regenerates <code>theme-style-{tenantId}.less</code> in classpath.
	 * @param tenantId
	 */
	protected void regenerateThemeStyle(String tenantId) {
		
	}

	@Override
	public void onTenantsStarting(TenantsStarting starting) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTenantsStopping(TenantsStopping stopping) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
