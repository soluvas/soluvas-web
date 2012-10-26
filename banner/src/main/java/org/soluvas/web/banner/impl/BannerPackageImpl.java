/**
 */
package org.soluvas.web.banner.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.soluvas.web.banner.Banner;
import org.soluvas.web.banner.BannerCatalog;
import org.soluvas.web.banner.BannerCollection;
import org.soluvas.web.banner.BannerFactory;
import org.soluvas.web.banner.BannerPackage;
import org.soluvas.web.banner.ImageBase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BannerPackageImpl extends EPackageImpl implements BannerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bannerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bannerCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bannerCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum imageBaseEEnum = null;

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
	 * @see org.soluvas.web.banner.BannerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BannerPackageImpl() {
		super(eNS_URI, BannerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BannerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BannerPackage init() {
		if (isInited) return (BannerPackage)EPackage.Registry.INSTANCE.getEPackage(BannerPackage.eNS_URI);

		// Obtain or create and register package
		BannerPackageImpl theBannerPackage = (BannerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BannerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BannerPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBannerPackage.createPackageContents();

		// Initialize created meta-data
		theBannerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBannerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BannerPackage.eNS_URI, theBannerPackage);
		return theBannerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBanner() {
		return bannerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBanner_ImageUri() {
		return (EAttribute)bannerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBanner_Title() {
		return (EAttribute)bannerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBanner_LinkUri() {
		return (EAttribute)bannerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBanner_Width() {
		return (EAttribute)bannerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBanner_Height() {
		return (EAttribute)bannerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBanner_ImageBase() {
		return (EAttribute)bannerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBannerCatalog() {
		return bannerCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBannerCollection() {
		return bannerCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBannerCollection_Banners() {
		return (EReference)bannerCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImageBase() {
		return imageBaseEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BannerFactory getBannerFactory() {
		return (BannerFactory)getEFactoryInstance();
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
		bannerEClass = createEClass(BANNER);
		createEAttribute(bannerEClass, BANNER__IMAGE_URI);
		createEAttribute(bannerEClass, BANNER__TITLE);
		createEAttribute(bannerEClass, BANNER__LINK_URI);
		createEAttribute(bannerEClass, BANNER__WIDTH);
		createEAttribute(bannerEClass, BANNER__HEIGHT);
		createEAttribute(bannerEClass, BANNER__IMAGE_BASE);

		bannerCatalogEClass = createEClass(BANNER_CATALOG);

		bannerCollectionEClass = createEClass(BANNER_COLLECTION);
		createEReference(bannerCollectionEClass, BANNER_COLLECTION__BANNERS);

		// Create enums
		imageBaseEEnum = createEEnum(IMAGE_BASE);
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
		bannerCatalogEClass.getESuperTypes().add(this.getBannerCollection());

		// Initialize classes and features; add operations and parameters
		initEClass(bannerEClass, Banner.class, "Banner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBanner_ImageUri(), ecorePackage.getEString(), "imageUri", null, 1, 1, Banner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBanner_Title(), ecorePackage.getEString(), "title", null, 0, 1, Banner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBanner_LinkUri(), ecorePackage.getEString(), "linkUri", null, 0, 1, Banner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBanner_Width(), ecorePackage.getEIntegerObject(), "width", null, 0, 1, Banner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBanner_Height(), ecorePackage.getEIntegerObject(), "height", null, 0, 1, Banner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBanner_ImageBase(), this.getImageBase(), "imageBase", "ABSOLUTE", 0, 1, Banner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bannerCatalogEClass, BannerCatalog.class, "BannerCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bannerCollectionEClass, BannerCollection.class, "BannerCollection", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBannerCollection_Banners(), this.getBanner(), null, "banners", null, 0, -1, BannerCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(imageBaseEEnum, ImageBase.class, "ImageBase");
		addEEnumLiteral(imageBaseEEnum, ImageBase.ABSOLUTE);
		addEEnumLiteral(imageBaseEEnum, ImageBase.IMAGES);

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
		  (getBanner_ImageBase(), 
		   source, 
		   new String[] {
			 "documentation", "Base of the provided imageUri."
		   });		
		addAnnotation
		  (imageBaseEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Provided Image URI is an absolute URI."
		   });		
		addAnnotation
		  (imageBaseEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Provided Image URI is an relative path to site\'s Images URI."
		   });
	}

} //BannerPackageImpl
