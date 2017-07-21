package org.soluvas.web.site.google;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.parser.XmlTag;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.web.site.IGoogleAnalyticsSysConfig;

/**
 * Script tag for sending non-interaction event during page load.
 * Created by ceefour on 21/07/2017.
 */
public class GoogleAnalyticsEventScript extends WebComponent {

    @SpringBean(required = false)
    private IGoogleAnalyticsSysConfig gaConfig;

    private String category;
    private String action;
    private String label;
    private Integer value;

    public GoogleAnalyticsEventScript(String id, String category, String action, String label, Integer value) {
        super(id);
        this.category = category;
        this.action = action;
        this.label = label;
        this.value = value;
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        checkComponentTag(tag, "script");
        if (tag.getType() != XmlTag.TagType.CLOSE) {
            tag.getAttributes().put("type", "text/javascript");
        }
    }

    @Override
    public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
        super.onComponentTagBody(markupStream, openTag);
        final String script = GoogleAnalyticsBehavior.getNonInteractionEventScript(gaConfig, category, action, label, value);
        replaceComponentTagBody(markupStream, openTag, script);
    }
}
