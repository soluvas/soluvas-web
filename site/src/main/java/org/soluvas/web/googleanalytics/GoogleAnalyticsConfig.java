package org.soluvas.web.googleanalytics;

import javax.inject.Inject;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.web.googleanalytics.impl.GoogleAnalyticsManagerImpl;
import org.soluvas.web.site.GoogleAnalyticsSysConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * {@link Configuration} for {@link GoogleAnalyticsManager}.
 * @author ceefour
 */
@Configuration
public class GoogleAnalyticsConfig {

	@Inject
	private SysConfigMapHolder<GoogleAnalyticsSysConfig> sysConfigMapHolder;
	
	@Bean(destroyMethod="destroy")
	public TenantBeans<GoogleAnalyticsManager> googleAnalyticsMgrBeanRepo() {
		return new TenantBeans<GoogleAnalyticsManager>(GoogleAnalyticsManagerImpl.class) {
			@Override
			protected GoogleAnalyticsManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final GoogleAnalyticsSysConfig sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), GoogleAnalyticsSysConfig.class);
				final boolean enabled = sysConfig.getGoogleAnalyticsEnabled();
				final String trackingId = sysConfig.getGoogleAnalyticsTrackingId();
				final String cookieDomain = sysConfig.getGoogleAnalyticsCookieDomain();
				return new GoogleAnalyticsManagerImpl(trackingId, enabled, cookieDomain);
			}
		};
	}
	
	@Bean @Scope("prototype")
	public GoogleAnalyticsManager googleAnalyticsMgr() {
		return googleAnalyticsMgrBeanRepo().getCurrent();
	}

}
