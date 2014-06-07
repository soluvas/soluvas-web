package org.soluvas.web.site.alexa;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Named;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantRepository;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.web.site.AlexaSysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.google.common.eventbus.EventBus;

/**
 * {@link Configuration} for {@link AlexaCertify}.
 * @author ceefour
 */
@Configuration
public class AlexaConfig {
	
	@Inject
	private TenantSelector tenantSelector;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Inject
	private SysConfigMapHolder<AlexaSysConfig> sysConfigMapHolder;
	@Autowired(required=false) @Nullable
	private TenantRepository<?> tenantRepo;
	
	@Bean(destroyMethod="destroy")
	public TenantBeans<AlexaCertify> alexaCertifyBeans() {
		return new TenantBeans<AlexaCertify>(AlexaCertifyImpl.class) {
			@Override
			protected AlexaCertifyImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final AlexaSysConfig sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), AlexaSysConfig.class);
				return new AlexaCertifyImpl(sysConfig.getAlexaCertifyEnabled(), sysConfig.getAlexaCertifyAccount(), 
						sysConfig.getAlexaCertifyDomain(), sysConfig.getAlexaCertifyJsCdn(), sysConfig.getAlexaCertifyImageCdn());
			}
		};
	}
	
	@Bean @Scope("prototype")
	public AlexaCertify alexaCertify() {
		return alexaCertifyBeans().get(tenantSelector.tenantRef().getTenantId());
	}
	
}