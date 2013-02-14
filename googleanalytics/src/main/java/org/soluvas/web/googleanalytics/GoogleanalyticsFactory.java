/**
 */
package org.soluvas.web.googleanalytics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.soluvas.web.googleanalytics.GoogleanalyticsPackage
 * @generated
 */
public interface GoogleanalyticsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GoogleanalyticsFactory eINSTANCE = org.soluvas.web.googleanalytics.impl.GoogleanalyticsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Google Analytics Manager</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Google Analytics Manager</em>'.
	 * @generated
	 */
	GoogleAnalyticsManager createGoogleAnalyticsManager();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GoogleanalyticsPackage getGoogleanalyticsPackage();

} //GoogleanalyticsFactory
