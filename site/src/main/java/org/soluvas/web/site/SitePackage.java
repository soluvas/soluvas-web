/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.soluvas.web.site.SiteFactory
 * @model kind="package"
 * @generated
 */
public interface SitePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "site";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.com/schema/site/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "site";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SitePackage eINSTANCE = org.soluvas.web.site.impl.SitePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PageMetaImpl <em>Page Meta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PageMetaImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageMeta()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PageIconImpl <em>Page Icon</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PageIconImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageIcon()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.OpenGraphMetaImpl <em>Open Graph Meta</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.OpenGraphMetaImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getOpenGraphMeta()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.OpenGraphImageImpl <em>Open Graph Image</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.OpenGraphImageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getOpenGraphImage()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.OpenGraphVideoImpl <em>Open Graph Video</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.OpenGraphVideoImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getOpenGraphVideo()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.OpenGraphAudioImpl <em>Open Graph Audio</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.OpenGraphAudioImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getOpenGraphAudio()
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
	 * The meta object id for the '{@link org.soluvas.web.site.PageSelector <em>Page Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.PageSelector
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageSelector()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.UriPatternPageSelectorImpl <em>Uri Pattern Page Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.UriPatternPageSelectorImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getUriPatternPageSelector()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PageRuleImpl <em>Page Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PageRuleImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageRule()
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
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE__WEIGHT = 1;

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
	 * The meta object id for the '{@link org.soluvas.web.site.PageDeclaration <em>Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.PageDeclaration
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageDeclaration()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.SourcePageDeclarationImpl <em>Source Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.SourcePageDeclarationImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getSourcePageDeclaration()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.ProcessorPageDeclarationImpl <em>Processor Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.ProcessorPageDeclarationImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getProcessorPageDeclaration()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.ResourcePageDeclarationImpl <em>Resource Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.ResourcePageDeclarationImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getResourcePageDeclaration()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.RepositoryPageDeclarationImpl <em>Repository Page Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.RepositoryPageDeclarationImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getRepositoryPageDeclaration()
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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PageRuleCatalogImpl <em>Page Rule Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PageRuleCatalogImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageRuleCatalog()
	 * @generated
	 */
	int PAGE_RULE_CATALOG = 14;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE_CATALOG__RULES = 0;

	/**
	 * The number of structural features of the '<em>Page Rule Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE_CATALOG_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.SectionImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__NAME = 1;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.SectionCollection <em>Section Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.SectionCollection
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getSectionCollection()
	 * @generated
	 */
	int SECTION_COLLECTION = 17;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_COLLECTION__SECTIONS = 0;

	/**
	 * The number of structural features of the '<em>Section Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.SiteCatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.SiteCatalogImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getSiteCatalog()
	 * @generated
	 */
	int SITE_CATALOG = 16;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_CATALOG__SECTIONS = SECTION_COLLECTION__SECTIONS;

	/**
	 * The feature id for the '<em><b>Page Metas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_CATALOG__PAGE_METAS = SECTION_COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Page Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_CATALOG__PAGE_RULES = SECTION_COLLECTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_CATALOG_FEATURE_COUNT = SECTION_COLLECTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.PageMetaCollection <em>Page Meta Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.PageMetaCollection
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageMetaCollection()
	 * @generated
	 */
	int PAGE_META_COLLECTION = 18;

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
	 * The meta object id for the '{@link org.soluvas.web.site.PageRuleCollection <em>Page Rule Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.PageRuleCollection
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageRuleCollection()
	 * @generated
	 */
	int PAGE_RULE_COLLECTION = 19;

	/**
	 * The feature id for the '<em><b>Page Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE_COLLECTION__PAGE_RULES = 0;

	/**
	 * The number of structural features of the '<em>Page Rule Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RULE_COLLECTION_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageMeta <em>Page Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Meta</em>'.
	 * @see org.soluvas.web.site.PageMeta
	 * @generated
	 */
	EClass getPageMeta();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.PageMeta#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon</em>'.
	 * @see org.soluvas.web.site.PageMeta#getIcon()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_Icon();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageMeta#getLanguageCode <em>Language Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language Code</em>'.
	 * @see org.soluvas.web.site.PageMeta#getLanguageCode()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_LanguageCode();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.PageMeta#getOpenGraph <em>Open Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Open Graph</em>'.
	 * @see org.soluvas.web.site.PageMeta#getOpenGraph()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_OpenGraph();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.PageMeta#getOpenGraphImage <em>Open Graph Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Open Graph Image</em>'.
	 * @see org.soluvas.web.site.PageMeta#getOpenGraphImage()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_OpenGraphImage();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.PageMeta#getOpenGraphVideo <em>Open Graph Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Open Graph Video</em>'.
	 * @see org.soluvas.web.site.PageMeta#getOpenGraphVideo()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_OpenGraphVideo();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.PageMeta#getOpenGraphAudio <em>Open Graph Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Open Graph Audio</em>'.
	 * @see org.soluvas.web.site.PageMeta#getOpenGraphAudio()
	 * @see #getPageMeta()
	 * @generated
	 */
	EReference getPageMeta_OpenGraphAudio();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageMeta#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.web.site.PageMeta#getDescription()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageMeta#getCharset <em>Charset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Charset</em>'.
	 * @see org.soluvas.web.site.PageMeta#getCharset()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Charset();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageMeta#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.soluvas.web.site.PageMeta#getTitle()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageMeta#getKeywords <em>Keywords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Keywords</em>'.
	 * @see org.soluvas.web.site.PageMeta#getKeywords()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Keywords();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageMeta#getViewport <em>Viewport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Viewport</em>'.
	 * @see org.soluvas.web.site.PageMeta#getViewport()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Viewport();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageMeta#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.soluvas.web.site.PageMeta#getAuthor()
	 * @see #getPageMeta()
	 * @generated
	 */
	EAttribute getPageMeta_Author();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageIcon <em>Page Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Icon</em>'.
	 * @see org.soluvas.web.site.PageIcon
	 * @generated
	 */
	EClass getPageIcon();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageIcon#getFaviconUri <em>Favicon Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Favicon Uri</em>'.
	 * @see org.soluvas.web.site.PageIcon#getFaviconUri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_FaviconUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageIcon#getIcon57Uri <em>Icon57 Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon57 Uri</em>'.
	 * @see org.soluvas.web.site.PageIcon#getIcon57Uri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_Icon57Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageIcon#getIcon72Uri <em>Icon72 Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon72 Uri</em>'.
	 * @see org.soluvas.web.site.PageIcon#getIcon72Uri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_Icon72Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageIcon#getIcon114Uri <em>Icon114 Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon114 Uri</em>'.
	 * @see org.soluvas.web.site.PageIcon#getIcon114Uri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_Icon114Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageIcon#getIcon144Uri <em>Icon144 Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon144 Uri</em>'.
	 * @see org.soluvas.web.site.PageIcon#getIcon144Uri()
	 * @see #getPageIcon()
	 * @generated
	 */
	EAttribute getPageIcon_Icon144Uri();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.OpenGraphMeta <em>Open Graph Meta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Graph Meta</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta
	 * @generated
	 */
	EClass getOpenGraphMeta();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getTitle()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getType()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getImage()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getUrl()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getAudio <em>Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Audio</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getAudio()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Audio();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getDescription()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getDeterminer <em>Determiner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Determiner</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getDeterminer()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Determiner();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getLocale <em>Locale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Locale</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getLocale()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Locale();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.web.site.OpenGraphMeta#getLocaleAlternates <em>Locale Alternates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Locale Alternates</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getLocaleAlternates()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_LocaleAlternates();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getSiteName <em>Site Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Site Name</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getSiteName()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_SiteName();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphMeta#getVideo <em>Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Video</em>'.
	 * @see org.soluvas.web.site.OpenGraphMeta#getVideo()
	 * @see #getOpenGraphMeta()
	 * @generated
	 */
	EAttribute getOpenGraphMeta_Video();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.OpenGraphImage <em>Open Graph Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Graph Image</em>'.
	 * @see org.soluvas.web.site.OpenGraphImage
	 * @generated
	 */
	EClass getOpenGraphImage();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphImage#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.soluvas.web.site.OpenGraphImage#getUrl()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphImage#getSecureUrl <em>Secure Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Url</em>'.
	 * @see org.soluvas.web.site.OpenGraphImage#getSecureUrl()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_SecureUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphImage#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.soluvas.web.site.OpenGraphImage#getType()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphImage#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.soluvas.web.site.OpenGraphImage#getWidth()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphImage#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.soluvas.web.site.OpenGraphImage#getHeight()
	 * @see #getOpenGraphImage()
	 * @generated
	 */
	EAttribute getOpenGraphImage_Height();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.OpenGraphVideo <em>Open Graph Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Graph Video</em>'.
	 * @see org.soluvas.web.site.OpenGraphVideo
	 * @generated
	 */
	EClass getOpenGraphVideo();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphVideo#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.soluvas.web.site.OpenGraphVideo#getUrl()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphVideo#getSecureUrl <em>Secure Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Url</em>'.
	 * @see org.soluvas.web.site.OpenGraphVideo#getSecureUrl()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_SecureUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphVideo#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.soluvas.web.site.OpenGraphVideo#getType()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphVideo#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.soluvas.web.site.OpenGraphVideo#getWidth()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphVideo#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.soluvas.web.site.OpenGraphVideo#getHeight()
	 * @see #getOpenGraphVideo()
	 * @generated
	 */
	EAttribute getOpenGraphVideo_Height();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.OpenGraphAudio <em>Open Graph Audio</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Graph Audio</em>'.
	 * @see org.soluvas.web.site.OpenGraphAudio
	 * @generated
	 */
	EClass getOpenGraphAudio();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphAudio#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.soluvas.web.site.OpenGraphAudio#getUrl()
	 * @see #getOpenGraphAudio()
	 * @generated
	 */
	EAttribute getOpenGraphAudio_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphAudio#getSecureUrl <em>Secure Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Url</em>'.
	 * @see org.soluvas.web.site.OpenGraphAudio#getSecureUrl()
	 * @see #getOpenGraphAudio()
	 * @generated
	 */
	EAttribute getOpenGraphAudio_SecureUrl();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.OpenGraphAudio#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.soluvas.web.site.OpenGraphAudio#getType()
	 * @see #getOpenGraphAudio()
	 * @generated
	 */
	EAttribute getOpenGraphAudio_Type();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageSelector <em>Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Selector</em>'.
	 * @see org.soluvas.web.site.PageSelector
	 * @generated
	 */
	EClass getPageSelector();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.UriPatternPageSelector <em>Uri Pattern Page Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uri Pattern Page Selector</em>'.
	 * @see org.soluvas.web.site.UriPatternPageSelector
	 * @generated
	 */
	EClass getUriPatternPageSelector();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.UriPatternPageSelector#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.soluvas.web.site.UriPatternPageSelector#getPattern()
	 * @see #getUriPatternPageSelector()
	 * @generated
	 */
	EAttribute getUriPatternPageSelector_Pattern();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageRule <em>Page Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Rule</em>'.
	 * @see org.soluvas.web.site.PageRule
	 * @generated
	 */
	EClass getPageRule();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.PageRule#getSelector <em>Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Selector</em>'.
	 * @see org.soluvas.web.site.PageRule#getSelector()
	 * @see #getPageRule()
	 * @generated
	 */
	EReference getPageRule_Selector();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageRule#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see org.soluvas.web.site.PageRule#getWeight()
	 * @see #getPageRule()
	 * @generated
	 */
	EAttribute getPageRule_Weight();

	/**
	 * Returns the meta object for the containment reference '{@link org.soluvas.web.site.PageRule#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declaration</em>'.
	 * @see org.soluvas.web.site.PageRule#getDeclaration()
	 * @see #getPageRule()
	 * @generated
	 */
	EReference getPageRule_Declaration();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageDeclaration <em>Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Declaration</em>'.
	 * @see org.soluvas.web.site.PageDeclaration
	 * @generated
	 */
	EClass getPageDeclaration();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.SourcePageDeclaration <em>Source Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Page Declaration</em>'.
	 * @see org.soluvas.web.site.SourcePageDeclaration
	 * @generated
	 */
	EClass getSourcePageDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.web.site.SourcePageDeclaration#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.soluvas.web.site.SourcePageDeclaration#getSource()
	 * @see #getSourcePageDeclaration()
	 * @generated
	 */
	EReference getSourcePageDeclaration_Source();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.ProcessorPageDeclaration <em>Processor Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processor Page Declaration</em>'.
	 * @see org.soluvas.web.site.ProcessorPageDeclaration
	 * @generated
	 */
	EClass getProcessorPageDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.ProcessorPageDeclaration#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.soluvas.web.site.ProcessorPageDeclaration#getFilter()
	 * @see #getProcessorPageDeclaration()
	 * @generated
	 */
	EAttribute getProcessorPageDeclaration_Filter();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.ResourcePageDeclaration <em>Resource Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Page Declaration</em>'.
	 * @see org.soluvas.web.site.ResourcePageDeclaration
	 * @generated
	 */
	EClass getResourcePageDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.ResourcePageDeclaration#getBundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle</em>'.
	 * @see org.soluvas.web.site.ResourcePageDeclaration#getBundle()
	 * @see #getResourcePageDeclaration()
	 * @generated
	 */
	EAttribute getResourcePageDeclaration_Bundle();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.ResourcePageDeclaration#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.soluvas.web.site.ResourcePageDeclaration#getPath()
	 * @see #getResourcePageDeclaration()
	 * @generated
	 */
	EAttribute getResourcePageDeclaration_Path();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.RepositoryPageDeclaration <em>Repository Page Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository Page Declaration</em>'.
	 * @see org.soluvas.web.site.RepositoryPageDeclaration
	 * @generated
	 */
	EClass getRepositoryPageDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.RepositoryPageDeclaration#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.soluvas.web.site.RepositoryPageDeclaration#getFilter()
	 * @see #getRepositoryPageDeclaration()
	 * @generated
	 */
	EAttribute getRepositoryPageDeclaration_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.RepositoryPageDeclaration#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.soluvas.web.site.RepositoryPageDeclaration#getPath()
	 * @see #getRepositoryPageDeclaration()
	 * @generated
	 */
	EAttribute getRepositoryPageDeclaration_Path();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageRuleCatalog <em>Page Rule Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Rule Catalog</em>'.
	 * @see org.soluvas.web.site.PageRuleCatalog
	 * @generated
	 */
	EClass getPageRuleCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.PageRuleCatalog#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see org.soluvas.web.site.PageRuleCatalog#getRules()
	 * @see #getPageRuleCatalog()
	 * @generated
	 */
	EReference getPageRuleCatalog_Rules();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.Section <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see org.soluvas.web.site.Section
	 * @generated
	 */
	EClass getSection();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.Section#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.soluvas.web.site.Section#getId()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.Section#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.web.site.Section#getName()
	 * @see #getSection()
	 * @generated
	 */
	EAttribute getSection_Name();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.SiteCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.soluvas.web.site.SiteCatalog
	 * @generated
	 */
	EClass getSiteCatalog();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.SectionCollection <em>Section Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section Collection</em>'.
	 * @see org.soluvas.web.site.SectionCollection
	 * @generated
	 */
	EClass getSectionCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.SectionCollection#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sections</em>'.
	 * @see org.soluvas.web.site.SectionCollection#getSections()
	 * @see #getSectionCollection()
	 * @generated
	 */
	EReference getSectionCollection_Sections();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageMetaCollection <em>Page Meta Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Meta Collection</em>'.
	 * @see org.soluvas.web.site.PageMetaCollection
	 * @generated
	 */
	EClass getPageMetaCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.PageMetaCollection#getPageMetas <em>Page Metas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page Metas</em>'.
	 * @see org.soluvas.web.site.PageMetaCollection#getPageMetas()
	 * @see #getPageMetaCollection()
	 * @generated
	 */
	EReference getPageMetaCollection_PageMetas();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageRuleCollection <em>Page Rule Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Rule Collection</em>'.
	 * @see org.soluvas.web.site.PageRuleCollection
	 * @generated
	 */
	EClass getPageRuleCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.PageRuleCollection#getPageRules <em>Page Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page Rules</em>'.
	 * @see org.soluvas.web.site.PageRuleCollection#getPageRules()
	 * @see #getPageRuleCollection()
	 * @generated
	 */
	EReference getPageRuleCollection_PageRules();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SiteFactory getSiteFactory();

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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PageMetaImpl <em>Page Meta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PageMetaImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageMeta()
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
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_META__DESCRIPTION = eINSTANCE.getPageMeta_Description();

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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PageIconImpl <em>Page Icon</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PageIconImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageIcon()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.OpenGraphMetaImpl <em>Open Graph Meta</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.OpenGraphMetaImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getOpenGraphMeta()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.OpenGraphImageImpl <em>Open Graph Image</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.OpenGraphImageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getOpenGraphImage()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.OpenGraphVideoImpl <em>Open Graph Video</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.OpenGraphVideoImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getOpenGraphVideo()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.OpenGraphAudioImpl <em>Open Graph Audio</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.OpenGraphAudioImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getOpenGraphAudio()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.PageSelector <em>Page Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.PageSelector
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageSelector()
		 * @generated
		 */
		EClass PAGE_SELECTOR = eINSTANCE.getPageSelector();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.UriPatternPageSelectorImpl <em>Uri Pattern Page Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.UriPatternPageSelectorImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getUriPatternPageSelector()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PageRuleImpl <em>Page Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PageRuleImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageRule()
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
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_RULE__WEIGHT = eINSTANCE.getPageRule_Weight();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RULE__DECLARATION = eINSTANCE.getPageRule_Declaration();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.PageDeclaration <em>Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.PageDeclaration
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageDeclaration()
		 * @generated
		 */
		EClass PAGE_DECLARATION = eINSTANCE.getPageDeclaration();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.SourcePageDeclarationImpl <em>Source Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.SourcePageDeclarationImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getSourcePageDeclaration()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.ProcessorPageDeclarationImpl <em>Processor Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.ProcessorPageDeclarationImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getProcessorPageDeclaration()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.ResourcePageDeclarationImpl <em>Resource Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.ResourcePageDeclarationImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getResourcePageDeclaration()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.RepositoryPageDeclarationImpl <em>Repository Page Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.RepositoryPageDeclarationImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getRepositoryPageDeclaration()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PageRuleCatalogImpl <em>Page Rule Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PageRuleCatalogImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageRuleCatalog()
		 * @generated
		 */
		EClass PAGE_RULE_CATALOG = eINSTANCE.getPageRuleCatalog();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RULE_CATALOG__RULES = eINSTANCE.getPageRuleCatalog_Rules();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.SectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.SectionImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getSection()
		 * @generated
		 */
		EClass SECTION = eINSTANCE.getSection();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECTION__ID = eINSTANCE.getSection_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECTION__NAME = eINSTANCE.getSection_Name();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.SiteCatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.SiteCatalogImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getSiteCatalog()
		 * @generated
		 */
		EClass SITE_CATALOG = eINSTANCE.getSiteCatalog();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.SectionCollection <em>Section Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.SectionCollection
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getSectionCollection()
		 * @generated
		 */
		EClass SECTION_COLLECTION = eINSTANCE.getSectionCollection();

		/**
		 * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION_COLLECTION__SECTIONS = eINSTANCE.getSectionCollection_Sections();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.PageMetaCollection <em>Page Meta Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.PageMetaCollection
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageMetaCollection()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.PageRuleCollection <em>Page Rule Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.PageRuleCollection
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageRuleCollection()
		 * @generated
		 */
		EClass PAGE_RULE_COLLECTION = eINSTANCE.getPageRuleCollection();

		/**
		 * The meta object literal for the '<em><b>Page Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RULE_COLLECTION__PAGE_RULES = eINSTANCE.getPageRuleCollection_PageRules();

	}

} //SitePackage
