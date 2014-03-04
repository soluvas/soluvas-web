package org.soluvas.web.bootstrap;

import java.util.Locale;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

import com.google.common.collect.ImmutableList;

import de.agilecoders.wicket.core.markup.html.themes.bootstrap.BootstrapCssReference;

/**
 * A {@link CssResourceReference} that requires {@link BootstrapCssReference}.
 * @author mahendri
 */
public class AfterBootstrapCssResourceReference extends CssResourceReference {

	private static final long serialVersionUID = 1L;

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
	public Iterable<? extends HeaderItem> getDependencies() {
		return ImmutableList.of(CssHeaderItem.forReference(BootstrapCssReference.instance()));
	}

}
