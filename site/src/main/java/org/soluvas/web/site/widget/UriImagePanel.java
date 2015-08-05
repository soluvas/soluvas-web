package org.soluvas.web.site.widget;

import com.google.common.base.Strings;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;

/**
 * Created by ceefour on 03/08/2015.
 */
class UriImagePanel extends GenericPanel<String> {

    public UriImagePanel(String id, IModel<String> model, String cssClass, int height) {
        super(id, model);
        if (!Strings.isNullOrEmpty(model.getObject())) {
            add(new AttributeAppender("class", cssClass));
            final Image img = new Image("img", new UrlResourceReference(Url.parse(model.getObject())));
            img.add(new AttributeAppender("height", height));
            add(img);
        } else {
            add(new EmptyPanel("img"));
        }
    }
}
