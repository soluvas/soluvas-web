/**
 */
package org.soluvas.web.site.pagemeta.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.soluvas.web.site.pagemeta.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PageMetaFactoryImpl extends EFactoryImpl implements PageMetaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PageMetaFactory init() {
		try {
			PageMetaFactory thePageMetaFactory = (PageMetaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/web.site.pagemeta/1.0"); 
			if (thePageMetaFactory != null) {
				return thePageMetaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PageMetaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMetaFactoryImpl() {
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
			case PageMetaPackage.PAGE_META: return createPageMeta();
			case PageMetaPackage.PAGE_ICON: return createPageIcon();
			case PageMetaPackage.OPEN_GRAPH_META: return createOpenGraphMeta();
			case PageMetaPackage.OPEN_GRAPH_IMAGE: return createOpenGraphImage();
			case PageMetaPackage.OPEN_GRAPH_VIDEO: return createOpenGraphVideo();
			case PageMetaPackage.OPEN_GRAPH_AUDIO: return createOpenGraphAudio();
			case PageMetaPackage.URI_PATTERN_PAGE_SELECTOR: return createUriPatternPageSelector();
			case PageMetaPackage.PAGE_RULE: return createPageRule();
			case PageMetaPackage.SOURCE_PAGE_DECLARATION: return createSourcePageDeclaration();
			case PageMetaPackage.PROCESSOR_PAGE_DECLARATION: return createProcessorPageDeclaration();
			case PageMetaPackage.RESOURCE_PAGE_DECLARATION: return createResourcePageDeclaration();
			case PageMetaPackage.REPOSITORY_PAGE_DECLARATION: return createRepositoryPageDeclaration();
			case PageMetaPackage.PAGE_META_CATALOG: return createPageMetaCatalog();
			case PageMetaPackage.PAGE_META_COLLECTION: return createPageMetaCollection();
			case PageMetaPackage.PAGE_RULE_COLLECTION: return createPageRuleCollection();
			case PageMetaPackage.PAGE_TITLE: return createPageTitle();
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
	public PageMetaCatalog createPageMetaCatalog() {
		PageMetaCatalogImpl pageMetaCatalog = new PageMetaCatalogImpl();
		return pageMetaCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageMetaCollection createPageMetaCollection() {
		PageMetaCollectionImpl pageMetaCollection = new PageMetaCollectionImpl();
		return pageMetaCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageRuleCollection createPageRuleCollection() {
		PageRuleCollectionImpl pageRuleCollection = new PageRuleCollectionImpl();
		return pageRuleCollection;
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
	public PageMetaPackage getPageMetaPackage() {
		return (PageMetaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PageMetaPackage getPackage() {
		return PageMetaPackage.eINSTANCE;
	}

} //PageMetaFactoryImpl
