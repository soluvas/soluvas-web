/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Google Analytics Sys Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsEnabled <em>Google Analytics Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsTrackingId <em>Google Analytics Tracking Id</em>}</li>
 *   <li>{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsCookieDomain <em>Google Analytics Cookie Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getGoogleAnalyticsSysConfig()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface GoogleAnalyticsSysConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Google Analytics Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Whether Google Analytics is enabled.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Analytics Enabled</em>' attribute.
	 * @see #setGoogleAnalyticsEnabled(Boolean)
	 * @see org.soluvas.web.site.SitePackage#getGoogleAnalyticsSysConfig_GoogleAnalyticsEnabled()
	 * @model default="false"
	 * @generated
	 */
	Boolean getGoogleAnalyticsEnabled();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsEnabled <em>Google Analytics Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Analytics Enabled</em>' attribute.
	 * @see #getGoogleAnalyticsEnabled()
	 * @generated
	 */
	void setGoogleAnalyticsEnabled(Boolean value);

	/**
	 * Returns the value of the '<em><b>Google Analytics Tracking Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Google Analytics Tracking ID, which is mandatory if enabled.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Analytics Tracking Id</em>' attribute.
	 * @see #setGoogleAnalyticsTrackingId(String)
	 * @see org.soluvas.web.site.SitePackage#getGoogleAnalyticsSysConfig_GoogleAnalyticsTrackingId()
	 * @model
	 * @generated
	 */
	String getGoogleAnalyticsTrackingId();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsTrackingId <em>Google Analytics Tracking Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Analytics Tracking Id</em>' attribute.
	 * @see #getGoogleAnalyticsTrackingId()
	 * @generated
	 */
	void setGoogleAnalyticsTrackingId(String value);

	/**
	 * Returns the value of the '<em><b>Google Analytics Cookie Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Cookie domain for Google Analytics, if different than the default settings (usually the "www" subdomain).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Analytics Cookie Domain</em>' attribute.
	 * @see #setGoogleAnalyticsCookieDomain(String)
	 * @see org.soluvas.web.site.SitePackage#getGoogleAnalyticsSysConfig_GoogleAnalyticsCookieDomain()
	 * @model
	 * @generated
	 */
	String getGoogleAnalyticsCookieDomain();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsCookieDomain <em>Google Analytics Cookie Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Analytics Cookie Domain</em>' attribute.
	 * @see #getGoogleAnalyticsCookieDomain()
	 * @generated
	 */
	void setGoogleAnalyticsCookieDomain(String value);

} // GoogleAnalyticsSysConfig
