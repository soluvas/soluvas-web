/**
 */
package org.soluvas.web.site.pagemeta;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.soluvas.web.site.pagemeta.PagemetaFactory
 * @model kind="package"
 * @generated
 */
public interface PagemetaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "pagemeta";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.org/schema/web.site.pagemeta/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pagemeta";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PagemetaPackage eINSTANCE = org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl <em>Page Meta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.PageMetaImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageMeta()
	 * @generated
	 */
	int PAGE_META = 0;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__ICON = 0;

	/**
	 * The feature id for the '<em><b>Language Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__LANGUAGE_CODE = 1;

	/**
	 * The feature id for the '<em><b>Open Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__OPEN_GRAPH = 2;

	/**
	 * The feature id for the '<em><b>Open Graph Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__OPEN_GRAPH_IMAGE = 3;

	/**
	 * The feature id for the '<em><b>Open Graph Video</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__OPEN_GRAPH_VIDEO = 4;

	/**
	 * The feature id for the '<em><b>Open Graph Audio</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__OPEN_GRAPH_AUDIO = 5;

	/**
	 * The feature id for the '<em><b>Charset</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__CHARSET = 6;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__TITLE = 7;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__KEYWORDS = 8;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__DESCRIPTION = 9;

	/**
	 * The feature id for the '<em><b>Viewport</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__VIEWPORT = 10;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META__AUTHOR = 11;

	/**
	 * The number of structural features of the '<em>Page Meta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META_FEATURE_COUNT = 12;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl <em>Page Icon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.PageIconImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageIcon()
	 * @generated
	 */
	int PAGE_ICON = 1;

	/**
	 * The feature id for the '<em><b>Favicon Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_ICON__FAVICON_URI = 0;

	/**
	 * The feature id for the '<em><b>Icon57 Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_ICON__ICON57_URI = 1;

	/**
	 * The feature id for the '<em><b>Icon72 Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_ICON__ICON72_URI = 2;

	/**
	 * The feature id for the '<em><b>Icon114 Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_ICON__ICON114_URI = 3;

	/**
	 * The feature id for the '<em><b>Icon144 Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_ICON__ICON144_URI = 4;

	/**
	 * The number of structural features of the '<em>Page Icon</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_ICON_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.OpenGraphMetaImpl <em>Open Graph Meta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.OpenGraphMetaImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getOpenGraphMeta()
	 * @generated
	 */
	int OPEN_GRAPH_META = 2;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__IMAGE = 2;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__URL = 3;

	/**
	 * The feature id for the '<em><b>Audio</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__AUDIO = 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Determiner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__DETERMINER = 6;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__LOCALE = 7;

	/**
	 * The feature id for the '<em><b>Locale Alternates</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__LOCALE_ALTERNATES = 8;

	/**
	 * The feature id for the '<em><b>Site Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__SITE_NAME = 9;

	/**
	 * The feature id for the '<em><b>Video</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META__VIDEO = 10;

	/**
	 * The number of structural features of the '<em>Open Graph Meta</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_META_FEATURE_COUNT = 11;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.OpenGraphImageImpl <em>Open Graph Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.OpenGraphImageImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getOpenGraphImage()
	 * @generated
	 */
	int OPEN_GRAPH_IMAGE = 3;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_IMAGE__URL = 0;

	/**
	 * The feature id for the '<em><b>Secure Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_IMAGE__SECURE_URL = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_IMAGE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_IMAGE__WIDTH = 3;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_IMAGE__HEIGHT = 4;

	/**
	 * The number of structural features of the '<em>Open Graph Image</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_IMAGE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.OpenGraphVideoImpl <em>Open Graph Video</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.OpenGraphVideoImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getOpenGraphVideo()
	 * @generated
	 */
	int OPEN_GRAPH_VIDEO = 4;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_VIDEO__URL = 0;

	/**
	 * The feature id for the '<em><b>Secure Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_VIDEO__SECURE_URL = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_VIDEO__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_VIDEO__WIDTH = 3;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_VIDEO__HEIGHT = 4;

	/**
	 * The number of structural features of the '<em>Open Graph Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_VIDEO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.OpenGraphAudioImpl <em>Open Graph Audio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.OpenGraphAudioImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getOpenGraphAudio()
	 * @generated
	 */
	int OPEN_GRAPH_AUDIO = 5;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_AUDIO__URL = 0;

	/**
	 * The feature id for the '<em><b>Secure Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_AUDIO__SECURE_URL = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_AUDIO__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Open Graph Audio</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_GRAPH_AUDIO_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.PageSelector <em>Page Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.PageSelector
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageSelector()
	 * @generated
	 */
	int PAGE_SELECTOR = 6;

	/**
	 * The number of structural features of the '<em>Page Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_SELECTOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.UriPatternPageSelectorImpl <em>Uri Pattern Page Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.UriPatternPageSelectorImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getUriPatternPageSelector()
	 * @generated
	 */
	int URI_PATTERN_PAGE_SELECTOR = 7;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PATTERN_PAGE_SELECTOR__PATTERN = PAGE_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Uri Pattern Page Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_PATTERN_PAGE_SELECTOR_FEATURE_COUNT = PAGE_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.PageRuleImpl <em>Page Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.PageRuleImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageRule()
	 * @generated
	 */
	int PAGE_RULE = 8;

	/**
	 * The feature id for the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE__SELECTOR = 0;

	/**
	 * The feature id for the '<em><b>Positioner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE__POSITIONER = 1;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE__DECLARATION = 2;

	/**
	 * The number of structural features of the '<em>Page Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.PageDeclaration <em>Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.PageDeclaration
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageDeclaration()
	 * @generated
	 */
	int PAGE_DECLARATION = 9;

	/**
	 * The number of structural features of the '<em>Page Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_DECLARATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.SourcePageDeclarationImpl <em>Source Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.SourcePageDeclarationImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getSourcePageDeclaration()
	 * @generated
	 */
	int SOURCE_PAGE_DECLARATION = 10;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_PAGE_DECLARATION__SOURCE = PAGE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source Page Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_PAGE_DECLARATION_FEATURE_COUNT = PAGE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.ProcessorPageDeclarationImpl <em>Processor Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.ProcessorPageDeclarationImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getProcessorPageDeclaration()
	 * @generated
	 */
	int PROCESSOR_PAGE_DECLARATION = 11;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_PAGE_DECLARATION__FILTER = PAGE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processor Page Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSOR_PAGE_DECLARATION_FEATURE_COUNT = PAGE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.ResourcePageDeclarationImpl <em>Resource Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.ResourcePageDeclarationImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getResourcePageDeclaration()
	 * @generated
	 */
	int RESOURCE_PAGE_DECLARATION = 12;

	/**
	 * The feature id for the '<em><b>Bundle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PAGE_DECLARATION__BUNDLE = PAGE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PAGE_DECLARATION__PATH = PAGE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Page Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PAGE_DECLARATION_FEATURE_COUNT = PAGE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.RepositoryPageDeclarationImpl <em>Repository Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.RepositoryPageDeclarationImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getRepositoryPageDeclaration()
	 * @generated
	 */
	int REPOSITORY_PAGE_DECLARATION = 13;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PAGE_DECLARATION__FILTER = PAGE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PAGE_DECLARATION__PATH = PAGE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Repository Page Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_PAGE_DECLARATION_FEATURE_COUNT = PAGE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.PageMetaCollectionImpl <em>Page Meta Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.PageMetaCollectionImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageMetaCollection()
	 * @generated
	 */
	int PAGE_META_COLLECTION = 15;

	/**
	 * The feature id for the '<em><b>Page Metas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META_COLLECTION__PAGE_METAS = 0;

	/**
	 * The number of structural features of the '<em>Page Meta Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl <em>Page Meta Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageMetaCatalog()
	 * @generated
	 */
	int PAGE_META_CATALOG = 14;

	/**
	 * The feature id for the '<em><b>Page Metas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META_CATALOG__PAGE_METAS = PAGE_META_COLLECTION__PAGE_METAS;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META_CATALOG__RULES = PAGE_META_COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Page Meta Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_META_CATALOG_FEATURE_COUNT = PAGE_META_COLLECTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.PageRuleCollectionImpl <em>Page Rule Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.PageRuleCollectionImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageRuleCollection()
	 * @generated
	 */
	int PAGE_RULE_COLLECTION = 16;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE_COLLECTION__RULES = 0;

	/**
	 * The number of structural features of the '<em>Page Rule Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.PageTitleImpl <em>Page Title</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.PageTitleImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageTitle()
	 * @generated
	 */
	int PAGE_TITLE = 17;

	/**
	 * The feature id for the '<em><b>Main</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TITLE__MAIN = 0;

	/**
	 * The feature id for the '<em><b>Prefixes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TITLE__PREFIXES = 1;

	/**
	 * The feature id for the '<em><b>Suffixes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TITLE__SUFFIXES = 2;

	/**
	 * The feature id for the '<em><b>Prefix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TITLE__PREFIX_SEPARATOR = 3;

	/**
	 * The feature id for the '<em><b>Suffix Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TITLE__SUFFIX_SEPARATOR = 4;

	/**
	 * The number of structural features of the '<em>Page Title</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_TITLE_FEATURE_COUNT = 5;


	/**
	 * The meta object id for the '{@link org.soluvas.web.site.pagemeta.impl.ClassPageSelectorImpl <em>Class Page Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.pagemeta.impl.ClassPageSelectorImpl
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getClassPageSelector()
	 * @generated
	 */
	int CLASS_PAGE_SELECTOR = 18;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PAGE_SELECTOR__CLASS_NAME = PAGE_SELECTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Page Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_PAGE_SELECTOR_FEATURE_COUNT = PAGE_SELECTOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Page Rule Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.PageRuleContext
	 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageRuleContext()
	 * @generated
	 */
	int PAGE_RULE_CONTEXT = 19;


	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageMeta <em>Page Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Meta</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta
	 * @generated
	 */
	EClass getPageMeta();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.pagemeta.PageMeta#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getIcon()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageMeta#getLanguageCode <em>Language Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language Code</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getLanguageCode()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_LanguageCode();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraph <em>Open Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Open Graph</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getOpenGraph()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_OpenGraph();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphImage <em>Open Graph Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Open Graph Image</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphImage()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_OpenGraphImage();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphVideo <em>Open Graph Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Open Graph Video</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphVideo()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_OpenGraphVideo();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphAudio <em>Open Graph Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Open Graph Audio</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getOpenGraphAudio()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_OpenGraphAudio();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageMeta#getCharset <em>Charset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Charset</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getCharset()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Charset();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageMeta#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getTitle()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageMeta#getKeywords <em>Keywords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keywords</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getKeywords()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Keywords();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageMeta#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getDescription()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageMeta#getViewport <em>Viewport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Viewport</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getViewport()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Viewport();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageMeta#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMeta#getAuthor()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Author();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageIcon <em>Page Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Icon</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageIcon
	 * @generated
	 */
	EClass getPageIcon();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageIcon#getFaviconUri <em>Favicon Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Favicon Uri</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageIcon#getFaviconUri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_FaviconUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon57Uri <em>Icon57 Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon57 Uri</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageIcon#getIcon57Uri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_Icon57Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon72Uri <em>Icon72 Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon72 Uri</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageIcon#getIcon72Uri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_Icon72Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon114Uri <em>Icon114 Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon114 Uri</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageIcon#getIcon114Uri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_Icon114Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageIcon#getIcon144Uri <em>Icon144 Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon144 Uri</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageIcon#getIcon144Uri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_Icon144Uri();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta <em>Open Graph Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Graph Meta</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta
	 * @generated
	 */
	EClass getOpenGraphMeta();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getTitle()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getType()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getImage()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getUrl()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getAudio <em>Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Audio</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getAudio()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Audio();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getDescription()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getDeterminer <em>Determiner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Determiner</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getDeterminer()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Determiner();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getLocale <em>Locale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Locale</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getLocale()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Locale();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getLocaleAlternates <em>Locale Alternates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Locale Alternates</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getLocaleAlternates()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_LocaleAlternates();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getSiteName <em>Site Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Site Name</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getSiteName()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_SiteName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphMeta#getVideo <em>Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Video</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphMeta#getVideo()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Video();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.OpenGraphImage <em>Open Graph Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Graph Image</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphImage
	 * @generated
	 */
	EClass getOpenGraphImage();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphImage#getUrl()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getSecureUrl <em>Secure Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Url</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphImage#getSecureUrl()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_SecureUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphImage#getType()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphImage#getWidth()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphImage#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphImage#getHeight()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_Height();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo <em>Open Graph Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Graph Video</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphVideo
	 * @generated
	 */
	EClass getOpenGraphVideo();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphVideo#getUrl()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getSecureUrl <em>Secure Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Url</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphVideo#getSecureUrl()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_SecureUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphVideo#getType()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphVideo#getWidth()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphVideo#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphVideo#getHeight()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_Height();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.OpenGraphAudio <em>Open Graph Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Graph Audio</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphAudio
	 * @generated
	 */
	EClass getOpenGraphAudio();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphAudio#getUrl()
	 * @see #getOpenGraphAudio()
	 * @generated
	 */
	EAttribute getOpenGraphAudio_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getSecureUrl <em>Secure Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Url</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphAudio#getSecureUrl()
	 * @see #getOpenGraphAudio()
	 * @generated
	 */
	EAttribute getOpenGraphAudio_SecureUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.OpenGraphAudio#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.soluvas.web.site.pagemeta.OpenGraphAudio#getType()
	 * @see #getOpenGraphAudio()
	 * @generated
	 */
	EAttribute getOpenGraphAudio_Type();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageSelector <em>Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Selector</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageSelector
	 * @generated
	 */
	EClass getPageSelector();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.UriPatternPageSelector <em>Uri Pattern Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uri Pattern Page Selector</em>'.
	 * @see org.soluvas.web.site.pagemeta.UriPatternPageSelector
	 * @generated
	 */
	EClass getUriPatternPageSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.UriPatternPageSelector#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.soluvas.web.site.pagemeta.UriPatternPageSelector#getPattern()
	 * @see #getUriPatternPageSelector()
	 * @generated
	 */
	EAttribute getUriPatternPageSelector_Pattern();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageRule <em>Page Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Rule</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageRule
	 * @generated
	 */
	EClass getPageRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.pagemeta.PageRule#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Selector</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageRule#getSelector()
	 * @see #getPageRule()
	 * @generated
	 */
	EReference getPageRule_Selector();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageRule#getPositioner <em>Positioner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Positioner</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageRule#getPositioner()
	 * @see #getPageRule()
	 * @generated
	 */
	EAttribute getPageRule_Positioner();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.pagemeta.PageRule#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declaration</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageRule#getDeclaration()
	 * @see #getPageRule()
	 * @generated
	 */
	EReference getPageRule_Declaration();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageDeclaration <em>Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Declaration</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageDeclaration
	 * @generated
	 */
	EClass getPageDeclaration();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.SourcePageDeclaration <em>Source Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Page Declaration</em>'.
	 * @see org.soluvas.web.site.pagemeta.SourcePageDeclaration
	 * @generated
	 */
	EClass getSourcePageDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.web.site.pagemeta.SourcePageDeclaration#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.soluvas.web.site.pagemeta.SourcePageDeclaration#getSource()
	 * @see #getSourcePageDeclaration()
	 * @generated
	 */
	EReference getSourcePageDeclaration_Source();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.ProcessorPageDeclaration <em>Processor Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processor Page Declaration</em>'.
	 * @see org.soluvas.web.site.pagemeta.ProcessorPageDeclaration
	 * @generated
	 */
	EClass getProcessorPageDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.ProcessorPageDeclaration#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.soluvas.web.site.pagemeta.ProcessorPageDeclaration#getFilter()
	 * @see #getProcessorPageDeclaration()
	 * @generated
	 */
	EAttribute getProcessorPageDeclaration_Filter();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.ResourcePageDeclaration <em>Resource Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Page Declaration</em>'.
	 * @see org.soluvas.web.site.pagemeta.ResourcePageDeclaration
	 * @generated
	 */
	EClass getResourcePageDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.ResourcePageDeclaration#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle</em>'.
	 * @see org.soluvas.web.site.pagemeta.ResourcePageDeclaration#getBundle()
	 * @see #getResourcePageDeclaration()
	 * @generated
	 */
	EAttribute getResourcePageDeclaration_Bundle();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.ResourcePageDeclaration#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.soluvas.web.site.pagemeta.ResourcePageDeclaration#getPath()
	 * @see #getResourcePageDeclaration()
	 * @generated
	 */
	EAttribute getResourcePageDeclaration_Path();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.RepositoryPageDeclaration <em>Repository Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository Page Declaration</em>'.
	 * @see org.soluvas.web.site.pagemeta.RepositoryPageDeclaration
	 * @generated
	 */
	EClass getRepositoryPageDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.RepositoryPageDeclaration#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.soluvas.web.site.pagemeta.RepositoryPageDeclaration#getFilter()
	 * @see #getRepositoryPageDeclaration()
	 * @generated
	 */
	EAttribute getRepositoryPageDeclaration_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.RepositoryPageDeclaration#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.soluvas.web.site.pagemeta.RepositoryPageDeclaration#getPath()
	 * @see #getRepositoryPageDeclaration()
	 * @generated
	 */
	EAttribute getRepositoryPageDeclaration_Path();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageMetaCatalog <em>Page Meta Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Meta Catalog</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMetaCatalog
	 * @generated
	 */
	EClass getPageMetaCatalog();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageMetaCollection <em>Page Meta Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Meta Collection</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMetaCollection
	 * @generated
	 */
	EClass getPageMetaCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.pagemeta.PageMetaCollection#getPageMetas <em>Page Metas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page Metas</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageMetaCollection#getPageMetas()
	 * @see #getPageMetaCollection()
	 * @generated
	 */
	EReference getPageMetaCollection_PageMetas();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageRuleCollection <em>Page Rule Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Rule Collection</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageRuleCollection
	 * @generated
	 */
	EClass getPageRuleCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.pagemeta.PageRuleCollection#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageRuleCollection#getRules()
	 * @see #getPageRuleCollection()
	 * @generated
	 */
	EReference getPageRuleCollection_Rules();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.PageTitle <em>Page Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Title</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageTitle
	 * @generated
	 */
	EClass getPageTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageTitle#getMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageTitle#getMain()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_Main();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.web.site.pagemeta.PageTitle#getPrefixes <em>Prefixes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Prefixes</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageTitle#getPrefixes()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_Prefixes();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.web.site.pagemeta.PageTitle#getSuffixes <em>Suffixes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Suffixes</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageTitle#getSuffixes()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_Suffixes();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageTitle#getPrefixSeparator <em>Prefix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix Separator</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageTitle#getPrefixSeparator()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_PrefixSeparator();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.PageTitle#getSuffixSeparator <em>Suffix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix Separator</em>'.
	 * @see org.soluvas.web.site.pagemeta.PageTitle#getSuffixSeparator()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_SuffixSeparator();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.pagemeta.ClassPageSelector <em>Class Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Page Selector</em>'.
	 * @see org.soluvas.web.site.pagemeta.ClassPageSelector
	 * @generated
	 */
	EClass getClassPageSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.pagemeta.ClassPageSelector#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.soluvas.web.site.pagemeta.ClassPageSelector#getClassName()
	 * @see #getClassPageSelector()
	 * @generated
	 */
	EAttribute getClassPageSelector_ClassName();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.web.site.PageRuleContext <em>Page Rule Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Page Rule Context</em>'.
	 * @see org.soluvas.web.site.PageRuleContext
	 * @model instanceClass="org.soluvas.web.site.PageRuleContext"
	 * @generated
	 */
	EDataType getPageRuleContext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PagemetaFactory getPagemetaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.PageMetaImpl <em>Page Meta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.PageMetaImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageMeta()
		 * @generated
		 */
		EClass PAGE_META = eINSTANCE.getPageMeta();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_META__ICON = eINSTANCE.getPageMeta_Icon();

		/**
		 * The meta object literal for the '<em><b>Language Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_META__LANGUAGE_CODE = eINSTANCE.getPageMeta_LanguageCode();

		/**
		 * The meta object literal for the '<em><b>Open Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_META__OPEN_GRAPH = eINSTANCE.getPageMeta_OpenGraph();

		/**
		 * The meta object literal for the '<em><b>Open Graph Image</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_META__OPEN_GRAPH_IMAGE = eINSTANCE.getPageMeta_OpenGraphImage();

		/**
		 * The meta object literal for the '<em><b>Open Graph Video</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_META__OPEN_GRAPH_VIDEO = eINSTANCE.getPageMeta_OpenGraphVideo();

		/**
		 * The meta object literal for the '<em><b>Open Graph Audio</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_META__OPEN_GRAPH_AUDIO = eINSTANCE.getPageMeta_OpenGraphAudio();

		/**
		 * The meta object literal for the '<em><b>Charset</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_META__CHARSET = eINSTANCE.getPageMeta_Charset();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_META__TITLE = eINSTANCE.getPageMeta_Title();

		/**
		 * The meta object literal for the '<em><b>Keywords</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_META__KEYWORDS = eINSTANCE.getPageMeta_Keywords();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_META__DESCRIPTION = eINSTANCE.getPageMeta_Description();

		/**
		 * The meta object literal for the '<em><b>Viewport</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_META__VIEWPORT = eINSTANCE.getPageMeta_Viewport();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_META__AUTHOR = eINSTANCE.getPageMeta_Author();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.PageIconImpl <em>Page Icon</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.PageIconImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageIcon()
		 * @generated
		 */
		EClass PAGE_ICON = eINSTANCE.getPageIcon();

		/**
		 * The meta object literal for the '<em><b>Favicon Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_ICON__FAVICON_URI = eINSTANCE.getPageIcon_FaviconUri();

		/**
		 * The meta object literal for the '<em><b>Icon57 Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_ICON__ICON57_URI = eINSTANCE.getPageIcon_Icon57Uri();

		/**
		 * The meta object literal for the '<em><b>Icon72 Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_ICON__ICON72_URI = eINSTANCE.getPageIcon_Icon72Uri();

		/**
		 * The meta object literal for the '<em><b>Icon114 Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_ICON__ICON114_URI = eINSTANCE.getPageIcon_Icon114Uri();

		/**
		 * The meta object literal for the '<em><b>Icon144 Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_ICON__ICON144_URI = eINSTANCE.getPageIcon_Icon144Uri();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.OpenGraphMetaImpl <em>Open Graph Meta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.OpenGraphMetaImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getOpenGraphMeta()
		 * @generated
		 */
		EClass OPEN_GRAPH_META = eINSTANCE.getOpenGraphMeta();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__TITLE = eINSTANCE.getOpenGraphMeta_Title();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__TYPE = eINSTANCE.getOpenGraphMeta_Type();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__IMAGE = eINSTANCE.getOpenGraphMeta_Image();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__URL = eINSTANCE.getOpenGraphMeta_Url();

		/**
		 * The meta object literal for the '<em><b>Audio</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__AUDIO = eINSTANCE.getOpenGraphMeta_Audio();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__DESCRIPTION = eINSTANCE.getOpenGraphMeta_Description();

		/**
		 * The meta object literal for the '<em><b>Determiner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__DETERMINER = eINSTANCE.getOpenGraphMeta_Determiner();

		/**
		 * The meta object literal for the '<em><b>Locale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__LOCALE = eINSTANCE.getOpenGraphMeta_Locale();

		/**
		 * The meta object literal for the '<em><b>Locale Alternates</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__LOCALE_ALTERNATES = eINSTANCE.getOpenGraphMeta_LocaleAlternates();

		/**
		 * The meta object literal for the '<em><b>Site Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__SITE_NAME = eINSTANCE.getOpenGraphMeta_SiteName();

		/**
		 * The meta object literal for the '<em><b>Video</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_META__VIDEO = eINSTANCE.getOpenGraphMeta_Video();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.OpenGraphImageImpl <em>Open Graph Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.OpenGraphImageImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getOpenGraphImage()
		 * @generated
		 */
		EClass OPEN_GRAPH_IMAGE = eINSTANCE.getOpenGraphImage();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_IMAGE__URL = eINSTANCE.getOpenGraphImage_Url();

		/**
		 * The meta object literal for the '<em><b>Secure Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_IMAGE__SECURE_URL = eINSTANCE.getOpenGraphImage_SecureUrl();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_IMAGE__TYPE = eINSTANCE.getOpenGraphImage_Type();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_IMAGE__WIDTH = eINSTANCE.getOpenGraphImage_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_IMAGE__HEIGHT = eINSTANCE.getOpenGraphImage_Height();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.OpenGraphVideoImpl <em>Open Graph Video</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.OpenGraphVideoImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getOpenGraphVideo()
		 * @generated
		 */
		EClass OPEN_GRAPH_VIDEO = eINSTANCE.getOpenGraphVideo();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_VIDEO__URL = eINSTANCE.getOpenGraphVideo_Url();

		/**
		 * The meta object literal for the '<em><b>Secure Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_VIDEO__SECURE_URL = eINSTANCE.getOpenGraphVideo_SecureUrl();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_VIDEO__TYPE = eINSTANCE.getOpenGraphVideo_Type();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_VIDEO__WIDTH = eINSTANCE.getOpenGraphVideo_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_VIDEO__HEIGHT = eINSTANCE.getOpenGraphVideo_Height();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.OpenGraphAudioImpl <em>Open Graph Audio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.OpenGraphAudioImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getOpenGraphAudio()
		 * @generated
		 */
		EClass OPEN_GRAPH_AUDIO = eINSTANCE.getOpenGraphAudio();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_AUDIO__URL = eINSTANCE.getOpenGraphAudio_Url();

		/**
		 * The meta object literal for the '<em><b>Secure Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_AUDIO__SECURE_URL = eINSTANCE.getOpenGraphAudio_SecureUrl();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_GRAPH_AUDIO__TYPE = eINSTANCE.getOpenGraphAudio_Type();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.PageSelector <em>Page Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.PageSelector
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageSelector()
		 * @generated
		 */
		EClass PAGE_SELECTOR = eINSTANCE.getPageSelector();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.UriPatternPageSelectorImpl <em>Uri Pattern Page Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.UriPatternPageSelectorImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getUriPatternPageSelector()
		 * @generated
		 */
		EClass URI_PATTERN_PAGE_SELECTOR = eINSTANCE.getUriPatternPageSelector();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_PATTERN_PAGE_SELECTOR__PATTERN = eINSTANCE.getUriPatternPageSelector_Pattern();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.PageRuleImpl <em>Page Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.PageRuleImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageRule()
		 * @generated
		 */
		EClass PAGE_RULE = eINSTANCE.getPageRule();

		/**
		 * The meta object literal for the '<em><b>Selector</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RULE__SELECTOR = eINSTANCE.getPageRule_Selector();

		/**
		 * The meta object literal for the '<em><b>Positioner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_RULE__POSITIONER = eINSTANCE.getPageRule_Positioner();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RULE__DECLARATION = eINSTANCE.getPageRule_Declaration();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.PageDeclaration <em>Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.PageDeclaration
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageDeclaration()
		 * @generated
		 */
		EClass PAGE_DECLARATION = eINSTANCE.getPageDeclaration();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.SourcePageDeclarationImpl <em>Source Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.SourcePageDeclarationImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getSourcePageDeclaration()
		 * @generated
		 */
		EClass SOURCE_PAGE_DECLARATION = eINSTANCE.getSourcePageDeclaration();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_PAGE_DECLARATION__SOURCE = eINSTANCE.getSourcePageDeclaration_Source();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.ProcessorPageDeclarationImpl <em>Processor Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.ProcessorPageDeclarationImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getProcessorPageDeclaration()
		 * @generated
		 */
		EClass PROCESSOR_PAGE_DECLARATION = eINSTANCE.getProcessorPageDeclaration();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSOR_PAGE_DECLARATION__FILTER = eINSTANCE.getProcessorPageDeclaration_Filter();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.ResourcePageDeclarationImpl <em>Resource Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.ResourcePageDeclarationImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getResourcePageDeclaration()
		 * @generated
		 */
		EClass RESOURCE_PAGE_DECLARATION = eINSTANCE.getResourcePageDeclaration();

		/**
		 * The meta object literal for the '<em><b>Bundle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PAGE_DECLARATION__BUNDLE = eINSTANCE.getResourcePageDeclaration_Bundle();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PAGE_DECLARATION__PATH = eINSTANCE.getResourcePageDeclaration_Path();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.RepositoryPageDeclarationImpl <em>Repository Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.RepositoryPageDeclarationImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getRepositoryPageDeclaration()
		 * @generated
		 */
		EClass REPOSITORY_PAGE_DECLARATION = eINSTANCE.getRepositoryPageDeclaration();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY_PAGE_DECLARATION__FILTER = eINSTANCE.getRepositoryPageDeclaration_Filter();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY_PAGE_DECLARATION__PATH = eINSTANCE.getRepositoryPageDeclaration_Path();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl <em>Page Meta Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.PageMetaCatalogImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageMetaCatalog()
		 * @generated
		 */
		EClass PAGE_META_CATALOG = eINSTANCE.getPageMetaCatalog();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.PageMetaCollectionImpl <em>Page Meta Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.PageMetaCollectionImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageMetaCollection()
		 * @generated
		 */
		EClass PAGE_META_COLLECTION = eINSTANCE.getPageMetaCollection();

		/**
		 * The meta object literal for the '<em><b>Page Metas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_META_COLLECTION__PAGE_METAS = eINSTANCE.getPageMetaCollection_PageMetas();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.PageRuleCollectionImpl <em>Page Rule Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.PageRuleCollectionImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageRuleCollection()
		 * @generated
		 */
		EClass PAGE_RULE_COLLECTION = eINSTANCE.getPageRuleCollection();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RULE_COLLECTION__RULES = eINSTANCE.getPageRuleCollection_Rules();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.PageTitleImpl <em>Page Title</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.PageTitleImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageTitle()
		 * @generated
		 */
		EClass PAGE_TITLE = eINSTANCE.getPageTitle();

		/**
		 * The meta object literal for the '<em><b>Main</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_TITLE__MAIN = eINSTANCE.getPageTitle_Main();

		/**
		 * The meta object literal for the '<em><b>Prefixes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_TITLE__PREFIXES = eINSTANCE.getPageTitle_Prefixes();

		/**
		 * The meta object literal for the '<em><b>Suffixes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_TITLE__SUFFIXES = eINSTANCE.getPageTitle_Suffixes();

		/**
		 * The meta object literal for the '<em><b>Prefix Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_TITLE__PREFIX_SEPARATOR = eINSTANCE.getPageTitle_PrefixSeparator();

		/**
		 * The meta object literal for the '<em><b>Suffix Separator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_TITLE__SUFFIX_SEPARATOR = eINSTANCE.getPageTitle_SuffixSeparator();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.pagemeta.impl.ClassPageSelectorImpl <em>Class Page Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.pagemeta.impl.ClassPageSelectorImpl
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getClassPageSelector()
		 * @generated
		 */
		EClass CLASS_PAGE_SELECTOR = eINSTANCE.getClassPageSelector();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_PAGE_SELECTOR__CLASS_NAME = eINSTANCE.getClassPageSelector_ClassName();

		/**
		 * The meta object literal for the '<em>Page Rule Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.PageRuleContext
		 * @see org.soluvas.web.site.pagemeta.impl.PagemetaPackageImpl#getPageRuleContext()
		 * @generated
		 */
		EDataType PAGE_RULE_CONTEXT = eINSTANCE.getPageRuleContext();

	}

} //PagemetaPackage
