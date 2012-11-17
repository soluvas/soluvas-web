package org.soluvas.web.site.client;

import org.apache.wicket.behavior.Behavior;

/**
 * Extended by {@link Behavior}s such as {@link BackboneModel} to return the
 * generated JavaScript source.
 * @author ceefour
 */
@SuppressWarnings("serial")
public abstract class JsSource extends Behavior {
	
	/**
	 * Returns the generated JavaScript source.
	 * @return
	 */
	public abstract String getJsSource();

}
