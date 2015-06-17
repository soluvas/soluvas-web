package org.soluvas.web.site;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.OnDemandXmiLoader;
import org.soluvas.commons.ResourceType;
import org.soluvas.commons.TenantSource;
import org.soluvas.commons.config.SysConfigMapHolder;
import org.soluvas.commons.config.TenantSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implements typical {@link org.soluvas.commons.config.SysConfigMapHolder} for {@link StarterSysConfig}.
 * Created by ceefour on 6/14/15.
 */
@Configuration
public class StarterSysConfigConfig implements SysConfigMapHolder<StarterSysConfig> {

    private static final Logger log = LoggerFactory.getLogger(StarterSysConfigConfig.class);

    @Inject
    private Environment env;
    @Inject
    private TenantSelector tenantSelector;

    @Override @Bean
    public Map<String, StarterSysConfig> sysConfigMap() throws IOException {
        Preconditions.checkNotNull(env, "Environment not injected, make sure Spring @Configuration beans ordering is free from circular dependencies");
        final TenantSource tenantSource = env.getProperty("tenantSource", TenantSource.class, TenantSource.CONFIG);
        log.info("Tenant source: {}", tenantSource);
        final Pattern tenantIdPattern = Pattern.compile("([^.]+).+");
        // FIXME: Implement "overlay" support
        switch (tenantSource) {
            case CONFIG:
                final org.springframework.core.io.Resource[] fileResources = new PathMatchingResourcePatternResolver(StarterSysConfigConfig.class.getClassLoader())
                        .getResources("file:config/*.StarterSysConfig.xmi");
                log.info("Loading {} StarterSysConfig resources from config dir: {}", fileResources.length, fileResources);
                final ImmutableMap.Builder<String, StarterSysConfig> configSysConfigMab = ImmutableMap.builder();
                for (final org.springframework.core.io.Resource res : fileResources) {
                    final Matcher tenantIdMatcher = tenantIdPattern.matcher(res.getFilename());
                    Preconditions.checkState(tenantIdMatcher.matches(), "Invalid StarterSysConfig resource name: %s", res.getFilename());
                    final String tenantId = tenantIdMatcher.group(1);
                    final StarterSysConfig sysConfig = new OnDemandXmiLoader<StarterSysConfig>(
                            SitePackage.eINSTANCE, res.getFile()).get();
                    sysConfig.setTenantId(tenantId);
                    configSysConfigMab.put(tenantId, sysConfig);
                }
                return configSysConfigMab.build();
            case CLASSPATH:
                final org.springframework.core.io.Resource[] cpResources = new PathMatchingResourcePatternResolver(StarterSysConfigConfig.class.getClassLoader())
                        .getResources("classpath*:/META-INF/*.StarterSysConfig.xmi");
                log.info("Loading {} StarterSysConfig resources from classpath: {}", cpResources.length, cpResources);
                final ImmutableMap.Builder<String, StarterSysConfig> cpSysConfigMab = ImmutableMap.builder();
                for (final org.springframework.core.io.Resource res : cpResources) {
                    final Matcher tenantIdMatcher = tenantIdPattern.matcher(res.getFilename());
                    Preconditions.checkState(tenantIdMatcher.matches(), "Invalid StarterSysConfig resource name: %s", res.getFilename());
                    final String tenantId = tenantIdMatcher.group(1);
                    final StarterSysConfig sysConfig = new OnDemandXmiLoader<StarterSysConfig>(
                            SitePackage.eINSTANCE, res.getURL(), ResourceType.CLASSPATH).get();
                    sysConfig.setTenantId(tenantId);
                    cpSysConfigMab.put(tenantId, sysConfig);
                }
                return cpSysConfigMab.build();
            case REPOSITORY:
                throw new UnsupportedOperationException("Loading tenant list from repository not yet implemented.");
            default:
                throw new IllegalArgumentException("Unknown tenantSource: " + tenantSource);
        }
    }

    @Bean @Scope("request")
    public StarterSysConfig sysConfig() throws IOException {
        return sysConfigMap().get(tenantSelector.tenantRef().getTenantId());
    }

}
