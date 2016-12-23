/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Google Webmasters Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * SysConfig for <a href="https://developers.google.com/+/">Google+ Sign-in</a> and <a href="https://www.google.com/webmasters/tools/home">Google Webmasters Toolkit</a>.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.soluvas.web.site.GoogleSysConfig#getGoogleApiKey <em>Google Api Key</em>}</li>
 *   <li>{@link org.soluvas.web.site.GoogleSysConfig#getGoogleClientId <em>Google Client Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.GoogleSysConfig#getGoogleClientSecret <em>Google Client Secret</em>}</li>
 *   <li>{@link org.soluvas.web.site.GoogleSysConfig#getGoogleVerifyId <em>Google Verify Id</em>}</li>
 * </ul>
 *
 * @see org.soluvas.web.site.SitePackage#getGoogleSysConfig()
 * @model
 * @deprecated Use {@link GoogleSysConfig2}.
 */
@Deprecated
public interface GoogleSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Google Api Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <a href="https://developers.google.com/console/help/using-keys">Public API access</a>
	 * 
	 * <p>Use of this key does not require any user action or consent, does not grant access to any account information, and is not used for authorization.
	 * 
	 * <p>Get this from <a href="https://console.developers.google.com/">Google Developers Console</a> - API Project - APIs & auth - Credentials - Public API access.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Api Key</em>' attribute.
	 * @see #setGoogleApiKey(String)
	 * @see org.soluvas.web.site.SitePackage#getGoogleSysConfig_GoogleApiKey()
	 * @model
	 * @generated
	 */
	String getGoogleApiKey();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleSysConfig#getGoogleApiKey <em>Google Api Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Api Key</em>' attribute.
	 * @see #getGoogleApiKey()
	 * @generated
	 */
	void setGoogleApiKey(String value);

	/**
	 * Returns the value of the '<em><b>Google Client Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <a href="https://developers.google.com/console/help/generating-oauth2">OAuth 2.0 Client ID</a>
	 * 
	 * <p>OAuth 2.0 allows users to share specific data with you (for example, contact lists) while keeping their usernames, passwords, and other information private.
	 * 
	 * <p>Get this from <a href="https://console.developers.google.com/">Google Developers Console</a> - API Project - APIs & auth - Credentials - OAuth.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Client Id</em>' attribute.
	 * @see #setGoogleClientId(String)
	 * @see org.soluvas.web.site.SitePackage#getGoogleSysConfig_GoogleClientId()
	 * @model
	 * @generated
	 */
	String getGoogleClientId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleSysConfig#getGoogleClientId <em>Google Client Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Client Id</em>' attribute.
	 * @see #getGoogleClientId()
	 * @generated
	 */
	void setGoogleClientId(String value);

	/**
	 * Returns the value of the '<em><b>Google Client Secret</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <a href="https://developers.google.com/console/help/generating-oauth2">OAuth 2.0 Client Secret</a>
	 * 
	 * <p>OAuth 2.0 allows users to share specific data with you (for example, contact lists) while keeping their usernames, passwords, and other information private.
	 * 
	 * <p>Get this from <a href="https://console.developers.google.com/">Google Developers Console</a> - API Project - APIs & auth - Credentials - OAuth.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Client Secret</em>' attribute.
	 * @see #setGoogleClientSecret(String)
	 * @see org.soluvas.web.site.SitePackage#getGoogleSysConfig_GoogleClientSecret()
	 * @model
	 * @generated
	 */
	String getGoogleClientSecret();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleSysConfig#getGoogleClientSecret <em>Google Client Secret</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Client Secret</em>' attribute.
	 * @see #getGoogleClientSecret()
	 * @generated
	 */
	void setGoogleClientSecret(String value);

	/**
	 * Returns the value of the '<em><b>Google Verify Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Google site verification ID provided by <a href="https://www.google.com/webmasters/tools/home">Google Webmasters Toolkit</a>, e.g. {@code google187974e610426105}.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Verify Id</em>' attribute.
	 * @see #setGoogleVerifyId(String)
	 * @see org.soluvas.web.site.SitePackage#getGoogleSysConfig_GoogleVerifyId()
	 * @model
	 * @generated
	 */
	String getGoogleVerifyId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleSysConfig#getGoogleVerifyId <em>Google Verify Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Verify Id</em>' attribute.
	 * @see #getGoogleVerifyId()
	 * @generated
	 */
	void setGoogleVerifyId(String value);

} // GoogleSysConfig
