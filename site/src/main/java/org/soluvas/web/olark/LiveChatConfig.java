package org.soluvas.web.olark;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.emf.ecore.EObject;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.CommonsWebConfig;
import org.soluvas.commons.config.MultiTenantConfig;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.config.TenantSelector;
import org.soluvas.commons.tenant.TenantBeanRepository;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.web.olark.impl.LiveChatManagerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.google.common.eventbus.EventBus;

/**
 * {@link Configuration} for {@link LiveChatManager}.
 * @author ceefour
 */
@Configuration @Lazy
public class LiveChatConfig {

	@Inject
	private TenantSelector tenantSelector;
	@Inject
	private MultiTenantConfig tenantConfig;
	@Inject @Named(CommonsWebConfig.APP_EVENT_BUS)
	private EventBus appEventBus;
	@Inject
	private SysConfigMapHolder<EObject> sysConfigMapHolder;
	
	@Bean(destroyMethod="destroy")
	public TenantBeanRepository<LiveChatManager> liveChatMgrBeanRepo() {
		return new TenantBeanRepository<LiveChatManager>(LiveChatManagerImpl.class, tenantConfig.tenantMap(), appEventBus) {
			@Override
			protected LiveChatManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final EObject sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), EObject.class);
				final boolean enabled = (boolean) PropertyUtils.getProperty(sysConfig, "liveChatEnabled");
				final LiveChatProvider provider = (LiveChatProvider) PropertyUtils.getProperty(sysConfig, "liveChatProvider");
				final String siteId = (String) PropertyUtils.getProperty(sysConfig, "liveChatSiteId");
				return new LiveChatManagerImpl(siteId, enabled, provider);
			}
		};
	}
	
	@Bean @Scope("prototype")
	public LiveChatManager liveChatMgr() {
		return liveChatMgrBeanRepo().get(tenantSelector.tenantRef().getTenantId());
	}
	
}
