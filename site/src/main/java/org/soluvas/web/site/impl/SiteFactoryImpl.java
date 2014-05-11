/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.soluvas.web.olark.LiveChatProvider;
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
			SiteFactory theSiteFactory = (SiteFactory)EPackage.Registry.INSTANCE.getEFactory(SitePackage.eNS_URI);
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
			case SitePackage.SECTION: return createSection();
			case SitePackage.SITE_CATALOG: return createSiteCatalog();
			case SitePackage.SECTION_COLLECTION: return createSectionCollection();
			case SitePackage.GENERIC_PAGE: return createGenericPage();
			case SitePackage.RAW_ENTITY_TABLE_PAGE: return createRawEntityTablePage();
			case SitePackage.ENTITY_TABLE_PAGE: return createEntityTablePage();
			case SitePackage.ENTITY_EDIT_PAGE: return createEntityEditPage();
			case SitePackage.RAW_ENTITY_EDIT_PAGE: return createRawEntityEditPage();
			case SitePackage.RAW_ENTITY_NEW_PAGE: return createRawEntityNewPage();
			case SitePackage.ENTITY_NEW_PAGE: return createEntityNewPage();
			case SitePackage.CONTENT_PAGE: return createContentPage();
			case SitePackage.DASHBOARD_PAGE: return createDashboardPage();
			case SitePackage.PAGE_PARAM: return createPageParam();
			case SitePackage.LOGIN_PAGE: return createLoginPage();
			case SitePackage.REGISTER_PAGE: return createRegisterPage();
			case SitePackage.RESET_PASSWORD_PAGE: return createResetPasswordPage();
			case SitePackage.PERMALINK_CATALOG: return createPermalinkCatalog();
			case SitePackage.PERMALINK: return createPermalink();
			case SitePackage.PERMALINK_MANAGER: return createPermalinkManager();
			case SitePackage.REQUIRE_MANAGER: return createRequireManager();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SitePackage.JAVA_SCRIPT_MODE:
				return createJavaScriptModeFromString(eDataType, initialValue);
			case SitePackage.LIVE_CHAT_PROVIDER:
				return createLiveChatProviderFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SitePackage.JAVA_SCRIPT_MODE:
				return convertJavaScriptModeToString(eDataType, instanceValue);
			case SitePackage.LIVE_CHAT_PROVIDER:
				return convertLiveChatProviderToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public PermalinkCatalog createPermalinkCatalog() {
		PermalinkCatalogImpl permalinkCatalog = new PermalinkCatalogImpl();
		return permalinkCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Permalink createPermalink() {
		PermalinkImpl permalink = new PermalinkImpl();
		return permalink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PermalinkManager createPermalinkManager() {
		PermalinkManagerImpl permalinkManager = new PermalinkManagerImpl();
		return permalinkManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequireManager createRequireManager() {
		RequireManagerImpl requireManager = new RequireManagerImpl();
		return requireManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaScriptMode createJavaScriptModeFromString(EDataType eDataType, String initialValue) {
		JavaScriptMode result = JavaScriptMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaScriptModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveChatProvider createLiveChatProviderFromString(EDataType eDataType, String initialValue) {
		return (LiveChatProvider)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLiveChatProviderToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
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
