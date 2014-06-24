package org.soluvas.web.bootstrap;

import java.util.Locale;

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

	private static final long serialVersionUID = 1L;

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
	public Iterable<? extends HeaderItem> getDependencies() {
		return ImmutableList.of(CssHeaderItem.forReference(BootstrapCssReference.instance()));
	}
	
	public CssHeaderItem asHeaderItem() {
		return CssHeaderItem.forReference(this);
	}

}
