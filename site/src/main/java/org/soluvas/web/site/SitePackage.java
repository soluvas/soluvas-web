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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.SectionImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 14;

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
	 * The feature id for the '<em><b>Pages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION__PAGES = 2;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.SectionCollectionImpl <em>Section Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.SectionCollectionImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getSectionCollection()
	 * @generated
	 */
	int SECTION_COLLECTION = 16;

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
	int SITE_CATALOG = 15;

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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PageMetaCollectionImpl <em>Page Meta Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PageMetaCollectionImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageMetaCollection()
	 * @generated
	 */
	int PAGE_META_COLLECTION = 17;

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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PageRuleCollectionImpl <em>Page Rule Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PageRuleCollectionImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageRuleCollection()
	 * @generated
	 */
	int PAGE_RULE_COLLECTION = 18;

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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PageTitleImpl <em>Page Title</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PageTitleImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageTitle()
	 * @generated
	 */
	int PAGE_TITLE = 19;

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
	 * The meta object id for the '{@link org.soluvas.web.site.Page <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.Page
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__MOUNT_POINT = 1;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__PARAMS = 2;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__SECTION = 3;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.GenericPageImpl <em>Generic Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.GenericPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getGenericPage()
	 * @generated
	 */
	int GENERIC_PAGE = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Generic Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERIC_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.RawEntityTablePageImpl <em>Raw Entity Table Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.RawEntityTablePageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getRawEntityTablePage()
	 * @generated
	 */
	int RAW_ENTITY_TABLE_PAGE = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_TABLE_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_TABLE_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_TABLE_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_TABLE_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Raw Entity Table Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_TABLE_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.EntityTablePageImpl <em>Entity Table Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.EntityTablePageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityTablePage()
	 * @generated
	 */
	int ENTITY_TABLE_PAGE = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TABLE_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TABLE_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TABLE_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TABLE_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Entity Table Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TABLE_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.EntityEditPageImpl <em>Entity Edit Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.EntityEditPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityEditPage()
	 * @generated
	 */
	int ENTITY_EDIT_PAGE = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EDIT_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EDIT_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EDIT_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EDIT_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Entity Edit Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EDIT_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.RawEntityEditPageImpl <em>Raw Entity Edit Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.RawEntityEditPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getRawEntityEditPage()
	 * @generated
	 */
	int RAW_ENTITY_EDIT_PAGE = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_EDIT_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_EDIT_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_EDIT_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_EDIT_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Raw Entity Edit Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_EDIT_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.RawEntityNewPageImpl <em>Raw Entity New Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.RawEntityNewPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getRawEntityNewPage()
	 * @generated
	 */
	int RAW_ENTITY_NEW_PAGE = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_NEW_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_NEW_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_NEW_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_NEW_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Raw Entity New Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_NEW_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.EntityNewPageImpl <em>Entity New Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.EntityNewPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityNewPage()
	 * @generated
	 */
	int ENTITY_NEW_PAGE = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_NEW_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_NEW_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_NEW_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_NEW_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Entity New Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_NEW_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.ContentPageImpl <em>Content Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.ContentPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getContentPage()
	 * @generated
	 */
	int CONTENT_PAGE = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Content Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENT_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.DashboardPageImpl <em>Dashboard Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.DashboardPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getDashboardPage()
	 * @generated
	 */
	int DASHBOARD_PAGE = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Dashboard Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DASHBOARD_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PageParamImpl <em>Page Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PageParamImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageParam()
	 * @generated
	 */
	int PAGE_PARAM = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_PARAM__NAME = 0;

	/**
	 * The number of structural features of the '<em>Page Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_PARAM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.LoginPageImpl <em>Login Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.LoginPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getLoginPage()
	 * @generated
	 */
	int LOGIN_PAGE = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The feature id for the '<em><b>Register Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PAGE__REGISTER_PAGE = PAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Reset Password Page</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PAGE__RESET_PASSWORD_PAGE = PAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Login Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIN_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.RegisterPageImpl <em>Register Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.RegisterPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getRegisterPage()
	 * @generated
	 */
	int REGISTER_PAGE = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Register Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGISTER_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.ResetPasswordPageImpl <em>Reset Password Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.ResetPasswordPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getResetPasswordPage()
	 * @generated
	 */
	int RESET_PASSWORD_PAGE = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_PASSWORD_PAGE__NAME = PAGE__NAME;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_PASSWORD_PAGE__MOUNT_POINT = PAGE__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_PASSWORD_PAGE__PARAMS = PAGE__PARAMS;

	/**
	 * The feature id for the '<em><b>Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_PASSWORD_PAGE__SECTION = PAGE__SECTION;

	/**
	 * The number of structural features of the '<em>Reset Password Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESET_PASSWORD_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 0;


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
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.Section#getPages <em>Pages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pages</em>'.
	 * @see org.soluvas.web.site.Section#getPages()
	 * @see #getSection()
	 * @generated
	 */
	EReference getSection_Pages();

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
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageTitle <em>Page Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Title</em>'.
	 * @see org.soluvas.web.site.PageTitle
	 * @generated
	 */
	EClass getPageTitle();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageTitle#getMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main</em>'.
	 * @see org.soluvas.web.site.PageTitle#getMain()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_Main();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.web.site.PageTitle#getPrefixes <em>Prefixes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Prefixes</em>'.
	 * @see org.soluvas.web.site.PageTitle#getPrefixes()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_Prefixes();

	/**
	 * Returns the meta object for the attribute list '{@link org.soluvas.web.site.PageTitle#getSuffixes <em>Suffixes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Suffixes</em>'.
	 * @see org.soluvas.web.site.PageTitle#getSuffixes()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_Suffixes();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageTitle#getPrefixSeparator <em>Prefix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix Separator</em>'.
	 * @see org.soluvas.web.site.PageTitle#getPrefixSeparator()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_PrefixSeparator();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageTitle#getSuffixSeparator <em>Suffix Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suffix Separator</em>'.
	 * @see org.soluvas.web.site.PageTitle#getSuffixSeparator()
	 * @see #getPageTitle()
	 * @generated
	 */
	EAttribute getPageTitle_SuffixSeparator();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see org.soluvas.web.site.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.Page#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.web.site.Page#getName()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.Page#getMountPoint <em>Mount Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mount Point</em>'.
	 * @see org.soluvas.web.site.Page#getMountPoint()
	 * @see #getPage()
	 * @generated
	 */
	EAttribute getPage_MountPoint();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.Page#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see org.soluvas.web.site.Page#getParams()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Params();

	/**
	 * Returns the meta object for the container reference '{@link org.soluvas.web.site.Page#getSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Section</em>'.
	 * @see org.soluvas.web.site.Page#getSection()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Section();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.GenericPage <em>Generic Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generic Page</em>'.
	 * @see org.soluvas.web.site.GenericPage
	 * @generated
	 */
	EClass getGenericPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.RawEntityTablePage <em>Raw Entity Table Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raw Entity Table Page</em>'.
	 * @see org.soluvas.web.site.RawEntityTablePage
	 * @generated
	 */
	EClass getRawEntityTablePage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.EntityTablePage <em>Entity Table Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Table Page</em>'.
	 * @see org.soluvas.web.site.EntityTablePage
	 * @generated
	 */
	EClass getEntityTablePage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.EntityEditPage <em>Entity Edit Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Edit Page</em>'.
	 * @see org.soluvas.web.site.EntityEditPage
	 * @generated
	 */
	EClass getEntityEditPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.RawEntityEditPage <em>Raw Entity Edit Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raw Entity Edit Page</em>'.
	 * @see org.soluvas.web.site.RawEntityEditPage
	 * @generated
	 */
	EClass getRawEntityEditPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.RawEntityNewPage <em>Raw Entity New Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Raw Entity New Page</em>'.
	 * @see org.soluvas.web.site.RawEntityNewPage
	 * @generated
	 */
	EClass getRawEntityNewPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.EntityNewPage <em>Entity New Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity New Page</em>'.
	 * @see org.soluvas.web.site.EntityNewPage
	 * @generated
	 */
	EClass getEntityNewPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.ContentPage <em>Content Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Content Page</em>'.
	 * @see org.soluvas.web.site.ContentPage
	 * @generated
	 */
	EClass getContentPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.DashboardPage <em>Dashboard Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dashboard Page</em>'.
	 * @see org.soluvas.web.site.DashboardPage
	 * @generated
	 */
	EClass getDashboardPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PageParam <em>Page Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Param</em>'.
	 * @see org.soluvas.web.site.PageParam
	 * @generated
	 */
	EClass getPageParam();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.PageParam#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.soluvas.web.site.PageParam#getName()
	 * @see #getPageParam()
	 * @generated
	 */
	EAttribute getPageParam_Name();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.LoginPage <em>Login Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Login Page</em>'.
	 * @see org.soluvas.web.site.LoginPage
	 * @generated
	 */
	EClass getLoginPage();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.web.site.LoginPage#getRegisterPage <em>Register Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Register Page</em>'.
	 * @see org.soluvas.web.site.LoginPage#getRegisterPage()
	 * @see #getLoginPage()
	 * @generated
	 */
	EReference getLoginPage_RegisterPage();

	/**
	 * Returns the meta object for the reference '{@link org.soluvas.web.site.LoginPage#getResetPasswordPage <em>Reset Password Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reset Password Page</em>'.
	 * @see org.soluvas.web.site.LoginPage#getResetPasswordPage()
	 * @see #getLoginPage()
	 * @generated
	 */
	EReference getLoginPage_ResetPasswordPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.RegisterPage <em>Register Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Register Page</em>'.
	 * @see org.soluvas.web.site.RegisterPage
	 * @generated
	 */
	EClass getRegisterPage();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.ResetPasswordPage <em>Reset Password Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reset Password Page</em>'.
	 * @see org.soluvas.web.site.ResetPasswordPage
	 * @generated
	 */
	EClass getResetPasswordPage();

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
		 * The meta object literal for the '<em><b>Pages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECTION__PAGES = eINSTANCE.getSection_Pages();

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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.SectionCollectionImpl <em>Section Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.SectionCollectionImpl
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PageMetaCollectionImpl <em>Page Meta Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PageMetaCollectionImpl
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
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PageRuleCollectionImpl <em>Page Rule Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PageRuleCollectionImpl
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

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PageTitleImpl <em>Page Title</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PageTitleImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageTitle()
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
		 * The meta object literal for the '{@link org.soluvas.web.site.Page <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.Page
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__NAME = eINSTANCE.getPage_Name();

		/**
		 * The meta object literal for the '<em><b>Mount Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE__MOUNT_POINT = eINSTANCE.getPage_MountPoint();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__PARAMS = eINSTANCE.getPage_Params();

		/**
		 * The meta object literal for the '<em><b>Section</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__SECTION = eINSTANCE.getPage_Section();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.GenericPageImpl <em>Generic Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.GenericPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getGenericPage()
		 * @generated
		 */
		EClass GENERIC_PAGE = eINSTANCE.getGenericPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.RawEntityTablePageImpl <em>Raw Entity Table Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.RawEntityTablePageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getRawEntityTablePage()
		 * @generated
		 */
		EClass RAW_ENTITY_TABLE_PAGE = eINSTANCE.getRawEntityTablePage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.EntityTablePageImpl <em>Entity Table Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.EntityTablePageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityTablePage()
		 * @generated
		 */
		EClass ENTITY_TABLE_PAGE = eINSTANCE.getEntityTablePage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.EntityEditPageImpl <em>Entity Edit Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.EntityEditPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityEditPage()
		 * @generated
		 */
		EClass ENTITY_EDIT_PAGE = eINSTANCE.getEntityEditPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.RawEntityEditPageImpl <em>Raw Entity Edit Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.RawEntityEditPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getRawEntityEditPage()
		 * @generated
		 */
		EClass RAW_ENTITY_EDIT_PAGE = eINSTANCE.getRawEntityEditPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.RawEntityNewPageImpl <em>Raw Entity New Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.RawEntityNewPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getRawEntityNewPage()
		 * @generated
		 */
		EClass RAW_ENTITY_NEW_PAGE = eINSTANCE.getRawEntityNewPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.EntityNewPageImpl <em>Entity New Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.EntityNewPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityNewPage()
		 * @generated
		 */
		EClass ENTITY_NEW_PAGE = eINSTANCE.getEntityNewPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.ContentPageImpl <em>Content Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.ContentPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getContentPage()
		 * @generated
		 */
		EClass CONTENT_PAGE = eINSTANCE.getContentPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.DashboardPageImpl <em>Dashboard Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.DashboardPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getDashboardPage()
		 * @generated
		 */
		EClass DASHBOARD_PAGE = eINSTANCE.getDashboardPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PageParamImpl <em>Page Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PageParamImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPageParam()
		 * @generated
		 */
		EClass PAGE_PARAM = eINSTANCE.getPageParam();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_PARAM__NAME = eINSTANCE.getPageParam_Name();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.LoginPageImpl <em>Login Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.LoginPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getLoginPage()
		 * @generated
		 */
		EClass LOGIN_PAGE = eINSTANCE.getLoginPage();

		/**
		 * The meta object literal for the '<em><b>Register Page</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGIN_PAGE__REGISTER_PAGE = eINSTANCE.getLoginPage_RegisterPage();

		/**
		 * The meta object literal for the '<em><b>Reset Password Page</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGIN_PAGE__RESET_PASSWORD_PAGE = eINSTANCE.getLoginPage_ResetPasswordPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.RegisterPageImpl <em>Register Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.RegisterPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getRegisterPage()
		 * @generated
		 */
		EClass REGISTER_PAGE = eINSTANCE.getRegisterPage();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.ResetPasswordPageImpl <em>Reset Password Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.ResetPasswordPageImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getResetPasswordPage()
		 * @generated
		 */
		EClass RESET_PASSWORD_PAGE = eINSTANCE.getResetPasswordPage();

	}

} //SitePackage
