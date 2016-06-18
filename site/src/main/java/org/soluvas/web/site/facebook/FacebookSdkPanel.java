package org.soluvas.web.site.facebook;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.socmed.FacebookApp;

import java.util.HashSet;

/**
 * Includes the <a href="https://developers.facebook.com/docs/reference/javascript/">Facebook JavaScript SDK</a>,
 * ideally right after the opening {@code <body>} tag.
 * Created by ceefour on 18/06/2016.
 */
public class FacebookSdkPanel extends GenericPanel<FacebookApp> {

    public FacebookSdkPanel(String id, String apiKey) {
        this(id, new FacebookApp(apiKey, null, ImmutableSet.of()));
    }

    public FacebookSdkPanel(String id, FacebookApp model) {
        this(id, new Model<>(model));
    }

    public FacebookSdkPanel(String id, IModel<FacebookApp> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        setRenderBodyOnly(true);
        final IModel<String> scriptModel = new AbstractReadOnlyModel<String>() {
            @Override
            public String getObject() {
                final String src = "(function(d, s, id) {\n" +
                        "var js, fjs = d.getElementsByTagName(s)[0];\n" +
                        "if (d.getElementById(id)) return;\n" +
                        "js = d.createElement(s); js.id = id;\n" +
                        "js.src = \"//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.6&appId=" + getModelObject().getApiKey() + "\";\n" +
                        "fjs.parentNode.insertBefore(js, fjs);\n" +
                        "}(document, 'script', 'facebook-jssdk'));";
                return src;
            }
        };
        add(new Label("script", scriptModel).setEscapeModelStrings(false));
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        setVisibilityAllowed(null != getModelObject() && !Strings.isNullOrEmpty(getModelObject().getApiKey()));
    }
}
