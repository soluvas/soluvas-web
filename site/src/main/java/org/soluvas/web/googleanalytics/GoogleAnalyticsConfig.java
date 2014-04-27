package org.soluvas.web.googleanalytics;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.web.googleanalytics.impl.GoogleAnalyticsManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.google.common.eventbus.EventBus;

/**
 * {@link Configuration} for {@link GoogleAnalyticsManager}.
 * @author ceefour
 */
@Configuration @Lazy
public class GoogleAnalyticsConfig {

	@Inject
	private TenantSelector tenantSelector;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Inject
	private SysConfigMapHolder<EObject> sysConfigMapHolder;
	@Autowired(required=false) @Nullable
	private TenantRepository<?> tenantRepo;
	
	@Bean(destroyMethod="destroy")
	public TenantBeans<GoogleAnalyticsManager> googleAnalyticsMgrBeanRepo() {
		return new TenantBeans<GoogleAnalyticsManager>(GoogleAnalyticsManagerImpl.class, tenantConfig.tenantMap(), appEventBus, tenantRepo) {
			@Override
			protected GoogleAnalyticsManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final EObject sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), EObject.class);
				final boolean enabled = (boolean) PropertyUtils.getProperty(sysConfig, "googleAnalyticsEnabled");
				final String trackingId = (String) PropertyUtils.getProperty(sysConfig, "googleAnalyticsTrackingId");
				final String cookieDomain = (String) PropertyUtils.getProperty(sysConfig, "googleAnalyticsCookieDomain");
				return new GoogleAnalyticsManagerImpl(trackingId, enabled, cookieDomain);
			}
		};
	}
	
	@Bean @Scope("prototype")
	public GoogleAnalyticsManager googleAnalyticsMgr() {
		return googleAnalyticsMgrBeanRepo().get(tenantSelector.tenantRef().getTenantId());
	}

}
