package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.soluvas.web.site.AfterJQueryUrlResourceReference;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * @author rio
 * @todo Do we need to custmoize {@literal ui.totop.css} ?
 */
@SuppressWarnings("serial")
public class JQueryUiToTop {

	/**
	 * references {@literal ../img/ui.totop.png}
	 */
	private static final CssResourceReference TOTOP_CSS = new CssResourceReference(JQueryUiToTop.class, "jquery.ui.totop-1.2/css/ui.totop.css");
	private static final JavaScriptResourceReference TOTOP = new JavaScriptResourceReference(JQueryUiToTop.class, "jquery.ui.totop-1.2/jquery.ui.totop.js") {
		@Override
		public Iterable<? extends HeaderItem> getDependencies() {
			return Iterables.concat(super.getDependencies(), ImmutableList.<HeaderItem>of(
					JavaScriptHeaderItem.forReference(JQueryEasing.instance()), 
					CssHeaderItem.forReference(TOTOP_CSS)));
		};
	};
	private static final UrlResourceReference TOTOP_CDN = new AfterJQueryUrlResourceReference("//cdn.jsdelivr.net/jquery.uitotop/1.2/js/jquery.ui.totop.min.js") {
		@Override
		public Iterable<? extends HeaderItem> getDependencies() {
			return Iterables.concat(super.getDependencies(), ImmutableList.of(
					JavaScriptHeaderItem.forReference(JQueryEasing.instance()),
					CssHeaderItem.forUrl("//cdn.jsdelivr.net/jquery.uitotop/1.2/css/ui.totop.css")));
		};
	};
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}, includes CSS and latest {@link JQueryEasing} (no compatibility with old easing names).
	 * @return
	 */
	public static ResourceReference instance() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return TOTOP_CDN;
		} else {
			return TOTOP;
		}
	}
	
}