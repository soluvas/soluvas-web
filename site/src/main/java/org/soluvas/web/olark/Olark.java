package org.soluvas.web.olark;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <a href="https://www.olark.com/">Olark</a> webchat component that can be used standalone
 * (before closing BODY), without rigid SysConfig configuration.
 */
public class Olark extends GenericPanel<String> {
    private static final Logger log = LoggerFactory.getLogger(Olark.class);

    public Olark(String id, Model<String> model) {
        super(id);
        setRenderBodyOnly(true);
        String siteId = model.getObject();
        final String identifyScript = "olark.identify('" + siteId + "');";
        final Label identify = new Label("identify", identifyScript);
        identify.setEscapeModelStrings(false);
        add(identify);
        final String contactHref = "https://www.olark.com/site/" + siteId + "/contact";
        final WebMarkupContainer contact = new WebMarkupContainer("contact");
        contact.add(new AttributeModifier("href", contactHref));
        add(contact);
    }

}
