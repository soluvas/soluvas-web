/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.soluvas.web.site.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SiteFactoryImpl extends EFactoryImpl implements SiteFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SiteFactory init() {
		try {
			SiteFactory theSiteFactory = (SiteFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/web.site/1.0"); 
			if (theSiteFactory != null) {
				return theSiteFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SiteFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SiteFactoryImpl() {
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
			case SitePackage.SECTION: return (EObject)createSection();
			case SitePackage.SITE_CATALOG: return (EObject)createSiteCatalog();
			case SitePackage.SECTION_COLLECTION: return (EObject)createSectionCollection();
			case SitePackage.GENERIC_PAGE: return (EObject)createGenericPage();
			case SitePackage.RAW_ENTITY_TABLE_PAGE: return (EObject)createRawEntityTablePage();
			case SitePackage.ENTITY_TABLE_PAGE: return (EObject)createEntityTablePage();
			case SitePackage.ENTITY_EDIT_PAGE: return (EObject)createEntityEditPage();
			case SitePackage.RAW_ENTITY_EDIT_PAGE: return (EObject)createRawEntityEditPage();
			case SitePackage.RAW_ENTITY_NEW_PAGE: return (EObject)createRawEntityNewPage();
			case SitePackage.ENTITY_NEW_PAGE: return (EObject)createEntityNewPage();
			case SitePackage.CONTENT_PAGE: return (EObject)createContentPage();
			case SitePackage.DASHBOARD_PAGE: return (EObject)createDashboardPage();
			case SitePackage.PAGE_PARAM: return (EObject)createPageParam();
			case SitePackage.LOGIN_PAGE: return (EObject)createLoginPage();
			case SitePackage.REGISTER_PAGE: return (EObject)createRegisterPage();
			case SitePackage.RESET_PASSWORD_PAGE: return (EObject)createResetPasswordPage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Section createSection() {
		SectionImpl section = new SectionImpl();
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SiteCatalog createSiteCatalog() {
		SiteCatalogImpl siteCatalog = new SiteCatalogImpl();
		return siteCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SectionCollection createSectionCollection() {
		SectionCollectionImpl sectionCollection = new SectionCollectionImpl();
		return sectionCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericPage createGenericPage() {
		GenericPageImpl genericPage = new GenericPageImpl();
		return genericPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawEntityTablePage createRawEntityTablePage() {
		RawEntityTablePageImpl rawEntityTablePage = new RawEntityTablePageImpl();
		return rawEntityTablePage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityTablePage createEntityTablePage() {
		EntityTablePageImpl entityTablePage = new EntityTablePageImpl();
		return entityTablePage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityEditPage createEntityEditPage() {
		EntityEditPageImpl entityEditPage = new EntityEditPageImpl();
		return entityEditPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawEntityEditPage createRawEntityEditPage() {
		RawEntityEditPageImpl rawEntityEditPage = new RawEntityEditPageImpl();
		return rawEntityEditPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawEntityNewPage createRawEntityNewPage() {
		RawEntityNewPageImpl rawEntityNewPage = new RawEntityNewPageImpl();
		return rawEntityNewPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntityNewPage createEntityNewPage() {
		EntityNewPageImpl entityNewPage = new EntityNewPageImpl();
		return entityNewPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContentPage createContentPage() {
		ContentPageImpl contentPage = new ContentPageImpl();
		return contentPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DashboardPage createDashboardPage() {
		DashboardPageImpl dashboardPage = new DashboardPageImpl();
		return dashboardPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageParam createPageParam() {
		PageParamImpl pageParam = new PageParamImpl();
		return pageParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoginPage createLoginPage() {
		LoginPageImpl loginPage = new LoginPageImpl();
		return loginPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegisterPage createRegisterPage() {
		RegisterPageImpl registerPage = new RegisterPageImpl();
		return registerPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResetPasswordPage createResetPasswordPage() {
		ResetPasswordPageImpl resetPasswordPage = new ResetPasswordPageImpl();
		return resetPasswordPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SitePackage getSitePackage() {
		return (SitePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SitePackage getPackage() {
		return SitePackage.eINSTANCE;
	}

} //SiteFactoryImpl
