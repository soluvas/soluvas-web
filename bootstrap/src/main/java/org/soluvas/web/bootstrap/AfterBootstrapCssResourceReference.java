package org.soluvas.web.bootstrap;

import com.google.common.collect.ImmutableList;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

import java.util.List;
import java.util.Locale;

/**
 * A {@link CssResourceReference} that requires {@link BootstrapSettings#getCssResourceReference()}.
 * @author mahendri
 * @deprecated Doesn't work well with {@link de.agilecoders.wicket.core.markup.html.themes.bootstrap.BootstrapTheme} anyway.
 */
public class AfterBootstrapCssResourceReference extends CssResourceReference {

	/**
	 * @param key
	 */
	public AfterBootstrapCssResourceReference(Key key) {
		super(key);
	}

	/**
	 * @param scope
	 * @param name
	 */
	public AfterBootstrapCssResourceReference(Class<?> scope, String name) {
		super(scope, name);
	}

	/**
	 * @param scope
	 * @param name
	 * @param locale
	 * @param style
	 * @param variation
	 */
	public AfterBootstrapCssResourceReference(Class<?> scope, String name,
			Locale locale, String style, String variation) {
		super(scope, name, locale, style, variation);
	}
	
	@SuppressWarnings("null")
	@Override
	public List<HeaderItem> getDependencies() {
		return ImmutableList.of(); //screws bootswatch CSS: CssHeaderItem.forReference(Bootstrap.getSettings().getCssResourceReference()));
	}

	public CssHeaderItem asHeaderItem() {
		return CssHeaderItem.forReference(this);
	}

}
