package org.soluvas.web.site.alexa;

import javax.inject.Inject;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.web.site.AlexaSysConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * {@link Configuration} for {@link AlexaCertify}.
 * @author ceefour
 */
@Configuration
public class AlexaConfig {
	
	@Inject
	private SysConfigMapHolder<? extends AlexaSysConfig> sysConfigMapHolder;
	
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
		return alexaCertifyBeans().getCurrent();
	}
	
}