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
 *   <li>{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#isGoogleAnalyticsDisplayFeatures <em>Google Analytics Display Features</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.site.SitePackage#getGoogleAnalyticsSysConfig()
 * @model
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

	/**
	 * Returns the value of the '<em><b>Google Analytics Display Features</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <a href="https://support.google.com/analytics/answer/2700409">Google Analytics Advertising Features</a> allow you to enable features in Analytics that aren't available through standard implementations. Advertising Features include:
	 * 
	 * <ol>
	 * <li>Remarketing with Google Analytics</li>
	 * <li>Google Display Network Impression Reporting</li>
	 * <li>DoubleClick Platform integrations</li>
	 * <li>Google Analytics Demographics and Interest Reporting</li>
	 * </ol>
	 * 
	 * <p>By enabling these advertising features, you enable Google Analytics to collect data about your traffic via Google advertising cookies and anonymous identifiers, in addition to data collected through a standard Google Analytics implementation. Regardless of how you send data to Google Analytics (for example, via the Google Analytics tracking code, Google Analytics SDK, or the Measurement Protocol), if you use Google Analytics Advertising Features, you must adhere to this policy.
	 * 
	 * <p>You will not facilitate the merging of personally-identifiable information with non-personally identifiable information collected through any Google advertising product or feature unless you have robust notice of, and the user's prior affirmative (i.e., opt-in) consent to, that merger.
	 * 
	 * <p>If you've enabled any Google Analytics Advertising Features, you are required to notify your visitors by disclosing the following information in your privacy policy:
	 * 
	 * <ol>
	 * <li>The Google Analytics Advertising Features you've implemented.</li>
	 * <li>How you and third-party vendors use first-party cookies (such as the Google Analytics cookie) or other first-party identifiers, and third-party cookies (such as the DoubleClick cookie) or other third-party identifiers together.</li>
	 * <li>How visitors can opt-out of the Google Analytics Advertising Features you use, including through Ads Settings, Ad Settings for mobile apps, or any other available means (for example, the NAI's consumer opt-out).</li>
	 * </ol>
	 * 
	 * <p>We also encourage you to point users to Google Analytics' <a href="https://tools.google.com/dlpage/gaoptout/">currently available opt-outs</a> for the web.
	 * 
	 * <p>Because laws across countries and territories vary, and because Google Analytics can be used in many ways, Google is unable to provide the exact language you need to include in your privacy policy. Only you understand the unique aspects and special considerations of your business, and your privacy policy should account for this information that only you can provide.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Google Analytics Display Features</em>' attribute.
	 * @see #isSetGoogleAnalyticsDisplayFeatures()
	 * @see #unsetGoogleAnalyticsDisplayFeatures()
	 * @see #setGoogleAnalyticsDisplayFeatures(boolean)
	 * @see org.soluvas.web.site.SitePackage#getGoogleAnalyticsSysConfig_GoogleAnalyticsDisplayFeatures()
	 * @model unsettable="true"
	 * @generated
	 */
	boolean isGoogleAnalyticsDisplayFeatures();

	/**
	 * Sets the value of the '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#isGoogleAnalyticsDisplayFeatures <em>Google Analytics Display Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Google Analytics Display Features</em>' attribute.
	 * @see #isSetGoogleAnalyticsDisplayFeatures()
	 * @see #unsetGoogleAnalyticsDisplayFeatures()
	 * @see #isGoogleAnalyticsDisplayFeatures()
	 * @generated
	 */
	void setGoogleAnalyticsDisplayFeatures(boolean value);

	/**
	 * Unsets the value of the '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#isGoogleAnalyticsDisplayFeatures <em>Google Analytics Display Features</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGoogleAnalyticsDisplayFeatures()
	 * @see #isGoogleAnalyticsDisplayFeatures()
	 * @see #setGoogleAnalyticsDisplayFeatures(boolean)
	 * @generated
	 */
	void unsetGoogleAnalyticsDisplayFeatures();

	/**
	 * Returns whether the value of the '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#isGoogleAnalyticsDisplayFeatures <em>Google Analytics Display Features</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Google Analytics Display Features</em>' attribute is set.
	 * @see #unsetGoogleAnalyticsDisplayFeatures()
	 * @see #isGoogleAnalyticsDisplayFeatures()
	 * @see #setGoogleAnalyticsDisplayFeatures(boolean)
	 * @generated
	 */
	boolean isSetGoogleAnalyticsDisplayFeatures();

} // GoogleAnalyticsSysConfig
