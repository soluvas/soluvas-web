package org.soluvas.web.bootstrap;

import java.util.List;
import java.util.Locale;

import de.agilecoders.wicket.core.Bootstrap;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;

import com.google.common.collect.ImmutableList;

import de.agilecoders.wicket.core.markup.html.themes.bootstrap.BootstrapCssReference;
import de.agilecoders.wicket.less.LessResourceReference;

/**
 * A {@link LessResourceReference} that requires {@link BootstrapCssReference}.
 * @author mahendri
 */
public class AfterBootstrapLessResourceReference extends LessResourceReference {

	/**
	 * @param key
	 */
	public AfterBootstrapLessResourceReference(Key key) {
		super(key);
	}

	/**
	 * @param scope
	 * @param name
	 */
	public AfterBootstrapLessResourceReference(Class<?> scope, String name) {
		super(scope, name);
	}

	/**
	 * @param scope
	 * @param name
	 * @param locale
	 * @param style
	 * @param variation
	 */
	public AfterBootstrapLessResourceReference(Class<?> scope, String name,
			Locale locale, String style, String variation) {
		super(scope, name, locale, style, variation);
	}
	
	@SuppressWarnings("null")
	@Override
	public List<HeaderItem> getDependencies() {
		return ImmutableList.of(CssHeaderItem.forReference(Bootstrap.getSettings().getCssResourceReference()));
	}
	
	public CssHeaderItem asHeaderItem() {
		return CssHeaderItem.forReference(this);
	}

}
