package org.soluvas.web.site;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.resource.UrlResourceReference;
import org.apache.wicket.settings.def.JavaScriptLibrarySettings;

import com.google.common.collect.ImmutableList;

/**
 * A {@link UrlResourceReference} that depends on {@link JavaScriptLibrarySettings#getJQueryReference()}.
 * @author mahendri
 * @deprecated Use {@link de.agilecoders.wicket.core.markup.html.references.JQueryPluginUrlResourceReference}
 */
@SuppressWarnings("serial") @Deprecated
public class AfterJQueryUrlResourceReference extends
		UrlResourceReference {

	public AfterJQueryUrlResourceReference(Url url) {
		super(url);
	}

	public AfterJQueryUrlResourceReference(String url) {
		super(Url.parse(url));
	}

	@Override
	public Iterable<? extends HeaderItem> getDependencies() {
		return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
	};

}
