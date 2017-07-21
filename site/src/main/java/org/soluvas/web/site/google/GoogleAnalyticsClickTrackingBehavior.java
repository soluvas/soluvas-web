package org.soluvas.web.site.google;

import com.google.common.base.Strings;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.parser.XmlTag;
import org.soluvas.web.site.IGoogleAnalyticsSysConfig;

/**
 * Uses Google Analytics for outbound link tracking during onclick.
 * See https://developers.google.com/analytics/devguides/collection/analyticsjs/events#outbound_link_and_form_tracking .
 * Obviously the {@code onclick} attribute will be replaced.
 * Transport beacon will be used (https://developers.google.com/analytics/devguides/collection/analyticsjs/sending-hits#specifying_different_transport_mechanisms)
 * Created by ceefour on 21/07/2017.
 */
public class GoogleAnalyticsClickTrackingBehavior extends Behavior {

    private IGoogleAnalyticsSysConfig config;
    private String category;
    private String action;
    private String label;
    private Integer value;

    public GoogleAnalyticsClickTrackingBehavior(IGoogleAnalyticsSysConfig config,
                                                String category, String action, String label, Integer value) {
        super();
        this.config = config;
        this.category = category;
        this.action = action;
        this.label = label;
        this.value = value;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);
        if (isEnabled(component) && tag.getType() != XmlTag.TagType.CLOSE) {
            final String script = GoogleAnalyticsBehavior.getEventBeaconScript(config, category, action, label, this.value);
            if (!Strings.isNullOrEmpty(script)) {
                tag.getAttributes().put("onclick", script);
            }
        }
    }
}
