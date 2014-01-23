/**
 */
package org.soluvas.web.googleanalytics.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.soluvas.web.googleanalytics.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GoogleanalyticsFactoryImpl extends EFactoryImpl implements GoogleanalyticsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GoogleanalyticsFactory init() {
		try {
			GoogleanalyticsFactory theGoogleanalyticsFactory = (GoogleanalyticsFactory)EPackage.Registry.INSTANCE.getEFactory(GoogleanalyticsPackage.eNS_URI);
			if (theGoogleanalyticsFactory != null) {
				return theGoogleanalyticsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GoogleanalyticsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoogleanalyticsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GoogleanalyticsPackage.GOOGLE_ANALYTICS_MANAGER: return createGoogleAnalyticsManager();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoogleAnalyticsManager createGoogleAnalyticsManager() {
		GoogleAnalyticsManagerImpl googleAnalyticsManager = new GoogleAnalyticsManagerImpl();
		return googleAnalyticsManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoogleanalyticsPackage getGoogleanalyticsPackage() {
		return (GoogleanalyticsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GoogleanalyticsPackage getPackage() {
		return GoogleanalyticsPackage.eINSTANCE;
	}

} //GoogleanalyticsFactoryImpl
