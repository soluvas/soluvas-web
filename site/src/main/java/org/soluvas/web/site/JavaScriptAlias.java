package org.soluvas.web.site;


public interface JavaScriptAlias {

	/**
	 * @return the from
	 */
	public abstract String getFrom();

	/**
	 * @return the to
	 */
	public abstract String getTo();

	/**
	 * @return the mode
	 */
	public abstract AliasMode getMode();

}