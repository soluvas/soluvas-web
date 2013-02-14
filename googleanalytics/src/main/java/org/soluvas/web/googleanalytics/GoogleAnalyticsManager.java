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

} // GoogleAnalyticsManager
