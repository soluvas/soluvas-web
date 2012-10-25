/**
 */
package org.soluvas.web.site.webaddress.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.web.site.webaddress.WebAddress;
import org.soluvas.web.site.webaddress.WebaddressFactory;
import org.soluvas.web.site.webaddress.WebaddressPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WebaddressPackageImpl extends EPackageImpl implements WebaddressPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass webAddressEClass = null;

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
	 * @see org.soluvas.web.site.webaddress.WebaddressPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WebaddressPackageImpl() {
		super(eNS_URI, WebaddressFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link WebaddressPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WebaddressPackage init() {
		if (isInited) return (WebaddressPackage)EPackage.Registry.INSTANCE.getEPackage(WebaddressPackage.eNS_URI);

		// Obtain or create and register package
		WebaddressPackageImpl theWebaddressPackage = (WebaddressPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WebaddressPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WebaddressPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theWebaddressPackage.createPackageContents();

		// Initialize created meta-data
		theWebaddressPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWebaddressPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WebaddressPackage.eNS_URI, theWebaddressPackage);
		return theWebaddressPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWebAddress() {
		return webAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_BaseUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_BasePath() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_ApiPath() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_ImagesUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_CssUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_JsUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_SecureBaseUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_SecureImagesUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_SecureCssUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWebAddress_SecureJsUri() {
		return (EAttribute)webAddressEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WebaddressFactory getWebaddressFactory() {
		return (WebaddressFactory)getEFactoryInstance();
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
		webAddressEClass = createEClass(WEB_ADDRESS);
		createEAttribute(webAddressEClass, WEB_ADDRESS__BASE_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__BASE_PATH);
		createEAttribute(webAddressEClass, WEB_ADDRESS__API_PATH);
		createEAttribute(webAddressEClass, WEB_ADDRESS__IMAGES_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__CSS_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__JS_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SECURE_BASE_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SECURE_IMAGES_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SECURE_CSS_URI);
		createEAttribute(webAddressEClass, WEB_ADDRESS__SECURE_JS_URI);
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
		initEClass(webAddressEClass, WebAddress.class, "WebAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWebAddress_BaseUri(), ecorePackage.getEString(), "baseUri", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_BasePath(), ecorePackage.getEString(), "basePath", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_ApiPath(), ecorePackage.getEString(), "apiPath", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_ImagesUri(), ecorePackage.getEString(), "imagesUri", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_CssUri(), ecorePackage.getEString(), "cssUri", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_JsUri(), ecorePackage.getEString(), "jsUri", null, 1, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SecureBaseUri(), ecorePackage.getEString(), "secureBaseUri", null, 0, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SecureImagesUri(), ecorePackage.getEString(), "secureImagesUri", null, 0, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SecureCssUri(), ecorePackage.getEString(), "secureCssUri", null, 0, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWebAddress_SecureJsUri(), ecorePackage.getEString(), "secureJsUri", null, 0, 1, WebAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";		
		addAnnotation
		  (webAddressEClass, 
		   source, 
		   new String[] {
			 "documentation", "Tenant-wide website URI configuration."
		   });		
		addAnnotation
		  (getWebAddress_BaseUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI of the website. Used by email notifications, external servers, etc."
		   });		
		addAnnotation
		  (getWebAddress_BasePath(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute path to website, e.g. /"
		   });		
		addAnnotation
		  (getWebAddress_ApiPath(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute path to API, e.g. /api/\n"
		   });		
		addAnnotation
		  (getWebAddress_ImagesUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to image files, e.g. http://images.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_CssUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to CSS files, e.g. http://css.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_JsUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to JavaScript files, e.g. http://js.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_SecureBaseUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to website, e.g. https://www.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_SecureImagesUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to secure image files, e.g. https://images.berbatik.com/"
		   });		
		addAnnotation
		  (getWebAddress_SecureCssUri(), 
		   source, 
		   new String[] {
			 "documentation", "Absolute URI to secure CSS files, e.g. https://css.berbatik.com/"
		   });
	}

} //WebaddressPackageImpl
