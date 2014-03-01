package org.soluvas.web.site.alexa;

import javax.inject.Inject;
import javax.inject.Named;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeanRepository;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.web.site.AlexaCertifySysConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.google.common.eventbus.EventBus;

/**
 * {@link Configuration} for {@link AlexaCertify}.
 * @author ceefour
 */
@Configuration @Lazy
public class AlexaCertifyConfig {
	
	@Inject
	private TenantSelector tenantSelector;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Inject
	private SysConfigMapHolder<AlexaCertifySysConfig> sysConfigMapHolder;
	
	@Bean(destroyMethod="destroy")
	public TenantBeanRepository<AlexaCertify> alexaCertifyBeanRepo() {
		return new TenantBeanRepository<AlexaCertify>(AlexaCertifyImpl.class, tenantConfig.tenantMap(), appEventBus) {
			@Override
			protected AlexaCertifyImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final AlexaCertifySysConfig sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), AlexaCertifySysConfig.class);
				return new AlexaCertifyImpl(sysConfig.getAlexaCertifyEnabled(), sysConfig.getAlexaCertifyAccount(), 
						sysConfig.getAlexaCertifyDomain(), sysConfig.getAlexaCertifyJsCdn(), sysConfig.getAlexaCertifyImageCdn());
			}
		};
	}
	
	@Bean @Scope("prototype")
	public AlexaCertify alexaCertify() {
		return alexaCertifyBeanRepo().get(tenantSelector.tenantRef().getTenantId());
	}

	
	
}