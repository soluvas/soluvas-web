package org.soluvas.web.bootstrap.widget;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameModifier;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * <p>Usage in {@code .nav .nav-pills .nav-stacked}:</p>
 *
 * <pre>{@code
 * <ul class="nav nav-pills nav-stacked">
 *     <li wicket:id="freqLinks">
 *         <a href="#" wicket:id="link"><i wicket:id="icon" class="fa fa-desktop"></i> <wicket:container wicket:id="label">Analytics</wicket:container></a>
 *     </li>
 * </ul>
 * }</pre>
 *
 * Created by ceefour on 31/03/2016.
 *
 * @see NavLinkListView
 */
public class NavLink extends BookmarkablePageLink<Page> {

    public NavLink(Class<? extends Page> pageClass, String label, String icon) {
        super("link", pageClass);
        add(new WebMarkupContainer("icon").add(new CssClassNameModifier("fa", "fa-" + icon)));
        add(new Label("label", label));
    }
}
