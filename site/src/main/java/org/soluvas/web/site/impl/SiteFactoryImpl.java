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
			SiteFactory theSiteFactory = (SiteFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.com/schema/site/1.0"); 
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
			case SitePackage.PAGE_META: return createPageMeta();
			case SitePackage.PAGE_ICON: return createPageIcon();
			case SitePackage.OPEN_GRAPH_META: return createOpenGraphMeta();
			case SitePackage.OPEN_GRAPH_IMAGE: return createOpenGraphImage();
			case SitePackage.OPEN_GRAPH_VIDEO: return createOpenGraphVideo();
			case SitePackage.OPEN_GRAPH_AUDIO: return createOpenGraphAudio();
			case SitePackage.URI_PATTERN_PAGE_SELECTOR: return createUriPatternPageSelector();
			case SitePackage.PAGE_RULE: return createPageRule();
			case SitePackage.SOURCE_PAGE_DECLARATION: return createSourcePageDeclaration();
			case SitePackage.PROCESSOR_PAGE_DECLARATION: return createProcessorPageDeclaration();
			case SitePackage.RESOURCE_PAGE_DECLARATION: return createResourcePageDeclaration();
			case SitePackage.REPOSITORY_PAGE_DECLARATION: return createRepositoryPageDeclaration();
			case SitePackage.PAGE_RULE_CATALOG: return createPageRuleCatalog();
			case SitePackage.SECTION: return createSection();
			case SitePackage.SITE_CATALOG: return createSiteCatalog();
			case SitePackage.PAGE_TITLE: return createPageTitle();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMeta createPageMeta() {
		PageMetaImpl pageMeta = new PageMetaImpl();
		return pageMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageIcon createPageIcon() {
		PageIconImpl pageIcon = new PageIconImpl();
		return pageIcon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphMeta createOpenGraphMeta() {
		OpenGraphMetaImpl openGraphMeta = new OpenGraphMetaImpl();
		return openGraphMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphImage createOpenGraphImage() {
		OpenGraphImageImpl openGraphImage = new OpenGraphImageImpl();
		return openGraphImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphVideo createOpenGraphVideo() {
		OpenGraphVideoImpl openGraphVideo = new OpenGraphVideoImpl();
		return openGraphVideo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenGraphAudio createOpenGraphAudio() {
		OpenGraphAudioImpl openGraphAudio = new OpenGraphAudioImpl();
		return openGraphAudio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UriPatternPageSelector createUriPatternPageSelector() {
		UriPatternPageSelectorImpl uriPatternPageSelector = new UriPatternPageSelectorImpl();
		return uriPatternPageSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageRule createPageRule() {
		PageRuleImpl pageRule = new PageRuleImpl();
		return pageRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcePageDeclaration createSourcePageDeclaration() {
		SourcePageDeclarationImpl sourcePageDeclaration = new SourcePageDeclarationImpl();
		return sourcePageDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessorPageDeclaration createProcessorPageDeclaration() {
		ProcessorPageDeclarationImpl processorPageDeclaration = new ProcessorPageDeclarationImpl();
		return processorPageDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourcePageDeclaration createResourcePageDeclaration() {
		ResourcePageDeclarationImpl resourcePageDeclaration = new ResourcePageDeclarationImpl();
		return resourcePageDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryPageDeclaration createRepositoryPageDeclaration() {
		RepositoryPageDeclarationImpl repositoryPageDeclaration = new RepositoryPageDeclarationImpl();
		return repositoryPageDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageRuleCatalog createPageRuleCatalog() {
		PageRuleCatalogImpl pageRuleCatalog = new PageRuleCatalogImpl();
		return pageRuleCatalog;
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
	public PageTitle createPageTitle() {
		PageTitleImpl pageTitle = new PageTitleImpl();
		return pageTitle;
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
