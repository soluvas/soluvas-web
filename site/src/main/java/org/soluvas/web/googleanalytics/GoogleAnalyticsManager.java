/**
 */
package org.soluvas.web.googleanalytics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Google Analytics Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.soluvas.web.googleanalytics.GoogleAnalyticsManager#getTrackingId <em>Tracking Id</em>}</li>
 *   <li>{@link org.soluvas.web.googleanalytics.GoogleAnalyticsManager#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.soluvas.web.googleanalytics.GoogleAnalyticsManager#getCookieDomain <em>Cookie Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.soluvas.web.googleanalytics.GoogleanalyticsPackage#getGoogleAnalyticsManager()
 * @model
 * @generated
 */
public interface GoogleAnalyticsManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Tracking Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tracking Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tracking Id</em>' attribute.
	 * @see org.soluvas.web.googleanalytics.GoogleanalyticsPackage#getGoogleAnalyticsManager_TrackingId()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	String getTrackingId();

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see org.soluvas.web.googleanalytics.GoogleanalyticsPackage#getGoogleAnalyticsManager_Enabled()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Returns the value of the '<em><b>Cookie Domain</b></em>' attribute.
	 * The default value is <code>"auto"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cookie Domain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cookie Domain</em>' attribute.
	 * @see #setCookieDomain(String)
	 * @see org.soluvas.web.googleanalytics.GoogleanalyticsPackage#getGoogleAnalyticsManager_CookieDomain()
	 * @model default="auto"
	 * @generated
	 */
	String getCookieDomain();

	/**
	 * Sets the value of the '{@link org.soluvas.web.googleanalytics.GoogleAnalyticsManager#getCookieDomain <em>Cookie Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cookie Domain</em>' attribute.
	 * @see #getCookieDomain()
	 * @generated
	 */
	void setCookieDomain(String value);

} // GoogleAnalyticsManager
