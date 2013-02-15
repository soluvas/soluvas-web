package org.soluvas.web.site;

public enum AliasMode {
	/**
	 * This alias is active for any {@link JavaScriptMode}.
	 */
	ANY,
	/**
	 * This alias is only active for {@link JavaScriptMode#MINIFIED} and {@link JavaScriptMode#AGGREGATED_MINIFIED}.
	 */
	MINIFIED
}