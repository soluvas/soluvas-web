package org.soluvas.web.olark;

import javax.inject.Inject;

import org.soluvas.commons.AppManifest;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.tenant.TenantBeans;
import org.soluvas.commons.tenant.TenantUtils;
import org.soluvas.web.olark.impl.LiveChatManagerImpl;
import org.soluvas.web.site.LiveChatSysConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * {@link Configuration} for {@link LiveChatManager}.
 * @author ceefour
 */
@Configuration
public class LiveChatConfig {

	@Inject
	private SysConfigMapHolder<LiveChatSysConfig> sysConfigMapHolder;
	
	@Bean(destroyMethod="destroy")
	public TenantBeans<LiveChatManager> liveChatMgrBeanRepo() {
		return new TenantBeans<LiveChatManager>(LiveChatManagerImpl.class) {
			@Override
			protected LiveChatManagerImpl create(String tenantId, AppManifest appManifest)
					throws Exception {
				final LiveChatSysConfig sysConfig = TenantUtils.selectBean(tenantId, sysConfigMapHolder.sysConfigMap(), LiveChatSysConfig.class);
				final boolean enabled = sysConfig.getLiveChatEnabled();
				final LiveChatProvider provider = sysConfig.getLiveChatProvider();
				final String siteId = sysConfig.getLiveChatSiteId();
				return new LiveChatManagerImpl(siteId, enabled, provider);
			}
		};
	}
	
	@Bean @Scope("prototype")
	public LiveChatManager liveChatMgr() {
		return liveChatMgrBeanRepo().getCurrent();
	}
	
}
