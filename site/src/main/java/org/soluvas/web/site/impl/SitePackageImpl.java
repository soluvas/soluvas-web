/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.web.site.ContentPage;
import org.soluvas.web.site.DashboardPage;
import org.soluvas.web.site.EntityEditPage;
import org.soluvas.web.site.EntityNewPage;
import org.soluvas.web.site.EntityPage;
import org.soluvas.web.site.EntityTablePage;
import org.soluvas.web.site.GenericPage;
import org.soluvas.web.site.LoginPage;
import org.soluvas.web.site.Page;
import org.soluvas.web.site.PageParam;
import org.soluvas.web.site.RawEntityEditPage;
import org.soluvas.web.site.RawEntityNewPage;
import org.soluvas.web.site.RawEntityTablePage;
import org.soluvas.web.site.RegisterPage;
import org.soluvas.web.site.ResetPasswordPage;
import org.soluvas.web.site.Section;
import org.soluvas.web.site.SectionCollection;
import org.soluvas.web.site.SiteCatalog;
import org.soluvas.web.site.SiteFactory;
import org.soluvas.web.site.SitePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SitePackageImpl extends EPackageImpl implements SitePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass siteCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sectionCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawEntityTablePageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityTablePageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEditPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawEntityEditPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawEntityNewPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityNewPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dashboardPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loginPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass registerPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resetPasswordPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityPageEClass = null;

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
	 * @see org.soluvas.web.site.SitePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SitePackageImpl() {
		super(eNS_URI, SiteFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SitePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SitePackage init() {
		if (isInited) return (SitePackage)EPackage.Registry.INSTANCE.getEPackage(SitePackage.eNS_URI);

		// Obtain or create and register package
		SitePackageImpl theSitePackage = (SitePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SitePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SitePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSitePackage.createPackageContents();

		// Initialize created meta-data
		theSitePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSitePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SitePackage.eNS_URI, theSitePackage);
		return theSitePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSection() {
		return sectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSection_Id() {
		return (EAttribute)sectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSection_Name() {
		return (EAttribute)sectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSection_Pages() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSiteCatalog() {
		return siteCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSectionCollection() {
		return sectionCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSectionCollection_Sections() {
		return (EReference)sectionCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPage() {
		return pageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPage_Name() {
		return (EAttribute)pageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPage_MountPoint() {
		return (EAttribute)pageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPage_Params() {
		return (EReference)pageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPage_Section() {
		return (EReference)pageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericPage() {
		return genericPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawEntityTablePage() {
		return rawEntityTablePageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityTablePage() {
		return entityTablePageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityEditPage() {
		return entityEditPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawEntityEditPage() {
		return rawEntityEditPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawEntityNewPage() {
		return rawEntityNewPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityNewPage() {
		return entityNewPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContentPage() {
		return contentPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDashboardPage() {
		return dashboardPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageParam() {
		return pageParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageParam_Name() {
		return (EAttribute)pageParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoginPage() {
		return loginPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoginPage_RegisterPage() {
		return (EReference)loginPageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoginPage_ResetPasswordPage() {
		return (EReference)loginPageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegisterPage() {
		return registerPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResetPasswordPage() {
		return resetPasswordPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityPage() {
		return entityPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityPage_EntityClass() {
		return (EAttribute)entityPageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SiteFactory getSiteFactory() {
		return (SiteFactory)getEFactoryInstance();
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
		sectionEClass = createEClass(SECTION);
		createEAttribute(sectionEClass, SECTION__ID);
		createEAttribute(sectionEClass, SECTION__NAME);
		createEReference(sectionEClass, SECTION__PAGES);

		siteCatalogEClass = createEClass(SITE_CATALOG);

		sectionCollectionEClass = createEClass(SECTION_COLLECTION);
		createEReference(sectionCollectionEClass, SECTION_COLLECTION__SECTIONS);

		pageEClass = createEClass(PAGE);
		createEAttribute(pageEClass, PAGE__NAME);
		createEAttribute(pageEClass, PAGE__MOUNT_POINT);
		createEReference(pageEClass, PAGE__PARAMS);
		createEReference(pageEClass, PAGE__SECTION);

		genericPageEClass = createEClass(GENERIC_PAGE);

		rawEntityTablePageEClass = createEClass(RAW_ENTITY_TABLE_PAGE);

		entityTablePageEClass = createEClass(ENTITY_TABLE_PAGE);

		entityEditPageEClass = createEClass(ENTITY_EDIT_PAGE);

		rawEntityEditPageEClass = createEClass(RAW_ENTITY_EDIT_PAGE);

		rawEntityNewPageEClass = createEClass(RAW_ENTITY_NEW_PAGE);

		entityNewPageEClass = createEClass(ENTITY_NEW_PAGE);

		contentPageEClass = createEClass(CONTENT_PAGE);

		dashboardPageEClass = createEClass(DASHBOARD_PAGE);

		pageParamEClass = createEClass(PAGE_PARAM);
		createEAttribute(pageParamEClass, PAGE_PARAM__NAME);

		loginPageEClass = createEClass(LOGIN_PAGE);
		createEReference(loginPageEClass, LOGIN_PAGE__REGISTER_PAGE);
		createEReference(loginPageEClass, LOGIN_PAGE__RESET_PASSWORD_PAGE);

		registerPageEClass = createEClass(REGISTER_PAGE);

		resetPasswordPageEClass = createEClass(RESET_PASSWORD_PAGE);

		entityPageEClass = createEClass(ENTITY_PAGE);
		createEAttribute(entityPageEClass, ENTITY_PAGE__ENTITY_CLASS);
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
		siteCatalogEClass.getESuperTypes().add(this.getSectionCollection());
		genericPageEClass.getESuperTypes().add(this.getPage());
		rawEntityTablePageEClass.getESuperTypes().add(this.getPage());
		rawEntityTablePageEClass.getESuperTypes().add(this.getEntityPage());
		entityTablePageEClass.getESuperTypes().add(this.getPage());
		entityTablePageEClass.getESuperTypes().add(this.getEntityPage());
		entityEditPageEClass.getESuperTypes().add(this.getPage());
		entityEditPageEClass.getESuperTypes().add(this.getEntityPage());
		rawEntityEditPageEClass.getESuperTypes().add(this.getPage());
		rawEntityEditPageEClass.getESuperTypes().add(this.getEntityPage());
		rawEntityNewPageEClass.getESuperTypes().add(this.getPage());
		rawEntityNewPageEClass.getESuperTypes().add(this.getEntityPage());
		entityNewPageEClass.getESuperTypes().add(this.getPage());
		entityNewPageEClass.getESuperTypes().add(this.getEntityPage());
		contentPageEClass.getESuperTypes().add(this.getPage());
		dashboardPageEClass.getESuperTypes().add(this.getPage());
		loginPageEClass.getESuperTypes().add(this.getPage());
		registerPageEClass.getESuperTypes().add(this.getPage());
		resetPasswordPageEClass.getESuperTypes().add(this.getPage());

		// Initialize classes and features; add operations and parameters
		initEClass(sectionEClass, Section.class, "Section", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSection_Id(), ecorePackage.getEString(), "id", null, 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSection_Name(), ecorePackage.getEString(), "name", null, 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSection_Pages(), this.getPage(), this.getPage_Section(), "pages", null, 0, -1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(siteCatalogEClass, SiteCatalog.class, "SiteCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sectionCollectionEClass, SectionCollection.class, "SectionCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSectionCollection_Sections(), this.getSection(), null, "sections", null, 0, -1, SectionCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageEClass, Page.class, "Page", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPage_Name(), ecorePackage.getEString(), "name", null, 1, 1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPage_MountPoint(), ecorePackage.getEString(), "mountPoint", null, 0, 1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPage_Params(), this.getPageParam(), null, "params", null, 0, -1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPage_Section(), this.getSection(), this.getSection_Pages(), "section", null, 0, 1, Page.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(pageEClass, ecorePackage.getEString(), "getClassSimpleName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(genericPageEClass, GenericPage.class, "GenericPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rawEntityTablePageEClass, RawEntityTablePage.class, "RawEntityTablePage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityTablePageEClass, EntityTablePage.class, "EntityTablePage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityEditPageEClass, EntityEditPage.class, "EntityEditPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rawEntityEditPageEClass, RawEntityEditPage.class, "RawEntityEditPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rawEntityNewPageEClass, RawEntityNewPage.class, "RawEntityNewPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityNewPageEClass, EntityNewPage.class, "EntityNewPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contentPageEClass, ContentPage.class, "ContentPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dashboardPageEClass, DashboardPage.class, "DashboardPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pageParamEClass, PageParam.class, "PageParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPageParam_Name(), ecorePackage.getEString(), "name", null, 0, 1, PageParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loginPageEClass, LoginPage.class, "LoginPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoginPage_RegisterPage(), this.getRegisterPage(), null, "registerPage", null, 0, 1, LoginPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoginPage_ResetPasswordPage(), this.getResetPasswordPage(), null, "resetPasswordPage", null, 0, 1, LoginPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(registerPageEClass, RegisterPage.class, "RegisterPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resetPasswordPageEClass, ResetPasswordPage.class, "ResetPasswordPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(entityPageEClass, EntityPage.class, "EntityPage", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntityPage_EntityClass(), ecorePackage.getEString(), "entityClass", null, 1, 1, EntityPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (sectionEClass, 
		   source, 
		   new String[] {
			 "documentation", "A large division of web application.\n\nFor example, Bippo Mall is divided into 4 sections: sys, mall, shop, and pub."
		   });		
		addAnnotation
		  (siteCatalogEClass, 
		   source, 
		   new String[] {
			 "documentation", "The site catalog is used to define all *logical* sections and pages in a site.\n\nIt is used in 2 ways:\n1. at generation time, to generate concrete page classes, Wicket HTML markup, and JS files.\n2. at runtime, to inspect *logical* sections and pages in the site.\n\nNote that information about actual concrete page classes etc. are not visible here, and if needed, then it should be described using another schema."
		   });		
		addAnnotation
		  (pageEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Returns the class simple name, which is simply the name + \"Page\" suffix."
		   });		
		addAnnotation
		  (getPage_Name(), 
		   source, 
		   new String[] {
			 "documentation", "The resulting simple name of the Wicket Page subclass, e.g. \"ProductSysTable\", without the \"Page\" suffix."
		   });		
		addAnnotation
		  (getPage_MountPoint(), 
		   source, 
		   new String[] {
			 "documentation", "Where the page is mounted, relative to application root, e.g. /product/sys, or a URI template with parameters: /product/sys/show/${productId}\n\nmountPoint is highly recommended for SEO and easy URI typing, but not mandatory."
		   });		
		addAnnotation
		  (genericPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "A page that that specifies the literal Wicket page class name"
		   });		
		addAnnotation
		  (rawEntityTablePageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Lists raw entities in a page using Backbone and jQuery DataTables.\n\nFor normal entities see EntityTablePage.\n\nEntities can be added, shown, and deleted.\n\nFeatures:\n* client-side paging support\n* client-side quick search\n* client-side table column sorting\n\nTODO: support push for dynamic add/remove and show status."
		   });		
		addAnnotation
		  (entityTablePageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Lists normal entities in a page using Backbone and jQuery DataTables.\n\nFor raw entities see RawEntity TablePage.\n\nSupported folders:\n1. Published (virtual; published only)\n2. All Items (virtual; except deleted)\n3. Drafts (virtual)\n4. Trash (virtual)\n\nActions on entities:\n1. add\n2. show\n3. delete\n4. undelete\n5. publish (draft->published)\n6. unpublish (published->draft; some entities may not support this)\n\nFeatures:\n* client-side paging support\n* client-side quick search\n* client-side table column sorting\n\nTODO: support push for dynamic add/remove and show status."
		   });		
		addAnnotation
		  (entityEditPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Edit page for normal entities"
		   });		
		addAnnotation
		  (rawEntityEditPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Edit page for raw entities"
		   });		
		addAnnotation
		  (rawEntityNewPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "New normal entity page"
		   });		
		addAnnotation
		  (entityNewPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "New raw entity page"
		   });		
		addAnnotation
		  (contentPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains static but editable HTML content."
		   });		
		addAnnotation
		  (dashboardPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "A page that can be customized by admin.\n\nTypically used for homepage.\n\nThe layout is a bit different than other pages because it has a header and a slider/carousel after the header.\nThe sidebar is below the header and the carousel."
		   });		
		addAnnotation
		  (getPageParam_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Parameter name for the page, e.g. \"productId\"."
		   });		
		addAnnotation
		  (loginPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Login page, that also serves as a SSO register page for Facebook, Twitter, Google, etc."
		   });		
		addAnnotation
		  (registerPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Register as user via email."
		   });		
		addAnnotation
		  (resetPasswordPageEClass, 
		   source, 
		   new String[] {
			 "documentation", "Used to reset password if user forgets the password."
		   });		
		addAnnotation
		  (getEntityPage_EntityClass(), 
		   source, 
		   new String[] {
			 "documentation", "Full name of the class that represents the entity.\n\nThis is required for:\n1. Getting the EntityRepository for the entity, scoped to the active tenant\n2. Getting the EntityDescriptor which provides metadata about the entity, scoped to the active tenant\n"
		   });
	}

} //SitePackageImpl
