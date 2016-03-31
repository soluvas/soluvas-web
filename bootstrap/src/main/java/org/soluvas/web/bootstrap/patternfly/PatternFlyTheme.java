package org.soluvas.web.bootstrap.patternfly;

import com.google.common.collect.ImmutableList;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.Theme;
import de.agilecoders.wicket.webjars.request.resource.WebjarsCssResourceReference;
import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import java.util.List;

/**
 * Created by ceefour on 31/03/2016.
 */
public class PatternFlyTheme extends Theme {
    public PatternFlyTheme() {
        super("patternfly");
    }

    @Override
    public List<HeaderItem> getDependencies() {
        return ImmutableList.of(
                CssHeaderItem.forReference(new WebjarsCssResourceReference("patternfly/current/dist/css/patternfly.min.css")),
                CssHeaderItem.forReference(new WebjarsCssResourceReference("patternfly/current/dist/css/patternfly-additions.min.css")),
                JavaScriptHeaderItem.forReference(Bootstrap.getSettings().getJsResourceReference()),
                JavaScriptHeaderItem.forReference(new WebjarsJavaScriptResourceReference("patternfly/current/dist/js/patternfly.min.js"))
        );
    }
}
