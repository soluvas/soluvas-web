/**
 */
package org.soluvas.web.site.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.soluvas.commons.CommonsPackage;
import org.soluvas.web.olark.LiveChatProvider;
import org.soluvas.web.site.AlexaSysConfig;
import org.soluvas.web.site.BingSysConfig;
import org.soluvas.web.site.ContentPage;
import org.soluvas.web.site.DashboardPage;
import org.soluvas.web.site.EntityEditPage;
import org.soluvas.web.site.EntityNewPage;
import org.soluvas.web.site.EntityPage;
import org.soluvas.web.site.EntityTablePage;
import org.soluvas.web.site.GenericPage;
import org.soluvas.web.site.GoogleAnalyticsSysConfig;
import org.soluvas.web.site.GooglePlusSysConfig;
import org.soluvas.web.site.GoogleSysConfig;
import org.soluvas.web.site.Interaction;
import org.soluvas.web.site.JavaScriptMode;
import org.soluvas.web.site.LiveChatSysConfig;
import org.soluvas.web.site.LoginPage;
import org.soluvas.web.site.Page;
import org.soluvas.web.site.PageParam;
import org.soluvas.web.site.PerfectAudienceSysConfig;
import org.soluvas.web.site.Permalink;
import org.soluvas.web.site.PermalinkCatalog;
import org.soluvas.web.site.PermalinkManager;
import org.soluvas.web.site.RawEntityEditPage;
import org.soluvas.web.site.RawEntityNewPage;
import org.soluvas.web.site.RawEntityTablePage;
import org.soluvas.web.site.RegisterPage;
import org.soluvas.web.site.RequireManager;
import org.soluvas.web.site.ResetPasswordPage;
import org.soluvas.web.site.Section;
import org.soluvas.web.site.SectionCollection;
import org.soluvas.web.site.SiteCatalog;
import org.soluvas.web.site.SiteFactory;
import org.soluvas.web.site.SitePackage;
import org.soluvas.web.site.ThemePref;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permalinkCatalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permalinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass permalinkManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requireManagerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alexaSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveChatSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass googleAnalyticsSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass themePrefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass googleSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass googlePlusSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bingSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass perfectAudienceSysConfigEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum javaScriptModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum interactionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType liveChatProviderEDataType = null;

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

		// Initialize simple dependencies
		CommonsPackage.eINSTANCE.eClass();

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
	@Override
	public EClass getSection() {
		return sectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSection_Id() {
		return (EAttribute)sectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSection_Name() {
		return (EAttribute)sectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSection_Pages() {
		return (EReference)sectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSiteCatalog() {
		return siteCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSectionCollection() {
		return sectionCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSectionCollection_Sections() {
		return (EReference)sectionCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPage() {
		return pageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPage_Name() {
		return (EAttribute)pageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPage_MountPoint() {
		return (EAttribute)pageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPage_Params() {
		return (EReference)pageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPage_Section() {
		return (EReference)pageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGenericPage() {
		return genericPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRawEntityTablePage() {
		return rawEntityTablePageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntityTablePage() {
		return entityTablePageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntityEditPage() {
		return entityEditPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRawEntityEditPage() {
		return rawEntityEditPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRawEntityNewPage() {
		return rawEntityNewPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntityNewPage() {
		return entityNewPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContentPage() {
		return contentPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDashboardPage() {
		return dashboardPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPageParam() {
		return pageParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPageParam_Name() {
		return (EAttribute)pageParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLoginPage() {
		return loginPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoginPage_RegisterPage() {
		return (EReference)loginPageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoginPage_ResetPasswordPage() {
		return (EReference)loginPageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRegisterPage() {
		return registerPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResetPasswordPage() {
		return resetPasswordPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEntityPage() {
		return entityPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEntityPage_EntityClass() {
		return (EAttribute)entityPageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPermalinkCatalog() {
		return permalinkCatalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPermalinkCatalog_Permalinks() {
		return (EReference)permalinkCatalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPermalink() {
		return permalinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPermalink_Namespace() {
		return (EAttribute)permalinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPermalink_Template() {
		return (EAttribute)permalinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPermalinkManager() {
		return permalinkManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequireManager() {
		return requireManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequireManager_JavaScriptMode() {
		return (EAttribute)requireManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRequireManager_CacheBust() {
		return (EAttribute)requireManagerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAlexaSysConfig() {
		return alexaSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAlexaSysConfig_AlexaVerifyId() {
		return (EAttribute)alexaSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAlexaSysConfig_AlexaCertifyEnabled() {
		return (EAttribute)alexaSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAlexaSysConfig_AlexaCertifyAccount() {
		return (EAttribute)alexaSysConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAlexaSysConfig_AlexaCertifyDomain() {
		return (EAttribute)alexaSysConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAlexaSysConfig_AlexaCertifyJsCdn() {
		return (EAttribute)alexaSysConfigEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAlexaSysConfig_AlexaCertifyImageCdn() {
		return (EAttribute)alexaSysConfigEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiveChatSysConfig() {
		return liveChatSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiveChatSysConfig_LiveChatEnabled() {
		return (EAttribute)liveChatSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiveChatSysConfig_LiveChatProviderId() {
		return (EAttribute)liveChatSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiveChatSysConfig_LiveChatProvider() {
		return (EAttribute)liveChatSysConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLiveChatSysConfig_LiveChatSiteId() {
		return (EAttribute)liveChatSysConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGoogleAnalyticsSysConfig() {
		return googleAnalyticsSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoogleAnalyticsSysConfig_GoogleAnalyticsEnabled() {
		return (EAttribute)googleAnalyticsSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoogleAnalyticsSysConfig_GoogleAnalyticsTrackingId() {
		return (EAttribute)googleAnalyticsSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoogleAnalyticsSysConfig_GoogleAnalyticsCookieDomain() {
		return (EAttribute)googleAnalyticsSysConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoogleAnalyticsSysConfig_GoogleAnalyticsDisplayFeatures() {
		return (EAttribute)googleAnalyticsSysConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getThemePref() {
		return themePrefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_NavbarTextColor() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_OutlineColor() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_BackgroundColor() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_HighlightColor() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_TwitterLinkVisible() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_FacebookLinkVisible() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_YouTubeLinkVisible() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_FootnoteVisible() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getThemePref_NavbarColor() {
		return (EAttribute)themePrefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGoogleSysConfig() {
		return googleSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoogleSysConfig_GoogleApiKey() {
		return (EAttribute)googleSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoogleSysConfig_GoogleClientId() {
		return (EAttribute)googleSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoogleSysConfig_GoogleClientSecret() {
		return (EAttribute)googleSysConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGoogleSysConfig_GoogleVerifyId() {
		return (EAttribute)googleSysConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGooglePlusSysConfig() {
		return googlePlusSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGooglePlusSysConfig_GooglePlusId() {
		return (EAttribute)googlePlusSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGooglePlusSysConfig_GooglePlusKind() {
		return (EAttribute)googlePlusSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGooglePlusSysConfig_GooglePlusUrl() {
		return (EAttribute)googlePlusSysConfigEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGooglePlusSysConfig_GooglePlusDisplayName() {
		return (EAttribute)googlePlusSysConfigEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBingSysConfig() {
		return bingSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBingSysConfig_BingVerifyId() {
		return (EAttribute)bingSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPerfectAudienceSysConfig() {
		return perfectAudienceSysConfigEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPerfectAudienceSysConfig_PerfectAudienceId() {
		return (EAttribute)perfectAudienceSysConfigEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPerfectAudienceSysConfig_PerfectAudienceEnabled() {
		return (EAttribute)perfectAudienceSysConfigEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getJavaScriptMode() {
		return javaScriptModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getInteraction() {
		return interactionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getLiveChatProvider() {
		return liveChatProviderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

		permalinkCatalogEClass = createEClass(PERMALINK_CATALOG);
		createEReference(permalinkCatalogEClass, PERMALINK_CATALOG__PERMALINKS);

		permalinkEClass = createEClass(PERMALINK);
		createEAttribute(permalinkEClass, PERMALINK__NAMESPACE);
		createEAttribute(permalinkEClass, PERMALINK__TEMPLATE);

		permalinkManagerEClass = createEClass(PERMALINK_MANAGER);

		requireManagerEClass = createEClass(REQUIRE_MANAGER);
		createEAttribute(requireManagerEClass, REQUIRE_MANAGER__JAVA_SCRIPT_MODE);
		createEAttribute(requireManagerEClass, REQUIRE_MANAGER__CACHE_BUST);

		alexaSysConfigEClass = createEClass(ALEXA_SYS_CONFIG);
		createEAttribute(alexaSysConfigEClass, ALEXA_SYS_CONFIG__ALEXA_VERIFY_ID);
		createEAttribute(alexaSysConfigEClass, ALEXA_SYS_CONFIG__ALEXA_CERTIFY_ENABLED);
		createEAttribute(alexaSysConfigEClass, ALEXA_SYS_CONFIG__ALEXA_CERTIFY_ACCOUNT);
		createEAttribute(alexaSysConfigEClass, ALEXA_SYS_CONFIG__ALEXA_CERTIFY_DOMAIN);
		createEAttribute(alexaSysConfigEClass, ALEXA_SYS_CONFIG__ALEXA_CERTIFY_JS_CDN);
		createEAttribute(alexaSysConfigEClass, ALEXA_SYS_CONFIG__ALEXA_CERTIFY_IMAGE_CDN);

		liveChatSysConfigEClass = createEClass(LIVE_CHAT_SYS_CONFIG);
		createEAttribute(liveChatSysConfigEClass, LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_ENABLED);
		createEAttribute(liveChatSysConfigEClass, LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_PROVIDER_ID);
		createEAttribute(liveChatSysConfigEClass, LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_PROVIDER);
		createEAttribute(liveChatSysConfigEClass, LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_SITE_ID);

		googleAnalyticsSysConfigEClass = createEClass(GOOGLE_ANALYTICS_SYS_CONFIG);
		createEAttribute(googleAnalyticsSysConfigEClass, GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED);
		createEAttribute(googleAnalyticsSysConfigEClass, GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID);
		createEAttribute(googleAnalyticsSysConfigEClass, GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN);
		createEAttribute(googleAnalyticsSysConfigEClass, GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_DISPLAY_FEATURES);

		themePrefEClass = createEClass(THEME_PREF);
		createEAttribute(themePrefEClass, THEME_PREF__NAVBAR_COLOR);
		createEAttribute(themePrefEClass, THEME_PREF__NAVBAR_TEXT_COLOR);
		createEAttribute(themePrefEClass, THEME_PREF__OUTLINE_COLOR);
		createEAttribute(themePrefEClass, THEME_PREF__BACKGROUND_COLOR);
		createEAttribute(themePrefEClass, THEME_PREF__HIGHLIGHT_COLOR);
		createEAttribute(themePrefEClass, THEME_PREF__TWITTER_LINK_VISIBLE);
		createEAttribute(themePrefEClass, THEME_PREF__FACEBOOK_LINK_VISIBLE);
		createEAttribute(themePrefEClass, THEME_PREF__YOU_TUBE_LINK_VISIBLE);
		createEAttribute(themePrefEClass, THEME_PREF__FOOTNOTE_VISIBLE);

		googleSysConfigEClass = createEClass(GOOGLE_SYS_CONFIG);
		createEAttribute(googleSysConfigEClass, GOOGLE_SYS_CONFIG__GOOGLE_API_KEY);
		createEAttribute(googleSysConfigEClass, GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_ID);
		createEAttribute(googleSysConfigEClass, GOOGLE_SYS_CONFIG__GOOGLE_CLIENT_SECRET);
		createEAttribute(googleSysConfigEClass, GOOGLE_SYS_CONFIG__GOOGLE_VERIFY_ID);

		googlePlusSysConfigEClass = createEClass(GOOGLE_PLUS_SYS_CONFIG);
		createEAttribute(googlePlusSysConfigEClass, GOOGLE_PLUS_SYS_CONFIG__GOOGLE_PLUS_ID);
		createEAttribute(googlePlusSysConfigEClass, GOOGLE_PLUS_SYS_CONFIG__GOOGLE_PLUS_KIND);
		createEAttribute(googlePlusSysConfigEClass, GOOGLE_PLUS_SYS_CONFIG__GOOGLE_PLUS_URL);
		createEAttribute(googlePlusSysConfigEClass, GOOGLE_PLUS_SYS_CONFIG__GOOGLE_PLUS_DISPLAY_NAME);

		bingSysConfigEClass = createEClass(BING_SYS_CONFIG);
		createEAttribute(bingSysConfigEClass, BING_SYS_CONFIG__BING_VERIFY_ID);

		perfectAudienceSysConfigEClass = createEClass(PERFECT_AUDIENCE_SYS_CONFIG);
		createEAttribute(perfectAudienceSysConfigEClass, PERFECT_AUDIENCE_SYS_CONFIG__PERFECT_AUDIENCE_ID);
		createEAttribute(perfectAudienceSysConfigEClass, PERFECT_AUDIENCE_SYS_CONFIG__PERFECT_AUDIENCE_ENABLED);

		// Create enums
		javaScriptModeEEnum = createEEnum(JAVA_SCRIPT_MODE);
		interactionEEnum = createEEnum(INTERACTION);

		// Create data types
		liveChatProviderEDataType = createEDataType(LIVE_CHAT_PROVIDER);
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

		// Obtain other dependent packages
		CommonsPackage theCommonsPackage = (CommonsPackage)EPackage.Registry.INSTANCE.getEPackage(CommonsPackage.eNS_URI);

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

		initEClass(permalinkCatalogEClass, PermalinkCatalog.class, "PermalinkCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPermalinkCatalog_Permalinks(), this.getPermalink(), null, "permalinks", null, 0, -1, PermalinkCatalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(permalinkEClass, Permalink.class, "Permalink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPermalink_Namespace(), ecorePackage.getEString(), "namespace", null, 1, 1, Permalink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPermalink_Template(), ecorePackage.getEString(), "template", null, 1, 1, Permalink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(permalinkManagerEClass, PermalinkManager.class, "PermalinkManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(permalinkManagerEClass, ecorePackage.getEString(), "relative", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getEntityKind(), "kind", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "slugPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(permalinkManagerEClass, ecorePackage.getEString(), "absolute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "webHost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getEntityKind(), "kind", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "slugPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(permalinkManagerEClass, ecorePackage.getEString(), "unsecureAbsolute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "webHost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getEntityKind(), "kind", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "slugPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(permalinkManagerEClass, ecorePackage.getEString(), "secureAbsolute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "webHost", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCommonsPackage.getEntityKind(), "kind", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "slugPath", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(requireManagerEClass, RequireManager.class, "RequireManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRequireManager_JavaScriptMode(), this.getJavaScriptMode(), "javaScriptMode", null, 1, 1, RequireManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRequireManager_CacheBust(), ecorePackage.getEString(), "cacheBust", null, 0, 1, RequireManager.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alexaSysConfigEClass, AlexaSysConfig.class, "AlexaSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAlexaSysConfig_AlexaVerifyId(), ecorePackage.getEString(), "alexaVerifyId", null, 0, 1, AlexaSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlexaSysConfig_AlexaCertifyEnabled(), ecorePackage.getEBooleanObject(), "alexaCertifyEnabled", "false", 0, 1, AlexaSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlexaSysConfig_AlexaCertifyAccount(), ecorePackage.getEString(), "alexaCertifyAccount", null, 0, 1, AlexaSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlexaSysConfig_AlexaCertifyDomain(), ecorePackage.getEString(), "alexaCertifyDomain", null, 0, 1, AlexaSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlexaSysConfig_AlexaCertifyJsCdn(), ecorePackage.getEString(), "alexaCertifyJsCdn", null, 0, 1, AlexaSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlexaSysConfig_AlexaCertifyImageCdn(), ecorePackage.getEString(), "alexaCertifyImageCdn", null, 0, 1, AlexaSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(liveChatSysConfigEClass, LiveChatSysConfig.class, "LiveChatSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiveChatSysConfig_LiveChatEnabled(), ecorePackage.getEBooleanObject(), "liveChatEnabled", "false", 0, 1, LiveChatSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiveChatSysConfig_LiveChatProviderId(), ecorePackage.getEString(), "liveChatProviderId", null, 0, 1, LiveChatSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiveChatSysConfig_LiveChatProvider(), this.getLiveChatProvider(), "liveChatProvider", null, 1, 1, LiveChatSysConfig.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiveChatSysConfig_LiveChatSiteId(), ecorePackage.getEString(), "liveChatSiteId", null, 0, 1, LiveChatSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(googleAnalyticsSysConfigEClass, GoogleAnalyticsSysConfig.class, "GoogleAnalyticsSysConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoogleAnalyticsSysConfig_GoogleAnalyticsEnabled(), ecorePackage.getEBooleanObject(), "googleAnalyticsEnabled", "false", 0, 1, GoogleAnalyticsSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoogleAnalyticsSysConfig_GoogleAnalyticsTrackingId(), ecorePackage.getEString(), "googleAnalyticsTrackingId", null, 0, 1, GoogleAnalyticsSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoogleAnalyticsSysConfig_GoogleAnalyticsCookieDomain(), ecorePackage.getEString(), "googleAnalyticsCookieDomain", null, 0, 1, GoogleAnalyticsSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoogleAnalyticsSysConfig_GoogleAnalyticsDisplayFeatures(), ecorePackage.getEBoolean(), "googleAnalyticsDisplayFeatures", null, 0, 1, GoogleAnalyticsSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(themePrefEClass, ThemePref.class, "ThemePref", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThemePref_NavbarColor(), ecorePackage.getEString(), "navbarColor", null, 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThemePref_NavbarTextColor(), ecorePackage.getEString(), "navbarTextColor", null, 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThemePref_OutlineColor(), ecorePackage.getEString(), "outlineColor", null, 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThemePref_BackgroundColor(), ecorePackage.getEString(), "backgroundColor", null, 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThemePref_HighlightColor(), ecorePackage.getEString(), "highlightColor", null, 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThemePref_TwitterLinkVisible(), ecorePackage.getEBoolean(), "twitterLinkVisible", "true", 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThemePref_FacebookLinkVisible(), ecorePackage.getEBoolean(), "facebookLinkVisible", "true", 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThemePref_YouTubeLinkVisible(), ecorePackage.getEBoolean(), "youTubeLinkVisible", "true", 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThemePref_FootnoteVisible(), ecorePackage.getEBoolean(), "footnoteVisible", "true", 0, 1, ThemePref.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(googleSysConfigEClass, GoogleSysConfig.class, "GoogleSysConfig", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoogleSysConfig_GoogleApiKey(), ecorePackage.getEString(), "googleApiKey", null, 0, 1, GoogleSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoogleSysConfig_GoogleClientId(), ecorePackage.getEString(), "googleClientId", null, 0, 1, GoogleSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoogleSysConfig_GoogleClientSecret(), ecorePackage.getEString(), "googleClientSecret", null, 0, 1, GoogleSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoogleSysConfig_GoogleVerifyId(), ecorePackage.getEString(), "googleVerifyId", null, 0, 1, GoogleSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(googlePlusSysConfigEClass, GooglePlusSysConfig.class, "GooglePlusSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGooglePlusSysConfig_GooglePlusId(), ecorePackage.getEString(), "googlePlusId", null, 0, 1, GooglePlusSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGooglePlusSysConfig_GooglePlusKind(), ecorePackage.getEString(), "googlePlusKind", null, 0, 1, GooglePlusSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGooglePlusSysConfig_GooglePlusUrl(), ecorePackage.getEString(), "googlePlusUrl", null, 0, 1, GooglePlusSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGooglePlusSysConfig_GooglePlusDisplayName(), ecorePackage.getEString(), "googlePlusDisplayName", null, 0, 1, GooglePlusSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bingSysConfigEClass, BingSysConfig.class, "BingSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBingSysConfig_BingVerifyId(), ecorePackage.getEString(), "bingVerifyId", null, 0, 1, BingSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(perfectAudienceSysConfigEClass, PerfectAudienceSysConfig.class, "PerfectAudienceSysConfig", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerfectAudienceSysConfig_PerfectAudienceId(), ecorePackage.getEString(), "perfectAudienceId", null, 0, 1, PerfectAudienceSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerfectAudienceSysConfig_PerfectAudienceEnabled(), ecorePackage.getEBooleanObject(), "perfectAudienceEnabled", "false", 0, 1, PerfectAudienceSysConfig.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(javaScriptModeEEnum, JavaScriptMode.class, "JavaScriptMode");
		addEEnumLiteral(javaScriptModeEEnum, JavaScriptMode.DEVELOPMENT);
		addEEnumLiteral(javaScriptModeEEnum, JavaScriptMode.MINIFIED);
		addEEnumLiteral(javaScriptModeEEnum, JavaScriptMode.AGGREGATED_MINIFIED);

		initEEnum(interactionEEnum, Interaction.class, "Interaction");
		addEEnumLiteral(interactionEEnum, Interaction.LOGIN);
		addEEnumLiteral(interactionEEnum, Interaction.LOGOUT);
		addEEnumLiteral(interactionEEnum, Interaction.INFO);
		addEEnumLiteral(interactionEEnum, Interaction.QUESTION);
		addEEnumLiteral(interactionEEnum, Interaction.WARNING);
		addEEnumLiteral(interactionEEnum, Interaction.ERROR);
		addEEnumLiteral(interactionEEnum, Interaction.DELETED);
		addEEnumLiteral(interactionEEnum, Interaction.ADDED);
		addEEnumLiteral(interactionEEnum, Interaction.MODIFIED);
		addEEnumLiteral(interactionEEnum, Interaction.SEARCHED);
		addEEnumLiteral(interactionEEnum, Interaction.FILTERED);
		addEEnumLiteral(interactionEEnum, Interaction.LOADING_LIGHT);
		addEEnumLiteral(interactionEEnum, Interaction.LOADING_HEAVY);
		addEEnumLiteral(interactionEEnum, Interaction.MESSAGE_SENT);
		addEEnumLiteral(interactionEEnum, Interaction.MESSAGE_RECEIVED);
		addEEnumLiteral(interactionEEnum, Interaction.IM_RECEIVED);
		addEEnumLiteral(interactionEEnum, Interaction.IM_SENT);
		addEEnumLiteral(interactionEEnum, Interaction.LIKED);
		addEEnumLiteral(interactionEEnum, Interaction.UNLIKED);

		// Initialize data types
		initEDataType(liveChatProviderEDataType, LiveChatProvider.class, "LiveChatProvider", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

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
		addAnnotation
		  (permalinkEClass, 
		   source, 
		   new String[] {
			 "documentation", "Permalink configuration for an entity."
		   });	
		addAnnotation
		  (getPermalink_Namespace(), 
		   source, 
		   new String[] {
			 "documentation", "e.g. person, shop, etc."
		   });	
		addAnnotation
		  (getPermalink_Template(), 
		   source, 
		   new String[] {
			 "documentation", "Recognized values are:\n\n<ol>\n<li>baseUri (from WebAddress, automatically chosen whether relative (\'/\'), absolute plain HTTP, or absolute HTTPS),\nincluding scheme and port, and trailing slash.</li>\n<li>slugPath</li>\n</ol>\n\n<p>Reference: https://github.com/damnhandy/Handy-URI-Templates"
		   });	
		addAnnotation
		  (permalinkManagerEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Get permalink URI relative to current website, no switch of HTTP(S) protocol."
		   });	
		addAnnotation
		  (permalinkManagerEClass.getEOperations().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Get absolute permalink URI, considering the recommended protocol for the entity show page, e.g. plain HTTP vs secure HTTPS."
		   });	
		addAnnotation
		  (permalinkManagerEClass.getEOperations().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Get absolute permalink URI, plain HTTP only."
		   });	
		addAnnotation
		  (permalinkManagerEClass.getEOperations().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Get absolute permalink URI, secure HTTPS."
		   });	
		addAnnotation
		  (javaScriptModeEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Use original JS."
		   });	
		addAnnotation
		  (javaScriptModeEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Use minified JS."
		   });	
		addAnnotation
		  (javaScriptModeEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "Aggregate all JavaScript, then minify it."
		   });	
		addAnnotation
		  (getRequireManager_CacheBust(), 
		   source, 
		   new String[] {
			 "documentation", "A string used to bust CDN cache, e.g. \"2013-02-16 18:43:22+07:00\".\n\nThis will be appended as a query string to \"relative\" js, skin, and img URIs. Relative here in reference to webAddres URIs. Absolute URIs won\'t be cache-busted."
		   });	
		addAnnotation
		  (alexaSysConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "SysConfig for Alexa Verify and Alexa Certify.\n\n<p>Note: Alexa Certify is paid, Verify is free by <a href=\"http://www.alexa.com/siteowners/claim\">claiming your site</a>."
		   });	
		addAnnotation
		  (getAlexaSysConfig_AlexaVerifyId(), 
		   source, 
		   new String[] {
			 "documentation", "Note: Alexa Certify is paid, Verify is free by <a href=\"http://www.alexa.com/siteowners/claim\">claiming your site</a>."
		   });	
		addAnnotation
		  (getAlexaSysConfig_AlexaCertifyEnabled(), 
		   source, 
		   new String[] {
			 "documentation", "Whether Alexa Certify feature is enabled."
		   });	
		addAnnotation
		  (getAlexaSysConfig_AlexaCertifyAccount(), 
		   source, 
		   new String[] {
			 "documentation", "Account ID for Alexa Certify."
		   });	
		addAnnotation
		  (getAlexaSysConfig_AlexaCertifyDomain(), 
		   source, 
		   new String[] {
			 "documentation", "Domain for Alexa Certify, e.g. \"berbatik.com\"."
		   });	
		addAnnotation
		  (getAlexaSysConfig_AlexaCertifyJsCdn(), 
		   source, 
		   new String[] {
			 "documentation", "Alexa Certify JavaScript CDN, embedded inside Alexa\'s script, which will be used to dynamically generate the script. e.g. \"d31qbv1cthcecs.cloudfront.net\""
		   });	
		addAnnotation
		  (getAlexaSysConfig_AlexaCertifyImageCdn(), 
		   source, 
		   new String[] {
			 "documentation", "Alexa Certify Image CDN, embedded inside Alexa\'s script, which will be used to dynamically generate the script. e.g. \"d5nxst8fruw4z.cloudfront.net\""
		   });	
		addAnnotation
		  (getLiveChatSysConfig_LiveChatEnabled(), 
		   source, 
		   new String[] {
			 "documentation", "Whether live chat feature is enabled."
		   });	
		addAnnotation
		  (getLiveChatSysConfig_LiveChatProviderId(), 
		   source, 
		   new String[] {
			 "documentation", "Live chat provider, if enabled. Available choices: OLARK, LIVECHATINC."
		   });	
		addAnnotation
		  (getLiveChatSysConfig_LiveChatProvider(), 
		   source, 
		   new String[] {
			 "documentation", "Live chat provider, if enabled. Available choices: OLARK, LIVECHATINC."
		   });	
		addAnnotation
		  (getLiveChatSysConfig_LiveChatSiteId(), 
		   source, 
		   new String[] {
			 "documentation", "Live chat site ID, if enabled. This is provider-specific."
		   });	
		addAnnotation
		  (getGoogleAnalyticsSysConfig_GoogleAnalyticsEnabled(), 
		   source, 
		   new String[] {
			 "documentation", "Whether Google Analytics is enabled."
		   });	
		addAnnotation
		  (getGoogleAnalyticsSysConfig_GoogleAnalyticsTrackingId(), 
		   source, 
		   new String[] {
			 "documentation", "Google Analytics Tracking ID, which is mandatory if enabled."
		   });	
		addAnnotation
		  (getGoogleAnalyticsSysConfig_GoogleAnalyticsCookieDomain(), 
		   source, 
		   new String[] {
			 "documentation", "Cookie domain for Google Analytics, if different than the default settings (usually the \"www\" subdomain)."
		   });	
		addAnnotation
		  (getGoogleAnalyticsSysConfig_GoogleAnalyticsDisplayFeatures(), 
		   source, 
		   new String[] {
			 "documentation", "<a href=\"https://support.google.com/analytics/answer/2700409\">Google Analytics Advertising Features</a> allow you to enable features in Analytics that aren\'t available through standard implementations. Advertising Features include:\n\n<ol>\n<li>Remarketing with Google Analytics</li>\n<li>Google Display Network Impression Reporting</li>\n<li>DoubleClick Platform integrations</li>\n<li>Google Analytics Demographics and Interest Reporting</li>\n</ol>\n\n<p>By enabling these advertising features, you enable Google Analytics to collect data about your traffic via Google advertising cookies and anonymous identifiers, in addition to data collected through a standard Google Analytics implementation. Regardless of how you send data to Google Analytics (for example, via the Google Analytics tracking code, Google Analytics SDK, or the Measurement Protocol), if you use Google Analytics Advertising Features, you must adhere to this policy.\n\n<p>You will not facilitate the merging of personally-identifiable information with non-personally identifiable information collected through any Google advertising product or feature unless you have robust notice of, and the user\'s prior affirmative (i.e., opt-in) consent to, that merger.\n\n<p>If you\'ve enabled any Google Analytics Advertising Features, you are required to notify your visitors by disclosing the following information in your privacy policy:\n\n<ol>\n<li>The Google Analytics Advertising Features you\'ve implemented.</li>\n<li>How you and third-party vendors use first-party cookies (such as the Google Analytics cookie) or other first-party identifiers, and third-party cookies (such as the DoubleClick cookie) or other third-party identifiers together.</li>\n<li>How visitors can opt-out of the Google Analytics Advertising Features you use, including through Ads Settings, Ad Settings for mobile apps, or any other available means (for example, the NAI\'s consumer opt-out).</li>\n</ol>\n\n<p>We also encourage you to point users to Google Analytics\' <a href=\"https://tools.google.com/dlpage/gaoptout/\">currently available opt-outs</a> for the web.\n\n<p>Because laws across countries and territories vary, and because Google Analytics can be used in many ways, Google is unable to provide the exact language you need to include in your privacy policy. Only you understand the unique aspects and special considerations of your business, and your privacy policy should account for this information that only you can provide."
		   });	
		addAnnotation
		  (themePrefEClass, 
		   source, 
		   new String[] {
			 "documentation", "Theme Preference, usable by App, Tenant, Shop, Person, and possibly Article/Category/Product.\n\n<p>Should be extended, e.g. {@link id.co.bippo.common.BippoThemePref} contains bippo-specific theme preferences in additional to Soluvas Web\'s.\n\n<p><b>Notes:</b> These may be disabled for a tenant by FeatureSet, which has veto power.\nA ThemePref feature usually requires data from AppManifest/Mall/SysConfig, so without the data, the theme won\'t be able to show it anyway.\nNot all Themes support all ThemePref features."
		   });	
		addAnnotation
		  (getThemePref_NavbarColor(), 
		   source, 
		   new String[] {
			 "documentation", "HTML color that is usually used for the navbar background color (color 1), but depends on theme."
		   });	
		addAnnotation
		  (getThemePref_NavbarTextColor(), 
		   source, 
		   new String[] {
			 "documentation", "HTML color that is usually used for the navbar text color (color 2), but depends on theme."
		   });	
		addAnnotation
		  (getThemePref_OutlineColor(), 
		   source, 
		   new String[] {
			 "documentation", "HTML color usually used for link or button outlines (color 3), but it depends on theme."
		   });	
		addAnnotation
		  (getThemePref_BackgroundColor(), 
		   source, 
		   new String[] {
			 "documentation", "HTML color usually used for the overall page background color (color 4), but it depends on theme."
		   });	
		addAnnotation
		  (getThemePref_HighlightColor(), 
		   source, 
		   new String[] {
			 "documentation", "HTML color usually used for highlight background color selected/active elements (color 5), but it depends on theme."
		   });	
		addAnnotation
		  (getThemePref_FootnoteVisible(), 
		   source, 
		   new String[] {
			 "documentation", "Displays the footnote specified in {@link org.soluvas.commons.AppManifest#getFootnote()}.\nThe footnote is shown on all frontend pages, usually positioned below the main content, but above the footer."
		   });	
		addAnnotation
		  (interactionEEnum, 
		   source, 
		   new String[] {
			 "documentation", "Used for providing sound effects (themeable) during or after interactions.\n\n<p><b>Note</b>: Sound effects are generally only playable during user actions, so for example we can\'t play sound on page load.\n\n<p>A sound theme depend on other themes, so it can use sounds from them.\n\n<p>See <a href=\"https://idbippo.atlassian.net/browse/BC-1811\">BC-1811: Integrasi growl / Wicket feedback dengan sound effect</a>.\n"
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Tenant user logs in to tenant."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Tenant user logs out from tenant."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "documentation", "General notification."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "documentation", "Question or confirmation box, usually a modal."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "documentation", "Warning notification."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(5), 
		   source, 
		   new String[] {
			 "documentation", "Error notification."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(6), 
		   source, 
		   new String[] {
			 "documentation", "One or more entities have been deleted."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(7), 
		   source, 
		   new String[] {
			 "documentation", "One or more entities have been added."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(8), 
		   source, 
		   new String[] {
			 "documentation", "One or more entities have been modified."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(9), 
		   source, 
		   new String[] {
			 "documentation", "Search results have been shown."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(10), 
		   source, 
		   new String[] {
			 "documentation", "Filtered results have been shown."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(11), 
		   source, 
		   new String[] {
			 "documentation", "Loading loop for light/short operations, usually without progress bar. e.g. {@link com.vaynberg.wicket.select2.Select2Choice}."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(12), 
		   source, 
		   new String[] {
			 "documentation", "Loading loop for heavy/long operations, usually with either AJAX spinner or progress bar. e.g. {@link org.soluvas.web.site.widget.AutoDisableAjaxButton}."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(13), 
		   source, 
		   new String[] {
			 "documentation", "Message or comment sent."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(14), 
		   source, 
		   new String[] {
			 "documentation", "Message or comment (long, non-private) received."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(15), 
		   source, 
		   new String[] {
			 "documentation", "Short/private instant message received."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(16), 
		   source, 
		   new String[] {
			 "documentation", "Short/private instant message sent."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(17), 
		   source, 
		   new String[] {
			 "documentation", "Liked or starred or watched."
		   });	
		addAnnotation
		  (interactionEEnum.getELiterals().get(18), 
		   source, 
		   new String[] {
			 "documentation", "Unliked or unstarred or unwatched."
		   });	
		addAnnotation
		  (googleSysConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "SysConfig for <a href=\"https://developers.google.com/+/\">Google+ Sign-in</a> and <a href=\"https://www.google.com/webmasters/tools/home\">Google Webmasters Toolkit</a>."
		   });	
		addAnnotation
		  (getGoogleSysConfig_GoogleApiKey(), 
		   source, 
		   new String[] {
			 "documentation", "<a href=\"https://developers.google.com/console/help/using-keys\">Public API access</a>\n\n<p>Use of this key does not require any user action or consent, does not grant access to any account information, and is not used for authorization.\n\n<p>Get this from <a href=\"https://console.developers.google.com/\">Google Developers Console</a> - API Project - APIs & auth - Credentials - Public API access."
		   });	
		addAnnotation
		  (getGoogleSysConfig_GoogleClientId(), 
		   source, 
		   new String[] {
			 "documentation", "<a href=\"https://developers.google.com/console/help/generating-oauth2\">OAuth 2.0 Client ID</a>\n\n<p>OAuth 2.0 allows users to share specific data with you (for example, contact lists) while keeping their usernames, passwords, and other information private.\n\n<p>Get this from <a href=\"https://console.developers.google.com/\">Google Developers Console</a> - API Project - APIs & auth - Credentials - OAuth."
		   });	
		addAnnotation
		  (getGoogleSysConfig_GoogleClientSecret(), 
		   source, 
		   new String[] {
			 "documentation", "<a href=\"https://developers.google.com/console/help/generating-oauth2\">OAuth 2.0 Client Secret</a>\n\n<p>OAuth 2.0 allows users to share specific data with you (for example, contact lists) while keeping their usernames, passwords, and other information private.\n\n<p>Get this from <a href=\"https://console.developers.google.com/\">Google Developers Console</a> - API Project - APIs & auth - Credentials - OAuth."
		   });	
		addAnnotation
		  (getGoogleSysConfig_GoogleVerifyId(), 
		   source, 
		   new String[] {
			 "documentation", "Google site verification ID provided by <a href=\"https://www.google.com/webmasters/tools/home\">Google Webmasters Toolkit</a>, e.g. {@code google187974e610426105}."
		   });	
		addAnnotation
		  (bingSysConfigEClass, 
		   source, 
		   new String[] {
			 "documentation", "This will serve {@code /BingSiteAuth.xml} with the following content (for example):\n\n<pre>\n&lt;?xml version=\"1.0\"?>\n&lt;users>\n\t&lt;user>81F7B85A49DDECE76EB169D2EFA46809</user>\n&lt;/users>\n</pre>\n\nGo to <a href=\"https://www.bing.com/webmaster/home/mysites\">Bing Webmaster</a> to get Bing Verify ID for your website."
		   });
	}
	
	public static SitePackage getInstance() {
		return eINSTANCE;
	}

} //SitePackageImpl
