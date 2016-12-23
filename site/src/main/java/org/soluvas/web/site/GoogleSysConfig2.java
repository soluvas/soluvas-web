/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;
import org.springframework.core.env.Environment;

/**
 * SysConfig for <a href="https://developers.google.com/+/">Google+ Sign-in</a> and <a href="https://www.google.com/webmasters/tools/home">Google Webmasters Toolkit</a>.
 *
 * <p>Properties:</p>
 * <ul>
 * 	<li>google.api-key</li>
 * 	<li>google.client-id</li>
 *  <li>google.client-secret</li>
 *  <li>google.verify-id</li>
 * </ul>
 */
public class GoogleSysConfig2 {

	private String googleApiKey;
	private String googleClientId;
	private String googleClientSecret;
	private String googleVerifyId;

	public GoogleSysConfig2() {
	}

	public GoogleSysConfig2(Environment env) {
		this.googleApiKey = env.getProperty("google.api-key");
		this.googleClientId = env.getProperty("google.client-id");
		this.googleClientSecret = env.getProperty("google.client-secret");
		this.googleVerifyId = env.getProperty("google.verify-id");
	}

	/**
	 * <a href="https://developers.google.com/console/help/using-keys">Public API access</a>
	 *
	 * <p>Use of this key does not require any user action or consent, does not grant access to any account information, and is not used for authorization.
	 *
	 * <p>Get this from <a href="https://console.developers.google.com/">Google Developers Console</a> - API Project - APIs & auth - Credentials - Public API access.
	 */
	public String getGoogleApiKey() {
		return googleApiKey;
	}

	public void setGoogleApiKey(String value) {
		this.googleApiKey = value;
	}

	/**
	 * <a href="https://developers.google.com/console/help/generating-oauth2">OAuth 2.0 Client ID</a>
	 *
	 * <p>OAuth 2.0 allows users to share specific data with you (for example, contact lists) while keeping their usernames, passwords, and other information private.
	 *
	 * <p>Get this from <a href="https://console.developers.google.com/">Google Developers Console</a> - API Project - APIs & auth - Credentials - OAuth.
	 */
	public String getGoogleClientId() {
		return googleClientId;
	}

	public void setGoogleClientId(String value) {
		this.googleClientId = value;
	}

	/**
	 * <a href="https://developers.google.com/console/help/generating-oauth2">OAuth 2.0 Client Secret</a>
	 *
	 * <p>OAuth 2.0 allows users to share specific data with you (for example, contact lists) while keeping their usernames, passwords, and other information private.
	 *
	 * <p>Get this from <a href="https://console.developers.google.com/">Google Developers Console</a> - API Project - APIs & auth - Credentials - OAuth.
	 */
	public String getGoogleClientSecret() {
		return googleClientSecret;
	}

	public void setGoogleClientSecret(String value) {
		this.googleClientSecret = value;
	}

	/**
	 * Google site verification ID provided by <a href="https://www.google.com/webmasters/tools/home">Google Webmasters Toolkit</a>, e.g. {@code google187974e610426105}.
	 */
	public String getGoogleVerifyId() {
		return googleVerifyId;
	}

	public void setGoogleVerifyId(String value) {
		this.googleVerifyId = value;
	}

} // GoogleSysConfig
