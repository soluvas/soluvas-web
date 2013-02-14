/**
 */
package org.soluvas.web.googleanalytics.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.web.googleanalytics.GoogleAnalyticsManager;
import org.soluvas.web.googleanalytics.GoogleanalyticsFactory;
import org.soluvas.web.googleanalytics.GoogleanalyticsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GoogleanalyticsPackageImpl extends EPackageImpl implements GoogleanalyticsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass googleAnalyticsManagerEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.soluvas.web.googleanalytics.GoogleanalyticsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GoogleanalyticsPackageImpl() {
		super(eNS_URI, GoogleanalyticsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GoogleanalyticsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GoogleanalyticsPackage init() {
		if (isInited) return (GoogleanalyticsPackage)EPackage.Registry.INSTANCE.getEPackage(GoogleanalyticsPackage.eNS_URI);

		// Obtain or create and register package
		GoogleanalyticsPackageImpl theGoogleanalyticsPackage = (GoogleanalyticsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GoogleanalyticsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GoogleanalyticsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGoogleanalyticsPackage.createPackageContents();

		// Initialize created meta-data
		theGoogleanalyticsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGoogleanalyticsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GoogleanalyticsPackage.eNS_URI, theGoogleanalyticsPackage);
		return theGoogleanalyticsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoogleAnalyticsManager() {
		return googleAnalyticsManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoogleAnalyticsManager_TrackingId() {
		return (EAttribute)googleAnalyticsManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoogleanalyticsFactory getGoogleanalyticsFactory() {
		return (GoogleanalyticsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		googleAnalyticsManagerEClass = createEClass(GOOGLE_ANALYTICS_MANAGER);
		createEAttribute(googleAnalyticsManagerEClass, GOOGLE_ANALYTICS_MANAGER__TRACKING_ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(googleAnalyticsManagerEClass, GoogleAnalyticsManager.class, "GoogleAnalyticsManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoogleAnalyticsManager_TrackingId(), ecorePackage.getEString(), "trackingId", null, 1, 1, GoogleAnalyticsManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //GoogleanalyticsPackageImpl
