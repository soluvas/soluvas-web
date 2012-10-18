/**
 */
package org.soluvas.web.banner;

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
 * @see org.soluvas.web.banner.BannerFactory
 * @model kind="package"
 * @generated
 */
public interface BannerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "banner";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.soluvas.com/schema/web/banner/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "banner";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BannerPackage eINSTANCE = org.soluvas.web.banner.impl.BannerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.soluvas.web.banner.impl.BannerImpl <em>Banner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.banner.impl.BannerImpl
	 * @see org.soluvas.web.banner.impl.BannerPackageImpl#getBanner()
	 * @generated
	 */
	int BANNER = 0;

	/**
	 * The feature id for the '<em><b>Image Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER__IMAGE_URI = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Link Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER__LINK_URI = 2;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER__WIDTH = 3;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER__HEIGHT = 4;

	/**
	 * The number of structural features of the '<em>Banner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.soluvas.web.banner.BannerCollection <em>Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.banner.BannerCollection
	 * @see org.soluvas.web.banner.impl.BannerPackageImpl#getBannerCollection()
	 * @generated
	 */
	int BANNER_COLLECTION = 2;

	/**
	 * The feature id for the '<em><b>Banners</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER_COLLECTION__BANNERS = 0;

	/**
	 * The number of structural features of the '<em>Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER_COLLECTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.soluvas.web.banner.impl.BannerCatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.soluvas.web.banner.impl.BannerCatalogImpl
	 * @see org.soluvas.web.banner.impl.BannerPackageImpl#getBannerCatalog()
	 * @generated
	 */
	int BANNER_CATALOG = 1;

	/**
	 * The feature id for the '<em><b>Banners</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER_CATALOG__BANNERS = BANNER_COLLECTION__BANNERS;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BANNER_CATALOG_FEATURE_COUNT = BANNER_COLLECTION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.soluvas.web.banner.Banner <em>Banner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Banner</em>'.
	 * @see org.soluvas.web.banner.Banner
	 * @generated
	 */
	EClass getBanner();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.banner.Banner#getImageUri <em>Image Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image Uri</em>'.
	 * @see org.soluvas.web.banner.Banner#getImageUri()
	 * @see #getBanner()
	 * @generated
	 */
	EAttribute getBanner_ImageUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.banner.Banner#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.soluvas.web.banner.Banner#getTitle()
	 * @see #getBanner()
	 * @generated
	 */
	EAttribute getBanner_Title();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.banner.Banner#getLinkUri <em>Link Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Uri</em>'.
	 * @see org.soluvas.web.banner.Banner#getLinkUri()
	 * @see #getBanner()
	 * @generated
	 */
	EAttribute getBanner_LinkUri();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.banner.Banner#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.soluvas.web.banner.Banner#getWidth()
	 * @see #getBanner()
	 * @generated
	 */
	EAttribute getBanner_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.soluvas.web.banner.Banner#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.soluvas.web.banner.Banner#getHeight()
	 * @see #getBanner()
	 * @generated
	 */
	EAttribute getBanner_Height();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.banner.BannerCatalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.soluvas.web.banner.BannerCatalog
	 * @generated
	 */
	EClass getBannerCatalog();

	/**
	 * Returns the meta object for class '{@link org.soluvas.web.banner.BannerCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection</em>'.
	 * @see org.soluvas.web.banner.BannerCollection
	 * @generated
	 */
	EClass getBannerCollection();

	/**
	 * Returns the meta object for the containment reference list '{@link org.soluvas.web.banner.BannerCollection#getBanners <em>Banners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Banners</em>'.
	 * @see org.soluvas.web.banner.BannerCollection#getBanners()
	 * @see #getBannerCollection()
	 * @generated
	 */
	EReference getBannerCollection_Banners();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BannerFactory getBannerFactory();

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
		 * The meta object literal for the '{@link org.soluvas.web.banner.impl.BannerImpl <em>Banner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.banner.impl.BannerImpl
		 * @see org.soluvas.web.banner.impl.BannerPackageImpl#getBanner()
		 * @generated
		 */
		EClass BANNER = eINSTANCE.getBanner();

		/**
		 * The meta object literal for the '<em><b>Image Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BANNER__IMAGE_URI = eINSTANCE.getBanner_ImageUri();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BANNER__TITLE = eINSTANCE.getBanner_Title();

		/**
		 * The meta object literal for the '<em><b>Link Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BANNER__LINK_URI = eINSTANCE.getBanner_LinkUri();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BANNER__WIDTH = eINSTANCE.getBanner_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BANNER__HEIGHT = eINSTANCE.getBanner_Height();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.banner.impl.BannerCatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.banner.impl.BannerCatalogImpl
		 * @see org.soluvas.web.banner.impl.BannerPackageImpl#getBannerCatalog()
		 * @generated
		 */
		EClass BANNER_CATALOG = eINSTANCE.getBannerCatalog();

		/**
		 * The meta object literal for the '{@link org.soluvas.web.banner.BannerCollection <em>Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.soluvas.web.banner.BannerCollection
		 * @see org.soluvas.web.banner.impl.BannerPackageImpl#getBannerCollection()
		 * @generated
		 */
		EClass BANNER_COLLECTION = eINSTANCE.getBannerCollection();

		/**
		 * The meta object literal for the '<em><b>Banners</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BANNER_COLLECTION__BANNERS = eINSTANCE.getBannerCollection_Banners();

	}

} //BannerPackage
