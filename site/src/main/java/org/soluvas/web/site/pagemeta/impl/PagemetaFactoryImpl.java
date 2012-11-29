/**
 */
package org.soluvas.web.site.pagemeta.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.soluvas.web.site.PageRuleContext;
import org.soluvas.web.site.pagemeta.*;
import org.soluvas.web.site.pagemeta.OpenGraphAudio;
import org.soluvas.web.site.pagemeta.OpenGraphImage;
import org.soluvas.web.site.pagemeta.OpenGraphMeta;
import org.soluvas.web.site.pagemeta.OpenGraphVideo;
import org.soluvas.web.site.pagemeta.PageIcon;
import org.soluvas.web.site.pagemeta.PageMeta;
import org.soluvas.web.site.pagemeta.PageMetaCatalog;
import org.soluvas.web.site.pagemeta.PageMetaCollection;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageRuleCollection;
import org.soluvas.web.site.pagemeta.PageTitle;
import org.soluvas.web.site.pagemeta.PagemetaFactory;
import org.soluvas.web.site.pagemeta.PagemetaPackage;
import org.soluvas.web.site.pagemeta.ProcessorPageDeclaration;
import org.soluvas.web.site.pagemeta.RepositoryPageDeclaration;
import org.soluvas.web.site.pagemeta.ResourcePageDeclaration;
import org.soluvas.web.site.pagemeta.SourcePageDeclaration;
import org.soluvas.web.site.pagemeta.UriPatternPageSelector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PagemetaFactoryImpl extends EFactoryImpl implements PagemetaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PagemetaFactory init() {
		try {
			PagemetaFactory thePagemetaFactory = (PagemetaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.soluvas.org/schema/web.site.pagemeta/1.0"); 
			if (thePagemetaFactory != null) {
				return thePagemetaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PagemetaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PagemetaFactoryImpl() {
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
			case PagemetaPackage.PAGE_META: return (EObject)createPageMeta();
			case PagemetaPackage.PAGE_ICON: return (EObject)createPageIcon();
			case PagemetaPackage.OPEN_GRAPH_META: return (EObject)createOpenGraphMeta();
			case PagemetaPackage.OPEN_GRAPH_IMAGE: return (EObject)createOpenGraphImage();
			case PagemetaPackage.OPEN_GRAPH_VIDEO: return (EObject)createOpenGraphVideo();
			case PagemetaPackage.OPEN_GRAPH_AUDIO: return (EObject)createOpenGraphAudio();
			case PagemetaPackage.URI_PATTERN_PAGE_SELECTOR: return (EObject)createUriPatternPageSelector();
			case PagemetaPackage.PAGE_RULE: return (EObject)createPageRule();
			case PagemetaPackage.SOURCE_PAGE_DECLARATION: return (EObject)createSourcePageDeclaration();
			case PagemetaPackage.PROCESSOR_PAGE_DECLARATION: return (EObject)createProcessorPageDeclaration();
			case PagemetaPackage.RESOURCE_PAGE_DECLARATION: return (EObject)createResourcePageDeclaration();
			case PagemetaPackage.REPOSITORY_PAGE_DECLARATION: return (EObject)createRepositoryPageDeclaration();
			case PagemetaPackage.PAGE_META_CATALOG: return (EObject)createPageMetaCatalog();
			case PagemetaPackage.PAGE_META_COLLECTION: return (EObject)createPageMetaCollection();
			case PagemetaPackage.PAGE_RULE_COLLECTION: return (EObject)createPageRuleCollection();
			case PagemetaPackage.PAGE_TITLE: return (EObject)createPageTitle();
			case PagemetaPackage.CLASS_PAGE_SELECTOR: return (EObject)createClassPageSelector();
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
			case PagemetaPackage.PAGE_RULE_CONTEXT:
				return createPageRuleContextFromString(eDataType, initialValue);
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
			case PagemetaPackage.PAGE_RULE_CONTEXT:
				return convertPageRuleContextToString(eDataType, instanceValue);
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
	public PageMeta createPageMeta() {
		PageMetaImpl pageMeta = new PageMetaImpl();
		return pageMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageIcon createPageIcon() {
		PageIconImpl pageIcon = new PageIconImpl();
		return pageIcon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpenGraphMeta createOpenGraphMeta() {
		OpenGraphMetaImpl openGraphMeta = new OpenGraphMetaImpl();
		return openGraphMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpenGraphImage createOpenGraphImage() {
		OpenGraphImageImpl openGraphImage = new OpenGraphImageImpl();
		return openGraphImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpenGraphVideo createOpenGraphVideo() {
		OpenGraphVideoImpl openGraphVideo = new OpenGraphVideoImpl();
		return openGraphVideo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpenGraphAudio createOpenGraphAudio() {
		OpenGraphAudioImpl openGraphAudio = new OpenGraphAudioImpl();
		return openGraphAudio;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UriPatternPageSelector createUriPatternPageSelector() {
		UriPatternPageSelectorImpl uriPatternPageSelector = new UriPatternPageSelectorImpl();
		return uriPatternPageSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageRule createPageRule() {
		PageRuleImpl pageRule = new PageRuleImpl();
		return pageRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourcePageDeclaration createSourcePageDeclaration() {
		SourcePageDeclarationImpl sourcePageDeclaration = new SourcePageDeclarationImpl();
		return sourcePageDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessorPageDeclaration createProcessorPageDeclaration() {
		ProcessorPageDeclarationImpl processorPageDeclaration = new ProcessorPageDeclarationImpl();
		return processorPageDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourcePageDeclaration createResourcePageDeclaration() {
		ResourcePageDeclarationImpl resourcePageDeclaration = new ResourcePageDeclarationImpl();
		return resourcePageDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RepositoryPageDeclaration createRepositoryPageDeclaration() {
		RepositoryPageDeclarationImpl repositoryPageDeclaration = new RepositoryPageDeclarationImpl();
		return repositoryPageDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageMetaCatalog createPageMetaCatalog() {
		PageMetaCatalogImpl pageMetaCatalog = new PageMetaCatalogImpl();
		return pageMetaCatalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageMetaCollection createPageMetaCollection() {
		PageMetaCollectionImpl pageMetaCollection = new PageMetaCollectionImpl();
		return pageMetaCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageRuleCollection createPageRuleCollection() {
		PageRuleCollectionImpl pageRuleCollection = new PageRuleCollectionImpl();
		return pageRuleCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PageTitle createPageTitle() {
		PageTitleImpl pageTitle = new PageTitleImpl();
		return pageTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPageSelector createClassPageSelector() {
		ClassPageSelectorImpl classPageSelector = new ClassPageSelectorImpl();
		return classPageSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageRuleContext createPageRuleContextFromString(EDataType eDataType, String initialValue) {
		return (PageRuleContext)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPageRuleContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PagemetaPackage getPagemetaPackage() {
		return (PagemetaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PagemetaPackage getPackage() {
		return PagemetaPackage.eINSTANCE;
	}

} //PagemetaFactoryImpl
