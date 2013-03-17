/**
 */
package org.soluvas.web.olark.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.web.olark.OlarkFactory;
import org.soluvas.web.olark.OlarkManager;
import org.soluvas.web.olark.OlarkPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OlarkPackageImpl extends EPackageImpl implements OlarkPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass olarkManagerEClass = null;

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
	 * @see org.soluvas.web.olark.OlarkPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OlarkPackageImpl() {
		super(eNS_URI, OlarkFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OlarkPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OlarkPackage init() {
		if (isInited) return (OlarkPackage)EPackage.Registry.INSTANCE.getEPackage(OlarkPackage.eNS_URI);

		// Obtain or create and register package
		OlarkPackageImpl theOlarkPackage = (OlarkPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OlarkPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OlarkPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theOlarkPackage.createPackageContents();

		// Initialize created meta-data
		theOlarkPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOlarkPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OlarkPackage.eNS_URI, theOlarkPackage);
		return theOlarkPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOlarkManager() {
		return olarkManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOlarkManager_SiteId() {
		return (EAttribute)olarkManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOlarkManager_Enabled() {
		return (EAttribute)olarkManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OlarkFactory getOlarkFactory() {
		return (OlarkFactory)getEFactoryInstance();
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
		olarkManagerEClass = createEClass(OLARK_MANAGER);
		createEAttribute(olarkManagerEClass, OLARK_MANAGER__SITE_ID);
		createEAttribute(olarkManagerEClass, OLARK_MANAGER__ENABLED);
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
		initEClass(olarkManagerEClass, OlarkManager.class, "OlarkManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOlarkManager_SiteId(), ecorePackage.getEString(), "siteId", "", 1, 1, OlarkManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOlarkManager_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 1, 1, OlarkManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OlarkPackageImpl
