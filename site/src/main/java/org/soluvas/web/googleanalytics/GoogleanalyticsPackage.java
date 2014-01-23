/**
 */
package org.soluvas.web.googleanalytics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.soluvas.web.googleanalytics.GoogleanalyticsFactory
 * @model kind="package"
 * @generated
 */
public interface GoogleanalyticsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "googleanalytics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/web.googleanalytics/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "googleanalytics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GoogleanalyticsPackage eINSTANCE = org.soluvas.web.googleanalytics.impl.GoogleanalyticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.web.googleanalytics.impl.GoogleAnalyticsManagerImpl <em>Google Analytics Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.googleanalytics.impl.GoogleAnalyticsManagerImpl
	 * @see org.soluvas.web.googleanalytics.impl.GoogleanalyticsPackageImpl#getGoogleAnalyticsManager()
	 * @generated
	 */
	int GOOGLE_ANALYTICS_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Tracking Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOOGLE_ANALYTICS_MANAGER__TRACKING_ID = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOOGLE_ANALYTICS_MANAGER__ENABLED = 1;

	/**
	 * The feature id for the '<em><b>Cookie Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOOGLE_ANALYTICS_MANAGER__COOKIE_DOMAIN = 2;

	/**
	 * The number of structural features of the '<em>Google Analytics Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOOGLE_ANALYTICS_MANAGER_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.soluvas.web.googleanalytics.GoogleAnalyticsManager <em>Google Analytics Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Google Analytics Manager</em>'.
	 * @see org.soluvas.web.googleanalytics.GoogleAnalyticsManager
	 * @generated
	 */
	EClass getGoogleAnalyticsManager();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.googleanalytics.GoogleAnalyticsManager#getTrackingId <em>Tracking Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tracking Id</em>'.
	 * @see org.soluvas.web.googleanalytics.GoogleAnalyticsManager#getTrackingId()
	 * @see #getGoogleAnalyticsManager()
	 * @generated
	 */
	EAttribute getGoogleAnalyticsManager_TrackingId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.googleanalytics.GoogleAnalyticsManager#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.soluvas.web.googleanalytics.GoogleAnalyticsManager#isEnabled()
	 * @see #getGoogleAnalyticsManager()
	 * @generated
	 */
	EAttribute getGoogleAnalyticsManager_Enabled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.googleanalytics.GoogleAnalyticsManager#getCookieDomain <em>Cookie Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cookie Domain</em>'.
	 * @see org.soluvas.web.googleanalytics.GoogleAnalyticsManager#getCookieDomain()
	 * @see #getGoogleAnalyticsManager()
	 * @generated
	 */
	EAttribute getGoogleAnalyticsManager_CookieDomain();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GoogleanalyticsFactory getGoogleanalyticsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.web.googleanalytics.impl.GoogleAnalyticsManagerImpl <em>Google Analytics Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.googleanalytics.impl.GoogleAnalyticsManagerImpl
		 * @see org.soluvas.web.googleanalytics.impl.GoogleanalyticsPackageImpl#getGoogleAnalyticsManager()
		 * @generated
		 */
		EClass GOOGLE_ANALYTICS_MANAGER = eINSTANCE.getGoogleAnalyticsManager();

		/**
		 * The meta object literal for the '<em><b>Tracking Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOOGLE_ANALYTICS_MANAGER__TRACKING_ID = eINSTANCE.getGoogleAnalyticsManager_TrackingId();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOOGLE_ANALYTICS_MANAGER__ENABLED = eINSTANCE.getGoogleAnalyticsManager_Enabled();

		/**
		 * The meta object literal for the '<em><b>Cookie Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOOGLE_ANALYTICS_MANAGER__COOKIE_DOMAIN = eINSTANCE.getGoogleAnalyticsManager_CookieDomain();

	}

} //GoogleanalyticsPackage
