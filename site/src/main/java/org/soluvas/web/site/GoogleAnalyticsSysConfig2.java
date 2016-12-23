package org.soluvas.web.site;

import org.springframework.core.env.Environment;

import javax.persistence.MappedSuperclass;

/**
 * Created by ceefour on 23/12/2016.
 */
@MappedSuperclass
public class GoogleAnalyticsSysConfig2 implements IGoogleAnalyticsSysConfig {

    private Boolean googleAnalyticsEnabled;
    private String googleAnalyticsTrackingId;
    private String googleAnalyticsCookieDomain;
    private Boolean googleAnalyticsDisplayFeatures;

    public GoogleAnalyticsSysConfig2() {
    }

    public GoogleAnalyticsSysConfig2(Environment env) {
        this.googleAnalyticsEnabled = env.getProperty("google.analytics.enabled", Boolean.class);
        this.googleAnalyticsTrackingId = env.getProperty("google.analytics.tracking-id");
        this.googleAnalyticsCookieDomain = env.getProperty("google.analytics.cookie-domain");
        this.googleAnalyticsDisplayFeatures = env.getProperty("google.analytics.display-features", Boolean.class);
    }

    @Override
    public Boolean getGoogleAnalyticsEnabled() {
        return googleAnalyticsEnabled;
    }

    @Override
    public void setGoogleAnalyticsEnabled(Boolean googleAnalyticsEnabled) {
        this.googleAnalyticsEnabled = googleAnalyticsEnabled;
    }

    @Override
    public String getGoogleAnalyticsTrackingId() {
        return googleAnalyticsTrackingId;
    }

    @Override
    public void setGoogleAnalyticsTrackingId(String googleAnalyticsTrackingId) {
        this.googleAnalyticsTrackingId = googleAnalyticsTrackingId;
    }

    @Override
    public String getGoogleAnalyticsCookieDomain() {
        return googleAnalyticsCookieDomain;
    }

    @Override
    public void setGoogleAnalyticsCookieDomain(String googleAnalyticsCookieDomain) {
        this.googleAnalyticsCookieDomain = googleAnalyticsCookieDomain;
    }

    public Boolean getGoogleAnalyticsDisplayFeatures() {
        return googleAnalyticsDisplayFeatures;
    }

    public void setGoogleAnalyticsDisplayFeatures(boolean googleAnalyticsDisplayFeatures) {
        this.googleAnalyticsDisplayFeatures = googleAnalyticsDisplayFeatures;
    }
}
