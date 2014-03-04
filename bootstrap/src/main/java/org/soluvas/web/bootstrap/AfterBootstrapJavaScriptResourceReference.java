package org.soluvas.web.bootstrap;

import java.util.Locale;

import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import com.google.common.collect.ImmutableList;

import de.agilecoders.wicket.core.markup.html.references.BootstrapJavaScriptReference;

/**
 * A {@link JavaScriptResourceReference} that depends on {@link JQueryResourceReference}.
 * @author mahendri
 */
public class AfterBootstrapJavaScriptResourceReference extends
		JavaScriptResourceReference {

	private static final long serialVersionUID = 1L;

	/**
	 * @param key
	 */
	public AfterBootstrapJavaScriptResourceReference(Key key) {
		super(key);
	}

	/**
	 * @param scope
	 * @param name
	 */
	public AfterBootstrapJavaScriptResourceReference(Class<?> scope, String name) {
		super(scope, name);
	}

	/**
	 * @param scope
	 * @param name
	 * @param locale
	 * @param style
	 * @param variation
	 */
	public AfterBootstrapJavaScriptResourceReference(Class<?> scope,
			String name, Locale locale, String style, String variation) {
		super(scope, name, locale, style, variation);
	}

	@Override
	public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
		return ImmutableList.of( JavaScriptHeaderItem.forReference(BootstrapJavaScriptReference.instance()) );
	};

}
