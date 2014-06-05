package org.soluvas.web.site;

import java.util.Locale;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.settings.def.JavaScriptLibrarySettings;

import com.google.common.collect.ImmutableList;

/**
 * A {@link JavaScriptResourceReference} that depends on {@link JavaScriptLibrarySettings#getJQueryReference()}.
 * @author mahendri
 */
@SuppressWarnings("serial")
public class AfterJQueryJavaScriptResourceReference extends
		JavaScriptResourceReference {

	/**
	 * @param key
	 */
	public AfterJQueryJavaScriptResourceReference(Key key) {
		super(key);
	}

	/**
	 * @param scope
	 * @param name
	 */
	public AfterJQueryJavaScriptResourceReference(Class<?> scope, String name) {
		super(scope, name);
	}

	/**
	 * @param scope
	 * @param name
	 * @param locale
	 * @param style
	 * @param variation
	 */
	public AfterJQueryJavaScriptResourceReference(Class<?> scope,
			String name, Locale locale, String style, String variation) {
		super(scope, name, locale, style, variation);
	}

	@Override
	public Iterable<? extends HeaderItem> getDependencies() {
		return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
	};

}
