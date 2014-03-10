package org.soluvas.web.site;

import java.io.Serializable;

/**
 * @deprecated Use Wicket's renderHead() mechanism.
 * @author ceefour
 */
@Deprecated
public interface JavaScriptAlias extends Serializable {

	/**
	 * @return the from
	 */
	public abstract String getFrom();

	String getMinifiedTo();

	/**
	 * If developmentTo is set to null, this alias will not be active during development.
	 * @return
	 */
	String getDevelopmentTo();

}
