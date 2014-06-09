/**
 */
package org.soluvas.web.site;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
	String eNS_URI = "http://www.soluvas.org/schema/web.site/1.0";

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
	 * The meta object id for the '{@link org.soluvas.web.site.impl.SectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.SectionImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getSection()
	 * @generated
	 */
	int SECTION = 0;

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
	int SECTION_COLLECTION = 2;

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
	int SITE_CATALOG = 1;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_CATALOG__SECTIONS = SECTION_COLLECTION__SECTIONS;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_CATALOG_FEATURE_COUNT = SECTION_COLLECTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.Page <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.Page
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 3;

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
	int GENERIC_PAGE = 4;

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
	int RAW_ENTITY_TABLE_PAGE = 5;

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
	 * The feature id for the '<em><b>Entity Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_TABLE_PAGE__ENTITY_CLASS = PAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Raw Entity Table Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_TABLE_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.EntityTablePageImpl <em>Entity Table Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.EntityTablePageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityTablePage()
	 * @generated
	 */
	int ENTITY_TABLE_PAGE = 6;

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
	 * The feature id for the '<em><b>Entity Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TABLE_PAGE__ENTITY_CLASS = PAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Table Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_TABLE_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.EntityEditPageImpl <em>Entity Edit Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.EntityEditPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityEditPage()
	 * @generated
	 */
	int ENTITY_EDIT_PAGE = 7;

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
	 * The feature id for the '<em><b>Entity Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EDIT_PAGE__ENTITY_CLASS = PAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity Edit Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_EDIT_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.RawEntityEditPageImpl <em>Raw Entity Edit Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.RawEntityEditPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getRawEntityEditPage()
	 * @generated
	 */
	int RAW_ENTITY_EDIT_PAGE = 8;

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
	 * The feature id for the '<em><b>Entity Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_EDIT_PAGE__ENTITY_CLASS = PAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Raw Entity Edit Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_EDIT_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.RawEntityNewPageImpl <em>Raw Entity New Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.RawEntityNewPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getRawEntityNewPage()
	 * @generated
	 */
	int RAW_ENTITY_NEW_PAGE = 9;

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
	 * The feature id for the '<em><b>Entity Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_NEW_PAGE__ENTITY_CLASS = PAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Raw Entity New Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RAW_ENTITY_NEW_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.EntityNewPageImpl <em>Entity New Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.EntityNewPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityNewPage()
	 * @generated
	 */
	int ENTITY_NEW_PAGE = 10;

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
	 * The feature id for the '<em><b>Entity Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_NEW_PAGE__ENTITY_CLASS = PAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Entity New Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_NEW_PAGE_FEATURE_COUNT = PAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.ContentPageImpl <em>Content Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.ContentPageImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getContentPage()
	 * @generated
	 */
	int CONTENT_PAGE = 11;

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
	int DASHBOARD_PAGE = 12;

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
	int PAGE_PARAM = 13;

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
	int LOGIN_PAGE = 14;

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
	int REGISTER_PAGE = 15;

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
	int RESET_PASSWORD_PAGE = 16;

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
	 * The meta object id for the '{@link org.soluvas.web.site.EntityPage <em>Entity Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.EntityPage
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityPage()
	 * @generated
	 */
	int ENTITY_PAGE = 17;

	/**
	 * The feature id for the '<em><b>Entity Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PAGE__ENTITY_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Entity Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_PAGE_FEATURE_COUNT = 1;


	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PermalinkCatalogImpl <em>Permalink Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PermalinkCatalogImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPermalinkCatalog()
	 * @generated
	 */
	int PERMALINK_CATALOG = 18;

	/**
	 * The feature id for the '<em><b>Permalinks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMALINK_CATALOG__PERMALINKS = 0;

	/**
	 * The number of structural features of the '<em>Permalink Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMALINK_CATALOG_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PermalinkImpl <em>Permalink</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PermalinkImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPermalink()
	 * @generated
	 */
	int PERMALINK = 19;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMALINK__NAMESPACE = 0;

	/**
	 * The feature id for the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMALINK__TEMPLATE = 1;

	/**
	 * The number of structural features of the '<em>Permalink</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMALINK_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.PermalinkManagerImpl <em>Permalink Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.PermalinkManagerImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getPermalinkManager()
	 * @generated
	 */
	int PERMALINK_MANAGER = 20;

	/**
	 * The number of structural features of the '<em>Permalink Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERMALINK_MANAGER_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.soluvas.web.site.impl.RequireManagerImpl <em>Require Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.impl.RequireManagerImpl
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getRequireManager()
	 * @generated
	 */
	int REQUIRE_MANAGER = 21;

	/**
	 * The feature id for the '<em><b>Java Script Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_MANAGER__JAVA_SCRIPT_MODE = 0;

	/**
	 * The feature id for the '<em><b>Cache Bust</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_MANAGER__CACHE_BUST = 1;

	/**
	 * The number of structural features of the '<em>Require Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRE_MANAGER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.AlexaSysConfig <em>Alexa Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.AlexaSysConfig
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getAlexaSysConfig()
	 * @generated
	 */
	int ALEXA_SYS_CONFIG = 22;

	/**
	 * The feature id for the '<em><b>Alexa Verify Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALEXA_SYS_CONFIG__ALEXA_VERIFY_ID = 0;

	/**
	 * The feature id for the '<em><b>Alexa Certify Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALEXA_SYS_CONFIG__ALEXA_CERTIFY_ENABLED = 1;

	/**
	 * The feature id for the '<em><b>Alexa Certify Account</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALEXA_SYS_CONFIG__ALEXA_CERTIFY_ACCOUNT = 2;

	/**
	 * The feature id for the '<em><b>Alexa Certify Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALEXA_SYS_CONFIG__ALEXA_CERTIFY_DOMAIN = 3;

	/**
	 * The feature id for the '<em><b>Alexa Certify Js Cdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALEXA_SYS_CONFIG__ALEXA_CERTIFY_JS_CDN = 4;

	/**
	 * The feature id for the '<em><b>Alexa Certify Image Cdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALEXA_SYS_CONFIG__ALEXA_CERTIFY_IMAGE_CDN = 5;

	/**
	 * The number of structural features of the '<em>Alexa Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALEXA_SYS_CONFIG_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.LiveChatSysConfig <em>Live Chat Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.LiveChatSysConfig
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getLiveChatSysConfig()
	 * @generated
	 */
	int LIVE_CHAT_SYS_CONFIG = 23;

	/**
	 * The feature id for the '<em><b>Live Chat Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Live Chat Provider Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_PROVIDER_ID = 1;

	/**
	 * The feature id for the '<em><b>Live Chat Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_PROVIDER = 2;

	/**
	 * The feature id for the '<em><b>Live Chat Site Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_SITE_ID = 3;

	/**
	 * The number of structural features of the '<em>Live Chat Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_CHAT_SYS_CONFIG_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig <em>Google Analytics Sys Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.GoogleAnalyticsSysConfig
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getGoogleAnalyticsSysConfig()
	 * @generated
	 */
	int GOOGLE_ANALYTICS_SYS_CONFIG = 24;

	/**
	 * The feature id for the '<em><b>Google Analytics Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Google Analytics Tracking Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID = 1;

	/**
	 * The feature id for the '<em><b>Google Analytics Cookie Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN = 2;

	/**
	 * The number of structural features of the '<em>Google Analytics Sys Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOOGLE_ANALYTICS_SYS_CONFIG_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.ThemePref <em>Theme Pref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.ThemePref
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getThemePref()
	 * @generated
	 */
	int THEME_PREF = 25;

	/**
	 * The feature id for the '<em><b>Twitter Link Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_PREF__TWITTER_LINK_VISIBLE = 0;

	/**
	 * The feature id for the '<em><b>Facebook Link Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_PREF__FACEBOOK_LINK_VISIBLE = 1;

	/**
	 * The feature id for the '<em><b>You Tube Link Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_PREF__YOU_TUBE_LINK_VISIBLE = 2;

	/**
	 * The feature id for the '<em><b>Footnote Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_PREF__FOOTNOTE_VISIBLE = 3;

	/**
	 * The feature id for the '<em><b>Gallery Link Navbar Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_PREF__GALLERY_LINK_NAVBAR_VISIBLE = 4;

	/**
	 * The number of structural features of the '<em>Theme Pref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_PREF_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.web.site.JavaScriptMode <em>Java Script Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.JavaScriptMode
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getJavaScriptMode()
	 * @generated
	 */
	int JAVA_SCRIPT_MODE = 26;


	/**
	 * The meta object id for the '{@link org.soluvas.web.site.Interaction <em>Interaction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.site.Interaction
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getInteraction()
	 * @generated
	 */
	int INTERACTION = 27;

	/**
	 * The meta object id for the '<em>Live Chat Provider</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.olark.LiveChatProvider
	 * @see org.soluvas.web.site.impl.SitePackageImpl#getLiveChatProvider()
	 * @generated
	 */
	int LIVE_CHAT_PROVIDER = 28;


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
	 * Returns the meta object for class '{@link org.soluvas.web.site.EntityPage <em>Entity Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Page</em>'.
	 * @see org.soluvas.web.site.EntityPage
	 * @generated
	 */
	EClass getEntityPage();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.EntityPage#getEntityClass <em>Entity Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entity Class</em>'.
	 * @see org.soluvas.web.site.EntityPage#getEntityClass()
	 * @see #getEntityPage()
	 * @generated
	 */
	EAttribute getEntityPage_EntityClass();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PermalinkCatalog <em>Permalink Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permalink Catalog</em>'.
	 * @see org.soluvas.web.site.PermalinkCatalog
	 * @generated
	 */
	EClass getPermalinkCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.site.PermalinkCatalog#getPermalinks <em>Permalinks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Permalinks</em>'.
	 * @see org.soluvas.web.site.PermalinkCatalog#getPermalinks()
	 * @see #getPermalinkCatalog()
	 * @generated
	 */
	EReference getPermalinkCatalog_Permalinks();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.Permalink <em>Permalink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permalink</em>'.
	 * @see org.soluvas.web.site.Permalink
	 * @generated
	 */
	EClass getPermalink();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.Permalink#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.soluvas.web.site.Permalink#getNamespace()
	 * @see #getPermalink()
	 * @generated
	 */
	EAttribute getPermalink_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.Permalink#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template</em>'.
	 * @see org.soluvas.web.site.Permalink#getTemplate()
	 * @see #getPermalink()
	 * @generated
	 */
	EAttribute getPermalink_Template();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.PermalinkManager <em>Permalink Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Permalink Manager</em>'.
	 * @see org.soluvas.web.site.PermalinkManager
	 * @generated
	 */
	EClass getPermalinkManager();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.RequireManager <em>Require Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Require Manager</em>'.
	 * @see org.soluvas.web.site.RequireManager
	 * @generated
	 */
	EClass getRequireManager();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.RequireManager#getJavaScriptMode <em>Java Script Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Script Mode</em>'.
	 * @see org.soluvas.web.site.RequireManager#getJavaScriptMode()
	 * @see #getRequireManager()
	 * @generated
	 */
	EAttribute getRequireManager_JavaScriptMode();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.RequireManager#getCacheBust <em>Cache Bust</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cache Bust</em>'.
	 * @see org.soluvas.web.site.RequireManager#getCacheBust()
	 * @see #getRequireManager()
	 * @generated
	 */
	EAttribute getRequireManager_CacheBust();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.AlexaSysConfig <em>Alexa Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alexa Sys Config</em>'.
	 * @see org.soluvas.web.site.AlexaSysConfig
	 * @generated
	 */
	EClass getAlexaSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.AlexaSysConfig#getAlexaVerifyId <em>Alexa Verify Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alexa Verify Id</em>'.
	 * @see org.soluvas.web.site.AlexaSysConfig#getAlexaVerifyId()
	 * @see #getAlexaSysConfig()
	 * @generated
	 */
	EAttribute getAlexaSysConfig_AlexaVerifyId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyEnabled <em>Alexa Certify Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alexa Certify Enabled</em>'.
	 * @see org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyEnabled()
	 * @see #getAlexaSysConfig()
	 * @generated
	 */
	EAttribute getAlexaSysConfig_AlexaCertifyEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyAccount <em>Alexa Certify Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alexa Certify Account</em>'.
	 * @see org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyAccount()
	 * @see #getAlexaSysConfig()
	 * @generated
	 */
	EAttribute getAlexaSysConfig_AlexaCertifyAccount();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyDomain <em>Alexa Certify Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alexa Certify Domain</em>'.
	 * @see org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyDomain()
	 * @see #getAlexaSysConfig()
	 * @generated
	 */
	EAttribute getAlexaSysConfig_AlexaCertifyDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyJsCdn <em>Alexa Certify Js Cdn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alexa Certify Js Cdn</em>'.
	 * @see org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyJsCdn()
	 * @see #getAlexaSysConfig()
	 * @generated
	 */
	EAttribute getAlexaSysConfig_AlexaCertifyJsCdn();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyImageCdn <em>Alexa Certify Image Cdn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alexa Certify Image Cdn</em>'.
	 * @see org.soluvas.web.site.AlexaSysConfig#getAlexaCertifyImageCdn()
	 * @see #getAlexaSysConfig()
	 * @generated
	 */
	EAttribute getAlexaSysConfig_AlexaCertifyImageCdn();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.LiveChatSysConfig <em>Live Chat Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Chat Sys Config</em>'.
	 * @see org.soluvas.web.site.LiveChatSysConfig
	 * @generated
	 */
	EClass getLiveChatSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatEnabled <em>Live Chat Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Live Chat Enabled</em>'.
	 * @see org.soluvas.web.site.LiveChatSysConfig#getLiveChatEnabled()
	 * @see #getLiveChatSysConfig()
	 * @generated
	 */
	EAttribute getLiveChatSysConfig_LiveChatEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatProviderId <em>Live Chat Provider Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Live Chat Provider Id</em>'.
	 * @see org.soluvas.web.site.LiveChatSysConfig#getLiveChatProviderId()
	 * @see #getLiveChatSysConfig()
	 * @generated
	 */
	EAttribute getLiveChatSysConfig_LiveChatProviderId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatProvider <em>Live Chat Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Live Chat Provider</em>'.
	 * @see org.soluvas.web.site.LiveChatSysConfig#getLiveChatProvider()
	 * @see #getLiveChatSysConfig()
	 * @generated
	 */
	EAttribute getLiveChatSysConfig_LiveChatProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.LiveChatSysConfig#getLiveChatSiteId <em>Live Chat Site Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Live Chat Site Id</em>'.
	 * @see org.soluvas.web.site.LiveChatSysConfig#getLiveChatSiteId()
	 * @see #getLiveChatSysConfig()
	 * @generated
	 */
	EAttribute getLiveChatSysConfig_LiveChatSiteId();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig <em>Google Analytics Sys Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Google Analytics Sys Config</em>'.
	 * @see org.soluvas.web.site.GoogleAnalyticsSysConfig
	 * @generated
	 */
	EClass getGoogleAnalyticsSysConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsEnabled <em>Google Analytics Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Google Analytics Enabled</em>'.
	 * @see org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsEnabled()
	 * @see #getGoogleAnalyticsSysConfig()
	 * @generated
	 */
	EAttribute getGoogleAnalyticsSysConfig_GoogleAnalyticsEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsTrackingId <em>Google Analytics Tracking Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Google Analytics Tracking Id</em>'.
	 * @see org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsTrackingId()
	 * @see #getGoogleAnalyticsSysConfig()
	 * @generated
	 */
	EAttribute getGoogleAnalyticsSysConfig_GoogleAnalyticsTrackingId();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsCookieDomain <em>Google Analytics Cookie Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Google Analytics Cookie Domain</em>'.
	 * @see org.soluvas.web.site.GoogleAnalyticsSysConfig#getGoogleAnalyticsCookieDomain()
	 * @see #getGoogleAnalyticsSysConfig()
	 * @generated
	 */
	EAttribute getGoogleAnalyticsSysConfig_GoogleAnalyticsCookieDomain();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.site.ThemePref <em>Theme Pref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Theme Pref</em>'.
	 * @see org.soluvas.web.site.ThemePref
	 * @generated
	 */
	EClass getThemePref();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.ThemePref#isTwitterLinkVisible <em>Twitter Link Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Twitter Link Visible</em>'.
	 * @see org.soluvas.web.site.ThemePref#isTwitterLinkVisible()
	 * @see #getThemePref()
	 * @generated
	 */
	EAttribute getThemePref_TwitterLinkVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.ThemePref#isFacebookLinkVisible <em>Facebook Link Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Facebook Link Visible</em>'.
	 * @see org.soluvas.web.site.ThemePref#isFacebookLinkVisible()
	 * @see #getThemePref()
	 * @generated
	 */
	EAttribute getThemePref_FacebookLinkVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.ThemePref#isYouTubeLinkVisible <em>You Tube Link Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>You Tube Link Visible</em>'.
	 * @see org.soluvas.web.site.ThemePref#isYouTubeLinkVisible()
	 * @see #getThemePref()
	 * @generated
	 */
	EAttribute getThemePref_YouTubeLinkVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.ThemePref#isFootnoteVisible <em>Footnote Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Footnote Visible</em>'.
	 * @see org.soluvas.web.site.ThemePref#isFootnoteVisible()
	 * @see #getThemePref()
	 * @generated
	 */
	EAttribute getThemePref_FootnoteVisible();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.site.ThemePref#isGalleryLinkNavbarVisible <em>Gallery Link Navbar Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gallery Link Navbar Visible</em>'.
	 * @see org.soluvas.web.site.ThemePref#isGalleryLinkNavbarVisible()
	 * @see #getThemePref()
	 * @generated
	 */
	EAttribute getThemePref_GalleryLinkNavbarVisible();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.web.site.JavaScriptMode <em>Java Script Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Java Script Mode</em>'.
	 * @see org.soluvas.web.site.JavaScriptMode
	 * @generated
	 */
	EEnum getJavaScriptMode();

	/**
	 * Returns the meta object for enum '{@link org.soluvas.web.site.Interaction <em>Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interaction</em>'.
	 * @see org.soluvas.web.site.Interaction
	 * @generated
	 */
	EEnum getInteraction();

	/**
	 * Returns the meta object for data type '{@link org.soluvas.web.olark.LiveChatProvider <em>Live Chat Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Live Chat Provider</em>'.
	 * @see org.soluvas.web.olark.LiveChatProvider
	 * @model instanceClass="org.soluvas.web.olark.LiveChatProvider"
	 * @generated
	 */
	EDataType getLiveChatProvider();

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

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.EntityPage <em>Entity Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.EntityPage
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getEntityPage()
		 * @generated
		 */
		EClass ENTITY_PAGE = eINSTANCE.getEntityPage();

		/**
		 * The meta object literal for the '<em><b>Entity Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_PAGE__ENTITY_CLASS = eINSTANCE.getEntityPage_EntityClass();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PermalinkCatalogImpl <em>Permalink Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PermalinkCatalogImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPermalinkCatalog()
		 * @generated
		 */
		EClass PERMALINK_CATALOG = eINSTANCE.getPermalinkCatalog();

		/**
		 * The meta object literal for the '<em><b>Permalinks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERMALINK_CATALOG__PERMALINKS = eINSTANCE.getPermalinkCatalog_Permalinks();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PermalinkImpl <em>Permalink</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PermalinkImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPermalink()
		 * @generated
		 */
		EClass PERMALINK = eINSTANCE.getPermalink();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMALINK__NAMESPACE = eINSTANCE.getPermalink_Namespace();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERMALINK__TEMPLATE = eINSTANCE.getPermalink_Template();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.PermalinkManagerImpl <em>Permalink Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.PermalinkManagerImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getPermalinkManager()
		 * @generated
		 */
		EClass PERMALINK_MANAGER = eINSTANCE.getPermalinkManager();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.impl.RequireManagerImpl <em>Require Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.impl.RequireManagerImpl
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getRequireManager()
		 * @generated
		 */
		EClass REQUIRE_MANAGER = eINSTANCE.getRequireManager();

		/**
		 * The meta object literal for the '<em><b>Java Script Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_MANAGER__JAVA_SCRIPT_MODE = eINSTANCE.getRequireManager_JavaScriptMode();

		/**
		 * The meta object literal for the '<em><b>Cache Bust</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIRE_MANAGER__CACHE_BUST = eINSTANCE.getRequireManager_CacheBust();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.AlexaSysConfig <em>Alexa Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.AlexaSysConfig
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getAlexaSysConfig()
		 * @generated
		 */
		EClass ALEXA_SYS_CONFIG = eINSTANCE.getAlexaSysConfig();

		/**
		 * The meta object literal for the '<em><b>Alexa Verify Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALEXA_SYS_CONFIG__ALEXA_VERIFY_ID = eINSTANCE.getAlexaSysConfig_AlexaVerifyId();

		/**
		 * The meta object literal for the '<em><b>Alexa Certify Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALEXA_SYS_CONFIG__ALEXA_CERTIFY_ENABLED = eINSTANCE.getAlexaSysConfig_AlexaCertifyEnabled();

		/**
		 * The meta object literal for the '<em><b>Alexa Certify Account</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALEXA_SYS_CONFIG__ALEXA_CERTIFY_ACCOUNT = eINSTANCE.getAlexaSysConfig_AlexaCertifyAccount();

		/**
		 * The meta object literal for the '<em><b>Alexa Certify Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALEXA_SYS_CONFIG__ALEXA_CERTIFY_DOMAIN = eINSTANCE.getAlexaSysConfig_AlexaCertifyDomain();

		/**
		 * The meta object literal for the '<em><b>Alexa Certify Js Cdn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALEXA_SYS_CONFIG__ALEXA_CERTIFY_JS_CDN = eINSTANCE.getAlexaSysConfig_AlexaCertifyJsCdn();

		/**
		 * The meta object literal for the '<em><b>Alexa Certify Image Cdn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALEXA_SYS_CONFIG__ALEXA_CERTIFY_IMAGE_CDN = eINSTANCE.getAlexaSysConfig_AlexaCertifyImageCdn();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.LiveChatSysConfig <em>Live Chat Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.LiveChatSysConfig
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getLiveChatSysConfig()
		 * @generated
		 */
		EClass LIVE_CHAT_SYS_CONFIG = eINSTANCE.getLiveChatSysConfig();

		/**
		 * The meta object literal for the '<em><b>Live Chat Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_ENABLED = eINSTANCE.getLiveChatSysConfig_LiveChatEnabled();

		/**
		 * The meta object literal for the '<em><b>Live Chat Provider Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_PROVIDER_ID = eINSTANCE.getLiveChatSysConfig_LiveChatProviderId();

		/**
		 * The meta object literal for the '<em><b>Live Chat Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_PROVIDER = eINSTANCE.getLiveChatSysConfig_LiveChatProvider();

		/**
		 * The meta object literal for the '<em><b>Live Chat Site Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIVE_CHAT_SYS_CONFIG__LIVE_CHAT_SITE_ID = eINSTANCE.getLiveChatSysConfig_LiveChatSiteId();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.GoogleAnalyticsSysConfig <em>Google Analytics Sys Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.GoogleAnalyticsSysConfig
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getGoogleAnalyticsSysConfig()
		 * @generated
		 */
		EClass GOOGLE_ANALYTICS_SYS_CONFIG = eINSTANCE.getGoogleAnalyticsSysConfig();

		/**
		 * The meta object literal for the '<em><b>Google Analytics Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_ENABLED = eINSTANCE.getGoogleAnalyticsSysConfig_GoogleAnalyticsEnabled();

		/**
		 * The meta object literal for the '<em><b>Google Analytics Tracking Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_TRACKING_ID = eINSTANCE.getGoogleAnalyticsSysConfig_GoogleAnalyticsTrackingId();

		/**
		 * The meta object literal for the '<em><b>Google Analytics Cookie Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOOGLE_ANALYTICS_SYS_CONFIG__GOOGLE_ANALYTICS_COOKIE_DOMAIN = eINSTANCE.getGoogleAnalyticsSysConfig_GoogleAnalyticsCookieDomain();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.ThemePref <em>Theme Pref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.ThemePref
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getThemePref()
		 * @generated
		 */
		EClass THEME_PREF = eINSTANCE.getThemePref();

		/**
		 * The meta object literal for the '<em><b>Twitter Link Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THEME_PREF__TWITTER_LINK_VISIBLE = eINSTANCE.getThemePref_TwitterLinkVisible();

		/**
		 * The meta object literal for the '<em><b>Facebook Link Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THEME_PREF__FACEBOOK_LINK_VISIBLE = eINSTANCE.getThemePref_FacebookLinkVisible();

		/**
		 * The meta object literal for the '<em><b>You Tube Link Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THEME_PREF__YOU_TUBE_LINK_VISIBLE = eINSTANCE.getThemePref_YouTubeLinkVisible();

		/**
		 * The meta object literal for the '<em><b>Footnote Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THEME_PREF__FOOTNOTE_VISIBLE = eINSTANCE.getThemePref_FootnoteVisible();

		/**
		 * The meta object literal for the '<em><b>Gallery Link Navbar Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THEME_PREF__GALLERY_LINK_NAVBAR_VISIBLE = eINSTANCE.getThemePref_GalleryLinkNavbarVisible();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.JavaScriptMode <em>Java Script Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.JavaScriptMode
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getJavaScriptMode()
		 * @generated
		 */
		EEnum JAVA_SCRIPT_MODE = eINSTANCE.getJavaScriptMode();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.site.Interaction <em>Interaction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.site.Interaction
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getInteraction()
		 * @generated
		 */
		EEnum INTERACTION = eINSTANCE.getInteraction();

		/**
		 * The meta object literal for the '<em>Live Chat Provider</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.olark.LiveChatProvider
		 * @see org.soluvas.web.site.impl.SitePackageImpl#getLiveChatProvider()
		 * @generated
		 */
		EDataType LIVE_CHAT_PROVIDER = eINSTANCE.getLiveChatProvider();

	}

} //SitePackage
