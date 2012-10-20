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
import org.soluvas.web.site.EntityTablePage;
import org.soluvas.web.site.GenericPage;
import org.soluvas.web.site.LoginPage;
import org.soluvas.web.site.OpenGraphAudio;
import org.soluvas.web.site.OpenGraphImage;
import org.soluvas.web.site.OpenGraphMeta;
import org.soluvas.web.site.OpenGraphVideo;
import org.soluvas.web.site.Page;
import org.soluvas.web.site.PageDeclaration;
import org.soluvas.web.site.PageIcon;
import org.soluvas.web.site.PageMeta;
import org.soluvas.web.site.PageMetaCollection;
import org.soluvas.web.site.PageParam;
import org.soluvas.web.site.PageRule;
import org.soluvas.web.site.PageRuleCollection;
import org.soluvas.web.site.PageSelector;
import org.soluvas.web.site.PageTitle;
import org.soluvas.web.site.ProcessorPageDeclaration;
import org.soluvas.web.site.RawEntityEditPage;
import org.soluvas.web.site.RawEntityNewPage;
import org.soluvas.web.site.RawEntityTablePage;
import org.soluvas.web.site.RegisterPage;
import org.soluvas.web.site.RepositoryPageDeclaration;
import org.soluvas.web.site.ResetPasswordPage;
import org.soluvas.web.site.ResourcePageDeclaration;
import org.soluvas.web.site.Section;
import org.soluvas.web.site.SectionCollection;
import org.soluvas.web.site.SiteCatalog;
import org.soluvas.web.site.SiteFactory;
import org.soluvas.web.site.SitePackage;
import org.soluvas.web.site.SourcePageDeclaration;
import org.soluvas.web.site.UriPatternPageSelector;

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
	private EClass pageMetaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageIconEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openGraphMetaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openGraphImageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openGraphVideoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openGraphAudioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uriPatternPageSelectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourcePageDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processorPageDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourcePageDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryPageDeclarationEClass = null;

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
	private EClass pageMetaCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageRuleCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageTitleEClass = null;

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
	public EClass getPageMeta() {
		return pageMetaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageMeta_Icon() {
		return (EReference)pageMetaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageMeta_LanguageCode() {
		return (EAttribute)pageMetaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageMeta_OpenGraph() {
		return (EReference)pageMetaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageMeta_OpenGraphImage() {
		return (EReference)pageMetaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageMeta_OpenGraphVideo() {
		return (EReference)pageMetaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageMeta_OpenGraphAudio() {
		return (EReference)pageMetaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageMeta_Description() {
		return (EAttribute)pageMetaEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageMeta_Charset() {
		return (EAttribute)pageMetaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageMeta_Title() {
		return (EAttribute)pageMetaEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageMeta_Keywords() {
		return (EAttribute)pageMetaEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageMeta_Viewport() {
		return (EAttribute)pageMetaEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageMeta_Author() {
		return (EAttribute)pageMetaEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageIcon() {
		return pageIconEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageIcon_FaviconUri() {
		return (EAttribute)pageIconEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageIcon_Icon57Uri() {
		return (EAttribute)pageIconEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageIcon_Icon72Uri() {
		return (EAttribute)pageIconEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageIcon_Icon114Uri() {
		return (EAttribute)pageIconEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageIcon_Icon144Uri() {
		return (EAttribute)pageIconEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenGraphMeta() {
		return openGraphMetaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Title() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Type() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Image() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Url() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Audio() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Description() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Determiner() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Locale() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_LocaleAlternates() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_SiteName() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphMeta_Video() {
		return (EAttribute)openGraphMetaEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenGraphImage() {
		return openGraphImageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphImage_Url() {
		return (EAttribute)openGraphImageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphImage_SecureUrl() {
		return (EAttribute)openGraphImageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphImage_Type() {
		return (EAttribute)openGraphImageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphImage_Width() {
		return (EAttribute)openGraphImageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphImage_Height() {
		return (EAttribute)openGraphImageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenGraphVideo() {
		return openGraphVideoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphVideo_Url() {
		return (EAttribute)openGraphVideoEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphVideo_SecureUrl() {
		return (EAttribute)openGraphVideoEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphVideo_Type() {
		return (EAttribute)openGraphVideoEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphVideo_Width() {
		return (EAttribute)openGraphVideoEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphVideo_Height() {
		return (EAttribute)openGraphVideoEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenGraphAudio() {
		return openGraphAudioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphAudio_Url() {
		return (EAttribute)openGraphAudioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphAudio_SecureUrl() {
		return (EAttribute)openGraphAudioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenGraphAudio_Type() {
		return (EAttribute)openGraphAudioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageSelector() {
		return pageSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUriPatternPageSelector() {
		return uriPatternPageSelectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUriPatternPageSelector_Pattern() {
		return (EAttribute)uriPatternPageSelectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageRule() {
		return pageRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageRule_Selector() {
		return (EReference)pageRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageRule_Weight() {
		return (EAttribute)pageRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageRule_Declaration() {
		return (EReference)pageRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageDeclaration() {
		return pageDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourcePageDeclaration() {
		return sourcePageDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourcePageDeclaration_Source() {
		return (EReference)sourcePageDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessorPageDeclaration() {
		return processorPageDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessorPageDeclaration_Filter() {
		return (EAttribute)processorPageDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourcePageDeclaration() {
		return resourcePageDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcePageDeclaration_Bundle() {
		return (EAttribute)resourcePageDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourcePageDeclaration_Path() {
		return (EAttribute)resourcePageDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepositoryPageDeclaration() {
		return repositoryPageDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepositoryPageDeclaration_Filter() {
		return (EAttribute)repositoryPageDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRepositoryPageDeclaration_Path() {
		return (EAttribute)repositoryPageDeclarationEClass.getEStructuralFeatures().get(1);
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
	public EClass getPageMetaCollection() {
		return pageMetaCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageMetaCollection_PageMetas() {
		return (EReference)pageMetaCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageRuleCollection() {
		return pageRuleCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageRuleCollection_PageRules() {
		return (EReference)pageRuleCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageTitle() {
		return pageTitleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageTitle_Main() {
		return (EAttribute)pageTitleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageTitle_Prefixes() {
		return (EAttribute)pageTitleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageTitle_Suffixes() {
		return (EAttribute)pageTitleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageTitle_PrefixSeparator() {
		return (EAttribute)pageTitleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageTitle_SuffixSeparator() {
		return (EAttribute)pageTitleEClass.getEStructuralFeatures().get(4);
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
		pageMetaEClass = createEClass(PAGE_META);
		createEReference(pageMetaEClass, PAGE_META__ICON);
		createEAttribute(pageMetaEClass, PAGE_META__LANGUAGE_CODE);
		createEReference(pageMetaEClass, PAGE_META__OPEN_GRAPH);
		createEReference(pageMetaEClass, PAGE_META__OPEN_GRAPH_IMAGE);
		createEReference(pageMetaEClass, PAGE_META__OPEN_GRAPH_VIDEO);
		createEReference(pageMetaEClass, PAGE_META__OPEN_GRAPH_AUDIO);
		createEAttribute(pageMetaEClass, PAGE_META__CHARSET);
		createEAttribute(pageMetaEClass, PAGE_META__TITLE);
		createEAttribute(pageMetaEClass, PAGE_META__KEYWORDS);
		createEAttribute(pageMetaEClass, PAGE_META__DESCRIPTION);
		createEAttribute(pageMetaEClass, PAGE_META__VIEWPORT);
		createEAttribute(pageMetaEClass, PAGE_META__AUTHOR);

		pageIconEClass = createEClass(PAGE_ICON);
		createEAttribute(pageIconEClass, PAGE_ICON__FAVICON_URI);
		createEAttribute(pageIconEClass, PAGE_ICON__ICON57_URI);
		createEAttribute(pageIconEClass, PAGE_ICON__ICON72_URI);
		createEAttribute(pageIconEClass, PAGE_ICON__ICON114_URI);
		createEAttribute(pageIconEClass, PAGE_ICON__ICON144_URI);

		openGraphMetaEClass = createEClass(OPEN_GRAPH_META);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__TITLE);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__TYPE);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__IMAGE);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__URL);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__AUDIO);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__DESCRIPTION);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__DETERMINER);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__LOCALE);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__LOCALE_ALTERNATES);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__SITE_NAME);
		createEAttribute(openGraphMetaEClass, OPEN_GRAPH_META__VIDEO);

		openGraphImageEClass = createEClass(OPEN_GRAPH_IMAGE);
		createEAttribute(openGraphImageEClass, OPEN_GRAPH_IMAGE__URL);
		createEAttribute(openGraphImageEClass, OPEN_GRAPH_IMAGE__SECURE_URL);
		createEAttribute(openGraphImageEClass, OPEN_GRAPH_IMAGE__TYPE);
		createEAttribute(openGraphImageEClass, OPEN_GRAPH_IMAGE__WIDTH);
		createEAttribute(openGraphImageEClass, OPEN_GRAPH_IMAGE__HEIGHT);

		openGraphVideoEClass = createEClass(OPEN_GRAPH_VIDEO);
		createEAttribute(openGraphVideoEClass, OPEN_GRAPH_VIDEO__URL);
		createEAttribute(openGraphVideoEClass, OPEN_GRAPH_VIDEO__SECURE_URL);
		createEAttribute(openGraphVideoEClass, OPEN_GRAPH_VIDEO__TYPE);
		createEAttribute(openGraphVideoEClass, OPEN_GRAPH_VIDEO__WIDTH);
		createEAttribute(openGraphVideoEClass, OPEN_GRAPH_VIDEO__HEIGHT);

		openGraphAudioEClass = createEClass(OPEN_GRAPH_AUDIO);
		createEAttribute(openGraphAudioEClass, OPEN_GRAPH_AUDIO__URL);
		createEAttribute(openGraphAudioEClass, OPEN_GRAPH_AUDIO__SECURE_URL);
		createEAttribute(openGraphAudioEClass, OPEN_GRAPH_AUDIO__TYPE);

		pageSelectorEClass = createEClass(PAGE_SELECTOR);

		uriPatternPageSelectorEClass = createEClass(URI_PATTERN_PAGE_SELECTOR);
		createEAttribute(uriPatternPageSelectorEClass, URI_PATTERN_PAGE_SELECTOR__PATTERN);

		pageRuleEClass = createEClass(PAGE_RULE);
		createEReference(pageRuleEClass, PAGE_RULE__SELECTOR);
		createEAttribute(pageRuleEClass, PAGE_RULE__WEIGHT);
		createEReference(pageRuleEClass, PAGE_RULE__DECLARATION);

		pageDeclarationEClass = createEClass(PAGE_DECLARATION);

		sourcePageDeclarationEClass = createEClass(SOURCE_PAGE_DECLARATION);
		createEReference(sourcePageDeclarationEClass, SOURCE_PAGE_DECLARATION__SOURCE);

		processorPageDeclarationEClass = createEClass(PROCESSOR_PAGE_DECLARATION);
		createEAttribute(processorPageDeclarationEClass, PROCESSOR_PAGE_DECLARATION__FILTER);

		resourcePageDeclarationEClass = createEClass(RESOURCE_PAGE_DECLARATION);
		createEAttribute(resourcePageDeclarationEClass, RESOURCE_PAGE_DECLARATION__BUNDLE);
		createEAttribute(resourcePageDeclarationEClass, RESOURCE_PAGE_DECLARATION__PATH);

		repositoryPageDeclarationEClass = createEClass(REPOSITORY_PAGE_DECLARATION);
		createEAttribute(repositoryPageDeclarationEClass, REPOSITORY_PAGE_DECLARATION__FILTER);
		createEAttribute(repositoryPageDeclarationEClass, REPOSITORY_PAGE_DECLARATION__PATH);

		sectionEClass = createEClass(SECTION);
		createEAttribute(sectionEClass, SECTION__ID);
		createEAttribute(sectionEClass, SECTION__NAME);
		createEReference(sectionEClass, SECTION__PAGES);

		siteCatalogEClass = createEClass(SITE_CATALOG);

		sectionCollectionEClass = createEClass(SECTION_COLLECTION);
		createEReference(sectionCollectionEClass, SECTION_COLLECTION__SECTIONS);

		pageMetaCollectionEClass = createEClass(PAGE_META_COLLECTION);
		createEReference(pageMetaCollectionEClass, PAGE_META_COLLECTION__PAGE_METAS);

		pageRuleCollectionEClass = createEClass(PAGE_RULE_COLLECTION);
		createEReference(pageRuleCollectionEClass, PAGE_RULE_COLLECTION__PAGE_RULES);

		pageTitleEClass = createEClass(PAGE_TITLE);
		createEAttribute(pageTitleEClass, PAGE_TITLE__MAIN);
		createEAttribute(pageTitleEClass, PAGE_TITLE__PREFIXES);
		createEAttribute(pageTitleEClass, PAGE_TITLE__SUFFIXES);
		createEAttribute(pageTitleEClass, PAGE_TITLE__PREFIX_SEPARATOR);
		createEAttribute(pageTitleEClass, PAGE_TITLE__SUFFIX_SEPARATOR);

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
		uriPatternPageSelectorEClass.getESuperTypes().add(this.getPageSelector());
		sourcePageDeclarationEClass.getESuperTypes().add(this.getPageDeclaration());
		processorPageDeclarationEClass.getESuperTypes().add(this.getPageDeclaration());
		resourcePageDeclarationEClass.getESuperTypes().add(this.getPageDeclaration());
		repositoryPageDeclarationEClass.getESuperTypes().add(this.getPageDeclaration());
		siteCatalogEClass.getESuperTypes().add(this.getSectionCollection());
		siteCatalogEClass.getESuperTypes().add(this.getPageMetaCollection());
		siteCatalogEClass.getESuperTypes().add(this.getPageRuleCollection());
		genericPageEClass.getESuperTypes().add(this.getPage());
		rawEntityTablePageEClass.getESuperTypes().add(this.getPage());
		entityTablePageEClass.getESuperTypes().add(this.getPage());
		entityEditPageEClass.getESuperTypes().add(this.getPage());
		rawEntityEditPageEClass.getESuperTypes().add(this.getPage());
		rawEntityNewPageEClass.getESuperTypes().add(this.getPage());
		entityNewPageEClass.getESuperTypes().add(this.getPage());
		contentPageEClass.getESuperTypes().add(this.getPage());
		dashboardPageEClass.getESuperTypes().add(this.getPage());
		loginPageEClass.getESuperTypes().add(this.getPage());
		registerPageEClass.getESuperTypes().add(this.getPage());
		resetPasswordPageEClass.getESuperTypes().add(this.getPage());

		// Initialize classes and features; add operations and parameters
		initEClass(pageMetaEClass, PageMeta.class, "PageMeta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageMeta_Icon(), this.getPageIcon(), null, "icon", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageMeta_LanguageCode(), ecorePackage.getEString(), "languageCode", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPageMeta_OpenGraph(), this.getOpenGraphMeta(), null, "openGraph", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPageMeta_OpenGraphImage(), this.getOpenGraphImage(), null, "openGraphImage", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPageMeta_OpenGraphVideo(), this.getOpenGraphVideo(), null, "openGraphVideo", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPageMeta_OpenGraphAudio(), this.getOpenGraphAudio(), null, "openGraphAudio", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageMeta_Charset(), ecorePackage.getEString(), "charset", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageMeta_Title(), ecorePackage.getEString(), "title", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageMeta_Keywords(), ecorePackage.getEString(), "keywords", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageMeta_Description(), ecorePackage.getEString(), "description", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageMeta_Viewport(), ecorePackage.getEString(), "viewport", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageMeta_Author(), ecorePackage.getEString(), "author", null, 0, 1, PageMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageIconEClass, PageIcon.class, "PageIcon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPageIcon_FaviconUri(), ecorePackage.getEString(), "faviconUri", null, 0, 1, PageIcon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageIcon_Icon57Uri(), ecorePackage.getEString(), "icon57Uri", null, 0, 1, PageIcon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageIcon_Icon72Uri(), ecorePackage.getEString(), "icon72Uri", null, 0, 1, PageIcon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageIcon_Icon114Uri(), ecorePackage.getEString(), "icon114Uri", null, 0, 1, PageIcon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageIcon_Icon144Uri(), ecorePackage.getEString(), "icon144Uri", null, 0, 1, PageIcon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openGraphMetaEClass, OpenGraphMeta.class, "OpenGraphMeta", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenGraphMeta_Title(), ecorePackage.getEString(), "title", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_Type(), ecorePackage.getEString(), "type", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_Image(), ecorePackage.getEString(), "image", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_Url(), ecorePackage.getEString(), "url", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_Audio(), ecorePackage.getEString(), "audio", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_Description(), ecorePackage.getEString(), "description", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_Determiner(), ecorePackage.getEString(), "determiner", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_Locale(), ecorePackage.getEString(), "locale", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_LocaleAlternates(), ecorePackage.getEString(), "localeAlternates", null, 0, -1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_SiteName(), ecorePackage.getEString(), "siteName", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphMeta_Video(), ecorePackage.getEString(), "video", null, 0, 1, OpenGraphMeta.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openGraphImageEClass, OpenGraphImage.class, "OpenGraphImage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenGraphImage_Url(), ecorePackage.getEString(), "url", null, 0, 1, OpenGraphImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphImage_SecureUrl(), ecorePackage.getEString(), "secureUrl", null, 0, 1, OpenGraphImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphImage_Type(), ecorePackage.getEString(), "type", null, 0, 1, OpenGraphImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphImage_Width(), ecorePackage.getEIntegerObject(), "width", null, 0, 1, OpenGraphImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphImage_Height(), ecorePackage.getEIntegerObject(), "height", null, 0, 1, OpenGraphImage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openGraphVideoEClass, OpenGraphVideo.class, "OpenGraphVideo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenGraphVideo_Url(), ecorePackage.getEString(), "url", null, 0, 1, OpenGraphVideo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphVideo_SecureUrl(), ecorePackage.getEString(), "secureUrl", null, 0, 1, OpenGraphVideo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphVideo_Type(), ecorePackage.getEString(), "type", null, 0, 1, OpenGraphVideo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphVideo_Width(), ecorePackage.getEIntegerObject(), "width", null, 0, 1, OpenGraphVideo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphVideo_Height(), ecorePackage.getEIntegerObject(), "height", null, 0, 1, OpenGraphVideo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openGraphAudioEClass, OpenGraphAudio.class, "OpenGraphAudio", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenGraphAudio_Url(), ecorePackage.getEString(), "url", null, 0, 1, OpenGraphAudio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphAudio_SecureUrl(), ecorePackage.getEString(), "secureUrl", null, 0, 1, OpenGraphAudio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenGraphAudio_Type(), ecorePackage.getEString(), "type", null, 0, 1, OpenGraphAudio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageSelectorEClass, PageSelector.class, "PageSelector", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uriPatternPageSelectorEClass, UriPatternPageSelector.class, "UriPatternPageSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUriPatternPageSelector_Pattern(), ecorePackage.getEString(), "pattern", null, 0, 1, UriPatternPageSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageRuleEClass, PageRule.class, "PageRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageRule_Selector(), this.getPageSelector(), null, "selector", null, 0, 1, PageRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageRule_Weight(), ecorePackage.getEIntegerObject(), "weight", null, 0, 1, PageRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPageRule_Declaration(), this.getPageDeclaration(), null, "declaration", null, 0, 1, PageRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageDeclarationEClass, PageDeclaration.class, "PageDeclaration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourcePageDeclarationEClass, SourcePageDeclaration.class, "SourcePageDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourcePageDeclaration_Source(), this.getPageMeta(), null, "source", null, 0, 1, SourcePageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processorPageDeclarationEClass, ProcessorPageDeclaration.class, "ProcessorPageDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessorPageDeclaration_Filter(), ecorePackage.getEString(), "filter", null, 0, 1, ProcessorPageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourcePageDeclarationEClass, ResourcePageDeclaration.class, "ResourcePageDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourcePageDeclaration_Bundle(), ecorePackage.getEString(), "bundle", null, 0, 1, ResourcePageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourcePageDeclaration_Path(), ecorePackage.getEString(), "path", null, 0, 1, ResourcePageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repositoryPageDeclarationEClass, RepositoryPageDeclaration.class, "RepositoryPageDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRepositoryPageDeclaration_Filter(), ecorePackage.getEString(), "filter", null, 0, 1, RepositoryPageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepositoryPageDeclaration_Path(), ecorePackage.getEString(), "path", null, 0, 1, RepositoryPageDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sectionEClass, Section.class, "Section", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSection_Id(), ecorePackage.getEString(), "id", null, 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSection_Name(), ecorePackage.getEString(), "name", null, 1, 1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSection_Pages(), this.getPage(), this.getPage_Section(), "pages", null, 0, -1, Section.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(siteCatalogEClass, SiteCatalog.class, "SiteCatalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sectionCollectionEClass, SectionCollection.class, "SectionCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSectionCollection_Sections(), this.getSection(), null, "sections", null, 0, -1, SectionCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageMetaCollectionEClass, PageMetaCollection.class, "PageMetaCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageMetaCollection_PageMetas(), this.getPageMeta(), null, "pageMetas", null, 0, -1, PageMetaCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageRuleCollectionEClass, PageRuleCollection.class, "PageRuleCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageRuleCollection_PageRules(), this.getPageRule(), null, "pageRules", null, 0, -1, PageRuleCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pageTitleEClass, PageTitle.class, "PageTitle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPageTitle_Main(), ecorePackage.getEString(), "main", null, 0, 1, PageTitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageTitle_Prefixes(), ecorePackage.getEString(), "prefixes", null, 0, -1, PageTitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageTitle_Suffixes(), ecorePackage.getEString(), "suffixes", null, 0, -1, PageTitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageTitle_PrefixSeparator(), ecorePackage.getEString(), "prefixSeparator", null, 0, 1, PageTitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPageTitle_SuffixSeparator(), ecorePackage.getEString(), "suffixSeparator", null, 0, 1, PageTitle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (pageMetaEClass, 
		   source, 
		   new String[] {
			 "documentation", "Low-level meta-information about a HTML page.\n\nFor practical purposes, these are usually provided dynamically. However, some information, like favicon URIs and OpenGraph siteName are usually provided statically from application\'s site catalog XMI e.g. berbatik.SiteCatalog.xmi.\n\nNote that PageMeta uses low-level HTML title, not a \"CMS title\" (which needs to be reformatted i.e. with prefix & suffix).\nIt also distinguishes between meta description and og:description.\nSo it doesn\'t fit well to be provided statically."
		   });		
		addAnnotation
		  (getPageMeta_LanguageCode(), 
		   source, 
		   new String[] {
			 "documentation", "Used in \"html\" tag, recommended is \"en\"."
		   });		
		addAnnotation
		  (getPageMeta_Charset(), 
		   source, 
		   new String[] {
			 "documentation", "Recommended: utf-8."
		   });		
		addAnnotation
		  (getPageMeta_Viewport(), 
		   source, 
		   new String[] {
			 "documentation", "Recommended: width=device-width, initial-scale=1.0"
		   });		
		addAnnotation
		  (openGraphMetaEClass, 
		   source, 
		   new String[] {
			 "documentation", "The Open Graph protocol enables any web page to become a rich object in a social graph. For instance, this is used on Facebook to allow any web page to have the same functionality as any other object on Facebook.\n\nWhile many different technologies and schemas exist and could be combined together, there isn\'t a single technology which provides enough information to richly represent any web page within the social graph. The Open Graph protocol builds on these existing technologies and gives developers one thing to implement. Developer simplicity is a key goal of the Open Graph protocol which has informed many of the technical design decisions.\n\nBasic Metadata\nTo turn your web pages into graph objects, you need to add basic metadata to your page. We\'ve based the initial version of the protocol on RDFa which means that you\'ll place additional <meta> tags in the <head> of your web page. The four required properties for every page are:\n\nog:title - The title of your object as it should appear within the graph, e.g., \"The Rock\".\nog:type - The type of your object, e.g., \"video.movie\". Depending on the type you specify, other properties may also be required.\nog:image - An image URL which should represent your object within the graph.\nog:url - The canonical URL of your object that will be used as its permanent ID in the graph, e.g., \"http://www.imdb.com/title/tt0117500/\".\nAs an example, the following is the Open Graph protocol markup for The Rock on IMDB:\n\n<html prefix=\"og: http://ogp.me/ns#\">\n<head>\n<title>The Rock (1996)</title>\n<meta property=\"og:title\" content=\"The Rock\" />\n<meta property=\"og:type\" content=\"video.movie\" />\n<meta property=\"og:url\" content=\"http://www.imdb.com/title/tt0117500/\" />\n<meta property=\"og:image\" content=\"http://ia.media-imdb.com/images/rock.jpg\" />\n...\n</head>\n...\n</html>\nOptional Metadata\nThe following properties are optional for any object and are generally recommended:\n\nog:audio - A URL to an audio file to accompany this object.\nog:description - A one to two sentence description of your object.\nog:determiner - The word that appears before this object\'s title in a sentence. An enum of (a, an, the, \"\", auto). If auto is chosen, the consumer of your data should chose between \"a\" or \"an\". Default is \"\" (blank).\nog:locale - The locale these tags are marked up in. Of the format language_TERRITORY. Default is en_US.\nog:locale:alternate - An array of other locales this page is available in.\nog:site_name - If your object is part of a larger web site, the name which should be displayed for the overall site. e.g., \"IMDb\".\nog:video - A URL to a video file that complements this object.\nFor example (line-break solely for display purposes):\n\n<meta property=\"og:audio\" content=\"http://example.com/bond/theme.mp3\" />\n<meta property=\"og:description\" \n  content=\"Sean Connery found fame and fortune as the\n           suave, sophisticated British agent, James Bond.\" />\n<meta property=\"og:determiner\" content=\"the\" />\n<meta property=\"og:locale\" content=\"en_GB\" />\n<meta property=\"og:locale:alternate\" content=\"fr_FR\" />\n<meta property=\"og:locale:alternate\" content=\"es_ES\" />\n<meta property=\"og:site_name\" content=\"IMDb\" />\n<meta property=\"og:video\" content=\"http://example.com/bond/trailer.swf\" />\nThe RDF schema (in Turtle) can be found at ogp.me/ns.\n\nStructured Properties\nSome properties can have extra metadata attached to them. These are specified in the same way as other metadata with property and content, but the property will have extra :.\n\nThe og:image property has some optional structured properties:\n\nog:image:url - Identical to og:image.\nog:image:secure_url - An alternate url to use if the webpage requires HTTPS.\nog:image:type - A MIME type for this image.\nog:image:width - The number of pixels wide.\nog:image:height - The number of pixels high.\nA full image example:\n\n<meta property=\"og:image\" content=\"http://example.com/ogp.jpg\" />\n<meta property=\"og:image:secure_url\" content=\"https://secure.example.com/ogp.jpg\" />\n<meta property=\"og:image:type\" content=\"image/jpeg\" />\n<meta property=\"og:image:width\" content=\"400\" />\n<meta property=\"og:image:height\" content=\"300\" />\nThe og:video tag has the identical tags as og:image. Here is an example:\n\n<meta property=\"og:video\" content=\"http://example.com/movie.swf\" />\n<meta property=\"og:video:secure_url\" content=\"https://secure.example.com/movie.swf\" />\n<meta property=\"og:video:type\" content=\"application/x-shockwave-flash\" />\n<meta property=\"og:video:width\" content=\"400\" />\n<meta property=\"og:video:height\" content=\"300\" />\nThe og:audio tag only has the first 3 properties available (since size doesn\'t make sense for sound):\n\n<meta property=\"og:audio\" content=\"http://example.com/sound.mp3\" />\n<meta property=\"og:audio:secure_url\" content=\"https://secure.example.com/sound.mp3\" />\n<meta property=\"og:audio:type\" content=\"audio/mpeg\" />\nArrays\nIf a tag can have multiple values, just put multiple versions of the same <meta> tag on your page. The first tag (from top to bottom) is given preference during conflicts.\n\n<meta property=\"og:image\" content=\"http://example.com/rock.jpg\" />\n<meta property=\"og:image\" content=\"http://example.com/rock2.jpg\" />\nPut structured properties after you declare their root tag. Whenever another root element is parsed, that structured property is considered to be done and another one is started.\n\nFor example:\n\n<meta property=\"og:image\" content=\"http://example.com/rock.jpg\" />\n<meta property=\"og:image:width\" content=\"300\" />\n<meta property=\"og:image:height\" content=\"300\" />\n<meta property=\"og:image\" content=\"http://example.com/rock2.jpg\" />\n<meta property=\"og:image\" content=\"http://example.com/rock3.jpg\" />\n<meta property=\"og:image:height\" content=\"1000\" />\nmeans there are 3 images on this page, the first image is 300x300, the middle one has unspecified dimensions, and the last one is 1000px tall.\n\nObject Types\nIn order for your object to be represented within the graph, you need to specify its type. This is done using the og:type property:\n\n<meta property=\"og:type\" content=\"website\" />\nWhen the community agrees on the schema for a type, it is added to the list of global types. All other objects in the type system are CURIEs of the form\n\n<head prefix=\"my_namespace: http://example.com/ns#\">\n<meta property=\"og:type\" content=\"my_namespace:my_type\" />\nThe global types are grouped into verticals. Each vertical has its own namespace. The og:type values for a namespace are always prefixed with the namespace and then a period. This is to reduce confusion with user-defined namespaced types which always have colons in them.\n\nMusic\nNamespace URI: http://ogp.me/ns/music#\nog:type values:\n\nmusic.song\n\nmusic:duration - integer >=1 - The song\'s length in seconds.\nmusic:album - music.album array - The album this song is from.\nmusic:album:disc - integer >=1 - Which disc of the album this song is on.\nmusic:album:track - integer >=1 - Which track this song is.\nmusic:musician - profile array - The musician that made this song.\nmusic.album\n\nmusic:song - music.song - The song on this album.\nmusic:song:disc - integer >=1 - The same as music:album:disc but in reverse.\nmusic:song:track - integer >=1 - The same as music:album:track but in reverse.\nmusic:musician - profile - The musician that made this song.\nmusic:release_date - datetime - The date the album was released.\nmusic.playlist\n\nmusic:song - Identical to the ones on music.album\nmusic:song:disc\nmusic:song:track\nmusic:creator - profile - The creator of this playlist.\nmusic.radio_station\n\nmusic:creator - profile - The creator of this station.\nVideo\nNamespace URI: http://ogp.me/ns/video#\nog:type values:\n\nvideo.movie\n\nvideo:actor - profile array - Actors in the movie.\nvideo:actor:role - string - The role they played.\nvideo:director - profile array - Directors of the movie.\nvideo:writer - profile array - Writers of the movie.\nvideo:duration - integer >=1 - The movie\'s length in seconds.\nvideo:release_date - datetime - The date the movie was released.\nvideo:tag - string array - Tag words associated with this movie.\nvideo.episode\n\nvideo:actor - Identical to video.movie\nvideo:actor:role\nvideo:director\nvideo:writer\nvideo:duration\nvideo:release_date\nvideo:tag\nvideo:series - video.tv_show - Which series this episode belongs to.\nvideo.tv_show\n\nA multi-episode TV show. The metadata is identical to video.movie.\n\nvideo.other\n\nA video that doesn\'t belong in any other category. The metadata is identical to video.movie.\n\nNo Vertical\nThese are globally defined objects that just don\'t fit into a vertical but yet are broadly used and agreed upon.\n\nog:type values:\n\narticle - Namespace URI: http://ogp.me/ns/article#\n\narticle:published_time - datetime - When the article was first published.\narticle:modified_time - datetime - When the article was last changed.\narticle:expiration_time - datetime - When the article is out of date after.\narticle:author - profile array - Writers of the article.\narticle:section - string - A high-level section name. E.g. Technology\narticle:tag - string array - Tag words associated with this article.\nbook - Namespace URI: http://ogp.me/ns/book#\n\nbook:author - profile array - Who wrote this book.\nbook:isbn - string - The ISBN\nbook:release_date - datetime - The date the book was released.\nbook:tag - string array - Tag words associated with this book.\nprofile - Namespace URI: http://ogp.me/ns/profile#\n\nprofile:first_name - string - A name normally given to an individual by a parent or self-chosen.\nprofile:last_name - string - A name inherited from a family or marriage and by which the individual is commonly known.\nprofile:username - string - A short unique string to identify them.\nprofile:gender - enum(male, female) - Their gender.\nwebsite - Namespace URI: http://ogp.me/ns/website#\n\nNo additional properties other than the basic ones. Any non-marked up webpage should be treated as og:type website.\n\nTypes\nThe following types are used when defining attributes in Open Graph protocol.\n\nType\tDescription\tLiterals\nBoolean\tA Boolean represents a true or false value\ttrue, false, 1, 0\nDateTime\tA DateTime represents a temporal value composed of a date (year, month, day) and an optional time component (hours, minutes)\tISO 8601\nEnum\tA type consisting of bounded set of constant string values (enumeration members).\tA string value that is a member of the enumeration\nFloat\tA 64-bit signed floating point number\tAll literals that conform to the following formats:\n\n1.234\n-1.234\n1.2e3\n-1.2e3\n7E-10\nInteger\tA 32-bit signed integer. In many languages integers over 32-bits become floats, so we limit Open Graph protocol for easy multi-language use.\tAll literals that conform to the following formats:\n\n1234\n-123\nString\tA sequence of Unicode characters\tAll literals composed of Unicode characters with no escape characters\nURL\tA sequence of Unicode characters that identify an Internet resource.\tAll valid URLs that utilize the http:// or https:// protocols\n"
		   });		
		addAnnotation
		  (getOpenGraphMeta_Title(), 
		   source, 
		   new String[] {
			 "documentation", "og:title. The title of your object as it should appear within the graph, e.g., \"The Rock\"."
		   });		
		addAnnotation
		  (getOpenGraphMeta_Type(), 
		   source, 
		   new String[] {
			 "documentation", "og:type. The type of your object, e.g., \"video.movie\". Depending on the type you specify, other properties may also be required."
		   });		
		addAnnotation
		  (getOpenGraphMeta_Image(), 
		   source, 
		   new String[] {
			 "documentation", "og:image - An image URL which should represent your object within the graph.\n"
		   });		
		addAnnotation
		  (getOpenGraphMeta_Url(), 
		   source, 
		   new String[] {
			 "documentation", "og:url - The canonical URL of your object that will be used as its permanent ID in the graph, e.g., \"http://www.imdb.com/title/tt0117500/\"."
		   });		
		addAnnotation
		  (getOpenGraphMeta_Audio(), 
		   source, 
		   new String[] {
			 "documentation", "og:audio - A URL to an audio file to accompany this object."
		   });		
		addAnnotation
		  (getOpenGraphMeta_Description(), 
		   source, 
		   new String[] {
			 "documentation", "og:description - A one to two sentence description of your object."
		   });		
		addAnnotation
		  (getOpenGraphMeta_Determiner(), 
		   source, 
		   new String[] {
			 "documentation", "og:determiner - The word that appears before this object\'s title in a sentence. An enum of (a, an, the, \"\", auto). If auto is chosen, the consumer of your data should chose between \"a\" or \"an\". Default is \"\" (blank)."
		   });		
		addAnnotation
		  (getOpenGraphMeta_Locale(), 
		   source, 
		   new String[] {
			 "documentation", "og:locale - The locale these tags are marked up in. Of the format language_TERRITORY. Default is en_US."
		   });		
		addAnnotation
		  (getOpenGraphMeta_LocaleAlternates(), 
		   source, 
		   new String[] {
			 "documentation", "og:locale:alternate - An array of other locales this page is available in.\n"
		   });		
		addAnnotation
		  (getOpenGraphMeta_SiteName(), 
		   source, 
		   new String[] {
			 "documentation", "og:site_name - If your object is part of a larger web site, the name which should be displayed for the overall site. e.g., \"IMDb\"."
		   });		
		addAnnotation
		  (getOpenGraphMeta_Video(), 
		   source, 
		   new String[] {
			 "documentation", "og:video - A URL to a video file that complements this object.\n"
		   });		
		addAnnotation
		  (openGraphImageEClass, 
		   source, 
		   new String[] {
			 "documentation", "The og:image property has some optional structured properties:\n\nog:image:url - Identical to og:image.\nog:image:secure_url - An alternate url to use if the webpage requires HTTPS.\nog:image:type - A MIME type for this image.\nog:image:width - The number of pixels wide.\nog:image:height - The number of pixels high.\nA full image example:\n\n<meta property=\"og:image\" content=\"http://example.com/ogp.jpg\" />\n<meta property=\"og:image:secure_url\" content=\"https://secure.example.com/ogp.jpg\" />\n<meta property=\"og:image:type\" content=\"image/jpeg\" />\n<meta property=\"og:image:width\" content=\"400\" />\n<meta property=\"og:image:height\" content=\"300\" />"
		   });		
		addAnnotation
		  (getOpenGraphImage_Url(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:url - Identical to og:image."
		   });		
		addAnnotation
		  (getOpenGraphImage_SecureUrl(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:secure_url - An alternate url to use if the webpage requires HTTPS.\n"
		   });		
		addAnnotation
		  (getOpenGraphImage_Type(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:type - A MIME type for this image.\n"
		   });		
		addAnnotation
		  (getOpenGraphImage_Width(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:width - The number of pixels wide.\n"
		   });		
		addAnnotation
		  (getOpenGraphImage_Height(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:height - The number of pixels high.\n"
		   });		
		addAnnotation
		  (openGraphVideoEClass, 
		   source, 
		   new String[] {
			 "documentation", "The og:video tag has the identical tags as og:image. Here is an example:\n\n<meta property=\"og:video\" content=\"http://example.com/movie.swf\" />\n<meta property=\"og:video:secure_url\" content=\"https://secure.example.com/movie.swf\" />\n<meta property=\"og:video:type\" content=\"application/x-shockwave-flash\" />\n<meta property=\"og:video:width\" content=\"400\" />\n<meta property=\"og:video:height\" content=\"300\" />"
		   });		
		addAnnotation
		  (getOpenGraphVideo_Url(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:url - Identical to og:image."
		   });		
		addAnnotation
		  (getOpenGraphVideo_SecureUrl(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:secure_url - An alternate url to use if the webpage requires HTTPS.\n"
		   });		
		addAnnotation
		  (getOpenGraphVideo_Type(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:type - A MIME type for this image.\n"
		   });		
		addAnnotation
		  (getOpenGraphVideo_Width(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:width - The number of pixels wide.\n"
		   });		
		addAnnotation
		  (getOpenGraphVideo_Height(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:height - The number of pixels high.\n"
		   });		
		addAnnotation
		  (openGraphAudioEClass, 
		   source, 
		   new String[] {
			 "documentation", "The og:audio tag only has the first 3 properties available (since size doesn\'t make sense for sound):\n\n<meta property=\"og:audio\" content=\"http://example.com/sound.mp3\" />\n<meta property=\"og:audio:secure_url\" content=\"https://secure.example.com/sound.mp3\" />\n<meta property=\"og:audio:type\" content=\"audio/mpeg\" />"
		   });		
		addAnnotation
		  (getOpenGraphAudio_Url(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:url - Identical to og:image."
		   });		
		addAnnotation
		  (getOpenGraphAudio_SecureUrl(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:secure_url - An alternate url to use if the webpage requires HTTPS.\n"
		   });		
		addAnnotation
		  (getOpenGraphAudio_Type(), 
		   source, 
		   new String[] {
			 "documentation", "og:image:type - A MIME type for this image.\n"
		   });		
		addAnnotation
		  (pageSelectorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Matches a web request against a rule and modifies the current Page object."
		   });		
		addAnnotation
		  (uriPatternPageSelectorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Matches web requests using http://code.google.com/p/wo-furi/"
		   });		
		addAnnotation
		  (getPageRule_Declaration(), 
		   source, 
		   new String[] {
			 "documentation", "What to apply when the selector matches."
		   });		
		addAnnotation
		  (sourcePageDeclarationEClass, 
		   source, 
		   new String[] {
			 "documentation", "Applies the contents of the specified \"source\" Page to current web request.\n\nThe Page instance must be linked via EMF, which is sometimes handy but not very flexible for runtime purposes."
		   });		
		addAnnotation
		  (processorPageDeclarationEClass, 
		   source, 
		   new String[] {
			 "documentation", "Uses a PageProcessor implementation to modify the Page for current web request.\n\nIt will be looked up in OSGi (scoped for the current tenant) using the given filters."
		   });		
		addAnnotation
		  (getProcessorPageDeclaration_Filter(), 
		   source, 
		   new String[] {
			 "documentation", "Filter in LDAP syntax."
		   });		
		addAnnotation
		  (resourcePageDeclarationEClass, 
		   source, 
		   new String[] {
			 "documentation", "Loads the file from the specified bundle and the specified resource path.\n\nThis is handy to load from classpath in OSGi environments, but cannot handle overrides properly. You need a proper federating repository for that."
		   });		
		addAnnotation
		  (getResourcePageDeclaration_Bundle(), 
		   source, 
		   new String[] {
			 "documentation", "Bundle symbolic name that hosts the Page XMI file."
		   });		
		addAnnotation
		  (getResourcePageDeclaration_Path(), 
		   source, 
		   new String[] {
			 "documentation", "Full path to the Page XMI in the bundle, including the leading \'/\' and the \'.xmi\' extension."
		   });		
		addAnnotation
		  (getRepositoryPageDeclaration_Filter(), 
		   source, 
		   new String[] {
			 "documentation", "Filter to the repository in LDAP syntax. Will be looked up in OSGi."
		   });		
		addAnnotation
		  (getRepositoryPageDeclaration_Path(), 
		   source, 
		   new String[] {
			 "documentation", "Path to the page in the repository."
		   });		
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
		  (pageRuleCollectionEClass, 
		   source, 
		   new String[] {
			 "documentation", "Contains a list of rules."
		   });		
		addAnnotation
		  (pageTitleEClass, 
		   source, 
		   new String[] {
			 "documentation", "Used to compose a title string.\n\nThis will set the :\n- page meta title : prefixes.join(prefixSeparator) + main + suffixes.join(suffixSeparator)\n- open graph meta : title <= main (TODO: needs to be more configurable), e.g. we want to display \"Zalova Bag - Bags\" or \"Zalova Bag - O Batiks\" or even \"Zalova Bag - Bags - O Batiks\""
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
	}

} //SitePackageImpl
