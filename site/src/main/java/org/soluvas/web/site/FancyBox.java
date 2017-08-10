package org.soluvas.web.site;

import com.google.common.collect.ImmutableList;
import org.apache.wicket.markup.head.*;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;

import java.util.List;

/**
 * Created by ceefour on 8/10/2017.
 */
public class FancyBox {

    public static CssUrlReferenceHeaderItem CSS = CssUrlReferenceHeaderItem.forUrl("//cdnjs.cloudflare.com/ajax/libs/fancybox/3.1.20/jquery.fancybox.min.css");
    public static UrlResourceReference JS = new UrlResourceReference(
            Url.parse("//cdnjs.cloudflare.com/ajax/libs/fancybox/3.1.20/jquery.fancybox.min.js")) {
        @Override
        public List<HeaderItem> getDependencies() {
            return ImmutableList.of(
                    JavaScriptHeaderItem.forReference(WebApplication.get().getJavaScriptLibrarySettings().getJQueryReference()),
                    CSS);
        }
    };

    public static JavaScriptReferenceHeaderItem asHeaderItem() {
        return JavaScriptReferenceHeaderItem.forReference(JS);
    }
}
